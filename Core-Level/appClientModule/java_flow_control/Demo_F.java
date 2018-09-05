package java_flow_control;

/**
 * for-each loop (Iterative statement):
 * 
 * -> This is enhanced for loop.
 * 
 * -> This is the best choice to retrieve the elements of Arrays and
 * Collections.
 * 
 * -> The target element in for-each loop should be iterable object and a target
 * is said to be iterable if and only if corresponding class implements
 * java.lang.iterable interface. All array related classed and collection
 * related classes already implements iterable interface.
 * 
 * 
 * Limitations:
 * 
 * 1) for-each is the best choice to retrieve elements of arrays and collections
 * but it's limitation is it's applicable only for arrays and collections and
 * it's not a general purpose loop.
 * 
 * 2) By using normal for loop we can print array elements either in original
 * order or in reverse order but by using for-each loop we can print array
 * elements only in original order but not in reverse order.
 * 
 * 3) The enhanced for loop needs either an array or any object that implements
 * Collection interface. Map does not implement Collection interface, though you
 * can use Map.getKeySet() or Map.values() to get a Collection and then iterate
 * over that Collection.
 * */

public class Demo_F {
	public static void main(String[] args) {

		/** To print the elements of one dimensional array. */
		int[] arr = { 10, 20, 30, 40, 50 };
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();

		/** To print the elements of two dimensional array. */
		int[][] b = { { 10, 20, 30 }, { 40, 50 } };

		for (int[] i : b) {
			for (int j : i) {
				System.out.print(j + " ");
			}
		}

	}
}
