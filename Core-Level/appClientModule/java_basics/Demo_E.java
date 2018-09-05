package java_basics;

/**
 * Literals:
 * 
 * ->A constant value which can be assign to the variable is called literal.
 * 
 * Integral literals:
 * 
 * ->decimal literals: allowed digits are 0 to 9 and base is 10. by default JVM
 * take all integral literals as decimal literal.
 * 
 * ->octal literals: allowed digits are 0 to 7 and base is 8. literal value
 * should be prefixed with 0.
 * 
 * ->hexadecimal literals:allowed digits are 0 to 9, a to f or A to F. base is
 * 16. literal value should be prefixed with 0x or 0X.
 * 
 * -> By default every integral literal is int type. but we can specify
 * explicitly as long type by suffixed with the l or L.
 * 
 * -> There is no direct way to specify byte and short explicitly.
 * 
 * -> If we assign any integral value to the byte and that integral is within
 * the range of byte then compiler treat it as byte literal automatically.
 * similarly short literal also.
 * 
 * 
 * Floating point literals:
 * 
 * ->By default every floating point literal is double type.hence, we can't
 * assign directly. but we can specify explicitly by suffixed with f or F.
 * 
 * ->We can specify floating point literal as double type by suffixed with d or
 * D.
 * 
 * ->We can't specify floating point literal in octal and hexadecimal form.
 * 
 * 
 * Char literals:
 * 
 * ->We can specify char literals as integral literals, which represent UNICODE
 * value of the character and that integral literal can be specify either in
 * decimal or octal or hexadecimal forms.
 * 
 * ->but allowed range is 0 to 65535.
 * 
 * ->Every escape character is char literal
 * 
 * ->Escape characters in java-\n,\t,\r,\b,\f,\',\",\\
 * 
 */

public class Demo_E {

	/**
	 * 
	 * *****1.7 version enhancements with respect to literals
	 * 
	 * 1)binary literals:
	 * 
	 * ->for integral data types until 1.6 version we can specify literal value
	 * in the following ways, DECIMAL, OCTAL and HEXADECIMAL form.
	 * 
	 * ->but from 1.7 version onwards we can specify literal value even in
	 * binary form also.
	 * 
	 * ->Allowed digits are 0 and 1.
	 * 
	 * ->Literal value should be prefixed with 0b or 0B.
	 * 
	 * 
	 * 2)usage of underscore symbol(_) in numeric literals:
	 * 
	 * ->from 1.7 version onwards we can use _ symbol between digits of numeric
	 * literal.
	 * 
	 * ->the main advantage of this approach is readability of code will be
	 * improved.
	 * 
	 * ->at the time of compilation this _ symbol will be removed
	 * automatically.hence after compilation it becomes usual double format.
	 * e.g. 123456.12
	 * 
	 * ->we can add more than one _ symbol between the digits.
	 * 
	 * -> Note: 8 bytes long value we can assign to 4 byte float value.because
	 * both are following different memory representation internally.
	 * 
	 */
	public static void main(String[] args) {

		// decimal literals
		int a = 10;
		System.out.println("int decimal literal:" + a);

		// octal literals
		int x = 077;
		System.out.println("int octal literal:" + x);

		// compile time error saying integer number too large, because allowed
		// digits are 0 to 7 only.
		// int b=0789;

		// hexadecimal literals
		int y = 0xFACE;
		System.out.println("int hexadecimal literal:" + y);

		// If we assign long value to int, than we'll get possible loss of
		// precision compile time error.
		// int i=10l;
		long i = 10l;
		System.out.println("long literal:" + i);

		// we'll get possible loss of precision compile time error.
		// float f=1.12;
		float f = 1123.456f;
		System.out.println("float literal:" + f);
		double e = 123.5d;
		System.out.println("double literal:" + e);

		// internally treated as decimal form and not as octal form.
		double k = 0129.5;
		System.out.println("double decimal literal:" + k);
		double z = 076;
		System.out.println("double octal literal:"+z);
		/*
		 * compile time error saying integer number too large, because allowed
		 * digits are 0 to 7 only. because there is no decimal point so compiler
		 * treat it as type int.
		 * 
		 * double l=0789;
		 */

		double y2 = 0XFE;
		System.out.println("double hexadecimal literal:"+y2);
		/*
		 * compile time error:malformed floating point literal.
		 * 
		 * double m=0x12.50;
		 */

		/**
		 * we can assign integral literal directly to the floating point data
		 * type and that integral can be either in decimal, octal and
		 * hexadecimal form. and later it will automatically converted into
		 * float or double type.
		 */
		float bi = 10;
		System.out.println("float decimal literal:" + bi);
		float bj = 0456;
		System.out.println("float octal literal:" + bj);
		float bk = 0x999;
		System.out.println("float hexadecimal literal:" + bk);
		
		double di = 1.2e3;
		System.out.println("floating point literal in exponential form:" + di);

		// we'll get possible loss of precision compile time error.
		// float dj=1.2e3;

		// we can specify floating point literal even in exponential form.
		float dj = 1.2e3f;
		System.out.println("floating point literal in exponential form:" + dj);

		// compile time error-can't find symbol
		// char ch1=a;

		// 3 compile time error- for first character a=unclosed char literal,
		// for second character b=unclosed char literal
		// not a statement because it's not a valid java statement
		// char ch1='ab';

		// char literals as integral literals which represent unicode value of
		// that character
		char ch1 = 97;
		System.out.println("char decimal literal:"+ch1);
		char ch2 = 0117;
		System.out.println("char octal literal:"+ch2);
		char ch3 = 0xFACE;
		System.out.println("char hexadecimal literal:"+ch3);
		char chi = 65535;
		System.out.println("char literal MAX value:"+chi);
		// compile time error-possible loss of precision
		// char ch4=65536;

		/**
		 * we can represent char literal in UNICODE representation which is
		 * nothing but '\u0000' 4-digit hexadecimal number
		 * */
		char ch5 = '\u0061';
		System.out.println("char literal in UNICODE representation:"+ch5);
		char ch6 = '\uface';
		System.out.println("char literal in UNICODE representation:"+ch6);
		char \u0062 = 'a';
		ch\u0061r ab = 'a';
		System.out.println("char literal in UNICODE representation:"+(\u0062)+" "+ab);
		
		char ch7 = '\n';
		System.out.println("char literal line break:"+ch7);
		char ch8 = '\t';
		System.out.println("char literal space:"+ch8+"Ronak");
		// compile time error:illegal escape character
		// char ch9='\m';

		System.out.println("this is \tsymbol");
		System.out.println("this is \'symbol\'");
		System.out.println("this is \"symbol\"");

		
		 //1.7 version enhancements
		int x1=0b1111;
		System.out.println("binary literal:"+x1);
		 
		 //1.7 version enhancements
		double d1=1_23_456.12; 
		double d2=45__6_9_7.4__56;
		System.out.println(d1+" underscore in numeric literal  "+d2);
		 
	}
}
