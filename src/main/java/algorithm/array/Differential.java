package algorithm.array;

public class Differential {

	private double[] series;
	
	public Differential(double[] series) {
		this.series = series;
	}

	public double[] getStandardDifferential() {
		double[] gradient = new double[series.length-1];
		
		for(int i=1; i<series.length; i++){
			gradient[i-1] = 0.5 * (series[i-1] + series[i]);
		}
		return gradient;
	}

	
}
