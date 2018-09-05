package java_flow_control;

import java.util.ArrayList;
import java.util.List;

/**
 * return (transfer statement):
 * 
 * -> A return keyword is used to stop execution of the method and return a
 * value for the caller of that method.
 * 
 * -> In that returned value can be reference of any Java Object. Moreover, we
 * can return literal of any String, number, boolean and null.
 * 
 * -> Sometimes we can use return statement even in void data type contained
 * method. In such case return is used to exit the method based on some
 * conditional expression.
 * 
 * -> finally block dominates return statement. Hence, if there is any return
 * statement present inside try or catch block then first finally block will be
 * and later return statement will be executed.
 */
public class Demo_H {

	private String companyName;

	private Demo_H(String name) {
		super();
		this.companyName = name;
	}

	public Demo_H getDemo_H() {

		return this;
	}

	public static void main(String[] args) {

		for (int iCounter = 5; iCounter > 0; iCounter--) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			getElements(iCounter, list);
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}

		prineName();

		Demo_H h = new Demo_H("EInfochips");

		Demo_H h2 = h.getDemo_H();
		System.out.println(h2.companyName);
	}

	public static List<Integer> getElements(int num, List<Integer> list) {

		if (num == 0) {
			return list;
		}
		list.add(num);
		return getElements(--num, list);
	}

	private static void prineName() {

		try {
			System.out.println("Ronak Nayak");

			// It does not need to add return over this but it may do so.
			return;

		} catch (Exception e) {

		} finally {
			System.out.println("finally block executed.");
		}
	}
}