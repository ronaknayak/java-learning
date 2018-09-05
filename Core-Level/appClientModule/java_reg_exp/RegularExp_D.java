package java_reg_exp;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * String class split() method:
 * 
 * String class also contains split() to split the target string according to a
 * particular pattern & return string array.
 * 
 * 
 * Pattern class split() method:
 *
 * We can use Pattern class split method to split the target string according to
 * a particular pattern & return string array.
 * 
 * To split a text into multiple strings, based on a delimiter (Here delimiter
 * would be specified using regex).
 * 
 * NOTE:
 * 
 * Pattern class split() method can take target string as argument whereas
 * String class can take pattern as argument.
 * 
 * 
 * StringTokenizer:
 * --------------------------------------------------------------------------
 * It's a specially designed class for tokenization activity. We can use
 * StringTokenizer to divide the target string into streams of tokens.
 * 
 * StringTokenized present in java.util package.
 * 
 * The DEFAULT regular expression for StringTokenizer is space character.
 * 
 * 
 * It allows you to tokenize a string based on the delimiters that you provide.
 * If you don't provide any delimiters, a default set of delimiters will be
 * used, which are " \t\n\r\f".
 * 
 * Constructors:
 * -----------------------------------------------------------------------------
 * StringTokenizer(String string): Default delimiters, delimiters not returned
 * as tokens
 * 
 * StringTokenizer(String string, String delimiter): custom delimiters,
 * delimiters not returned as tokens.
 * 
 * StringTokenizer(String string, String delimiter, boolean returnDelims):
 * custom delimiters, delimiters returned as tokens if returnDelims is true.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > REMEMBER that the delimiter string itself doesn't act as a delimiter but
 * each character in the delimiter String acts as a delimiter. So,
 * StringTokenizer("abcde", "bd") will return a, c, and e and not abcde because
 * b and d both act as delimiter.
 * 
 * > If the input String doesn't contain any given delimiter character, the
 * whole String will be returned as one token.
 */

public class RegularExp_D {
	public static void main(String[] args) throws Exception {

		Pattern pattern = Pattern.compile("\\s");
		String[] s = pattern.split("Ronak Arvindbhai Nayak");
		for (String name : s) {
			System.out.println(name);
		}

		// pattern = Pattern.compile(".");
		// pattern = Pattern.compile("\\.");
		pattern = Pattern.compile("[.]");
		String[] site = pattern.split("www.einfochips.com");
		for (String string : site) {
			System.out.println(string);
		}

		String str = "OracleXYCertifiedXYProgrammer";
		String[] siteName = str.split("XY");
		for (String string : siteName) {
			System.out.println(string);
		}

		StringTokenizer tokenizer = new StringTokenizer("Ronak Nayak");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}

		// Every characters in the string delimiter argument is delimiter.
		StringTokenizer tokenize = new StringTokenizer("Team Lunch", "[abc]",true);
		while (tokenize.hasMoreTokens()) {
			System.out.println(tokenize.nextToken());
		}

		// Pattern mobileNumPattern = Pattern.compile("[789][0-9]{9}");
		// Pattern mobileNumPattern = Pattern.compile("0?[789][0-9]{9}");
		Pattern mobileNumPattern = Pattern.compile("(0|91)?[789][0-9]{9}");

		if (Pattern.matches(mobileNumPattern.toString(), "8000008699")) {
			System.out.println("Valid mobile number");
		} else {
			throw new Exception("Invalid mobile number");
		}
	}
}
