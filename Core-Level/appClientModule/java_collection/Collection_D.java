package java_collection;

import java.util.ArrayList;

/**
 * ArrayList(c):
 * 
 * The underlying data structure is ReSizable array or GrowablE array.
 * 
 * Duplicates objects are allowed.
 * 
 * Insertion order is preserved.
 * 
 * Heterogeneous objects are allowed.
 * 
 * NULL insertion is possible.
 * 
 * Note: Except TreeSet & TreeMap everywhere Heterogeneous objects are allowed.
 * Because, TreeSet & TreeMap are meant for sorting of objects. So, comparison
 * of objects needed & we can't compare Heterogeneous(different types) objects.
 * 
 * 
 * Constructors:
 * 
 * 1) ArrayList list = new ArrayList();
 * 
 * Creates an empty ArrayList object with default initial capacity 10. Once,
 * ArrayList reaches it's max capacity then a new ArrayList object will be
 * created with,
 * 
 * New capacity = (Current capacity * 3/2) + 1 , this follows Integral devision.
 * 
 * 2) ArrayList list = new ArrayList(int InitialCapacity);
 * 
 * Created an empty ArrayList object with the specified Initial capacity. This
 * constructor used when we know the Initial size in advance.
 * 
 * 3) ArrayList list = new ArrayList(Collection c);
 * 
 * Creates an equivalent ArrayList object for the given Collection. So, This
 * constructor is for dancing between Collection objects.
 * 
 * 
 * When to use:
 * 
 * > ArrayList & Vector implements RandomAccess interface. So that any Random
 * element we can access with same Speed. Hence, If our frequent operation is
 * fetch an item from the list then best suitable data structure is ArrayList
 * because elements are stored at contiguous location & thus we can grab any
 * element in constant time.
 * 
 * 
 * Note:
 * 
 * Usually we can use collections to hold & transfer objects from one location
 * to another location. To provide support for this requirement every Collection
 * class by default implements SerializablE(To send an object across Network)
 * and CloneablE(To recover an object if something goes wrong) interfaces.
 * 
 * 
 * If our frequent operation is Insertion & Deletion operation in the middle,
 * then ArrayList is worst choice because it requires several shift operation.
 * 
 * RandomAccess interface present in java.util package & doesn't contain any
 * methods. It's a marker interface. Where, required ability will be provided
 * automatically by the JVM.
 * 
 * 
 * To get Synchronized version of ArrayList object:
 * 
 * By using Collections class SynchronizedList() we can get Synchronized version
 * of ArrayList.
 * 
 * public static List SynchronizedList(List l)
 * 
 * Similarly, we can get Synchronized version of Set & Map objects by using,
 * 
 * public static Set SynchronizedSet(Set l)
 * 
 * public static Map SynchronizedMap(Map l)
 * 
 * 
 * 
 * Time Complexity:
 * 
 * The size, isEmpty, get, set, iterator, and listIterator operations run in
 * constant time O(1). This is because, ArrayList has direct references to every
 * element in the list, so it can get the nth element in constant time.
 * 
 * The add/remove operation runs in amortized constant time, that is, adding n
 * elements requires O(n) time. All of the other operations run in linear time
 * like contains(object) will run in O(n) to check whether list has that object.
 */

public class Collection_D {
	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		list.add("A");
		list.add(10);
		list.add('A');
		list.add(null);
		// In ArrayList toString() is implemented as to represent objects in []
		System.out.println(list);

		list.remove(2);
		System.out.println(list);

		list.add(2, "N");
		System.out.println(list);

		list.add("R");
		System.out.println(list);
	}
}
