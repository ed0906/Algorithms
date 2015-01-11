package algorithm.matrix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MatrixTest {
	private double FLOAT_ERROR = 0.1;

	@Test
	public void shouldInitializeAs3x3Matrix() {
		Matrix matrix = new Matrix(3, 3);
		
		assertEquals(3, matrix.rowCount());
		assertEquals(3, matrix.columnCount());
	}

	@Test
	public void shouldInitializeAsZeroMatrix() {
		Matrix matrix = new Matrix(3, 3);
		
		assertEquals(0, matrix.get(0, 0), FLOAT_ERROR);
		assertEquals(0, matrix.get(1, 1), FLOAT_ERROR);
		assertEquals(0, matrix.get(2, 2), FLOAT_ERROR);
	}

	@Test
	public void shouldFillWithOnes() {
		Matrix matrix = new Matrix(3, 3);
		matrix.fill(1);

		assertEquals(1, matrix.get(0, 0), FLOAT_ERROR);
		assertEquals(1, matrix.get(1, 1), FLOAT_ERROR);
		assertEquals(1, matrix.get(2, 2), FLOAT_ERROR);
	}

	@Test
	public void shouldSetIndividualElements() {
		Matrix matrix = new Matrix(3, 3);
		matrix.set(1, 1, 10);

		assertEquals(0, matrix.get(0, 0), FLOAT_ERROR);
		assertEquals(10, matrix.get(1, 1), FLOAT_ERROR);
		assertEquals(0, matrix.get(2, 2), FLOAT_ERROR);
	}

	@Test
	public void shouldMultiplyVectors() {
		Matrix m1 = new Matrix(1, 2);
		m1.fill(1);
		Matrix m2 = new Matrix(2, 1);
		m2.fill(2);

		Matrix product = m1.multiplyBy(m2);

		assertEquals(1, product.rowCount());
		assertEquals(1, product.columnCount());
		assertEquals(4, product.get(0, 0), FLOAT_ERROR);
	}

	@Test
	public void shouldMultipleMatrices() {
		Matrix m1 = new Matrix(2, 2);
		m1.fill(1);
		Matrix m2 = new Matrix(2, 1);
		m2.fill(2);

		Matrix product = m1.multiplyBy(m2);

		assertEquals(2, product.rowCount());
		assertEquals(1, product.columnCount());
		assertEquals(4, product.get(0, 0), FLOAT_ERROR);
		assertEquals(4, product.get(1, 0), FLOAT_ERROR);
	}
	
	@Test
	public void shouldMultiplyMatricesByANumber() {
		Matrix m1 = new Matrix(2, 2);
		m1.fill(2);
		
		Matrix product = m1.multiplyBy(2);
		
		assertEquals(2, product.rowCount());
		assertEquals(2, product.columnCount());
		assertEquals(4, product.get(0, 0), FLOAT_ERROR);
		assertEquals(4, product.get(1, 0), FLOAT_ERROR);
	}
	
	@Test(expected = MatrixDimensionException.class)
	public void shouldThrowExceptionForMultiplicationWithInvalidDimensions() {
		Matrix m1 = new Matrix(2, 2);
		Matrix m2 = new Matrix(1, 1);
		
		m1.multiplyBy(m2);
		fail();
	}
	
	@Test
	public void shouldTransposeMatrices() {
		Matrix m = new Matrix(2, 1);
		m.set(1, 0, 1);
		
		Matrix t = m.transpose();
		
		assertEquals(1, t.rowCount());
		assertEquals(2, t.columnCount());
		assertEquals(1, t.get(0, 1), FLOAT_ERROR);
	}
	
	@Test
	public void shouldAddMatrices() {
		Matrix m1 = new Matrix(2,2);
		m1.fill(1);
		
		Matrix m2 = new Matrix(2,2);
		m2.fill(2);
		
		Matrix sum = m1.add(m2);
		
		assertEquals(2, sum.rowCount());
		assertEquals(2, sum.columnCount());
		assertEquals(3, sum.get(0, 0), FLOAT_ERROR);
	}
	
	@Test
	public void shouldSubtractMatrices() {
		Matrix m1 = new Matrix(2,2);
		m1.fill(3);
		
		Matrix m2 = new Matrix(2,2);
		m2.fill(2);
		
		Matrix result = m1.subtract(m2);
		
		assertEquals(2, result.rowCount());
		assertEquals(2, result.columnCount());
		assertEquals(1, result.get(0, 0), FLOAT_ERROR);
	}
	
	@Test
	public void shouldSumMatrix() {
		Matrix m1 = new Matrix(2,2);
		m1.fill(1);
		
		assertEquals(4, m1.sum(), FLOAT_ERROR);
	}

	@Test
	public void shouldCreateSubMatrix() {
		Matrix m = new Matrix(2,2);
		m.fill(1);
		
		Matrix mSub = m.subMatrix(0, 1, 0, 0);
		
		assertEquals(2, mSub.rowCount());
		assertEquals(1, mSub.columnCount());
		assertEquals(1, mSub.get(0, 0), FLOAT_ERROR);
		assertEquals(1, mSub.get(1, 0), FLOAT_ERROR);
		
	}
}
