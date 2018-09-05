package java_oops;

/**
 * SINGELTON class Design Pattern:
 * 
 * Real-time example: President of Country
 * 
 * For any Java class, If we are allowed to create only one object, such type of
 * class is called SINGELTON class. e.g.RunTime, ServiceLocator(EJB),
 * BusinessDelegate(EJB), ActionServlet(Struts) etc.
 * 
 * Advantage:
 * 
 * If several classes have same requirement then It's not recommended to create
 * a separate object for every requirement. We have to create only one object &
 * we can reuse same object for every similar requirement. So that performance &
 * memory utilization will be improved.
 * 
 * 
 * Creation of our own SINGLETON class:
 * 
 * 1st Approach:
 * 
 * We can create our own SINGLETON class. For this we have to use private
 * constructor, private static variable and public factory method.
 * 
 * Factory Method: By using class name If we call any method & It return same
 * object. Then, this method is considered as factory method.
 * 
 * 
 * 2nd Approach:
 * 
 * In 1st approach, At the begin compulsory one object will be created whether
 * we are required or not.
 * 
 * But, If we use 2nd approach then at our first request it only create an
 * object and for all consecutive requests it use same object.
 * 
 * At any point of time for FirstApproach, SecondApproach classes we can create
 * only one object. Hence, FirstApproach and SecondApproach classes are
 * SINGLETON classes.
 * 
 * 3rd Approach:
 * 
 * public enum SingletonClass {
 * 
 * INSTANCE; }
 * 
 * This approach is functionally equivalent to the public field approach as
 * shown in options as above.
 */

public class Demo_L {
	public static void main(String[] args) {

		ThirdApproach approach = ThirdApproach.INSTANCE;
		System.out.println(approach.getClass().getSimpleName());
	}
}

/**
 * Singleton class. Eagerly initialized static instance guarantees thread
 * safety.
 */
class FirstApproach {
	/**
	 * Static to class instance of the class.
	 */
	private static FirstApproach approach = new FirstApproach();

	/**
	 * Private constructor so nobody can instantiate the class.
	 */
	private FirstApproach() {
	}

	/**
	 * To be called by user to obtain instance of the class.
	 *
	 * @return instance of the singleton.
	 */
	public static FirstApproach getInstance() {
		return approach;
	}
}

/**
 * Thread-safe Singleton class. The instance is lazily initialized and thus
 * needs synchronization mechanism.
 */
class SecondApproach {
	private static SecondApproach approach = null;

	private SecondApproach() {
	}

	/**
	 * The instance gets created only when it is called for first time.
	 * Lazy-loading
	 */
	public synchronized static SecondApproach getInstance() {

		if (approach == null) {
			approach = new SecondApproach();
		}
		return approach;
	}
}

enum ThirdApproach {
	INSTANCE;

	private ThirdApproach() {
	}
}