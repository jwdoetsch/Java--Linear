package usr.doetsch.linalg;

public class LinAlg {

	/**
	 * Calculates and returns the product of the multiplication of the given matrices.
	 *  
	 * @param a
	 * @param b
	 * @return
	 * @throws MatrixDimensionInconsistencyException
	 */
	public static Matrix multiply (Matrix a, Matrix b) throws MatrixDimensionInconsistencyException {
		Matrix c = Matrix.createMatrix(new double[a.getRows()][b.getColumns()]);
		
		if (a.getColumns() != b.getRows()) {
			throw new MatrixDimensionInconsistencyException();
		}
		
		for (int row = 0; row < c.getRows(); row++) {
			for (int column = 0; column < c.getColumns(); column++) {
				double sum = 0;
				for (int i = 0; i < a.getColumns(); i++) {
					sum += a.cells[row][i] * b.cells[i][column];
				}
				c.cells[row][column] = sum;
			}
		}
		
		
		return c;
	}
	
	/**
	 * Calculates and returns the product of the multiplication of the given matrices.
	 *  
	 * @param a
	 * @param b
	 * @return
	 * @throws MatrixDimensionInconsistencyException
	 */
	public static Matrix multiply (double[][] a, double[][] b) throws MatrixDimensionInconsistencyException {
		Matrix c = Matrix.createMatrix(new double[a.length][b[0].length]);
		
		if (a[0].length != b.length) {
			throw new MatrixDimensionInconsistencyException();
		}
		
		for (int row = 0; row < c.getRows(); row++) {
			for (int column = 0; column < c.getColumns(); column++) {
				double sum = 0;
				for (int i = 0; i < a[0].length; i++) {
					sum += a[row][i] * b[i][column];
				}
				c.cells[row][column] = sum;
			}
		}
		
		
		return c;
	}
	
	
}
