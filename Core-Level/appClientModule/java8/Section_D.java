package java8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * Lambda Expression with Collections:
 * ****************************************************************************
 * 
 * Comparator interface has only one method i.e. compare(). So, it's functional 
 * interface.
 * 
 * Thus, We don't have need to write separate comparator implementation for to
 * achieve sorting. We can replace comparator with lambda expression wherever 
 * we need to do sorting.
 * 
 * 
 */
public class Section_D {
	public static void main(String[] args) {
		
		/**
		 * We can achieve same thing for TreeSet and TreeMap as well.
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(51);
		list.add(21);
		list.add(71);
		list.add(111);
		list.add(41);
		list.add(51);
		
		System.out.println("Before sorting: " + list);
		Collections.sort(list, (num1, num2) -> (num1 < num2) ? -1 : (num1 > num2) ? 1 : 0);
		System.out.println("After sorting: " + list);
	}
}
