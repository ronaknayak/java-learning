package java_localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Java Internationalization: TimeZones
 * ---------------------------------------------------------------------------
 * When users of a system, e.g. a web application, have different time zones, it
 * can be challenging to manage dates and time in the system in manner that
 * looks consistent to all users.
 * 
 * UTC: UTC is short for Coordinated Universal Time (Universal Time Coordinated
 * ?). UTC is the time in the UK time zone.
 * 
 * Time Zones: All time zones are calculated as offsets to UTC time. For
 * instance, the time zone in Denmark is UTC + 1 meaning UTC time plus one hour
 * & for India it's UTC + 5:30.
 * 
 * Converting Time Zones:
 * 
 * When a user types in a date and time, they usually do so in their own time
 * zone. If a user in another time zone need to look at that date and time, that
 * user would often like to see that date and time converted to his own time
 * zone.
 * 
 * 
 * 
 * Java.util.Calendar:
 * 
 * Date is a simpler class and is mainly there for backward compatibility
 * reasons. If you need to set particular dates or do date arithmetic, use a
 * Calendar. Calendars also handle localization. Since, the previous date
 * manipulation functions of Date have been deprecated.
 * 
 * The Calendar class is an abstract class that provides methods for converting
 * between a specific instant in time and a set of calendar fields such as YEAR,
 * MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar
 * fields, such as getting the date of the next week.
 */

public class Local_F {
	public static void main(String[] args) {

		// doTimezoneAction();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
		Calendar calendar = Calendar.getInstance();

		System.out.println(calendar.getTimeZone());
		System.out.println(sdf.format(calendar.getTime()));

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		int hour = calendar.get(Calendar.HOUR);
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);

		System.out.println("\nUpdate Calendar\n");

		/**
		 * public void set(int field, int value)
		 * 
		 * The Calendar class has a corresponding set() method so that you can
		 * set these fields too. Sets the given calendar field to the given
		 * value.
		 */
		calendar.set(Calendar.YEAR, 2015);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 2);
		System.out.println(calendar.getTime());

		/**
		 * Updating Time Period (Months and days) to a Date
		 * 
		 * Adds or subtracts the specified amount of time to the given calendar
		 * field, based on the calendar's rules.
		 */
		calendar.add(Calendar.YEAR, 4);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println("After adding time: " + calendar.getTime());
		calendar.add(Calendar.HOUR, -12);
		System.out.println("After subtracting time: " + calendar.getTime());

		/**
		 * Calendar object automatically took care of adjusting the year when an
		 * overflow occurred. However, there might be instances where we don’t
		 * want this to happen.
		 * 
		 * public void roll(int field, int amount)
		 * 
		 * Adds the specified (signed) amount to the specified calendar field
		 * without changing larger fields. A negative amount means to roll down.
		 */
		Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.YEAR, 1);
		System.out.println("Time rolling up the year: "
				+ sdf.format(cal.getTime()));
		cal.roll(Calendar.MONTH, false);
		System.out.println("Time rolling down the month: "
				+ sdf.format(cal.getTime()));

		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		System.out.println("Occurs after: " + c.compareTo(cal));
		System.out.println("Occurs before: " + cal.compareTo(c));
	}

	static void doTimezoneAction() {
		/**
		 * The java.util.Calendar class is abstract, meaning you cannot
		 * instantiate it. The reason is that there are more than one calendar
		 * in the world.
		 * 
		 * Java only comes with a Gregorian calendar implementation, the
		 * java.util.GregorianCalendar class.
		 */
		Calendar calendar = new GregorianCalendar();

		calendar.setTimeZone(TimeZone.getTimeZone("ETC/UTC"));

		calendar.set(Calendar.HOUR_OF_DAY, 12);
		System.out.println(calendar.getTimeZone().getDisplayName());
		System.out.println("UTC: " + calendar.get(Calendar.HOUR_OF_DAY));

		calendar.setTimeZone(TimeZone.getTimeZone("IST"));
		System.out.println(calendar.getTimeZone().getDisplayName());
		System.out.println("IST: " + calendar.get(Calendar.HOUR_OF_DAY));
	}
}
