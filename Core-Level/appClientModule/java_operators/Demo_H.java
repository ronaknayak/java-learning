package java_operators;

/**
 * 10) Short circuit operator (&&, ||) :
 * 
 * -> We can use these operators just to improve the performance of the system.
 * 
 * i)x & y -> y will be evaluated even if x is false.
 * 
 * x && y -> y will be evaluated if x is true.
 * 
 * 
 * ii) x | y -> y will be evaluated even if x is true.
 * 
 * x || y -> y will not be evaluated if x is true.
 * 
 * 
 * 11) Type-cast operator:
 * 
 * -> Whenever we assign bigger data type value to the smaller data type then we
 * required explicit type casting.
 * 
 * -> Programmer is responsible to do explicit type casting.
 * 
 * -> There may be a chance of LOSS OF INFORMATION in this type casting.
 * 
 * -> Whenever we assign bigger data type value to the smaller data type
 * variable by explicit type casting the most significant bit will be lost. we
 * have to consider only least significant bits.
 * 
 * -> If we assign floating point values to the integral types by explicit type
 * casting the digits after the decimal point will be lost.
 * */

public class Demo_H {
	public static void main(String[] args) {

		int x = 150;

		// CE: possible loss of information
		// byte b = x;

		byte b = (byte) x;
		short c = (short) x;
		System.out.println("int type to short: " + c);
		System.out.println("int type to byte: " + b);

		double d = 130.45;
		int i = (int) d;
		System.out.println("double type to int " + i);

	}
}
