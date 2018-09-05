package java_flow_control;

/**
 * switch (selection statement):
 * 
 * -> If several options are available then it is not recommended to use nested
 * if else statement. Because it reduces readability of the code.
 * 
 * To handle this requirement we should go for switch statement.
 * 
 * -> The allowed argument types for the switch statement are BYTE, SHORT, CHAR
 * and INT until 1.4 version.
 * 
 * But from 1.5 version onwards corresponding WRAPPER CLASSES (Integer, Character, Short, Byte)
 * and ENUM type also allowed.
 * 
 * From 1.7 version onwards STRING type also allowed.
 * */

public class Demo_B {
	public static void main(String[] args) {

		/**
		 * Curly braces are mandatory. Except switch everywhere in java curly
		 * braces are optional. Both case and default are optional.
		 */
		int x = 10;
		switch (x) {

		}

		int y = 10;
		// Compile time error: case, default or } expected.
		// switch (y) {
		// System.out.print("hello");
		// }

		/**
		 * Every case label should be compile time CONSTANT(i.e. constant
		 * expression) else will get CE: constant expression required.
		 * 
		 * If we declare y as final then we won't get compile time error,
		 * because it becomes CONSTANT.
		 */

		final int z = 1;
		switch (z) {
		case z:
			System.out.println("Final case label.");
			break;

		// case y:
		// System.out.println("hi");
		// break;
		}

		/**
		 * Both switch argument and a case label can be expressions. but case
		 * label should be constant expression.
		 */

		switch (x + 1) {
		case 1:
			System.out.println("Expressions as an argument");
			break;

		case 2 + 4 + 5 * 1:
			System.out.println("Expressions as an argument-------");
			break;
		}

		/**
		 * Duplicate case labels are not allowed. otherwise we'll get compile
		 * time error.
		 */

		// switch (x) {
		// case 97:
		// System.out.println("hello");
		// break;
		//
		// case 98:
		// System.out.println("hi");
		// break;
		//
		// case 'a':
		// System.out.println("hey");
		// break;
		// }

		/**
		 * Fall-through inside switch:
		 * 
		 * -> Within the switch if any case is matched, from that case onwards
		 * all statements will be executed until break or end of the switch.
		 * This is called fall-through inside switch.
		 * 
		 * -> The main advantage of fall-through inside a switch is we can
		 * define common action for multiple cases. So, it gives code
		 * REUSABILITY.
		 * */
		Byte month = 2;

		switch (month) {
		case 1:
		case 2:
		case 3:
			System.out.println("Quarter 1");
			break;

		case 4:
		case 5:
		case 6:
			System.out.println("Quarter 2");
			break;

		case 7:
		case 8:
		case 9:
			System.out.println("Quarter 3");
		default:
			System.out.println("Last Quarter");
			break;
		}

		/**
		 * default case:
		 * 
		 * -> We use it to define default action. This case will be executed
		 * when no other case is matched.
		 * 
		 * -> We can take default case anywhere within the switch but it is
		 * recommended to write as last case.
		 * */
		int iCase = 1;
		switch (iCase) {
		default:
			System.out.println("Default action");
			break;
		case 0:
			System.out.println("Good case");
			break;
		case 1:
			System.out
					.println("If we forget break statement then next case will be executed.");
		case 2:
			System.out.println("To stop we have to put break statement.");
			break;
		case 3:
			System.out.println("Better case");
		}
	}
}
