package java_multi_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CallablE & Future:
 * ---------------------------------------------------------------------------
 * In the case of Runnable job Thread won't return anything after completing the
 * job.
 * 
 * If a Thread is required to return some result after execution then we should
 * go for CallablE interface.
 * 
 * CallablE interface contains only one method:
 * 
 * public T call() throws Exception {
 * 
 * }
 * 
 * If we submit CallablE object to Executor, then after completing the job,
 * Thread returns an Object of the type Future. i.e. Future object can be used
 * to retrieve the result from CallablE job.
 * 
 * 
 * CallablE VS Runnable:
 * 
 * If a Thread not required to return anything after completing the job then we
 * should go for Runnable.
 * 
 * If a Thread required to return something after completing the job then we
 * should go for CallablE.
 * 
 * Runnable interface contains only one method: run() & it has not required to
 * return anything and hence, return type is void.
 * 
 * CallablE interface contains only one method: call() & it has to return
 * something and hence, return type is Object.
 * 
 * Within the run(), If there is any chance of raising checked exceptions
 * compulsory we should handle by using try-catch. Because we can't use throws
 * keyword for run() method as parent class run() does not throw any checked
 * exception.
 * 
 * Within the call(), If there is any chance of raising checked exceptions we
 * are not required to handle by using try-catch because parent call() method
 * already throws Exception class.
 * 
 * Runnable interface is present in java.lang package whereas CallablE interface
 * present in java.util.concurrent package.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > A Callable cannot be passed to Thread for Thread creation but a Runnable
 * can be. i.e. new Thread( aRunnable ); is valid. Therefore, if you want to
 * execute a task directly in a Thread, a Callable is not suitable. You will
 * need to use a Runnable.
 * 
 * > Both Callable and Runnable can be used to execute a task asynchronously. If
 * the task does not return any result, neither is more appropriate than the
 * other. However, if the task returns a result, which you want to collect
 * asynchronously later, Callable is more appropriate.
 * 
 * > Both Runnable & Callable can be used with an ExecutorService.
 * 
 * <T> Future<T> submit(Callable<T> task) and Future<?> submit(Runnable task)
 * 
 * Observe that even though a Runnable's run() method cannot return a value, the
 * ExecutorService.submit(Runnable) returns a Future. The Future's get method
 * will return null upon successful completion.
 */

public class Thread_U {
	public static void main(String[] args) throws InterruptedException {

		MyCallable[] jobs = { new MyCallable(10), new MyCallable(20),
				new MyCallable(30), new MyCallable(40), new MyCallable(50),
				new MyCallable(60), };

		ExecutorService service = Executors.newFixedThreadPool(3);
		for (MyCallable job : jobs) {
			/**
			 * Remember that Future.get() will block until there is a value to
			 * return or there is an exception.
			 * 
			 * If you don't want to block the code, you may use Future.isDone(),
			 * which returns a boolean without blocking.
			 */
			Future<Integer> future = service.submit(job);

			while (!future.isDone()) {
				Thread.sleep(1000);
			}
			try {
				int result = future.get();
				System.out.println("Callable returned: " + result);
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}
		}
		service.shutdown();
	}
}

class MyCallable implements Callable<Integer> {

	int number;

	public MyCallable(int num) {
		number = num;
	}

	@Override
	public Integer call() throws Exception {

		System.out.println(Thread.currentThread().getName()
				+ " is responsible to find sum of the first " + number
				+ " numbers.");
		int sum = 0;
		for (int iCounter = 0; iCounter < number; iCounter++) {
			sum += iCounter;
		}
		return sum;
	}
}