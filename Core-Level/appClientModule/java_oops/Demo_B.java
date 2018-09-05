package java_oops;

import java.io.IOException;

/***
 * Method Overriding:
 * 
 * Whatever methods Parent class defines by default available to the Child class
 * through Inheritance. If a Child class not satisfied with Parent class
 * implementation then Child is allowed to redefine that method based on it's
 * requirement. This process is called Method Overriding.
 * 
 * Method overriding is used to provide specific implementation of a method that
 * is already provided by its super class. When we don't want to go with Parent
 * class method by Inheritance, we should go for Method Overriding.
 * 
 * 
 * RULES:
 * 
 * In overriding method must have the same name as parent class method name,
 * method must have same number of parameters, method must have same types of
 * parameters. i.e. method SIGNATURE must be same
 * 
 * If child class overrides method with different parameters, It'll be treated
 * as separate method for that class. i.e. OVERLOADED method
 * 
 * Return type should be same or CO-VARIANT type. But, this concept is
 * applicable only for object types but not for primitive types.
 * 
 * 
 * SALIENT NOTE: Whenever we are creating child class object parent object won't
 * be created, just parent class constructor will be called for some
 * instantiation purpose.
 * 
 * ****************************************************************************
 * 
 * Why method overriding is called Runtime POLYMORPHISM or Dynamic POLYMORPHISM
 * or Late BINDING ?
 * 
 * Parent p = new Child(); p.methodCall();
 * 
 * At compile time, based on parent reference it figure out that whether
 * methodCall() is available.
 * 
 * Let's assume it's available. At runtime based on what object we are creating,
 * JVM invoke methodCall().
 * 
 * So, In method overriding method resolution is based on what object we are
 * passing at runtime.
 */

public class Demo_B {

	/**
	 * Case: 1) According to COVARIANT type, child method return type need not
	 * to be same as parent method return type. It's child type is allowed.
	 */
	public Object checkReturnType() {
		return "";
	}

	// Otherwise, we'll get CE
	public Integer checkReturnType(Integer i) {
		return 0;
	}

	/**
	 * Case: 2) COVARIANT return type is only applicable for Object type but not
	 * for primitive types. Otherwise, we'll get CE.
	 */
	public double checkReturnType(double i) {
		return 0;
	}

	/**
	 * Case: 3) We can't override parent class final method but we can use it as
	 * it is. If we are trying to override we'll get compile time error.
	 */
	public final String checkReturnType(String str) {
		return "";
	}

	/**
	 * Case: 4) Parent class private methods not available to the child and
	 * hence, overriding concept is not applicable for private methods.
	 * 
	 * Based on our requirement we can define exactly same private method in
	 * child class. It's valid but not overriding.
	 * 
	 */
	private void checkModifier(int i) {
		// parent class specific functionality
	}

	/**
	 * Case: 5) Parent class abstract method we have to compulsory override in
	 * Child class to provide implementation.
	 * 
	 * Now the case, where we can override parent class non-abstract method as
	 * abstract in child class to stop parent class implementation available to
	 * the child classes.
	 */
	public char checkModifier(char ch) {
		return 0;
	}

	/**
	 * Case: 6) NATIVE, SYNCHRONIZED, STRICTFP won't play any restrictions in
	 * overriding.
	 */

	/**
	 * Case: 7) While overriding we can't decrease scope of the methods but we
	 * can increase the scope.
	 * 
	 * private > default > protected > public
	 * 
	 * Internal Reason: Outside package classes may use your OVERRIDED method as
	 * per their requirement.So, to allow this we can keep scope as same as
	 * Parent class or we can increase scope.
	 * 
	 * FOR INTERFACE: This rule is also applicable in case of interface.
	 */
	protected Number checkModifier(Number number) {
		return 0;
	}

	/**
	 * Case: 8) If child class method throws some checked exception then
	 * compulsory parent class method should throw SAME checked exception or
	 * it's PARENT class.
	 * 
	 * Otherwise we'll get CE.
	 * 
	 * NOTE: But, there is no rule for UNCHECKED Exception.
	 * 
	 * Child class may throw only those exceptions that are declared in the
	 * throws clause of the superclass's method or exceptions that are
	 * subclasses of the declared exceptions. It may also choose NOT to throw
	 * any exception.
	 * 
	 * CONCLUSION: While overriding method we can't increase the exception
	 * level.
	 * 
	 * *******************************************************************
	 * 
	 * Internal Reason:
	 *
	 * Parent p = new Child();
	 * 
	 * While calling method we have to handle exception either by throws or by
	 * try-catch. & what exceptions we should handle it depends on reference we
	 * use to call method. So, If child class method throws exception other than
	 * same exception or it's sub class then at runtime it's problematic to call
	 * child class method.
	 */
	public void checkThrowsClause() throws Exception {
	}

	public void checkThrowsClause(int i) throws IOException {
	}

	public void checkThrowsClause(String s) throws IOException {
	}

	/**
	 * Case: 9) We can't override static method as non-static method. Because we
	 * can't override class level method as object level method.
	 * 
	 * Similarly, we can't override non-static method as static method. Because
	 * we can't override object level method as class level method.
	 * 
	 * If both parent and child class method declared as static then we won't
	 * get any CE. It seems overriding concept applicable for static methods but
	 * it's not & It's METHOD HIDING.
	 * 
	 * *********************************************************************
	 * 
	 * In METHOD HIDING Parent class method hides Child class method as both
	 * OVERRIDEN & OVERRIDING methods are static. So, compiler is responsible
	 * for method resolution based on reference.
	 * 
	 * Parent p = new Child();
	 * 
	 * Child c = new Child();
	 * 
	 * In overriding, for both above cases only child class method will get
	 * call. But, In method hiding for first case always parent class method get
	 * called. Hence, proven why it's method hiding.
	 */
	public static void checkStaticMethod() {
		System.out.println("parent class");
	}

	public void checkStaticMethod(int i) {
	}

	/**
	 * Case: 10) We can't override a VAR-ARG method with general method. If we
	 * are trying to override it will become OVERLOADING but not overriding.
	 * 
	 * A VAR-ARG method should be override with VAR-ARG method only.
	 */
	public void checkVarArg(String s, int... a) {
		System.out.println("parent class method in case of VAR-ARG");
	}

	/**
	 * Case: 11) Overriding concept is not applicable for VARIABLES.
	 * 
	 * Reason: Variables resolution always takes care by compiler based on
	 * reference type. Runtime object won't play any role in variable
	 * resolution.
	 * 
	 * NOTE: Whether the variables are static or instance there is no change in
	 * result.
	 */
}
