package java_exception_handling;

/**
 * How to define customized exception.
 * 
 * While defining our own exception it's highly recommended to define Customized
 * exception as Unchecked i.e. We have to extend RuntimeException but not
 * Exception or Throwable.
 */

public class Demo_G_TooYoungException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * As we have to provide some our exception message that's why we have to
	 * take parameterized constructor for that.
	 */
	public Demo_G_TooYoungException(String s) {

		/*
		 * This required to avail our own exception message to the default
		 * exception handler. i.e. to JVM.
		 */
		super(s);
	}
}
