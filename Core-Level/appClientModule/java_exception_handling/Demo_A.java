package java_exception_handling;

/**
 * Exception:
 * 
 * -> An unexpected, unwanted event that disturbs normal flow of the program is
 * called exception. e.g. SleepingException, FileNotFoundException etc.
 * 
 * -> It's highly recommended to handle exception and the main objective of
 * exception handling is graceful termination of the program.
 * 
 * e.g. To close the database connection if SQLException occurred.So, that it
 * can be use for the next request.
 * 
 * -> Exception handling does not mean repairing an exception. we have to
 * provide ALTERNATIVE WAY to continue rest of the program normally is the
 * concept of exception handling.
 * 
 * 
 * Runtime stack mechanism:
 * 
 * -> For every thread JVM will create a runtime stack.
 * 
 * -> Each and every method call performed by that thread will stored in
 * corresponding stack.
 * 
 * -> Each entry in the stack is called stack frame or activation record.
 * 
 * -> After completing every method call the corresponding entry from the stack
 * will be removed.
 * 
 * -> After completing all method call the stack will become empty and that
 * empty stack will be destroyed by JVM, just before terminating that thread.
 * 
 * 
 * Default exception handling in JAVA:
 * 
 * -> If any exception raised, the method in which it's raised is responsible to
 * create exception object by following information,
 * 
 * 1.Name of the exception
 * 
 * 2.Description
 * 
 * 3.Location (Stack trace)
 * 
 * 
 * -> After creating exception object, method hand over that object to the JVM.
 * 
 * -> JVM checks whether method contains exception handling code or not.
 * 
 * -> If it does not contain handling code then JVM terminates that method
 * abnormally and remove corresponding entry from the stack.
 * 
 * -> JVM identifies caller method and check whether caller method contains any
 * handling code or not. If the caller does not contain handling code then JVM
 * terminate that caller method also abnormally and removes corresponding entry
 * from the stack.
 * 
 * -> This process will be continued until main method and if the main method
 * also does not contain handling code then JVM terminates main method
 * abnormally and removes corresponding entry from the stack.
 * 
 * -> Then JVM hand over responsibility of exception handling to the default
 * exception handler, which is part of JVM and which throws exception as,
 * " Exception in thread "main" ExceptionClassName "
 */

public class Demo_A {

	/*
	 * Note: In a program if at least one method terminate abnormally then the
	 * program termination is abnormal termination. If all methods terminated
	 * normally then only program is normal termination.
	 */

	public static void main(String[] args) {
		doStuff();
		System.out.println("terminate main abnormally");
	}

	public static void doStuff() {
		doMoreStuff();
		System.out.println("terminate doStuff abnormally");
	}

	public static void doMoreStuff() {
		throw new IllegalArgumentException();
	}
}
