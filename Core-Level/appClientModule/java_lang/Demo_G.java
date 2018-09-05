package java_lang;

/**
 * Wrapper classes Utility methods:
 */

public class Demo_G {

	public static void main(String[] args) {
		/**
		 * valueOf():
		 * 
		 * The java string valueOf() method converts different types of values
		 * into string.
		 * 
		 * By the help of string valueOf() method, you can convert int to
		 * string, long to string, boolean to string, character to string, float
		 * to string, double to string, object to string and char Array to
		 * string.
		 * 
		 */
		String string = String.valueOf(10.5);
		System.out.println("valueOf() for any parameter:" + string);
		String string2 = String.valueOf(11001376);
		System.out.println("valueOf() for any parameter:" + string2);
		String string3 = String.valueOf(false);
		System.out.println("valueOf() for any parameter:" + string3);
		String string4 = String.valueOf(new char[] { '2', '0', '1', '6' });
		System.out.println("valueOf() for char array:" + string4);

		/**
		 * * form 1: Every wrapper class except Character class contains a
		 * static valueOf() for converting string to the wrapper object.
		 */
		Integer integer = Integer.valueOf("10");
		System.out.println("valueOf() for string parameter:" + integer);
		// Apart from true & false, if we pass any other string it will return
		// false.
		Boolean boolean1 = Boolean.valueOf("TRUE");
		System.out.println("valueOf() for string parameter:" + boolean1);

		/**
		 * form 2: Every wrapper class including Character class contains the
		 * valueOf() to convert primitive to corresponding wrapper object.
		 */
		Integer integer2 = Integer.valueOf(10);
		System.out.println("valueOf() for primitive parameter:" + integer2);
		Character character = Character.valueOf('c');
		System.out.println("valueOf() for primitive parameter:" + character);

		/**
		 * parseXxx():
		 * 
		 * We can use parseXxx() to convert String to corresponding primitive.
		 * 
		 * Every wrapper class except Character class contains a static
		 * parseXxx() for converting string to corresponding primitive.
		 */
		int i = Integer.parseInt("10");
		System.out.println("parseXxx():" + i);
		long l = Long.parseLong("50");
		System.out.println("parseXxx():" + l);
		Boolean boolean2 = Boolean.parseBoolean("mai hoo na");
		System.out.println("parseXxx():" + boolean2);

		/**
		 * toString():
		 * 
		 * We can use toString() to convert wrapper object or primitive to
		 * string.
		 */

		/**
		 * form 1: Every wrapper class contains the toString() to convert
		 * wrapper object to string type.
		 */
		Integer integer3 = new Integer(100);
		System.out.println("toString():" + integer3.toString());
		
		/**
		 * form 2: Every wrapper class contains the static toString() to convert
		 * primitive to string form.
		 */
		String str = Boolean.toString(false);
		System.out.println("static toString()" + str);
	}
}
