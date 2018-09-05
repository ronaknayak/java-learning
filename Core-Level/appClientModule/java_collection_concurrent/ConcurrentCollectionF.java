package java_collection_concurrent;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet(c):
 * 
 * It is concurrent version of implementation class of Set interface.
 * 
 * It's a Thread safe version of Set & internally implemented by
 * CopyOnWriteArrayList.
 * 
 * Insertion order is not preserved & duplicate objects are not allowed.
 * 
 * MULTIPLE threads can able to perform read operation simultaneously but for
 * every update operation separate clone copy will be created & at last
 * synchronization will be performed by JVM.
 * 
 * It's costly to use because for every update operation a cloned copy will be
 * created. Hence, It's the best choice when several read operations and less
 * number of write operations are required to perform.
 * 
 * Heterogeneous objects are allowed & null insertion is possible(Only once).
 * 
 * While one thread iterating CopyOnWriteArraySet, the other threads are allowed
 * to modify & we won't get ConcurrentModificationException.
 * 
 * Iterator of HashSet can perform remove operation but iterator of
 * CopyOnWriteArraySet can't perform remove operation. Because, If it's allowed
 * then at sync time it causes data inconsistency issue. Otherwise, we'll get RE
 * saying UnsupportedOperationException.
 * 
 * CopyOnWriteArraySet does not have any special methods. Thereby, we have to
 * use only methods provided by collection interface.
 * 
 * Constructors:
 * 
 * CopyOnWriteArraySet s = new CopyOnWriteArraySet();
 * 
 * CopyOnWriteArraySet s = new CopyOnWriteArraySet(Collection c);
 */

public class ConcurrentCollectionF {
	public static void main(String[] args) {

		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<String>();
		set.add("Aatya");
		set.add("Jiya");
		set.add("Sneh");
		set.add(null);
		set.add("Jiya");
		set.add("Maitry");
		System.out.println(set);
	}
}
