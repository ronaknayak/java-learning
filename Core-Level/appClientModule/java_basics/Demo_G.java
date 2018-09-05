package java_basics;

/** VAR-ARG METHODS (variable-number of argument methods):
 * 
 *  -> Until 1.4 version we can't declare a method with variable number of arguments.
 *  if there is any change any number of arguments compulsory we should declare a new 
 *  method. This approach increase length of the code & reduce readability.
 *  
 *  -> Hence, from 1.5 version onwards we can declare a method with variable number of
 *  arguments.
 *  
 *  -> Declaration: method_Name(Any_Data-type... x) 
 *  here, ... is called as ellipse in java.
 * */

public class Demo_G {
	
	static void sum(int... a) {
		System.out.println("var-arg methods");
	}
	
	static void sum1(int... a) {
		int total=0;
		for(int x : a){
			total +=x; 
		}
		System.out.println("SUM="+total);
	}
	
	public static void main(String[] args) {
		
		//we can call this method by passing any number of int values, including zero.
		sum();
		sum(10);
		sum(10,20);	
		sum(new int[]{1,2,3,4,5});
		
		/** Internally var-arg parameters will be converted into one dimensional array.
		 * hence, within the var-arg method we can differentiate values by using index.
		 * */
		sum1();
		sum1(10);
		sum1(10,20);
		sum1(new int[]{1,2,3,4,5});
		
		//general method get called.
		varArg(100);
	}
	
	/** How differently we can declare var-arg methods.
	 * Case 1: */
	static void case1(int... x){
		System.out.println("case 1");
	}
	
	static void case2(int...x){
		System.out.println("case 1");
	}
	
	static void case3(int ...x){
		System.out.println("case 1");
	}
	
	/*static void case4(int x...){
		System.out.println("case 1");
	}*/
	
	/*static void case5(int. ..x){
		System.out.println("case 1");
	}*/
	
	/*static void case6(int. x..){
		System.out.println("case 1");
	}*/
	
	
	
	/**Case 2: We can mix var-arg parameters with normal parameters.*/
	static void caseMix1(int a,int... x){
		System.out.println("case 2");
	}
	
	static void caseMix2(int a,String... x){
		System.out.println("case 2");
	}
	
	
	/**Case 3: If we are mix var-arg parameter with normal parameter then var-arg
	 * parameter should be last parameter.
	 * */
	static void caseMix3(int a,String... x){
		System.out.println("case 3");
	}
	
	/*static void caseMix4(String... x, int a){
		System.out.println("case 3");
	}*/
	
	
	
	/**Case 4: In any var-arg method we can't take more than one var-arg parameter.*/
	static void caseMix5(int a,double d,String... x){
		System.out.println("case 4");
	}
	
	/*static void caseMix6(int... a,String... x){
		System.out.println("case 4");
	}*/
	
	
	
	/**Case 5: In general var-arg method gets least priority. i.e if no other method 
	 * matched then only var-arg method gets chance. It is exactly same as default case
	 * inside switch.*/
	
	static void varArg(int... a){
		System.out.println("Var-arg method called..");
	}
	static void varArg(int a){
		System.out.println("General method called..");
	}
	
	
	
	/**Case 6: Within the class if we are declaring var-arg parameter method then in the
	 * same class we can't declare corresponding one dimensional array method.
	 * 
	 * CE: can't declare both caseMix7(int[] a) and  caseMix7(int... a) in Demo_G */
	static void caseMix7(int... a){
		System.out.println("case 6");
	}
	
	/*static void caseMix7(int[] a){
		System.out.println("case 6");
	}*/
	
	
	
	/** 
	 * Equivalence between one dimensional arrays and var-arg parameters.
	 */
	/* Case 1: Wherever one dimensional array present in method parameter 
	 * we can replace with var-arg parameter. */
	
	/* Case 2: Wherever var-arg method parameter present we can't replace 
	 * with one dimensional array. */
}
