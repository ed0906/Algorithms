package algorithm.matrix;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Matrix {

	private double[][] matrix;
	private int rows;
	private int cols;

	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;

		matrix = new double[rows][cols];
	}

	public double get(int row, int col) {
		return matrix[row][col];
	}

	public void fill(double number) {
		for (double[] row : matrix) {
			for (int i = 0; i < row.length; i++) {
				row[i] = number;
			}
		}
	}

	public void fill(int r1, int r2, int c1, int c2, double number){
		if(r1 > rows || r1 < 0 || r1 > r2 || r2 > rows){
			throw new MatrixDimensionException("Input row indices are invalid");
		}else if(c1 > cols || c1 < 0 || c1 > c2 || c2 > cols){
			throw new MatrixDimensionException("Input column indices are invalid");
		}
		
		for(int r=r1; r<r2+1; r++){
			for(int c=c1; c<c2+1; c++){
				set(r,c,number);
			}
		}
	}
	
	public void set(int row, int col, double value) {
		matrix[row][col] = value;
	}

	public int rowCount() {
		return rows;
	}

	public int columnCount() {
		return cols;
	}

	public Matrix multiplyBy(final Matrix m) {
		int mRows = m.rowCount();
		int mCols = m.columnCount();

		if (cols != mRows) {
			throw new MatrixDimensionException(
					"this.cols must be equal to m.rows");
		}

		Matrix output = new Matrix(rows, mCols);

		double aggregate;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < mCols; c++) {
				aggregate = 0;
				for (int e = 0; e < cols; e++) {
					aggregate += get(r, e) * m.get(e, c);
				}
				output.set(r, c, aggregate);
			}
		}

		return output;
	}

	public Matrix transpose() {
		Matrix output = new Matrix(cols, rows);

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				output.set(c, r, get(r, c));
			}
		}

		return output;
	}

	public Matrix add(final Matrix m) {
		if (rows != m.rowCount() || cols != m.columnCount()) {
			throw new MatrixDimensionException(
					"Cannot add matrices of different dimensions");
		}

		Matrix output = new Matrix(rows, cols);

		double sum;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				sum = get(r, c) + m.get(r, c);
				output.set(r, c, sum);
			}
		}

		return output;
	}

	public Matrix add(double value) {
		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				set(r, c, get(r, c) + value);
			}
		}
		return output;
	}

	public Matrix subtract(final Matrix m) {
		if (rows != m.rowCount() || cols != m.columnCount()) {
			throw new MatrixDimensionException(
					"Cannot subtract matrices of different dimensions");
		}

		Matrix output = new Matrix(rows, cols);

		double sub;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				sub = get(r, c) - m.get(r, c);
				output.set(r, c, sub);
			}
		}

		return output;
	}

	public Matrix subtract(double value) {
		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				set(r, c, get(r, c) - value);
			}
		}
		return output;
	}

	public Matrix multiplyBy(double factor) {
		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				output.set(r, c, get(r, c) * factor);
			}
		}
		return output;
	}

	public Matrix multiplyElementsBy(final Matrix m) {
		if (cols != m.columnCount() || rows != m.rowCount()) {
			throw new MatrixDimensionException(
					"Column & row count must be the same");
		}

		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				output.set(r, c, get(r, c) * m.get(r, c));
			}
		}
		return output;
	}

	public Matrix toPowerOf(double power) {
		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				output.set(r, c, Math.pow(get(r, c), power));
			}
		}
		return output;
	}

	public Matrix subMatrix(int r1, int r2, int c1, int c2) {
		Matrix output = new Matrix(r2 - r1 + 1, c2 - c1 + 1);

		for (int r = r1; r < r2 + 1; r++) {
			for (int c = c1; c < c2 + 1; c++) {
				output.set(r, c, get(r, c));
			}
		}
		return output;
	}

	public Matrix setSubMatrix(int rTopLeft, int cTopLeft, final Matrix m) {
		if(rTopLeft + m.rowCount() > rows || cTopLeft + m.columnCount() > cols) {
			throw new MatrixDimensionException("Matrix m does not fit inside");
		}
		
		Matrix output = copy();
		
		int r2 = rTopLeft + m.rowCount();
		int c2 = cTopLeft + m.columnCount();
		for(int r=rTopLeft; r<r2; r++){
			for(int c=cTopLeft; c<c2; c++) {
				output.set(r,c, m.get(r-rTopLeft, c-cTopLeft));
			}
		}
		
		return output;
	}
	
	public double sum() {
		double sum = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				sum += get(r, c);
			}
		}
		return sum;
	}

	@Override
	public boolean equals(Object m) {
		return EqualsBuilder.reflectionEquals(this, m);
	}

	public Matrix copy() {
		Matrix output = new Matrix(rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				output.set(r, c, get(r, c));
			}
		}
		return output;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(rows*(2*cols+3));
		for(int r=0; r<rows; r++){
			builder.append("|");
			for(int c=0; c<cols; c++){
				builder.append(get(r,c) + " ");
			}
			builder.deleteCharAt(builder.length()-1);
			builder.append("|\n");
		}
		int length = builder.length();
		builder.delete(length-2, length);
		return builder.toString();
	}
}
