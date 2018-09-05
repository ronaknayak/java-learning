package java_inner_class;

import java_inner_class.OuterClass.InnerClass;
import java_inner_class.OuterClass.InnerClass.InnerNested;

/**
 * Nesting of Inner classes:
 * 
 * Inside Inner class we can declare another Inner class i.e. Nesting of inner
 * classes is possible.
 * 
 * ---------------------------------------------------------------------------
 * 
 * 2) Method Local Inner class:
 * 
 * Sometimes we can declare a class inside a method such type of Inner class is
 * called method local Inner class.
 * 
 * Purpose: To declare method specific functionality which requires repeatedly.
 * 
 * Method local inner classes are best suitable to meet Nested method
 * requirements.
 * 
 * We can access method local inner class only within a method where we declare
 * & outside of the method we can't access. Because of it's less scope Method
 * local Inner class is MOST RARELY USED inner class.
 * 
 * ----------------------------------------------------------------------------
 * 
 * CONCLUSION 1 - We can declare method Local Inner class inside both Instance
 * and static method.
 * 
 * CONCLUSION 2 - If we declare Inner class inside Instance method then we can
 * access both static and Non-static variable of outer class directly from that
 * Inner class. Reason: Entire scope is instance & thereby we can access both
 * types of variables.
 * 
 * CONCLUSION 3 - If we declare Inner class inside static method then we can
 * access only static members of Outer class directly from that Inner class.
 * Reason: Entire scope becomes static & thereby we can't access instance
 * members directly.
 * 
 * CONCLUSION 4 - From method Local Inner class we can't access local variable
 * in which we declare it & we'll get CE. But,If that variable declared as the
 * final then we can access.
 * 
 * Reason: Because at compile time all final variable converted into value it is
 * assigned, so we can access that Inner class even from outside since
 * dependency with local variable removed & we'll not CE.
 * 
 * CONCLUSION 5 - If we declare sum() method as static then we'll get CE because
 * as we discussed earlier we can't declare static members inside Inner class.
 * 
 * CONCLUSION 6 - The only applicable modifier for method Local Inner classes
 * are final, abstract & strictfp.
 */

public class Inner_B {
	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		InnerClass inner = outer.new InnerClass();
		InnerNested nested = inner.new InnerNested();
		nested.getResult();

		new OuterMain().m1();
		
		OuterMain.m2();
	}
}

class OuterClass {

	class InnerClass {

		class InnerNested {

			public void getResult() {
				System.out.println("Nested Inner class method");
			}
		}
	}
}

class OuterMain {

	int m = 12;
	static int n = 144;

	public void m1() {
		
		int section = 0;
		if(section > 100) {
			section = 1000;
		}
		final int section2 = 1000;
		class InnerMethodLocal {
			public void sum(int x, int y) {
				System.out.println("SUM = " + (x + y));
				
				System.out.println(m);
				System.out.println(n);
				
				// System.out.println(section);
				System.out.println(section2);
			}
		}
		
		InnerMethodLocal methodLocal = new InnerMethodLocal();
		methodLocal.sum(10, 15);
		methodLocal.sum(35, 12);
	}

	public static void m2() {

		class InnMethodLocal {
			void accessOuterMember() {
				// System.out.println(m);
				System.out.println("Access static instance member:"+n);
			}
		}
		InnMethodLocal local = new InnMethodLocal();
		local.accessOuterMember();
	}
}