package java_basics;

/**
 * Array Initialization:
 * 
 * -> Once we create an array every element by default initialized with default
 * values.
 */

public class Demo_I_Arrays3 {

	public static void main(String[] args) {

		int[] a = new int[3];

		/**
		 * whenever we try to print any object reference internally toString()
		 * will be call which is implemented by default to return the string as
		 * below, className@hexadecimal_string_of_hashcocde
		 */
		System.out.println("One dim array object reference:" + a);
		System.out.println("Default value for array element:" + a[0]);

		int[][] b = new int[3][2];

		// b is two dim array reference
		System.out.println("Two dim array reference:" + b);
		// b[0] is one dim array reference
		System.out.println("One dim array object reference:" + b[0]);
		// b[0][0] is 0.
		System.out.println("Default value for array element:" + b[0][0]);

		/**
		 * Once we create an array every element in array initialized with
		 * default values. If we are not satisfied with default values then we
		 * can override those values with our customized values.
		 */
		int[] c = new int[3];
		c[0] = 10;
		c[1] = 20;
		c[2] = 30;
		// If we try to access an array with out of index range, we'll get
		// runtime exception ArrayIndexOutOfBoundException.
		// c[8]=50;

		/**
		 * Declaration, creation and initialization in a single line:
		 * 
		 * We can declare, create and initialize an array in single line.
		 * 
		 * We can extend this for multi dimensional array also.
		 */
		int[] d = { 10, 20, 30 };
		System.out.println("One dim array in single line:" + d[2]);

		int[][] mulDim = { { 10, 20, 30 }, { 40 }, { 50, 60 } };

		System.out.println("Two dim array in single line:");
		System.out.println(mulDim[0][0]);
		System.out.println(mulDim[0][1]);

		System.out.println(mulDim[1][0]);

		System.out.println(mulDim[2][0]);
		System.out.println(mulDim[2][1]);

		/**
		 * If we want to use this shortcut compulsory we should perform
		 * Declaration, creation and initialization in a single line.
		 * 
		 * If we are using multi lines we'll get CE: Illegal start of
		 * expression.
		 */
		int[] shortArray;
		// shortArray = {1,2,3,4,5};
	}

}
