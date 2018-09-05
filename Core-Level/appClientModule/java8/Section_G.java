package java8;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * Default methods inside interface:
 * ****************************************************************************
 * 
 * Until 1.7 version onwards inside interface we can take only public abstract 
 * methods and public static final variables (every method present inside interface 
 * is always public and abstract whether we are declaring or not).
 * 
 * But from 1.8 version onwards in addition to these, we can declare default 
 * concrete methods also inside interface, which are also known as defender 
 * methods.
 * 
 * Interface default methods are by-default available to all implementation classes. 
 * Based on requirement implementation class can use these default methods directly 
 * or can override.
 * 
 * 
 * Advantage:
 * 
 * The main advantage of default methods is without effecting implementation classes 
 * we can add new functionality to the interface (backward compatibility).
 * 
 * 
 * 
 * Default method VS multiple inheritance:
 * ****************************************************************************
 * Two interfaces can contain default method with same signature then there may be a 
 * chance of ambiguity problem (diamond problem) to the implementation class. 
 * 
 * To overcome this problem compulsory we should override default method in the 
 * implementation class otherwise we get compile time error.
 * 
 * In the implementation class we can provide complete new implementation or we can 
 * call any interface method as follows:
 * 
 * Interfacename.super.m1();
 */
public class Section_G implements Interf {
	public static void main(String[] args) {

		Section_G section = new Section_G();
		section.m1();
	}
}

interface Interf {
	default void m1() {
		System.out.println("Default Method");
	}
}