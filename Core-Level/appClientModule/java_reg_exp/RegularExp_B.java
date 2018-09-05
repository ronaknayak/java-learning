package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegEx Character classes:
 * ----------------------------------------------------------------------------
 * A character class matches a single character in the input text against
 * multiple allowed characters in the character class.
 * 
 * [abc] -> It would match with text if the text is having either one of
 * them(a,b or c) and only once.
 * 
 * [^abc] -> Any single character except a, b, or c (^ denote negation).
 * 
 * [a-z] -> any lower case alphabet from a to z
 * 
 * [A-Z] -> any capital case alphabet from A to Z
 * 
 * [a-zA-Z] -> any alphabet symbol
 * 
 * [a-d[m-p]]: a through d, or m through p: [a-dm-p] (union)
 * 
 * [a-z&&[def]]: Any one of them (d, e, or f) (intersection)
 * 
 * [a-z&&[^bc]]: a through z, except for b and c: [ad-z] (subtraction)
 * 
 * [a-z&&[^m-p]]: a through z, and not m through p: [a-lq-z] (subtraction)
 * 
 * [0-9] -> any digit from 0 to 9
 * 
 * [0-9a-zA-Z] -> any alphanumeric symbol
 * 
 * [^0-9a-zA-Z] -> except alphanumeric symbol (To get only special character)
 * 
 * 
 * 
 * 
 * 
 * PreDefined Character classes:
 * ----------------------------------------------------------------------
 * 
 * "." -> Any character (may or may not match line terminators)
 * 
 * "\s" -> space character
 * 
 * "\S" -> except space any character [^\s]
 * 
 * "\d" -> any digit from 0 to 9 [0-9]
 * 
 * "\D" -> except digit, any character [^0-9]
 * 
 * "\w" -> any word character [a-zA-Z0-9]
 * 
 * "\W" -> except word character(i.e.just special characters) [^a-zA-Z0-9]
 * 
 * "\b" -> A word boundary
 * 
 * "\B" -> A Non-word boundary
 * 
 * However; notice that in Java, you will need to “double escape” these
 * backslashes.
 * 
 * 
 * 
 * 
 * 
 * Meta-characters:
 * ----------------------------------------------------------------------------
 * 
 * Meta-characters are used to group, divide, and perform special operations in
 * patterns.
 * 
 * "\" -> Escape the next meta-character. (it becomes a normal/literal
 * character)
 * 
 * "^" -> Matches the beginning of a line.
 * 
 * "$" -> Match the end of the line (or before newline at the end)
 * 
 * "|" -> Alternation (‘or’ statement)
 * 
 * "()" -> Grouping i.e.group everything within the parenthesis as group
 * 
 * "[]" -> Custom character class
 * 
 * () and |, these two meta-characters are core parts of flexible regular
 * expressions. We can use a group (), with an ‘or’ meta-character in order to
 * specify a list of expressions to allow in our match.
 * 
 * 
 * 
 * 
 * Quantifiers:
 * ----------------------------------------------------------------------------
 * We can use Quantifiers to specify number of occurrence to match. i.e. To
 * identify the quantity of occurrence.
 * 
 * a -> exactly one 'a'
 * 
 * a+ -> occurs once or more times
 * 
 * a* -> any numbers of 'a' including zero
 * 
 * a? -> occurs once or not at all
 * 
 * X{n} -> X occurs n times only
 * 
 * X{n,} -> X occurs n or more times
 * 
 * X{y,z} -> X occurs at least y times but less than z times
 */

public class RegularExp_B {
	public static void main(String[] args) {

		/*
		 * returns true if the string matches exactly "tom" or "Tom"
		 */
		System.out.println(Pattern.matches("[Tt]om", "Tom"));

		/*
		 * Returns true if the string matches exactly "jin" or "Jin"
		 */
		System.out.println(Pattern.matches("[tT]im|[jJ]in", "jin"));

		/*
		 * returns true if the string contains "abc" at any place
		 */
		System.out.println(Pattern.matches(".*abc.*", "deabcpq"));

		// returns true if the string contains of three letters
		System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aPz"));
		System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "RN2"));
		System.out.println(Pattern.matches("[a-zA-Z][a-zA-Z][a-zA-Z]", "aPzZ"));

		System.out.println("UNION: " + Pattern.matches("[a-d[m-p]]", "o"));
		System.out.println("INTER-SECTION: "
				+ Pattern.matches("[a-z&&[d-g]]an", "ran"));
		System.out.println("SUBTRACTION: "
				+ Pattern.matches("[a-z&&[^m-z]]", "k"));

		// String search = "[abc]";
		// String search = "[^abc]";
		String search = "[a-z]";
		// String search = "[0-9]";
		// String search = "[a-zA-Z0-9]";
		// String search = "[^a-zA-Z0-9]";

		String inputStr = "a3b@k9z#";
		Pattern pattern = Pattern.compile(search);
		Matcher matcher = pattern.matcher(inputStr);
		while (matcher.find()) {
			System.out.println(matcher.start() + "-" + matcher.group());
		}

		System.out.println("********************************");

		System.out.println(Pattern.matches("\\d", "4"));
		// Since . represents any character
		System.out.println(Pattern.matches(".R", "2R"));

		// String find = "\\s";
		// compiler does not accept single slash because it's meant for escape
		// character. So, take it as \s symbol we have to add one more slash(\).
		// String find = "\\S";
		// String find = "\\d";
		// String find = "\\W";
		String find = ".";

		Pattern pat = Pattern.compile(find);
		Matcher match = pat.matcher("a3b @k9z#");

		while (match.find()) {
			System.out.println(match.start() + "----" + match.group());
		}

		System.out.println("**************Meta Characters****************");
		/*
		 * returns true if the string does not have a number at the beginning
		 */
		System.out.println(Pattern.matches("^[^\\d].*", "5abc"));
		System.out.println(Pattern.matches("^[^\\d].*", "a2cd"));
		pattern = Pattern.compile("^[^\\d].*Ron");
		matcher = pattern.matcher("a2cdRonak");
		while (matcher.find()) {
			System.out.println(matcher.start() + "----" + matcher.group());
		}

		// return true, Begins and ends with Hello
		System.out.println(Pattern.matches("^Hello$", "Hello"));

		// return false, does not begin with Hello
		System.out.println(Pattern.matches("^Hello$", "Namaste! Hello"));

		// return false, Does not end with Hello
		System.out.println(Pattern.matches("^Hello$", "Hello Namaste!"));

		System.out.println("***************Quantifiers*****************");
		// returns true if the string contains 0 or more non-digits
		System.out.println(Pattern.matches("\\D*", "abcde"));
		System.out.println(Pattern.matches("\\D*", "abcde123"));

		pattern = Pattern.compile("\\D*");
		matcher = pattern.matcher("abcde123");
		while (matcher.find()) {
			System.out.println(matcher.start() + "----" + matcher.group());
		}

		System.out.println(Pattern.matches("[a-z]{8}", "ronnayak"));
		// false (more than 6 char)
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6,20}", "ronak8699"));

		// String quantity = "a";
		String quantity = "a+";
		// String quantity = "a*";
		// String quantity = "a?";

		Pattern p = Pattern.compile(quantity);
		Matcher m = p.matcher("abaabaaab");

		while (m.find()) {
			System.out.println(m.start() + "----" + m.group());
		}

		/*
		 * \b used to match only whole word.
		 * 
		 * \B used to match word anywhere in the data string.
		 * 
		 * (ENTHUWARE)\\b means a word boundary. Therefore, \\bo will match any
		 * o immediately follows a word boundary, which means a TAB, a SPACE, a
		 * BEGINNING OF A LINE, an END OF A LINE, and SPECIAL CHARACTERS. In
		 * other words, a word boundary matches any character that is generally
		 * not used in making words. In this case, only the first o edges a word
		 * boundary; all others are within a word. Therefore, only the first o
		 * is a match and it is replaced with X.
		 * 
		 * \\B means a word boundary matches any character that is used in
		 * making words. If there is word boundary(such as a tab, a space, a
		 * beginning of a line, an end of a line, and special characters) that
		 * word will not be counted.
		 */
		String data1 = "Today, java is object oriented languagejava";

		String regex = "\\bjava\\b";

		Pattern pattern101 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher101 = pattern101.matcher(data1);
		while (matcher101.find()) {
			System.out.print("Start index: " + matcher101.start());
			System.out.print(" End index: " + matcher101.end() + " ");
			System.out.println(matcher101.group());
		}
		System.out.println("********************************");

		String data = "Searching in words : @java javap myjava myjavaprogram";

		String regEx = "\\Bjava|java\\B";

		Pattern pattern102 = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher102 = pattern102.matcher(data);
		while (matcher102.find()) {
			System.out.print("Start index: " + matcher102.start());
			System.out.print(" End index: " + matcher102.end() + " ");
			System.out.println(matcher102.group());
		}
	}
}
