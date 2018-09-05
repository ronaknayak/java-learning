package java8;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * Anonymous Inner class & Lambda Expression:
 * ****************************************************************************
 * Anonymous Inner class is a class without name. Lambda Expression is a
 * function without name.
 * 
 * Anonymous Inner class can implement an interface that contains any number of
 * abstract methods. Lambda Expression can implement an interface which contain
 * only single abstract method.
 * 
 * Anonymous Inner class can be instantiated but Lambda Expression can't be
 * instantiated.
 * 
 * Anonymous Inner class is the best choice if we want to handle multiplE
 * abstract methods. But, Lambda Expression is the best choice if we want to
 * handle only single abstract method & such type of interface known as
 * functional interface.
 * 
 * Wherever we are using anonymous inner classes there may be a chance of using 
 * Lambda expression to reduce length of the code and to resolve complexity.
 * 
 * 
 * Conclusion: 
 * ****************************************************************************
 * Anonymous Inner class & Lambda Expression both are different
 * concepts.
 * 
 * Anonymous inner class can extend concrete class, can extend abstract class, 
 * can implement interface with any number of methods but Lambda expression can 
 * implement an interface with only single abstract method (Functional Interface).
 * 
 * Hence if anonymous inner class implements Functional Interface in that particular 
 * case only we can replace with lambda expressions. Hence wherever anonymous inner 
 * class concept is there, it may not possible to replace with Lambda expressions.
 */
public class Section_F {
	public static void main(String[] args) {

		// Up to Java7
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Sunday Morning");
			}
		});
		thread.start();

		// Java8
		Thread threadOther = new Thread(
				() -> System.out.println("Sunday Morning"));
		threadOther.start();
	}
}
