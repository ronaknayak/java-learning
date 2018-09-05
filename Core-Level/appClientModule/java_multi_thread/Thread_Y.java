package java_multi_thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Atomic Variables:
 * 
 * http://winterbe.com/posts/2015/05/22/java8-concurrency-tutorial-atomic
 * -concurrent-map-examples/
 * 
 * http://coderevisited.com/atomic-variables/
 * 
 * http://tutorials.jenkov.com/java-util-concurrent/atomicinteger.html
 * 
 * 
 * 
 * 
 * Volatile Variables:
 * 
 * http://tutorials.jenkov.com/java-concurrency/volatile.html
 * 
 * 
 * Volatile --> Guarantees visibility and NOT ATOMICITY
 * 
 * Synchronization (Locking) --> Guarantees visibility and ATOMICITY (if done
 * properly)
 */

public class Thread_Y {

	public static void main(String[] args) {

		doAtomicOperation();

	}

	static void doAtomicOperation() {

		AtomicInteger atomicInteger = new AtomicInteger();

		atomicInteger.set(100);

		int value = atomicInteger.get();
		System.out.println("Atomic Integer Value:" + value);

		/**
		 * It first checks if the current value is same as the expected value
		 * and if so, updates to the new value.
		 * 
		 * @return false if expected value is not there
		 */
		System.out.println(atomicInteger.compareAndSet(value, 200));

		int newValue = atomicInteger.get();
		System.out.println("Updated value:" + newValue);

		System.out.println(atomicInteger.getAndAdd(10));
		System.out.println("1->" + atomicInteger.get());

		System.out.println("2->" + atomicInteger.addAndGet(10));

		System.out.println(atomicInteger.getAndIncrement());
		System.out.println("3->" + atomicInteger.get());

		System.out.println("4->" + atomicInteger.incrementAndGet());

		System.out.println(atomicInteger.getAndDecrement());
		System.out.println("5->" + atomicInteger.get());

		System.out.println("6->" + atomicInteger.decrementAndGet());

		// return current value and set given value
		System.out.println("7->" + atomicInteger.getAndSet(300));
		System.out.println("8->" + atomicInteger.get());
	}
}
