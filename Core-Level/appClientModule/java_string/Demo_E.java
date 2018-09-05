package java_string;

/**
 * StringBuilder:
 * 
 * Every method present in StringBuffer is synchronized. Hence, at a time only
 * one thread is allowed to access StringBuffer object. It increases waiting
 * time of threads and effects performance of the system.
 * 
 * For this SUN people introduced StringBuilder. No method is synchronized in
 * StringBuilder. StringBuilder is thread safe because it can be accessed by
 * multiple threads simultaneously.
 * 
 * It's Non-Synchronized version of StringBuffer. So, relatively performance is
 * high.
 * 
 * StringBuilder is exactly same as StringBuffer including methods and
 * constructors but methods in StringBuilder are not synchronized.
 * 
 * _____________________________________________________________________________
 * 
 * Method Chaining:
 * 
 * For most of the methods in String, StringBuffer & StringBuilder the return
 * types are same type. Hence, After applying a method on the result we can call
 * another method which forms method chaining.
 * 
 * In method chaining all methods will be executed from left to right.
 */

public class Demo_E {

	public static void main(String[] args) {

		// Important StringBuffer methods:

		StringBuffer buffer = new StringBuffer("ronak");
		System.out.println("charAt():" + buffer.charAt(0));
		System.out.println("length():" + buffer.length());
		System.out.println("subString():" + buffer.substring(2));
		System.out.println("replace():" + buffer.replace(3, 5, "nayak"));

		StringBuffer buffer2 = new StringBuffer("ron@k");
		buffer2.setCharAt(3, 'a');
		System.out.println("setCharAt():" + buffer2);

		/**
		 * The overloaded method append() can be used to append characters at
		 * the end of a string buffer.
		 * 
		 * The object argument is converted to a string as if by the static
		 * method call String.valueOf(object), and this string is appended to
		 * the current string buffer.
		 * 
		 * Hence proven, append() is also overloaded for String, int, char,
		 * boolean, double, Object etc.
		 */
		StringBuffer buffer3 = new StringBuffer("ronak DOB:");
		buffer3.append(2121991);
		System.out.println("append():" + buffer3);

		/**
		 * The overloaded method insert() can be used to insert characters at a
		 * given position in a string buffer.
		 * 
		 * The argument is converted, if necessary, by applying the static
		 * method String.valueOf().
		 * 
		 * Hence proven, insert() is also overloaded for String, int, char,
		 * boolean, double, Object etc.
		 */
		StringBuffer buffer4 = new StringBuffer("ronak ");
		buffer4.insert(6, "nayak");
		System.out.println("insert():" + buffer4);

		/**
		 * The following methods can be used to delete characters from specific
		 * positions in a string buffer.
		 * 
		 * start - The beginning index, inclusive.
		 * 
		 * end - The ending index, exclusive
		 * 
		 * Throws: StringIndexOutOfBoundsException - if start is negative,
		 * greater than length(), or greater than end.
		 */
		StringBuffer buffer5 = new StringBuffer("ronak bhojak");
		buffer5.delete(6, 12);
		System.out.println("delete():" + buffer5);
		buffer5.deleteCharAt(5);
		System.out.println("deleteCharAt():" + buffer5);

		StringBuffer buffer6 = new StringBuffer("ronak");
		System.out.println("reverese():" + buffer6.reverse());

		/**
		 * This method ensures that the actual number of characters, i.e., the
		 * length of the string buffer, is exactly equal to the value of the
		 * argument passed in method.
		 * 
		 * The newLength argument must be greater than or equal to 0.
		 * Parameters: newLength - the new length
		 * 
		 * Throws: IndexOutOfBoundsException - if the newLength argument is
		 * negative.
		 */
		StringBuffer buffer7 = new StringBuffer("ronak computer engineer");
		buffer7.setLength(5);
		System.out.println("setLength():" + buffer7);
		buffer7.setLength(14);
		System.out.println("setLength() Again:" + buffer7);

		/**
		 * ensureCapacity() used to increase capacity on fly based on our
		 * requirement.
		 */
		StringBuffer buffer8 = new StringBuffer();
		System.out.print(buffer8.capacity() + "  ");
		buffer8.ensureCapacity(100);
		System.out.println("ensureCapacity():" + buffer8.capacity());

		/**
		 * trimToSize() to release extra allocated free memory.
		 */
		StringBuffer buffer9 = new StringBuffer("Allocate Memory");
		buffer9.ensureCapacity(2000);
		buffer9.append("release memory");
		System.out.print("Current capacity:" + buffer9.capacity());
		buffer9.trimToSize();
		System.out.println(" trimToSize():" + buffer9.capacity());

		// Method Chaining
		StringBuilder builder = new StringBuilder();
		builder.append("We are ").append("going ").insert(13, "for outing a")
				.deleteCharAt(builder.lastIndexOf("a"));
		System.out.println("Result: " + builder);
	}
}
