package java_access_modifiers;

/**
 * Class Level Modifiers:
 * 
 * Whenever we are creating our own java class. compulsory we have to provide
 * some information about our class to the JVM like,
 * 
 * 1) whether our class can be accessible from any where or not.
 * 
 * 2) whether child class creation is possible for our class or not.
 * 
 * 3) whether object creation is possible or not.
 * 
 * we can specify this by declaring with appropriate modifier.
 * 
 * The only applicable modifier for top-level classes are, PUBLIC, <DEFAULT>,
 * FINAL, ABSTRACT, STRICTFP. If we are using any other modifier, we'll get CE:
 * modifier private not allowed here.
 * 
 * But, for Inner classes the applicable modifiers are top-level classes
 * modifiers + PRIVATE, PROTECTED, STATIC.
 * 
 * 
 * 1) public classes: If a class declared as public then we can access that
 * class from anywhere.
 * 
 * 
 * 2) default classes: If a class declared as default then we can access that
 * class only within current package. So, from outside of package we can't
 * access.
 * 
 * 
 * 3) final modifier: final is the modifier applicable for classes, methods and
 * variables.
 * 
 * Whatever methods parent has by default available to the child through
 * INHERITANCE. If a method declared as final then we are not allowed to
 * override that method in child class. If the child not satisfied with the
 * parent method implementation then child is allowed to redefine that method
 * based on it's requirement. This process is called METHOD OVERRIDING.
 * 
 * If the parent class method declared as final then we can't override that
 * method in child class because it's implementation is final.
 * 
 * If a class declared as final we can't extend functionality of that class.
 * i.e. we can't create child class for that class. Inheritance is not possible
 * for final classes or else we'll get CE: can't inherit from final
 * PARENT_CLASS_NAME.
 * 
 * The main advantage of final keyword is we can achieve security as no one is
 * allowed to change our implementation. Our implementation would be unique.
 * 
 * But, the main disadvantage of final modifier is we are missing key benefits
 * of OOPS INHERITANCE(because of final class) and POLYMORPHISM(because of final
 * method). Hence, if there is no specific requirement never recommended to use
 * final modifier.
 * 
 * 
 * NOTE: In java, order of modifiers is not important.
 */

final public class Demo_A {

	static String name = "Ronak";

	public static void main(String[] args) {

		/*
		 * NOTE: Every method present inside final class by default final. But,
		 * every variable present inside final class need not to be final.
		 * 
		 * Because In Java every object has unique data (except static
		 * variables).
		 */
		name = "Nayak";
		System.out.println(name);
	}
}