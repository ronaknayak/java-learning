package java_collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 5) Map(I):
 * 
 * All the above interfaces(Collection, List, Set, SortedSet, NavigableSet and
 * Queue) are meant for representing a group of individual objects.
 *
 * Note: Map is not child interface of Collection.
 * 
 * If we want to represent a group of objects as key-value pairs then we should
 * go for Map.
 * 
 * Both key and value are objects only. Duplicate keys are not allowed but
 * values can be duplicated.
 * 
 * Each key-value pair is called an Entry. Hence, Map is considered as a
 * collection of Entry objects.
 * 
 * HashMap, LinkedHashMap, WeakHashMap, IdentityHashMap, Hashtable, Properties
 * and Dictionary are implementation classes for Map interface.
 * 
 * Properties is child class of Hashtable and Dictionary  parent class of
 * Hashtable & It's an abstract class. This all are legacy classes because they
 * came in old generation.
 * 
 * 
 * Entry interface:
 * 
 * A map is a group of key-value pairs & each key-value pair is called an entry.
 * Hence, map is considered as a collection of entry objects.
 * 
 * Without existing map object there is no chance of existing entry object i.e.
 * both are tightly coupled. Hence, Entry interface is defined inside Map
 * interface. i.e. Entry is an inner interface of Map interface.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * ============================================================================
 * A Map is nothing but a set of buckets holding key-value pairs. Each bucket
 * corresponds to a unique HASHCODE. When you store a key-value pair in a Map,
 * the following things happen:
 * 
 * 1. HASHCODE of the key is computed. This key is used to identify the bucket
 * where the key-value must be stored.
 * 
 * 2. The key - value pair is stored in that bucket wrapped in a Map.Entry
 * object.
 * 
 * 3. If multiple keys have same HASHCODE value, all those key-value pairs are
 * stored in the same bucket.
 * 
 * Now, a look up in a Map is a three step process:
 * 
 * 1. HASHCODE of the key is computed. This code is used to identify the bucket
 * where the key should be looked for.
 * 
 * 2. For all the key-value pairs in that bucket, check whether the supplied key
 * is equal to the key in the bucket using equals() method.
 * 
 * 3. If a match exists, return the value, otherwise, return null.
 * 
 * As you can see, it is critically important to make sure that hashCode()
 * method return the same value for two objects that are equal as per equals()
 * method. If this rule is not followed, you will not be able to retrieve the
 * value from the map using another key object that is equal to the key object
 * stored in the map.
 * 
 * Remember that, before comparing the objects with equals() method, a map first
 * tries to locate the bucket in which it thinks it will find the object. It
 * locates the bucket using hash code of the key object passed in get(key) or
 * put(key, object).
 * 
 * Now, if you do not implement the hash code, object class's HASHCODE will be
 * used. So when you put the original object, it's hash code will be different
 * from the current object that you pass in get(object). Thus, it will not find
 * the right bucket and so it will not be able to find the original object.
 */

public class Collection_P {
	public static void main(String[] args) {

		/* Map interface methods */

		Map<Integer, String> map = new HashMap<Integer, String>();

		/**
		 * Object put(Object key, Object value)
		 * 
		 * To add key-value pair to the map.
		 * 
		 * If the specified key is already available then old value will be
		 * replaced with new value & old value will be returned.
		 */
		map.put(101, "Anil");
		map.put(110, "Jimmi");
		System.out.println("Adding unique key: " + map.put(102, "Shubham"));
		System.out.println("Adding duplicate key: " + map.put(102, "Pratik"));
		System.out.println(map);

		/**
		 * Object putAll(Map m)
		 * 
		 * To add group of key-value pairs to the map.
		 */

		/**
		 * Object get(Object key)
		 * 
		 * Returns value associated with the specified key.
		 * 
		 * If the key is not available then we'll get null.
		 */
		System.out.println("get object: " + map.get(102));

		/**
		 * Object remove(Object key)
		 * 
		 * removes the entry associated with the specified key.
		 */
		System.out.println("remove object: " + map.remove(110));

		/**
		 * boolean conatinsKey(Object key)
		 */
		System.out.println("Check map key : " + map.containsKey(150));

		/**
		 * boolean conatinsValue(Object value)
		 */
		System.out.println("Check map value: " + map.containsValue("Anil"));

		System.out.println("size(): " + map.size());
		System.out.println("isEmpty(): " + (!map.isEmpty()));
		// map.clear();
		System.out.println(map);

		/**
		 * Set keySet()
		 * 
		 * @return keys associated with map.
		 */
		Set<Integer> keys = map.keySet();
		System.out.println("keys inside map: " + keys);

		/**
		 * Collection values()
		 */
		Collection<String> values = map.values();
		System.out.println("values inside map: " + values);

		/**
		 * Set entrySet()
		 * 
		 * To get entire key-value pair entries from the map.
		 */
		Set<Map.Entry<Integer, String>> entries = map.entrySet();
		for (Map.Entry<Integer, String> entry : entries) {
			System.out.println(entry.getValue());
		}

		/* Entry interface specific methods */

		// Not Recommended Approach
		Iterator<Map.Entry<Integer, String>> iterator = map.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entr = iterator.next();
			System.out.println("Key : " + entr.getKey() + " Value :"
					+ entr.getValue());
		}

		// Recommended Approach
		for (Entry<Integer, String> entryObj : map.entrySet()) {
			System.out.println(entryObj.getKey() + " : " + entryObj.getValue());
			if (entryObj.getKey() == 101) {
				entryObj.setValue("AnilR");
			}
		}
		System.out.println(map);
	}
}
