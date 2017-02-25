package calculator;

/*This class implements the AbstractOperator.
 * It is used for addition.
 */
public class PlusOperator extends AbstractOperator {
    
    public PlusOperator(int position){
	super.precedence = 1;// The Lowest Standard precedence
	this.position = position;
    }
    
    @Override
    public double operate(double d1,double d2){
	return d1+d2;
    }

}
