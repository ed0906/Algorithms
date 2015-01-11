package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;

public class Ln implements Expression{
	
	private Expression value;
	
	public Ln(Expression value) {
		this.value = value;
	}

	@Override
	public Double evaluate() {
		return Math.log(value.evaluate());
	}

	@Override
	public String toString() {
		return "Ln(" + value.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		return new Divide(value.partialDifferential(var), value);
	}
}
