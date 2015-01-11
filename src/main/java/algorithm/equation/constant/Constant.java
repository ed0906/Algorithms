package algorithm.equation.constant;

import algorithm.equation.Expression;

public class Constant implements Expression{
	
	private double value;
	
	public Constant(double value) {
		this.value = value;
	}

	@Override
	public Double evaluate() {
		return value;
	}

	@Override
	public String toString() {
		if(value % 1 == 0){
			return "" + (int) value;
		}
		return "" + value;
	}
}
