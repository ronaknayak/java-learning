package java_generics;

import java.util.ArrayList;

/**
 * Generic methods & wild card character(?):
 * ----------------------------------------------------------------------------
 * 
 * Java Generic's wild-cards is a mechanism in Java GenericS aimed at making it
 * possible to cast a collection of a certain class, e.g A, to a collection of a
 * subclass or superclass of A. This text explains how.
 * 
 * The ? (question mark) symbol represents wild-card element. It means any type.
 * If we write <? extends Number>, it means any child class of Number e.g.
 * Integer, Float, Double etc.
 * 
 * 1) m1(ArrayList<String> list) [Upper bounded Wild-card]
 * 
 * We can call this method by passing ArrayList of only String type.
 * 
 * But, within the method we can add only String type of objects & null to the
 * list. By mistake If we are trying to add ArrayList of any other type then
 * we'll get compile time error.
 *
 * 
 * 2) m1(ArrayList<?> list) [Unbounded Wild-card]
 * 
 * Sometimes we have a situation where we want our generic method to be working
 * with all types, in this case unbounded wild-card can be used.
 * 
 * We can call this method by passing ArrayList of any Unknown type.
 * 
 * Since the you do not know what type the List is typed to, you can only read
 * from the collection, and you can only treat the objects read as being Object
 * instances.
 * 
 * Cons: But, within the method we can't add anything to the list except null
 * because we don't know the type exactly. NULL is allowed because it's valid
 * value for any object type.
 * 
 * Pros: So, This type of methods are best suitable for Read only operation.
 * 
 * 
 * 3) m1(ArrayList<? extends X> list) [Sub-typing using wild-card]
 * 
 * X can be either class or interface. If X is a class then we can call this
 * method by passing ArrayList of either X type or it's child classes.
 * 
 * If X is an interface then we can call this method by passing ArrayList of
 * either X type or it's implementation classes.
 * 
 * But, within the method we can't add anything to the list except null. Because
 * we don't know the type of X exactly. This type of methods also best suitable
 * for Read only operation.
 * 
 * 
 * 4) m1(ArrayList<? super X> list) [Lower bounded Wild-card]
 * 
 * X can be either class or interface. If X is a class then we can call this
 * method by passing ArrayList of either X type or it's super classes.
 * 
 * If X is an interface then we can call this method by passing ArrayList of
 * either X type or super class of implementation class of X.
 * 
 * But, within the method we can add X type of objects & null to the list.
 * 
 * 
 * Here, summarizing three ways to define a collection (variable) using generic
 * wild-cards:
 * 
 * List<?> listUknown = new ArrayList<A>();
 * 
 * List<? extends A> listUknown = new ArrayList<A>();
 * 
 * List<? super A> listUknown = new ArrayList<A>();
 * 
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > Map<Object, ?> m = new LinkedHashMap<Object, Object>();
 * 
 * While this is a valid declaration, it will not allow you to put anything into
 * 'm'. The reason is that m is declared to be of type Map that takes an
 * instance of Object class as a key and instance of 'Unknown class' as value.
 * Therefore, if you try to put an Object, or Integer, or anything, the compiler
 * will not allow it because that 'Unknown' class is not necessarily Object or
 * Integer or any other class.  
 * 
 * Even though the actual object pointed to by 'm' is of type
 * LinkedHashMap<Object, Object>, the compiler looks only at the reference type
 * of the variable. Thus, 'm' is read-only. It would have worked if m were
 * declared as Map<Object, Object> m = .... Because in this case the compiler
 * *knows* that m can take an instance of Object as value. Instance of Object
 * covers all kind of objects.
 * 
 * 
 * > Map<Object, ? super ArrayList> m = new LinkedHashMap<Object, ArrayList>();
 * 
 * 'm' is declared to be of type Map that takes an instance of Object class as a
 * key and an instance of 'a class that is either ArrayList or a superclass of
 * ArrayList' as value. This means that the value can be an instance of
 * ArrayList or its subclass.
 * 
 * However, you cannot put Object (which is a superclass of ArrayList) in it
 * because the compiler doesn't know the exact superclass that 'm' can take. It
 * could be AbstractList, or Object, or any other super class of ArrayList. The
 * compiler only knows that it is a superclass but not the exact type.
 * 
 * 
 * > public static <E extends CharSequence> List<? super E> doIt(List<E> nums)
 * 
 * Calling method, result = doIt(in);
 * 
 * The input parameter has been specified as List<E>, where E has to be some
 * class that extends CharSequence. So ArrayList<String>, List<String>, or
 * List<CharSequence> are all valid as reference types for 'in'.
 * 
 * The output type of the method has been specified as List<? super E> , which
 * means that it is a List that contains objects of some class that is a super
 * class of E. Here, E will be typed to whatever is being used for 'in'. For
 * example, if you declare ArrayList<String> in, E will be String.
 * 
 * The important concept here once the method returns, there is no way to know
 * what is the exact class of objects stored in the returned List. So you cannot
 * declare out in a way that ties it to any particular class, not even Object.
 * Thus, the only way to accomplish this is to either use non-typed reference
 * type, such as:  List result; or use the same type as the return type
 * mentioned in the method signature i.e. List<? super String> (Because E will
 * be bound to String in this case.)
 */

public class Generics_E {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("Today");
		list.add("Holiday");
		// We can call this method by passing any type
		m1(list);

		/** Check Declarations: */

		ArrayList<String> list2 = new ArrayList();

		ArrayList<?> list3 = new ArrayList();
		ArrayList<?> list4 = new ArrayList<Integer>();

		ArrayList<? extends Number> list5 = new ArrayList<Integer>();
		// ArrayList<? extends Number> list6 = new ArrayList<Object>();

		ArrayList<? super String> list6 = new ArrayList<Object>();

		/**
		 * We can use ? character only for declaration & we can't use it while
		 * object instantiation.
		 */
		// ArrayList<?> list7 =new ArrayList<?>();
		// ArrayList<?> list8 =new ArrayList<? extends Number>();
	}

	public static void m1(ArrayList<? super String> list) {
		// CE: Because we don't know the type exactly

		// list.add(new Integer(10));
		list.add("Not Valid");
		list.add(null);

		// Read operation only
		System.out.println(list);
	}
}
