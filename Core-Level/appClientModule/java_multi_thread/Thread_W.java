package java_multi_thread;

/**
 * Inheritance VS ThreadLocal:
 * ------------------------------------------------------------------------
 * Parent threads ThreadLocal variable by default not available to the Child
 * Thread.
 * 
 * If we want to make Parent Thread ThreadLocal value available to the Child
 * Thread then we should go for InheritableThreadLocal class.
 * 
 * By default, Child Thread value is exactly same as Parent Thread value but we
 * can provide customized value to Child Thread by Overriding childValue()
 * method in Parent Thread.
 * 
 * Constructor:
 * 
 * InheritableThreadLocal t = new InheritableThreadLocal();
 * 
 * InheritableThreadLocal class Methods:
 * 
 * InheritableThreadLocal is the child class of ThreadLocal & hence all methods
 * present in ThreadLocal by default available to InheritableThreadLocal class.
 * i.e. ThreadLocal ----> InheritableThreadLocal
 * 
 * In addition to this methods,
 * 
 * public Object childValue(Object parentValue) {
 * 
 * }
 * 
 * If we use ThreadLocal instead of InheritableThreadLocal & if we are not
 * overriding childValue() method then the output is null value for Child
 * Thread.
 * 
 * If we maintaining InheritableThreadLocal class & If we are not overriding
 * childValue() then Child Thread will have same value as Parent Thread.
 */

public class Thread_W {
	public static void main(String[] args) {

		ParentThread parentThread = new ParentThread();
		parentThread.start();
	}
}

class ParentThread extends Thread {

	public static InheritableThreadLocal<String> local = new InheritableThreadLocal<String>() {

		@Override
		protected String childValue(String parentValue) {
			return "CHILD THREAD VALUE";
		};
	};
	
	//public static InheritableThreadLocal<String> local = new InheritableThreadLocal<String>();
	
	@Override
	public void run() {
		local.set("PARENT THREAD VALUE");
		System.out.println("parent thread value:" + local.get());

		ChildThread childThread = new ChildThread();
		childThread.start();
	};
}

class ChildThread extends Thread {

	@Override
	public void run() {
		System.out.println("child thread value:" + ParentThread.local.get());
	}
}
