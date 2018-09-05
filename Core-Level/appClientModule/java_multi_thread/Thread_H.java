package java_multi_thread;

/**
 * (3) sleep():
 * 
 * If a Thread don't want to perform any operation for a particular amount of
 * time then we should go for sleep() method. i.e. pausing Thread for particular
 * amount of time.
 * 
 * Signature:
 * 
 * public static native void sleep(long timePeriod) throws InterruptedException
 * 
 * public static void sleep(long timePeriod, int nenoSec) throws
 * InterruptedException [This method is implemented in Java so it's not native]
 * 
 * static: Because sleep() method is called by Thread class means Thread.sleep()
 * 
 * 
 * Impact of sleep() in Thread life cycle:
 * 
 * When a running thread calls sleep() method then that Thread will entered into
 * sleeping state. Now, that Thread will go in Ready state if given time expires
 * or if that Thread interrupted by other threads in sleeping state.
 * 
 * Now, If Thread scheduler allocated CPU then that Thread again entered in
 * Running state.
 * 
 */

public class Thread_H {

	public static void main(String[] args) throws InterruptedException {

		SlideRotator rotator = new SlideRotator();
		rotator.start();
	}

}

class SlideRotator extends Thread {

	@Override
	public void run() {
		super.run();
		for (int i = 1; i <= 5; i++) {
			System.out.println("Slide:" + i);
			try {
				sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int j = 1; j <= 5; j++) {
				System.out.println("	Sub-Slide:" + j);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}