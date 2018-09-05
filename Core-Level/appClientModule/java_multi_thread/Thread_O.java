package java_multi_thread;

/**
 * DeadLock:
 * 
 * If two threads are waiting for each other forever, such type of infinite
 * waiting is called DeadLock.
 * 
 * synchronized keyword is the only reason for DeadLock situation. Hence, while
 * using synchronized keyword we have to take special care.
 * 
 * There are no resolution techniques for DeadLock but several prevention
 * techniques are available.
 * 
 * Note:
 * 
 * In our program, If we remove at least one synchronized keyword then the
 * program will not enter into DeadLock. Hence, synchronized keyword is the only
 * reason for DeadLock situation. Due to this while using synchronized we have
 * to take special care.
 * 
 * 
 * DeadLock VS Starvation:
 * 
 * Long waiting of a thread where waiting never ends is called DeadLock.
 * 
 * Whereas, Long waiting of a thread where waiting ends at certain point is
 * called starvation. For example, Low priority thread has to wait until
 * completing all high priority threads. It may be long waiting but it
 * compulsory ends at certain point, which is nothing but starvation.
 * 
 * Starvation describes a situation where a thread is unable to gain regular
 * access to shared resources and is unable to make progress. This happens when
 * shared resources are made unavailable for long periods by "greedy" threads.
 * 
 * For example, suppose an object provides a synchronized method that often
 * takes a long time to return. If one thread invokes this method frequently,
 * other threads that also need frequent synchronized access to the same object
 * will often be blocked.
 * 
 * In some cases, it is possible that another thread may never get a chance to
 * acquire the lock for the same file due to bad scheduling in the OS. Thus, the
 * thread that is frequently not able to get the lock is starved.
 * 
 * 
 * LiveLock:
 * 
 * A thread often acts in response to the action of another thread. If the other
 * thread's action is also a response to the action of another thread, then
 * LiveLock may result.
 * 
 * As with deadlock, LiveLocked threads are unable to make further progress.
 * However, the threads are not blocked — they are simply too busy responding to
 * each other to resume work. For example, after acquiring the File lock, T1
 * tries to acquire the Printer lock. Finding the Printer lock to be already
 * taken, it releases the lock for the File and notifies T2. At the same time,
 * T2 tries to acquire the File lock and seeing that it is already taken it
 * releases Printer lock and notifies T1.
 * 
 * This process can go on and on, both the threads releasing and acquiring the
 * locks in tandem but none of them getting both the locks at the same time. So
 * neither of the threads is blocked but neither of the threads is able to do
 * any real work. All they are doing is notifying each other.
 */

public class Thread_O {
	public static void main(String[] args) {
		new DeadLock();
	}
}

class Thread1 extends Thread {

	public synchronized void d1(Thread2 thread2) {

		System.out.println("Thread1 started execution of d1()");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException exception) {
		}
		System.out.println("Thread1 trying to call Thread2's last()");
		thread2.last();
	}

	public synchronized void last() {
		System.out.println("Thread1.last()");
	}
}

class Thread2 extends Thread {

	public synchronized void d2(Thread1 thread1) {

		System.out.println("Thread2 started execution of d2()");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException exception) {
		}
		System.out.println("Thread2 trying to call Thread1's last()");
		thread1.last();
	}

	public synchronized void last() {
		System.out.println("Thread2.last()");
	}
}

class DeadLock extends Thread {

	Thread1 thread1 = new Thread1();
	Thread2 thread2 = new Thread2();

	public DeadLock() {
		this.start();
		thread1.d1(thread2); // This line is executed by main Thread
	}

	@Override
	public void run() {
		thread2.d2(thread1); // This line is executed by child Thread
	}
}