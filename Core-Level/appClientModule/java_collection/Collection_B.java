package java_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 9-Key Interfaces of Collection Framework:
 * 
 * 1) Collection(I):
 * 
 * If we want to represent a group of individual objects as a single entity then
 * we should go for Collection interface.
 * 
 * Collection interfaces defines most common methods which are applicable to any
 * collection objects. In general, collection interface is considered as Root
 * interface of collection framework.
 * 
 * There is no concrete class which implements Collection interface directly.
 * 
 * 
 * Collection(I) VS Collections(C):
 * 
 * Collection is an interface, used to represent a group of individual objects
 * as a single entity.
 * 
 * Collections is an Utility class, present in java.util package to define
 * several utility methods for collections.
 * 
 * There is also one Utility class in collection framework & it's Arrays.
 * 
 */

public class Collection_B {
	public static void main(String[] args) {

		/* Collection interface methods: */
		Collection<String> collection = new ArrayList<String>();

		/**
		 * boolean add(Object o)
		 * 
		 * To add single object in collection.
		 */
		collection.add("First Collection Object");
		System.out.println(collection);

		/**
		 * boolean addAll(Collection c)
		 * 
		 * To add group of objects in collection. So, There are two add methods in
		 * Collection.
		 */
		collection.addAll(getGadgets());
		System.out.println(collection);

		/**
		 * boolean remove(Object c)
		 * 
		 * To remove particular object from collection. Return false if no object found.
		 * 
		 * boolean removeAll(Collection c)
		 * 
		 * To remove group of objects from collection. Return false if no object found.
		 */
		collection.remove("table");
		System.out.println(collection);

		collection.removeAll(getGadgets());
		System.out.println(collection);

		/**
		 * void clear()
		 * 
		 * To remove all the objects from the collection and make collection empty.
		 */
		collection.clear();
		System.out.println(collection);

		/**
		 * void retainAll(Collection c)
		 * 
		 * To remove all objects from the collection except those presented in c. So,
		 * There are four remove methods in Collection.
		 */
		collection.add("Smart TV");
		collection.addAll(getGadgets());
		System.out.println(collection);
		collection.retainAll(Arrays.asList("mobile", "tablet"));
		System.out.println("Retained objects: " + collection);

		/**
		 * boolean contains()
		 * 
		 * To check particular object is in collection or not. Return, false if No such
		 * a object is available.
		 * 
		 * boolean containsAll(Collection c)
		 * 
		 * To check group of objects is in collection or not. Return, false if No such a
		 * object is available.
		 */
		System.out.println(collection.contains("Android TV"));
		System.out.println(collection.containsAll(getGadgets()));

		// Custom Objects

		Share share = new Share("V-GUARD");
		List<Share> shares = getAllShares();
		if (shares.contains(share)) {
			System.out.println(share.getShareName() + " is availble to get traded.");
		} else {
			System.out.println(share.getShareName() + " is not availble to get traded.");
		}

		Share otherShare = new Share("REL");
		shares.add(otherShare);
		System.out.println("Before retaining shares: " + shares);
		shares.retainAll(getAllShares());
		System.out.println("After retaining shares: " + shares);

		/**
		 * boolean isEmpty()
		 * 
		 * To check whether collection is empty or not. Return, true if there is no
		 * objects in collection.
		 * 
		 * int size():
		 * 
		 * To get number of objects in collection.
		 */
		System.out.println(collection.isEmpty());
		System.out.println(collection.size());

		/**
		 * Object[] toArray()
		 * 
		 * To convert collection to array. This is meant for to enhance the performance
		 * because at performance context arrays are efficient than collection.
		 * 
		 * @return, Object[].
		 */
		Object[] objArray = collection.toArray();
		for (int i = 0; i < objArray.length; i++) {
			System.out.println("toArray(): " + objArray[i]);
		}

		/**
		 * Iterator iterator()
		 * 
		 * To iterate objects we need cursor. This one is most common cursor in
		 * collection.
		 * 
		 * iterator() method returns Iterator object & using that object we can iterate
		 * over collection.
		 */
		Iterator<String> iterate = collection.iterator();
		while (iterate.hasNext()) {
			String string =  iterate.next();
			System.out.println(string);
		}

		for (Iterator<String> iterator = collection.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			System.out.println(string);
		}
	}

	public static Collection<String> getGadgets() {

		Collection<String> collection = new ArrayList<String>();
		collection.add("mobile");
		collection.add("tablet");
		collection.add("laptop");

		return collection;
	}

	public static List<Share> getAllShares() {

		List<Share> shares = new ArrayList<Share>();
		shares.add(new Share("HDIL"));
		shares.add(new Share("ICICI BANK"));
		shares.add(new Share("V-GUARD"));

		return shares;
	}
}

class Share {

	private String shareName;

	public Share() {
	}

	public Share(String shareName) {
		super();
		this.shareName = shareName;
	}

	public String getShareName() {
		return shareName;
	}

	@Override
	public boolean equals(Object o) {

		System.out.println("equals() method called...");
		if (o instanceof Share) {
			Share share = (Share) o;
			if ((this.shareName.equals(share.shareName))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Share [shareName=" + shareName + "]";
	}

}
