package java_collection;

import java.util.TreeSet;

/**
 * TreeSet(c):
 * 
 * The underlying data structure is Balanced Tree.
 * 
 * Duplicate objects are not allowed.
 * 
 * Insertion order not preserved because all objects will be inserted based on
 * some sorting or order. It may be default natural sorting order or customized
 * sorting order.
 * 
 * Heterogeneous objects are not allowed. Otherwise, we'll get RE saying
 * ClassCastException. This cause because TreeSet compares different objects to
 * arrange them in order.
 * 
 * NULL insertion is possible(but, only once).
 * 
 * TreeSet implements SerializablE and CloneablE interfaces.
 * 
 * 
 * Constructors:
 * ----------------------------------------------------------------------------
 * TreeSet t = new TreeSet();
 * 
 * Creates an empty TreeSet object where the elements will be inserted according
 * to Default natural sorting order.
 * 
 * TreeSet t = new TreeSet(Comparator c);
 * 
 * Creates an empty TreeSet object where the elements will be inserted according
 * to customized sorting order specified by Comparator object.
 * 
 * TreeSet t = new TreeSet(Collection c);
 * 
 * TreeSet t = new TreeSet(SortedSet s);
 * 
 * 
 * 
 * For empty TreeSet as the first element we can insert NULL. But, At the moment
 * when we add an element we'll get NPE, because comparison operation performed
 * on null object.
 * 
 * Important:
 * 
 * Until 1.6 version, NULL is allowed as the first element to the empty TreeSet.
 * But, from 1.7 version onwards NULL is not allowed even as the first element.
 * i.e. NULL such type story is not applicable for TreeSet from 1.7 version
 * onwards.
 */

public class Collection_K {
	public static void main(String[] args) {

		Person person = new Person("Ronak");
		Person person2 = new Person("Jimmi");
		Person person3 = new Person("ronak");
		Person person4 = new Person("Maulik");

		TreeSet<Person> set = new TreeSet<Person>();
		set.add(person);
		set.add(person2);
		set.add(person3);
		set.add(person4);
		System.out.println("Natural sorting: \n" + set);

		/**
		 * If we are depending on Default natural sorting order compulsory the object
		 * should be Homogeneous & Comparable. Otherwise, we'll get RE:
		 * ClassCastException.
		 * 
		 * So, In our example if we add Person object directly in set then will end up
		 * with ClassCastException as Person class is not implementing Comparable
		 * interface.
		 * 
		 * An object is said to be Comparable if and only if corresponding class
		 * implements Comparable interface.
		 * 
		 * String class & all Wrapper classes already implement Comparable interface.
		 * But, StringBuffer class doesn't implements Comparable interface.
		 * 
		 * So, In our example we are adding Person's name in set as if it's type of
		 * String.
		 */

		TreeSet<StringBuffer> buffers = new TreeSet<StringBuffer>();
		buffers.add(new StringBuffer("Ronak"));
		buffers.add(new StringBuffer("Jimmi"));
		buffers.add(new StringBuffer("Maulik"));
	}
}

class Person implements Comparable<Person> {

	String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Person person) {
		if (this.name.compareTo(person.getName()) < 0) {
			return -1;
		} else if (this.name.compareTo(person.getName()) > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
