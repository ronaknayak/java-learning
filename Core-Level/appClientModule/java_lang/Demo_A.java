package java_lang;

/**
 * For writing any Java program whether it is simple or complex, the most
 * commonly required classes & interfaces are grouped into a separate package,
 * which is nothing but java.lang package.
 * 
 * We are not required to import java.lang package explicitly because all
 * classes & interfaces present in java.lang package by default available to
 * every Java program.
 * 
 * 
 * java.lang.Object:
 * 
 * The most commonly required methods for every Java class are define in a
 * separate class which is nothing but Object class.
 * 
 * Every class in java is the child class of Object class either directly or
 * indirectly. So that every methods of object class by default available to
 * every java class.
 * 
 * Hence, Object class is considered as root of all Java classes.
 * 
 * java.lang package is automatically imported into every source file at compile
 * time. The package contains the Object class that is the superclass of all
 * classes.
 * 
 * The java.lang package also contains classes that provide the standard input,
 * output, and error streams (System), string handling (String, StringBuilder,
 * StringBuffer), and mathematical functions (Math) and the Wrapper classes
 * (Boolean, Character, Byte, Short, Integer, Long, Float, Double) used to
 * handle primitive values as objects.
 * 
 * If our class does not extends any other class then only our class is direct
 * child class of Object class. If our class extends any other class then our
 * class is not direct child of Object class. It extends object class
 * indirectly.
 * 
 * Conclusion:
 * 
 * Either directly or indirectly Java won't provide support for multiple
 * inheritance with respect to classes.
 * 
 * 
 * 
 * 1) toString():
 * 
 * To get string representation of an object then we should go for toString()
 * method.
 * 
 * Whenever we trying to print our class object reference toString() called
 * internally.
 * 
 * If our class does not contain toString() then Object class toString() called
 * internally.
 * 
 * Object class to toString() is implemented as follows:
 * 
 * public String toString() {
 * 
 * return getClass().getName() + "@" + Integer.HexString(hashCode()); }
 * 
 * Based on our requirement we can override toString() to provide our own string
 * representation & it's HIGHLY RECOMMENDED.
 */

public class Demo_A {

	String firstName;
	String lastName;

	public Demo_A() {

	}

	public Demo_A(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	public static void main(String[] args) {

		Demo_A a = new Demo_A("Ronak", "Nayak");
		System.out.println("Object reference:" + a);
		System.out.println("Object reference:" + a.toString());

	}
}
