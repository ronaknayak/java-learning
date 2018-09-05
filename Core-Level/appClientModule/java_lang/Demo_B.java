package java_lang;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * In all Wrapper classes, in all Collection classes, in String, in StringBuffer
 * and in StringBuilder toString() is overridden for meaningful String
 * representation.
 * 
 * So, it is highly recommended to override toString() in our class also.
 */

public class Demo_B {

	@Override
	public String toString() {
		return "MyOwnClass";
	}

	public static void main(String[] args) {

		String s = new String("Ronak Nayak");
		System.out.println("String object:" + s);

		Integer i = new Integer(40);
		System.out.println("Interger object:" + i);

		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		System.out.println("ArrayList object:" + list);

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(101, "eInfochips");
		System.out.println("HashMap object:" + map);

		Demo_B b = new Demo_B();
		System.out.println("User defined class object:" + b);
	}
}
