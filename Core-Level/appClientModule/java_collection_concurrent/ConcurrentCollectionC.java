package java_collection_concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ConcurrentHashMap(c):
 * 
 * The underlying data structure is Hashtable.
 * 
 * ConcurrentHashMap implements ConcurrentMap which extends Map interface.
 * 
 * ConcurrentHashMap allows concurrent read and thread-safe update operations.
 * So, It's thread-safe version of HashMap.
 * 
 * To perform read operation thread won't require any lock. But, to perform
 * update operation thread requires lock but it's the lock of only a particular
 * part of Map(Bucket Level Lock).
 * 
 * Instead of whole Map concurrent update achieved by internally dividing Map
 * into smaller portion which is defined by Concurrency Level.
 * 
 * The default Concurrency Level is 16.
 * 
 * That is ConcurrentHashMap allows simultaneous read operation and
 * simultaneously 16 update operations.
 * 
 * null is not allowed for both keys and values.
 * 
 * While one thread iterating other thread can perform update operation and
 * ConcurrentHashMap never throws ConcurrentModificationException.
 * 
 * 
 * constructors:
 * 
 * ConcurrentHashMap m = new ConcurrentHashMap();
 * 
 * Creates an empty ConcurrentHashMap with default initial capacity 16 and
 * default fill ratio 0.75 and default concurrency level 16.
 * 
 * ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity);
 * 
 * ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity, float
 * fillRatio);
 * 
 * ConcurrentHashMap m = new ConcurrentHashMap(int initialCapacity, float
 * fillRatio, int concurrencyLevel);
 * 
 * ConcurrentHashMap m = new ConcurrentHashMap(Map map);
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > An important thing to know about the Iterators retrieved from a
 * ConcurrentHashMap is that, they are backed by that ConcurrentHashMap, which
 * means any operations done on the ConcurrentHashMap instance may be reflected
 * in the Iterator.
 * 
 * Thus, the thread that is iterating through the entries may or may not see the
 * entries removed from the map by another thread. Retrieval operations
 * (including get) generally do not block, so may overlap with update operations
 * (including put and remove).
 */

public class ConcurrentCollectionC {
	public static void main(String[] args) {

		// ConcurrentHashMap specific methods
		ConcurrentMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		map.put(101, "Jignesh");
		map.put(102, "Hozefa");
		map.put(103, "Raman");
		System.out.println(map);

		map.put(102, "Jimmi");
		System.out.println(map);

		/**
		 * Object putIfAbsent(Object key, Object value)
		 * 
		 * To add entry to the Map, If the specified key is already available it
		 * returns old associated value.
		 * 
		 * Returns null if no value is associated with specified key & add it.
		 * 
		 * 
		 * This is equivalent to,
		 * 
		 * if (!map.containsKey(key))        return map.put(key, value);    else
		 *        return map.get(key);
		 */
		System.out.println("putIfAbsent():	" + map.putIfAbsent(103, "Aneri"));
		System.out.println("putIfAbsent():	" + map.putIfAbsent(105, "Aneri"));
		System.out.println(map);

		/**
		 * boolean remove(Object key, Object value)
		 * 
		 * removes the entry if the key associated with the the specified value.
		 * 
		 * This is equivalent to,
		 * 
		 * if (map.containsKey(key) && map.get(key).equals(value)) {
		 *        map.remove(key);        return true;     } else return false;
		 * 
		 */
		System.out.println("remove():	" + map.remove(102, "Aneri"));
		System.out.println("remove():	" + map.remove(102, "Hozefa"));
		System.out.println(map);

		/**
		 * boolean replace(Object key, Object oldValue, Object newValue)
		 * 
		 * replace with the new value if key-value is matched.
		 * 
		 * This is equivalent to    
		 * 
		 * if (map.containsKey(key) && map.get(key).equals(oldValue)) {
		 *        map.put(key, newValue);        return true;    } else return
		 * false;
		 */
		System.out.println(map.replace(105, "Jayana", "Maulik"));
		System.out.println(map.replace(105, "Aneri", "Maulik"));
		System.out.println(map);
	}
}
