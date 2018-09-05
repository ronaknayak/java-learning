package java_multi_thread;

/**
 * The ways to define, instantiate & start a new thread:
 * 
 * 
 * We can define a thread in the following two ways:
 * 
 * (1) By extending Thread class
 * 
 * (2) By implementing Runnable interface
 * 
 * 
 * Case 1: Thread scheduler
 * ---------------------------------------------------------------------------
 * It's the part of JVM.
 * 
 * It's responsible to schedule threads i.e. If multiple threads are waiting to
 * get the chance of execution then in which order threads will be executed is
 * decided by Thread scheduler.
 * 
 * We can't expect exactly algorithm followed by thread scheduler and it's
 * varied from JVM to JVM. Hence, we can't expect threads execution order and
 * exact output.
 * 
 * Note: whenever situation comes to multi-threading there is no guarantee for
 * exact output but we can provide several possible outputs.
 * 
 * 
 * 
 * Case 2: Difference between thread.start() and thread.run()
 * ---------------------------------------------------------------------------
 * In the case of thread.start() a new thread will be created and that thread is
 * responsible to execute run() method.
 * 
 * But in the case of thread.run() no new thread will be created and run method
 * will be executed just like a normal method call by main thread.
 * 
 * 
 * 
 * Case 3: Important of Thread class start method
 * ---------------------------------------------------------------------------
 * Thread class start method is responsible to register the thread with Thread
 * scheduler and all other mandatory activities. Hence, without executing start
 * method there is no chance of starting a new thread in java.
 * 
 * When the run method gets called through start() method then a new separate
 * thread is being allocated to the execution of run method, so if more than one
 * thread calls start() method that means their run method is being executed by
 * separate threads (these threads run simultaneously).
 * 
 * Due to this, Thread class start method is considered as HEART of
 * MULTI-THREADING.
 * 
 * 
 * 
 * Case 4: Overloading run()
 * ---------------------------------------------------------------------------
 * Overloading of run() is possible but Thread class start() will always call
 * no-argument run() only. The other overloaded run method we have to call like
 * a normal method call.
 * 
 * 
 * 
 * Case 5: If we are not overriding run() method
 * ---------------------------------------------------------------------------
 * If we are not overriding run() method, then Thread class run() will be
 * executed which has Empty implementation and hence we won't get any output.
 * 
 * Note: It is highly recommended to override run() to define our job, to take
 * benefits of MULTI-THREADING.
 * 
 * 
 * 
 * Case 6: Overriding of start()
 * ---------------------------------------------------------------------------
 * If override start() then that start method will be executed just like a
 * normal method call and no new thread will be created.
 * 
 * So, this way we don't get benefits of multi-threading because our class
 * defined start() won't call run() like Thread class start().
 * 
 * 
 * 
 * Case 7: super.start()
 * ---------------------------------------------------------------------------
 * If we add super.start() in our class defined start() then the new thread will
 * be created and we can utilize multi-threading indirectly.
 * 
 * 
 * 
 * Case 8: Life cycle of a Thread:
 * ---------------------------------------------------------------------------
 * TODO: Watch Part-14
 * 
 * > Once we create a Thread object then it is said to be in New state or Born
 * state.
 * 
 * MyThread thread = new MyThread();
 * 
 * > If we call start() method then the Thread will be into Ready or Runnable
 * state.
 * 
 * thread.start();
 * 
 * > If Thread scheduler allocates CPU and run() method is called then the
 * Thread will be entered into Running state.
 * 
 * public void run() { @Implementation }
 * 
 * > If run() method completes then the Thread will be entered into Dead state.
 * 
 * 
 * 
 * Case 9:
 * ---------------------------------------------------------------------------
 * After starting a Thread we are not allowed to restart the same Thread once
 * again. Otherwise, we'll get RE saying IllegalThreadStateException.
 * 
 * Though, there is no such state.
 * 
 * Within run() method, if we call super.start() then we'll get same RE saying
 * IllegalThreadStateException.
 */

public class Thread_B {

	public static void main(String[] args) {

		/**
		 * (1) By extending Thread class
		 */

		// Child Thread Instantiation
		MyThread thread = new MyThread();

		/*
		 * main thread starts child thread and now onwards child thread is
		 * responsible for his job.
		 * 
		 * There are two job's running after starting child thread. Both works
		 * independently and thereby generates mixed output of both threads.
		 */
		thread.start();

		// main thread and it's is responsible for this job
		for (int i = 0; i < 10; i++) {
			System.out.println("Main thread");
		}
	}
}

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child thread");
		}
	}
}
