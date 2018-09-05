package java_multi_thread;

/**
 * (2) join():
 * 
 * If a Thread wants to wait until completing some other thread then we should
 * go for join() method.
 * 
 * 
 * For example, If a Thread t1 wants to wait until completing t2 then t1 has to
 * call t2.join().
 * 
 * If t1 executes t2.join() then immediately t1 will be entered into waiting
 * state until t2 complete. Once t2 completes then t1 can continue it's
 * execution.
 * 
 * Signature:
 * 
 * public final void join() throws InterruptedException
 * 
 * public final void join(long timePeriod) throws InterruptedException
 * 
 * public final void join(long timePeriod, int nanoSeconds) throws
 * InterruptedException
 * 
 * Whenever a Thread is waiting in waiting state there may be chance that other
 * threads interrupt that Thread. Thus, that called join() throws
 * InterruptedException.
 * 
 * InterruptedException is checked exception. Hence, we should handle either by
 * try-catch or by using throws keyword. Otherwise,we'll get CE.
 * 
 * 
 * Impact of yield() in Thread life cycle:
 * 
 * If t1 executes t2.join() then t1 will entered in waiting state. Thread t1
 * will not directly go in Ready or Runnable state. t1 Thread will go in Ready
 * state if t2 completes or if the time expires or if t1 got interrupted in
 * waiting state by other threads.
 * 
 * Now, If Thread scheduler allocate CPU then t1 again entered in Running state.
 */

public class Thread_G {

	public static void main(String[] args) throws InterruptedException {

		/** Case 1: Waiting of main thread until completing child thread */

		MyThreadThird third = new MyThreadThird();
		third.start();

		try {
			third.join(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("Waiting of Main Thread");
		}

		/** Case 2: Waiting of child thread until completing main thread */

		// MyThreadFourth.myThread = Thread.currentThread();
		//
		// MyThreadFourth fourth = new MyThreadFourth();
		// fourth.start();
		//
		// try {
		// for (int i = 0; i < 10; i++) {
		// System.out.println("Main Thread Executing");
		// Thread.sleep(500);
		// }
		// }
		// catch (InterruptedException e) { e.printStackTrace(); }

		/**
		 * Case 3: If a main thread call join() method on child thread object
		 * and child thread call join() method on main thread object then both
		 * threads will wait forever and the program will be paused. This is
		 * something like DEADLOCK.
		 */

		// DeadlockInstance.myThread = Thread.currentThread();
		//
		// DeadlockInstance deadlock = new DeadlockInstance();
		// deadlock.start();
		//
		// try {
		// for (int i = 0; i < 10; i++) {
		// System.out.println("Main Thread Executing");
		// deadlock.join();
		// }
		// }
		// catch (InterruptedException e) { e.printStackTrace(); }

		/**
		 * Case 4: If a thread calls join() method on the same thread itself
		 * then the program will be paused.This is something like DEADLOCK.
		 * 
		 * In this case thread has to wait infinite amount of time.
		 */
		// Thread.currentThread().join();

	}
}

class MyThreadThird extends Thread {

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread Executing");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThreadFourth extends Thread {

	static Thread myThread;

	@Override
	public void run() {
		super.run();

		try {
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(250);
				System.out.println("Child Thread Executing");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class DeadlockInstance extends Thread {

	static Thread myThread;

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread Executing");
			try {
				myThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
