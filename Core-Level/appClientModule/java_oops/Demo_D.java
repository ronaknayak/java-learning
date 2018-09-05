package java_oops;

/**
 * Interface Naming Conflicts:
 * 
 * 1) method naming conflicts:
 * 
 * Case 1: If two interface contains a method with the SAME SIGNATURE and with
 * the SAME RETURN TYPE and if implementation class implements both interface
 * then it would be enough to provide implementation for only one method.
 * 
 * Case 2: If two interfaces contains a method with the SAME NAME and DIFFERENT
 * ARGUMENT TYPES then in the implementation class we have to provide
 * implementation for both methods and this methods acts as overloaded methods.
 * 
 * Case 3: If two interfaces contains a method with SAME SIGNATURE but with
 * DIFFERENT RETURN TYPES then it's impossible to implement both interfaces
 * simultaneously. Otherwise, we'll get CE.
 * 
 * (It's OK, If return types are COVARIANT, but this rule is not applicable for
 * primitives. This is same as Inheritance.)
 * 
 * 
 * NOTE: A java class implements any number of interfaces simultaneously except
 * the case when two interface methods contains method with same signature but
 * with different return types.
 * 
 * 
 * 2) variable naming conflicts:
 * 
 * There may be a chance of two interfaces can contain a variable with the same
 * name and there may be a chance of variable naming conflicts. But we can solve
 * this problem by using interface names.
 */

interface First {

	void m1();

	void m2();

	Number m3();

	String loginId = "ronak.nayak";
}

interface Second {

	void m1();

	void m2(int i);

	Double m3();

	String loginId = "ronnayak";
}

public class Demo_D implements First, Second {

	@Override
	public void m1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void m2(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double m3() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printLoginId() {

		// CE: reference to loginId is ambiguous.
		// System.out.println(loginId);

		System.out.println(Second.loginId);
	}
	
	public static void main(String[] args) {
		
		First first = new Demo_D();
		System.out.println(first.loginId);
		new Demo_D().printLoginId();
	}
}
