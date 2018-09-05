package java_collection_concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionE extends Thread{

	static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("Child thread performing updation");
		list.add("Mit");
	}

	public static void main(String[] args) {
		
		list.add("Aarya");
		list.add("Jenil");
		list.add("Maitry");
		
		ConcurrentCollectionE childThread = new ConcurrentCollectionE();
		childThread.start();
		
		for (String name : list) {
			System.out.println("Main thread retrieving names: "+name);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
		System.out.println(list);
	}
}
