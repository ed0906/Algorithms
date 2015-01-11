package algorithm.machine.learning.hypothesis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import algorithm.matrix.Matrix;

public class RegressionHypothesisTest {

	private final static double FLOAT_ERROR = 0.1;
	private RegressionHypothesis hypothesis;
	private Matrix x;
	
	@Before
	public void setUp() {
		hypothesis = new RegressionHypothesis(2);
		x = new Matrix(2,3);
		
		//x0
		x.set(0, 0, 1);
		x.set(0, 1, 1);
		x.set(0, 2, 1);
		
		//x1
		x.set(1, 0, 1);
		x.set(1, 1, 2);
		x.set(1, 2, 3);
	}
	
	@Test
	public void shouldCalculateHypothesis() {
		Matrix hOutput = hypothesis.calculate(x);
		
		assertEquals(1, hOutput.rowCount());
		assertEquals(3, hOutput.columnCount());
		assertEquals(0, hOutput.get(0, 0), FLOAT_ERROR);
		assertEquals(0, hOutput.get(0, 1), FLOAT_ERROR);
		assertEquals(0, hOutput.get(0, 2), FLOAT_ERROR);
	}
}
