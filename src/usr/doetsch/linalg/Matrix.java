package usr.doetsch.linalg;

public class Matrix {
	
	public final double[][] cells;
	
	protected Matrix (double[][] matrix) {
		//TODO check if row dimensions are symmetrical/rectangular
		
		this.cells = matrix;
	}
	
	protected Matrix (int rows, int columns) {
		if ((rows < 1) || columns < 1) {
			throw new InvalidDimensionsException("Invalid matrix dimensions: "
					+ rows + "x" + columns);
		}
		
		this.cells = new double[rows][columns];
	}
	
	public int getRows () {
		return cells.length;
	}
	
	public int getN () {
		return getRows();
	}
	
	public int getColumns () {
		return cells[0].length;
	}
	
	public int getM () {
		return getColumns();
	}
	
	/**
	 * Creates a new Matrix instance encapsulating the given matrix.
	 * 
	 * @param matrix the matrix to encapsulate/wrap
	 * @return a new Matrix instance wrapping the given matrix
	 */
	public static Matrix createMatrix (double[][] matrix) {
		return new Matrix(matrix);		
	}
	
	/**
	 * Creates a new Matrix instance encapsulating a matrix with the
	 * given dimensions
	 * 
	 * @param rows the number of rows in the matrix
	 * @param columns the number of columns in the matrix
	 * @return a new Matrix instance wrapping a matrix with the given dimensions
	 */
	public static Matrix createMatrix (int rows, int columns) {
		return new Matrix(rows, columns);
	}
	

	@Override
	public String toString () {
		String s = "";
		
		for (int row = 0; row < getRows(); row++) {
			for (int column = 0; column < getColumns(); column++) {
				s += String.valueOf(cells[row][column]) + ", ";
			}
			s += "\n";
		}
		
		return s;
	}
	
	public static void main (String[] args) {
		
		double[][] a = {{1, 2, 3, 4},
						{2, 3, 4, 5},
						{3, 4, 5, 6},
						{4, 5, 6, 7}};
		
		double[][] b = {{11, 12, 13, 14},
						{12, 13, 14, 15},
						{13, 14, 15, 16},
						{14, 15, 16, 17}};

//		double[][] b = {{11},
//						{12},
//						{13},
//						{14}};
		
		long then = System.currentTimeMillis();
		int i = 0;
		
		while ((System.currentTimeMillis() - then) < 10000) {				
			//System.out.println(Matrix.multiply(new Matrix(a), new Matrix(b)));
			Matrix m = LinAlg.multiply(new Matrix(a), new Matrix(b));
			i++;
		}
		
		System.out.println(i);
		
	}

}
