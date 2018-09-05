package java_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Collections class:
 *
 * It's an utility class present in java.util package.
 * 
 * The java.util.Collections class consists exclusively of static methods that
 * operate on or return collections
 * 
 * Collections class defines several utility methods for Collection implemented
 * class objects like SORTING, SEARCHING, REVERSING etc.
 */

public class Collection_Z {
	public static void main(String[] args) {

		// Sorting elements of a List:

		/**
		 * public static void sort(List l)
		 * 
		 * To sort elements of a List based on Default natural sorting order.
		 * 
		 * Natural order means: as governed by the compareTo() method of the
		 * elements. In case of String elements, the natural order is: SPACES <
		 * NUMBERS < UPPERCASE < LOWERCASE
		 * 
		 * In this case List should compulsory contain Homogeneous & Comparable
		 * objects. Otherwise, we'll get RE saying ClassCastException.
		 * 
		 * List should not contain null. Otherwise, we'll get RE saying NPE
		 * because to sort there needs to compare objects & while comparing with
		 * null it causes exception.
		 * 
		 * 
		 * public static void sort(List l, Comparator c)
		 * 
		 * To sort elements of a List based on customized sorting order.
		 */

		ArrayList<String> names = new ArrayList<String>();
		names.add("D - Section Books");
		names.add("G - Section Books");
		names.add("A - Section Books");
		names.add("E - Section Books");
		names.add("J - Section Books");
		// names.add(null);
		System.out.println("Before sorting: " + names);
		Collections.sort(names);
		System.out.println("After sorting: " + names);

		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("D - Section Books");
		nameList.add("G - Section Books");
		nameList.add("A - Section Books");
		nameList.add("E - Section Books");
		nameList.add("J - Section Books");
		System.out.println("Before sorting: " + nameList);
		Collections.sort(nameList, new StringComparator());
		System.out.println("After sorting: " + nameList);

		// Searching elements of List:

		/**
		 * public static int binarySearch(List l, Object target)
		 * 
		 * If the List is sorted according to Default natural sorting order then
		 * we have to use this method.
		 * 
		 * 
		 * public static int binarySearch(List l, Object target, Comparator c)
		 * 
		 * We have to use this method if the List is sorted according to
		 * customized sorting order.
		 * 
		 * 
		 * Conclusions:
		 * 
		 * The above search method internally will use binary search algorithm.
		 * 
		 * Successful search returns index & Unsuccessful search returns
		 * insertion point i.e. (-(insertion point) - 1) = -(index + 1).
		 * Insertion point is the location where we can place element in the
		 * sorted List starting with 0.
		 * 
		 * Before calling binarySearch() method compulsory List should be
		 * sorted. Otherwise, we'll get unpredictable results.
		 * 
		 * If the List is sorted according to Comparator then at the time of
		 * search operation also we have to pass same Comparator object.
		 * Otherwise, we'll get unpredictable results.
		 * 
		 * Return value will be >= 0 if and only if the key is found.
		 */

		System.out.println("Searching with Default natural sorting: "
				+ Collections.binarySearch(names, "E - Section Books"));
		System.out
				.println(Collections.binarySearch(names, "B - Section Books"));

		System.out.println("Searching with Customized sorting: "
				+ Collections.binarySearch(nameList, "E - Section Books",
						new UniversalComparator()));
		System.out.println(Collections.binarySearch(nameList,
				"b - Section Books", new UniversalComparator()));

		// Reversing elements of List:

		/**
		 * public static void reverse(List l)
		 * 
		 * public static Comparator reverseOrder(Comparator c)
		 * 
		 * 
		 * reverse() VS reverseOrder()
		 * 
		 * We can use reverse() method to reverse order of elements of List.
		 * 
		 * Whereas we can use reverseOrder() method to get Comparator object for
		 * reversing original sorting order.
		 */
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ahmedabad");
		list.add("Surat");
		list.add("Baroda");
		list.add("Mehsana");
		System.out.println("Before reversing: " + list);
		Collections.reverse(list);
		System.out.println("After reversing: " + list);

		Comparator<String> comparator = Collections
				.reverseOrder(new StringComparator());
		Collections.sort(list, comparator);
		System.out.println(list);

		/**
		 * fill(List<? super T> list, T object)
		 * 
		 * It's used to replace the elements of the given list with the
		 * specified element.
		 */
		ArrayList<String> cities = new ArrayList<String>();
		cities.addAll(list);
		Collections.fill(cities, "Gujarat");
		System.out.println("After filling:" + cities);

		/**
		 * copy(destination, source)
		 * 
		 * It copies all the elements from one list into another. After this
		 * method the index of each copied element in the destination list will
		 * be identical to its index in the source list. Destination list needs
		 * to be equal or bigger in the size.
		 */
		Collections.copy(cities, list);
		System.out.println("After copying:" + list);

		Collections.replaceAll(list, "Ahmedabad", "Ahm");
		System.out.println("Aftre replacement:" + list);
	}
}
