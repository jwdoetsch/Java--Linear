package usr.doetsch.linalg;



public class Vector extends Matrix {

	protected Vector (double[][] matrix) {
		super(matrix);
	}
	
	public static Vector createVector (double x, double y, double z) {
		double[][] m = {{x},
						{y},
						{z},
						{1}};

		return new Vector(m);
	}
	
	public static void main (String[] args) {
		
		Matrix a = Matrix.createMatrix(4, 4);
		
		Matrix b = Vector.createVector(1,  2, 3);
		
	}

}
