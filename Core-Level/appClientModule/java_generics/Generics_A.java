package java_generics;

import java.util.ArrayList;

/**
 * Introduction:
 * ---------------------------------------------------------------------------
 * The main objectives of Generics are to provide Type safety & to resolve Type
 * casting problems.
 * 
 * Case 1: Type-safety
 * 
 * Arrays are type-safe. That is, We can give the guarantee for the type of
 * elements present inside array.
 * 
 * for example, If our program requirement is to add only String objects then we
 * can go for String[]. For this array we can add only String type of objects.
 * By mistake If we are trying to add other type we'll get CE: incompatible
 * types.
 * 
 * Hence, String[] can contain only String type of objects. Due to this we can
 * give the guarantee for the type of elements present inside array. Hence,
 * Arrays are safe to use with respect to type. i.e. Arrays are type-safe.
 * 
 * But, Collections are not Type-safe. i.e. We can't give the guarantee for the
 * type of elements present inside collections.
 * 
 * For example, If our program requirement is to hold only String type of
 * objects & If we choose ArrayList , By mistake If we are trying to add any
 * other type of objects we won't get any CE. But, The program may fail at
 * Runtime.
 * 
 * Hence, we can't give the guarantee for the type of elements present inside
 * collection. Due to this, Collection are not safe to use with respect to type.
 * i.e. Collections are not type-safe.
 * 
 * So, As far as the concern with Type-safety Arrays are safe because CE is
 * always good than RE.
 */

/**
 * Case 2: Type-casting
 * 
 * In the case of Arrays, at the time of retrieval it's not required to perform
 * type-casting because there is a guarantee for the elements present inside
 * Array.
 * 
 * But In the case of Collections at the time of Retrieval compulsory we have to
 * perform type-casting because there is No guarantee for the type of elements
 * present inside Collection. As In our example, At the time of retrieval
 * list.get() returns Object type & we are assigning that value in String type.
 * Therefore, Type casting needed there.
 * 
 * Hence, Type casting is a bigger Headache in collections.
 * 
 * To overcome above problems of collections SUN people introduced genericS
 * concept in 1.5 version.
 * 
 * Hence, The main objectives of genericS are,
 * 
 * 1) To provide Type-safety
 * 
 * 2) To resolve Type-casting problem
 * 
 * 3) It is checked at compile time so problem will not occur at runtime. The
 * good programming strategy says it is far better to handle the problem at
 * compile time than runtime.
 */

public class Generics_A {
	public static void main(String[] args) {

		/** In case we use Array */

		String strArray[] = new String[3];
		strArray[0] = "Ronak  Nayak";
		strArray[1] = "Ravi Yadav";
		// CE: incompatible type
		// strArray[2] = new Generics_A();

		// At the time of Retrieval
		for (String string : strArray) {
			String fullName = string;
			System.out.println("Type Casting Not Required:" + fullName);
		}

		/** In case we use ArrayList */

		ArrayList list = new ArrayList();
		list.add("Ronak Nayak");
		list.add("Ravi Yadav");
		// list.add(new Generics_A());

		for (Object object : list) {
			// RE: ClassCastException
			String name = (String) object;
		}

		// At the time of Retrieval
		for (int i = 0; i < list.size(); i++) {
			String n = (String) list.get(i);
			System.out.println("Type Casting Compulsory Required:" + n);
		}
	}
}
