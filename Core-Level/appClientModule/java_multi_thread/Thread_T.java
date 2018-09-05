package java_multi_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Thread Pools (Executor Framework):
 * -----------------------------------------------------------------------
 * Creating a new Thread for a every task may create performance & memory
 * problems. To overcome this we should go for Thread Pool.
 * 
 * Instead of starting a new thread for every task to execute concurrently, the
 * task can be passed to a thread pool. As soon as the pool has any idle threads
 * the task is assigned to one of them and executed.
 * 
 * Thread Pool is a pool of already created threads, ready to do our job. Java
 * 1.5 version introduces Thread Pool framework to implement Thread Pools.
 * 
 * Gives better performance as it saves time because there is no need to create
 * new thread.
 * 
 * The java.util.concurrent.ExecutorService interface represents an asynchronous
 * execution mechanism which is capable of executing tasks in the background. An
 * ExecutorService is thus very similar to a thread pool.
 * 
 * In fact, the implementation of ExecutorService present in the
 * java.util.concurrent package is a thread pool implementation. Thus, Thread
 * Pool framework also known as Executor framework.
 * 
 * 
 * 
 * We can create a Thread Pool as follows:
 * 
 * ExecutorService service = Executors.newFixedThreadPool(int threadPoolSize);
 * 
 * An ExecutorService is created using the newFixedThreadPool() factory method.
 * 
 * 
 * ExecutorService methods:
 * ============================================================================
 * 
 * service.execute(Runnable):
 * 
 * The execute(Runnable) method takes a java.lang.Runnable object, and executes
 * it asynchronously. execute(Runnable) does not return anything.
 * 
 * 
 * service.submit(job):
 * 
 * An anonymous implementation of the Runnable interface is passed to the
 * execute() method. This causes the Runnable to be executed by one of the
 * threads in the ExecutorService.
 * 
 * But returns a Future object. This Future object can be used to check if the
 * Runnable has finished executing.
 * 
 * We can also pass An anonymous implementation of the Callable interface but it
 * can return a result whereas The Runnable.run() method cannot return a result.
 * 
 * 
 * service.invokeAny():
 * 
 * The invokeAny() method takes a collection of Callable objects, or
 * sub-interfaces of Callable. Invoking this method does not return a Future
 * object, but returns the result of one of the Callable objects. You have no
 * guarantee about which of the Callable's results you get. Just one of the ones
 * that finish.
 * 
 * If one of the tasks complete (or throws an exception), the rest of the
 * Callable's are cancelled.
 * 
 * 
 * service.invokeAll():
 * 
 * The invokeAll() method invokes all of the Callable objects you pass to it in
 * the collection passed as parameter. The invokeAll() returns a list of Future
 * objects via which you can obtain the results of the executions of each
 * Callable.
 * 
 * 
 * service.shutdown():
 * 
 * When you are done using the ExecutorService you should shut it down, so the
 * threads do not keep running.
 * 
 * For instance, if your application is started via a main() method and your
 * main thread exits your application, the application will keep running if you
 * have an active ExexutorService in your application. The active threads inside
 * this ExecutorService prevents the JVM from shutting down.
 * 
 * To terminate the threads inside the ExecutorService you call its shutdown()
 * method. The ExecutorService will not shut down immediately, but it will no
 * longer accept new tasks, and once all threads have finished current tasks,
 * the ExecutorService shuts down. All tasks submitted to the ExecutorService
 * before shutdown() is called, are executed.
 * 
 * If you want to shut down the ExecutorService immediately, you can call the
 * shutdownNow() method. This will attempt to stop all executing tasks right
 * away, and skips all submitted but non-processed tasks. There are no
 * guarantees given about the executing tasks. Perhaps they stop, perhaps the
 * execute until the end.
 * 
 * 
 * shutdownNow():
 * 
 * This method attempts to stop all actively executing tasks, halts the
 * processing of waiting tasks, and returns a list of the tasks that were
 * awaiting execution.
 * 
 * This method does not wait for actively executing tasks to terminate. Use
 * awaitTermination to do that.
 * 
 * 
 * 
 * Since ExecutorService is an interface, you need to its implementations in
 * order to make any use of it. The ExecutorService has the following
 * implementation in the java.util.concurrent package:
 * 
 * 1. ThreadPoolExecutor(c): TODO: do.google
 * 
 * The thread pool contained inside the ThreadPoolExecutor can contain a varying
 * amount of threads. The number of threads in the pool is determined by these
 * variables:
 * 
 * corePoolSize & maximumPoolSize
 * 
 * However, unless you need to specify all these parameters explicitly for your
 * ThreadPoolExecutor, it is often easier to use one of the factory methods in
 * the java.util.concurrent.Executors class.
 * 
 * 
 * 2. ScheduledThreadPoolExecutor(c): TODO: do.google
 * 
 * The java.util.concurrent.ScheduledExecutorService is an ExecutorService which
 * can schedule tasks to run after a delay, or to execute repeatedly with a
 * fixed interval of time in between each execution.
 * 
 * 
 * Creating an ExecutorService:
 * 
 * How you create an ExecutorService depends on the implementation you use.
 * However, you can use the Executors factory class to create ExecutorService
 * instances too.
 * 
 * ExecutorService executorService1 = Executors.newSingleThreadExecutor();
 * 
 * ExecutorService executorService2 = Executors.newFixedThreadPool(10);
 * 
 * ExecutorService exService3 = Executors.newSingleThreadScheduledExecutor();
 * 
 * ExecutorService executorService4 = Executors.newScheduledThreadPool(10);
 * 
 * ExecutorService executorService5 = Executors.newCachedThreadPool();
 * 
 * 
 * Note:
 * 
 * While designing web-server & application-server we can use Thread Pool
 * concept. So, Whenever a request come to web server a Thread will be allocated
 * for that request & when request complete, that Thread will come back to the
 * Thread Pool.
 * 
 * The Default Thread Pool size is 60 for most of the server. You can even
 * customize this.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > java.util.concurrent.Executor is an interface that has only one method:
 * 
 * public void execute(Runnable command)
 * 
 * ExecutorService interface extends Executor interface. While Executor allows
 * you to execute a Runnable, ExecutorService allows you to execute a Callable.
 * 
 * > Java concurrent library has several implementations for this interface such
 * as ForkJoinPool, ScheduledThreadPoolExecutor, and ThreadPoolExecutor.
 * 
 * > As instance of an Executor is created using various static factory methods
 * of java.util.concurrent.Executors such as newFixedThreadPool,
 * newSingleThreadExecutor, and newScheduledThreadPool.
 * 
 * Thus, the number of threads used by an Executor instance depends on the class
 * of that instance and how that instance was created. For example, if an
 * instance was created using Executors.newSingleThreadExecutor(), only one
 * thread will be created, but if it was created using
 * Executors.newFixedThreadPool(5), five threads will be created.
 * 
 * Note: Most of the concrete classes that implement Executor, actually
 * implement java.util.concurrent.ExecutorService interface. ExecutorService
 * extends Executor.
 */

public class Thread_T {
	public static void main(String[] args) {

		PrintJob[] jobs = { new PrintJob("Maitry"), new PrintJob("Jiya"),
				new PrintJob("Mit"), new PrintJob("Siddhi"),
				new PrintJob("Sneh") };

		int numCPUs = Runtime.getRuntime().availableProcessors();
		System.out.println("Available CPUs=" + numCPUs);

		ExecutorService service = Executors.newFixedThreadPool(numCPUs + 1);
		for (PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}
}

class PrintJob implements Runnable {

	String name;

	public PrintJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(name + " job started by thread:"
				+ Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ex) {
		}
		System.out.println(name + " job completed by thread:"
				+ Thread.currentThread().getName());
	}

}