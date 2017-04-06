package determinant;

public class MatrixTester 
{
	public static void main()
	{
		int matrix[][] = {{5, 4, 3, 2, 1},
						  {3, 4, 1, 2, 5},
						  {5, 3, 4, 1, 2},
						  {3, 5, 4, 2, 1},
						  {4, 1, 5, 2, 3}};
		
		Matrix m = new Matrix(matrix);
		m.printMatrix(m);
		System.out.println("---------------------------");
		System.out.print("Determinant: " + m.determinant(m));
		System.out.println();
	}
}
