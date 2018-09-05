package java_operators;

/** 3) String concatenation operator(+):
 * 
 * -> The only overloaded operator in java is + operator. sometimes it acts as
 * arithmetic addition operator and sometimes it acts as string concatenation
 * operator.
 * 
 * -> If at least one argument is string type then + operator act as concatenation
 * operator and if both arguments are number type then + operator act as arithmetic
 * addition operator.   
 * */

public class Demo_C {
	
	public static void main(String[] args) {
		
		String name="Ronak";
		int a=10, b=20, c=30;
		
		System.out.println("1st case:"+(name+a+b+c));
		System.out.println("2nd case:"+(a+b+c+name));
		System.out.println("3rd case:"+(a+b+name+c));
		System.out.println("4th case:"+(a+name+b+c));
		
		
		
		/** consider the following expression */
		//compile time error: incompatible types
		//name = a+b+c;
		
		name = name+a+b;
		
		//compile time error: incompatible types
		//b = name+b+c;
		
		a = a+b+c;
		
		
		
		
	}
}
