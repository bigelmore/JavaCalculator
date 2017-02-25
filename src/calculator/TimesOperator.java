package calculator;

/*This class extendes the AbstractOperator class.
 * It is used for multiplication.
 */
public class TimesOperator extends AbstractOperator {
    
    public TimesOperator(int position){
	this.precedence = 2;//The second lowest Precedence.
	this.position = position;
    }

    //Multiplicates the values.
    @Override
    public double operate(double d1, double d2) {
	return d1*d2;
    }

}
