package java_exception_handling;

/**
 * Customized exception handling by using try-catch:
 * 
 * -> It's highly recommended to handle exception. The code which may rise
 * exception is called RISKY code and we have to define that code inside try
 * block and corresponding handling code we have to define inside catch block.
 * 
 * 
 * Try with multiple catch blocks:
 * 
 * -> The way of handling an exception is varied from exception to exception.
 * Hence, for every exception raised it's highly recommended to take separate
 * catch block. i.e. try with multiple catch block is always possible and
 * recommended to use.
 * 
 * -> If try with multiple catch block present then the order of catch block is
 * very important. we have to take child first and then parent. otherwise we'll
 * get compile time error saying exception XXXX has already been caught.
 * 
 * */

public class Demo_C {

	public static void controlFlow() {
		/** Control flow in try-catch: */

		// Normal termination
		// try {
		// System.out.println("state.. 1");
		// System.out.println("state.. 2");
		// System.out.println("state.. 3");
		// } catch (Exception e) {
		// System.out.println("state.. 4");
		// }
		// System.out.println("state.. 5");

		// try {
		// System.out.println("state.. 1");
		// System.out.println("state.. 2"+(10/0));
		//
		// // Whatever code here, won't be executed
		// System.out.println("state.. 3");
		// } catch (Exception e) {
		// System.out.println("state.. 4");
		// }
		// System.out.println("state.. 5");

		// try {
		// System.out.println("state.. 1");
		// System.out.println("state.. 2"+(10/0));
		// System.out.println("state.. 3");
		// } catch (ArrayIndexOutOfBoundsException e) {
		// System.out.println("state.. 4");
		// }
		// System.out.println("state.. 5");

		// try {
		// System.out.println("state.. 1");
		// System.out.println("state.. 2"+(10/0));
		// System.out.println("state.. 3");
		// } catch (Exception e) {
		// System.out.println("state.. 4"+(10/0));
		// }
		// System.out.println("state.. 5");

		// try {
		// System.out.println("state.. 1");
		// System.out.println("state.. 2");
		// System.out.println("state.. 3");
		// } catch (Exception e) {
		// System.out.println("state.. 4");
		// }
		// System.out.println("state.. 5"+(10/0));

		/**
		 * NOTE:
		 * 
		 * -> Within the try block if any where exception raised then rest of
		 * the try block won't be executed even though we handled that
		 * exception. Hence, within the try block we have to take only RISKY
		 * code and length of try block should be as less as possible.
		 * 
		 * -> In addition to try block there may be a chance of raising an
		 * exception inside catch and finally blocks.
		 * 
		 * -> If any statement which is not part of try block and raises
		 * exception then it is always abnormal termination.
		 */
	}

	public static void multiCatch() {

		/* Worst programming practice */
		try {
			// Risky code
		} catch (Exception e) {
			// Handling code
		}

		/* Good programming practice */
		try {
			// Risky code
		} catch (NullPointerException e) {
			// If null element access
		} catch (ArithmeticException e) {
			// If arithmetic problem
		} catch (Exception e) {
			// Default exception handling code
		}
	}

	public static void main(String[] args) {

		System.out.println("state 1");
		try {
			// Risky code
			System.out.println(10 / 0);
		} catch (ArithmeticException e) {
			// Handling code
			System.out.println(0);
		}
		System.out.println("state 2");

		controlFlow();
		multiCatch();
	}
}
