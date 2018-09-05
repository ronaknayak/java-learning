package java_inner_class;

public class Inner_D {
	public static void main(String[] args) {

		/**
		 * B) Anonymous Inner class that implements interface:
		 * 
		 * Here, we are not creating an object of Runnable interface but it's of
		 * class which implements Runnable interface.
		 */
		Runnable runnable = new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Child thread executing");
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread executing");
		}

		/**
		 * C) Anonymous Inner class that define Inside method argument:
		 */
		new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Child thread");
				}
			}
		}).start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread");
		}
	}
}
