package java_oops;

/**
 * Static Block:
 * 
 * static blocks will be executed at the time of class loading. Hence, at the
 * time of class loading If we want to perform any activity then we have to
 * define that inside static block.
 * 
 * Within a class we can take any number of static blocks but all these static
 * block will be executed from top-to-bottom.
 * 
 * 
 * When to use:
 * 
 * Example 1: At the time of Java class loading the corresponding native
 * libraries should be loaded. Hence, we have to define this activity inside
 * static block.
 * 
 * Example 2: After loading every database driver class
 * (e.g.com.mysql.jdbc.Driver) we have to register driver class with
 * DriverManager. But, Inside database driver class there is a static block to
 * perform this activity & we are NOT RESPONSIBLE to register explicitly.
 */

public class Demo_F {

	// Different ways to use static member

	static String var = m();
	static ConstructorCall call = new ConstructorCall(0);

	static {
		System.out.println("static block executed");
		// System.loadLibrary("Native_Library_Path");
	}

	static String m() {
		System.out.println("static variable assignment");
		return "";
	}

	public static void main(String[] args) {
		System.out.println("main method");
	}
}

class ConstructorCall {

	public ConstructorCall(int num) {
		System.out.println("ConstructorCall object created: " + num);
	}
}