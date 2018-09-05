package java_multi_thread;

/**
 * The methods to prevent Thread execution:
 * 
 * (1) yield():
 * 
 * yield() method causes to pause the current executing thread to give the
 * chance for waiting threads of SAME PRIORITY (Because threads having high
 * priority would have been executed first).
 * 
 * CONCLUSION 1: If there is no waiting threads or all waiting threads having
 * low priority then same thread can continue it's execution.
 * 
 * CONCLUSION 2: If multiple threads are waiting with the same priority then
 * which waiting thread will get the chance we can't expect. It depends on
 * Thread scheduler.
 * 
 * CONCLUSION 3: The Thread which is yielded, when it will get the chance once
 * again, It depends on Thread scheduler and we can't expect exactly.
 * 
 * 
 * Signature:
 * 
 * public static native yield()
 * 
 * 
 * Impact of yield() in Thread life cycle:
 * 
 * When we call yield() method on thread then that thread will go in Ready or
 * Runnable state with other threads and when it will get the chance once again,
 * It depends on Thread scheduler and we can't expect exactly.
 * 
 * 
 * 
 * Note: Some platforms won't provide proper support for yield().
 * 
 * This is because invoking yield() is PREEMPTIVE scheduling. i.e. enforcing to
 * deallocate CPU from the currently executing Thread, means pausing Thread.
 * It's OS level concept. So, some platform may not support this facility.
 * Therefore, some platforms does not support yield()
 * 
 * 
 * (ENTHUWARE)Note that yield() does not necessarily put the calling thread on
 * hold. Also, if a higher priority thread comes in ready to run state, there is
 * no guarantee that the lower priority thread will be put on hold. It all
 * depends on the Operating System.
 */

public class Thread_F {

	public static void main(String[] args) {

		MyThreadSecond second = new MyThreadSecond();
		second.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread Executing");
			Thread.yield();
		}
	}

}

class MyThreadSecond extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread Executing");
		}
		MyThreThird threadThirD = new MyThreThird();
		threadThirD.start();
	}
}

class MyThreThird extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("Second Child Thread Executing");
		}
	}
}