package java_oops_theory;

/**
 * Abstraction:
 * 
 * Abstraction is the process of hiding the internal implementation details and
 * highlight the set of services what we are offering is the concept of
 * Abstraction.
 * 
 * Hiding implementation details means not from user. It hides implementation
 * logic from another class. The other class doesn't need to know about the
 * logic i.e. what services we have called and what SQL queries executing in DAO
 * layer. It simply uses the class/interface without knowing about
 * implementation. Even any update to the logic doesn't require modification of
 * another class. Its called as hiding implementation details.
 * 
 * In java we use print() method without knowing the actual code of print(). So,
 * I would say print() implementation details are abstracted from me.
 * 
 * In general, Abstraction lets you focus on what the object does instead of how
 * it does it.
 * 
 * 
 * ADVANTAGES:
 * 
 * When you change your code that implements an abstraction, the user of the
 * abstraction doesn't have to change their code. This allows the implementation
 * to be changed as the CLASS/INTERFACE will remain consistent.
 * 
 * 
 * 
 * WHEN TO USE ABSTRACT CLASS and INTERFACE ?
 * 
 * > The abstract class purpose is to provide an appropriate superclass from
 * which other classes can inherit and share a code among several closely
 * related classes i.e. CODE REUSABILITY and NEED TO CHANGE ONLY ONE PLACE AT THE
 * TIME OF MAINTANANCE.
 * 
 * The interface describes a set of methods that can be implemented by unrelated
 * classes. For example, Comparable and Runnable are implemented by many
 * unrelated classed.
 * 
 * > In abstract class case, as if we are extending abstract class we lost our
 * chance to extend other class.
 * 
 * But, in case of using interfaces still we can extend other utility class as
 * we are implementing interface.
 * 
 * > We can use abstract class to declare some common non-static and final
 * variables and initialize those variables through abstract class constructor.
 * This way all sub-classes does not need to initialize those variables in their
 * constructors and initialize easily by simply using super(VALUE1, VALUEn)
 * 
 * > We can use interface to take advantage of MULTIPLE INHERITANCE.
 */

public abstract class Bank_Abstraction {

	abstract int getRateOfIntrest();

	public static void main(String[] args) {

		Bank_Abstraction bank = new BankKOTAK();
		// if object is SBI, method of SBI will be invoked

		int intrest = bank.getRateOfIntrest();

		System.out.println("RATE OF INTREST IS " + intrest + "%");
	}
}
