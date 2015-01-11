package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;

public class Add implements Expression{

	private Expression[] elements;
	
	public Add(Expression lhs, Expression rhs) {
		this.elements = new Expression[]{lhs, rhs};
	}
	
	public Add(Expression...expressions){
		if(expressions == null || expressions.length < 2){
			throw new RuntimeException("Cannot add less than 2 expressions");
		}
		this.elements = expressions;
	}
	
	@Override
	public Double evaluate() {
		double value = 0;
		for(Expression e : elements){
			value *= e.evaluate();
		}
		
		return new Double(value);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Expression e : elements){
			builder.append(e.toString());
			builder.append(" + ");
		}
		builder.delete(builder.length()-3, builder.length());
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public Expression partialDifferential(String var) {
		Expression[] differentials = elements.clone();
		for(int i=0; i<elements.length; i++){
			differentials[i] = differentials[i].partialDifferential(var);
		}
		return new Add(differentials);
	}
}
