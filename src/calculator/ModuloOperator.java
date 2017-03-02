package calculator;

/*This class extends the AbstractOperator class.
 * It is used for modulo operations.
 */
public class ModuloOperator extends AbstractOperator {

    public ModuloOperator(int position) {
	super.precedence = 2;//The second lowest standard precedence
	super.position = position;
    }
    
    @Override
    public double operate(double d1,double d2){
	return d1%d2;
    }

}
