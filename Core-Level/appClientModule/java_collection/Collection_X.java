package java_collection;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 1.6 version enhancements in Collection Framework:
 * 
 * As a part of 1.6 version the following two concepts introduced in Collection
 * Framework.
 * 
 * NavigableSet & NavigableMap
 * 
 * 8) NavigableSet(I):
 * 
 * It's the child interface of SortedSet.
 * 
 * It contains several methods for navigation purpose. TreeSet is implementation
 * class for NavigableSet interface.
 * 
 */

public class Collection_X {

	/* NavigableSet interface specific methods */
	public static void main(String[] args) {

		NavigableSet<Double> set = new TreeSet<Double>();
		set.add(6.30);
		set.add(1.00);
		set.add(2.30);
		set.add(12.00);
		set.add(5.30);
		set.add(6.0);
		set.add(7.15);
		set.add(10.30);
		set.add(8.45);
		System.out.println("Indian airline timings: " + set);

		/**
		 * E ceiling(E e)
		 * 
		 * Returns the least element in this set greater than or equal to the
		 * given element (>=e), or NULL if there is no such element.
		 */
		double timing = set.ceiling(7.15);
		System.out.println(timing);

		/**
		 * E higher(E e)
		 * 
		 * Returns the least element in this set strictly greater than the given
		 * element (>e), or NULL if there is no such element.
		 */
		System.out.println(set.higher(7.0));

		/**
		 * E floor(E e)
		 * 
		 * Returns the greatest element in this set less than or equal to the
		 * given element (<=e), or NULL if there is no such element.
		 */
		System.out.println(set.floor(6.30));

		/**
		 * E lower(E e)
		 * 
		 * Returns the greatest element in this set strictly less than the given
		 * element (<e), or null if there is no such element.
		 */
		System.out.println(set.lower(6.0));

		/**
		 * E pollFirst()
		 * 
		 * Retrieves and removes the first (lowest) element, or returns null if
		 * the set is empty.
		 * 
		 * @return removed object
		 */
		// System.out.println(set.pollFirst());

		/**
		 * E pollLast()
		 * 
		 * Retrieves and removes the last (highest) element, or returns null if
		 * this set is empty.
		 * 
		 * @return removed removed object
		 */
		// System.out.println(set.pollLast());

		/**
		 * NavigableSet<E> descendingSet()
		 * 
		 * Returns a reverse order view of the elements contained in this set.
		 */
		// System.out.println(set.descendingSet());

		System.out.println("Head-Set");
		System.out.println(set.headSet(5.30));
		System.out.println(set.headSet(5.30, true));

		System.out.println("Tail-Set ---  greater than equal to");
		System.out.println(set.tailSet(7.15));
		System.out.println(set.tailSet(7.15, false));

		System.out.println("Sub-Set");
		System.out.println(set.subSet(5.30, 7.15));
		System.out.println(set.subSet(5.30, false, 7.15, true));

		/**
		 * Operations on User Objects
		 */
		Employee employee = new Employee(104, "Krishna Panchal");
		Employee employee2 = new Employee(112, "Aneri Fumatiwala");
		Employee employee3 = new Employee(101, "Anil RajPurohit");
		Employee employee4 = new Employee(106, "Jimmi Prajapati");
		Employee employee5 = new Employee(103, "Ronak Nayak");
		Employee employee6 = new Employee(109, "Zeal Shah");

		NavigableSet<Employee> navigableSet = new TreeSet<>();
		navigableSet.add(employee);
		navigableSet.add(employee2);
		navigableSet.add(employee3);
		navigableSet.add(employee4);
		navigableSet.add(employee5);
		navigableSet.add(employee6);
		System.out.println("\nNavigableSet: " + navigableSet);

		Employee empCeiling = navigableSet.ceiling(new Employee(106, ""));
		System.out.println(empCeiling);

		Employee empFloor = navigableSet.floor(new Employee(104, ""));
		System.out.println(empFloor);

		SortedSet<Employee> empHeadSet = navigableSet.headSet(new Employee(106,
				""));
		System.out.println(empHeadSet);

		SortedSet<Employee> empTailSet = navigableSet.tailSet(new Employee(104,
				""));
		System.out.println(empTailSet);

		SortedSet<Employee> empSubSet = navigableSet.subSet(new Employee(104,
				""), new Employee(112, ""));
		System.out.println(empSubSet);
	}
}
