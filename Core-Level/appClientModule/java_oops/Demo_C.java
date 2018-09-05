package java_oops;

/**
 * Interface:
 * 
 * Any service requirement specification or 100% abstract class is considered as
 * interface.
 * 
 * Example: JDBC API access requirement specification to develop database
 * driver. Database vendor is responsible to implement this JDBC API.
 * 
 * SERVLET API access requirement specification to develop web server. Web
 * server vendor is responsible to implement SERVLET API.
 * 
 * Whenever we are implementing an interface method compulsory it should be
 * declared in public. Otherwise we'll get CE. Because, implementing interface
 * method means overriding that method, therefore we can't decrease scope of
 * interface method.
 * 
 * 1) A class can extend only one class at a time.
 * 
 * 2) An interface can extend any number of interface simultaneously.
 * 
 * 3) A class can implement any number of interfaces simultaneously.
 * 
 * 4) A class can extend another class and implements any number of interfaces
 * simultaneously.
 * 
 * 
 * Interface methods:
 * 
 * Whether we are declaring or not every interface method is by default public
 * and abstract by compiler. It's public to make interface method availability
 * for every implementation class.
 * 
 * As every interface method is always public we can't declare it as DEFAULT,
 * private and protected. As every interface method is always abstract we can't
 * declare it as final, static, STRICTFP, native and synchronized.
 * 
 * 
 * Interface variables:
 * 
 * An interface can contain variables. The main purpose of interface variable is
 * to define requirement level constants.
 * 
 * Every interface variable is always public static final by compiler whether we
 * are declaring or not.
 * 
 * As every interface variable is always public we can't declare interface
 * variable with private, protected, DEFAULT.
 * 
 * As we can't create object of an interface there is no serialization concept.
 * so every interface variable is static there is no need of transient modifier.
 * 
 * As we can't change the value for interface variable is final we can't declare
 * it as volatile.
 * 
 * NOTE: For the interface variable compulsory we should perform initialization
 * at the time of declaration. Otherwise we'll get CE.
 */
public interface Demo_C {
	String driveName = "com.mysql.jdbc.Driver";

	void m1();
}

interface A extends Demo_C {

	void m2();
}

interface B extends Demo_C, A {
	void m3();
}
