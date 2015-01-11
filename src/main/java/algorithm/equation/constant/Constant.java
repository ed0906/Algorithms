package algorithm.equation.constant;

import org.apache.commons.lang3.builder.EqualsBuilder;

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

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		return new Constant(0);
	}
}
