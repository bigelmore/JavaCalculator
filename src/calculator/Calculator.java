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
	    }else{
		equation = new StringBuilder(equation).insert(0, '1').toString();//1 is inserted as the first letter
	    }
	}
	//This for loop tests if the logarithms are in the right order
	//It also inserts 10; when the logarithms are in the form log(b). For example
	//log(25) would be changed to log(10;25)
	for(int i = 0; i<equation.length();i++){
	    if(equation.charAt(i)=='l'){
		if(equation.charAt(i+1)!='o'||equation.charAt(i+2)!='g'){
		    throw new UnsupportedOrderException("The logarithms are typed wrongly!Excpected synstax is log(a;b)");
		}
		
		int startNextLogarithm;//Stores the position of the next logarithm
		if(equation.indexOf("log", i+3)!=-1){//When there is another logarithm
		    startNextLogarithm = equation.indexOf('l');
		}else{
		    startNextLogarithm = equation.length()-1;//The end of the string
		}
		if(!equation.substring(i, startNextLogarithm+1).contains(";")){//Substring method is exclusiuve, hence the plus 1
		    equation = new StringBuilder(equation).insert(i+4,"10;").toString();
		}
		
		//This checks whether there is a number infront of the String and
		//if there is "*" is inserted there.
		if(i>0){
		    try{
			Double.parseDouble(equation.substring(i-1,i));//Throws an exception when there is no number, i.e. an operator
			equation = new StringBuilder(equation).insert(i, "*").toString();
		    }catch(Exception ex){//When there is no number
			
		    }
		}
	    }
	}
	equation = equation.replaceAll("log", "");
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
	    case 'l':
	    case 'o':
	    case 'g':
		
	    case '.':
	    case '(':
	    case ')':
		
	    case '+':
	    case '-':
	    case '*':
	    case '%':
	    case '^':
	    case ';':
	    case '!':
	    case '/':break;//Stops if nothing happens
	    default: throw new UnsupportedOperatorsException("The character"+c+" is not supported.");// throws an Exception if no matching value is found.
	    }
	}
    }
    
    /*This method checks whether the character
     * is an operator. If it is, it returns a object
     * of this type. If not, it returns null.
     * The operator is also initialized with its position
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
	    case '%':return new ModuloOperator(position);
	    case '^':return new ExponateOperator(position);
	    case ';':return new LogarithmOperator(position);
	    case '!':return new FactorialOperator(position);
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
    
    /*Returns true when the operator at the position index in the 
     * array operators is an unary operator.
     * 
     */
    private boolean isUnaryOperator(int position){
	AbstractOperator test = operators.get(position);
	if(test instanceof FactorialOperator){
	    return true;
	}
	return false;
    }
    
    /*This method removes all parenthesis. It uses the method
     * of the operators to adjust the precedence accordingly.
     */ 
    private void removeParenthesis() throws UnsupportedOrderException{
	int currentParenthesis = 0;
	
	/*Counts the number of parenthesis already gone through. 
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
		operators.set(nearestOperator, temp);// sets the parenthesis of this operator, returns it in the list
		nearestOperator++;
	    }
	}
	
	//The precedence of the operators are updated, so the parenthesis can be removed.
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
		    //When the first Operator is '^','*' or "/" and the second one is '+' or '-'
		    if(((operators.get(i) instanceof ExponateOperator)||(operators.get(i) instanceof TimesOperator)||(operators.get(i) instanceof DivideOperator))&&((operators.get(i+1)instanceof PlusOperator)||(operators.get(i+1)instanceof MinusOperator))){
			operators.remove(i+1);//removes the second operator
			/*The end position has to be changed now.
			 *The if statements is there if there is not another operator
			 */
			if(i+1==operators.size()){
			    end = equation.length();
			}else{
			    end = operators.get(i+1).getPosition();
			}
			value = Double.parseDouble(equation.substring(start,end));//reads in the value 
		    }
		}else{
		    value = Double.parseDouble(equation.substring(start, end));
		}
		//There only needs to be added if the operator is not an unary operator
		if(!this.isUnaryOperator(i)){
		    values.add(value);
		}
		
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
	while(operators.size()>0){
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
	    if(!this.isUnaryOperator(positionHighestPrecedenceOperator)){
		result = operators.get(positionHighestPrecedenceOperator).operate(values.get(positionHighestPrecedenceOperator), values.get(positionHighestPrecedenceOperator+1));//Operates the two values.
		values.set(positionHighestPrecedenceOperator, result);//Reads in the result.
		values.remove(positionHighestPrecedenceOperator+1);//Removes the now redundant value.
		operators.remove(positionHighestPrecedenceOperator);//Remove the now redundant operator.
	    }else{
		values.set(positionHighestPrecedenceOperator, operators.get(positionHighestPrecedenceOperator).operate(values.get(positionHighestPrecedenceOperator), 0));
		operators.remove(positionHighestPrecedenceOperator);
	    }
	}
	return values.get(0);//Returns the result.
    }
}
