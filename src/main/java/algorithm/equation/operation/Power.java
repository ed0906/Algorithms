package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;

public class Power implements Expression{

	private Expression base;
	private Expression exponent;
	
	public Power(Expression lhs, Expression rhs) {
		this.base = lhs;
		this.exponent = rhs;
	}
	
	@Override
	public Double evaluate() {
		return Math.pow(base.evaluate(), exponent.evaluate());
	}
	
	@Override
	public String toString() {
		return base.toString() + "^(" + exponent.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		return new Multiply(this,new Multiply(exponent, new Ln(base).partialDifferential(var)));
	}
}
