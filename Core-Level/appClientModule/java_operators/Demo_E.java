package java_operators;

/** 
 * 5)Equality operators (==, !=):
 */
public class Demo_E {
	
	public static void main(String[] args) {
		
		/** We can apply equality operators for EVERY PRIMITIVE TYPE, including 
		 * boolean type also.
		 */
		System.out.println("1st case:"+(10 == 20));
		System.out.println("2nd case:"+(10 == 20.5));
		System.out.println("3rd case:"+(64.5 == 'A'));
		System.out.println("5th case:"+(false == true));
		
		
		/** We can apply equality operators even for object reference also. for the
		 * two object references r1 and r2, 
		 * 
		 * r1 == r2 returns true if and only if both the references pointing to the same 
		 * object. i.e. == operator is always meant for reference/address comparison.*/
		
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3=t1;
		System.out.println("object comparison:"+(t1 == t2));
		System.out.println("object comparison:"+(t1 == t3));
		
		
		
		/** If we apply equality operator for object types then compulsory there should
		 * be some relationship between argument types either parent to child or child 
		 * to parent or same type.
		 * 
		 * otherwise we'll get compile time error.
		 */
		Thread thread = new Thread();
		Object object = new Object();
		String string = new String("Ronak");
		System.out.println("obj relation: "+(thread == object));
		System.out.println("obj relation: "+(string == object));
		
		//compile time error:incomparable types: java.lang.String and java.lang.Thread
		//System.out.println("obj relation "+(thread == string));
		
		
		
		/** Difference between == operator and equals() method:
		 * 
		 * -> In general we can use == operator for reference comparison and
		 * equals() method for content comparison.
		 */
		String s1=new String("ronak");
		String s2=new String("ronak");
		System.out.println("obj compare == :"+(s1 == s2));
		System.out.println("obj compare equals() :"+s1.equals(s2));
		
		
		
		/** For any object reference r, r == null is always false. otherwise 
		 * r contains null value. */
		String s = new String("ronak");
		System.out.println("null compare: "+(s == null));
		s=null;
		System.out.println("null compare: "+(s == null));
		System.out.println("null compare: "+(null == null));
	}
}
