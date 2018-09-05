package java_inner_class;

/**
 * 3) Anonymous Inner class(Most Commonly Used):
 * 
 * Sometimes we can declare a Inner class without name such type of nameless
 * Inner class are called Anonymous Inner class.
 * 
 * The main purpose of Anonymous Inner class is just for instant use(one-time
 * usage) or to meet temporary requirement.
 * 
 * 
 * Based on declaration & behavior there are three types of Anonymous Inner
 * classes.
 * 
 * A) Anonymous Inner class that extends a class:
 * 
 * Thread t = new Thread() {
 * 
 * };
 * 
 * Here, new Thread() is not a Thread class object but it is Anonymous child
 * class object what extending a Thread class.
 * 
 * 
 * Analysis:
 * -------------------------------------------------------------------------- 1)
 * 1) PopCorn p = new PopCorn();
 * 
 * Just, we are creating PopCorn object.
 * 
 * 2) PopCorn p = new PopCorn() {
 * 
 * };
 * 
 * We are declaring a class that extends PopCorn class without name(Anonymous
 * Inner class).
 * 
 * For that child class we are creating an object with parent reference.
 * 
 * 3) PopCorn p = new PopCorn() {
 * 
 * public void taste() {
 * 
 * System.out.println("Spicy PopCorn");
 * 
 * } };
 * 
 * We are declaring a class that extends PopCorn class without name(Anonymous
 * Inner class).
 * 
 * In that child class we are OVERRIDING test() method.
 * 
 * For that child class we are creating an object with parent reference.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * Anonymous classes are implicitly final.
 * 
 * Anonymous class can never be static, even if created in a static method.
 * 
 * Anonymous inner class can have initialization parameter.(If the class they
 * extend has a corresponding constructor).
 * 
 * When you create an anonymous class for an interface then it extends from
 * Object. But if you make an anonymous class from another class then it extends
 * from that class.
 */

public class Inner_C {
	public static void main(String[] args) {

		switch (args[0]) {

		case "spicy":
			Popcorn popcorn = new Popcorn() {
				@Override
				public void taste() {
					System.out.println("Spicy Popcorn");
				}
			};
			popcorn.taste();
			System.out.println(popcorn.getClass().getName());
			break;
		case "sweet":
			Popcorn popcor = new Popcorn() {
				@Override
				public void taste() {
					System.out.println("Sweet Popcorn");
				}
			};
			popcor.taste();
			System.out.println(popcor.getClass().getName());
			break;
		default:
			Popcorn pop = new Popcorn();
			pop.taste();
			System.out.println(pop.getClass().getName());
		}

		/**
		 * Defining a thread by extending Thread class
		 */

		Thread thread = new Thread() {

			// If thread job is required only once
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Child thread executing");
				}
			}
		};
		thread.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread executing");
		}
	}
}

class Popcorn {

	public void taste() {
		System.out.println("Salty Popcorn");
	}

	// 10 Another Methods
}
