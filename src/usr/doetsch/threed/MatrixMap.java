package usr.doetsch.threed;

import java.util.ArrayList;

import usr.doetsch.linalg.Matrix;
import usr.doetsch.linalg.TransformationMatrixFactory;

public class MatrixMap {
	
	private ArrayList<Matrix> map;
	private int vectorCount = 0;
	
	public MatrixMap () {
		
		this.map = new ArrayList<Matrix>();
	}
	
	public void add (Matrix m) {
		this.map.add(m);
		vectorCount += m.cells[0].length;
	}
	
	public Matrix get (int index) {
		return this.map.get(index);
	}
	
	public Matrix getMatrix () {
		double[][] m = new double[4][vectorCount];
		
		for (int i = 0; i < map.size(); i++) {
			
			Matrix currentMatrix = map.get(i);
			
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < currentMatrix.getColumns(); c++) {
					m[r][(i * currentMatrix.getColumns()) + c] = currentMatrix.cells[r][c];
				}
			}
		}
		
		return Matrix.createMatrix(m);
	}
	
	public static void main (String[] args) {
		
		MatrixMap map = new MatrixMap();
		TransformationMatrixFactory matFact = TransformationMatrixFactory.createInstance();
		
		map.add(new Matrix44(matFact.createIdentityMatrix().cells));
		
		map.add(new Matrix44(matFact.createTranslationMatrix(2, 3, 4).cells));
		
		System.out.println(map.getMatrix());
	}
	
}
