package calculator;

/*This class extendes the AbstractOperator class.
 * It is used for division.
 */
public class DivideOperator extends AbstractOperator {
    
    public DivideOperator(int position){
	this.precedence = 2;//the second lowest precedence
	this.position = position;
    }
    
    @Override
    public double operate(double d1, double d2) {
	return d1/d2;
    }

}
