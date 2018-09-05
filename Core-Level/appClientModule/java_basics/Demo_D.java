package java_basics;

/**
 * DATA TYPES:
 * 
 * -> In java every variable and every expression has some type.
 * 
 * -> Each and every data type is clearly defined.
 * 
 * -> Every assignment should be checked by compiler for type compatibility.
 * because of these reason java is strongly typed programming language.
 * 
 * -> Java is not considered as pure object oriented programming language
 * because several oops feature are not satisfied by java. like, operator
 * overloading, multiple inheritance etc. moreover we are depending on primitive
 * data types which are not objects.
 *
 * 
 * -> Except boolean and char data type remaining data types are considered as
 * signed data type because we can represent both positive and negative numbers.
 * 
 * ->If we need numeric value without decimal places then should go for Integral
 * data types and if we need numeric value with some decimal places then would
 * be good to choose Floating point data types.
 * 
 * ->If we want 5 to 6 decimal places of accuracy then should go for float.
 * 
 * ->If we want 14 to 15 decimal places of accuracy then should go for double.
 * 
 * -> Old languages(like c or c++) are ASCII code based and number of allowed
 * different ASCII code characters are less than or equal to 256 and to
 * represent all those characters 8-bits is enough. hence the size of char in
 * old languages is 1 byte.
 * 
 * but, java is UNICODE based and the number of different UNICODE characters are
 * greater than 256 and less than or equal to 65536. to represent this many
 * characters 8 bits may not enough, compulsory we should go for 16 bits. hence
 * the size of char in java is 2 bytes and range is 0 to 65535. char data type
 * is unsigned.
 * 
 * -> Note: The default value for char data type is 0(which represent blank
 * space).
 */

public class Demo_D {

	public static void main(String[] args) {

		/**
		 * integral types—represent signed integers (byte, short, int, long) and
		 * unsigned character values (char)
		 * 
		 * floating-point types (float, double)—represent fractional signed
		 * numbers
		 * 
		 * boolean type (boolean)—represents logical values
		 * 
		 * The integer types and the char type are collectively called integral
		 * types.
		 */

		// If we assign any other value than numeric value we'll get
		// incompatible type compile time error.
		// byte a=true;

		// If we exceeds the range of byte than we'll get possible loss of
		// precision compile time error.
		// byte b = 10.5;
		// byte b=130;

		// If we exceeds the size, then we'll get compile time error- integer
		// number too large
		// int x=10000000000;

		// If we assign long value to int, then we'll get possible loss of
		// precision compile time error.
		// int x=1000000000l;

		// If we assign any other value than numeric value we'll get
		// incompatible type compile time error.
		// int x="ronak";

		// If we assign any other value than true or false, then we'll get
		// incompatible type compile time error.
		// boolean b=0;

		// If we assign this kind of unknown value then we'll get can't find
		// symbol compile time error.
		// boolean b=True;

		// If we assign null value we'll get incompatible type compile time
		// error, because null is default value
		// for object reference.
		// char ch=null;
	}
}
