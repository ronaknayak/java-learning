package java_multi_thread;

/**
 * Inter_Thread Communication:
 * 
 * Two threads can communicate with each other by using wait(), notify() and
 * notifyAll() methods.
 * 
 * The thread which is expecting updatioN is responsible to call wait() method.
 * Then immediately the thread will entered into waiting state.
 * 
 * The thread which is responsible to perform updatioN, after performing
 * updatioN it is responsible to call notify() method. Then, waiting thread will
 * get that notification & continue it's execution with those updated items.
 * 
 * wait(), notify() and notifyAll() methods are present in Object class but not
 * in Thread class. This is because based on these methods functionality Threads
 * are require to call these methods on any Java Object (e.g. Stack, Vector,
 * Student, Employee etc.) & If for every Java object some method is require
 * then that method should be available in Object class.
 * 
 * To call wait(), notify() or notifyAll() methods on any object, Thread should
 * be owner of that Object. i.e. The thread should has Lock of that object. i.e.
 * THE THREAD SHOULD BE INSIDE SYNCHRONIZED AREA.
 * 
 * Hence, We can call wait(), notify() or notifyAll() methods only from
 * Synchronized area. Otherwise,We'll get Runtime Exception saying
 * IllegalMonitorStateException.
 * 
 * To understand this concept consider this: You are eating with your friends
 * and there is only one Spoon. Now suppose you get the spoon and start eating.
 * After you finish, you'll say, "here is the spoon, I'm done with it". So other
 * people will start competing for the it. But you can't give a spoon if you
 * don't have one. Right? This is exactly what happens with shared resources. If
 * a thread really has some resource only then it can release (and notify
 * others) it. If it does not have a resource and still tries to notify others,
 * an exception will be thrown.
 * 
 * So, wait()/notiy()/notifyAll() can only be called from synchronized methods
 * because then it will be sure that the thread really has the lock for the
 * object (resource). Note that the synchronization should be on the same object
 * as it is calling notify on. (If you have a spoon, you should notify others
 * that you are releasing that same spoon and not some thing else!!!)
 * 
 * 
 * If a thread calls wait() method on any object, it immediately releases Lock
 * of that particular object and entered into waiting state.
 * 
 * If a thread calls notify() method on any object it releases the Lock of that
 * object but may not immediately. So, conclusive thing is that even though
 * thread calls notify()/notifyAll(), the lock on object is not released until
 * the thread gets out of the synchronized block.
 * 
 * Except wait(), notify() and notifyAll() methods there is no other methods
 * where thread releases the Lock.
 * 
 * 
 * Methods:
 * 
 * public final void wait() throws InterruptedException
 * 
 * public final native void wait(long waitingTime) throws InterruptedException
 * 
 * public final void wait(long waitingTime, int nanoSec) throws
 * InterruptedException
 * 
 * public final native void notify()
 * 
 * public final native void notifyAll()
 * 
 * 
 * Impact of wait() in Thread Life cycle:
 * 
 * Whenever Running thread will call wait() method on some object then
 * immediately that thread releases Lock of that object & entered into waiting
 * state.
 * 
 * When waiting thread gets notification or time expires or if waiting thread
 * got interrupted, It will entered into another waiting state to get the Lock.
 * Because now to continue, Thread needs two things: Notification & Lock of
 * object.
 * 
 * Once, Thread get Lock it will entered into Ready/Runnable state.
 * 
 * Now, If Thread scheduler allocate CPU then that Thread again entered in
 * Running state & If run() completes it will entered into Dead state.
 * 
 * Note:
 * 
 * Producer-Consumer Problem is the best way to represent this concept.
 * 
 * TODO: Theory is in eBook.
 */

public class Thread_M {
	public static void main(String[] args) {

		Mathematic mathematic = new Mathematic(100);
		mathematic.start();

		/*
		 * If main thread executes first, then we'll get 0 value. Sometimes, we
		 * get some other value because while looping main thread may get
		 * chance.
		 * 
		 * This is because main expects updatioN from child thread & child has
		 * to update the value.
		 */
		System.out.println("Inconsistency " + mathematic.total);

		MathematicSolve solve = new MathematicSolve(100);
		solve.start();

		try {
			/*
			 * This is not even consistent solution. Because If thread sleep for
			 * a long & child thread complete quickly then remaining time will
			 * go in vein & performance will go down.
			 * 
			 * If we short the sleeping time & If for some input thread take for
			 * time then it would give some intermediate result.
			 */
			Thread.sleep(0, 1);
		} catch (InterruptedException e) {
		}
		System.out.println("Performance issue  " + solve.total);

		MathematicSolve sol = new MathematicSolve(100);
		// sol.start();

		try {
			/*
			 * This is not even efficient solution. Because If child thread has
			 * some other thousand lines of code which is irrelevant for main
			 * thread then child thread takes much time for giving required
			 * updatioN.
			 */
			sol.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Not efficient  " + sol.total);

		MathematicSolved solved = new MathematicSolved(100);
		solved.start();

		/**
		 * If main thread call sleep(10000) method then for our case it will
		 * never get notification.
		 * 
		 * We can solve this type of problem by configuring time in wait(10000).
		 * But, In real main thread does not get notification. It just stop to
		 * wait.
		 * 
		 * So, when there is no guarantee about the notification from other
		 * thread we should configure time in wait() method parameter.
		 */
		// try {
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// }

		synchronized (solved) {
			System.out
					.println("main thread got lock of MathematicSolved object \nTrying to call wait method and releasing the lock...");
			try {
				solved.wait();
				System.out.println("main thread has got notification & acquired the lock of object again");
				System.out.println("Updated value = " + solved.total);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Mathematic extends Thread {

	int total = 0;
	int num;

	public Mathematic(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		for (int iCounter = 1; iCounter <= num; iCounter++) {
			total += iCounter;
		}
	}
}

class MathematicSolve extends Thread {

	int total = 0;
	int num;

	public MathematicSolve(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		for (int iCounter = 1; iCounter <= num; iCounter++) {
			total += iCounter;
		}
	}
}

class MathematicSolved extends Thread {

	int total = 0;
	int num;

	public MathematicSolved(int num) {
		this.num = num;
	}

	@Override
	public void run() {

		synchronized (this) {
			System.out
					.println("child thread got lock of current object & started calculation.");
			for (int iCounter = 1; iCounter <= num; iCounter++) {
				this.total += iCounter;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			System.out.println("child thread giving notification & releasing the lock...");
			this.notify();
		}
	}
}
