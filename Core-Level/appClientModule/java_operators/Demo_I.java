package java_operators;

/** 12) Assignment operators:
 * 
 * 	There are three types of assignments operators:
 *  i) simple assignment
 *  ii) chained assignment
 *  iii)compound assignment
 *  
 *  
 *  13) Conditional operator (?:):
 *  
 *   -> The only possible ternary operator in java is conditional operator.
 *   
 *  14) new operator:
 *   ->  We can use this operator for creation of OBJECT.
 *   NOTE:
 *   -> After creating an object constructor will be executed to perform initialization of an object.
 *   Hence, constructor is not for creation of object and it's for initialization of an object. 
 *   
 *  15) [] operator:
 *   -> We can use these operator for declaring and creating arrays.
 * */

public class Demo_I {
	public static void main(String[] args) {
		
		/** We can't perform chained assignment directly at the time of declaration.*/
		
		//CE: can't find symbol variable b, can't find symbol variable c
		//int a=b=c=10;
		
		//case 1:
		int a,b,c;
		a=b=c=10;
		
		//case 2:
		int d,e,f;
		int g=d=e=f=20;
		System.out.println("Chained assignment: g = "+ g +" d = "+d);
		
		/** Sometimes assignment operator mixed with some other operator such type of assignment operator are called 
		 * compound assignment operator.
		 * 
		 * Compound assignment operators ( +=, *= etc) have strange ways
		 * A compound assignment expression of the form E1 op= E2 is equivalent to E1 = (T)
		 * ((E1) operator (E2)), where T is the type of E1
		 * Hence, It internally performs explicit type casting. 
		 */
		byte x = 10;
		x += 20;
		System.out.println("Compound assignment:"+x);
		
		
		
		int m = (10 < 20) ? 30 : 40;
		System.out.println("Conditional operator:"+m);
		
		/** We can perform nesting of conditional operator also.*/
		int n = (10 > 20) ? 30 : ((40 > 50) ? 40 : 60);
		System.out.println("Conditional operator Nesting:"+n);
	}
}
