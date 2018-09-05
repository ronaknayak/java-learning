package java_multi_thread;

public class Thread_C1_ENTHUWARE {
	public static void main(String[] args) {

		/**
		 * 1. The statement : Thread.currentThread().setName("First"); in the
		 * main() method sets the name of the current thread. This is the thread
		 * that is running the main method.
		 * 
		 * 2. The statement: MyRunnable mr = new MyRunnable("MyRunnable");
		 * creates a new MyRunnable object. In its constructor, it creates a new
		 * threads with the name "MyRunnable" and also starts this thread.
		 * 
		 * 3. Now there are two threads running (or ready to run state): The
		 * main thread (having the name "First") and the MyRunnable thread
		 * (having the name "MyRunnable"). Any of these two threads may be
		 * allowed to run by the OS.
		 * 
		 * 4. Calling mr.run() does not create a new Thread. Instead, the run()
		 * method is executed by the thread that has called the run() method, in
		 * this case the main thread. Since the main threads calls run() twice,
		 * the name of the main thread is printed twice in sequence. However, it
		 * changes the name before calling the run() second time. Therefore,
		 * "Second" will always be printed after "First" (may not be immediately
		 * after, though). Since it is printed by the same thread.
		 */
		Thread.currentThread().setName("First");
		MyRunnableImpl mr = new MyRunnableImpl("MyRunnable");
		mr.run();
		Thread.currentThread().setName("Second");
		mr.run();
	}
}

class MyRunnableImpl implements Runnable {
	MyRunnableImpl(String name) {
		new Thread(this, name).start();
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}