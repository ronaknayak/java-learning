package java_operators;

/**
 * 2) Arithmetic operators (+,-,*,/,%):
 * 
 * -> If we apply any arithmetic operators between two variable a and b the
 * result type is always Max(integer type, type of a, type of b).
 * 
 * byte + byte = int
 * 
 * byte + short = int
 * 
 * short + short = int
 * 
 * byte + long = long
 * 
 * long + double = double
 * 
 * float + long = float
 * 
 * char + char = int
 * 
 * char + double = double
 * 
 * */

public class Demo_B {
	public static void main(String[] args) {

		// If we apply any arithmetic operators between two variable
		System.out.println("Add two characters " + ('a' + 'b'));
		System.out.println("Add char & integral num " + ('a' + 10));
		System.out.println("Add char & floating num " + ('a' + 0.8));

		/**
		 * In integral arithmetic(byte , short, int, long) there is no way to
		 * represent infinity. hence if the infinity is the result we'll get
		 * arithmetic exception in integral arithmetic.
		 */

		// runtime exception- divide by zero
		// System.out.println(10/0);

		/**
		 * But, in floating point arithmetic(float, double) there is a way to
		 * represent infinity. for this Float and Double classes contains the
		 * following two constants POSITIVE_INFINITY & NEGATIVE_INFINITY.
		 * 
		 * hence, even though result is infinity we'll not get any arithmetic
		 * exception in floating point arithmetic.
		 */
		System.out.println("POSITIVE_INFINITY:" + (10.0 / 0));
		System.out.println("NEGATIVE_INFINITY:" + (-10 / 0.0));

		/**
		 * NaN(not a number):
		 * 
		 * In integral arithmetic (byte, short, int, long) there is no way to
		 * represent undefined result. hence we'll get runtime exception.
		 * 
		 * but in floating point arithmetic there is a way to represent
		 * undefined result for this Float & Double classes contains NaN
		 * constants. hence, we'll not get any arithmetic exception in floating
		 * point arithmetic.
		 */

		// runtime exception- divide by zero
		// System.out.println(0/0);
		System.out.println("For undefined result: " + (0 / 0.0));
		System.out.println("For undefined result: " + (-0.0 / 0));
	}
}
