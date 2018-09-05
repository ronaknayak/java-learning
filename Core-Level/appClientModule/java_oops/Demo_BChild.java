package java_oops;

import java.io.EOFException;
import java.io.IOException;

public class Demo_BChild extends Demo_B {

	public String checkReturnType() {
		return "";
	}

	/**
	 * CE: return type is incompatible with parent class method.
	 */
	// public Number checkReturnType(Integer i) { return 0; }

	/**
	 * CE: return type is incompatible with parent class method.
	 */
	// public int checkReturnType(double i) { return 0; }

	private void checkModifier(int i) {

	}

	// public abstract char checkModifier(char ch);

	/**
	 * CE: can't reduce the visibility of the method declared in parent class.
	 */
	// Number checkModifier(Number number) { return 0; }
	
	public void checkThrowsClause() throws Exception, RuntimeException {
	}

	public void checkThrowsClause(int i) {
	}
	
	// public void checkThrowsClause(String s) throws EOFException,
	// InterruptedException {
	// }

	public static void checkStaticMethod() {
		System.out.println("child class");
	}

	/**
	 * CE:checkStaticMethod() can't override checkStaticMethod() in parent.
	 * Overridden method is static.
	 */
	// public void checkStaticMethod() { System.out.println("child class"); }
	
	public void checkVarArg(String s, int i) {
		System.out.println("child class method in case of VAR-ARG");
	}
	
	public static void main(String[] args) {
		
		Demo_B child = new Demo_BChild();
		child.checkVarArg("Ronak", 8699);
		
	}
}
