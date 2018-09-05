package java_basics;

/** Command-line arguments:
 * 	
 * The arguments which are passing from command prompt are called command-line argument.
 * 
 * With this command-line arguments JVM will create String[] and passes that array as an
 * argument, JVM will call main method.
 * 
 * The main objective of command-line arguments is we can customize behavior of the main
 * method. Therefore, instead of giving fix values to our application we can give varied
 * values as per our requirement.
 * 
 * String is most commonly used object and to convert into any data-type from String it's
 * quite easy. So, sun people restricted main() arguments as a string[] arguments.	*/

public class Demo_J {
	
	// Case 1: AIOOBE
	/*public static void main(String[] args) {
		
		for (int i = 0; i <= args.length; i++) {
			System.out.println(args[i]);
		}
	}*/
	
	
	// Case 2:
	/*public static void main(String[] args) {
		
		String[] argNew={"Kaminiben","Jaguben","Nikiben","Khushbuben"};
		args = argNew;
		
		for(String str : args) {
			System.out.println(str);
		}
	}*/
	
	
	/* Case 3: 
	 * Within main() command-line arguments available in String form.*/
	/*public static void main(String[] args) {
		
		System.out.println(args[0] + args[1]);
	}*/
	
	
	/* Case 4: 
	 * Space is separator between command-line arguments. If the command-line arguments itself contains space
	 * then we should enclose within double quotes.*/
	
	public static void main(String[] args) {
		
		System.out.println(args[0]);
	}
}
