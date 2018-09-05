package java_oops;

/**
 * Static control flow in Parent to Child relationship:
 * 
 * 
 * Process:
 * 
 * Whenever we are trying to load child class then automatically parent class
 * will be loaded to make parent class members by default available to the child
 * classes. i.e. Two .class files will be generated.
 * 
 * Hence, whenever we are executing child class the following sequence of events
 * will be executed automatically as a part of static control flow.
 * 
 * 1) Identification of static members from parent to child.
 * 
 * 2) Execution of static variable assignments and static blocks from
 * Parent-to-Child.
 * 
 * 3) Execution of only Child class main() method.
 * 
 *
 * Note: Whenever we are trying to load child class then automatically parent
 * class will be loaded to make parent class members by default available to the
 * child classes. But, whenever we are loading parent class child class won't be
 * loaded because child class members by default won't be available to parent
 * class.
 */

class Demo_G extends Base {
	static int x = 100;

	static {
		m2();
		System.out.println("Derived class static block");
	}

	public static void main(String[] args) {
		System.out.println("Derived class main method");
		m2();
	}

	static void m2() {
		System.out.println("m2() method retrive " + j);
	}

	static int j = 200;
}

class Base {
	static int x = 10;

	static {
		m1();
		System.out.println("Base class static block");
	}

	public static void main(String[] args) {
		System.out.println("Base class main method");
		m1();
	}

	static void m1() {
		System.out.println("m1() method retrive " + j);
	}

	static int j = 20;
}
