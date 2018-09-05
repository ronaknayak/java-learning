package java_collection;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 7) Queue(I) (1.5 Version Enhancements):
 * 
 * Queue is a FIFO structure (i.e. add to the end and remove from the front
 * i.e.begin).It's the child interface of Collection.
 * 
 * If we want to represent a group of individual objects prior to processing
 * (Before performing some operation) then we should go for Queue.
 * 
 * For example, Before sending SMS all mobile numbers we have to store in some
 * data structures. In which order we added mobile numbers in the same order
 * only SMS should be send. For this, FIFO requirement Queue is the best choice.
 * 
 * Usually, Queue follows FIFO order, but based on our requirement we can
 * implement our own priority order also (PriorityQueue).
 * 
 * From 1.5 version onwards, LinkedList class also implements Queue interface.
 * LinkedList based implementation of Queue always follows FIFO order.
 * 
 * 
 * Since Queue is an interface you need to instantiate a concrete implementation
 * of the interface in order to use it. You can choose between the following
 * Queue implementations in the Java Collections API:
 * 
 * java.util.LinkedList, java.util.PriorityQueue & java.util.BlockingQueue
 * 
 * PriorityQueue and BlockingQueue are implementation classes for Queue
 * interface. PriorityBlockingQueue and LinkedBlockingQueue are child classes
 * for BlockingQueue class.
 * 
 * 
 * 
 * PriorityQueue(c):
 * -----------------------------------------------------------------------------
 * This is the Data Structure to hold group of individual objects prior to
 * processing according to some priority then we should go for PriorityQueue.
 * 
 * The priority can be either Default natural sorting order or customized
 * sorting order defined by Comparator.
 * 
 * Insertion order is not preserved & it's based on some priority.
 * 
 * Duplicate objects are not allowed.
 * 
 * If we are depending on Default natural sorting order compulsory the object
 * should be Homogeneous & Comparable. Otherwise we'll get RE saying CCE.
 * 
 * If we are defining our own sorting by Comparator then objects need not be
 * Homogeneous & Comparable.
 * 
 * null is not allowed even as the first element also.
 * 
 * 
 * Constructors:
 * 
 * PriorityQueue q = new PriorityQueue();
 * 
 * Creates an empty PriorityQueue with the default initial capacity 11 & all
 * objects will be inserted according to default natural sorting order.
 * 
 * PriorityQueue q = new PriorityQueue(int initialCapacity);
 * 
 * PriorityQueue q = new PriorityQueue(int initialCapacity, Comparator c);
 * 
 * PriorityQueue q = new PriorityQueue(SortedSet s);
 * 
 * PriorityQueue q = new PriorityQueue(Collection c);
 * 
 * 
 * Note:
 * 
 * Some platforms won't provide proper support for Thread priorities &
 * PriorityQueue.
 */

public class Collection_W {

	/* Queue interface specific methods */
	public static void main(String[] args) {

		Queue<Integer> queue = new PriorityQueue<Integer>();
		
		/**
		 * Object peek()
		 * 
		 * To return head element of the Queue. If Queue is empty then this
		 * method returns null.
		 * 
		 * Object element()
		 * 
		 * To return head element of the Queue. If Queue is empty then we'll get
		 * RE saying NoSuchElementException.
		 */
		System.out.println(queue.peek());
		try {
			System.out.println(queue.element());
		} catch(NoSuchElementException ex) {
			System.out.println("No element in queue");
		}
		
		/**
		 * boolean offer(Object o)
		 * 
		 * To add an object into the queue.
		 */

		for (int iCounter = 10; iCounter > 0; iCounter--) {
			queue.offer(iCounter);
		}
		System.out.println(queue.peek());
		System.out.println(queue.element());
		System.out.println(queue);

		/**
		 * Object poll()
		 * 
		 * To remove & return head element of the Queue. If Queue is empty then
		 * this method returns null.
		 * 
		 * Object remove()
		 * 
		 * To remove & return head element of the Queue. If Queue is empty then
		 * we'll get RE saying NoSuchElementException.
		 */
		System.out.println(queue.poll());
		System.out.println(queue.remove());
		System.out.println("After removal: " + queue);

		/* For Customized Sorting Order. */
		PriorityQueue<String> priorityQueue = new PriorityQueue<String>(15,
				new StringComparator());
		priorityQueue.offer("ronak.nayak@einfochips.com");
		priorityQueue.offer("jignesh.varmora@einfochips.com");
		priorityQueue.offer("mayank.gusani@einfochips.com");
		priorityQueue.offer("jimmi.prajapati@einfochips.com");

		System.out.println("Customized sorting order: " + priorityQueue);
	}
}
