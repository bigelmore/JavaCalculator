package calculator;

/*This class extends the AbstractOperator class.
 * It is used to exponate two double values.
 */
public class ExponateOperator extends AbstractOperator {

    public ExponateOperator(int postion) {
	super.position = postion;
	super.precedence = 3;//The third lowest standard precedence;
    }
    
    @Override
    public double operate(double d1, double d2){
	return Math.pow(d1, d2);	
    }

}
