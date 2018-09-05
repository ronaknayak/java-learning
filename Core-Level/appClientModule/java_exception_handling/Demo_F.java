package java_exception_handling;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * throws keyword:
 * 
 * Exception propagation:
 * 
 * Inside a method if an exception raised and if we are not handling that
 * exception then exception object will be propagated to caller then caller
 * method is responsible to handle exception. This process is called exception
 * propagation.
 * 
 * In our program if there is a possibility of raising checked exception then
 * compulsory we should handle that checked exception. otherwise, we'll get
 * compile time error saying unreported exception XXXX; must be caught or
 * declared to be thrown.
 * 
 * Whether a method call needs to be wrapped in a try/catch or whether the
 * enclosing method requires a throws clause depends on the class of the
 * reference and not the class of the actual object.
 * 
 */

public class Demo_F {

	public static void doStuff() throws FileNotFoundException {
		doMoreStuff();
	}

	public static void doMoreStuff() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter("abc.txt");
		printWriter.print("hello");
		printWriter.close();
	}

	public static void main(String[] args) throws InterruptedException {

		// CE: unreported exception java.lang.InterruptedException; must be
		// caught or declared to be thrown

		/**
		 * We can handle this compile time error by using two ways. 1) By using
		 * try-catch:
		 */
		/*
		 * try { Thread.sleep(10000); } catch(InterruptedException e) {
		 * 
		 * }
		 */

		/**
		 * 2) By using Throws keyword:
		 * 
		 * -> We can use throws keyword to delegate responsibility of exception
		 * handling to the caller. (It may be another method or JVM)
		 * 
		 * -> Then caller method is responsible to handle that exception.
		 * 
		 * -> IMPORTANT: Throws keyword required only for checked exceptions and
		 * usage of Throws for unchecked exceptions there is no use or impact.
		 * 
		 * -> Throws keyword require only to convince compiler and usage of
		 * Throws keyword does not prevent abnormal termination of the program.
		 * 
		 * -> It is recommended to use try-catch over Throws keyword.
		 * 
		 */
		Thread.sleep(1000);

		try {
			doStuff();
		} catch (Exception e) {
			// handle exception
		}

		/**
		 * Case 1: We can use Throws keyword for a method and constructor but
		 * not for classes.
		 */

		/**
		 * Case 2: We can use Throws keyword only for Throwable types. otherwise
		 * we'll get compile time error. If we are trying to use for normal java
		 * classes then we'll get compile time error saying incompatible types.
		 */

		/**
		 * Case 3: CE: unreported exception java.lang.Exception; must be caught
		 * or declared to be thrown
		 * 
		 * An exception is checked, therefore compulsory we should handle either
		 * by try-catch or by throws keyword.
		 */

		// throw new Exception();

		// throw new Error();
		/*
		 * RE: exception in thread main java.lang.Error An Error is unchecked,
		 * therefore not required to be handled by try-catch or by throws
		 * keyword.
		 */

		/**
		 * Case 4: In our program if there is no chance of raising an exception
		 * then we can't define catch block for that exception. otherwise we'll
		 * get compile time error. But, this rule is applicable for FULLY
		 * CHECKED exceptions.
		 */

		// CE: exception java.sql.SQLException is never thrown in body of
		// corresponding try statement
		// Because there is no database code any where in try block.
		/*
		 * try { System.out.println("there is no database related code"); }
		 * catch(SQLException e) {
		 * 
		 * }
		 */
	}
}
