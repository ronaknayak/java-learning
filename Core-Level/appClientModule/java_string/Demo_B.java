package java_string;

/**
 * Immutable String class:
 * 
 * In java String object and all Wrapper objects are immutable.
 */

public class Demo_B {

	static String string = "ronak";

	public static void main(String[] args) {

		/**
		 * Once we create a string object we can't perform any changes in
		 * existing object. If we are trying to perform any changes, with those
		 * changes a new object will be created. This NON-CHANGABLE behavior is
		 * nothing but IMMUTABILITY of string object.
		 * 
		 * For every string constants one object will be created in string
		 * constant pool.So, Here two objects will be created in SCP. i.e.,ronak
		 * and nayak.
		 */
		String string1 = new String("ronak");
		string1.concat(" nayak");
		System.out.println("Immutable string object:" + string1);

		/**
		 * For first case, two objects will be created: One in the Heap area and
		 * other in String Constant Pool. Here,twoObjects will always pointing
		 * to heap object.
		 * 
		 * For second case, only one object will be created in SCP & oneObject
		 * always pointing to that object.
		 * 
		 * Object creation is always optional in SCP & duplicate objects are not
		 * allowed.
		 */
		String twoObjects = new String("Two-Objects");
		String oneObject = "Just matter of one object";

		/**
		 * In string class .equals() method is OVERRIDEN for content compare.
		 * Hence, .equals() returns true if content is same even though objects
		 * are different.
		 */
		String string2 = new String("ronak");
		String string3 = new String("ronak");
		System.out.println(".equals method:" + string2.equals(string3));
		System.out.println("== operator:" + (string2 == string3));

		System.out.println(".equals method(with static):"
				+ string.equals(string3));
		System.out.println("== operator:(with static)" + (string == string3));

		String string4 = "ronak";
		String string5 = "ronak";
		System.out.println(".equals method:" + string4.equals(string5));
		System.out.println("== operator:" + (string4 == string5));

		System.out.println(".equals method(with static):"
				+ string.equals(string5));
		System.out.println("== operator:(with static)" + (string == string5));

		System.out.println(".equals method(with other class static):"
				+ string.equals(Demo_BFirst.string));
		System.out.println("== operator:(with other class static)"
				+ (string == Demo_BFirst.string));

		/**
		 * By using heap object reference If you want to get corresponding SCP
		 * object reference then we should go for intern().
		 * 
		 * A reference to an interned string can be obtained by calling the
		 * intern() method in the String class.
		 */
		String string6 = new String("nayak");
		String strSCPObj = string6.intern();
		String string7 = "nayak";
		System.out.println("intern():" + (string6 == strSCPObj));
		System.out.println("intern():" + (strSCPObj == string7));

		/**
		 * If the corresponding object is not available in SCP then intern()
		 * creates that object and return it.
		 */
		String string8 = new String("nayak");
		String string9 = string8.concat(" ronak");
		String string10 = string9.intern();
		String newStr = "nayak ronak";
		System.out.println("intern():" + (newStr == string10));

		/**
		 * Because of Runtime operation If there is a change in the content then
		 * with those changes a new object will be created on the HEAP.
		 * 
		 * If there is no change in content, existing object only reused.
		 * 
		 * NOTE: Whether the object is present in HEAP or SCP, the rule is same.
		 */
		String s1 = "maitry";
		String s2 = s1.toUpperCase();
		String s3 = s1.toLowerCase();
		String s4 = s2.toUpperCase();
		System.out.println("object reuse:" + (s1 == s2));
		System.out.println("object reuse:" + (s1 == s3));
		System.out.println("object reuse:" + (s2 == s4));

		String s5 = "jiya";
		String s6 = s5.toString();
		System.out.println("object reuse:" + (s5 == s6));

	}
}

class Demo_BFirst {
	static String string = "ronak";
}
