package java_multi_thread;

/**
 * ThreadGroup:
 * 
 * Java provides a convenient way to group multiple threads in a single object.
 * In such way, we can suspend, resume or interrupt group of threads by a single
 * method call.
 * 
 * Note: Now suspend(), resume() and stop() methods are deprecated.
 * 
 * Based on functionality we can group threads into a single unit which is
 * nothing but ThreadGroup. i.e.ThreadGroup contains a group of threads.
 * 
 * In addition to threads, ThreadGroup can also contains sub thread groups.
 * 
 * The main advantage of maintaining threads in the form of ThreadGroup is we
 * can perform common operation very easily.
 * 
 * Every Thread in Java belongs to some group. main thread belongs to main
 * group.
 * 
 * Every ThreadGroup in Java is the child group of system group either directly
 * or indirectly. Hence, system group acts as root for all ThreadGroups in Java.
 * 
 * main thread group contains main thread, Thread-0, sub thread group etc.
 * 
 * ThreadGroup is a Java class present in java.lang package & it's the direct
 * child class of Object class.
 * 
 * 
 * Constructors:
 * 
 * ThreadGroup g = new ThreadGroup(String groupName);
 * 
 * Creates a new ThreadGroup with a specified group name. The parent of this new
 * group is the ThreadGroup of currently executing thread.
 * 
 * ThreadGroup g = new ThreadGroup(ThreadGroup parentGroup, String groupName);
 * 
 * Creates a new ThreadGroup with specified group name. The parent of this new
 * ThreadGroup is specified parent group.
 * 
 * 
 * ThreadGroup class Methods:
 * ***************************************************************************
 * 
 * String getName()
 * 
 * returns name of the ThreadGroup.
 * 
 * ----------------------------------------------------------
 * 
 * int getMaxPriority()
 * 
 * returns max priority of ThreadGroup.
 * 
 * ----------------------------------------------------------
 * 
 * void setMaxPriority(int p)
 * 
 * To set maximum priority of ThreadGroup. The Default max priority is 10.
 * 
 * Note: Threads in the ThreadGroup that already have higher priority won't be
 * affected. But, for newly added threads this max priority is applicable.
 * 
 * ----------------------------------------------------------
 * 
 * ThreadGroup getParent()
 * 
 * returns parent group of current thread.
 * 
 * ----------------------------------------------------------
 * 
 * void list()
 * 
 * It prints information about ThreadGroup to the console.
 * 
 * ----------------------------------------------------------
 * 
 * int activeCount()
 * 
 * returns number of active threads present in the ThreadGroup.
 * 
 * ----------------------------------------------------------
 * 
 * int activeGroupCount()
 * 
 * returns number of active groups present in the current ThreadGroup.
 * 
 * ----------------------------------------------------------
 * 
 * int enumerate(Thread[] t)
 * 
 * To copy all active threads of this ThreadGroup into provided thread array.
 * 
 * ----------------------------------------------------------
 * 
 * int enumerate(ThreadGroup[] threadGroup)
 * 
 * To copy all active sub-thread groups into ThreadGroup array.
 * 
 * ----------------------------------------------------------
 * 
 * boolean isDaemon()
 * 
 * To check whether the ThreadGroup is daemon or not.
 * 
 * void setDaemon(boolean b)
 * 
 * ----------------------------------------------------------
 * 
 * void interrupt()
 * 
 * To interrupt all waiting or sleeping threads present in the ThreadGroup.
 * 
 * ----------------------------------------------------------
 * 
 * void destroy()
 * 
 * To destroy ThreadGroup & it's sub-thread groups.
 */

public class Thread_R {
	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getThreadGroup().getName());

		System.out.println(Thread.currentThread().getThreadGroup().getParent()
				.getName());

		ThreadGroup group = new ThreadGroup("First Group");
		System.out.println(group.getParent().getName());

		// Here, Parent group: First Group & Child group: Second Group
		ThreadGroup threadGroup = new ThreadGroup(group, "Second Group");
		System.out.println(threadGroup.getParent().getName());

		ThreadGroup parentGroup = new ThreadGroup("Parent Group");
		ThreadGroup childGroup = new ThreadGroup(parentGroup, "Child Group");

		MyThreadGroup myThread = new MyThreadGroup(parentGroup,
				"Child Thread-1");
		MyThreadGroup myThread2 = new MyThreadGroup(parentGroup,
				"Child Thread-2");
		myThread.start();
		myThread2.start();

		System.out.println(parentGroup.activeCount());
		System.out.println(parentGroup.activeGroupCount());
		parentGroup.list();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		System.out.println(parentGroup.activeCount());
		System.out.println(parentGroup.activeGroupCount());
		parentGroup.list();

		ThreadGroup system = Thread.currentThread().getThreadGroup()
				.getParent();
		Thread[] threadArray = new Thread[system.activeCount()];

		system.enumerate(threadArray);
		for (Thread thread : threadArray) {
			System.out.println(thread.getName() + "-----" + thread.isDaemon());
		}
	}
}

class MyThreadGroup extends Thread {

	public MyThreadGroup(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
}