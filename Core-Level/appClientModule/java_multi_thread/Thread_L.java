package java_multi_thread;

/**
 * 
 * Synchronized Block:
 * 
 * If very few lines of the code require Synchronization then it's not
 * recommended to declare entire method as synchronized. We have to enclose
 * those few lines of the code by using synchronized block.
 * 
 * The main advantage of synchronized block over synchronized method is it
 * reduces waiting time of Threads & improves performance of the application.
 * 
 * We can declare synchronized block as follows:
 * 
 * 1) To get a lock of current object
 * 
 * synchronized(this) {
 * 
 * }
 * 
 * If a thread got lock of current object then only it's allowed to execute this
 * area.
 * 
 * 2) To get a lock of particular object
 * 
 * synchronized(objBank) {
 * 
 * }
 * 
 * If a thread got lock of objBank object then only it's allowed to execute this
 * area.
 * 
 * 3) To get class level lock
 * 
 * synchronized(Display.class) {
 * 
 * }
 * 
 * If a thread got class level lock of class then only it's allowed to execute
 * this area.
 * 
 * 4) synchronized block concept is applicable only for objects and classes but
 * not for primitives. Otherwise, we'll get CE: Unexpected type
 * 
 * 5) Every object in a Java has unique Lock, But Thread can acquire more than
 * one lock at a time(of course from different objects).
 */

public class Thread_L {
	public static void main(String[] args) {

//		 Display display = new Display();
//		 MyThreading t1 = new MyThreading(display, "Nitin");
//		 MyThreading t2 = new MyThreading(display, "Vipul");
//		 t1.start();
//		 t2.start();

		// To get class Level Lock
		Display display1 = new Display();
		Display display2 = new Display();
		MyThreading thread1 = new MyThreading(display1, "Nitin");
		MyThreading thread2 = new MyThreading(display2, "Vipul");
		thread1.start();
		thread2.start();
	}
}
