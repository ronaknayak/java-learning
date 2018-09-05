package java_multi_thread;

/**
 * (2) By implementing Runnable interface
 * 
 * We can define a thread by implementing Runnable interface.
 * 
 * Runnable interface present in java.lang package and contains only one method
 * that is run() method.
 * 
 * We'll get mixed output and we can't exact output.
 * 
 * 
 * 
 * Case study:
 * 
 * MyRunnable r = new MyRunnable();
 * 
 * Thread t1 = new Thread();
 * 
 * Thread t2 = new Thread(runnable);
 * 
 * 
 * Case 1: t1.start()
 * 
 * A new Thread will be created which is responsible for execution of Thread
 * class run() method & which has an EMPTY implementation.
 * 
 * 
 * Case 2: t1.run()
 * 
 * No new thread will be created & Thread class run() method will be executed
 * just like a normal method call & not yield any output as it has an EMPTY
 * implementation.
 * 
 * 
 * Case 3: t2.start()
 * 
 * New thread will be created and which is responsible for the execution of
 * MyRunnable run() method.
 * 
 * 
 * Case 4: t2.run()
 * 
 * No new thread will be created and MyRunnable run() method will be executed
 * just like a normal method call.
 * 
 * 
 * Case 5: r.start()
 * 
 * We'll get CE saying start() is not available in MyRunnable class.
 * 
 * 
 * Case 6: r.run()
 * 
 * No new thread will be created and MyRunnable run() method will be executed
 * just like a normal method call.
 */
public class Thread_C {

	public static void main(String[] args) {

		// main thread creates MyRunnable object
		Runnable runnable = new MyRunnable();

		/*
		 * Because Thread class has capability to run MyRunnable and to call our
		 * IMPLMENTED run() method we have to pass MyRunnable object in Thread
		 * class constructor. Otherwise, Thread class run() will be called and
		 * it has Empty implementation.
		 */
		Thread thread = new Thread(runnable);
		thread.start();

		// main thread and it's is responsible for this job
		for (int iCount = 0; iCount < 10; iCount++) {
			System.out.println("Main thread");
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int iCounter = 0; iCounter < 10; iCounter++) {
			System.out.println("Child Thread");
		}
	}

}
