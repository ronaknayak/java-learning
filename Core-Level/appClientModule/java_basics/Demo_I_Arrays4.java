package java_basics;

public class Demo_I_Arrays4 {

	public static void sum(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("Anonymous array:" + sum);
	}

	public static void main(String[] args) {

		/**
		 * length of an array:
		 * 
		 * -> length is a final variable, applicable for arrays. length variable
		 * represents size of the Array.
		 * 
		 * -> In multi dimensional arrays length variable represents only base
		 * size but not the total size.
		 * */

		int[] a = new int[5];
		System.out.println("Length of array:" + a.length);

		int[][] b = new int[2][3];
		System.out.println("Two dimensional array base size:" + b.length);
		System.out.println("Second array size:" + b[0].length);

		/*
		 * there is no direct way to find total length of multi dimensional
		 * array, but in directly we can find it.
		 */
		System.out.println("Total size of multi dimensional array:"
				+ (b[0].length + b[1].length));

		/**
		 * Anonymous Array:
		 * 
		 * -> Sometimes we can declare an array without name, such type of
		 * nameless arrays are called anonymous array.
		 * 
		 * -> The main purpose anonymous arrays is just for instant use(one time
		 * only and not in future).
		 * 
		 * -> At the time of anonymous array creation, we can't specify size.
		 * Otherwise, we'll get CE.
		 * 
		 * -> We can create multi dimensional anonymous arrays also.
		 * */

		sum(new int[] { 10, 15, 20, 25 });

	}
}
