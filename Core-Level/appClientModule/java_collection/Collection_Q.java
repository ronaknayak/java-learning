package java_collection;

import java.util.HashMap;

/**
 * HashMap(c):
 * 
 * The underlying data structure is Hashtable which in turn based on Buckets
 * implementation.
 * 
 * Insertion order is not preserved because it's based on hash code of keys.
 * 
 * HashMap allow us to store object and retrieve it in constant time O(1) when
 * we know the key value object.
 * 
 * Duplicates key are not allowed but values can be duplicated.
 * 
 * Heterogeneous objects are allowed for both key and value.
 * 
 * null is allowed for key (only once) & null is allowed for values(any number
 * of times).
 * 
 * HashMap implements SerializablE & CloneablE interface but not RandomAccess.
 * 
 * HashMap is the best choice if our frequent operation is search operation.
 * 
 * 
 * SEVERAL DIFFERENCES BETWEEN HashMap & Hashtable:
 * 
 * > Hashtable is synchronized, whereas HashMap is not. This makes HashMap
 * better for non-threaded applications, as unsynchronized Objects typically
 * perform better than synchronized ones.
 * 
 * > In case of Hashtable, null is not allowed for both key & values. Otherwise,
 * we'll get NullPointerException. HashMap allows one null key and any number of
 * null values.
 * 
 * 
 * Constructors:
 * ----------------------------------------------------------------
 * 
 * HashMap m = new HashMap();
 * 
 * Creates an empty HashMap object with default initial capacity level is 16 &
 * default fill ratio 0.75(75%).
 * 
 * HashMap m = new HashMap(int initialCapacity);
 * 
 * HashMap m = new HashMap(int initialCapacity, float fillRatio);
 * 
 * HashMap m = new HashMap(Map m);
 * 
 * 
 * How to get synchronized version of HashMap:
 * 
 * By default, HashMap is not synchronized. But, we can get synchronized version
 * of HashMap by using synchronizedMap() method of Collections class.
 * 
 * Map m = Collections.synchronizedMap(HashMap hashMap);
 */

public class Collection_Q {
	public static void main(String[] args) {

		NotifierVO notifierVO = new NotifierVO(104, "Notifier-1");
		NotifierVO notifierVO1 = new NotifierVO(105, "Notifier-2");
		NotifierVO notifierVO2 = new NotifierVO(87, "Notifier-3");
		NotifierVO notifierVO3 = new NotifierVO(94, "Notifier-4");
		NotifierVO notifierVO4 = new NotifierVO(126, "Notifier-5");
		NotifierVO notifierVO5 = new NotifierVO(87, "Notifier-6");

		HashMap<NotifierVO, String> notifiers = new HashMap<NotifierVO, String>();
		notifiers.put(notifierVO, notifierVO.getName());
		notifiers.put(notifierVO1, notifierVO1.getName());
		notifiers.put(notifierVO2, notifierVO2.getName());
		notifiers.put(notifierVO3, notifierVO3.getName());

		// Below object will go to next to the above object in bucket.
		notifiers.put(notifierVO4, notifierVO4.getName());

		// As it's duplicate key, new value will be added.
		notifiers.put(notifierVO5, notifierVO5.getName());

		System.out.print("\n");
		System.out.println(notifiers);

		System.out.println("Starting lookup on map...");
		NotifierVO vo = new NotifierVO(87);
		System.out.println(notifiers.get(vo));
	}
}

class NotifierVO {

	private int notifierId;
	private String name;

	public NotifierVO() {
	}

	public NotifierVO(int notifierId) {
		this.notifierId = notifierId;
	}

	public NotifierVO(int notifierId, String name) {
		this.notifierId = notifierId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode() method called.");
		return notifierId;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("In equals() method");
		if (obj == this) {
			System.out.println("obj == this");
			return true;
		}

		if (obj == null) {
			System.out.println("object is NULL");
			return true;
		}

		NotifierVO vo = (NotifierVO) obj;
		if (this.notifierId == vo.notifierId) {
			System.out.println("contents are equal");
			return true;
		} else {
			System.out.println("not equal");
			return false;
		}
	}

	public int getNotifierId() {
		return notifierId;
	}

	public String getName() {
		return name;
	}
}
