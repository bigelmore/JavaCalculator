package calculator;
/*This class is used for sinus operations.
 * It extends the AbstractOperator class.
 * The character used for it is an "s".
 * The second value is not used.
 */
public class SinusOperator extends AbstractOperator {

    public SinusOperator(int position) {
	super.position = position;
	super.precedence = 4;//The fourth lowest precedence.
    }
    
    //The Math class uses radians, so d1 has to be changed.
    @Override
    public double operate(double d1, double d2){
	return Math.sin(d1*(Math.PI/180));
    }

}
