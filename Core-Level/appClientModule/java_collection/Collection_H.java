package java_collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

/**
 * Cursors:
 *
 * If we want to get objects one by one from the collection then we should go
 * for cursor.
 * 
 * There are three types of cursors available in Java.
 * 
 * 1) Enumeration:
 * 
 * We can use Enumeration to get objects one by one from Legacy collection
 * objects.
 * 
 * We can create Enumeration object by using elements() method of Vector class.
 * 
 * Limitation of Enumeration:
 * 
 * Enumeration is applicable only for Legacy classes & hence it's not a
 * universal cursor.
 * 
 * By using Enumeration we can get only Read access & we can't perform remove
 * operations.
 * 
 * To overcome above limitations we should go for Iterator.
 * 
 * 
 * 2) Iterator:
 * 
 * We can apply Iterator concept for any Collection object & Hence, It's
 * universal cursor.
 * 
 * By using iterator, We can perform both read and remove operations.
 * 
 * We can create Iterator object by using iterator() of Collection interface.
 * 
 * public Iterator iterator()
 * 
 * e.g. Iterator it = c.iterator(); Where, c can be any collection object.
 * 
 * Methods:
 * 
 * public boolean hasNext()
 * 
 * public Object next()
 * 
 * public void remove()
 * 
 * 
 * Limitation of Iterator:
 * 
 * 1) By using Enumeration & Iterator we can always move always towards forward
 * direction & we can't move towards backward direction.
 * 
 * 2) By using Iterator we can perform only Read & Remove operations and we
 * can't perform Replacement & Addition of new objects.
 * 
 * 3) To overcome above limitations, We should go for ListIterator.
 * 
 * 
 * 3) ListIterator:
 * 
 * ListIterator is the child interface of Iterator interface & Hence, all
 * methods present in Iterator by default available to the ListIterator.
 * 
 * By using ListIterator we can move either to the forward direction or to the
 * backward direction & hence it's Bidirectional cursor.
 * 
 * By using ListIterator we can perform Replacement & Addition of new objects in
 * addition to Read & Remove operations.
 * 
 * We can create ListIterator object by using listIterator() method of List
 * interface.
 * 
 * public ListIterator listIterator()
 * 
 * ListIterator l = list.listIterator();
 * 
 * Methods:
 * ----------------------------------------------------------------------
 * 
 * public boolean hasNext()
 * 
 * public Object next()
 * 
 * public int nextIndex()
 * 
 * 
 * public boolean hasPrevious()
 * 
 * public Object previous()
 * 
 * public int previousIndex()
 * 
 * 
 * public void remove()
 * 
 * public void set(Object) --> Replace an object with new Object
 * 
 * public void add(Object object) --> Add new object
 * 
 * 
 * Note:
 * 
 * The most powerful cursor is ListIterator, but it's limitation is it's
 * applicable only for list objects.
 * 
 * TODO: Comparison of three cursor from eBook
 */

public class Collection_H {
	public static void main(String[] args) {

		// enumerationCase();
		// iteratorCase();
		listIteratorCase();
	}

	public static void listIteratorCase() {

		LinkedList<String> list = new LinkedList<String>();
		list.add("Dhavan");
		list.add("Rohit");
		list.add("Kohli");
		list.add("Dhoni");
		System.out.println("LinkedList object:" + list);

		ListIterator<String> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			String string = (String) listIterator.next();

			switch (string) {
			case "Dhavan":
				listIterator.set("Rahane");
				break;
			case "Rohit":
				break;
			case "Kohli":
				break;
			default:
				listIterator.add("Jadeja");
				break;
			}
		}
		System.out.println(list);
	}

	public static void iteratorCase() {

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(new Integer(i));
		}
		System.out.println("ArrayList object:" + list);

		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int i = (int) iterator.next();

			if (i % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}

	public static void enumerationCase() {

		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 1; i <= 10; i++) {
			vector.addElement(new Integer(i));
		}
		System.out.println("Vector object:" + vector);

		Enumeration<Integer> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			int num = enumeration.nextElement();
			if (num % 2 != 0) {
				System.out.println(num);
			}
		}

	}
}
