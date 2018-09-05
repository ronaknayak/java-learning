package java_collection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 4) SortedSet(I):
 * 
 * It's the child interface of Set.
 * 
 * If we want to represent a group of individual objects as a single entity
 * where duplicates are not allowed and all objects should be inserted according
 * to some sorting order then we should go for SortedSet.
 * 
 * For example, Sorting group of Employee objects according to their EmployeeId,
 * To sort Customer objects according to their account_creation_date etc.
 * 
 * If we don't specify anything then default natural sorting order implied.
 */

public class Collection_J {
	public static void main(String[] args) {

		SortedSet<Integer> sortedSet = new TreeSet<Integer>();
		sortedSet.add(new Integer(100));
		sortedSet.add(new Integer(101));
		sortedSet.add(new Integer(113));
		sortedSet.add(new Integer(104));
		sortedSet.add(new Integer(108));
		sortedSet.add(new Integer(109));
		System.out.println("SortedSet: " + sortedSet);

		/**
		 * Object first()
		 * 
		 * returns the first element of SortedSet.
		 */
		System.out.println("first():" + sortedSet.first());

		/**
		 * Object last()
		 * 
		 * returns the last element of SortedSet.
		 */
		System.out.println("last()" + sortedSet.last());

		/**
		 * SortedSet headSet(Object o)
		 * 
		 * returns the SortedSet whose elements are less than given object.
		 */
		System.out.println("headSet():" + sortedSet.headSet(new Integer(104)));

		/**
		 * SortedSet tailSet(Object o)
		 * 
		 * returns the SortedSet whose elements are greater than & equal to
		 * given object.
		 */
		System.out.println("tailSet():" + sortedSet.tailSet(new Integer(104)));

		/**
		 * SortedSet subSet(Object o1, Object 02)
		 * 
		 * returns the SortedSet whose elements are greater than & equal to
		 * given o1 and less than o2.
		 */
		System.out.println("subSet():" + sortedSet.subSet(101, 108));

		/**
		 * Comparator comparator()
		 * 
		 * returns Comparator object describes underlying sorting technique.
		 * 
		 * If we use Default natural sorting order then we will get NULL.
		 */
		System.out.println("comparator():" + sortedSet.comparator());
	}
}
