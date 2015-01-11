package algorithm.machine.learning.normalize;

import algorithm.matrix.Matrix;

public class Normalizer {

	private Matrix matrix;

	public Normalizer(Matrix x) {
		this.matrix = x;
	}

	public Matrix normalizeEachRow() {
		Matrix temp = new Matrix(matrix.rowCount(), matrix.columnCount());

		for (int r = 0; r < matrix.rowCount(); r++) {
			double max = Double.MIN_VALUE;
			double min = Double.MAX_VALUE;
			double sum = 0;
			for (int c = 0; c < matrix.columnCount(); c++) {
				double val = matrix.get(r, c);
				if (val > max) {
					max = val;
				} else if (val < min) {
					min = val;
				}

				sum += val;
			}

			double mean = sum / (double) matrix.columnCount();
			double range = max - min;

			for (int c = 0; c < matrix.columnCount(); c++) {
				double val = matrix.get(r, c);
				val = (val - mean) / range;
				temp.set(r, c, val);
			}
		}
		
		return temp;
	}

	public Matrix normalizeEachColumn() {
		Matrix temp = new Matrix(matrix.rowCount(), matrix.columnCount());

		for (int c = 0; c < matrix.columnCount(); c++) {
			double max = Double.MIN_VALUE;
			double min = Double.MAX_VALUE;
			double sum = 0;
			for (int r = 0; r < matrix.rowCount(); r++) {
				double val = matrix.get(r, c);
				if (val > max) {
					max = val;
				} else if (val < min) {
					min = val;
				}

				sum += val;
			}

			double mean = sum / (double) matrix.columnCount();
			double range = max - min;

			for (int r = 0; r < matrix.rowCount(); r++) {
				double val = matrix.get(r, c);
				val = (val - mean) / range;
				temp.set(r, c, val);
			}
		}
		
		return temp;
	}
}
