package java_lang;

import java.util.HashMap;

/**
 * 2) public native int hashCode():
 * 
 * For every object JVM will generate a unique id which is nothing but Hash
 * code.
 * 
 * JVM will use hash code while saving object into Hashing related data
 * structures like HASHTABLE, HASHMAP etc. For example, Whenever we add any
 * Object in HashMap then JVM need hashCode of that object while saving that
 * object & We can give hashCode either by JVM generated or our own generated
 * hashCode.
 * 
 * The main advantage of saving object based on hash code is search operation
 * will become easy.
 * 
 * The most powerful search algorithm as of today is Hashing.
 * 
 * 
 * For customization we can Override hashCode() in our class.
 * 
 * If we are not override hashCode() then Object class hashCode() will be
 * executed. Which generates hashCode based on the address of an object. It does
 * not mean hashCode represent address of an object, JVM just use address for to
 * generate Hash Code. So, hashCode() method is not implemented in java and
 * that's why it's native method. (Though it is impossible to find address of an
 * object in java.)
 * 
 * Based on our requirement we can override hashCode(), then it's no longer
 * related to address of an object.
 * 
 * NOTE: HashCode of an Object and Address of an Object no way related to each
 * other.
 * 
 * Overriding hashCode() is said to be proper if and only if for every object we
 * have to generate a unique number as hash code.
 * 
 * 
 * toString() VS hashCode():
 * 
 * If we give opportunity to Object class toString() then it will internally
 * call hashCode().
 * 
 * If we give opportunity to our class toString() then it may not call
 * hashCode().
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > The hashCode() method of a class can be used to test inequality but not
 * equality of two objects of that class.
 * 
 * In other words, if the hash codes of two objects of the same class are not
 * equal, you can definitely say that the objects are not equal, However, if the
 * hash codes are equal, you cannot say anything about the equality of the
 * objects.
 * 
 * Rule: If the equals() method returns true, then hashCode() for both the
 * objects must return the same value. Note that the reverse is not required.
 * So, it is OK if the equals() method returns false but the hashCode() returns
 * same value for both the objects.
 * 
 * > If the equals() method is overridden, the hashCode() method should also be
 * overridden such a way that same hashCode is returned for objects that are
 * equal as per the equals method..
 * 
 * > However, the programmer should be aware that producing distinct integer
 * results for unequal objects may improve the performance of hash-tables.
 */

public class Demo_C {

	String name;
	int employeeCode;

	public Demo_C() {

	}

	public Demo_C(String name, int employeeCode) {
		this.name = name;
		this.employeeCode = employeeCode;
	}

	/**
	 * For every object if we are generating a unique number as Hash Code then
	 * Overriding of hashCode() said to be proper. Because for every employee
	 * there will be unique employee code.
	 */
	@Override
	public int hashCode() {
		return employeeCode;
	}

	public static void main(String[] args) {
		int searchEmpCode = 601;
		Demo_C search = new Demo_C();
		search.employeeCode = searchEmpCode;
		System.out.println("Object Reference:" + search);

		Demo_C c = new Demo_C("Ronak", 101);
		Demo_C c1 = new Demo_C("Ravi", 201);
		Demo_C c2 = new Demo_C("Hardik", 301);
		Demo_C c3 = new Demo_C("Nikhil", 401);
		Demo_C c4 = new Demo_C("Daxesh", 501);
		Demo_C c5 = new Demo_C("Ronak", 601);
		Demo_C c6 = new Demo_C("Ravi", 701);
		Demo_C c7 = new Demo_C("Hardik", 801);
		Demo_C c8 = new Demo_C("Nikhil", 901);
		Demo_C c9 = new Demo_C("Daxesh", 1001);
		Demo_C c10 = new Demo_C("Daxesh", 1101);

		HashMap<Integer, Demo_C> map = new HashMap<Integer, Demo_C>();
		map.put(101, c);
		map.put(201, c1);
		map.put(301, c2);
		map.put(401, c3);
		map.put(501, c4);
		map.put(601, c5);
		map.put(701, c6);
		map.put(801, c7);
		map.put(901, c8);
		map.put(1001, c9);
		map.put(1101, c10);

		if (map.containsKey(searchEmpCode)) {
			System.out.println("Found: " + map.get(searchEmpCode));
		}

	}
}
