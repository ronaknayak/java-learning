package java_lang;

/**
 * AutoBoxing and AutoUnBoxing:
 * 
 * AutoBoxing concept internally implemented by compiler using valueOf() method.
 * 
 * AutoUnBoxing concept internally implemented by compiler using xxxValue()
 * method.
 * 
 * Note: Because of AutoBoxing and AutoUnboxing from 1.5 version onwards there
 * is no difference between primitive values and wrapper objects. We can assign
 * primitive values to wrapper object and vice-versa.
 * 
 * 
 * By AutoBoxing if an object is required to create compiler won't create object
 * immediately. first check if there is any object already created.
 * 
 * If it's already created then it will reuse existing object instead of
 * creating one. But this rule is applicable only in following cases:
 * 
 * 1)Byte - always 2)short - -128 to 127 3)Integer - -128 to 127 4)Long - -128
 * to 127 5) Character - 0 to 127 6) Boolean - always
 * 
 * 
 * IMPORTANT RULES:
 * 
 * 1) While resolving Overloaded methods compiler will always keeps the
 * precedence in below order:
 * 
 * a) Widening b) AutoBoxing c) VarArg
 * 
 * 2) Widening and Boxing (WB) not allowed.
 * 
 * 3) Boxing and Widening (BW) allowed.
 * 
 * 4) While overloading, Widening + varArg and Boxing + varArg can only be used
 * in a mutually exclusive manner i.e. not together.
 * 
 * 5) Widening between wrapper classes not allowed
 */
public class Demo_H {

	public static void main(String[] args) {
		
		Integer integer = new Integer(10);
		Integer integer2 = new Integer(10);
		System.out.println("1st case:" + (integer == integer2));

		Boolean boolean1 = new Boolean(true);
		Boolean boolean2 = new Boolean(true);
		System.out.println("2nd case:" + (boolean1 == boolean2));

		Integer integer3 = new Integer(10);
		Integer integer4 = 10;
		System.out.println("3rd case:" + (integer3 == integer4));

		Integer integer5 = 127;
		Integer integer6 = 127;
		System.out.println("4th case:" + (integer5 == integer6));

		Integer integer7 = 128;
		Integer integer8 = 128;
		System.out.println("5th case:" + (integer7 == integer8));

		Boolean boolean3 = false;
		Boolean boolean4 = false;
		System.out.println("6th case:" + (boolean3 == boolean4));

		int number = 100;
		// CE:
		// m1(number);
		m2(number);

		Integer integer9 = 12;
		m3(integer9);

		// CE: compiler will ambiguous
		// m4(10);

		Integer i = 111;
		// m5(i);

		/** Check declarations: */
		/*
		 * Because when compiler do AutoBoxing by taking integer value,
		 * internally it do by Integer.valueOf(12) and when it assign to Long
		 * data, compiler forces for casting.
		 */
		// Long long1 = 12;
		Object obj = 100;
		System.out.println("assign int to Object:" + obj);
		// Double double1 = 12;
		Number n = 10;
		System.out.println("assign int to Number:" + n);
	}

	public static void m1(Long l) {

		System.out
				.println("widening followed by auto-boxing  is not  allowed.");
	}

	public static void m2(Object o) {

		System.out.println("auto-boxing followed by widening is allowed.");
	}

	public static void m3(Integer i) {

		System.out.println("Boxing and Widening (BW) allowed.");
	}

	static void m4(long... l) {
		System.out.println("widening + var-arg");
	}

	static void m4(Integer... integers) {
		System.out.println("autoboxing + var-arg");
	}

	public static void m5(Long l) {
		System.out.println("Widening between wrapper classes is not allowed.");
	}

	/**
	 * Now Let me illustrate each of them with instances :
	 * 
	 * Overloaded methods Invoked by saying Called method
	 * 
	 * doX(Integer i) & doX(long l) doX(5) long (by Rule 1)
	 * 
	 * doX(int...i) & doX(Integer i) doX(5) Integer (by Rule 1)
	 * 
	 * doX(Long l) & doX(int...i) doX(5) int...i (Rule 2 & 1)
	 * 
	 * doX(Long l) & doX(Integer...i) doX(5) Integer...i(Rule 2&1)
	 * 
	 * doX(Object o) & doX(Long l) doX(5) Object o (Rule 2&3)
	 * 
	 * doX(Object o) & doX(int...i) doX(5) Object o (Rule 3&1)
	 * 
	 * doX(Object o) & doX(long l) doX(5) long l (Rule 3&1)
	 * 
	 * doX(long...l) & doX(Integer...i) doX(5) ambiguous (Rule 4)
	 * 
	 * doX(long...l) & doX(Integer i) doX(5) Integer (Rule 1)
	 * 
	 * doX(Long l) Integer i; doX(i) error (Rule 5)
	 * 
	 * doX(Long l) & doX(long...l) Integer i;doX(i) long...l(Rule 5 & 1)
	 * 
	 */

}
