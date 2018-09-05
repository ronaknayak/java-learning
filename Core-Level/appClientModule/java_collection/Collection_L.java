package java_collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * Comparable(I):
 * 
 * Java Comparable interface is used to order the objects of user-defined class.
 * This interface is found in java.lang package.
 * 
 * public int compareTo(Object o)
 * 
 * If we are depending on Default Natural sorting order then while adding
 * objects into the TreeSet, JVM will call compareTo() method. It compare like,
 * 
 * object1.compareTo(object2)
 * 
 * Here, object1 is the object which is to be inserted & object2 is the object
 * which is already inserted.
 * 
 * We can sort the elements of String objects, Wrapper class objects and
 * User-defined class objects.
 * 
 * 
 * Note:
 * 
 * String class and Wrapper classes already implements Comparable interface by
 * default. So if you store the objects of string or wrapper classes in list,
 * set or map, it will be Comparable by default.
 * 
 * The Comparable interface is only allow to sort a single property. To sort
 * with multiple properties, you need Comparator.
 * 
 * If Default Natural sorting order not available or If we are not satisfied
 * with the default Natural sorting order then we can go for customized sorting
 * by using Comparator(I).
 */

public class Collection_L {
	public static void main(String[] args) {

		Set<Student> students = new TreeSet<Student>();

		students.add(new Student(101, "Vijay", 23));
		for (Student st : students) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		students.add(new Student(106, "Ajay", 27));
		for (Student st : students) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		students.add(new Student(105, "Jay", 25));
		for (Student st : students) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		students.add(new Student(109, "Rahul", 21));
		for (Student st : students) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}

		/**
		 * Sort List objects using Utility class Collections.
		 */
//		ArrayList<Student> al = new ArrayList<Student>();
//		al.add(new Student(101, "Vijay", 23));
//		al.add(new Student(106, "Ajay", 27));
//		al.add(new Student(105, "Jay", 25));
//
//		Collections.sort(al);
//		for (Student st : al) {
//			System.out.println(st.rollno + " " + st.name + " " + st.age);
//		}
	}
}

class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student st) {
		System.out.println("In compareTo() method..." + this.age + " <> "
				+ st.age);
		if (this.age == st.age) {
			System.out.println("No Change");
			return 0;
		} else if (this.age > st.age) {
			System.out.println("Come after");
			return 1;

		} else {
			System.out.println("Come before");
			return -1;
		}
	}

	@Override
	public int hashCode() {
		System.out.println("In hash function***");
		return rollno;
	}

	@Override
	public boolean equals(Object other) {
		System.out.println("In equals function###");
		if (!(other instanceof Student)) {
			return false;
		}
		Student otherNode = (Student) other;
		return this.name.equals(otherNode.name) && this.age == otherNode.age;
	}
}