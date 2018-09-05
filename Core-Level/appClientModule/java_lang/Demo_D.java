package java_lang;

/**
 * 3) public boolean equals(Object o) :
 * 
 * Used for to check equality of two objects. By default this method present in
 * Object class and which is meant for reference comparison (Address
 * comparison).
 * 
 * This behavior is exactly same as == operator.
 * 
 * If we want to perform content comparison instead of reference comparison we
 * should override equals() in our class.
 * 
 * While overriding equals() for content comparison we have to take care about
 * the following:
 * 
 * 1) What is the meaning of equality i.e. whether we have to check only names
 * or only roll numbers or both.
 * 
 * 2) If we are passing different type of object, our equals() should not raise
 * ClassCastException. i.e. We have to handle ClassCastException to return
 * false.
 * 
 * 3) If we are passing null argument, our equals() should not raise
 * NullPointerException. i.e. We have to handle NullPointerException to return
 * false.
 * 
 * ***************************************************************************
 * 
 * Relation between == operator & .equals() method:
 * 
 * If two objects are equal by == operator then this objects are always equal by
 * .equals() method. i.e. If r1 == r2 is true then r1.equals(r2) is always true.
 * 
 * If two objects are not equal by == operator then we can't conclude anything
 * about .equals() method. It may returns true or false. i.e. If r1 == r2 is
 * false then r1.equals(r2) may returns true or false. Because it depends on
 * whether we override .equals() method or not & how we override.
 * 
 * If two objects are equal by .equals() then we can't conclude anything about
 * == operator. It may returns true or false. i.e. r1.equals(r2) is true then we
 * can't conclude anything about r1 == r2. Because it depends on whether we
 * override .equals() method or not & how we override.
 * 
 * If two objects are not equal by .equals() then this objects are always not
 * equal by == operator. i.e. r1.equals(r2) is false then r1 == r2 is always
 * false.
 * 
 * Difference between == operator & .equals() method: TODO: eBook
 */

public class Demo_D {
	public static void main(String[] args) {

		Student s1 = new Student("Rohit", 12);
		Student s2 = new Student("Virat", 56);
		Student s3 = new Student("Rohit", 12);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		// Where, s1 is the current object

		System.out.println("Different reference comparision:"
				+ s1.equals("Dhoni"));
		System.out.println("Null comparision:" + s1.equals(null));
		System.out.println("===================================");

		/**
		 * NOTE:
		 * 
		 * In StringBuffer and StringBuilder class .equals() is NOT OVERRIDEN
		 * for content comparison. Hence, object class .equals() get executed
		 * which is meant for reference comparison.
		 * 
		 * In String class & Wrapper classes .equals() is OVERRIDEDN for content
		 * comparison.
		 * 
		 * To use == operator there should be some relation between objects.
		 * either parent to child or child to parent. Otherwise, It raise
		 * compile time error. But, .equals() method does not raise any compile
		 * time error, It simply returns false.
		 */
		String name = new String("Aarya");
		String nam = new String("Aarya");
		StringBuffer buffer = new StringBuffer("Ashwin");
		StringBuffer stringBuffer = new StringBuffer("Ashwin");

		System.out.println(name == nam);
		System.out.println(".equals() for String: " + name.equals(name));

		System.out.println(buffer == stringBuffer);
		System.out.println(".equals() for StringBuffer: "
				+ buffer.equals(stringBuffer));

		// System.out.println(name == buffer);
		System.out
				.println("Simply returns false: " + name.equals(stringBuffer));
		System.out.println("===================================");

		/**
		 * 
		 * Important Note: Hashing related algorithm follow the below
		 * fundamental rule,
		 * 
		 * TWO EQUIVALENT OBJECTS PLACED IN SAME BUCKET, BUT ALL OBJECTS PRESENT
		 * IN THE SAME BUCKET NEED NOT BE EQUAL.
		 * 
		 * 
		 * Contract between .equals() & hashCode():
		 * 
		 * 1) If two objects are equal by .equals(), then there Hash codes must
		 * be equal. i.e. Two equivalent objects should have same Hash code.
		 * 
		 * i.e. If r1.equals(r2) is true then r1.hashCode() == r2.hashCode()
		 * always true.
		 * 
		 * Object class .equals() & hashCode() follows above contract. Hence,
		 * whenever we are overriding .equals() method compulsory we should
		 * override hashCode() method to satisfy above contract. i.e. Two
		 * equivalent objects should have same Hash code.
		 * 
		 * 
		 * 2) If two objects are not equal by .equals(), then there are no
		 * restrictions on hashCodes. They can be equal or different.
		 * 
		 * 3) If Hash codes of two objects are equal, then we can't conclude
		 * anything about .equals(). It may return true or false.
		 * 
		 * 4) If Hash codes of two objects are not equal, then they always not
		 * equal by .equals().
		 * 
		 * 
		 * Recommendation:
		 * 
		 * [1] To satisfy the contract between .equals() & hashCode(), whenever
		 * we are overriding .equals() method compulsory we have to override
		 * hashCode() method. Otherwise, we won't get any CE or RE. But, It's
		 * not a good programming practice.
		 * 
		 * For instance, In String class .equals() method is OVERRIDEN for
		 * content comparison & hence, hashCode() method is OVERRIDEN to
		 * generate hash code based on content. But, In StringBuffer class
		 * .equals() method is not OVERRIDEN for content comparison& hence,
		 * hashCode() method is not OVERRIDEN.
		 * 
		 * [2] To maintain the contract between .equals() & hashCode(), whatever
		 * the parameter we are using while overriding .equals() we have to use
		 * same parameter while overriding hashCode() also.
		 * 
		 * [3] In all Collection classes, Wrapper classes & in String class
		 * .equals() method is OVERRIDEN for content comparison. Hence, It's
		 * highly recommended to override .equals() method in our class also for
		 * content comparison.
		 * 
		 * 
		 * 
		 * Excellent Point:
		 * 
		 * If hash codes are same then only it checks for equals method. If two
		 * objects uses default hash code method,Both will have different memory
		 * address hence different hash code & so it never check for equals
		 * method.
		 * 
		 */
		System.out.println(name.equals(nam));
		System.out.println("Case for String class: " + name.hashCode() + "\t"
				+ nam.hashCode());

		System.out.println(buffer.equals(stringBuffer));
		System.out.println("Case for StringBuffer class: " + buffer.hashCode()
				+ "\t" + stringBuffer.hashCode());
	}
}

class Student {
	String name;
	int rollno;

	public Student(String name, int rollno) {
		super();
		this.name = name;
		this.rollno = rollno;
	}

	// @Override
	// public boolean equals(Object obj) {
	//
	// try {
	// String name = this.name;
	// int rollno = this.rollno;
	//
	// Student std = (Student) obj;
	// String na = std.name;
	// int roll = std.rollno;
	//
	// if (name.equals(na) && rollno == roll) {
	// return true;
	// } else {
	// return false;
	// }
	// } catch (ClassCastException ex) {
	// // To avoid ClassCastException while comparing different object
	// return false;
	// } catch (NullPointerException ne) {
	// // To avoid NullPointerException while comparing with NULL object
	// return false;
	// }

	// Another Short way to override equals() method
	@Override
	public boolean equals(Object obj) {

		if (obj == this) {
			// To make equals() method more efficient.
			return true;
		}

		if (obj instanceof Student) {
			Student std = (Student) obj;

			if (name.equals(std.name) && rollno == std.rollno) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return name.hashCode() + rollno;
	}
}
