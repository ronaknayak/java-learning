package java_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 2) List(I):
 * 
 * It's the child interface of Collection.
 * 
 * If we want to represent a group of individual objects as a single entity
 * where duplicates are allowed & insertion order must be preserved then we
 * should go for List.
 * 
 * We can preserve insertion order by means of Index & we can differentiate
 * duplicate objects by using Index. Hence, Index will play very important role
 * in List.
 * 
 * ArrayList, LinkedList, Vector and Stack are implementation classes for List
 * interface. Stack is child class of Vector.
 * 
 * Note: Vector and Stack are part of legacy classes because they came in old
 * generation.
 */

public class Collection_C {
	/* List interface methods: */
	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		/**
		 * boolean add(int index, Object o)
		 * 
		 * To add single object at specified index in list. But, this requires several
		 * shift operation If element is in the middle.
		 */
		list.add(0, "First");
		System.out.println(list);

		/**
		 * boolean addAll(int index, Object o)
		 * 
		 * To add group of objects at specified index in list.
		 */
		list.addAll(1, getGadgets());
		System.out.println(list);

		/**
		 * Object remove(int Index)
		 * 
		 * To remove object from particular Index. Returns what Object we have removed
		 * from the list. But, this requires several shift operation If element is in
		 * the middle.
		 */
		String gadget = list.remove(0);
		System.out.println(gadget);

		/**
		 * Object get(int index)
		 * 
		 * To know which object at specified position.
		 */
		String obj = list.get(0);
		System.out.println(obj);

		/**
		 * Object set(int index, Object newObject)
		 * 
		 * To replace a new object with old object from specified position.
		 * 
		 * @return, Old object what we have replaced
		 */
		Object object = list.set(2, "Ultrabook");
		System.out.println(object);

		/**
		 * int indexOf(Object o)
		 * 
		 * To know the position of particular object where it first occurred.
		 * 
		 * @return -1 if No object is available in list.
		 * 
		 *         int lastIndexOf(Object o)
		 * 
		 *         To know the position of particular object where it last occurred.
		 * 
		 * @return -1 if No object is available in list.
		 */
		System.out.println(list.indexOf("tablet"));
		System.out.println(list.lastIndexOf("smart ring"));

		/**
		 * ListIterator listIterator()
		 * 
		 * ListIterator listIterator(int Index)
		 * 
		 * This is List interface specific method. Used to iterate list from begin and
		 * from specified Index as well.
		 * 
		 * listIterator() returns ListIterator object
		 */
		for (ListIterator<String> iterator = list.listIterator(1); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.print(string + "\t");
		}
		System.out.println();

		// Custom Objects
		Chocolate darkChocolate = new Chocolate("Dark");
		Chocolate fruitChocolate = new Chocolate("fruit & nut");
		
		List<Chocolate> chocolates = new ArrayList<>();
		
		chocolates.add(fruitChocolate);
		chocolates.add(darkChocolate);
		chocolates.add(darkChocolate);
		System.out.println(chocolates);
		
		chocolates.remove(darkChocolate);
		System.out.println(chocolates);
	}

	public static List<String> getGadgets() {

		List<String> list = new ArrayList<String>();
		list.add("mobile");
		list.add("tablet");
		list.add("laptop");

		return list;
	}
}

class Chocolate {
	String type;

	public Chocolate(String type) {
		super();
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {

		System.out.println("equals() method called...");
		if (o instanceof Chocolate) {
			Chocolate chocolate = (Chocolate) o;
			if ((this.type.equals(chocolate.type))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Chocolate [type=" + type + "]";
	}

}