package java_multi_thread;

/**
 * Case Study:
 * 
 * Case 1: Threads operating on different Objects
 * 
 * Even though wish() is synchronized we'll get irregular output in this case.
 * Because, The Threads are operating on different objects.
 * 
 * Reason: Whenever multiple Threads are operating on same Object then only
 * Synchronization play the role. If multiple Threads are operating on different
 * Objects then there is no impact of Synchronization.
 * 
 * e.g. Husband-Wife have Joint account then Synchronization is requires because
 * two threads operate on same Object while making transaction.
 * 
 * 
 * 
 * Case 2: class Level Lock
 * 
 * Every class in Java has a unique Lock which is nothing but class Level Lock.
 * 
 * If a thread wants to execute a static synchronized method then Thread
 * requires class Level Lock. Once, Thread got class Level Lock then it is
 * allowed to execute any static synchronized method of that class.
 * 
 * Once method execution completes automatically Thread releases Lock.
 * 
 * while a Thread executing static synchronized method then the remaining
 * Threads are not allowed to execute any static synchronized method of that
 * class simultaneously. Because, the class level lock is already acquired by
 * some other Thread. But, Remaining Threads are allowed to execute the
 * following methods simultaneously,
 * 
 * 1. Normal static methods 2. Synchronized instance methods 3. Normal instance
 * methods
 * 
 * 
 * Note:
 * 
 * There is No Link between Object Level Lock & class Level Lock. Both are
 * independent to each other.
 * 
 * class Level lock is different & object level lock is different.
 */

public class Thread_K {
	public static void main(String[] args) {

		Display display = new Display();
		Display display2 = new Display();
		
		MyThreading t1 = new MyThreading(display, "Nitin");
		MyThreadingNext t2 = new MyThreadingNext(display2, "Vipul");
		
		t1.start();
		t2.start();
	}
}

class ClassLevelLock {
	/*
	 * 
	 * If a thread wants to execute a m1() method then Thread acquires class
	 * Level Lock.
	 * 
	 * while a Thread executing static synchronized method then the remaining
	 * Threads are not allowed to execute m2() static synchronized method of
	 * that class simultaneously. But, Remaining Threads are allowed to execute
	 * the m3(), m4() and m5().
	 */
	static synchronized void m1() {
	}

	static synchronized void m2() {
	}

	static void m3() {
	}

	synchronized void m4() {
	}

	void m5() {
	}
}