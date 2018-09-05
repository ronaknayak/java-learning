package java_collection;

import java.util.LinkedList;

/**
 * LinkedList(c):
 * 
 * The underlying data structure is Doubly-linked list.
 * 
 * Insertion order is preserved.
 * 
 * Duplicates objects are allowed.
 * 
 * Heterogeneous objects are allowed.
 * 
 * NULL insertion is possible.
 * 
 * LinkedList implements SerializablE & CloneablE interface but not RandomAccess
 * interface.
 * 
 * 
 * Stack and Queue can be easily implemented using LinkedList.
 * 
 * Reason: Operations that are base of index the list will traverse the list
 * from the beginning or the end, whichever is closer to the specified index.
 * 
 * 
 * Note (Memory point of view):
 * 
 * Each element of a LinkedList has more overhead since pointers to the next and
 * previous elements are also stored. ArrayLists don't have this overhead.
 * 
 * However, ArrayLists take up as much memory as is allocated for the capacity,
 * regardless of whether elements have actually been added. The default initial
 * capacity of an ArrayList is pretty small i.e. 10. But since the underlying
 * implementation is an array, the array must be resized if you add a lot of
 * elements. To avoid the high cost of resizing when you know you're going to
 * add a lot of elements, construct the ArrayList with a higher initial
 * capacity.
 * 
 * 
 * When to use:
 * 
 * > If you have to perform lots of inserts use a LinkedList. The reason is as
 * follows -
 * 
 * ArrayList is backed by an array which has an initial capacity. So, if you add
 * more elements than the capacity of the underlying array, a new array (1.5
 * times the size) is allocated, and the old array is copied to the new one, so
 * adding to an ArrayList is O(n) in the worst case
 * 
 * On the other hand, LinkedList is backed by a linked list, where creating an
 * item always executes in a constant time O(1)- create an item and assign it to
 * the end of the list. No re-allocation occurs here.
 * 
 * > The main benefits of using a LinkedList arise when you re-use existing
 * iterators to insert and remove elements. If our frequent operation is
 * Insertion & Deletion operation in the middle, then LinkedList is best choice
 * because No shift operation requires. These operations can then be done in
 * O(1) by changing the list locally only.
 * 
 * But, If our frequent operation is retrieval operation then LinkedList is
 * worst choice because linked list elements are not stored at contiguous
 * location; the elements are linked using pointers & thus it allows only
 * sequential access of elements.
 * 
 * 
 * Constructors:
 * 
 * LinkedList list = new LinkedList();
 * 
 * Creates an empty LinkedList object.
 * 
 * We can't specify Initial capacity for LinkedList because it does not store
 * elements in consecutive location.
 * 
 * LinkedList list = new LinkedList(Collection c);
 * 
 * Creates an equivalent LinkedList object for the given Collection for internal
 * conversion between Collection objects.
 * 
 * 
 * LinkedList class specific methods:
 * 
 * Usually we can use LinkedList to develop Stack & Queue. To provide support
 * for this requirement LinkedList class defines the specific methods.
 * 
 * 
 * Time Complexity:
 * 
 * The add/remove operation runs in constant time O(1).
 * 
 * The get operation runs in O(n) as LinkedList require to traverse from the
 * head(first) element to get specified object.
 */

public class Collection_E {
	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.add("A");
		list.add(10);
		list.add('R');
		list.add(null);
		list.add('R');
		System.out.println(list);

		/**
		 * void addFirst(Object o)
		 */
		list.addFirst("First");
		System.out.println(list);

		/**
		 * void addLast(Object o)
		 */
		list.addLast("Last");
		System.out.println(list);

		/**
		 * Object removeFirst()
		 * 
		 * Object removeLast()
		 * 
		 * @return, removed object.
		 */
		Object o = list.removeFirst();
		System.out.println(o);
		list.removeLast();
		System.out.println(list);

		/**
		 * Object getFirst()
		 * 
		 * Object getLast()
		 */
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
	}
}
