package algorithm.equation;

public interface Expression {

	public Double evaluate();
	
	public Expression partialDifferential(String var);
}
