package java_collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque interface:
 * ----------------------------------------------------------------------------
 * The java.util.Deque interface is a sub-type of the java.util.Queue interface.
 * It represents a queue where you can insert and remove elements from both ends
 * of the queue. Thus, "Deque" is short for "Double Ended Queue"
 * 
 * Thus, Deque can act as a Queue as well as a Stack.
 * 
 * 1. Queue is a FIFO structure (i.e. add to the end and remove from the front).
 * It has methods offer(e)/add(e) and poll()/remove() for this purpose. Note
 * that offer and add are similar while poll and remove are similar.
 * 
 * 2. Stack is a LIFO structure (i.e. add to the front and remove from the
 * front). It provides methods push(e) and pop() for this purpose, where push
 * adds to the front and pop removes from the front.
 * 
 * 
 * 
 * Besides the above methods, Deque also has variations of the above methods.
 * But it is easy to figure out what they do:
 * 
 * pollFirst()/pollLast() -
 * 
 * poll is a Queue method. Therefore pollFirst and pollLast will remove elements
 * from the front and from the end respectively.
 * 
 * 
 * removeFirst()/removeLast() -
 * 
 * remove is a Queue method. Therefore removeFirst and removeLast will remove
 * elements from the front and from the end respectively.
 * 
 * 
 * offerFirst(e)/offerLast(e) -
 * 
 * offer is a Queue method. Therefore offerFirst and offerLast will add elements
 * to the front and to the end respectively.
 * 
 * 
 * addFirst(e)/addLast(e) -
 * 
 * add is a Queue method. Therefore addFirst and addLast will add elements to
 * the front and to the end respectively.
 * 
 * 
 * peek(), peekFirst(): return the first element from the front of the queue but
 * does not remove it from the queue.
 * 
 * peekLast() : returns the last element from the end of the queue but does not
 * remove it from the queue.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * You may wonder why there are multiple methods for the same thing such as
 * offer(e) and add(e). Well, they are not exactly same. add(e) throws an
 * exception if the element cannot be added to the queue because of lack of
 * capacity, while offer(e) does not.
 * 
 * 
 * 
 * Deque implementations in the Java Collections API:
 * 
 * java.util.ArrayDeque & java.util.LinkedList
 */

public class Collection_W1 {

	/* Deque interface specific methods */
	public static void main(String[] args) {

		Deque<Integer> deque = new LinkedList<Integer>();
		deque.offer(5);
		deque.offer(20);
		deque.offer(15);
		deque.offer(10);
		deque.offer(35);
		System.out.println("Numbers:" + deque);

		deque.addFirst(1);
		deque.addLast(50);
		System.out.println("Numbers:" + deque);

		deque.offerFirst(2);
		deque.offerLast(45);
		System.out.println("Numbers:" + deque);

		deque.remove();
		deque.removeFirst();
		deque.removeLast();
		System.out.println("Numbers after remove:" + deque);

		deque.pollFirst();
		deque.pollLast();
		System.out.println("Numbers after poll:" + deque);

		System.out.println(deque.peek() + " & " + deque.peekFirst() + " & "
				+ deque.element());
		System.out.println(deque.peekLast());

		deque.poll();
		System.out.println("Numbers:" + deque);

		System.out.println("Some stack operations...");
		deque.push(1);
		System.out.println("Numbers:" + deque);
		deque.pop();
		System.out.println("Numbers:" + deque);

	}
}
