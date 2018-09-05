package test;

import java_access_modifiers.Demo_C;

/**
 * Encapsulation:
 * 
 * public ArrayList<Integer> getScores(){ return scores; }
 * 
 * Change getScores to return a copy of the scores list:
 * 
 * public ArrayList<Integer> getScores(){ return new ArrayList(scores); }
 * 
 * If you return the same scores list, the caller would be able to add or remove
 * elements from it, thereby rendering the average incorrect. This can be
 * prevented by returning a copy of the list.
 * 
 */
public class Test3 extends Demo_C {

	static void m1ethod(int... l) {
		System.out.println("widening + var-arg");
	}

	static void m1ethod(Integer... integers) {
		System.out.println("autoboxing + var-arg");
	}

	strictfp synchronized final static public void main(String[] args) {

		char c = 70;
		int i = 'a';
		try {
			ocjp(c);
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
	}

	public static void ocjp(int i) throws Exception {
		throw new MyException();
	}
}
class MyException extends Exception{}
interface I {

}

class A implements I {

	private A() {
	}

	public A(String a) {
	}
}

class B extends A {

	public String name;

	public B(String name) {
		super(name);
		this.name = name;
	}

}

// class C extends B {
//
// }