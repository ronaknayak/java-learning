package java_exception_handling;

/**
 * finally block:
 * 
 * -> This block is always associated with try-catch block to maintain cleanup
 * code which should be executed irrespective of whether exception raised or not
 * and whether handled or not.
 */

public class Demo_D {

	/**
	 * Various possible combinations of try-catch-finally:
	 * 
	 * -> In try-catch-finally order is important.
	 * 
	 * -> Whenever we write try compulsory we should write either catch or
	 * finally.
	 * 
	 * -> Whenever we write catch compulsory we should write try.
	 * 
	 * -> Whenever we write finally compulsory we should write try.
	 * 
	 * -> Inside try-catch-finally we can declare try-catch-finally. That means
	 * NESTING of try-catch-finally is allowed.
	 * 
	 * -> For try-catch-finally block curly braces are mandatory.
	 */

	public static void combinationsTryCatchFinally() {

		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println(0);
		// }

		// try
		// {
		// String s = null;
		// System.out.println(s.compareTo("eIPL"));
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println(0);
		// }
		// catch (Exception e) {
		// System.out.println("Default handling code");
		// }

		/* CE: exception ArithmeticException has already been caught. */
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(Exception e) {
		// //handling code
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println(1);
		// }

		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println(0);
		// }
		// finally
		// {
		// System.out.println("always executed");
		// }

		// try
		// {
		// System.out.println(10/0);
		// }
		// finally
		// {
		// System.out.println("close database connection resources");
		// }

		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println(0);
		// }
		// try
		// {
		// System.out.println(10/0);
		// }
		// finally
		// {
		// System.out.println("close database connection");
		// }

		// CE: try without catch or finally
		// try
		// {
		// System.out.println(10/0);
		// }

		// CE: catch without try
		// catch (Exception e) {
		// // handle exception
		// }

		// CE: finally without try
		// finally {
		//
		// }

		// CE: catch without try
		// try
		// {
		// System.out.println(10/0);
		// }
		// finally
		// {
		// System.out.println("close database connection");
		// }
		// catch (Exception e) {
		// //handle exception
		// }

		// CE: try without catch or finally
		// CE: catch without try
		// try
		// {
		// System.out.println(10/0);
		// }
		// System.out.print("");
		// catch (Exception e) {
		// //handle exception
		// }

		// CE: catch without try
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (ArithmeticException e) {
		// //handle exception
		// }
		// System.out.print("hello");
		// catch (Exception e) {
		// //handle exception
		// }

		// CE: finally without try
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (ArithmeticException e) {
		// //handle exception
		// }
		// System.out.print("hello");
		// finally {
		//
		// }

		// try
		// {
		// //System.out.println(10/0);
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (Exception e)
		// {
		// System.out.println("inner catch");
		// }
		// }
		// catch (Exception e) {
		// System.out.println("outer catch");
		// }

		// CE: try without catch or finally
		// try
		// {
		// System.out.println(10/0);
		// try
		// {
		// System.out.println(10/0);
		// }
		// }
		// catch (Exception e) {
		// //handle exception
		// }

		// try
		// {
		// System.out.println("try code");
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(ArrayIndexOutOfBoundsException e) {
		// System.out.println("inner catch");
		// }
		// }
		// catch (Exception e) {
		// System.out.println("outer catch");
		// }

		// try
		// {
		// System.out.println("try code");
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch(Exception e) {
		// System.out.println("inner catch"+(10/0));
		// }
		// System.out.println("simple statement-1");
		// }
		// catch (Exception e) {
		// System.out.println("outer catch");
		// }
		// System.out.println("simple statement-2");

		// try
		// {
		// System.out.println("outer try");
		//
		// try
		// {
		// System.out.println("inner try");
		// }
		// catch(Exception e) {
		// System.out.println("inner catch");
		// }
		// System.out.println(10/0);
		// }
		// catch (Exception e) {
		// System.out.println("outer catch");
		// }
		// System.out.println("simple statement");

		// try
		// {
		// System.out.println("try code");
		// try
		// {
		// System.out.println(10/0);
		// }
		// finally
		// {
		// System.out.println("always executed");
		// }
		// }
		// catch (Exception e) {
		// System.out.println("handling code");
		// }

		// try
		// {
		// System.out.println("outer try");
		// try
		// {
		// System.out.println("inner try");
		// }
		// catch(ArithmeticException e)
		// {
		// System.out.println("inner catch");
		// }
		// finally
		// {
		// System.out.println(10/0);
		// }
		// System.out.println("simple statement");
		// }
		// catch (Exception e) {
		// System.out.println("outer catch");
		// }

		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (Exception e) {
		// try
		// {
		// System.out.println(10/10);
		// }
		// finally
		// {
		// System.out.println("always executed");
		// }
		// }

		// CE: finally without try
		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (Exception e) {
		//
		// finally
		// {
		// System.out.println("always executed");
		// }
		// }

		// try
		// {
		// System.out.println(10/0);
		// }
		// catch (Exception e) {
		// System.out.println("Outer catch");
		// }
		// finally
		// {
		// try {
		// System.out.println("Inner try");
		// } catch (Exception e2) {
		// System.out.println("Inner catch");
		// }
		// }

		// CE: finally without try
		// try
		// {
		// System.out.println(10/0);
		//
		// }
		// catch (Exception e) {
		//
		// }
		// finally
		// {
		// finally {
		//
		// }
		// }

		// CE: finally without try
		// try
		// {
		// System.out.println(10/0);
		//
		// }
		// catch (Exception e) {
		//
		// }
		// finally
		// {
		//
		// }
		// finally
		// {
		//
		// }
	}

	public static void main(String[] args) {
		combinationsTryCatchFinally();
	}
}
