package algorithm.machine.learning.normalize;

import algorithm.matrix.Matrix;

public class Normalizer {

	private Matrix matrix;
	private Matrix factors;
	
	public Normalizer(Matrix x){
		this.matrix = x;
	}
	
	public void normalizeRows() {
		factors = new Matrix(matrix.rowCount(),1);
		
		Matrix temp = new Matrix(matrix.rowCount(), matrix.columnCount());
		double max;
		double min;
		double mean;
		for(int r=0; r<matrix.rowCount(); r++){
			
		}
		
	}
	
	public void normalizeColumns() {
		factors = new Matrix(1, matrix.columnCount());
	}
}
