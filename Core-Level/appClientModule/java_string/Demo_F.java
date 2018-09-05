package java_string;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Formatter class:
 * -----------------------------------------------------------------------------
 * 
 * This class provides support for common format for numeric, string and
 * date-time and locale specific output.
 * 
 * The most commonly used format function is:
 * 
 * Formatter format(String fmtString, Object ... arguments)
 * 
 * A format specifier begins with a percent(%) sign followed by the format
 * conversion specifier. The format specifiers and the arguments are matched in
 * order from left to right.
 * 
 * Example: %d
 * 
 * ********************************************************
 * 
 * The format() method accepts a wide variety of format specifiers. When an
 * UpperCase specifier is used, then letters are shown in UpperCase. Otherwise,
 * the upper- and LowerCase specifiers perform the same conversion.
 * 
 * Each call to format() adds output to the end of the previous output.
 * 
 * ********************************************************
 * 
 * An integer following % and preceding the format specifier acts as a minimum
 * field width.
 * 
 * Example: %8d provides an eight byte field in which to print an integer.
 * 
 * Spaces are used for padding by default.
 * 
 * Field width can be provided for all format specifiers except %n (newline)
 * 
 * ********************************************************
 * 
 * A precision specifier can be used with %f, %e, %g, and %s.
 * 
 * The precision specifier added to floating-point data using the %f or %e
 * specifiers, the precision specifier determines the number of decimal places
 * displayed.
 * 
 * The format is minimum field width specifier (or not), followed by a
 * period(.), followed by an integer: %10.4f is used to indicate a ten byte
 * field with four decimal places.
 * 
 * NOTE: When applied to Strings, the precision specifier indicates the maximum
 * field length: %5.7s displays a string with at least five characters and not
 * exceeding seven characters. Extra characters are truncated.
 * 
 * ********************************************************
 * 
 * The optional flags is a set of characters that modify the output format. The
 * set of valid flags depends on the conversion.
 * 
 * Such as - 0 , + ( space etc.
 * 
 * "(" Enclose negative numbers in parentheses - Applicable only if conversion
 * char is d or f (i.e. for numbers).
 * 
 * "," Use locale-specific grouping separators (i.e., the comma in 123,456) -
 * Applicable only if conversion char is d or f (i.e. for numbers).
 * 
 * "0" Pad this argument with zeroes - Applicable only if conversion char is d
 * or f (i.e. for numbers). Must specify width as well or else will get RE.
 * 
 * "-" Pad on the right - Must specify width as well or else will get RE.
 * 
 * "+" Include a sign (+ or -) with this argument - Applicable only if
 * conversion char is d or f (i.e. for numbers).
 * 
 * ********************************************************
 * 
 * %[argument_index$][flags][width][.precision]CONVERSION_SPECIFIER_TYPE
 * 
 * Example: %2$-10.2f
 * 
 * The optional [argument_index] is a decimal integer indicating the position of
 * the argument in the argument list. The first argument is referenced by "1$",
 * the second by "2$", etc.
 * 
 * [flag] is a special formatting instruction. For example, the + flag specifies
 * that a numeric value should always be formatted with a sign, and the 0 flag
 * specifies that 0 is the padding character. Other flags include – that is pad
 * on the right , + pad on the left (if the formatted object is a string). Note
 * that some flags cannot be combined with certain other flags or with certain
 * formatted objects.
 * 
 * [width] denotes the minimum number of output characters for that Object.
 * 
 * [.precision] denotes the precision of floating point numbers in the output.
 * That is basically the number of decimal digits you wish to print on the
 * output. But it can be used for other types to truncate the output width.
 * 
 * type along with %, are the only MANDATORY formatting arguments. type simply
 * denotes the type of the object that will be formatted in the output. For
 * integers that is d, for strings that is s, for floating point numbers that is
 * f, for integers with hex format that is x.
 * 
 * 
 * 
 * Notes-to-Remember(ENTHUWARE):
 * 
 * The default number of decimals that %f prints is 6, so for Math.PI, 3.141593
 * is printed.
 * 
 * The rule for %b is : If the argument is null, then the result is "false". If
 * argument is a boolean or Boolean, then the result is the string returned by
 * String.valueOf(). Otherwise, the result is "true".
 * 
 * A format specification must start with a % and end with a conversion char ( b
 * boolean, c char, d integer, f floating point, and s string). Anything before
 * a % and after the conversion character is printed as it is.
 * 
 * formatting function works for wrapper objects just as it works for
 * primitives. e.g. System.out.printf("\"%c\"", new Character('d'));
 */

public class Demo_F {
	public static void main(String[] args) {

		// allBasicOperations();
		// stringFormatExample();
		// timeAndDateExample();

		Pattern pattern = Pattern.compile("(\\s|^)0[xX][0-9a-fA-F]+(\\s|$)");
		Matcher matcher = pattern.matcher("asdf      0x14  jjhgjhg  0x22 0x22");
		while (matcher.find()) {
			System.out.println("Found the text " + matcher.group()
					+ " starting at " + matcher.start()
					+ " and ending at index " + matcher.end());
		}
	}

	static void allBasicOperations() {

		System.out.println(String.format("%s gap filler %d %f", "Ronak", 100,
				23.10));

		/**
		 * Format Specifiers:
		 * 
		 * %c - Character
		 * 
		 * %b - boolean
		 * 
		 * %d - Decimal integer
		 * 
		 * %e %E - Scientific notation
		 * 
		 * %f - Decimal floating-point
		 * 
		 * %n - Inserts a newline character
		 * 
		 * %s %S - String
		 * 
		 * %t %T - Time and date
		 * 
		 * %x %X - Integer hexadecimal
		 * 
		 * %% Inserts a % sign
		 * 
		 * If the argument doesn't match the type-checks, an exception
		 * IllegalFormatException is thrown.
		 */

		System.out.println(String.format(
				"Copying file%nTransfer is %d%% complete", 88));

		/*
		 * Format to 2 decimal places in a 16 character field.
		 * 
		 * The default padding is done with spaces for width field.
		 */
		System.out.println(String.format("%16.2e", 123.1234567));

		// Format 4 decimal places.
		System.out.println(String.format("%.4f", 123.1234567));

		// print string as it is
		System.out.println("String output:" + String.format("%s", "12345"));

		// will pint the string as it is. If the string has less than 15
		// characters, the output will be padded on the left.
		System.out.println("String output:" + String.format("%15s", "12345"));

		// will print the string as it is. If the string has less than 15
		// characters, the output will be padded on the right.
		System.out.println("String output:"
				+ String.format("%-15s %d", "12345", 1));

		// will print maximum 10 characters of the string.
		System.out.println("String output:"
				+ String.format("%.10s", "123323232323232"));
		System.out.println("String output:"
				+ String.format("%10.10s", "123.123"));

		/*
		 * An integer between the % sign and the format conversion code acts as
		 * a minimum field width specifier.
		 * 
		 * The default padding is done with spaces.
		 * 
		 * If you want to pad with 0's, place a 0 before the field width
		 * specifier. But, for that case we must specify width or else it throws
		 * runtime exception.
		 */
		System.out.println("0 flag:" + String.format("%05d", 88));

		/*
		 * The ( flag shows negative numeric inside parentheses, rather than
		 * with a leading -.
		 */
		System.out.println("( flag:" + String.format("%(d", -100));

		/* The comma (,) flag adds grouping specifiers. */
		System.out.println(", flag:" + String.format("%,.2f", 1234567890.123));

		/*
		 * will print the integer as it is. If the number of digits is less than
		 * 16, the output will be padded on the right.
		 * 
		 * Must specify width as well or else it throws exception at runtime.
		 */
		System.out.printf("- flag: %-16d%-5d%n", 1234567890, 12345);

		System.out.printf("+ flag: %+16d%n", 1234567890);

		System.out.printf("+%-5d -%5d%n", 1, 67890);

		/*
		 * Normally, format specifiers and arguments are matched in order, from
		 * left to right.
		 * 
		 * However, by using an argument index you can explicitly control which
		 * argument a format specifier matches.
		 * 
		 * An argument index immediately follows the % in a format specifier:
		 * n$, where n is the index of the desired argument, beginning with 1.
		 */
		System.out.println(String.format("%3$d %2$d %1$S", "Ronak", 20, 30));

		System.out.println(String.format("%3$d %1$d %d", 1, 20, 30));
	}

	static void stringFormatExample() {

		System.out.println(String.format("Integer : %d", 15));

		System.out.println(String.format(
				"Floating point number with 3 decimal digits: %.3f\n",
				1.21312939123));

		System.out.println(String.format("String: %s, integer: %d, float: %f",
				"Hello World", 89, 9.0));

		// Integer Formating
		System.out.println(String.format("Nomber %6d", 123));

		System.out.println(String.format("Nomber %-6d %d", 123, 1));

		System.out.println(String.format("Nomber %06d", 123));

		// String Formating
		System.out.println(String.format("%s", "RonakNayak"));

		System.out.println(String.format("%15s", "RonakNayak"));

		System.out.println(String.format("%-15s %s", "Ronak", "Nayak"));

		System.out.println(String.format("%.5s", "How are you"));

		// Float Formating
		System.out.println(String.format("Float Nomber %f", 12.123));

		System.out.println(String.format("Float Nomber %.4f", 12.123456));

		System.out.println(String.format("Float Nomber %010.0f", 12.12345));
	}

	static void timeAndDateExample() {

		/**
		 * %t formats time and date information.
		 * 
		 * %t specifier requires the use of a suffix to describe the portion and
		 * precise format of the time or date desired.
		 * 
		 * The argument corresponding to the %t specifier must be of type
		 * Calendar, Date, Long, or long.
		 * 
		 * %tD - date as MM/dd/yy(i.e. default format) while %td is day %tm is
		 * month and %ty is 2 digit year while %tY is four digit year
		 * 
		 * %tB - full format of month i.e. February
		 */
		Date today = new Date();
		System.out.println(String.format("Today is %tD", today));

		System.out.println(String.format("Date in dd/mm/yy format %td/%tm/%tY",
				today, today, today));

		Calendar cal = Calendar.getInstance();

		// Display month by name and number.
		System.out.println(String.format("%tB %tb %tm", cal, cal, cal));

		// Display standard 12-hour time format.
		System.out.println(String.format("%tr", cal));

		// Display standard 24-hour time format.
		System.out.println(String.format("%tR", cal));

		// Display complete time and date information.
		System.out.println(String.format("%tc", cal));

		// Display just hour and minute.
		System.out.println(String.format("%tl:%tM", cal, cal));
	}
}
