package java_basics;

/**
 * Array Variable assignment:
 * 
 * 
 * Note:
 * 
 * For primitive type array - Any type which can be implicitly promoted to
 * declared type is allowed.
 * 
 * For object type array - Either declared type objects or it's child objects
 * are allowed.
 * 
 * For abstract type array - It's child class objects are allowed.
 * 
 * For interface type array - It's implementation class objects are allowed.
 */

public class Demo_I_Arrays5 {

	public static void main(String[] args) {

		/** Case 1: Element level promotions are not applicable at array level. */
		int[] a = { 10, 20, 30, 40, 50 };
		int[] x = a;
		System.out.println("Same type of array:" + x.length);

		char[] ch = { 'a', 'b', 'c' };
		// compile time error: incompatible types
		// int[] y = ch;

		/* Child type array we can assign to the parent type variable. */
		String[] str = { "einfochips", "service", "limited" };
		Object[] obj = str;
		System.out.println("Child type to parent:" + obj.length);
		
		// Valid, As array is also an object type 
		Object o1 = a;
		
		// Invalid, because a is primitive & not child of Object type
		// would have been valid for Integer[]
		//Object[] o2 = a;
		
		/**
		 * Case 2: Whenever we assign one array to another array internal
		 * elements will not be copied but just reference variable will be
		 * reassigned. Hence, type must be matched but not sized.
		 */
		int[] ai = { 10, 20, 30, 40, 50 };
		int[] bi = { 70, 80 };

		ai = bi;
		bi = ai;
		System.out.println("Reference variable assignment:" + ai.length);

		/**
		 * Case 3: Whenever we assign one array to another array dimensions must
		 * be matched.
		 */
		int[][] aj = new int[3][2];

		// compile time error: incompatible types
		// aj[0]=new int[2][4];

		// compile time error: incompatible types
		// aj[0] = 80;

		aj[0] = new int[10];
		System.out.println("Dimension must be matched:" + aj[0].length);

		/**
		 * Case 4: In the case of object type array, as array elements we can
		 * provide either declared type or it's child class objects or else
		 * we'll get CE.
		 */
		Number[] numbers = new Number[10];
		numbers[0] = new Integer(10);
		numbers[1] = new Double(15.0);
		// numbers[2] = new String("Ronak");

		Object[] objects = new Object[5];
		objects[0] = new Integer(10);
		objects[1] = new Double(15.0);
		objects[2] = new String("Ronak");
		objects[3] = new Object();

		for (Object object : objects) {

			if (object instanceof Double) {
				System.out.println("Object type array:" + object);
			}
		}

		/**
		 * Case 5: In the case of abstract class type array, as array elements
		 * we can provide it's child class objects or else we'll get CE.
		 * Here, Number is abstract class.
		 */
		Number[] nums = new Number[5];
		nums[0] = new Integer(10);
		// nums[1] = new Number();

		/**
		 * Case 6: In the case of interface type array, as array elements we can
		 * provide it's implementation class objects or else we'll get CE.
		 */
		Runnable[] runnables = new Runnable[2];
		runnables[0] = new Thread();
	}
}
