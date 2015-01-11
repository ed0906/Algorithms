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
		x = new Matrix(3,2);
		
		//x0
		x.set(0, 0, 1);
		x.set(1, 0, 1);
		x.set(2, 0, 1);
		
		//x1
		x.set(0, 1, 1);
		x.set(1, 1, 2);
		x.set(2, 1, 3);
	}
	
	@Test
	public void shouldCalculateHypothesis() {
		Matrix hOutput = hypothesis.evaluate(x);
		
		assertEquals(3, hOutput.rowCount());
		assertEquals(1, hOutput.columnCount());
		assertEquals(0, hOutput.get(0, 0), FLOAT_ERROR);
		assertEquals(0, hOutput.get(1, 0), FLOAT_ERROR);
		assertEquals(0, hOutput.get(2, 0), FLOAT_ERROR);
	}
}
