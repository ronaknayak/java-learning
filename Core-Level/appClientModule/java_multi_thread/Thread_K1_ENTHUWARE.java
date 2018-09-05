package java_multi_thread;

public class Thread_K1_ENTHUWARE extends Thread {

	private static int threadcounter = 0;

	/**
	 * Although the run method is synchronized, new TestClass objects are being
	 * created in the main method for each thread. So each thread will get a
	 * lock of a separate TestClass object.
	 * 
	 * Thus, any thread can potentially preempt any other thread while the
	 * thread is in the run method. For example, thread 1 increments the
	 * threadcounter to 1 and before it could print threadcounter, OS preempts
	 * thread 1 and runs thread 2. Thread 2 increments threadcounter to 2 and
	 * print 2. OS schedules thread 1 again, which prints threadcounter (which
	 * is now 2). So both the threads print 2 and 1 is never printed.
	 * 
	 * Also, the main() thread is not using the threadcounter value in any
	 * synchronized block. So depending on when the main() thread gets to run,
	 * it will print the current value of threadcounter. If the main thread gets
	 * to run first, then it will print 0 DONE first and then the rest of the
	 * numbers.
	 */
	public synchronized void run() {
		threadcounter++;
		System.out.println(threadcounter);
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			new Thread_K1_ENTHUWARE().start();
		}
		System.out.println(threadcounter + " DONE");
	}
}
