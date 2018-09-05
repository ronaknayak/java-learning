package java_inner_class;

import java_inner_class.OuterHelper.Nested;

/**
 * Normal Java class VS Anonymous Inner class:
 * 
 * - A normal class can extends only one class at a time. of course, Anonymous
 * Inner class can extends only one class at a time.
 * 
 * - A normal class can implement any number of interfaces simultaneously but
 * Anonymous Inner class can implements only one interface at a time.
 * 
 * - A normal class can extends a class and can implement any number of
 * interfaces simultaneously but Anonymous Inner class can extend a class or can
 * implements an interface but not both simultaneously.
 * 
 * - In normal class we can write any number of constructors but in Anonymous
 * Inner class we can't write any constructor explicitly. (Because then name of
 * the class and name of the constructor must be same but Anonymous Inner class
 * is nameless ;)
 * 
 * - If the requirement is standard and require several times then we should go
 * for Normal top level class. If the requirement is temporary & required only
 * once then we should go for Anonymous Inner class.
 * 
 * WHERE Anonymous Inner class is best suitable:
 * 
 * We can use Anonymous Inner classes frequently in GUI based applications to
 * implement even handling.
 * 
 * ----------------------------------------------------------------------------
 * 
 * 4) Static Nested classes:
 * 
 * Sometimes we can declare Inner class with static modifier such type of Inner
 * class are called static nested class.
 * 
 * In the case of normal or regular Inner class without existing outer class
 * object there is no chance of existing Inner class object. i.e. Inner class
 * object is strongly associated with Outer class object.
 * 
 * But, In the case of static nested class without existing Outer class object
 * there may be a chance of existing nested class object. Hence, static nested
 * class object is not strongly associated with the Outer class object.
 * 
 * In Normal or Regular Inner class we can't declare any static members.
 * 
 * But, In static nested class we can declare static members including main
 * method. Hence, we can invoke static nested class directly from command
 * prompt. It is like any other normal class.
 * 
 * From Normal or regular Inner class we can access both static and Non-static
 * members of Outer class directly. But, from static nested class we can access
 * static members of Outer class directly and we can't access Non-static members
 * directly.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * Static Nested class B. It can be used in other places: A.B b = new A.B();
 * There is no outer instance.
 * 
 * Regular Inner class C. It can only be used like this: A.C c = new A().new
 * C(); Outer instance is needed.
 * 
 * Declaring a nested class static only means that instances of the class are
 * created without having an outer instance. It does not put any limits on
 * whether the members of the class can be static or not.
 */

public class Inner_E {
	public static void main(String[] args) {

		// No need the Outer class object
		Nested nested = new Nested();
		nested.m();

		// Another approach as it's static
		OuterHelper.Nested helper = new OuterHelper.Nested();
		// In short
		new OuterHelper.Nested();
	}
}

class OuterHelper {
	private int initialValue = 10;
	static int maxSize = 1000;

	static class Nested {

		public void m() {
			System.out
					.println("static nested class method access static member: "
							+ maxSize);

			// System.out.println(initialValue);
			System.out
					.println("static nested class method access instance member:"
							+ new OuterHelper().initialValue);

			new OuterHelper().doGuessName();
		}

		public static void main(String[] args) {
			System.out.println("static nested class Main method");
		}
	}

	public void doGuessName() {
		System.out.println("Accessing outer class  non-static method");
	}
}