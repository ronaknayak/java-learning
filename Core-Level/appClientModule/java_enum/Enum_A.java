package java_enum;

/**
 * enumeration (ENUM):
 * ----------------------------------------------------------------------------
 * If we want to represents a group of named constants then we should go for
 * ENUM.
 * 
 * Objective:
 * 
 * 1) We should always use ENUMS when variable specially method parameter can
 * only take one out of set of possible values.
 * 
 * 2) If we use ENUMS then it increases compile time checking and avoid errors
 * from passing invalid constants.
 * 
 * 3) ENUMS improves both likelihood of correctness and readability without
 * writing a lot of boilerplate (extra coding).
 * 
 * 
 * Internal implementation of ENUM:
 * 
 * Every enum internally implemented by using class concept.
 * 
 * Every enum constant is always public static final.
 * 
 * Every enum constant represents an object of the type enum.
 * 
 * 
 * 
 * Declaration and usage of enum:
 * 
 * Every enum constant is static. Hence, we can access by using enum name.
 * Inside enum toString() implemented to return name of the constant directly.
 * 
 * If we want to use enum type only for one class then we should declare enum
 * constants within a class only. If other classes want to use enum constants
 * then we should declare enum outside of class i.e. In separate file.
 * 
 * If we are trying to declare enum inside a method or constructor then we'll
 * get CE.
 * 
 * If we declare enum outside the class, the applicable modifiers are PUBLIC,
 * <DEFAULT> and STRICTFP. As every enum is always final implicitly, we can't
 * declare it as final explicitly.
 * 
 * If we declare enum inside the class, the applicable modifiers are PUBLIC,
 * <DEFAULT>, STRICTFP, private, protected and static.
 * 
 * 
 * 
 * Note(ENTHUWARE):
 * ============================================================================
 * 1. An enum is allowed to implement interfaces. But, An enum cannot extend any
 * other enum or class because an enum is implicitly final(So, you can't extends
 * it from other enum or class) & extends from java.lang.Enum.
 * 
 * 2. enum constructor is always private by default. You cannot make it public
 * or protected. private is allowed but is redundant. If an enum type has no
 * constructor declarations, then a private constructor that takes no parameters
 * is automatically provided. Also, Unlike a regular java class, you cannot
 * access a non-final static field from an enum's constructor.
 * 
 * 3. Since enum maintains exactly one instance of its constants, you cannot
 * clone it. You cannot even override the clone method in an enum because
 * java.lang.Enum makes it final.
 * 
 * 4. Compiler provides an enum with two public static methods automatically
 * -  values() and valueOf(String). The values method returns an array of its
 * constants and valueOf method tries to match the String argument exactly (i.e.
 * CASE SENSITIVE) with an enum constant and returns that constant if successful
 * otherwise it throws java.lang.IllegalArgumentException.
 * 
 * It has a method ordinal(), which returns the index (starting with 0) of that
 * constant i.e. the position of that constant in its enum declaration. It has a
 * method name(), which returns the name of this enum constant, exactly as
 * declared in its enum declaration.
 * 
 * Because of second & third point we can also use enum as SINNGLETON class.
 * 
 * 5. It implements java.lang.Comparable (thus, an enum can be added to sorted
 * collections such as SortedSet, TreeSet, and TreeMap). The natural order of
 * enums is the order in which they are defined. It is not necessarily same as
 * alphabetical order of their names.
 */

public class Enum_A {

	private enum BRANCH {
		MP, AP, KB, AG, NP
	}

	public static void main(String[] args) {
		Month month = Month.DEC;
		System.out.println("Access enum constant:" + month);
		System.out.println("Access enum constant:" + BRANCH.AP);

		try {
			Month m = Month.valueOf("DEC");
			System.out.println("valueOf(): " + m);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

enum Month {
	// Semicolon is optional.
	JAN, FEB, MARCH, APRIL, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC
}
