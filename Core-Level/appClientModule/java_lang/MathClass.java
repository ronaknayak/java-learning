package java_lang;

public class MathClass {

	public static void main(String[] args) {

		int i = 7;
		int j = -9;
		double x = 72.3;
		double y = 0.34;
		double z = 1.5;

		/**
		 * The Math.abs() function returns the absolute value of the parameter
		 * passed to it. The absolute value is the positive value of the
		 * parameter. If the parameter value is negative, the negative sign is
		 * removed and the positive value corresponding to the negative value
		 * without sign is returned.
		 */
		System.out.println("|" + i + "| is " + Math.abs(i));
		System.out.println("|" + j + "| is " + Math.abs(j));
		System.out.println("|" + x + "| is " + Math.abs(x));
		System.out.println("|" + y + "| is " + Math.abs(y));

		/**
		 * The Math.random() method returns a random floating point number
		 * between 0.0 and 1.0
		 * 
		 * To get a random value between 0 and e.g. 100, multiply the value
		 * returned by Math.random() with the maximum number (e.g. 100).
		 */
		double random = Math.random();
		System.out.println("random num: " + random);
		random = Math.random() * 50;
		System.out.println("random num: "+random);
		/**
		 * The Math.round() method rounds a float or double to the nearest
		 * integer using normal math round rules (either up or down).
		 */
		System.out.println(x + " is approximately " + Math.round(x));
		System.out.println(y + " is approximately " + Math.round(y));
		System.out.println(y + " is approximately " + Math.round(z));

		/**
		 * The Math.ceil() function rounds a floating point value up to the
		 * nearest integer value. The rounded value is returned as a double.
		 */
		System.out.println("The ceiling of " + i + " is " + Math.ceil(i));
		System.out.println("The ceiling of " + j + " is " + Math.ceil(j));
		System.out.println("The ceiling of " + x + " is " + Math.ceil(x));
		System.out.println("The ceiling of " + y + " is " + Math.ceil(y));

		/**
		 * The Math.floor() function rounds a floating point value down to the
		 * nearest integer value. The rounded value is returned as a double.
		 */
		System.out.println("The floor of " + i + " is " + Math.floor(i));
		System.out.println("The floor of " + j + " is " + Math.floor(j));
		System.out.println("The floor of " + x + " is " + Math.floor(x));
		System.out.println("The floor of " + y + " is " + Math.floor(y));

		/**
		 * The Math.min() method returns the smallest of two values passed to it
		 * as parameter.
		 */
		System.out.println("min(" + i + "," + j + ") is " + Math.min(i, j));
		System.out.println("min(" + x + "," + y + ") is " + Math.min(x, y));
		System.out.println("min(" + i + "," + x + ") is " + Math.min(i, x));
		System.out.println("min(" + y + "," + j + ") is " + Math.min(y, j));

		/**
		 * The Math.max() method returns the largest of two values passed to it
		 * as parameter.
		 */
		System.out.println("max(" + i + "," + j + ") is " + Math.max(i, j));
		System.out.println("max(" + x + "," + y + ") is " + Math.max(x, y));
		System.out.println("max(" + i + "," + y + ") is " + Math.max(i, y));
		System.out.println("max(" + y + "," + j + ") is " + Math.max(y, j));

		/**
		 * The Math.sqrt() method calculates the square root of the parameter
		 * given to it.
		 */
		double sqrt4 = Math.sqrt(4);
		System.out.println("sqrt4 = " + sqrt4);

		/**
		 * The Math.pow() function takes two parameters. The method returns the
		 * value of the first parameter raised to the power of the second
		 * parameter.
		 */
		double pow2 = Math.pow(2, 2);
		System.out.println("pow2 = " + pow2);

		double pow8 = Math.pow(2, 8);
		System.out.println("pow8 = " + pow8);

	}
}
