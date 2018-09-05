package java_collection;

import java.util.TreeMap;

/**
 * TreeMap(c):
 * 
 * The underlying data structure is RED-BLACK tree.
 * 
 * Insertion order is not preserved & it is based on some sorting order of keys.
 * 
 * Duplicate keys are not allowed but values can be duplicated.
 * 
 * If we are depending on Default natural sorting order then keys should be
 * Homogeneous & Comparable. Otherwise, we'll get RE saying ClassCastException.
 * 
 * If we are defining our own sorting by Comparator then keys need not be
 * Homogeneous & Comparable. We can take Heterogeneous & Non-Comparable objects
 * also.
 * 
 * Whether we are depending on Default natural sorting order or Customized
 * sorting order there are no restrictions for values. We can take Heterogeneous
 * & Non-Comparable objects also.
 * 
 * 
 * null acceptance:
 * --------------------------------------------------------------------------
 * For Non-empty TreeMap if we are trying to insert an entry with null key then
 * we'll get RE saying NullPointerException.
 * 
 * For empty TreeMap as the first entry with null key is allowed. But, after
 * inserting that entry if we are trying to insert any other entry then we'll
 * get RE saying NullPointerException.
 * 
 * But, for values we can use null any number of times there is no restrictions.
 * 
 * Note: The above null acceptance rule applicable until 1.6 version only. From
 * 1.7 version onwards null is not allowed for key.
 * 
 * 
 * Constructors:
 * ----------------------------------------------------------------------------
 * TreeMap t = new TreeMap();
 * 
 * Creates an empty TreeMap object where the elements will be inserted according
 * to Default natural sorting order.
 * 
 * TreeMap t = new TreeMap(Comparator c);
 * 
 * Creates an empty TreeMap object where the elements will be inserted according
 * to customized sorting order specified by Comparator object.
 * 
 * TreeMap t = new TreeMap(Map m);
 * 
 * TreeMap t = new TreeMap(SortedMap m);
 */

public class Collection_T {
	public static void main(String[] args) {

		TreeMap map = new TreeMap();
		map.put(4, "South Africa");
		map.put(5, "Newzeland");
		map.put(2, "Australia");
		map.put(1, "India");
		map.put(3, "West Indies");
		map.put(10, 1000); // Values can be heterogeneous
		// map.put(" ", 1000); // Keys can't be heterogeneous: CCE
		// map.put(null, ""); // NPE
		map.put(50, null); // null values can be inserted any number of times
		System.out.println("Default natural sorting: " + map);

		TreeMap<String, String> players = new TreeMap<String, String>(
				new UniversalComparator());
		players.put("Virat Kohli", "India");
		players.put("AB Devilyers", "South Africa");
		players.put("Steve Smith", "Australia");
		players.put("Martin Guptil", "Newzeland");
		players.put("MS Dhoni", "India");
		players.put("Joe Root", "England");
		players.put("Chris Gayle", "West Indies");
		System.out.println("Customized sorting: " + players);
	}
}
