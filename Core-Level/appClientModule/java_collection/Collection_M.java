package java_collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Comparator(I):
 * 
 * Comparator interface present in java.util package & it defines two methods,
 * 
 * public int compare(Object obj1, Object obj2)
 * --------------------------------------------------------------------------
 * Here, obj1 is the object which we are trying to add & obj2 is the object
 * which is already present.
 * 
 * 
 * public boolean equals(Object object)
 * --------------------------------------------------------------------------
 * Whenever we are implementing Comparator interface, compulsory we should
 * provide implementation only for compare() method & we are not require to
 * provide implementation for equals() method because it's already available to
 * our class from Object class through inheritance.
 * 
 * No predefined class implements Comparator interface.
 * 
 * If we are not passing Comparator object then internally JVM will call
 * compareTo() which is meant for default natural sorting order.
 * 
 * If we are passing comparator object then our own compare() will be executed
 * which is meant for Customized sorting order.
 */

public class Collection_M {
	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<Integer>(new MyComparator());
		set.add(10);
		set.add(0);
		set.add(5);
		set.add(20);
		set.add(5);
		System.out.println("Sort Integer objects by descending order:" + set);
	}
}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer num1, Integer num2) {
		System.out.println("In compare() method " + num1 + "<>" + num2);
		if (num1 < num2) {
			System.out.println("come before");
			return -1000;
		} else if (num1 > num2) {
			System.out.println("come after");
			return 100;
		} else {
			System.out.println("no-change");
			return 0;
		}
	}

	/**
	 * Various possible combinations
	 * 
	 * JVM job is to just check that what we are returning, irrespective of what
	 * order will take place.
	 */
	// @Override
	// public int compare(Integer num1, Integer num2) {
	//
	// // return num1.compareTo(num2);
	// // return -num1.compareTo(num2);
	// // return num2.compareTo(num1);
	// // return -num2.compareTo(num1);
	// // return +1;
	// // return -1;
	// // return 0;
	// }
}
