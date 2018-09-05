package java_access_modifiers;

/**
 * Important Conclusions:
 * 
 * 1) The modifiers which are applicable for inner classes but not for outer
 * classes are private, protected and static.
 * 
 * 2) The modifier which is applicable for class but not for interface is FINAL.
 * All the modifiers which are applicable for inner class also applicable for
 * inner interface except FINAL.
 * 
 * 3) The only modifiers which are not applicable for methods are transient and
 * volatile.
 * 
 * 4) The only modifiers which are not applicable for member variables are
 * abstract, native and synchronized.
 * 
 * 5) The only modifiers which are applicable for constructors are public,
 * private, protected and <DEFAULT> (Only visibility modifiers).
 * 
 */

public class Demo_F {

	/**
	 * The interface which we declare inside a class will always static whether
	 * we declare or not.
	 */
	/*
	 * class A {
	 * 
	 * interface B { } }
	 */

	/**
	 * The interface which we declare inside a interface will always public
	 * static whether we declare or not.
	 */
	/*
	 * interface A {
	 * 
	 * interface B { } }
	 */

	/**
	 * The class which we declare inside a interface will always public static
	 * whether we declare or not.
	 */
	/*
	 * interface A {
	 * 
	 * class B { } }
	 */
}
