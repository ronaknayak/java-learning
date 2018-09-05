package java_collection_concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList(c):
 * 
 * CopyOnWriteArrayList is concurrent version of implementation class of List
 * interface.
 * 
 * It's the thread safe version of ArrayList.
 * 
 * As the name indicates CopyOnWriteArrayList creates a cloned copy of
 * underlying ArrayList for every update operation. As update operation is
 * performed on cloned copy there is no effect for the threads which perform
 * read operation.
 * 
 * At certain point both will synchronized automatically which is taken care by
 * JVM internally.
 * 
 * It's costly to use because for every update operation a cloned copy will be
 * created. Hence, It's the best choice when several read operations and less
 * number of write operations are required to perform.
 * 
 * Insertion order is preserved and duplicate objects are allowed.
 * 
 * Heterogeneous objects are allowed & null insertion is possible.
 * 
 * It implements SerializablE,CloneablE & RandomAccess interfaces.
 * 
 * While one thread iterating CopyOnWriteArrayList, the other threads are
 * allowed to modify & we won't get ConcurrentModificationException.
 * 
 * Iterator of ArrayList can perform remove operation but iterator of
 * CopyOnWriteArrayList can't perform remove operation. Because, If it's allowed
 * then at sync time it causes data inconsistency issue. Otherwise, we'll get RE
 * saying UnsupportedOperationException.
 * 
 * 
 * Constructors:
 * 
 * CopyOnWriteArrayList l = new CopyOnWriteArrayList();
 * 
 * CopyOnWriteArrayList l = new CopyOnWriteArrayList(Collection c);
 * 
 * CopyOnWriteArrayList l = new CopyOnWriteArrayList(Object[] array);
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * Modifications done to the CopyOnWriteArrayList are not reflected in the
 * Iterator and no modifications can be done on the list using that Iterator
 * (such as by calling iterator.remove() ). Calls that try to modify the
 * iterator will get UnsupportedOperationException.
 */

public class ConcurrentCollectionD {

	public static void main(String[] args) {

		// CopyOnWriteArrayList specific methods

		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("Aarya");
		list.add("Aarya");
		System.out.println("Because duplicates are allowed- " + list);

		/**
		 * boolean addIfAbsent(Object o)
		 * 
		 * The element will be added if and only if list does not contain this
		 * element.
		 */
		list.addIfAbsent("Jainal");
		list.addIfAbsent("Jainal");
		System.out.println("Check for existing object- " + list);

		/**
		 * int addAllAbsent(Collections c)
		 * 
		 * The elements of the collection will be added to the list if elements
		 * are absent & returns number of elements added.
		 * 
		 * In normal addAll() all elements will be added irrespective of it
		 * already present or not.
		 */
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Mit");
		arrayList.add("Aarya");
		arrayList.add("Sneh");
		System.out.println(list.addAllAbsent(arrayList));
		System.out.println("Returns number of added objects- " + list);

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {

			String string = (String) iterator.next();
			if (string.equals("Sneh")) {
				/**
				 * In ArrayList we can perform remove operation whenever
				 * required.
				 * 
				 * We can't perform remove operation because
				 * CopyOnWriteArrayList does not support it.
				 */
				// iterator.remove();
			}
		}
		afterGettingIterator();
	}

	public static void afterGettingIterator() {

		/**
		 * Important Note:
		 * 
		 * In case of CopyOnWriteArrayList, every update operation will be
		 * performed on separate copy hence after getting Iterator if we are
		 * trying to perform any modification to the list, It won't be reflected
		 * to the iterator.
		 * 
		 * But, In case of ArrayList, if we perform such an action we'll get RE
		 * saying ConcurrentModificationException.
		 */
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("Mit");
		arrayList.add("Aarya");
		arrayList.add("Sneh");

		Iterator<String> iterator = arrayList.iterator();
		// arrayList.add("Ronak");
		while (iterator.hasNext()) {
			iterator.next();
		}
		System.out.println("Case 1: " + arrayList);

		CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
		copyOnWriteArrayList.addAllAbsent(arrayList);
		Iterator<String> itr = copyOnWriteArrayList.iterator();
		System.out.println(copyOnWriteArrayList.addIfAbsent("Jignesh"));
		while (itr.hasNext()) {
			String name = itr.next();
			if (name.equals("Sneh")) {
				// itr.remove();
			}
			System.out.println(name);
		}
		System.out.println("Case 2: " + copyOnWriteArrayList);
	}
}