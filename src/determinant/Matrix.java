package determinant;

//a matrix class for use in linear algebra
//including methods for things like the determinant
//by Cole Hudson
public class Matrix 
{
	//2x2 matrix and variables for each dimension 
	private int[][] matrix;
	private int yDimension = 0;
	private int xDimension = 0;
	
	//initializer(s)
	public Matrix(int[][] matrix)
	{
		this.matrix = matrix;
		setyDimension(matrix.length);
		setxDimension(matrix[0].length);
	}
	
	public Matrix(int yDimension, int xDimension)
	{
		this.yDimension = yDimension;
		this.xDimension = xDimension;
		matrix = new int[yDimension][xDimension];
	}
	
	public Matrix()
	{
		//null initializer
	}
	
	//getters
	public int getyDimension()
	{
		return yDimension;
	}
	
	public int getxDimension()
	{
		return xDimension;
	}
	
	public int[][] getMatrix() 
	{
		return matrix;
	}
	
	public int getMatrixEntry(int y, int x)
	{
		return matrix[y][x];
	}
	
	//setters for variables
	private void setyDimension(int yDimension) 
	{
		this.yDimension = yDimension;
	}
	
	private void setxDimension(int xDimension) 
	{
		this.xDimension = xDimension;
	}

	public void setMatrix(int[][] matrix) 
	{
		this.matrix = matrix;
		setyDimension(matrix.length);//set the y dimension to that of the new matrix
		setxDimension(matrix[0].length);//set the x dimension to that of the new matrix
	}
	
	public void setMatrixEntry(int y, int x, int val)
	{
		matrix[y][x] = val;
	}
	
	//print the matrix
	public void printMatrix(Matrix m)
	{
		for(int y = 0; y < m.getyDimension(); y++)
		{
			for(int x = 0; x < m.getxDimension(); x++)
			{
				System.out.print(m.getMatrixEntry(y, x) + " ");
			}
			System.out.println();
		}
	}
	
	//**************
	//LINEAR ALGEBRA
	//**************
	
	//determinant - recursion :)
	public int twoByTwoDeterminant(Matrix m)
	{
		if(m.getyDimension() == 2 && m.getxDimension() == 2)
		{
			int a = m.getMatrixEntry(0, 0);
			int b = m.getMatrixEntry(0, 1);
			int c = m.getMatrixEntry(1, 0);
			int d = m.getMatrixEntry(1, 1);
			
			int determinant = (a*d) - (c*b);
			return determinant;
		}
		else
		{
			System.out.println("A NON 2x2 MATRIX WAS ENTERED INTO THE twoByTwoDeterminant() FUNCTION");
			return 666;
		}
	}
	
	public int determinant(Matrix m)
	{
		if(m.getyDimension() == 2 && m.getxDimension() == 2)//2x2, just do the 2x2 function
		{
			return twoByTwoDeterminant(m);
		}
		else if(m.getyDimension() == 0 || m.getxDimension() == 0)//it's a null matrix
		{
			System.out.println("A NULL MATRIX WAS ENTERED INTO the determinant() FUNCTION");
			return 666;
		}
		else if(m.getyDimension() > 0 && m.getxDimension() > 0)//this one works, time to take the determinant
		{
			int determinant = 0;
			int sign = 1; //determines to add or subtract the next determinant. 1=add 0=subtract
			for(int multiplierX = 0; multiplierX < m.getxDimension(); multiplierX++)//loop over the top row to get the multipliers
			{
				int multiplier = m.getMatrixEntry(0, multiplierX);
				//now generate a new matrix from the remaining rows
				Matrix newMat = new Matrix(m.getyDimension() - 1, m.getxDimension() - 1); //new matrix, -1 in each dimension
				
				int newMatY = 0;
				int newMatX = 0;
				//fill the matrix with the correct values
				for(int y = 1; y < m.getyDimension(); y++)
				{
					for(int x = 0; x< m.getxDimension(); x++)
					{
						if(x != multiplierX)//check to make sure the column is different from the multiplier column
						{
							int value = m.getMatrixEntry(y, x);
							newMat.setMatrixEntry(newMatY, newMatX, value);
							newMatX++;
						}
					}
					newMatY++;
				}
				
				int newMatDeterminant = determinant(newMat);
				
				if(sign == 1)
				{
					determinant += (multiplier * newMatDeterminant);
					sign = 0;
				}
				else if(sign == 0)
				{
					determinant -= (multiplier * newMatDeterminant);
					sign = 1;
				}
			}
			
			return determinant;
		}
		else
		{
			System.out.println("Matrix didn't get classified in the determinant function");
			return 666;
		}
	}
}
