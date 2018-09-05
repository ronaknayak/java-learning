package java_collection;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector(c):
 * 
 * The underlying data structure is ReSizable array or GrowablE array.
 * 
 * Duplicate objects are allowed.
 * 
 * Insertion order is preserved.
 * 
 * Heterogeneous objects are allowed.
 * 
 * NULL insertion is possible.
 * 
 * Vector implements SerializablE & CloneablE & RandomAccess interfaces.
 *
 * Best suitable If our frequent operation is Retrieval operation & worst choice
 * If our frequent operation is Insertion & Deletion in middle.
 * 
 * Every method defined in Vector class is Synchronized. Hence, Vector object is
 * Thread-Safe.
 * 
 * 
 * Constructor:
 * 
 * Vector v = new Vector();
 * 
 * Creates an empty vector object with default initial capacity 10 & once it
 * reaches it's max capacity a new vector object will created with double
 * capacity.
 * 
 * New capacity = 2 * Current capacity
 * 
 * Vector v = new Vector(int initialCapacity);
 * 
 * Creates Vector object with specified Initial capacity.
 * 
 * Vector v = new Vector(int intialCapacity, int incrementalCapacity);
 * 
 * Vector v = new Vector(Collection c);
 */

public class Collection_F {
	public static void main(String[] args) {

		/* Vector specific methods: */
		Vector vector = new Vector();
		vector.addElement("A");
		vector.addElement(null);
		vector.addElement("IND");
		vector.addElement(100);
		System.out.println(vector);

		/*
		 * To know the current capacity of Vector class. This facility is not in
		 * ArrayList because being a Java programmer we don't need to worry
		 * about Memory Level operations.
		 */
		System.out.println(vector.capacity());

		Enumeration enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			System.out.print(object + "	");
		}
		System.out.println();

		vector.remove(null);
		System.out.println(vector);

		vector.removeElementAt(0);
		System.out.println(vector);

		System.out.println(vector.elementAt(0));

		System.out.println(vector.firstElement());

		System.out.println(vector.lastElement());

		// This method perform same as clear()
		vector.removeAllElements();
		System.out.println(vector);
	}
}
