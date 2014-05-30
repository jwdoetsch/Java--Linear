package usr.doetsch.transform;
import usr.doetsch.linalg.Matrix;

/**
 * Matrix44 provides static methods that instantiate and return
 * affine transformation matrices.
 * 
 * @author Jacob Wesley Doetsch
 */

public class Matrix44 {
	
	/**
	 * Creates and returns a new affine scaling matrix.
	 * 
	 * @param sx x-axis scalar
	 * @param sy y-axis scalar
	 * @param sz z-axis scalar
	 * @return a Matrix instance encapsulating the affine scaling matrix defined
	 * by the given scalar values
	 */
	public static Matrix createScalingMatrix (double sx, double sy, double sz) {

		double[][] m = {{sx, 0, 0, 0},
						{0, sy, 0, 0},
						{0, 0, sz, 0},
						{0, 0, 0, 1}};
		
		
		return Matrix.createMatrix(m);			
	}
	
	/**
	 * Creates and returns a new affine translation matrix.
	 * 
	 * @param tx the x component of the translation vector
	 * @param ty the y component of the translation vector
	 * @param tz the z component of the translation vector
	 * @return a Matrix instance encapsulating the affine translation matrix
	 */
	public static Matrix createTranslationMatrix (double tx, double ty, double tz) {

		double[][] m = {{1, 0, 0, tx},
						{0, 1, 0, ty},
						{0, 0, 1, tz},
						{0, 0, 0, 1}};
		
		return Matrix.createMatrix(m);
	}
	
	
	public static Matrix createXAxisRotation (double angle) {	
		
		double[][] m = {{1, 0, 0, 0},
						{0, Math.cos(angle), -Math.sin(angle), 0},
						{0, Math.sin(angle), Math.cos(angle), 0},
						{0, 0, 0, 1}};
		
		return Matrix.createMatrix(m);
	}
	
	public static Matrix createYAxisRotation (double angle) {
		
		double[][] m = {{Math.cos(angle), 0, -Math.sin(angle), 0},
						{0, 1, 0, 0},
						{Math.sin(angle), 0, Math.cos(angle), 0},
						{0, 0, 0, 1}};

		return Matrix.createMatrix(m);

	}
	
	public static Matrix createZAxisRotation (double angle) {
		
		double[][] m = {{Math.cos(angle), -Math.sin(angle), 0, 0},
						{Math.sin(angle), Math.cos(angle), 0, 0},
						{0, 0, 1, 0},
						{0, 0, 0, 1}};

		return Matrix.createMatrix(m);
		
	}
	
	public static void main (String[] args) {
		
		double[][] p = {{0, 0, 1, 0},
						{0, 1, 0, 0},
						{0, 0, 0, 0},
						{1, 1, 1, 1}};
		
		System.out.println(
				Matrix.multiply(
						Matrix44.createZAxisRotation(Math.PI),
						Matrix.createMatrix(p)));
		
	}
	
}
