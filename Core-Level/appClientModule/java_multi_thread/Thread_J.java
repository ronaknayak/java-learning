package java_multi_thread;

/**
 * Synchronization:
 * 
 * Synchronized is the modifier applicable only for methods & blocks but not for
 * classes & variables.
 * 
 * If a muliplE threads are trying to operate simultaneously on the same Java
 * Object then there may be a chance of Data Inconsistency problem. This is
 * nothing but RACE CONDITION. To overcome this problem we should go for
 * Synchronized keyword.
 * 
 * There are two types of thread synchronization mutual exclusive and
 * Inter_Thread communication.
 * 
 * 1. Mutual Exclusive (Synchronized method, Synchronized block, static
 * synchronization)
 * 
 * 2. Cooperation (Inter_thread communication in java)
 * 
 * 
 * If a method or block declared as a Synchronized then at a time only one
 * Thread is allowed to execute that method or block on the given Object. So
 * that, Data Inconsistency problem will be resolved.
 * 
 * The main advantage of Synchronized keyword is we can resolve Data
 * Inconsistency problems. But, The main disadvantage of Synchronized keyword is
 * It increases waiting time of Threads and create performance problems. Hence,
 * If there is no specific requirement then It's not recommended to use
 * Synchronized keyword.
 * 
 * 
 * Internally, Synchronization concept is implemented by using Lock. Every
 * object in Java has a unique Lock. Whenever we are using Synchronized keyword
 * then only Lock concept will come into the picture.
 * 
 * If a thread wants to execute Synchronized method on the given object first It
 * has to get Lock of that object. Once Thread got the Lock then it's allowed to
 * execute any Synchronized method on that object. Once method execution
 * completes, automatically Thread releases Lock.
 * 
 * Acquiring & Releasing Lock internally takes care by JVM & programmer not
 * responsible for this activity.
 * 
 * Synchronized method is used to lock an object for any shared resource.
 * 
 * While a Thread executing Synchronized method on the given object the
 * remaining Threads are not allowed to execute any Synchronized method
 * simultaneously on the same object. But, Remaining Threads are allowed to
 * execute Non-Synchronized methods simultaneously.
 * 
 * Important Note: Lock concept is implemented based on Object but not based on
 * Method.
 * 
 * 
 * Synchronized Area:
 * 
 * This area can be accessed by only one Thread at a time because in this area
 * object state changing operation will be performed.
 * 
 * i.e. Update, Delete operation would be perform in Synchronized area. e.g. In
 * Reservation System bookTicket() should be Synchronized.
 * 
 * Non-Synchronized Area: This area can be accessed by any number of Threads
 * simultaneously. Object state changing operation should not be perform here as
 * it cause Data Inconsistency issue.
 * 
 * i.e.Read operation can be perform in Non-Synchronized area. e.g. In
 * Reservation System checkAvailability() should be Non-Synchronized.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > A synchronized method is similar to any other method except that only one
 * thread can be in it at a given time. This means it can access all the
 * variables that are otherwise accessible to it.
 * 
 * A thread can enter a synchronized method only after it acquires a lock. Note
 * that acquiring a lock is necessary only for entering synchronized methods,
 * there is no need to get a lock (of the object on which it is trying to
 * execute the method) for entering a normal method.
 * 
 * This means if Thread T1 is in a synchronized method sM1() then Thread T2 can
 * enter any other non-synchronized method. But T2 CANNOT enter sM1() or any
 * other synchronized method because there is only one lock with one object
 * which is already taken by T1. A thread can re-acquire a lock. This means once
 * it enters a synchronized method sm1() it can call any other synchronized
 * method within it. Hence there is no DEADLOCK.
 * 
 * > The Java memory model does not guarantee any updates made to a non-volatile
 * field from one thread to be visible to another thread if the field is not
 * accessed through a synchronized block. So, either we should keep that
 * variable accessible through synchronized area or make it volatile.
 */

public class Thread_J {
	public static void main(String[] args) {
		// Only one object
		Display display = new Display();

		MyThreading thread_1 = new MyThreading(display, "Nitin");
		MyThreadingNext thread_2 = new MyThreadingNext(display, "Vipul");
		MyThreadingAgain thread_3 = new MyThreadingAgain(display, "Prakash");

		thread_1.start();
		thread_2.start();
		thread_3.start();

		/*
		 * There are three threads having different and independent job but
		 * somehow they have to deal with wish() method of Display object.
		 * 
		 * In this case we would get irregular output. i.e. Data Inconsistency
		 * Problem.
		 * 
		 * To overcome this problem we have to declare wish() as Synchronized.
		 * This way we would get Regular output. But, we can't expect that which
		 * thread will execute first.
		 */
	}
}

class Display {
	/**
	 * This cause Data inconsistency issue.
	 */
//	 public void wish(String name) {
//	 for (int i = 0; i < 10; i++) {
//	 System.out.print("Good Morning	");
//	 try {
//	 Thread.sleep(2000);
//	 } catch (InterruptedException e) {
//	 e.printStackTrace();
//	 }
//	 System.out.println(name);
//	 }
//	 }

	/**
	 * This would resolve Data inconsistency issue.
	 */
	 public synchronized void wish(String name) {
	 for (int i = 0; i < 10; i++) {
	 System.out.print("Good Morning	");
	 try {
	 Thread.sleep(500);
	 } catch (InterruptedException e) {
	 e.printStackTrace();
	 }
	 System.out.println(name);
	 }
	 }

	/**
	 * static synchronized method.
	 */
	// public static synchronized void wish(String name) {
	// for (int i = 0; i < 10; i++) {
	// System.out.print("Good Morning	");
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println(name);
	// }
	// }

	/**
	 * Recommended approach to implement synchronized method.
	 */
//	public void wish(String name) {
//		// Thousand lines of code which no need to synchronized
//		synchronized (this) {
//			for (int i = 0; i < 10; i++) {
//				System.out.print("Good Morning	");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(name);
//			}
//		}
//		// Thousand lines of code which no need to synchronized
//	}

	// public static synchronized void wish(String name) {
	// // To get class level lock
	// synchronized (Display.class) {
	//
	// for (int i = 0; i < 10; i++) {
	// System.out.print("Good Morning	");
	// try {
	// Thread.sleep(2000);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// System.out.println(name);
	// }
	// }
	//
	// }
}

class MyThreading extends Thread {
	Display display;
	String name;

	public MyThreading(Display display, String name) {
		this.display = display;
		this.name = name;
	}

	@Override
	public void run() {
		display.wish(name);
	}
}

class MyThreadingNext extends Thread {
	Display display;
	String name;

	public MyThreadingNext(Display display, String name) {
		this.display = display;
		this.name = name;
	}

	@Override
	public void run() {
		display.wish(name);
	}
}

class MyThreadingAgain extends Thread {
	Display display;
	String name;

	public MyThreadingAgain(Display display, String name) {
		this.display = display;
		this.name = name;
	}

	@Override
	public void run() {
		display.wish(name);
	}
}