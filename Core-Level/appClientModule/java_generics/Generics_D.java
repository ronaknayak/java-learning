package java_generics;

/**
 * GenericS Bounded Type Parameters:
 * ----------------------------------------------------------------------------
 * 
 * Objective: To restrict the kinds of types that are allowed to be passed to a
 * type parameter. For example, a method that operates on numbers might only
 * want to accept instances of Number or its subclasses. This is what bounded
 * type parameters are for.
 * 
 * Bounded type parameters can be used with methods as well as classes and
 * interfaces.
 * 
 * We can bound the type parameter for a particular range by using extends
 * keyword, such types are called Bounded types. Example,
 * 
 * class Test<T> {
 * 
 * }
 * 
 * As the Type parameter we can pass any Type & there are no restrictions.
 * Hence, It's Unbounded type.
 * 
 * Test<Integer> t1 = new Test<Integer>(); Test<String> t2 = new Test<String>();
 * 
 * 
 * Syntax for Bounded types:
 * 
 * class Test<T extends X> {
 * 
 * }
 * 
 * X can be either class or interface.
 * 
 * If X is a class then as the type parameter we can pass either X type or it's
 * child classes. If X is an interface then as the type parameter we can pass
 * either X type or it's implementation classes.
 * 
 * 
 * 
 * Java GenericS supports multiple bounds also, i.e <T extends A & B & C>. In
 * this case A can be an interface or class. If A is class then B and C should
 * be interfaces. We can’t have more than one class in multiple bounds.
 * 
 * Thus, we can define Bounded types even in combination also. Example,
 * 
 * class Test<T extends Number & Runnable>
 * 
 * As the type parameter we can take anything which should be child class of
 * Number & should implements Runnable interface.
 * 
 * 
 * 
 * Type Parameters:
 * ----------------------------------------------------------------------------
 * T - Type
 * 
 * E - Element
 * 
 * K - Key
 * 
 * N - Number
 * 
 * V - Value
 */

public class Generics_D {

	public static <E extends Comparable<E>> E maximum(E x, E y, E z) {
		E max = x; // assume x is initially the largest
		if (y.compareTo(max) > 0) {
			max = y; // y is the largest so far
		}
		if (z.compareTo(max) > 0) {
			max = z; // z is the largest now
		}
		return max; // returns the largest object
	}

	public static void main(String[] args) {

		System.out.println("maxumum number: " + maximum(3, 4, 5));
		System.out.println("maxumum number: " + maximum(7.2, 4.4, 5.3));
		System.out.println("maxumum number: "
				+ maximum("banana", "cat", "apple"));

		/*
		 * We can pass any type as a parameterized type.
		 */
		TestS<Integer> test = new TestS<Integer>();
		TestS<String> testS = new TestS<String>();

		/*
		 * In this case, we can pass only Number or it's child classes.
		 * Otherwise we'll get CE: type parameter is not with it's bound.
		 */
		FirstTest<Integer> firstTest = new FirstTest<Integer>();
		// FirstTest<String> firstTest2 = new FirstTest<String>();

		/*
		 * In this case, we can pass only interface type or it's implementation
		 * classes. Otherwise we'll get CE: type parameter is not with it's
		 * bound.
		 */
		SecTest<Runnable> secTest = new SecTest<Runnable>();
		SecTest<Thread> secTest1 = new SecTest<Thread>();

		// SecTest<Integer> secTest2 = new SecTest<Integer>();

		/**
		 * Conclusions:
		 * 
		 * 1) We can define Bounded type only by using extends keyword & we
		 * can't use implements & super keywords. But, we can replace implements
		 * keyword purpose with extends keyword.
		 * 
		 * 2) As the type parameter T we can take any valid Java Identifier but
		 * it's convention to use T (As T suggests Type Parameter).
		 * 
		 * 3) Based on our requirement we can declare any number of type
		 * parameters & All this type parameter should be separated with
		 * ,(COMMA). For instance,
		 * 
		 * class Test<X,Y,Z> {
		 * 
		 * }
		 */
		FifthTest<Integer, String> fifthTest = new FifthTest<Integer, String>();
	}
}

class TestS<T> {

}

class FirstTest<T extends Number> {

}

class SecTest<T extends Runnable> {

}

class ThirTest<T extends Runnable & Comparable<T>> {

}

class FourTest<T extends Number & Runnable & Comparable<Object>> {

}

// Looks like HashMap class
class FifthTest<T extends Integer, String> {

}

/**
 * Because we have to take class first followed by any number of interfaces
 */
// class InvalidTest<T extends Comparable & String> {
//
// }

/**
 * Because multiple inheritance is not supported in case of class type.
 */
// class InvalidTest<T extends Number & Thread> {
//
// }

