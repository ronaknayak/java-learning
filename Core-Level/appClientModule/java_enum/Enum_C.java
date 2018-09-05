package java_enum;

/**
 * Features of java enum:
 * 
 * Java enum is more powerful because in addition to constants we can take
 * variables, methods, constructors etc. This facility is due to internal
 * implementation of enum concept which is class based.
 */
public enum Enum_C {

	MP, AP, KB, AG, NP("National Plazza");
	
	String name;
	private Enum_C() {
		System.out.println("constructor calling");
	}
	
	private Enum_C(String name) {
		this.name = name;
		System.out.println("parameterized constructor:"+name);
	}

	/**
	 * Case 1:
	 * 
	 * Inside enum we can declare main() and hence we can invoke enum class
	 * directly. Also, apart from constants if we want to take any other member
	 * then compulsory list of constants should be in 1st line (At lease
	 * semicolon).
	 */
	public static void main(String[] args) {
		System.out.println("main method inside enum." + AP);
	}
}

/** Case 2: */

// enum Case2 {
//
// public void m1() {
// }
// JAN, FEB, MARCH, APRIL, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC; }

/** Case 3: semicolon is mandatory in those cases. */

// enum Case3 {
//
// JAN, FEB, MARCH, APRIL, MAY, JUNE, JULY, AUG, SEP, OCT, NOV, DEC
//
// public void m1() {
//
// }
//
// }

/**
 * Case 4: Only members are not applicable. First line should be list of
 * constants
 */

// enum Case4 {
//
// public void m1() {
//
// }
//
// }

/** Case 5: */
enum Case5 {
	;
	public void m1() {

	}
}

/**
 * Case 6: Empty enum is always valid.
 */
enum Case6 {
}
