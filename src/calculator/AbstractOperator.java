package calculator;
/*An operator is a class that can take two values and output 
 * the resulting value. The child classes have to implement 
 * the operation which has to be done on the parameters.
 */
public abstract class AbstractOperator {
    
    /*The precedence is used to determine
     *in which order the operations have to be done.
     *The higher the precedence, the earlier the
     *operation will be done. 
     */
    protected int precedence = 0;
    
    /*This int gives the position of
     * the operator in the String value.
     * 
     * It is to initialize the values of the number,
     * because the program only gets the position 
     * of the Operators. The numbers have to be 
     * allocated in between them.
     */
    protected int position = 0;
    
    /*The maximum Precedence a Operator can have.
     *Parenthesis can change the precedence of
     *a certain Operator. 
     */
    public static final int MAX_PRECEDENCE = 15;
    
    //The Abstract Operation which the Child Classes have to implement.
    public abstract double operate(double d1, double d2);
    
    /*This method sets the Parenthesis.
     *The Operators with the most Parenthesis have the 
     *highest Precedence. 
     */
    public void setParenthesis(int numberOfParenthesis){
	precedence = precedence+(numberOfParenthesis*MAX_PRECEDENCE);
    }
    
    //Getter for the Precedence
    public int getPrecedence(){
	return this.precedence;
    }
    
    //Setter for Position
    public void setPosition(int position){
	this.position = position;
    }
    
    public int getPosition (){
	return this.position;
    }

}
