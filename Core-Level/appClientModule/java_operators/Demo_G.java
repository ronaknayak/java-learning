package java_operators;

/** 7) Bit-wise operators (&,|,^):
 * 
 * & ->returns true if both arguments are true.
 * | ->returns true if at least one argument is true.
 * ^ ->returns true if both arguments are different.
 *  
 *  ->We can apply this operators for INTEGRAL types also.
 *  
 *  
 *  8) Bit-wise complement operator(~);
 *  -> We can apply this operator only for integral types but not boolean type.
 *  otherwise we'll get compile time error.
 *  
 *  -> The most significant bit acts as, 
 *  0 means- positive number and 1 means negative number.
 *  Positive numbers represented in memory directly whereas Negative numbers represented 
 *  indirectly in memory in 2's complement form.
 *  
 *  9) Boolean complement operator(!):
 *  -> We can apply this only for boolean type but not for integral types.
 *  otherwise, we'll get compile time error.
 *  
 */
public class Demo_G {
	
	public static void main(String[] args) {
		
		System.out.println("& ope "+(true & true));
		System.out.println("& ope "+(true & false));
		System.out.println("| ope "+(true | false));
		System.out.println("| ope "+(true | true));
		System.out.println("^ ope "+(true ^ true));
		System.out.println("^ ope "+(true ^ false));
		
		
		/* We can apply this operators for INTEGRAL types also.*/
		System.out.println(4 & 5);
		System.out.println(4 | 5);
		System.out.println(4 ^ 5);
		
		
		//CE:operator ~ can't be applied to boolean 
		//System.out.println(~true);
		System.out.println("~ ope "+(~4));
		
		//CE:operator ! can't be applied to int 
		//System.out.println(!4);
		System.out.println(!true);
		System.out.println(!false);
		
	}
}
