package java_oops;

/**
 * Instance Control Flow:
 * 
 * Process:
 * 
 * Whenever we are executing a Java class first static control flow will be
 * executed. In the static control flow, If we are creating an object the
 * following sequence of events will be executed as a part of instance control
 * flow:
 * 
 * 1) Identification of instance members from top-to-bottom.
 * 
 * 2) Execution of instance variable assignment and instance blocks from
 * top-to-bottom.
 * 
 * 3) Execution of constructor.
 * 
 * 
 * NOTE: Static control flow is one time activity which will be performed at the
 * time of class loading. But, Instance control flow is not one time activity &
 * It'll be performed for every object creation.
 */

public class Demo_H {
	int x = 10;

	{
		m();
		System.out.println("First Instance Block");
	}

	Demo_H() {
		System.out.println("Constructor Executed");
	}

	public static void main(String[] args) {
		System.out.println("Main Method");
		new Demo_H();
	}

	void m() {
		System.out.println("Retrived: " + y);
	}

	int y = 20;

	{
		m();
		System.out.println("Second Instance Block");
	}

}
