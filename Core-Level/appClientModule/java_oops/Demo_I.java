package java_oops;

/**
 * Instance control flow from Parent to Child:
 * 
 * Process:
 * 
 * If we are creating an object of Child class following sequence of events will
 * be executed as a part of instance control flow:
 * 
 * 1) Identification of instance members from PARENT to CHILD.
 * 
 * 2) Execution of instance variable assignments & instance blocks only in
 * PARENT class.
 * 
 * 3) Execution of PARENT class constructor.
 * 
 * 4) Execution of instance variable assignments & instance blocks only in CHILD
 * class.
 * 
 * 5) Execution of CHILD class constructor.
 */

public class Demo_I extends Parent {

	{
		m1();
		System.out.println("Child Instance Block");
	}

	Demo_I() {
		System.out.println("Child Constructor Executed");
	}

	public static void main(String[] args) {
		System.out.println("Main Method - Child");
		new Demo_I();
	}

	void m1() {
		System.out.println("Child: " + x);
	}

	int x = 200;
}

class Parent {

	{
		m();
		System.out.println("Parent Instance Block");
	}

	Parent() {
		System.out.println("Parent Constructor Executed");
	}

	public static void main(String[] args) {
		System.out.println("Main Method - Parent");
		new Parent();
	}

	void m() {
		System.out.println("Parent: " + y);
	}

	int y = 20;
}