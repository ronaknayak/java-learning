package java_multi_thread;

import java.util.Random;

/**
 * ThreadLocal:
 * --------------------------------------------------------------------------
 * ThreadLocal class avails ThreadLocal variables. ThreadLocal class maintains
 * per Thread basis.
 * 
 * Each ThreadLocal object maintains a separate value like userId, transactionId
 * etc for each thread that accesses that object.
 * 
 * Thread can access it's local value, can manipulate it's value & even can
 * remove it's value.
 * 
 * Thread Local can be considered as a scope of access, like a request scope or
 * session scope. It’s a thread scope. You can set any object in Thread Local
 * and this object will be global and local to the specific thread which is
 * accessing this object.
 * 
 * Values stored in Thread Local are global to the thread, meaning that they can
 * be accessed from anywhere inside that thread. If a thread calls methods from
 * several classes, then all the methods can see the ThreadLocal variable set by
 * other methods (because they are executing in same thread). The value need not
 * be passed explicitly. It’s like how you use global variables.
 * 
 * Values stored in Thread Local are local to the thread, meaning that each
 * thread will have it’s own Thread Local variable. One thread can not
 * access/modify other thread’s Thread Local variables.
 * 
 * 
 * USE CASE:
 * ==========================================================================
 * Consider you have a Servlet which calls some business methods. You have a
 * requirement to generate a unique transaction id for each and every request
 * this servlet process and you need to pass this transaction id to the business
 * methods, for logging purpose. One solution would be passing this transaction
 * id as a parameter to all the business methods. But this is not a good
 * solution as the code is redundant and unnecessary.
 * 
 * To solve that, you can use Thread Local. You can generate a transaction id
 * (either in servlet or better in a filter) and set it in the Thread Local.
 * After this, what ever the business method, that this servlet calls, can
 * access the transaction id from the thread local.
 * 
 * This servlet might be servicing more that one request at a time. Since each
 * request is processed in separate thread, the transaction id will be unique to
 * each thread (local) and will be accessible from all over the thread’s
 * execution (global).
 * 
 * 
 * NOTE:
 * 
 * ThreadLocal class introduced in 1.2 version & enhanced in 1.5 version.
 * ThreadLocal can be associated with thread scope. Total code which is executed
 * by Thread has access to corresponding Thread local variable.
 * 
 * A Thread can access it's own local variables & can't access other Thread
 * local variables.
 * 
 * Once Thread entered into Dead state all it's local variables are by default
 * eligible for garbage collections.
 * 
 * 
 * Constructors:
 * 
 * ThreadLocal t = new ThreadLocal();
 * 
 * Created a ThreadLocal variable.
 * 
 * 
 * ThreadLocal class Methods:
 * ----------------------------------------------------------------------------
 * Object get()
 * 
 * Returns the value of the ThreadLocal variable associated with current thread.
 * 
 * void set(Object newValue)
 * 
 * To set a new value.
 * 
 * Object initialValue()
 * 
 * Returns initial value of ThreadLocal variable associated with current thread.
 * The default implementation of this method returns null. To customize our own
 * initial value we have to override this method.
 * 
 * void remove()
 * 
 * To remove the value of the ThreadLocal variable associated with current
 * thread. After removal If we are trying to access, it'll be reinitialized once
 * again by invoking it's initial value method.
 */

public class Thread_V {
	public static void main(String[] args) {

		ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

		System.out.println(threadLocal.get());
		threadLocal.set("Saturday");
		System.out.println(threadLocal.get());
		threadLocal.remove();
		System.out.println(threadLocal.get());
		System.out
				.println("--------OVERRIDING of initialValue() method--------");
		ThreadLocal<Object> local = new ThreadLocal<Object>() {

			public Object initialValue() {
				return "Init for ThreadLocal Var";
			}

		};

		System.out.println(local.get());
		local.set("Saturday");
		System.out.println(local.get());
		local.remove();
		System.out.println(local.get());

		TransactionProcess transactionProcessFirst = new TransactionProcess();
		transactionProcessFirst.start();

		TransactionProcess transactionProcessSec = new TransactionProcess();
		transactionProcessSec.start();
	}
}

class Context {
	private String transactionId = null;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}

class TransactionModel {

	public static final ThreadLocal userThreadLocal = new ThreadLocal();

	public static void set(Context user) {
		userThreadLocal.set(user);
	}

	public static void unset() {
		userThreadLocal.remove();
	}

	public static Context get() {
		return (Context) userThreadLocal.get();
	}
}

class TransactionProcess extends Thread {

	@Override
	public void run() {
		Context context = new Context();
		context.setTransactionId(String.valueOf(new Random().nextInt(100000)));

		// set the context object in thread local to access it somewhere else
		TransactionModel.set(context);

		/* note that we are not explicitly passing the transaction id */
		new BusinessService().businessMethod();
		TransactionModel.unset();
	}
}

class BusinessService {

	public void businessMethod() {
		// get the context from thread local
		Context context = TransactionModel.get();
		System.out.println(context.getTransactionId());
	}
}