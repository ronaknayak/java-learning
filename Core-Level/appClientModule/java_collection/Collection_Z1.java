package java_collection;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays class:
 * 
 * Arrays class is an utility class to define several utility methods for both
 * primitive arrays & object type arrays.
 */

public class Collection_Z1 {
	public static void main(String[] args) {

		/* Sorting the elements of Array: */

		/**
		 * public static void sort(primitive[] p)
		 * 
		 * To sort elements of primitive array according to natural sorting
		 * order.
		 */
		int[] primitiveArr = { 10, 7, 51, 2, 15 };
		Arrays.sort(primitiveArr);
		System.out.println("Primitive array after sorting: ");
		for (int iCount : primitiveArr) {
			System.out.print(iCount + " ");
		}
		System.out.println("\n");

		/**
		 * public static void sort(Object[] o)
		 * 
		 * To sort elements of object array according to natural sorting order.
		 * 
		 * In this case, compulsory the elements should be Homogeneous &
		 * Comparable. Otherwise, we'll get ClassCastException.
		 */
		String[] objectArr = { "Ronak", "Krishna", "Jigar", "Mayank" };
		Arrays.sort(objectArr);
		System.out.println("Object array after sorting: ");
		for (String name : objectArr) {
			System.out.print(name + "	");
		}
		System.out.println("\n");

		/**
		 * public static void sort(Object[] o, Comparator c)
		 * 
		 * To sort elements of object array according to customized sorting
		 * order.
		 * 
		 * Note:
		 * 
		 * We can sort primitive arrays only based on Default natural sorting
		 * order whereas we can sort Object arrays either based on Default
		 * natural sorting order or based on Customized sorting order.
		 */
		String[] objectArrComp = { "Ronak", "Krishna", "Jigar", "Mayank" };
		Arrays.sort(objectArrComp, new StringComparator());
		System.out.println("Object array after sorting by comparator: ");
		for (String name : objectArrComp) {
			System.out.print(name + "	");
		}
		System.out.println("\n");

		/*
		 * Searching the elements of Array:
		 * 
		 * Note:
		 * 
		 * All rules of Arrays class binarySearch are exactly same as
		 * Collections class binarySearch() methods.
		 */

		/**
		 * public static int binarySearch(primitive[] p, primitive_target)
		 */
		Arrays.sort(primitiveArr);
		System.out.println("Searching in primitive array: "
				+ Arrays.binarySearch(primitiveArr, 15));
		System.out.println(Arrays.binarySearch(primitiveArr, 100));

		/**
		 * public static int binarySearch(Object[] p, obj_target)
		 */
		Arrays.sort(objectArr);
		System.out.println("Searching in object array: "
				+ Arrays.binarySearch(objectArr, "Jigar"));
		System.out.println(Arrays.binarySearch(objectArr, "Raman"));

		/**
		 * public static int binarySearch(Object[] p, obj_target, Comparator c)
		 */
		for (String name : objectArr) {
			System.out.print(name + "	");
		}
		System.out.println("\nSearching for above elements...");
		Arrays.sort(objectArr, new StringComparator());
		System.out.println("Searching in object array by comparator: "
				+ Arrays.binarySearch(objectArrComp, "Jigar",
						new StringComparator()));

		// return -5 because it's sorted in reverse order
		System.out.println(Arrays.binarySearch(objectArr, "Aneri",
				new StringComparator()));

		// Conversion of Array to List:

		/**
		 * public static List asList(Object[] objArray)
		 * 
		 * Strictly speaking this method won't create an independent List
		 * object. For the existing array we are getting List view.
		 * 
		 * Conclusion 1: By using array reference if we perform any change
		 * automatically that change will be reflected to the List. Similarly,
		 * by using List reference if we perform any change that change will be
		 * reflected automatically to the array. This is because both are
		 * POINTING TO THE SAME ARRAY OBJECT.
		 * 
		 * Conclusion 2: By using List reference we can't perform any operation
		 * which varies the size. Otherwise, we'll get RE saying
		 * UnsupportedOperationException.
		 * 
		 * Conclusion 3: By using List reference we can perform replacement
		 * operation. But, replacement operation should be with same type of
		 * element only. Otherwise, we'll get Runtime exception saying
		 * ArrayStoreException.
		 * 
		 * e.g. list.add(Any Object) or list.remove(Any Object) would change the
		 * size. So, we'll get Runtime exception. But, we can perform
		 * list.set(1,"Add Name") kind of operation which will not
		 * increase/decrease the size.
		 * 
		 * Note(ENTHUWARE): Arrays.asList(T[] ) returns an object of type
		 * ArrayList<T>
		 */

		String[] names = { "Maitry", "Jiya", "Meet", "Siddhi" };
		List<String> list = Arrays.asList(names);
		System.out.println("After converting into List: " + list);

		names[0] = "Mitu";
		System.out.println("Changed by array reference: " + list);

		list.set(2, "Mit");
		System.out.println("Changed by list reference: ");
		for (String name : names)
			System.out.print(name + " ");

		// list.add("Cause UnsupportedOperationException");
		// list.remove("Jiya");
		// list.set(0, new StringBuffer("Cause ArrayStoreException"));
	}
}
