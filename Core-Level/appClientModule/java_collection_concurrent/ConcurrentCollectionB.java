package java_collection_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue Interface:
 * 
 * It extends Queue interface.
 * 
 * java.util.concurrent.BlockingQueue interface is a java Queue that support
 * operations that wait for the queue to become non-empty when retrieving and
 * removing an element, and wait for space to become available in the queue when
 * adding an element.
 * 
 * Java BlockingQueue implementations are thread-safe.
 * 
 * It's used for implementing producer consumer problem. The producing thread
 * will keep producing new objects and insert them into the queue, until the
 * queue reaches some upper bound on what it can contain.
 * 
 * If the blocking queue reaches its upper limit, the producing thread is
 * blocked while trying to insert the new object. It remains blocked until a
 * consuming thread takes an object out of the queue.
 * 
 * The consuming thread keeps taking objects out of the blocking queue, and
 * processes them. If the consuming thread tries to take an object out of an
 * empty queue, the consuming thread is blocked until a producing thread puts an
 * object into the queue.
 * 
 * Java BlockingQueue DOESN’T ACCEPT NULL values and throw NullPointerException
 * if you try to store null value in the queue.
 * 
 * Methods:
 * 
 * There are four types of methods available for each operations like insert,
 * remove and examine in a BlockingQueue. The respective type of method has to
 * be chosen according to our use case requirement.
 * 
 * > Throws exception – when an insert is performed if there is no space an
 * exception is thrown. add(o), remove(o), element()
 * 
 * > Returns value – returns a value like true or false. false means
 * insufficient space and true means successful insertion. offer(o), poll(),
 * peek()
 * 
 * > Blocks – blocks the thread till the space is available. put(o), take()
 * 
 * > Timed – waits for the specified amount of time. offer(o, timeout,
 * timeUnit), poll(timeout, timeUnit)
 * 
 * 
 * BlockingQueue Implementations:
 * 
 * http://javapapers.com/java/java-blockingqueue/
 * http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html
 */

public class ConcurrentCollectionB {
	public static void main(String[] args) {

		// Creating BlockingQueue of size 10
		BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>(10);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();

		System.out.println("Producer and Consumer has been started");
	}
}

class Message {
	private String msg;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

}

class Producer implements Runnable {

	private BlockingQueue<Message> queue;

	public Producer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 100; i++) {
			Message msg = new Message("" + i);
			try {
				Thread.sleep(i);
				/**
				 * This method is used to insert elements to the queue. If the
				 * queue is full, it waits for the space to be available.
				 */
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		Message msg = new Message("exit");
		try {
			System.out.println("EXIT");
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	private BlockingQueue<Message> queue;

	public Consumer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			Message msg;
			// consuming messages until exit message is received
			/**
			 * This method retrieves and remove the element from the head of the
			 * queue. If queue is empty it waits for the element to be
			 * available.
			 */
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}