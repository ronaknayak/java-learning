package java_collection;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 6) SortedMap(I):
 * 
 * It's the child interface of Map.
 * 
 * If we want to represent a group of key-value pairs according to some sorting
 * order of keys then we should go for SortedMap.
 * 
 * In SortedMap the sorting should be based on key but not based on value.
 */

public class Collection_S {

	/* SortedMap specific methods: */

	public static void main(String[] args) {

		SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
		sortedMap.put(7, "Sri Lanka");
		sortedMap.put(5, "Newzeland");
		sortedMap.put(2, "Australia");
		sortedMap.put(6, "England");
		sortedMap.put(1, "India");
		sortedMap.put(4, "South Africa");
		sortedMap.put(3, "West Indies");
		System.out.println(sortedMap);
		
		/**
		 * Object firstKey()
		 */
		System.out.println(sortedMap.firstKey());

		/**
		 * Object lastKey()
		 */
		System.out.println(sortedMap.lastKey());

		/**
		 * SortedMap headMap(Object key)
		 */
		System.out.println(sortedMap.headMap(4));

		/**
		 * SortedMap tailMap(Object key)
		 */
		System.out.println(sortedMap.tailMap(4));

		/**
		 * SortedMap subMap(Object key)
		 */
		System.out.println(sortedMap.subMap(3, 5));

		/**
		 * Comparator comparator()
		 * 
		 * returns comparator object. If we use default natuaral sorting order
		 * then it returns null.
		 */
	}
}
