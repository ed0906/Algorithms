package algorithm.equation.operation;

import org.apache.commons.lang3.builder.EqualsBuilder;

import algorithm.equation.Expression;

public class Multiply implements Expression{

	private Expression[] elements;
	
	public Multiply(Expression lhs, Expression rhs) {
		elements = new Expression[]{lhs, rhs};
	}
	
	public Multiply(Expression... elements){
		if(elements != null && elements.length > 0) {
			this.elements = elements;
		}else{
			throw new RuntimeException("Cannot use the multiply operation on less than 2 expressions");
		}
	}
	
	@Override
	public Double evaluate() {
		double value = 1;
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
			builder.append(" * ");
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
		int n = elements.length;
		Expression[] components = new Expression[n*(n-1)];
		
		for(int i=0; i<n; n++){
			int counter = 0;
			for(int j=0; j<n; j++){
				if(i != j){
					components[counter] = new Multiply(elements[i], elements[j].partialDifferential(var));
					counter++;
				}
			}
		}
		
		return new Add(components);
	}
}
