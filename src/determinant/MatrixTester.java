package determinant;

public class MatrixTester 
{
	public static void main(String[] args)
	{
		int matrix[][] = {{5, 4, 3},
						  {3, 4, 1},
						  {5, 3, 4}};
		
		Matrix m = new Matrix(matrix);
		m.printMatrix(m);
		System.out.println("---------------------------");
		System.out.print("Determinant: " + m.determinant(m));
		System.out.println();
	}
}
