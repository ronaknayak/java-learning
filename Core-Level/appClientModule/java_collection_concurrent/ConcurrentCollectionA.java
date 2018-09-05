package java_collection_concurrent;

import java.util.ArrayList;

/**
 * Need of Concurrent Collections:
 * 
 * 1. If we are working in MULTI-THREADING, traditional Collection objects like
 * ArrayList, HashMap etc can be accessed by MULTIPLE threads simultaneously and
 * there may be a chance of data inconsistency problem and hence these are not
 * thread-safe.
 * 
 * 2. Already existing thread-safe collections like Vector, synchronizedList(),
 * synchronizedMap() etc are performance wise not up to the mark.
 * 
 * 3. Because for every operation even for read operation also, total collection
 * will be loaded by only one thread at a time & it increases waiting time of
 * other threads.
 * 
 * Another big problem with traditional collections is while one thread
 * iterating collection, the other threads are not allowed to modify collection
 * object simultaneously. If we are trying to modify we'll get
 * ConcurrentModificationException.
 * 
 * Hence, these traditional collection objects are not suitable for scalable
 * MULTI Threaded Applications.
 * 
 * 
 * Pros of Concurrent Collections:
 * ********************************************************************
 * Concurrent collections are always Thread safe.
 * 
 * When compared with traditional thread safe collections performance is more
 * because of different locking system.
 * 
 * While one thread iterating collection the other threads are allowed to modify
 * collection in same manner. Hence, Concurrent collections never throws
 * ConcurrentModificationException.
 * 
 * 
 * The important Concurrent Collection classes are,
 * 
 * ConcurrentHashMap, CopyOnWriteArrayList, CopyOnwriteArraySet.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * In Simple collections, ConcurrentModificationException is thrown by the
 * methods of the Iterator interface. It is thrown when, while one thread is
 * iterating through a collection, another thread modifies the collection.
 */

public class ConcurrentCollectionA extends Thread {

	static ArrayList<String> list = new ArrayList<String>();

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("child thread updating list " + list.add("D"));
	}

	public static void main(String[] args) {

		list.add("A");
		list.add("B");
		list.add("C");

		ConcurrentCollectionA a = new ConcurrentCollectionA();
		a.start();

		for (String alphabet : list) {
			System.out
					.println("main thread iterating list & current object is: "
							+ alphabet);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(list);
	}
}
