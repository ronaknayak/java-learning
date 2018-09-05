package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExp_C {

	private static String REGEX = "NBU Computer Softworld";
	private static String INPUT = "I work at NBU Computer Softworld."
			+ "\nI have been working in NBU Computer Softworld since last 2 years.";
	private static String REPLACE = "eInfochips";

	public static void main(String[] args) {

		// Replacement Methods

		Pattern p = Pattern.compile(REGEX);

		Matcher m = p.matcher(INPUT);

		/**
		 * The replaceFirst and replaceAll methods replace the text that matches
		 * a given regular expression.
		 * 
		 * As their names indicate, replaceFirst replaces the first occurrence,
		 * and replaceAll replaces all occurrences.
		 * 
		 * Both methods do CASE-SENSITIVE match.
		 */
		INPUT = m.replaceAll(REPLACE);
		System.out.println(INPUT);

		String input = "User clientId=23421. Some more text clientId=33432. This clientNum=100";

		Pattern pattern = Pattern.compile("(clientId=)(\\d+)");
		Matcher matcher = pattern.matcher(input);

		StringBuffer result = new StringBuffer();
		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println("Masking: " + matcher.group(2));
			/**
			 * public Matcher appendReplacement(StringBuffer s, String
			 * replacement)
			 * 
			 * This method performs the following actions:
			 * 
			 * 1. It reads characters from the input sequence, starting at the
			 * append position, and appends them to the given string buffer. It
			 * stops after reading the last character preceding the previous
			 * match, that is, the character at index start() - 1.
			 * 
			 * 2. It appends the given replacement string to the string buffer.
			 * 
			 * 3. It sets the append position of this matcher to the index of
			 * the last character matched, plus one, that is, to end().
			 */
			matcher.appendReplacement(result, matcher.group(1) + "***masked***");
		}
		System.out.println("appendReplacement() response:\n" + result);

		/**
		 * public StringBuffer appendTail(StringBuffer s)
		 * 
		 * This method reads characters from the input sequence, starting at the
		 * append position, and appends them to the given string buffer.
		 * 
		 * It is intended to be invoked after one or more invocations of the
		 * appendReplacement method in order to copy the remainder of the input
		 * sequence.
		 */
		matcher.appendTail(result);
		System.out.println("appendTail() response:\n" + result);
	}
}
