package java_collection;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 9) NavigableMap(I):
 * 
 * It's the child interface of Map.
 * 
 * It defines several methods for navigation purposes.
 * 
 * TreeMap is implementation class for NavigableMap interface.
 * 
 */

public class Collection_Y {

	/* NavigableMap interface specific methods */
	public static void main(String[] args) {

		NavigableMap<Double, String> map = new TreeMap<Double, String>();
		map.put(7.15, "SpiceJet");
		map.put(1.00, "Go Air");
		map.put(6.00, "Jet Airways");
		map.put(12.00, "Air India");
		map.put(6.30, "Air India Express");
		map.put(8.45, "Indigo");
		map.put(2.30, "Indigo");
		map.put(10.30, "Jet Airways");
		map.put(5.30, "Air India");
		System.out.println("Indian airline timings: " + map);

		/**
		 * K ceilingKey(K key)
		 * 
		 * Returns the least key greater than or equal to the given key, or null
		 * if there is no such key.
		 * 
		 * Map.Entry<K,V> ceilingEntry(K key)
		 * 
		 * Returns a key-value mapping associated with the greatest key less
		 * than or equal to the given key, or null if there is no such key.
		 */
		System.out.println(map.ceilingKey(5.30));
		System.out.println(map.ceilingEntry(5.30));

		/**
		 * K higherKey(K key)
		 * 
		 * Returns the least key strictly greater than the given key, or null if
		 * there is no such key.
		 * 
		 * Map.Entry<K,V> higherEntry(K key)
		 * 
		 * Returns a key-value mapping associated with the least key strictly
		 * greater than the given key, or null if there is no such key.
		 */
		System.out.println(map.higherKey(5.45));
		System.out.println(map.higherEntry(5.45));

		/**
		 * K floorKey(K key)
		 * 
		 * Returns the greatest key less than or equal to the given key, or null
		 * if there is no such key.
		 * 
		 * Map.Entry<K,V> floorEntry(K key)
		 * 
		 * Returns a key-value mapping associated with the greatest key less
		 * than or equal to the given key, or null if there is no such key.
		 */
		System.out.println(map.floorKey(8.45));
		System.out.println(map.floorEntry(8.45));

		/**
		 * K lowerKey(K key)
		 * 
		 * Returns the greatest key strictly less than the given key, or null if
		 * there is no such key.
		 * 
		 * Map.Entry<K,V> lowerEntry(K key)
		 * 
		 * Returns a key-value mapping associated with the greatest key strictly
		 * less than the given key, or null if there is no such key.
		 */
		System.out.println(map.lowerKey(7.30));
		System.out.println(map.lowerEntry(7.30));

		/**
		 * Map.Entry<K,V> firstEntry()
		 * 
		 * Returns a key-value mapping associated with the least key in this
		 * map, or NULL if the map is empty.
		 */
		System.out.println(map.firstEntry());

		/**
		 * Map.Entry<K,V> lastEntry()
		 * 
		 * Returns a key-value mapping associated with the greatest key in this
		 * map, or null if the map is empty.
		 */
		System.out.println(map.lastEntry());

		/**
		 * NavigableSet<K> navigableKeySet()
		 * 
		 * Returns a NavigableSet view of the keys contained in this map. The
		 * set's iterator returns the keys in ascending order.
		 */
		System.out.println(map.navigableKeySet());

		/**
		 * NavigableSet<K> descendingKeySet()
		 * 
		 * Returns a reverse order NavigableSet view of the keys contained in
		 * this map. The set's iterator returns the keys in descending order.
		 */
		System.out.println(map.descendingKeySet());

		/**
		 * NavigableMap<K,V> headMap(K toKey, boolean inclusive)
		 * 
		 * Returns a view of the portion of this map whose keys are less than
		 * (or equal to, if inclusive is true) toKey.
		 * 
		 * NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)
		 * 
		 * Returns a view of the portion of this map whose keys are greater than
		 * (or equal to, if inclusive is true) fromKey.
		 */
		System.out.println("----head-map----");
		System.out.println(map.headMap(6.30));
		System.out.println(map.headMap(6.30, true));

		System.out.println("----tail-map----");
		System.out.println(map.tailMap(6.30));
		System.out.println(map.tailMap(6.30, false));

		/**
		 * NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey,
		 * boolean toInclusive)
		 * 
		 * Returns a view of the portion of this map whose keys range from
		 * fromKey to toKey. If fromKey and toKey are equal, the returned map is
		 * empty unless fromInclusive and toInclusive are both true.
		 */
		System.out.println("----sub-map----");
		System.out.println(map.subMap(6.30, true, 12.00, false));

		/**
		 * Map.Entry<K,V> pollFirstEntry()
		 * 
		 * Removes and returns a key-value mapping associated with the least key
		 * in this map, or null if the map is empty.
		 * 
		 * Map.Entry<K,V> pollLastEntry()
		 * 
		 * Removes and returns a key-value mapping associated with the greatest
		 * key in this map, or null if the map is empty.
		 */
		System.out.println(map.pollFirstEntry());
		System.out.println(map.pollLastEntry());

		/**
		 * NavigableMap<K,V> descendingMap()
		 * 
		 * Returns a reverse order view of the mappings contained in this map.
		 */
		System.out.println(map.descendingMap());

		/**
		 * Operations on User Objects
		 */
		NavigableMap<Empl, String> navigableMap = new TreeMap<>(
				new SalaryComp());
		navigableMap.put(new Empl("Ram", 3000), "RAM");
		navigableMap.put(new Empl("John", 6000), "JOHN");
		navigableMap.put(new Empl("Crish", 2000), "CRISH");
		navigableMap.put(new Empl("Tom", 2400), "TOM");
		navigableMap.put(new Empl("Mark", 1500), "MARK");
		navigableMap.put(new Empl("Taylor", 5000), "TAYLOR");
		System.out.println("\nNavigableMap: " + navigableMap);

		Empl empCeiling = navigableMap.ceilingKey(new Empl("Crish", 2000));
		System.out.println(empCeiling);

		Empl empFloor = navigableMap.floorKey(new Empl("Taylor", 5000));
		System.out.println(empFloor);

		Entry<Empl, String> empHighEntry = navigableMap.higherEntry(new Empl(
				"Crish", 2000));
		System.out.println(empHighEntry.getKey());

		SortedMap<Empl, String> empHeadMap = navigableMap.headMap(new Empl(
				"Ram", 3000));
		System.out.println(empHeadMap);

		SortedMap<Empl, String> empTailMap = navigableMap.tailMap(new Empl(
				"Ram", 3000));
		System.out.println(empTailMap);

		SortedMap<Empl, String> empSubMap = navigableMap.subMap(new Empl("Tom",
				2400), new Empl("Taylor", 5000));
		System.out.println(empSubMap);
	}
}

class Empl {

	private String name;
	private int salary;

	public Empl(String n, int s) {
		this.name = n;
		this.salary = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Name: " + this.name + "-- Salary: " + this.salary;
	}
}

class SalaryComp implements Comparator<Empl> {

	@Override
	public int compare(Empl e1, Empl e2) {
		if (e1.getSalary() > e2.getSalary()) {
			return 1;
		} else if (e1.getSalary() < e2.getSalary()) {
			return -1;
		} else {
			return 0;
		}
	}
}