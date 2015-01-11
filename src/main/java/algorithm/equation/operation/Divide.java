package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;
import algorithm.equation.constant.Constant;

public class Divide implements Expression{

	private Expression lhs;
	private Expression rhs;
	
	public Divide(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	@Override
	public Double evaluate() {
		return lhs.evaluate() / rhs.evaluate();
	}
	
	@Override
	public String toString() {
		return lhs.toString() + " / " + rhs.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	

	@Override
	public Expression partialDifferential(String var) {
		Expression exp1 = new Multiply(lhs, new Power(rhs, new Constant(-1)));
		Expression exp2 = new Multiply(new Power(rhs,new Constant(-1)),lhs.partialDifferential(var));
		return new Add(exp1, exp2);
	}
}
