package java_operators;

/** 4)Relational operators (<, <=, >, >=):
 * 
 * */

public class Demo_D {
	
	public static void main(String[] args) {
		
		/** We can apply relational operators for every PRIMITIVE TYPES except boolean.
		 * */
		System.out.println("1st case:"+(10 < 20));
		System.out.println("2nd case:"+(31 > 43.7));
		System.out.println("3rd case:"+('a' > 10));
		System.out.println("4rd case:"+('a' > 'A'));
		System.out.println("5th case:"+('b' > 203.5));
		
		//compile time error:operator > can't be applied to boolean
		//System.out.println("6th case:"+(true > false));
		
		
		
		/** we can't apply relational operators for Object types.*/
		
		//compile time error:operator > can't be applied to java.lang.String
		//System.out.println("7th case:"+("ronak" > "nayak"));
		
		
		
		/** Nesting of relational operators are not allowed. otherwise 
		 * we'll get compile time error.*/
		
		System.out.println(10 < 20);
		//compile time error:operator > can't be applied to boolean
		//System.out.println(10 < 20 < 30);
	}
}
