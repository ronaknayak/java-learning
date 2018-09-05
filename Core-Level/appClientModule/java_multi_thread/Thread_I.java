package java_multi_thread;

/**
 * Interruption of a Thread:
 * 
 * A Thread can interrupt another sleeping or waiting Thread by interrupt()
 * method of a Thread class. Sometimes, It requires to interrupt other Thread.
 * 
 * Signature:
 * 
 * public void interrupt()
 * 
 * calling interrupt() will cause an InterruptedException ONLY if the thread on
 * which interrupt() is called, is blocked on an invocation of the wait(...),
 * join(...), or sleep(...), methods of this class.
 * 
 * 
 * Note:
 * 
 * 1) Whenever we are calling interrupt() method, if the target thread not in
 * sleeping state or waiting state then there is no impact of interrupt call
 * immediately.
 * 
 * Interrupt call will be waited until target thread entered into sleeping or
 * waiting state. If the target thread entered into sleeping or waiting state
 * then immediately interrupt call will interrupt the target thread.
 * 
 * 2) If the target thread never entered into sleeping or waiting state in it's
 * life time then there is no impact of interrupt call. This is the only case
 * where interrupt call will be wasted.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * If the thread on which interrupt() is called, is blocked in an invocation of
 * the wait(...), join(...), or sleep(...), methods, then its interrupt status
 * will be cleared and that thread (not the caller of interrupt) will receive an
 * InterruptedException.
 * 
 * 
 * 
 * TODO: summary of three methods from video as well as eBook.
 */

public class Thread_I {

	public static void main(String[] args) {
		MyThreadFive five = new MyThreadFive();
		five.start();

		five.interrupt();
		System.out.println("End of the main thread execution");
	}
}

class MyThreadFive extends Thread {

	@Override
	public void run() {
		super.run();

		try {
			for (int i = 0; i < 100000; i++) {
				System.out.println("It's a Lazy Thread" + i);
				if (i == 90000)
					Thread.sleep(1000);
			}
		} catch (InterruptedException ie) {
			System.out.println("Thread got interrupted");
		}
	}
}
