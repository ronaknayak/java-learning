package java_localization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * 3) NumberFormat class:
 * 
 * Various countries follows various styles to represent number by using
 * NumberFormat class. So that, we can format number according to a particular
 * Locale.
 * 
 * Different countries have different standards for how they format numbers.
 * 
 * NumberFormat is a final class present in java.text package and it is an
 * abstract class. Hence, we can't create NumberFormat class object directly.
 * 
 * 
 * So, How to get object of NumberFormat class:
 * 
 * public static NumberFormat getInstance()
 * 
 * public static NumberFormat getNumberInstance()
 * 
 * public static NumberFormat getCurrencyInstance()
 * 
 * public static NumberFormat getPercentInstance()
 * 
 * 
 * Also, For specific Locale we can set and above methods are same for it but we
 * have to pass the corresponding Locale Object as argument. For instance,
 * 
 * > public static NumberFormat getInstance(Locale l)
 * 
 * 
 * Once we get NumberFormat class object we can format and parse numbers by
 * using the NumberFormat class methods. Using format() method, we can convert
 * Java specific number form to Locale specific string form.
 * 
 * > public String format(double dJava)
 * 
 * > public String format(long lJava)
 * 
 * Now, to convert Local specific number form to Java specific String form i.e.
 * reverse operation we can use NumberFormat class parse() method.
 * 
 * If we pass value other than Number it'll throws RE: IllegalArgumentException.
 * 
 * > public Number parse(String localSpecificNumber) throws ParseException
 * 
 */

public class Local_B {
	public static void main(String[] args) {

		double number = 123.465987;
		// To convert in default format
		NumberFormat nf = NumberFormat.getInstance();
		String formater = nf.format(number);
		System.out.println(formater);

		try {
			Number localSpecific = nf.parse(formater);
			System.out.println("Locale specific conversion: " + localSpecific);
		} catch (ParseException e) {
		}

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		System.out.println("Default currency conversion: "
				+ numberFormat.format(number));

		Locale locale = new Locale("pa", "IN");
		numberFormat = NumberFormat.getCurrencyInstance(locale);
		System.out.println("Currency conversion: "
				+ numberFormat.format(number));

		NumberFormat numForm = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("US specific Notation: " + numForm.format(25));

		NumberFormat currenceForm = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println("UK specific Notation: " + currenceForm.format(200));

		NumberFormat percentageFormat = NumberFormat
				.getPercentInstance(new Locale("in", "IN"));
		String percentage = percentageFormat.format(99.999);
		System.out.println("Percentage format:" + percentage);

		/**
		 * You can set both the minimum and maximum number of digits to use both
		 * for the integer part and the fractional part of the number.
		 */
		nf.setMaximumFractionDigits(2);
		System.out.println(nf.format(123.456));

		nf.setMinimumFractionDigits(2);
		System.out.println(nf.format(123.456));
		System.out.println(nf.format(123.4));

		nf.setMaximumIntegerDigits(2);
		System.out.println(nf.format(123.456));

		nf.setMinimumIntegerDigits(4);
		System.out.println(nf.format(123.456));
	}
}
