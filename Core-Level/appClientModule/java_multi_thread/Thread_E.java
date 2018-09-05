package java_multi_thread;

/**
 * Thread Priority:
 * 
 * Every thread in Java has some priority but the range of the thread
 * priorities. It may be default priority generated by JVM or customized
 * priority provided by programmer.
 * 
 * The valid range of Thread priorities is 1 to 10, Where 1 is Minimum priority
 * and 10 is Maximum priority. Otherwise, we'll get CE: IllegalArgumentException
 * 
 * Thread class defines some Constants to define some standard priorities,
 * Thread.MIN_PRIORITY = 1, Thread.NORM_PRIORITY = 5, Thread.MAX_PRIORITY = 10
 * 
 * 
 * Thread scheduler will use priorities while allocating processor. The thread
 * which is having highest priority will get chance first.
 * 
 * If two threads having same priority then we can't exact execution order. It
 * depends on Thread scheduler.
 * 
 * 
 * Default Priority:
 * 
 * The default priority only for the main thread is 5. But, for all the
 * remaining threads it will be inherited from the parent thread. i.e. whatever
 * the priority parent thread has, the same priority will be there for the child
 * thread.
 * 
 * Some platforms won't provide proper support for thread priorities.
 */
// Note: Windows 7 does not have support for Thread priorities.

public class Thread_E {

	public static void main(String[] args) {

		System.out.println("Main thread default priority:"
				+ Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(1);
		System.out.println("Main thread priority:"
				+ Thread.currentThread().getPriority());

		MyThreadFirst first = new MyThreadFirst();
		System.out.println("child thread default priority:"
				+ first.getPriority());
		first.setPriority(10);
		System.out.println("child thread priority:" + first.getPriority());
		first.start();

		for (int i = 1; i <= 10; i++) {
			System.out.println("Main Thread");
		}
	}
}

class MyThreadFirst extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 1; i <= 10; i++) {
			System.out.println("Child Thread");
		}
	}
}
