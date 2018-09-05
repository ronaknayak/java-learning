package java_generics;

/**
 * Generic class Understanding:
 * -------------------------------------------------------------------------
 * Until 1.4 version, A Non-generic version of ArrayList class is declared as,
 * 
 * class ArrayList {
 * 
 * add(Object o)
 * 
 * Object get(int i)
 * 
 * }
 * 
 * The argument to add method is object and hence, we can add any type of object
 * to the ArrayList. Due to this, We are missing Type-safety.
 * 
 * The return type of get() is Object. Hence, At the time of retrieval we have
 * to perform Type-casting.
 * 
 * 
 * 
 * But in 1.5 version, A generic version of ArrayList class is declared as,
 * 
 * class ArrayList<T> {
 * 
 * add(T t)
 * 
 * T get(int index)
 * 
 * }
 * 
 * Where, T is Type-parameter.
 * 
 * Based on our Runtime requirement, T will be replaced with our provided type.
 * For example,
 * 
 * To hold only IPICSMessage type of object we have to create generic version of
 * ArrayList object as,
 * 
 * ArrayList<IPICSMessage> list = new ArrayList<IPICSMessage>();
 * 
 * For this requirement the Compiler considered version of ArrayList class is,
 * 
 * class ArrayList<IPICSMessage> {
 * 
 * add(IPICSMessage message)
 * 
 * IPICSMessage get(int index)
 * 
 * }
 * 
 * The argument to add() became IPICSMessage type. Hence, we can add only
 * IPICSMessage type of objects. By mistake, If we are trying to add any other
 * type we'll get CE. i.e.We are getting Type-safety.
 * 
 * The return type of get() became IPICSMessage, hence at the time of retrieval
 * we can assign directly to the IPICSMessage type variable. i.e. It's not
 * required to perform Type-casting.
 * 
 * In genericS we are associating Type-parameter to the class, such type of
 * parameterized classes are nothing but Generic Classes.
 * 
 * 
 * 
 * 
 * 
 * Based on our requirement, we can define our own generic classes also.
 * 
 * class Account<T> {}
 * 
 * The <T> is a type token that signals that this class can have a type set when
 * instantiated.
 * 
 * Account<Saving> a = new Account<Saving>();
 * 
 * Account<Current> a = new Account<Current>();
 * 
 * 
 * Generic Interface:
 * ----------------------------------------------------------------------
 * Comparable interface is a great example of Generics in interfaces and it’s
 * written as:
 * 
 * public interface Comparable<T> {
 * 
 * public int compareTo(T o);
 * 
 * }
 */

public class Generics_C {
	public static void main(String[] args) {

		// We can store only Saving type of objects. Otherwise, CE.
		Account<Saving> account = new Account<>(new Saving("8.5"));
		System.out.println(account.getAccountObj().getClass());

		// At the time of retrieval, No need of Type-casting
		Saving saving = account.getAccountObj();
		System.out.println("Rate of interest in Saving Account is "
				+ saving.rateOfIntrest);

		Account<Current> acc = new Account<>(new Current("7.8"));
		System.out.println(acc.getAccountObj().getClass());
		Current current = acc.getAccountObj();
		System.out.println("Rate of interest in Current Account is "
				+ current.rateOfIntrest);
	}
}

/**
 * A class that can refer to any type is known as generic class. A generic type
 * is a class or interface that is parameterized over types. Here, we are using
 * T type parameter to create the generic class of specific type.
 * 
 * The T type indicates that it can refer to any type (like String, Integer,
 * Saving etc.). The type you specify for the class, will be used to store and
 * retrieve the data.
 * 
 * As with generic methods, the type parameter section of a generic class can
 * have one or more type parameters separated by commas.
 */
class Account<T> {

	T account;

	public Account() {
	}

	public Account(T object) {
		this.account = object;
	}

	public T getAccountObj() {
		return account;
	}
}

class Saving {

	String rateOfIntrest;

	public Saving(String rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
}

class Current {
	String rateOfIntrest;

	public Current(String rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
}