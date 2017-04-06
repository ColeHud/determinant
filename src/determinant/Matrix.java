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
	
	public Matrix()
	{
		//null initializer
	}
	
	//setters for variables
	private void setyDimension(int yDimension) {
		this.yDimension = yDimension;
	}
	
	private void setxDimension(int xDimension) {
		this.xDimension = xDimension;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
		setyDimension(matrix.length);//set the y dimension to that of the new matrix
		setxDimension(matrix[0].length);//set the x dimension to that of the new matrix
	}
	
	public void setMatrixEntry(int y, int x, int val)
	{
		matrix[y][x] = val;
	}
	//end of setters
	
	//**************
	//LINEAR ALGEBRA
	//**************
	
	//determinant
	
}
