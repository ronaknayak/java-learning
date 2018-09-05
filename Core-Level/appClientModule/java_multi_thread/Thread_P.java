package java_multi_thread;

/**
 * Daemon Threads:
 * 
 * The threads which are executing in the background are called Daemon threads.
 * E.g. Garbage Collector, Signal Dispatcher, Attach Listener etc.
 * 
 * Daemon threads are meant to perform supporting tasks that make sense only if
 * normal threads are running. For example, the Garbage Collector thread is
 * useful only if some user thread is running. If all the user threads end then
 * what is the use of GC thread? So the program should end when all the
 * non-daemon threads end.
 * 
 * The main objective of Daemon thread is to provide support for Non-Daemon
 * threads (Main thread).
 * 
 * For example, If main thread runs with low memory then JVM runs GC to destroy
 * useless objects. So that number of bytes of free memory will be improved.
 * With this free memory Main thread can continue it's execution.
 * 
 * So, Daemon Thread job is to provide support for Main thread.
 * 
 * Usually, Daemon threads having low priority but based on our requirement
 * Daemon thread can run with the high priority also.
 * 
 * 
 * We can check Daemon nature of a thread by using isDaemon() method of Thread
 * class.
 * 
 * public boolean isDaemon()
 * 
 * We can change Daemon nature of a thread by using setDaemon() method of Thread
 * class.
 * 
 * public void setDaemon(boolean b)
 * 
 * But, changing Daemon nature is possible before starting of a thread only.
 * After starting a thread, If we are trying to change Daemon nature then we'll
 * get RE saying IllegalThreadStateException.
 * 
 * 
 * Default Nature:
 * 
 * By default, main thread is always Non-Daemon & for all remaining threads
 * Daemon nature will be inherited from parent to child. i.e. If the parent
 * thread is Daemon then automatically child thread is also Daemon & If the
 * parent thread is Non-Daemon then automatically child thread is also
 * Non-Daemon.
 * 
 * Here, Main thread is by default Non-Daemon therefore Child thread
 * automatically becomes Non-Daemon. But, We can set Child thread Daemon nature.
 * 
 * Note:
 * 
 * You can not call setDaemon() after the thread is started. It will throw
 * IllegalThreadStateException if you do so. Remember that same exception is
 * thrown if you try to call start() on a thread that is already started.
 * 
 * As Daemon Thread job is to provide support for Main thread. So, whenever last
 * Non-Daemon terminates automatically Daemon threads will be terminated
 * irrespective of their position.
 */

public class Thread_P {
	public static void main(String[] args) {
		System.out.println("Main thread " + Thread.currentThread().isDaemon());

		DaemonThread thread = new DaemonThread();
		System.out.println("Before: " + thread.isDaemon());
		thread.setDaemon(true);
		System.out.println("After: " + thread.isDaemon());

		thread.start();
		
		//thread.setDaemon(false);
		System.out.println("End of main thread");
	}
}

class DaemonThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}