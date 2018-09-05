package test;

import java_access_modifiers.Demo_C;

public class Test4 extends TestProtected {
	public static void main(String[] args) {

		Test4 test = new Test4();
		test.property();

		// TestProtected testProtected = new TestProtected();
		// testProtected.property();
	}
}

class TestProtected extends Demo_C {
	
	
	public static void main(String[] args) {

		Test4 test = new Test4();
		test.property();

		TestProtected testProtected = new TestProtected();
		testProtected.property();

		Demo_C c = new TestProtected();
		// c.property();

		Demo_C c1 = new Test4();
		// c1.property();
	}
}
