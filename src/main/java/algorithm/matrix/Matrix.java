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

	public void set(int row, int col, double value) {
		matrix[row][col] = value;
	}

	public int rowCount() {
		return rows;
	}

	public int columnCount() {
		return cols;
	}

	public Matrix multiplyBy(Matrix m) {
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

	public Matrix add(Matrix m) {
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

	public Matrix subtract(Matrix m) {
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

	public Matrix multiplyElementsBy(Matrix m) {
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
}
