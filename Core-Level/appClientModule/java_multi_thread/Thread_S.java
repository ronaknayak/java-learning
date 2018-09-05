package java_multi_thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronization VS Lock:
 * ========================================
 * 
 * 1. Java Lock API provides more visibility and options for locking, unlike synchronized 
 * where a thread might end up waiting indefinitely for the lock, we can use tryLock() to 
 * make sure thread waits for specific time only.
 * 
 * 2. Synchronization code is much cleaner and easy to maintain whereas with Lock we are 
 * forced to have try-finally block to make sure Lock is released even if some exception 
 * is thrown between lock() and unlock() method calls.
 * 
 * 3. synchronization blocks or methods can cover only one method whereas we can acquire 
 * the lock in one method and release it in another method with Lock API.
 * 
 * 4. synchronized keyword doesn’t provide fairness whereas we can set fairness to true 
 * while creating ReentrantLock object so that longest waiting thread gets the lock first.
 * 
 * 5. We can create different conditions for Lock and different thread can await() for 
 * different conditions.
 */

/**
 * Concurrency:
 * --------------------------------------------------------------------------
 * 
 * Concurrency API came up with java.util.concurrent.locks package with Lock
 * interface and some implementation classes to improve the Object locking
 * mechanism.
 * 
 * The Problems with Traditional Synchronized Keyword:
 * 
 * We are not having any flexibility to try for a Lock without waiting.
 * 
 * There is no way to specify maximum waiting time for a Thread to get Lock. So
 * that, Thread will wait until getting the Lock which may create performance
 * problems, which may cause Deadlock.
 * 
 * If a Thread release a Lock then which waiting Thread will get that Lock we
 * are not having any control on this.
 * 
 * There is no API to list out all waiting threads for a Lock.
 * 
 * The Synchronized keyword compulsory we have to use either at a method level
 * or within a method & It's not possible to use across MULTIPLE methods.
 * 
 * To overcome this problems sun people introduced java.util.concurrent.locks
 * package in 1.5 version. It also provides several enhancements to the
 * programmer to provide more control on concurrency.
 * 
 * 
 * 
 * Some important interfaces and classes in Java Lock API are:
 * -------------------------------------------------------------------------
 * Lock(I):
 * 
 * Lock object is similar to implicit Lock acquired by a Thread to execute
 * synchronized method or synchronized block. i.e. It's used as an explicit
 * Lock.
 * 
 * Some of the important methods are lock() to acquire the lock, unlock() to
 * release the lock, tryLock() to wait for lock for a certain period of time,
 * newCondition() to create the Condition etc.
 * 
 * 
 * Important Methods:
 * 
 * void lock()
 * 
 * We can use this method to acquired a lock. If lock is already available then
 * immediately current Thread will get that lock. If the lock is not already
 * available then it'll wait until getting the lock. It is exactly same behavior
 * of traditional synchronized keyword.
 * 
 * boolean tryLock()
 * 
 * To acquired the lock without waiting. If the lock is available then the
 * Thread acquires the lock & returns true & If the lock is not available then
 * this method returns false & can continue it's execution without waiting i.e.
 * performs some alternative operation. In this case Thread never be entered
 * into waiting state.
 * 
 * boolean tryLock(long time, TimeUnit unit)
 * 
 * If the lock is available then the Thread acquires the lock and continue it's
 * execution & If the lock is not available then the Thread will wait until
 * specified amount of time.
 * 
 * Still, If the lock is not available then Thread can continue it's execution.
 * 
 * 
 * TimeUnit:
 * 
 * It's an ENUM present in java.util.concurrent package.
 * 
 * public enum TimeUnit {
 * 
 * NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS }
 * 
 * 
 * void lockInterruptibly()
 * 
 * One more worth noting difference between ReentrantLock and synchronized
 * keyword in Java is, ability to interrupt Thread while waiting for Lock. In
 * case of synchronized keyword, a thread can be blocked waiting for lock, for
 * an indefinite period of time and there was no way to control that.
 * ReentrantLock provides a method called lockInterruptibly(), which can be used
 * to interrupt thread when it is waiting for lock.
 * 
 * void unlock()
 * 
 * To releases the lock. To call this method compulsory current Thread should be
 * owner of the lock. Otherwise, we'll get RE saying
 * IllegalMonitorStateException.
 * 
 * *****************************************************************************
 * 
 * ReentrantLock(c):
 * 
 * It's the implementation class of Lock interface & It's the direct child class
 * of Object class.
 * 
 * Reentrant means a Thread can acquire same Lock MULTIPLE times without any
 * issue. Internally, ReentrantLock increments threads personal count whenever
 * we call lock() method & decrements count value whenever thread call unlock()
 * and lock will be released whenever count reaches zero.
 * 
 * 
 * Constructors:
 * 
 * ReentrantLock l = new ReentrantLock();
 * 
 * Creates an instance of ReentrantLock.
 * 
 * ReentrantLock l = new ReentrantLock(boolean fairNess);
 * 
 * Creates the ReentrantLock with the given fairNess policy. If the fairNess is
 * true then longest waiting thread can acquired the lock, if it is available.
 * i.e. It follows FCFS policy.
 * 
 * If fairNess is false then which waiting thread will get chance we can't
 * expect.
 * 
 * The default value for fairNess is false.
 * 
 * 
 * Important Methods:
 * 
 * It's Implementation class of Lock interface. So, By default all methods of
 * Lock interface will be available to ReentrantLock class. Apart from Lock
 * interface implementation, ReentrantLock contains some utility methods to get
 * the thread holding the lock, threads waiting to acquire the lock etc.
 * 
 * 
 * Collection getQueuedThreads()
 * 
 * Returns collection of threads which are waiting to get the lock.
 * 
 * boolean hasQueuedThreads()
 * 
 * Returns true if any thread waiting to get the lock.
 * 
 * Thread getOwner()
 * 
 * Returns the Thread which acquires the lock.
 * 
 * ****************************************************************************
 * 
 * Condition(I):
 * 
 * It's an interface. A Condition object, also known as condition variable,
 * provides a thread with the ability to suspend its execution, until the
 * condition is true. A Condition object is necessarily bound to a Lock and can
 * be obtained using the newCondition() method.
 * 
 * Condition objects are similar to Object wait-notify model with additional
 * feature to create different sets of wait. A Condition object is always
 * created by Lock object.
 * 
 * Important Methods:
 * 
 * > await(): The current thread suspends its execution until it is signalled or
 * interrupted.
 * 
 * > await(long time, TimeUnit unit): The current thread suspends its execution
 * until it is signaled, interrupted, or the specified amount of time elapses.
 * 
 * > awaitUninterruptibly(): The current thread suspends its execution until it
 * is signaled (cannot be interrupted).
 * 
 * > signal(): This method wakes a thread waiting on this condition.
 * 
 * > signalAll(): This method wakes all threads waiting on this condition.
 * 
 * ****************************************************************************
 * 
 * ReadWriteLock(I):
 * 
 * If multiple threads are accessing an object for reading data, it does not
 * make sense to use a synchronized block or any other mutually exclusive locks.
 * 
 * A java.util.concurrent.locks.ReadWriteLock interface is an advanced thread
 * lock mechanism. It allows multiple threads to read a certain resource, but
 * only one to write it, at a time.
 * 
 * The idea is that multiple threads can read from a shared resource without
 * causing concurrency errors. The concurrency errors first occur when reads and
 * writes to a shared resource occur concurrently, or if multiple writes take
 * place concurrently.
 * 
 * Multiple Threads can acquire multiple read Locks, but only a single Thread
 * can acquire mutually-exclusive write Lock. Other threads requesting
 * writeLocks have to wait till the write Lock is released.
 * 
 * ReentrantReadWriteLock class is an implementation of ReadWriteLock, that also
 * supports ReentrantLock functionality like providing fair mechanism
 * ,reentrantLocks, Condition Support (on a write Lock only), allowing
 * interruption on read as well as write Locks.
 * 
 * Methods:
 * 
 * Lock readLock() - to acquire read-Lock and returns Lock object.
 * 
 * Lock writeLock() - to acquire the write-Lock and returns Lock object.
 */

public class Thread_S {
	public static void main(String[] args) {

		ReentrantLock reentrantLock = new ReentrantLock();

		/**
		 * Acquires the lock if it is not held by another thread and returns
		 * immediately, setting the lock hold count to one.
		 * 
		 * If the current thread already holds the lock then the hold count is
		 * incremented by one and the method returns immediately.
		 * 
		 * If the lock is held by another thread then the current thread becomes
		 * disabled for thread scheduling purposes.
		 */
		reentrantLock.lock();
		reentrantLock.lock();

		/**
		 * int getHoldCount()
		 * 
		 * Returns number of holds on this Lock by current thread.
		 */
		System.out.println(reentrantLock.getHoldCount());

		/**
		 * boolean isLocked()
		 * 
		 * Returns true if the lock is acquired by some thread.
		 */
		System.out.println(reentrantLock.isLocked());

		/**
		 * boolean isHeldByCurrentThread()
		 * 
		 * Returns true if and only if Lock is hold by current thread.
		 */
		System.out.println(reentrantLock.isHeldByCurrentThread());

		/**
		 * int getQueueLength()
		 * 
		 * Returns number of threads waiting for the Lock.
		 */
		System.out.println(reentrantLock.getQueueLength());

		reentrantLock.unlock();

		System.out.println(reentrantLock.getHoldCount());

		System.out.println(reentrantLock.isLocked());

		/**
		 * Attempts to release this lock.
		 * 
		 * If the current thread is the holder of this lock then the hold count
		 * is decremented. If the hold count is now zero then the lock is
		 * released.
		 * 
		 * While calling this method, If the current thread is not the holder of
		 * this lock then IllegalMonitorStateException is thrown.
		 */
		reentrantLock.unlock();

		System.out.println(reentrantLock.isLocked());

		/**
		 * boolean isFair()
		 * 
		 * Returns true if the fairNess policy is set with the true value.
		 */
		System.out.println(reentrantLock.isFair());

		DisplayVO vo = new DisplayVO();
		ConcurrentThread NitinThread = new ConcurrentThread(vo, "Nitin");
		ConcurrentThread vipulThread = new ConcurrentThread(vo, "Vipul");
		ConcurrentThread prakashThread = new ConcurrentThread(vo, "Prakash");

		// NitinThread.start();
		// vipulThread.start();
		// prakashThread.start();

		ConcurrentThread local = new ConcurrentThread("Local Thread");
		ConcurrentThread remote = new ConcurrentThread("Remote Thread");

		local.start();
		remote.start();
	}
}

class DisplayVO {

	static ReentrantLock reentrantLock = new ReentrantLock();

	// public void prepare(String name) {
	//
	// reentrantLock.lock(); // Changed code from traditional synchronization
	// try {
	// System.out.println(name + " thread acquired the lock...");
	// for (int i = 0; i < 5; i++) {
	// System.out.print("Hi, ");
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println(name);
	// }
	// } catch(Exception ex) {
	//
	// } finally {
	// reentrantLock.unlock(); // Changed code from traditional synchronization
	// System.out.println(name + " thread released the lock...");
	// }
	// }

	// public void prepare(String name) {
	//
	// if (reentrantLock.tryLock()) {
	//
	// System.out.println(Thread.currentThread().getName()
	// + "- got lock and performing safe operations.");
	// try {
	// Thread.sleep(20000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// reentrantLock.unlock();
	// } else {
	// System.out
	// .println(Thread.currentThread().getName()
	// + "- unable to get lock & hence performing alternative operations.");
	// }
	// }

	public void prepare(String name) {

		try {
			if (reentrantLock.tryLock(5000, TimeUnit.MILLISECONDS)) {

				System.out.println(Thread.currentThread().getName()
						+ "- got lock and performing safe operations.");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				reentrantLock.unlock();
			} else {
				System.out
						.println(Thread.currentThread().getName()
								+ "- unable to get lock & hence performing alternative operations.");
			}
		} catch (InterruptedException e) {

		}
	}
}

class ConcurrentThread extends Thread {
	DisplayVO display;
	String name;

	public ConcurrentThread(DisplayVO display, String name) {
		this.display = display;
		this.name = name;
	}

	public ConcurrentThread(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public void run() {
		if (display == null) {
			display = new DisplayVO();
		}
		display.prepare(name);
	}
}