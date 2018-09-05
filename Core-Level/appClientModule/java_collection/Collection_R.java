package java_collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.WeakHashMap;

/**
 * LinkedHashMap(c):
 * 
 * It's the child class of HashMap.
 * 
 * It is exactly same as HashMap including methods & constructors except some
 * differences.
 * 
 * The underlying data structure is Hashtable and LinkedList(Hybrid Data
 * structure).
 * 
 * Insertion order is preserved & it's based on hash code of keys.
 * 
 * Note:
 * 
 * The main application area of LinkedHashSet & LinkedHashMap are cache
 * applications implementation where duplication is not allowed & insertion
 * order must be preserved.
 * 
 * 
 * IdentityHashMap(c):
 * 
 * It's exactly same as HashMap(including methods & constructors) except some
 * differences.
 * 
 * In the case of normal HashMap, .equals() method to identify duplicate keys,
 * which is meant for content comparison.
 * 
 * But, In the case of IdentityHashMap JVM will use == operator to identify
 * duplicate keys which is meant for reference comparison (Address comparison).
 * 
 * So In case of HashMap, I1 & I2 are duplicate keys because I1.equals(I2)
 * returns true.
 * 
 * But, If we use IdentityHashMap the I1 & I2 are not duplicate keys because
 * I1==I2 returns false.
 * 
 * 
 * WeakHashMap(c):
 * 
 * It is exactly same as HashMap except few differences.
 * 
 * In the case of HashMap even though doesn't have any reference it's not
 * eligible for GC, If it's associated with HashMap. i.e. HashMap dominates
 * Garbage Collector.
 * 
 * But In the case of WeakHashMap, If object doesn't contain any references it's
 * eligible for GC even though object associated with WeakHashMap. i.e. Garbage
 * Collector dominates WeakHashMap.
 */

public class Collection_R {
	public static void main(String[] args) {

		Integer I1 = new Integer(10);
		Integer I2 = new Integer(10);

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(I1, "Ronak");
		map.put(I2, "Ravi");
		System.out.println("Normal HashMap: " + map);

		IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<Integer, String>();
		identityHashMap.put(I1, "Ronak");
		identityHashMap.put(I2, "Ravi");
		System.out.println("IdentityHashMap: " + identityHashMap);

		Temp temp = new Temp();
		HashMap<Temp, String> hashMap = new HashMap<Temp, String>();
		hashMap.put(temp, "Hello");
		System.out.println("Normal HashMap: " + hashMap);
		temp = null;
		System.gc();

		try {
			Thread.sleep(5000);
			System.out.println("Normal HashMap: " + hashMap);
		} catch (InterruptedException e) {
		}

		temp = new Temp();
		WeakHashMap<Temp, String> weakHashMap = new WeakHashMap<Temp, String>();
		weakHashMap.put(temp, "Hello");
		System.out.println("WeakHashMap: " + weakHashMap);
		temp = null;
		System.gc();

		try {
			Thread.sleep(5000);
			System.out.println("WeakHashMap: " + weakHashMap);
		} catch (InterruptedException e) {
		}
	}
}

class Temp {

	@Override
	public String toString() {
		return "Temp";
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
	}
}