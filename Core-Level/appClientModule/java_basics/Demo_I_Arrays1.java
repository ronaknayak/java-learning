package java_basics;

/**
 * Array Declaration:
 * 
 * -> An array is an indexed collection of fixed number of homogeneous data
 * elements.
 * 
 * -> The main advantage of an array is we can represent huge number of values
 * by using single variable. so that readability of the code will be improved.
 * 
 * But, the main disadvantage of arrays is fixed in size. Therefore, once we
 * create an array there is no chance of increasing or decreasing the size based
 * on requirement. Hence, to use arrays concept we should know size in advance
 * which may not possible always.
 * 
 * 
 * */

public class Demo_I_Arrays1 {

	public static void main(String[] args) {

		/** one dimensional array declaration */

		int[] xi; // This one is recommended approach because variable name is
					// clearly separated from data type.
		int xj[];
		int[] xk;

		// At the time of declaration we can't specify the size otherwise we'll
		// get compile time error.
		// int[5] xSize;

		/** two dimensional array declaration */

		int[][] yi;
		int yj[][];
		int[][] yk;

		int[][] yl;
		int[] ym[];
		int[] yn[];

		/* which of the following declaration are valid */
		int[] a1, b1;
		int[] a2[], b2;
		int[] a3[], b3[];

		/*
		 * Here, a4 and b4 are two dimensional array.
		 * 
		 * Note: If we specify dimension before variable space is ignored by
		 * compiler.
		 */
		int[][] a4, b4;

		// Here a5=2 dim and b5=3 dimension
		int[][] a5, b5[];

		/*
		 * If you are specifying the dimension before the variable then that
		 * facility is applicable only for first variable in a declaration.
		 * 
		 * If we do so, for all remaining variable we'll get compile time error.
		 */
		// int[] []a6,[]b6;
		// int[] []a7,[]b7,[]c7

		/** three dimensional array declaration */

		int[][][] x1;
		int x2[][][];
		int[][][] x3;

		int[][][] x4;
		int[] x5[][];
		int[][] x6[];
		int[][][] x7;
		int[][] x8[];

		int[] x9[][];
		int[][] x10[];

	}
}
