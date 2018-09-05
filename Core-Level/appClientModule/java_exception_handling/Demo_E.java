package java_exception_handling;

/**
 * throw keyword:
 * 
 * -> Sometimes we can create exception object explicitly, we can hand-over to
 * the JVM manually. For this we have to use throw keyword.
 * 
 * -> Hence, the main objective of throw keyword is to hand-over our created
 * exception object to the JVM manually.
 * 
 * -> Best use of throw keyword is for User defined exceptions or Customized
 * exceptions. e.g.
 * 
 * public void withdraw(double amount) {
 * 
 * if(amount > balance) { throw new InsufficientBalanceException(); } else {
 * balance = balance - amount; } }
 * 
 * When to throw an exception ?
 * 
 * It is NOT an exception if the user name is not valid or the password is not
 * correct. Those are things you should expect in the normal flow of operation.
 * Exceptions are things that are not part of the normal program operation and
 * are rather rare. So, would say above sudo code may be wrongly designed.
 */

public class Demo_E {

	static StringIndexOutOfBoundsException se = new StringIndexOutOfBoundsException();
	static ArithmeticException e;

	public static void defaultCreation() {

		/*
		 * Here, exception object created by defaultCreation() and later it will
		 * be Hand-over to the JVM internally.
		 */
		System.out.println(10 / 0);
	}

	public static void manualCreation() {

		/*
		 * Here, we are creating object of arithmetic exception explicitly. and
		 * Hand-over our created exception object to the JVM manually.
		 */
		if (true) {
			throw new ArithmeticException("/ by zero_manual process");
		}
	}

	public static void main(String[] args) {

		/*
		 * The Result of both cases will be same. There is no difference except
		 * that we create exception object and pass to the JVM manually in case
		 * of throw.
		 */

		// defaultCreation();
		// manualCreation();

		/**
		 * Case 1: If we are trying to throw null reference, we will get
		 * NullPointerException.
		 * */

		// throw se;
		// throw e;

		/**
		 * Case 2: After throw statement we are not allow to write any statement
		 * directly. Although, indirectly we can write.
		 * */

		// CE: unreachable statement
		/*
		 * throw new NumberFormatException();
		 * System.out.println("execute this");
		 */

		/**
		 * Case 3: We can use throw keyword only for Throwable types. If we are
		 * trying to use for normal java objects then we'll get compile time
		 * error.
		 */

		// CE: incompatible types
		// throw new Demo_E();
	}
}
