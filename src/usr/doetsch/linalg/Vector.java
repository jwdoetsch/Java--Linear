package usr.doetsch.linalg;

public class Vector extends Matrix {
	
	protected Vector () {
		super(4, 1);
	}

	public Vector(double[][] b) {
		super(b);
	}

}
