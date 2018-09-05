package java_localization;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * 4) DateFormat class:
 * ========================================================================
 * Various countries follows various conversion to represent Date. By using
 * DateFormat class we can format the Date according to a particular Locale.
 * 
 * In Denmark dates are written using the format DD-MM-YYYY, but in the US they
 * format dates using the format MM-DD-YYYY.
 * 
 * DateFormat class is an abstract class & present in java.text package.
 * 
 * How to get DateFormat class object:
 * 
 * > public static DateFormat getInstance();
 * 
 * The getInstance() method doesn't take any parameter. Get a default date/time
 * formatter that uses the SHORT style for both the date and the time.
 * 
 * > public static DateFormat getDateInstance();
 * 
 * Gets the date formatter with the default formatting style for the default
 * locale.
 * 
 * > public static DateFormat getDateInstance(int style);
 * 
 * Gets the date formatter with the given formatting style for the default
 * locale.
 * 
 * Here, style input is, DateFormat.FULL = 0; DateFormat.LONG = 1;
 * DateFormat.MEDIUM(DateFormat.DEFAULT) = 2; DateFormat.SHORT = 3;
 * 
 * Also, for specific Locale,
 * 
 * > public static DateFormat getDateInstance(int style, Locale locale);
 * 
 * Gets the date formatter with the given formatting style for the given locale.
 * 
 * 
 * Once we get the DateFormat class object we can format and parse date using
 * parse() method. This way, we can convert Java specific Date form to
 * designated Locale string form.
 * 
 * >> public String format(Date date);
 * 
 * Now, To convert Local specific Date form to Java specific Date format,
 * 
 * >> public Date parse(String s) throws ParseException
 * 
 * 
 * NOTE(ENTHUWARE):
 * 
 * Default Date-Time style is MEDIUM and most of the case default locale is US.
 * 
 * Note that DateFormat does not have getInstance(Locale locale) method but
 * NumberFormat class has.
 */

public class Local_C {
	public static void main(String[] args) {

		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL,
				Locale.US);
		String dateLocale = dateFormat.format(new Date());
		System.out
				.println("Locale specific Date in string form: " + dateLocale);
		try {
			Date date = dateFormat.parse(dateLocale);
			System.out.println("To convert into Java specific Date: " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Default form: "
				+ DateFormat.getInstance().format(new Date()));
		System.out.println("Full form: "
				+ DateFormat.getDateInstance(DateFormat.FULL, Locale.US)
						.format(new Date()));
		System.out.println("Long form: "
				+ DateFormat.getDateInstance(DateFormat.LONG, Locale.US)
						.format(new Date()));
		System.out.println("Medium form: "
				+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(
						new Date()));
		System.out.println("Default form: "
				+ DateFormat.getDateInstance().format(new Date()));
		System.out.println("Short form: "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(
						new Date()));

		/**
		 * How to get DateFormat object to represent Time.
		 * ------------------------------------------------------------------
		 * public static DateFormat getTimeInstance();
		 * 
		 * public static DateFormat getTimeInstance(int timeStyle);
		 * 
		 * public static DateFormat getDateTimeInstance(int timeStyle, Locale
		 * locale);
		 */
		System.out.println(DateFormat.getTimeInstance().format(new Date()));
		System.out.println(DateFormat.getTimeInstance(0).format(new Date()));
		System.out.println(DateFormat.getTimeInstance(1).format(new Date()));
		System.out.println(DateFormat.getTimeInstance(2).format(new Date()));
		System.out.println(DateFormat.getTimeInstance(3, Locale.US).format(
				new Date()));
		/**
		 * How to get DateFormat object to represent both Date & Time.
		 * ------------------------------------------------------------------
		 * public static DateFormat getDateTimeInstance();
		 * 
		 * public static DateFormat getDateTimeInstance(int dateStyle, int
		 * timeStyle);
		 * 
		 * public static DateFormat getDateTimeInstance(int dateStyle, int
		 * timeStyle, Locale locale);
		 */
		DateFormat dateForm = DateFormat.getDateTimeInstance();
		System.out.println(dateForm.format(new Date()));
		System.out.println(DateFormat.getDateTimeInstance(0, 0).format(
				new Date()));
		System.out.println(DateFormat.getDateTimeInstance(0, 0, Locale.UK)
				.format(new Date()));
	}
}
