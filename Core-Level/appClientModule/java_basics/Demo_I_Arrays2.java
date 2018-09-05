package java_basics;

/**
 * Array Creation:
 * 
 * -> Every array in java is an object only.Hence, we can create array by using
 * new operator.
 * 
 * -> For every array type corresponding classes are available and this classes
 * are part of java language and not available to the programmer level.
 */

public class Demo_I_Arrays2 {

	public static void main(String[] args) {

		int[] a = new int[3];
		System.out.println("Corresponding class for array type:"
				+ a.getClass().getName());

		/**
		 * At the time of array creation compulsory we should specify the size.
		 * otherwise, we will get compile time error.
		 */
		// int b1[]= new int[];
		int[] b2 = new int[10];

		/* It is legal to have an array with size zero. */
		int[] b3 = new int[0];
		System.out.println("Zero size array:" + b3.length);

		/*
		 * If we are specifying array size with some negative integer value then
		 * we'll get runtime exception saying NegativeArraySizeException.
		 */
		// int[] b4=new int[-5];

		/**
		 * To specify array size the allowed data types are byte, short, char
		 * and int.
		 */
		int[] b5 = new int['m'];
		System.out.println("Array size in char:" + b5.length);

		/*
		 * The maximum allowed array size in java is 2147483647, which is the
		 * maximum value of int data type, if we exceed this number then we'll
		 * get compile time error. even we may get runtime exception if
		 * sufficient heap memory not available.
		 */
		// int[] b6=new int[2147483647];

		/**
		 * Two dimensional array creation:
		 * 
		 * In java two dimensional array not implemented by using matrix style,
		 * sun people followed Array of Arrays approach for multi dimensional
		 * array creation.
		 * 
		 * The main advantage of this approach is MEMORY UTILIZATION will be
		 * improved.
		 * */

		// Base size should be specified but If remaining all array size is
		// varied then leave it empty and assign size next.
		int[][] x1 = new int[2][];

		x1[0] = new int[2]; // If we want to store two element
		x1[1] = new int[3]; // If we want to store three element

	}
}
