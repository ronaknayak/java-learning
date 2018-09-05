package java_exception_handling;

/**
 * 2. multi_catch block:
 *
 * Until 1.6 version even though multiple different exceptions having same
 * handling code for every exception type we have to write separate catch block.
 * It increases length of the code and reduce readability.
 *
 * To overcome this problem sun people introduced multi_catch block in 1.7
 * version.
 *
 * According to this we can write a single catch block that can handle multiple
 * different types of exceptions.
 *
 * The main advantage of this approach is length of the code will be reduced and
 * readability will be improved.
 * 
 */
public class Demo_J {

	public static void main(String[] args) {

		try {
			String name = null;
			System.out.println(name.length());
		} catch (NumberFormatException e) {
			/*
			 * But the class of the reference e will be the closest common super
			 * class of all the exceptions in the catch block.
			 * 
			 * In this case, it will be java.lang.Exception because that is the
			 * most specific class that is a super class for all the three
			 * exceptions.
			 */
			System.out.println("handling code for this all exceptions "
					+ e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println("handling code for this exception "
					+ e.getMessage());
		}

		/**
		 * In multi_catch block there should not be any relation between
		 * exception types (either child to parent or parent to child or same
		 * types). Otherwise we'll get compile time error.
		 */

		// try {
		// } catch (ArithmeticException | Exception e) {
		// System.out.println("handling code for this exception "
		// + e.getMessage());
		// }

		/**
		 * Re-throwing exception:
		 * 
		 * We can use this approach to convert one exception type to another
		 * exception type.
		 * 
		 * USE CASE: In our application, if we have configured one error page to
		 * handle different types of exceptions.
		 * */
		try {
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			throw new Demo_G_TooOldException("universal exception handling");
		}

		/**
		 * If a catch block handles more than one exception type i.e.
		 * multi_catch_block, then the catch parameter is implicitly final. In
		 * this example, the catch parameter e is final and therefore you cannot
		 * assign any values to it within the catch block.
		 * 
		 * The exception parameter in a MULTI-CATCH clause is implicitly final.
		 * Thus, it cannot be reassigned. Had there been only one exception in
		 * the catch clause , it would have been valid.
		 */
		try {
		} catch (ArithmeticException | NullPointerException ex) {
			//ex = new NullPointerException();
		}
	}
}
