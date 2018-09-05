package java_string;

/**
 * String class:
 * 
 * The String class implements immutable character strings. Once the string has
 * been created and initialized we can't perform any change in existing object,
 * whereas the StringBuilder class implements dynamic character strings. The
 * StringBuffer class is a thread-safe version of the StringBuilder class.
 */

public class Demo_A {

	public static void main(String[] args) {

		/**
		 * Creating and initializing string:
		 * 
		 * Using string literal:
		 * 
		 * A string literal is a reference to a string object.
		 */
		String str1 = "you can't change me";

		/**
		 * only one String object is shared by all string valued constant
		 * expressions with the same character sequence. Such strings are said
		 * to be interned, meaning that they share a unique String object if
		 * they have the same content.
		 * 
		 * The String class maintains a private pool(String Constant Pool) where
		 * such strings are interned.
		 * 
		 * Because of some Runtime operation, If an object is required to create
		 * that object will be placed only in the Heap area, but not in SCP
		 * area. Because, SCP only contains only String CONSTANTS.
		 * 
		 * e.g. s = s.toUpperCase();
		 */
		String str2 = "you can't change me";
		String str3 = "you can't" + " change me";
		System.out.println(str1.hashCode() + " and " + str2.hashCode()
				+ " and " + str3.hashCode() + " are equal.");
		System.out.println("Reuse same object: " + (str2 == str3));

		/**
		 * If at least one argument is string type then + operator act as
		 * concatenation operator and if both arguments are number type then +
		 * operator act as arithmetic addition operator.
		 */
		String str4 = 7 + "up";
		System.out.println("string concat: " + str4);

		/**
		 * String Constructors:
		 * 
		 * The String class has numerous constructors to create and initialize
		 * String objects based on various types of arguments.
		 * 
		 * Note that using a constructor creates a brand new String object,
		 * i.e., using a constructor does not intern the string.
		 */

		/*
		 * 1] This constructor creates a new String object, whose content is the
		 * empty string "". In this case two objects will be created, one in
		 * Heap area and in SCP.
		 */
		String str5 = new String();
		System.out.println("empty string:" + str5);

		/*
		 * 2] This constructor creates a new String object, whose contents are
		 * the same as those of the String object passed as argument.
		 */
		String str6 = new String("you can't change me");

		String words = " change me";
		String strWords = "you can't" + words;
		String strWordsDiff = "you can't change me";
		System.out.println("new string object:" + (strWords == str6));
		// Because at runtime words can contain any string.
		System.out.println("new string object:" + (strWords == strWordsDiff));
		// It would be OK if we intern words earlier,
		System.out.println("new string object: (interned)"
				+ (strWords.intern() == strWordsDiff));

		/*
		 * 3] Creates an equivalent String object for the given char[] array.
		 * 
		 * These constructors create a new String object whose contents are
		 * copied from a char array.
		 */
		char[] ch = { 'a', 'b', 'c', 'd' };
		String str7 = new String(ch);
		System.out.println("passed char array:" + str7);
		byte[] b = { 65, 66, 67 };
		String strByte = new String(b);
		System.out.println("passed byte array:" + strByte);

		/*
		 * 4] Creates an equivalent String object for given StringBuffer and
		 * StringBuilder class.
		 */
		String str8 = new String(new StringBuffer("string-buffer"));
		System.out.println("Pass StringBuffer object:" + str8);
		String str9 = new String(new StringBuilder("string-builder"));
		System.out.println("Pass StringBuilder object:" + str9);
	}
}
