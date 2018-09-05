package java_oops;

/**
 * Static & Instance control flow:
 */

public class Demo_J {
	
	{
		System.out.println("First instance block");
	}
	
	static {
		System.out.println("First static block");
	}
	
	Demo_J() {
		System.out.println("Constructor executed");
	}
	
	public static void main(String[] args) {
		System.out.println("Main method");
		new Demo_J();
		System.out.println("--------Instance control flow is not one time activity------");
		new Demo_J();
	}
	
	{
		System.out.println("Second instance block");
	}
	
	static {
		System.out.println("Second static block");
	}
}
