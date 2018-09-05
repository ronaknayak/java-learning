package java_collection;

import java.util.Stack;

/**
 * Stack(c):
 * 
 * It is the child class of Vector class & contains only one constructor. It's
 * specially designed class for LIFO order.
 * 
 * Stack s = new Stack();
 */

public class Collection_G {

	/* Stack specific methods */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Stack s = new Stack();

		/**
		 * Object push(Object o)
		 * 
		 * To insert object into the Stack
		 */
		s.push("Ronak");
		s.push("Nayak");
		s.push("eInfochips");
		s.push("Oracle Certified Associate Java Programmer");
		System.out.println(s);

		/**
		 * Object pop()
		 * 
		 * As LIFO order pop() removes last added element.
		 */
		Object o = s.pop();
		System.out.println("Removed: "+o);
		System.out.println(s);

		/**
		 * Object peek()
		 * 
		 * To return top element of the stack what we added last.
		 */
		System.out.println(s.peek());

		/**
		 * boolean empty()
		 * 
		 * Returns true, when stack is empty.
		 */
		System.out.println(s.empty());

		/**
		 * int search(Object o)
		 * 
		 * Returns the offset from top of the stack if the object is available.
		 * Otherwise, returns -1.
		 * 
		 * offset is the number of element from the top element & It's not
		 * index.
		 */
		System.out.println(s.search("eInfochips"));
		System.out.println(s.search("Samsung"));
	}
}
