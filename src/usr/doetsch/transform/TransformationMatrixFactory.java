package usr.doetsch.transform;
import usr.doetsch.linalg.LinAlg;
import usr.doetsch.linalg.Matrix;

/**
 * TransformationMatrixFactory provides factory methods that create
 * and return 4x4 affine transformation matrices.
 * 
 * @author Jacob Wesley Doetsch
 */
public class TransformationMatrixFactory {
	
	private TransformationMatrixFactory () {
		
	}
	
	public static TransformationMatrixFactory createInstance () {
		return new TransformationMatrixFactory();		
	}
	
	/**
	 * Creates and returns a new affine scaling matrix.
	 * 
	 * @param sx x-axis scalar
	 * @param sy y-axis scalar
	 * @param sz z-axis scalar
	 * @return a Matrix instance encapsulating the transformation matrix
	 */
	public Matrix createScalingMatrix (double sx, double sy, double sz) {

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
	 * @return a Matrix instance encapsulating the transformation matrix
	 */
	public Matrix createTranslationMatrix (double tx, double ty, double tz) {

		double[][] m = {{1, 0, 0, tx},
						{0, 1, 0, ty},
						{0, 0, 1, tz},
						{0, 0, 0, 1}};
		
		return Matrix.createMatrix(m);
	}
	
	/**
	 * Creates and returns a new affine rotation matrix about the
	 * x axis (within the z-y plane).
	 * 
	 * @param angle the angle of rotation, in radians
	 * @return a Matrix instance encapsulating the transformation matrix
	 */
	public Matrix createXAxisRotation (double angle) {	
		
		double[][] m = {{1, 0, 0, 0},
						{0, Math.cos(angle), -Math.sin(angle), 0},
						{0, Math.sin(angle), Math.cos(angle), 0},
						{0, 0, 0, 1}};
		
		return Matrix.createMatrix(m);
	}
	
	/**
	 * Creates and returns a new affine rotation matrix about the
	 * y axis (within the x-z plane).
	 * 
	 * @param angle the angle of rotation, in radians
	 * @return a Matrix instance encapsulating the transformation matrix
	 */
	public Matrix createYAxisRotation (double angle) {
		
		double[][] m = {{Math.cos(angle), 0, -Math.sin(angle), 0},
						{0, 1, 0, 0},
						{Math.sin(angle), 0, Math.cos(angle), 0},
						{0, 0, 0, 1}};

		return Matrix.createMatrix(m);

	}
	
	/**
	 * Creates and returns a new affine rotation matrix about the
	 * z axis (within the x-y plane).
	 * 
	 * @param angle the angle of rotation, in radians
	 * @return a Matrix instance encapsulating the transformation matrix
	 */
	public Matrix createZAxisRotation (double angle) {
		
		double[][] m = {{Math.cos(angle), -Math.sin(angle), 0, 0},
						{Math.sin(angle), Math.cos(angle), 0, 0},
						{0, 0, 1, 0},
						{0, 0, 0, 1}};

		return Matrix.createMatrix(m);
		
	}
	
	public static void main (String[] args) {
		
		TransformationMatrixFactory affines = TransformationMatrixFactory.createInstance();
		
		double[][] p = {{0, 0, 1, 0},
						{0, 1, 0, 0},
						{0, 0, 0, 0},
						{1, 1, 1, 1}};
		
		System.out.println(
				LinAlg.multiply(
						affines.createZAxisRotation(Math.PI),
						Matrix.createMatrix(p)));
		
	}
	
}
