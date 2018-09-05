package java_string;

/**
 * StringBuffer class:
 * 
 * Where String concept is not up to the mark ? If there is any requirement that
 * content will change frequently then it's never recommended to go for String
 * class. Because for every change compulsory a new object will be created.
 * 
 * For this should go for StringBuffer where all the changes will be performed
 * in EXISTING OBJECT instead of creating new object.
 * 
 * Every method in StringBuffer is synchronized. So StringBuffer object is
 * thread safe and because of this in MULTI-THREADED environment StringBuffer
 * object can be accessed by one thread at a time.
 * 
 * NOTE: String, StringBuffer and StringBuilder classes, these are independent
 * final classes, they directly extending the Object class. Hence, String
 * references cannot be stored (or cast) to StringBuffer and StringBuilder
 * references, and vice versa.
 */

public class Demo_D {

	public static void main(String[] args) {

		/**
		 * Once we create a StringBuffer object we can perform any changes in
		 * the existing object. This behavior is nothing but MUTABILITY of
		 * StringBuffer object.
		 */
		StringBuffer buffer = new StringBuffer("ronak");
		buffer.append(" nayak");
		System.out.println("StringBuffer object:" + buffer);

		/**
		 * In StringBuffer does not have .equals(). so, it override object class
		 * .equals() method which is meant for reference compare.
		 */
		StringBuffer buffer2 = new StringBuffer("ronak");
		StringBuffer buffer3 = new StringBuffer("ronak");
		System.out.println("== operator:" + (buffer2 == buffer3));
		System.out.println(".equals():" + (buffer2.equals(buffer3)));

		/**
		 * StringBuffer constructor:
		 * 
		 * 1) Creates an empty StringBuffer object with initial capacity 16.
		 * Once StringBuffer reaches it's max capacity a new object will be
		 * created with new capacity = (current capacity * 2) + 1.
		 */
		StringBuffer buffer4 = new StringBuffer();
		System.out.println("Initial capacity:" + buffer4.capacity());

		/**
		 * 2) Creates an empty StringBuffer object with specified initial
		 * capacity.
		 */
		StringBuffer buffer5 = new StringBuffer(20);
		System.out.println("Initial capacity:" + buffer5.capacity());

		/**
		 * 3) Creates an equivalent StringBuffer object for the given string
		 * with, capacity = 16 + string.lenght().
		 */
		StringBuffer buffer6 = new StringBuffer("Sunday");
		System.out.println("Initial capacity:" + buffer6.capacity());

		/**
		 * If a reference variable declared as the final then we can't assign
		 * that reference variable again to some other object.
		 */
		final StringBuffer buffer7 = new StringBuffer("Monday");
		// CE: The final local variable can't be assigned.
		// buffer7 = new StringBuffer("Tuesday");

		/**
		 * Declaring a reference variable as final won't get any immutable in
		 * nature, in the corresponding object we can perform any type of
		 * changes even though reference variable declared as final.
		 * 
		 * Hence, final variable and immutable nature both are different
		 * concepts.
		 */
		final StringBuffer buffer8 = new StringBuffer("Monday");
		buffer8.append(" start to work");
		System.out.println("final reference variable:" + buffer8);
	}
}
