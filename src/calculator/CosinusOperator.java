package calculator;

/*This class is used for cosinus operations.
 * It extends the AbstractOperator class.
 * The second value is not used, since cos is a unary operation.
 * The character which represents cos in an equation class is "c".
 */
public class CosinusOperator extends AbstractOperator {

    public CosinusOperator(int position) {
	this.position = position;
	this.precedence = 4;//The fourth lowest precedence.
    }
    
    @Override
    public double operate(double d1, double d2){
	return Math.cos(d1*(Math.PI/180));
    }

}
