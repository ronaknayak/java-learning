package java_string;

/**
 * Important methods of String class:
 */
public class Demo_C {

	public static void main(String[] args) {

		String string = "java";
		System.out.println("charAt():" + string.charAt(0));
		// RE: StringIndexOutOfBoundException
		// System.out.println("charAt():"+string.charAt(4));

		string = string.concat(" tech");
		System.out.println("concat():" + string);

		String userName = "ronnayak";
		String password = "Ronak8699";
		System.out.println("equals(): " + password.equals("ronak8699"));
		System.out.println("equalsIgnoreCase(): "
				+ userName.equalsIgnoreCase("RONNAYAK"));
		/**
		 * NOTE: In general we can use equalsIgnoreCase() to validates user name
		 * where case is not important whereas we can use equals() to validate
		 * password where case is important.
		 */

		System.out.println("subString():" + string.substring(5));

		/**
		 * NOTE: returns subString from begin index to end-1 index.
		 */
		System.out.println("subString():" + string.substring(5, 8));

		/**
		 * There are 2 points to remember:
		 * 
		 * 1. replace() method creates a new String object.
		 * 
		 * 2. replace() method returns the same String object if both the
		 * parameters are same, i.e. if there is no change.
		 */
		String string2 = "android tech";
		System.out.println("replace():" + string2.replace('t', 'T'));
		System.out.println("replace():" + string2.replace("android", "iPhone"));

		System.out
				.println("replace(): diff obj " + string2.replace('t', 'T') == string2
						.replace('t', 'T'));
		System.out
				.println("replace(): same obj " + string2.replace('t', 't') == string2);
		
		String eI = "eanfochaps";
		System.out.println("replaceAll():" + eI.replaceAll("a", "i"));

		/**
		 * indexOf() returns -1, if specified character or string does not find.
		 */
		String string3 = "new year new";
		System.out.println("indexOf():" + string3.indexOf("new") + " "
				+ string3.indexOf("year"));
		System.out.println("indexOf():" + string3.indexOf("new", 5) + " "
				+ string3.indexOf('n', 5));
		System.out.println("lastIndexOf():" + string3.lastIndexOf("new"));
		
		String string4 = "hey,mate";
		System.out.println("contains():" + string4.contains("mate"));

		String string5 = "\t\n Java Nation \n\t ";
		string5 = string5.trim();
		System.out.println("trim():" + string5);

		String string6 = "happy birth day";
		String[] strArray = string6.split(" ");
		System.out.println("split():" + strArray[0] + " " + strArray[1] + " "
				+ strArray[2]);

		/**
		 * compareTo() does a lexicographical (like a dictionary) comparison. It
		 * stops at the first place where the strings have different letters.
		 * 
		 * If left hand side is bigger, it returns a positive number otherwise
		 * it returns a negative number. The value is equal to the difference of
		 * their UNICODE values. If there is no difference then it returns zero
		 */
		String string7 = "Ronak";
		String string8 = "ronak";
		System.out.println("compareTo():" + (string7.compareTo(string8)));

		String string9 = "happy birth day";
		System.out.println("startsWith():" + string9.startsWith("happy")
				+ " endsWith():" + string9.endsWith("day"));

		String string10 = "";
		System.out.println("isEmpty():" + string10.isEmpty());

		/**
		 * This method converts different types of values into string.
		 */
		System.out.println("valueOf():"
				+ String.valueOf(new char[] { 'R', 'o', 'n', 'a', 'k' }));
	}
}
