package java_multi_thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Condition Object Use-Case
public class Thread_S1 {
	public static void main(String[] args) {

		// Object on which producer and consumer thread will operate
		ProducerConsumerImpl producerConsumerImpl = new ProducerConsumerImpl();

		// creating producer and consumer threads
		Producer producer = new Producer(producerConsumerImpl);
		Consumer consumer = new Consumer(producerConsumerImpl);

		// starting producer and consumer threads
		producer.start();
		consumer.start();
	}
}

class ProducerConsumerImpl {
	// producer consumer problem data
	private static final int CAPACITY = 10;
	private final Queue<Integer> queue = new LinkedList<Integer>();
	private final Random theRandom = new Random();

	// lock and condition variables
	private final Lock lock = new ReentrantLock();

	/**
	 * Condition newCondition()
	 * 
	 * Returns a new Condition instance that is bound to this Lock instance.
	 * Before waiting on the condition the lock must be held by the current
	 * thread.
	 */
	private final Condition bufferNotFull = lock.newCondition();
	private final Condition bufferNotEmpty = lock.newCondition();

	public void put() throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == CAPACITY) {
				System.out.println(Thread.currentThread().getName()
						+ " : Buffer is full, waiting");
				bufferNotEmpty.await();
			}
			int number = theRandom.nextInt();
			boolean isAdded = queue.offer(number);
			if (isAdded) {
				System.out.printf("%s added %d into queue %n", Thread
						.currentThread().getName(), number);

				// signal consumer thread that, buffer has element now
				System.out.println(Thread.currentThread().getName()
						+ " : Signalling that buffer is no more empty now");
				bufferNotFull.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}

	public void get() throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == 0) {
				System.out.println(Thread.currentThread().getName()
						+ " : Buffer is empty, waiting");
				bufferNotFull.await();
			}
			Integer value = queue.poll();
			if (value != null) {
				System.out.printf("%s consumed %d from queue %n", Thread
						.currentThread().getName(), value);

				// signal producer thread that, buffer may be empty now
				System.out.println(Thread.currentThread().getName()
						+ " : Signalling that buffer may be empty now");
				bufferNotEmpty.signalAll();
			}
		} finally {
			lock.unlock();
		}
	}
}

class Producer extends Thread {
	ProducerConsumerImpl producerConsumerImpl;

	public Producer(ProducerConsumerImpl producerConsumerImpl) {
		super("PRODUCER");
		this.producerConsumerImpl = producerConsumerImpl;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			producerConsumerImpl.put();
		} catch (InterruptedException e) {
		}
	}
}

class Consumer extends Thread {
	ProducerConsumerImpl producerConsumerImpl;

	public Consumer(ProducerConsumerImpl producerConsumerImpl) {
		super("CONSUMER");
		this.producerConsumerImpl = producerConsumerImpl;
	}

	@Override
	public void run() {
		try {
			producerConsumerImpl.get();
		} catch (InterruptedException e) {
		}
	}
}