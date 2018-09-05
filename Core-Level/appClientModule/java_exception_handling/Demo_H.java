package java_exception_handling;

/** Hot favorite exceptions:
 * 
 * -> Based on the person who's raising an exception all exceptions are divided into two categories:
 * 
 * 1.JVM exceptions:
 * 
 * -> The exceptions which are raised automatically by JVM whenever a particular event occurs are called
 * JVM exceptions.
 * 
 * JVM : ClassCastException, NullPointerException, SecurityException --> "thrown implicitly"
 * 
 * 2.Programmatic exceptions:
 * 
 * -> The exceptions which are raised explicitly either by programmer or by API Developer to indicate that
 * something goes wrong are called programmatic exceptions.
 *  
 * Application : IllegalStateException, IllegalArgumentException, TooOldException --> "thrown explicitly"
 * 
 */
public class Demo_H {
	
	static {
		String driver = null;
		//System.out.println(driver.length());
	}
	
	public static void m1() {
		m2();
	}
	
	public static void m2() {
		m1();
	}
	
	public static void main(String[] args) {
		
		/** ArrayIndexOutofBoundException:
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever we are try to access array element with out of range index.
		 */
		int[] arr = {1,3,5};
		System.out.println("Check array index:"+arr[1]);
		//System.out.println(arr[10]);
		//System.out.println(arr[-2]);
		
		
		/** NullPointerException:
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever we try to perform any operation on NULL.
		 */
		String str = null;
		//System.out.println(str.substring(4));
		
		
		/** ClassCastException:
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever we try to type cast PARENT OBJECT to child type.
		 */
		String str1 = new String("Ronak");
		Object obj= (Object) str1;
		
		Object object2 = new String("Nayak");
		String string2 = (String) object2;
		
		Object object = new Object();
		//String string = (String) object;
		
		
		/** StackOverFlow error: 
		 * 
		 * -> It is the child class of Error class and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever we try to perform recursive method invocation.
		 */
		try {
			m1();
		} catch (Error e) {
			System.out.println("VM Error");
		}
		
		
		/** NoClassDefFoundError:
		 * 	
		 * -> It is the child class of Error and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever JVM unable to find required .class file.
		 */
		//NoClassDefFoundErrorException exception = new NoClassDefFoundErrorException();
		
		/** ExceptionInInitializerError:
		 * 
		 * -> It is the child class of Error and hence it's Unchecked.
		 * -> Raised automatically by JVM, if any exception occurs while executing static variable
		 * assignments and static blocks.
		 */
		
		
		/** IllegalArgumentException:
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised explicitly either by programmer or by API developer to indicate that a method
		 * has been invoked with illegal argument. 
		 */
		Thread thread =  new Thread();
		thread.setPriority(10);
		//thread.setPriority(11);
		
		
		/** NumberFormatException:
		 * 
		 * -> It is the direct child class of IllegalArgumentException and hence it's Unchecked.
		 * -> Raised explicitly either by programmer or by API developer to indicate that we are trying
		 * to convert String to Number type but the String is not properly formatted.
		 */
		int i = Integer.parseInt("10");
		//int j = Integer.parseInt("ten");
		
		
		/** IllegalStateExceptoin: 
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised explicitly either by programmer or by API developer to indicate that a method has been
		 * invoked  at a wrong time.
		 * -> Although, there is not such a state.
		 * */
		Thread thread2 = new Thread();
		thread2.start();
		//thread2.start();
		
		/** SecurityException:
		 * 
		 * -> It is the child class of RuntimeException and hence it's Unchecked.
		 * -> Raised automatically by JVM whenever security violation has occurred and thus, 
		 * the application cannot be executed.
		 * 
		 * -> For example, let’s create a simple hierarchy, where the parent directory is called java and the sub-directory
		 * is called util. Then, we create a sample Java class inside the java/util/ directory, which only prints a message.
		 * 
		 * -> So, you must avoid using package names that are reserved by Java.
		 */
	}
}

class NoClassDefFoundErrorException {
	 
	static int num = 1/0;
}
