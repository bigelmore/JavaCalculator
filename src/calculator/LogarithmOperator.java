package calculator;

/*This class extends the AbstractOperator class.
 * It is used for logarithms, which are expected to
 * be written in the form log(a;b).
 * The ";" is the actual operator, which is why there always must be one in a logarithm.
 * The parenthesis count is also decremented by one, because the operator is always in parenthesis. 
 * Logarithms written in the form log(a) are changed to the form log(10;a)
 */
public class LogarithmOperator extends AbstractOperator {

    public LogarithmOperator(int position) {
	super.position = position;
	super.precedence = 4;//The fourth lowest precedence.
    }
    
    public double operate(double d1, double d2){
	return Math.log(d2)/Math.log(d1);
    }
    
    @Override
    public void setParenthesis(int parenthesis){
	if(parenthesis-1>=0){
	    super.setParenthesis(parenthesis-1);
	}
    }

}
