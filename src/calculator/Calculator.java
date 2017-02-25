package calculator;

import java.util.*;
/*This class expects a String value with an equation.
 *It calculates the value of this equation.
 *Both "," and "." are supported, as well as 
 *Parenthesis.
 */
public class Calculator {
    private String equation;
    private List<Double> values;
    private List<AbstractOperator> operators;
    
    public Calculator(){
	super();
    }
    
    //Setter 
    public void setEquation(String equation) throws UnsupportedOperatorsException,UnsupportedOrderException{
	equation = equation.replaceAll("\\s+", "");// Replaces all whitespaces.
	equation = equation.replaceAll(",", ".");// Replaces all commas with dots.
	this.testValues(equation);// Tests if all values are allowed.
	
	if(this.getOperator(equation.charAt(0),0)!=null){//the first letter is an operator
	    if(equation.charAt(0)=='+'||equation.charAt(0)=='-'){//the operator is + or -
		equation = new StringBuilder(equation).insert(0, '0').toString();//0 is inserted as the first letter
	    }else{//the operator is * or /
		equation = new StringBuilder(equation).insert(0, '1').toString();//1 is inserted as the first letter
	    }
	}
	
	this.equation = equation;
    }
    
    private void testValues(String equation) throws UnsupportedOperatorsException{
	
	/*This loop goes through each character of the Equation.
	 * It checks whether each character is supported or not. 
	 * If not, the Method throws an Exception.
	 */
	for(int i=0;i<equation.length();i++){
	    char c = equation.charAt(i);//Current character
	    switch(c){
	    //Operators
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
	    case '0':
		
	    case '.':
	    case '(':
	    case ')':
		
	    case '+':
	    case '-':
	    case '*':
	    case '/':break;//Stops if nothing happens
	    default: throw new UnsupportedOperatorsException("The character"+c+" is not supported.");// throws an Exception if no matching value is found.
	    }
	}
    }
    
    /*This method checks whether the character
     * is an operator. If it is, it returns a object
     * of this type. If not, it returns null.
     * The operator is also initializid with its position
     * in the array.
     */
    private AbstractOperator getOperator(char c, int position){
	    switch(c){
	    //Types
	    //Break statements are redundant, because the method already stops after each return statment.
	    case '/':return new DivideOperator(position);
	    case '+':return new PlusOperator(position);
	    case '-':return new MinusOperator(position);
	    case '*':return new TimesOperator(position);
	    default: return null;
	    }
    }
    
    //This method reads in the operators
    private void readInOperators(){
	operators = new ArrayList<AbstractOperator>();
	/*This for loop goes through the String.
	 * It checks whether each char is an operator.
	 * If a char is an operators, the operator class is 
	 * added to the operators array.
	 */
	for(int i = 0;i<equation.length();i++){
	    char character = equation.charAt(i);
	    AbstractOperator test = getOperator(character, i);
	    if(test != null){// when the char is not an operator, the method returns null
		operators.add(test);
	    }
	}
    }
    
    /*This method removes all parenthesis. It uses the method
     * of the operators to adjust the precedence accordingly.
     */ 
    private void removeParenthesis() throws UnsupportedOrderException{
	int currentParenthesis = 0;
	
	/*Counts the nummber of parenthesis already gone through. 
	 * The number is then removed from the position of the Operators, because all parenthesis are removed later.
	 */
	int goneThroughParenthesis = 0;
	int nearestOperator = 0;//Is the index of the nearest operator in the operators list
	for(int i =0;i<equation.length();i++){
	    /*This code block increases or decreases the currentParenthesis count.
	     * If the parentthesis count goes below 0, it will throw an exception.
	     */
	    if(equation.charAt(i)=='('){
		currentParenthesis++;
		goneThroughParenthesis++;
	    }
	    if(equation.charAt(i)==')'){
		if(currentParenthesis<0){
		    throw new UnsupportedOrderException("The order of the parenthesis is wrong!");
		}else{
		    currentParenthesis--;
		    goneThroughParenthesis++;
		}
	    }
	    
	    if(this.getOperator(equation.charAt(i), 0)!=null){//when the current letter is an Operator; the index(0) is irrelevant
		AbstractOperator temp = operators.get(nearestOperator);
		temp.setParenthesis(currentParenthesis);
		temp.setPosition(temp.getPosition()-goneThroughParenthesis);//Removes the number of parenthesis from the positon.
		operators.set(nearestOperator, temp);// sets the parentthesis of this operator, returns it in the list
		nearestOperator++;
	    }
	}
	
	//The precedence of the operators are updated, so the parentthesis can be removed.
	equation = equation.replaceAll("\\(", "");
	equation = equation.replaceAll("\\)","");    }
    
    /*This method reads in the Values of the numbers.
     *It requires that all parenthesis are removed and all operators are read in.
     *So this method calls the methods that do each of the things.
     *The values are then read in as the values between the operators.
     *If there is no letter between two operators(for example "+-" or "-+") 0 is read in.
     */
    private void readInValues() throws UnsupportedOrderException{
	this.readInOperators();
	this.removeParenthesis();
	values = new ArrayList<Double>();
	/*This loop goes through the operators list and reads in the values between two operators.
	 * It then adds these values to the values array.
	 * But it doesn't read in the first value if the first letter of the equation is not an operator.
	 * So there must be another if statement to account for this fact.
	 */
	if(operators.get(0).getPosition()!=0){
	    values.add(Double.parseDouble(equation.substring(0,operators.get(0).getPosition())));
	}

	for(int i =0; i<operators.size();i++){
	    try{
		int start = operators.get(i).getPosition()+1;//The start index for the value.The "+1" is because the substring method includes the first index.
		int end;
		double value;//The value
		if(i+1==operators.size()){//when the current operator the last operator is
		    end = equation.length();
		}else{
		    end = operators.get(i+1).getPosition();
		}
		if(start==end){//When there are two operators next to eachother. For more information, read the comment above the method head.
		    value = 0;
		}else{
		    value = Double.parseDouble(equation.substring(start, end));
		}
		values.add(value);
		
	    }catch(Exception e){
		throw new UnsupportedOrderException("This should never happen");
	    }
	}
    }
    
    /*This method is used to determine the result of the equation.
     * It uses the other private methods to read in the values and 
     * remove the parenthesis. It goes through the value list, operates 
     * the operator with the highest precedence and reads in the result as well
     * as remove the corresponding value and operator. It then returns the result.
     * 
     */
    public double operate() throws UnsupportedOrderException{
	this.readInValues();
	double result = 0;
	/*This loop goes through the list of the values and
	 * operators the two values next to the operator with the highest precedence.
	 * The result is then read into the values list and the other one which didn't change 
	 * is then removed. The operator is removed after that aswell.
	 */
	for(int i =values.size();i>1;i--){
	    int positionHighestPrecedenceOperator = 0;//Stores the Position of the operator with the highest precedence.
	    int highestPrecedence = 0;//Stores the highest precedence
	    /*This loop goes through the operators list and 
	     * gets the position of the operator with the highest precedence.
	     */
	    for(int j =0;j<operators.size();j++){
		if(operators.get(j).getPrecedence()>highestPrecedence){
		    highestPrecedence = operators.get(j).getPrecedence();
		    positionHighestPrecedenceOperator = j;
		}
	    }
	    result = operators.get(positionHighestPrecedenceOperator).operate(values.get(positionHighestPrecedenceOperator), values.get(positionHighestPrecedenceOperator+1));//Operates the two values.
	    values.set(positionHighestPrecedenceOperator, result);//Reads in the result.
	    values.remove(positionHighestPrecedenceOperator+1);//Removes the now redundant value.
	    operators.remove(positionHighestPrecedenceOperator);//Remove the now redundant operator.
	}
	return values.get(0);//Returns the result.
    }
}
