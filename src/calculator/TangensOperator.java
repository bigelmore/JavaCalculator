package calculator;

/*This class extends the AbstractOperator class.
 * It is used for tangens operations.
 * The second value in the operate function is not used, since tangens is a unary operation.
 *The character for tan operations in the equation class is "t".
 */
public class TangensOperator extends AbstractOperator {

    public TangensOperator(int position) {
	this.position = position;
	this.precedence = 4;//The fourth lowest precedence.
    }
    
    @Override
    public double operate(double d1,double d2){
	return Math.tan(d1*(Math.PI/180));
    }

}
