package java_localization;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * SimpleDateFormat:
 * --------------------------------------------------------------------------
 * The java.text.SimpleDateFormat class is used to both parse and format dates
 * according to a formatting pattern.
 * 
 * Constructors:
 * 
 * > SimpleDateFormat()
 * 
 * The simplest constructor which creates a java.text.SimpleDateFormat with a
 * default pattern of date and a default locale.
 * 
 * > SimpleDateFormat(String pattern)
 * 
 * The constructor which creates a java.text.SimpleDateFormat with a given
 * pattern and a default locale.
 * 
 * > SimpleDateFormat(String pattern, Locale locale)
 * 
 * Constructs a java.text.SimpleDateFormat with the given pattern and a specific
 * locale.
 * 
 * > SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols)
 * 
 * To customize local date-time formatting data, such as the names of the
 * months, the names of the days of the week, and the time zone data.
 * 
 * 
 * 
 * 
 * Date and Time Patterns:
 * -----------------------------------------------------------------------------
 * 
 * y - Year (e.g. 12 or 2012) - Use either yy or yyyy
 * 
 * M - Month in year - Number of M's determine length of format (e.g. MM, MMM or
 * MMMMM)
 * 
 * d - Day in month - Number of d's determine length of format (e.g. d or dd)
 * 
 * h - Hour of day, 1-12 (AM / PM) (normally hh)
 * 
 * H - Hour of day, 0-23 (normally HH)
 * 
 * m - Minute in hour, 0-59 (normally mm)
 * 
 * s - Second in minute, 0-59 (normally ss)
 * 
 * S - Millisecond in second, 0-999 (normally SSS)
 * 
 * E - Day in week (e.g Monday, Tuesday etc.)
 * 
 * D - Day in year (1-366)
 * 
 * F - Day of week in month (e.g. 1st Thursday of December)
 * 
 * w - Week in year (1-53)
 * 
 * W - Week in month (0-5)
 * 
 * a - AM / PM marker
 * 
 * k - Hour in day (1-24, unlike HH's 0-23)
 * 
 * K - Hour in day, AM / PM (0-11)
 * 
 * z - General Time Zone
 * 
 * ' - Escape for text delimiter
 * 
 * 
 * The default pattern, which shows the date in the form of month/day/year and
 * the time using the 12-hour clock.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * Remember that if the number of pattern letters is 4 or more, the full form is
 * used; otherwise a short or abbreviated form is used if available. For
 * parsing, both forms are accepted, independent of the number of pattern
 * letters.
 */

public class Local_E {
	public static void main(String[] args) {

		// To create SimpleDateFormat instance
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

		// formating date
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		try {
			// parsing date
			Date lDate = simpleDateFormat.parse(date);
			System.out.println("Default pattern: " + lDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		pattetnInstances();
		//customizeDateTime();
	}

	static void pattetnInstances() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("MMM-dd-yyyy");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("MMMM-dd-yyyy");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.S a");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("E, dd MMMM yyyy HH:mm:ss");
		System.out.println(simpleDateFormat.format(new Date()));

		System.out.println("\n***************TimeZone**************\n");

		simpleDateFormat = new SimpleDateFormat("EEEE, MMMM yyyy HH:mm:ss Z");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("EEEE, MMMM yyyy HH:mm:ss z");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("EEEE, MMMM yyyy HH:mm:ss zzzz");
		System.out.println(simpleDateFormat.format(new Date()));

		simpleDateFormat = new SimpleDateFormat("k, dd/MM/yyyy HH:mm:ss");
		String hourInDay = simpleDateFormat.format(new Date());
		System.out.println("Hour in day: " + hourInDay);

		simpleDateFormat = new SimpleDateFormat("K, dd/MM/yyyy HH:mm:ss");
		String hourInTheDay = simpleDateFormat.format(new Date());
		System.out.println("Hour in day: " + hourInTheDay);

		simpleDateFormat = new SimpleDateFormat("D, dd/MM/yyyy HH:mm:ss");
		String dayOfYear = simpleDateFormat.format(new Date());
		System.out.println("Day of year: " + dayOfYear);

		simpleDateFormat = new SimpleDateFormat("F'st' E, dd/MM/yyyy HH:mm:ss");
		String dayOfWeekInMonth = simpleDateFormat.format(new Date());
		System.out.println("Day of week in month: " + dayOfWeekInMonth);

		simpleDateFormat = new SimpleDateFormat("w'th week in' yyyy");
		String weekInYear = simpleDateFormat.format(new Date());
		System.out.println("Week in year:" + weekInYear);

		simpleDateFormat = new SimpleDateFormat("W'st week in' MMMM");
		String weekInMonth = simpleDateFormat.format(new Date());
		System.out.println("Week in month:" + weekInMonth);
	}

	/**
	 * It is possible to customize the date symbols used in the formatted
	 * output, for a specific Locale. You do so using a
	 * java.text.DateFormatSymbols instance.
	 * 
	 * Constructors:
	 * 
	 * DateFormatSymbols format = new DateFormatSymbols();
	 * 
	 * DateFormatSymbols format = new DateFormatSymbols(Locale locale);
	 */
	static void customizeDateTime() {

		Locale locale = new Locale("in", "IN");

		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);

		dateFormatSymbols.setWeekdays(new String[] { "Unused", "Sad Sunday",
				"Manic Monday", "Thriving Tuesday", "Wet Wednesday",
				"Total Thursday", "Fat Friday", "Super Saturday", });

		dateFormatSymbols.setAmPmStrings(new String[] { "First-half",
				"Second-half" });

		String pattern = "EEEE MMMMM yyyy hh:mm:ss a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,
				dateFormatSymbols);

		String date = simpleDateFormat.format(new Date());
		System.out.println("Customization:\n" + date);
	}
}
