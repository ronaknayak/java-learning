package java_flow_control;

/**
 * for loop (iterative statement):
 * 
 * When to use:
 * 
 * -> If we know the number of iterations in advance then for loop is the best
 * choice.
 */

public class Demo_E {
	public static void main(String[] args) {

		/**
		 * Curly braces are optional and without having curly braces we can take
		 * only one statement and which should not be declarative.
		 */
		
		for (int i = 0; i < 10; i++)
			;

		for (int i = 0; i < 10; i++)
			System.out.println("hello");

		// for(int i=0;true;i++)
		// System.out.println("This will go infinite");

		// CE: unreachable statement
		// for(int i=0;false;i++)
		// System.out.println("Not able to execute");

		/**
		 * 1) Initialization section:
		 * 
		 * -> This will be executed only once in loop life cycle.
		 * 
		 * -> Here, we can declare and initialize local variables of the for
		 * loop.
		 * 
		 * ->Here, we can declare any number of variables but should be of the
		 * same type. Otherwise, we'll get compile time error.
		 */

		for (int i = 0, j = 10; i < 10; i++)
			System.out.println("Initialization of any number of any variable");

		/**
		 * This part of the for loop does not allow every kind of statement. It
		 * allows only the following statements here: Assignment,
		 * PreIncrementExpression, PreDecrementExpression,
		 * PostIncrementExpression, PostDecrementExpression, MethodInvocation,
		 * and ClassInstanceCreationExpression.
		 */
		int a = 0;
		for (System.out.println("Only once"); a < 3; a++)
			System.out.println("Until all iteration");

		/**
		 * 2) Conditional check:
		 * 
		 * -> Here, we can take any valid java expression but should be of the
		 * type BOOLEAN.
		 * 
		 * -> This part is optional, if we are not taking anything then compiler
		 * will always place true.
		 */
		for (int i = 0;; i++) {
			System.out.println("initialization");
			if (i == 2) {
				break;
			}
		}

		/**
		 * 3) Increment and decrement section:
		 * 
		 * -> This part (i.e. the update part) of the for loop does not allow
		 * every kind of statement. It allows only the following statements
		 * here: Assignment, PreIncrementExpression, PreDecrementExpression,
		 * PostIncrementExpression, PostDecrementExpression, MethodInvocation,
		 * and ClassInstanceCreationExpression.
		 * */

		for (int i = 0; i < 3; System.out.println("incre-decre")) {
			System.out.println("check here");
			i++;
		}

		int c = 0;
		for (System.out.println("init"); c < 3; System.out
				.println("incre/decre")) {
			System.out.println("check here");
			c++;
		}

		/**
		 * -> All 3 parts of the loop are independent to each other.
		 * 
		 * -> All 3 parts are optional.
		 * */

		// Both represents infinite loop.
		// for(;;);
		// for(;;)
		// System.out.println("goes infinite");

		// CE: unreachable statement
		// for (int i = 0; true; i++) {
		// System.out.println("hello");
		// }
		// System.out.println("hi");

		// CE: unreachable statement
		// for (int i = 0; false; i++) {
		// System.out.println("hello");
		// }
		// System.out.println("hi");

		// CE: unreachable statement
		// for (int i = 0; ; i++) {
		// System.out.println("hello");
		// }
		// System.out.println("hi");

		int l = 10, m = 20;
		 for (int i = 0; l<m ; i++) {
		 System.out.println("hello");
		 }
		 System.out.println("hi");

		for (int i = 0; l > m; i++) {
			System.out.println("hello");
		}
		System.out.println("hi");

		final int n = 10, o = 20;

		// CE: unreachable statement
		// for (int i = 0; n > o; i++) {
		// System.out.println("hello");
		// }
		// System.out.println("hi");

		// CE: unreachable statement
		// for (int i = 0; n < o; i++) {
		// System.out.println("hello");
		// }
		// System.out.println("hi");

	}
}
