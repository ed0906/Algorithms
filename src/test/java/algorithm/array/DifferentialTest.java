package algorithm.array;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DifferentialTest {

	private double FLOAT_DELTA = 0.1;
	
	private double[] series;
	private Differential differential;
	
	@Before
	public void setUp() {
		series = new double[]{2,1,1,2,3,3,2,1,1,2};
		differential = new Differential(series);
	}
	
	@Test
	public void shouldProcessStandardDifferential() {
		double[] gradient = differential.getStandardDifferential();
		
		assertEquals(9, gradient.length);
		assertEquals(1.5, gradient[0], FLOAT_DELTA);
		assertEquals(1, gradient[1], FLOAT_DELTA);
		assertEquals(1.5, gradient[2], FLOAT_DELTA);
	}
	
}
