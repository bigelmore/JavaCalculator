package calculator;

/*This class implements the AbstractOperator class.
 * It is used for subtraction.
 */
public class MinusOperator extends AbstractOperator {
    
    public MinusOperator(int position){
	super.precedence = 1;//The lowest standard precedence.
	this.position = position;
    }

    //Subtracts the two values.
    @Override
    public double operate(double d1, double d2) {
	return d1-d2;
    }

}
