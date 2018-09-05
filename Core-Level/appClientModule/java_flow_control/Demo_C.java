package java_flow_control;

/** While loop(iterative statement)
 * 
 * -> When to use:
 * 
 * If we don't know the number of iteration in advance the best suitable loop is while loop. 
 */

public class Demo_C {
		public static void main(String[] args) {
			
			/** The while loop argument should be boolean type. If we provide any other type then we will
			 * get compile time error.*/
			
			/** Curly braces are optional and we can take only one statement and which should not
			 * be declarative.*/
			
			//while(true);
			
			//while(true)
			//	System.out.println("Infinite Looping");
			
			boolean check=true;
			while(check){
				System.out.println("Executed only once");
				check=false;
			}
			
			while(true){
				System.out.println("executed infinitely");
			}
			
			//compile time error: unreachable statement
			//while(false) {
			//	System.out.println("not reached ");
			//}
			
			//compile time error: unreachable statement
			//while(true){
			//	System.out.println("hey");
			//}
			//System.out.println("hii");
			
			
			
			//int a=10,b=20;
			//while(a<b) {
			//	System.out.println("while a < b");
			//}
			//System.out.println("a < b");
			
			
			//int c=10,d=20;
			//while(c > d) {
			//	System.out.println("while c > d");
			//}
			//System.out.println("c > d");
			
			
			//CE: unreachable statement
			
			//final int e=10,f=20;
			//while(e < f) {
			//	System.out.println("while e < f final case");
			//}
			//System.out.println("e < f ");
			
			
			//CE: unreachable statement
			
			//final int g=10,h=20;
			//while(g > h) {
			//	System.out.println("while g > h final case");
			//}
			//System.out.println("g > h");
			
			/** Note:
			 * 
			 * 1) every final variable will be replaced by the value at a compile time only.
			 * 
			 * final int a = 10;
			 * int b=20;
			 * System.out.println(a);
			 * System.out.println(b);
			 * 
			 * After compilation,
			 * System.out.println(10);
			 * System.out.println(b);
			 * 
			 * 
			 * 2) If every argument is a final variable (compile time constant) then that operation should be performed 
			 * at compile time only.
			 * 
			 * final int a=10,b=20;
			 * int c=30;
			 * 
			 * System.out.println(a + b);
			 * System.out.println(a+c);
			 * System.out.println(a < b);
			 * System.out.println(a < c)
			 * 
			 * After compilation,
			 * System.out.println(30);
			 * System.out.println(10+c);
			 * System.out.println(true);
			 * System.out.println(10 < c)
			 * 
			 * */
		}
}
