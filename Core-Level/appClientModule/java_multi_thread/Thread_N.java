package java_multi_thread;

import java.util.Stack;

/**
 * notify() VS notifyAll()
 * 
 * We can use notify() to give the notification for only one waiting thread.
 * 
 * If a multiplE threads are waiting then only one thread will be notified & the
 * remaining threads have to wait for further notifications. Which thread will
 * be notified we can't expect. It depends on JVM.
 * 
 * We can use notifyAll() to give the notification for all waiting threads of a
 * PARTICULAR OBJECT. Even though multiplE threads notified but execution will
 * be performed one by one. Because threads required Lock & only one Lock is
 * available.
 */

public class Thread_N {
	public static void main(String[] args) {

		/**
		 * Note: On which object we are calling wait() method thread required
		 * the lock of that particular object.
		 * 
		 * For example, If we are calling wait() method on stack object then we
		 * have to get Lock of stack object but not of stack2 object. Otherwise,
		 * we'll get RuntimeException saying IllegalMonitorStateException.
		 */
		Stack<String> stack = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();

		synchronized (stack) {
			try {
				stack2.wait();
			} catch (InterruptedException e) {
			}
		}
	}
}
