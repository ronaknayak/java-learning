package java_operators;

import java.util.ArrayList;
import java.util.RandomAccess;

/** 6) instanceof operator:
 * 
 * -> We can use instanceof operator to check whether the given object is of particular
 * type or not.Therefore we can able to perform object specific functionality.
 * 
 * Here, second operand should be any Java class and not a reference.
 */

public class Demo_F {
	
	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<Object>();
		list.add("Ronak");
		list.add(10);
		list.add(95.0);
		
		for(Object obj : list) {
			
			if(obj instanceof String) {
				System.out.println("to perform String object specific functionality.");
			}
			else if(obj instanceof Integer) {
				System.out.println("to perform Integer object specific functionality.");
			}
		}
		
		
		
		Thread t =new Thread();
		System.out.println("1st case:"+(t instanceof Thread));
		System.out.println("2nd case:"+(t instanceof Object));
		System.out.println("3rd case:"+(t instanceof Runnable));
		
		
		/** To use instanceof operator, compulsory there should be some relationship
		 * between argument type either parent to child or child 
		 * to parent or same type. otherwise we'll get compile time error.
		 * 
		 * It's OK, if second operand is interface.
		 */
		
		//compile time error: inconvertible types
		//System.out.println(t instanceof String);
		
		System.out.println("Checking with interface type:"+(t instanceof RandomAccess));
		
		/** For any class or interface x, null instanceof x is always returns
		 * false.*/
		System.out.println("Check NULL:"+(null instanceof Object));
		System.out.println("Check NULL:"+(null instanceof Runnable));
	}
}
