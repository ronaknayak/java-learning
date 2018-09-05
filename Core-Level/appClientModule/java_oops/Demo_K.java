package java_oops;

import java.io.IOException;

/**
 * Constructors:
 * 
 * Once we creates an object, the properties will be assigned default values.
 * Now, compulsory we should perform initialization then only object in a
 * position to respond properly.
 * 
 * Whenever we are creating an object using new keyword some peace of the code
 * will be executed automatically to perform initialization for the newly
 * created object. This peace of code is nothing but constructor.
 * 
 * It's especially designed concept to perform INITIALIZATION for the newly
 * created object.
 * 
 * Significance of Constructor:
 * 
 * The main purpose of constructor to perform INITIALIZATION OF AN OBJECT but
 * NOT TO CREATE AN OBJECT.
 * 
 * *******************************************************************
 * 
 * Constructor VS Instance block:
 * 
 * Other than initialization, If we want to perform any activity for every
 * object creation then we should go for Instance block. (Like, Perform update
 * operation in DB before creating an object.)
 * 
 * Both, constructors and instance block will be executed for every object
 * creation but Instance block first followed by constructor.
 * 
 * e.g. class Student {
 * 
 * { Instance block }
 * 
 * Student() {}
 * 
 * }
 * 
 * After compilation It'll become as,
 * 
 * class Student {
 * 
 * Student() {
 * 
 * { Instance block } }
 * 
 * }
 * 
 * 
 * RULES to define constructor:
 * 
 * 1) The name of the class & name of the constructor must be matched.
 * 
 * 2) Return type concept is not applicable for constructor not even void
 * because we are not calling constructor. It called automatically whenever we
 * are creating an object.
 * 
 * 3) The only modifiers which are applicable for constructors are public,
 * private, protected and <DEFAULT>. If we use any other modifier then we'll get
 * CE.
 * 
 * **************************************************************************
 * 
 * Default constructor:
 * 
 * Compiler is responsible to generate default constructor.
 * 
 * If we are not writing any constructor then only compiler always generate
 * default constructor.
 * 
 * If we are writing at least one constructor then compiler won't generate
 * default constructor.
 * 
 * Creating an object using the new operator with the implicit default
 * constructor will initialize the fields of the object to their default values.
 * i.e. All instance variable will be initialized.
 * 
 * 
 * Prototype:
 * 
 * - It's always NO-ARG constructor.
 * 
 * - The access modifier for default constructor is exactly same as class but
 * this rule is applicable only for PUBLIC & <DEFALUT>.
 * 
 * - It contains only one line whether we declare or not and it's a no argument
 * call to super class constructor.
 * 
 * 
 * Super & This:
 * 
 * The first line inside a constructor should be either super() or this() & If
 * we are not writing anything then compiler will always place super().
 * 
 * CASE 1 - We can take super() or this() only in first line of constructor.
 * 
 * CASE 2 - Within constructor we can take super() or this() but not
 * simultaneously.
 * 
 * CASE 3 - We can use super() and this() only inside constructor. i.e. We can
 * call a constructor directly from another constructor only.
 * 
 * ========================================================================
 * 
 * Important Conclusions:
 * 
 * - Inheritance and overriding concepts are not applicable for constructors.
 * 
 * - Recursive method call is always runtime exception where as recursive
 * constructor invocation is a compile time error.
 * 
 * - Whenever we are writing any argument constructor in parent class then it's
 * good programming practice to write DEFAULT constructor also. Because of
 * super(), parent class DEFAULT constructor will executed while writing child
 * class and it raise CE if compiler don't find DEFAULT constructor.
 * 
 * - If parent class constructor throws some checked exception compulsory child
 * class constructor throws same checked exception or it's parent. Otherwise
 * we'll get CE.
 * 
 * REASON: This is because, If we call any method which throws some checked
 * exception then our caller method has to handle. Similarly, while executing
 * child class constructor it calls super class constructor. i.e. Child class
 * becomes caller of the parent class constructor.
 * 
 * class Child { Child() throws Exception { super(); } }
 * 
 * General LOOPHOLES with Constructor:
 * ---------------------------------------------------------------------------
 *
 * -> Why Parent class constructor executed when Child class object created ?
 * 
 * Whenever we are creating Child class object automatically Parent constructor
 * will be executed to perform initialization for the instance variables which
 * are inheriting from Parent class.
 * 
 * So, both parent and child class constructors are executed for Child object
 * initialization only.
 * 
 * 
 * -> Is it, parent object created while creating child object ?
 * 
 * Whenever we are creating Child class constructor Parent class constructor
 * executed but Parent class object won't be created.
 * 
 * 
 * -> What is the need of constructor in abstract class ?
 * 
 * Well, we can't create an object for abstract class either directly or
 * indirectly but abstract class can contains constructor.
 * 
 * The main objective for abstract class constructor is to perform
 * initialization for the instance variables which are inheriting from abstract
 * class to the child class i.e. Code ReUsablity.
 * 
 * 
 * -> Why interface doesn't contain constructor ?
 * 
 * The main purpose of constructor is to perform initialization for instance
 * variables.
 * 
 * Every variable present inside interface is always PUBLIC STATIC FINAL whether
 * we are declaring or not. Hence, there is no chance of existing instance
 * variables inside interface. Because of this, constructor concept is not
 * required for interfaces.
 * 
 * 
 * -> Why we can't replace interface with abstract class ?
 * 
 * If everything is abstract it's highly recommended to go for interface but not
 * abstract class.
 * 
 * While implementing interface we can extend any other class & hence we won't
 * miss inheritance benefits whereas in case of abstract class we miss
 * inheritance benefits.
 * 
 * Object creation is not costly in case of interface since interface doesn't
 * contain any constructor whereas abstract class contains constructor & it may
 * call another super() and so on.
 */

public class Demo_K {

	/**
	 * CE: modifier static is not allowed here.
	 * 
	 * public static Demo_K() { }
	 */

	/**
	 * Constructor overloading:
	 * 
	 * A class can contain more than one constructor with same name but with
	 * different arguments and these constructors are considered as overloaded
	 * constructors.
	 */
	public Demo_K() throws IOException {
		// CE: Recursive constructor invocation
		// this(0);
		System.out.println("Demo_K " + this.hashCode());
	}

	public Demo_K(int i) {
		// CE: Recursive constructor invocation
		// this();
		System.out.println("Demo_K() int");
	}

	public Demo_K(int i, double d) {
		System.out.println("Demo_K() int-double");
	}

	public static void main(String[] args) {

		new Demo_K(10);
		new Demo_K(10, 12.5);

		try {
			new ChildofK();
		} catch (Exception e) {

		}
	}

}

class ChildofK extends Demo_K {

	public ChildofK() throws Exception {
		super();
		System.out.println("ChildofE.ChildofE()" + this.hashCode());
	}
}