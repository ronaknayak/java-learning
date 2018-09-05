package java_operators;

/**
 * 1) Increment and decrement operators:
 * 
 * pre-increment: first increment and after assign. e.g. x=++y post-increment:
 * first assign and after increment. e.g. x=y++
 *
 * pre-decrement: first decrement and after assign. e.g. x=--y post-increment:
 * first assign and after decrement. e.g. x=y--
 * 
 */

public class Demo_A {

	public static void main(String[] args) {

		int a = 10;
		int b = ++a;
		System.out.println("Pre-increment: a=" + a + " b=" + b);

		int i = 10;
		int j = i++;
		System.out.println("Post-increment: i=" + i + " j=" + j);

		/**
		 * we can apply increment & decrement operators only for variables but
		 * not for CONSTANT values. If we apply constant value then we'll get
		 * compile time error.
		 */
		int c = 10;
		// compile time error:unexpected type
		// int d=++10;

		/**
		 * Nesting of increment & decrement operators are not allowed or else
		 * we'll get CE.
		 */
		int e = 10;
		// compile time error:unexpected type
		// int f = ++ (++e);

		/** For final variables we can't apply increment & decrement operators. */
		final int g = 10;
		// compile time error:can't assign a value to a final variable g
		// int h = g++;

		/**
		 * we can apply increment and decrement operators for every primitive
		 * type except boolean type.
		 */
		boolean isValid = true;
		// compile time error: operator ++ can't be applied to a boolean
		// isValid++;

		char ch = 'c';
		ch++;
		System.out.println("Character increment: " + ch);

		double k = 10.5;
		k++;
		System.out.println("Double increment " + k);

		/**
		 * Standard Rule: If we apply any arithmetic operators(+, *, -, /, %)
		 * between two variables the result type is always Max(integer type,
		 * type of 1st argument, type of 2nd argument)
		 */

		byte xi = 10;
		byte yi = 20;
		// compile time error:possible loss of precision because here, both
		// values
		// are of byte and max(int, byte, byte) is int.so, it give result in
		// integer.
		// byte zi=xi+yi;

		byte by = 10;
		by++;
		// compile time error:possible loss of precision
		// by = by+1;

		// To avoid this compile time error should perform TYPE CASTING
		byte zi = (byte) (xi + yi);
		by = (byte) (by + 1);
		System.out.println("Type casting " + zi + " " + by);

		/**
		 * but in the case of increment and decrement operators internal type
		 * casting performed automatically. 
		 * 
		 * b++ => b=(type of b)(b+1);
		 */

	}

}
