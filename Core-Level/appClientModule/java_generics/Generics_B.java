package java_generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generics_B {
	public static void main(String[] args) {

		/**
		 * For example, To hold only String type of Objects we can create a
		 * Generic version of ArrayList object as follows:
		 */
		ArrayList<String> list = new ArrayList<String>();

		/**
		 * For this ArrayList we can add only String type of Objects. By mistake
		 * if we are trying to add any other type then we'll get CE. Hence,
		 * through genericS We are getting Type-Safety.
		 */
		list.add("Palanpur");
		list.add("Mehsana");
		// list.add(new Integer(100));

		/**
		 * At the time of retrieval, We are not required to perform
		 * Type-casting. Because, we can give guarantee that ArrayList will
		 * return only String type of objects.
		 * 
		 * Hence, through genericS we can solve Type-casting problem.
		 */
		String city = list.get(0);
		System.out.println(city);

		/**
		 * Conclusion 1:
		 * 
		 * Here, ArrayList is Base-type and String is Parameter-type.
		 * 
		 * POLYMORPHISM concept is applicable only for the Base type but not for
		 * Parameter type. Otherwise, we'll get CE: Incompatible types.
		 * 
		 * Usage of parent reference to hold child objects is the concept of
		 * POLYMORPHISM.
		 */
		ArrayList<String> cities = new ArrayList<String>();
		List<String> employees = new ArrayList<String>();
		Collection<Integer> states = new ArrayList<Integer>();
		// ArrayList<Object> countries = new ArrayList<String>();

		/**
		 * Conclusion 2:
		 * 
		 * For the Parameter type we can provide any class or interface
		 * i.e.Object type but not primitive. If we are trying to provide
		 * primitive, then we'll get CE: Unexpected type.
		 */
		// ArrayList<int> arrList = new ArrayList<int>();
	}
}
