package java_lang;

/**
 * Wrapper classes:
 * 
 * Primitive values in Java are not objects. In order to manipulate these values
 * as objects, the java.lang package provides a wrapper class for each of the
 * primitive data types.
 * 
 * All wrapper classes, String, StringBuffer and StringBuilder are final. The
 * objects of all wrapper classes that can be instantiated are immutable, i.e.,
 * the value in the wrapper object cannot be changed.
 * 
 * Although the Void class is considered a wrapper class, it does not wrap any
 * primitive value and we can not instantiate it(i.e., has no public
 * constructors). It just denotes the Class object representing the keyword
 * void.
 * 
 * NOTE:
 * 
 * In all wrapper classes .equals() is OVERRIDEN for content comparison whether
 * we override or not. In all wrapper classes toString() is OVERRIDEN to return
 * it's content.
 * 
 * The Wrapper classes which are not child class of Number class are Character
 * and Boolean class.
 * 
 * Remember that,
 * 
 * 1. wrapper classes (java.lang.Boolean, java.lang.Integer, java.lang.Long,
 * java.lang.Short etc.) are also final and so they cannot be extended.
 * 
 * 2. java.lang.Number, however, is not final. Integer, Long, Double etc. extend
 * Number.
 */
public class Demo_F {

	public static void main(String[] args) {

		/**
		 * Common Wrapper Class Constructors:
		 * 
		 * The Character class has only one public constructor, taking a char
		 * value as parameter. The other wrapper classes all have two public
		 * one-argument constructors: one takes a primitive value and the other
		 * takes a string.
		 */
		Integer integer = new Integer('a');
		System.out.println("Integer primitive type:" + integer);

		/*
		 * If the string is not properly formated then we'll get
		 * NumberFormatException.
		 */
		Integer integer2 = new Integer("0");
		System.out.println("Integer string type:" + integer2);

		Character character = new Character('a');
		System.out.println("Character primitive type:" + character);

		Double double1 = new Double(12.5);
		Double double2 = new Double("0.0");
		System.out.println("Double primitive type:" + double1);
		System.out.println("Double string type:" + double2);

		/*
		 * Float class contains three constructors.
		 */
		Float float1 = new Float(12.0);
		Float float2 = new Float(12f);
		Float float3 = new Float("0");
		System.out.println("Float primitive type:" + float1 + " " + float2);
		System.out.println("Float string type:" + float3);

		Boolean boolean1 = new Boolean(true);
		Boolean boolean2 = new Boolean("false");
		Boolean bool = new Boolean("Ronak");
		System.out.println("Boolean primitive type:" + boolean1);
		System.out.println("Boolean string type:" + boolean2);
		System.out.println(bool);
		
		Boolean boolean3 = new Boolean("false");

		System.out.println(".equals():" + boolean2.equals(boolean3));
		System.out.println("== operator:" + (boolean2 == boolean3));

	}
}
