package java_inner_class;

/**
 * Inner Classes:
 * --------------------------------------------------------------------------
 * Sometimes we can declare a class inside another class. Such type of classes
 * are called inner classes.
 * 
 * PURPOSE: Inner classes are best for the purpose of logically grouping classes
 * that are used in one-place. For example, if you want to create class which is
 * used by ONLY enclosing class, then it doesn't make sense to create a separate
 * file for that. Instead you can add it as "inner class".
 * 
 * 
 * Without existing one type of objects if there is no chance of existing
 * another type of object, then we should go for Inner classes.
 * 
 * Example 1.0: Universities consist of several Departments. Without existing
 * university there is no chance of existing department. Hence, we have to
 * declare Department class inside University class.
 * 
 * class University {
 * 
 * class Department {
 * 
 * } }
 * 
 * Example 2.0: A map is group of key-value pairs and each key-value pair is
 * called an Entry. Without existing Map object there is no chance of Entry
 * object. Hence, Entry interface is defined inside Map interface.
 * 
 * The relationship between outer and inner class is not parent to child
 * relationship & It's HAS-A relationship(Composition or Aggregation).
 * 
 * In Java nested classes are considered members of their enclosing class. Thus,
 * a nested class can be declared public, package (no access modifier),
 * protected and private
 * 
 * Based on the purpose and position of declaration all Inner classes are
 * divided into four categories.
 * 
 * 
 * 1) Normal and Regular Inner class:
 * 
 * If we are declaring any named class directly inside a class without static
 * modifier, such type of inner class is called Normal inner class.
 * 
 * Member variables of the outer instance are always accessible to inner
 * instances, regardless of their accessibility modifiers.
 * 
 * An inner class can extend its outer class.
 * 
 * How the .class file is going to generate: Outer.class and Outer$Inner.class
 */

public class Inner_A {

	public class InnerNormal {
		static final String year = "2016";

		/**
		 * We can't touch Inner class directly without Outer class. So, Inside
		 * Inner class we can't declare static members or else we'll get CE.
		 * Hence, It is not possible to declare main() method inside Inner
		 * class.
		 * 
		 * Reason is that without existing outer class, no existence of inner
		 * class & It's only accessible by an instance of outer class.
		 * 
		 * Hence, we can't invoke Inner class directly from command prompt.
		 * 
		 * Non-static inner classes can contain final static fields (but not
		 * methods).
		 * 
		 * Also, static method can be declared only in static or top level class
		 * area.
		 * 
		 * Note: static keyword always marks a "top-level" construct (variable,
		 * method or class), which is never subject to an enclosing instance.
		 * This shows why an inner class cannot declare a static member, because
		 * the entire body of the inner class is in the scope of one or more
		 * enclosing instances.
		 */
		public void m1() {
			System.out.println("Inner class method");
		}
	}

	public void m2() {
		// We can access instance members directly inside instance area.
		InnerNormal normal = new InnerNormal();
		normal.m1();
	}

	public static void main(String[] args) {
		
		/**
		 * CASE 1: Access Inner class code from static area of Outer class:
		 * 
		 * Conclusion: Inside static area we can't touch Inner class directly,
		 * we need instance of Outer class as if Inner class is instance member
		 * of Outer class.
		 * 
		 * You cannot refer to Inner class directly (unless you import the
		 * inner class using import statement such as import p1.Outsider.*;
		 * where p1 is the package name).
		 */
		Inner_A outer = new Inner_A();
		Inner_A.InnerNormal normal = outer.new InnerNormal();
		normal.m1();

		// In Two Line
		Inner_A.InnerNormal innerNormal = new Inner_A().new InnerNormal();
		innerNormal.m1();

		// In One Line
		new Inner_A().new InnerNormal().m1();

		/**
		 * CASE 2: Access Inner class code from Instance area of Outer class:
		 * 
		 * This approach is better than CASE 1.
		 */
		Inner_A a = new Inner_A();
		a.m2();

		/**
		 * CASE 3: Access Inner class code from outside of Outer class:
		 * 
		 * This approach is as equivalent as CASE 1.
		 */
		Outer outer2 = new Outer();
		Outer.Inner inner = outer2.new Inner();
		inner.clearData();

		// In single line
		new Outer().new Inner().clearData();

		/**
		 * CASE 4: From normal or regular inner class we can access both static
		 * and non-static members of outer class directly.
		 * 
		 * Additionally, it can access all the members of outer class including
		 * private data members and methods.
		 */
		new Outer().new Inner().accessOuterMembers();

		/**
		 * CASE 5: Within the Inner class "this" always refers current Inner
		 * class object. If we want to refer current outer class object we have
		 * to use,
		 * 
		 * OuterClass.this
		 */
		new Outer().new Inner().accessCurrentObject();
	}
}

class Outer {

	private int x = 10;
	static int y = 20;
	String name = "ronak.nayak";

	class Inner {

		String name = "ronnayak";
		static final String email = "ronakanayak@gamil.com";
		public void clearData() {
			System.out.println("accessed outside of outer class.");
		}

		public void accessOuterMembers() {
			System.out.println(x);
			System.out.println(y);
		}

		public void accessCurrentObject() {
			System.out.println(this.name);
			System.out.println(Outer.this.name);
			System.out.println(email);
		}
	}
}