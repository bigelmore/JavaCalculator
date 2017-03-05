package calculator;

/*This operator is used for factorial operations.
 * The double value in the will be parsed to an int.
 */
public class FactorialOperator extends AbstractOperator {

    public FactorialOperator(int position) {
	super.position = position;
	super.precedence = 4;
    }
    
    @Override 
    public double operate(double d1, double d2){
	int i = Math.abs(new Double(d1).intValue());
	int result = 1;
	for(int j = 1;j<=i;j++){
	    result = result*j;
	}
	
	return result;
    }

}
