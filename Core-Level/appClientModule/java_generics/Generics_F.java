package java_generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generic Methods:
 * ----------------------------------------------------------------------------
 * We can declare type parameter either at class level or at the method level.
 * 
 * You can write a single generic method declaration that can be called with
 * arguments of different types. Based on the types of the arguments passed to
 * the generic method, the compiler handles each method call appropriately.
 */

// Declaring type parameter at class level.
class ClassLevel<T> {
	/*
	 * We can use type parameter T within class based on our requirement.
	 */
}

public class Generics_F {

	/**
	 * Sometimes we don’t want whole class to be parameterized, in that case we
	 * can create java GenericS method. Since constructor is a special kind of
	 * method, we can use GenericS type in constructors too.
	 * 
	 * RULES:
	 * 
	 * All generic method declarations have a type parameter section delimited
	 * by angle brackets (< and >) that precedes the method's return type.
	 * 
	 * Each type parameter section contains one or more type parameters
	 * separated by commas.
	 * 
	 * The type parameters can be used to declare the return type and act as
	 * Placeholder for the types of the arguments passed to the generic method,
	 * which are known as actual type arguments.
	 */
	public <T> T method(T object) {
		/*
		 * We can use type parameter T object anywhere within this method based
		 * on our requirement.
		 */
		return object;
	}

	/**
	 * We can define Bounded Types even at method level also and same rules are
	 * applicable as on bounded types in class.
	 * 
	 * The invocation of these methods is similar to unbounded method except
	 * that if we will try to use any class that is not Comparable, it will
	 * throw compile time error.
	 */
	public <T extends Number> T m1(T element) {
		return element;
	}

	public <T extends Number, Interger> void m() {
	}

	public <T extends Runnable> void m2() {
	}

	public <T extends Number & Runnable> void m3() {
	}

	public <T extends Comparable<String> & Runnable> void m4() {
	}

	public <T extends Number & Comparable<Object> & Runnable> void m5() {
	}

	// public <T extends Runnable & Number> void m6() { }

	// public <T extends Number & Thread> void m7() { }

	/**
	 * Communication with Non-Generic code:
	 * 
	 * If we send generic object to Non-generic area then it start behaving like
	 * Non-generic object. Similarly, If we send Non-generic object to generic
	 * area it start behaving like generic object.
	 * 
	 * i.e. The location in which object based on that behavior will be define.
	 */

	public static void main(String[] args) {

		Integer number = 10;
		// Object number = 10;
		List<Integer> numbers = new ArrayList<Integer>();

		System.out
				.println("Returned element: " + addAndReturn(number, numbers));

		ArrayList<String> list = new ArrayList<String>();
		list.add("Rahul");
		list.add("Daxesh");
		// We can't add any object, because this is Generic area.
		// list.add(100);

		nonGenericMethod(list);

		System.out.println("Behaves like Non-generic object: " + list);

		/**
		 * Conclusions:
		 * 
		 * 1) The main purpose of genericS is to provide Type safety & to
		 * resolve Type casting problems.
		 * 
		 * Type safety & Type casting both are applicable at compile time.
		 * Hence, genericS concept also applicable only at compile time but not
		 * at runtime.
		 * 
		 * At the time of compilation as last step genericS syntax will be
		 * removed & Hence, for the JVM genericS syntax won't be available.
		 * 
		 * Here, As per the rule we might get Runtime exception saying CCE but
		 * as At the time of compilation as last step genericS syntax will be
		 * removed JVM can find it as,
		 * 
		 * ArrayList arrayList = new ArrayList();
		 * 
		 * 
		 * Hence, The following declarations are equal.
		 * 
		 * ArrayList arrayList = new ArrayList<Integer>();
		 * 
		 * ArrayList arrayList = new ArrayList<String>();
		 * 
		 * ArrayList arrayList = new ArrayList();
		 * 
		 * 
		 * 2) The following declarations are equal,
		 * 
		 * ArrayList<String> arrayList = new ArrayList<String>();
		 * 
		 * ArrayList<String> arrayList = new ArrayList();
		 * 
		 * For this ArrayList objects we can add only String type of objects.
		 * Because, At compile time reference type checking happen.
		 * 
		 * 
		 * 3) Overloading problem:
		 * 
		 * At compile time, 1) compile code normally by considering generic
		 * syntax. 2) Remove generic syntax. 3) compile once again with
		 * resultant code.
		 * 
		 * public void m1(ArrayList<String> l) {}
		 * 
		 * public void m1(ArrayList<Integer> l) {}
		 * 
		 * If we declare this way then we'll get CE saying duplicate method
		 * signature. Because compiler perform third step as,
		 * 
		 * public void m1(ArrayList l) {}
		 * 
		 * public void m1(ArrayList l) {}
		 */

		ArrayList arrayList = new ArrayList<String>();
		// That's why we can now add any type.
		arrayList.add(10);
		arrayList.add("Compiler");
		arrayList.add(10.5);
		System.out
				.println("At Compile time all generics syntax will be removed. "
						+ arrayList);

		/*
		 * For this ArrayList objects we can add only String type of objects.
		 * Because, At compile time reference type checking happen.
		 */
		ArrayList<Integer> arras = new ArrayList();
		arras.add(12);
		// arras.add("Compiler");
	}

	public static <T extends Number> T addAndReturn(T element,
			Collection<T> collection) {
		collection.add(element);
		return element;
	}

	public static void nonGenericMethod(ArrayList list) {

		// We can add any object because this is Non-generic area.
		list.add(10);
		list.add(45.6);
		genericMethod(list);
	}

	public static void genericMethod(ArrayList<String> list) {

		list.add("Tapan");
		// We can't add any object because now this is generic area.
		// list.add(45.6);
	}
}
