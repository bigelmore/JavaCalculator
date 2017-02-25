package calculator;

/*This Exception is used when there are Characters
 * in the equation which are not supported via an operator.
 */
public class UnsupportedOperatorsException extends Exception {

    public UnsupportedOperatorsException() {
	super();
    }

    public UnsupportedOperatorsException(String message) {
	super(message);
    }

    public UnsupportedOperatorsException(Throwable cause) {
	super(cause);
    }

    public UnsupportedOperatorsException(String message, Throwable cause) {
	super(message, cause);
    }

    public UnsupportedOperatorsException(String message, Throwable cause, boolean enableSuppression,
	    boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

}
