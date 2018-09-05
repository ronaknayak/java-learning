package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular Expressions:
 * ``````````````````````````````````````````````````````````````````````````
 * Regular expressions are used for defining String patterns that can be used
 * for searching, manipulating and editing a text. These expressions are also
 * known as Regex (short form of Regular expressions).
 * 
 * If we want to represent a group of strings according to a particular pattern
 * then we should go for regular expression.
 * 
 * Every string is a regular expression. For example, the string, “I lost my
 * wallet”, is a regular expression that will match the text, “I lost my
 * wallet”, and will ignore everything else. What if we want to be able to find
 * more things that we lost? We can replace wallet with a character class
 * expression that will match any word.
 * 
 * e.g. We can write a regular expression to represent all valid mobile numbers,
 * We can write a regular expression to represent all mail id.
 * 
 * Validation Frameworks internally developed based on regular expression.
 * 
 * 
 * Pattern class:
 * ----------------------------------------------------------------------------
 * A Pattern object is a compiled version of regular expression. i.e. It's a
 * Java equivalent object of a Pattern. So, basically it's used for defining
 * patterns.
 * 
 * We can create a Pattern object by using compile method of a Pattern class.
 * 
 * public static Pattern compile(String regEx)
 * 
 * 
 * Matcher class:
 * ----------------------------------------------------------------------------
 * It implements MatchResult interface. It is a Regex engine i.e. We can use
 * matcher object to check the given Pattern in the target string. So, basically
 * it's used for to perform match operations on text using patterns.
 * 
 * We can create the Matcher object by using matcher() method of a Pattern
 * class.
 * 
 * public Matcher matcher(String target)
 * 
 * Note: Pattern & Matcher classes present in java.util.regex package &
 * introduced in 1.4 version.
 */

public class RegularExp_A {

	public static void main(String[] args) {

		simpleWayToSearchString();

		usingCompileToSearchString();

		// Important methods
		/**
		 * boolean matches()
		 * 
		 * It matches the regular expression against the whole text passed to
		 * the Pattern.matcher() method while creating Matcher instance.
		 * 
		 * --------------------------------
		 * 
		 * lookingAt()
		 * 
		 * Similar to matches() method except that it matches the regular
		 * expression only against the beginning of the text, while matches()
		 * method search in the whole text.
		 */
		String mainStr = "some text";
		String patternStr = ".*text.*";
		Pattern patt = Pattern.compile(patternStr);
		Matcher match = patt.matcher(mainStr);
		
		boolean isMatchFound = match.matches();
		System.out.println("matches(): " + isMatchFound);

		patt = Pattern.compile("text");
		match = patt.matcher("some text");
		System.out.println("lookingAt(): " + match.lookingAt());

		int occurance = 0;
		Pattern pattern = Pattern.compile("aba");
		Matcher matcher = pattern.matcher("abababab");

		/**
		 * String pattern()
		 * 
		 * Returns the regular expression from which this pattern was compiled.
		 */
		System.out.println("Regex pattern: " + pattern.pattern());

		/**
		 * boolean find()
		 * 
		 * It attempts to find next match & If it's available returns true.
		 * Otherwise, returns false. Mainly used when we are searching for
		 * multiple occurrences.
		 * 
		 * (ENTHUWARE) In this case, once the characters in the input string are
		 * consumed in a match, they cannot be reused. The first location where
		 * aba occurs is 0. It consumes the first 3 characters and so the second
		 * occurrence of aba at location 2 will not be reported. The next
		 * occurrence of aba is at location 4.
		 */
		while (matcher.find()) {

			/**
			 * start() and end(): Both these methods are generally used along
			 * with the find() method.
			 * 
			 * int start()
			 * 
			 * returns start index of the match starting with 0.
			 * 
			 * int end()
			 * 
			 * returns end + 1 index of the match.
			 * ----------------------------------------------------------------
			 * String group()
			 * 
			 * returns the matched pattern.
			 */
			System.out.println(matcher.start() + "----" + matcher.end()
					+ "----" + matcher.group());
			occurance++;
		}
		System.out.println("Total : " + occurance);

		/**
		 * ENTHUWARE:
		 * 
		 * * is a GREEDY OPERATOR for 0 and more. It will try to match as many
		 * of . (dot means any character) as it can before terminating with L.
		 */
		pattern = Pattern.compile("C.*L");
		matcher = pattern.matcher("CooLooLCuuLooC");
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	/*
	 * This is one of simplest and easiest way of searching a String in a text
	 * using Regex. (The expression .* is used for zero and more characters)
	 * 
	 * Limitations: This way we can search a single occurrence of a pattern in a
	 * text. For matching multiple occurrences you should use the
	 * Pattern.compile() method
	 */
	public static void simpleWayToSearchString() {
		String content = "This is Ronak " + "from Cisco-India.";

		String pattern = ".*Cisco.*";

		boolean isMatch = Pattern.matches(pattern, content);
		System.out.println("Is the text contains 'Cisco'? " + isMatch);

		// The . (dot) represents a single character & it can be any
		System.out.println(Pattern.matches(".s", "as"));// true (2nd char is s)
		System.out.println(Pattern.matches(".s", "mk"));// false (2nd char is
														// not s)
		System.out.println(Pattern.matches(".s", "mst"));// false (has more than
															// 2 char
		System.out.println(Pattern.matches("..s", "mas"));// true (3rd char is
															// s)

		System.out.println(Pattern.matches(".m.", "sma"));// true (2nd char is
															// m)
	}

	/*
	 * In the above example we searched a string “Cisco” in the text, that is a
	 * case sensitive search, however if you want to do a CASE INSENSITIVE
	 * search or want to do search multiple occurrences then you may need to
	 * first compile the pattern using Pattern.compile() before searching it in
	 * text.
	 */
	public static void usingCompileToSearchString() {
		String content = "This is Ronak " + "from Cisco-India";

		String patternStr = ".*cisco.*";
		// Pattern pattern = Pattern.compile(patternStr);
		Pattern pattern = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		int iOccurances = 0;
		while (matcher.find()) {
			iOccurances++;
		}
		System.out.println("Number of occurances: " + iOccurances);
	}
}
