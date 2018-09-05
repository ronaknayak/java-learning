package java_lang;

/**
 * clone():
 * 
 * The process of creating exactly same object is called cloning. The main
 * objective objective of cloning is to maintain backup.
 * 
 * Note(ENTHUWARE):
 * 
 * Object class defines a clone() method, but this method is protected.
 * Therefore, you cannot call B's clone() from outside class B. Usually, a class
 * that allows cloning overrides the clone() method and makes it public.
 */

public class Demo_E implements Cloneable {

	int iNumber;
	int jNumber;

	public Demo_E(int iNumber, int jNumber) {
		super();
		this.iNumber = iNumber;
		this.jNumber = jNumber;
	}

	public static void main(String[] args) throws CloneNotSupportedException {

		Demo_E d = new Demo_E(10, 20);

		/*
		 * The process of creating just exactly duplicate reference variable but
		 * not duplicate object is called SHALLOW CLONING.
		 */
		Demo_E d1 = d;

		System.out.println(d.iNumber == d1.iNumber);
		d1.iNumber = 1000;
		// Both references impacted since pointing to same object in memory
		System.out.println(d.iNumber == d1.iNumber);

		/*
		 * The process of creating exactly duplicate independent object is
		 * called DEEP CONING.
		 */
		Demo_E demo = (Demo_E) d.clone();
		demo.iNumber = 100;
		demo.jNumber = 200;
		// Here, both are pointing to independent object in memory
		System.out.println(d.iNumber == demo.jNumber);

		System.out.println("Shallow Cloning:" + d.hashCode() + " "
				+ d1.hashCode());
		System.out.println(d == d1);

		System.out.println("Deep Cloning:" + d.hashCode() + " "
				+ demo.hashCode());
		System.out.println(d == demo);
	}
}
