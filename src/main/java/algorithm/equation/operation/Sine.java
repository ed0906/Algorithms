package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;

public class Sine implements Expression {

	private Expression argument;

	public Sine(Expression value) {
		this.argument = value;
	}

	@Override
	public Double evaluate() {
		return Math.sin(argument.evaluate());
	}

	@Override
	public String toString() {
		return "Sin(" + argument.toString() + ")";
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public Expression partialDifferential(String var) {
		return new Cosine(argument);
	}
}
