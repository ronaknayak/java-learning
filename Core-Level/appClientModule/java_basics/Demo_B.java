package java_basics;

/**
 * JAVA IDENTIFIERS:
 * 
 * RULES:
 * 
 * -> The only allowed characters in java identifiers are, a to z, A to Z, 0 to
 * 9, _ and $. if we use any other character then we'll get COMPILE TIME ERROR.
 * convention is that to always begin identifier with letter not by _ or $.
 * 
 * -> Identifiers can't start with digits. Otherwise, we'll get CE.
 * 
 * -> Java identifiers are case sensitive. of course java language itself is
 * case sensitive.
 * 
 * -> There is no length limit for java identifiers. but it's not recommended to
 * take to lengthy identifiers. it is not recommend to use more than 15 length.
 * 
 * -> We can't use reserved words as identifiers.
 * 
 * -> All predefine java class names and interface names we can use as
 * identifiers. but it's not good programming practice because it reduces
 * readability and create confusion.
 */

public class Demo_B {
	public static void main(String[] args) {

		// identifiers can't start with digits.
		String name120 = "ronak";
		System.out.println(name120);

		// java identifiers are case sensitive.
		int NumBer = 10;
		int Number = 20;
		int NUMBER = 30;
		System.out.println(NumBer + " " + Number + " " + NUMBER);

		// all predefine java class names and interface names we can use as
		// identifiers.
		int String = 10;
		System.out.println(String);
		String Runnable = "This is valid declaration.";
		System.out.println(Runnable);
	}
}
