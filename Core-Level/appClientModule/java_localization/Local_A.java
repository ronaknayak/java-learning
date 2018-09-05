package java_localization;

import java.util.Locale;

/**
 * Internationalization(I18N) and Localization(L10N):
 * =========================================================================
 * Various countries follows various conversions to represent Dates, Numbers,
 * Currency, Times, Postal Addresses etc.
 * 
 * Our application should generate Locale specific responses like for India
 * people the response should be in terms of RUPEES(RS.) & for the U.S. people
 * the response should be in terms of Dollar($).
 * 
 * The process of designing web application on such a way that which provides
 * support for various countries and various languages and various currencies
 * automatically without performing any change in the application, is called
 * Internationalization.
 * 
 * For example, If the request is coming from India then the response should be
 * in Indian people understandable form and if the request is coming from US the
 * response should be in US people understandable form.
 * 
 * 
 * Basically, your application should be able to handle international input,
 * output and operations. In other words, your application should be able to
 * adapt itself to input, output and operations specific to different locations
 * and user preferences.
 * 
 * Input is everything that your application receives from its users, either
 * directly through the user interface, sent to it via service calls (e.g. SOAP
 * or REST calls), imported from files etc.
 * 
 * Output is everything your application is showing or sending to its users.
 * 
 * 
 * We can implement I18N using following classes.
 * 
 * 1) Locale - The Locale class represents a language and a country or region. A
 * Locale may also represent a certain type of formatting - e.g. date or number
 * formatting.
 * 
 * 2) ResourceBundle - The ResourceBundle class can contain localized texts or
 * components (objects). You can obtain a ResourceBundle for a specific Locale,
 * and thus obtain texts or objects localized to that Locale.
 * 
 * 3) NumberFormat - The NumberFormat class is used to format numbers according
 * to a certain Locale.
 * 
 * 4) DateFormat - The DateFormat class is used to format dates according to a
 * specific Locale.
 * 
 * 5) SimpleDateFormat - The SimpleDateFormat class is used to parse and format
 * dates according to custom formatting patterns. These patterns are also Locale
 * sensitive.
 * 
 * 
 * 
 * 1) Locale:
 * -------------------------------------------------------------------------
 * Locale class is final class present in java.util package. It is direct child
 * class of Object class & It implements CloneablE & SerializablE interfaces.
 * 
 * Locale object represent a geographic location(country) or language or both.
 * For example, we can create Locale object to represent India. We can create
 * Locale object to represent English language.
 * 
 * 
 * Constructors:
 * 
 * Locale l = new Locale(String language); // To represent only language
 * 
 * Locale l = new Locale(String language, String country); // To represent
 * country and language both.
 * 
 * 
 * Once you have a Locale instance you can use it as input to other components
 * that use a Locale to localize their functions.
 * 
 * Locale locale = new Locale("pa", "IN");
 * 
 * ResourceBundle resourceBundle = ResourceBundle.getBundle("bundleName",
 * locale);
 */

public class Local_A {
	public static void main(String[] args) {

		// Locale class specific methods

		Locale locale = Locale.getDefault();
		System.out.println("default locale:	" + locale);

		System.out
				.println(locale.getCountry() + "-----" + locale.getLanguage());

		System.out.println(locale.getDisplayCountry() + "-----"
				+ locale.getDisplayLanguage());

		System.out.println(locale.getDisplayName());

		Locale loc = new Locale("pa", "IN");
		Locale.setDefault(loc);
		System.out.println(loc.getDisplayCountry() + "-----"
				+ loc.getDisplayLanguage());

		/*
		 * Locale class already defines several constants to represent some
		 * standard Locale. We can use these constants directly instead of
		 * creating out Locale object.
		 * 
		 * We use one of these constants simply by referring to it.
		 */
		Locale locObj = Locale.JAPAN;
		System.out.println("Locale object by constants for country:"
				+ locObj.getDisplayCountry() + "::::"
				+ locObj.getDisplayLanguage());
		Locale locaObj = Locale.KOREAN;
		System.out.println("Locale object by constants for language:"
				+ locaObj.getDisplayLanguage());

		/*
		 * From Java 7,
		 * 
		 * You can use the Locale.Builder() method to build a Locale instance.
		 * 
		 * The factory method Locale.forLanguageTag() can also be used to create
		 * a Locale instance.
		 */
		Locale cLocale = new Locale.Builder().setLanguage("pa").setRegion("US")
				.build();
		System.out.println("Java7 - " + cLocale.getDisplayName());

		Locale aLocale = Locale.forLanguageTag("pa");
		System.out.println("Java7 - " + aLocale.getDisplayName());

		System.out.println("---------All ISO Countries--------");
		String[] countries = Locale.getISOCountries();
		for (String country : countries) {
			System.out.print(country + "\t");
		}
		System.out.println();
		
		System.out.println("---------All ISO Languages--------");
		String[] langauges = Locale.getISOLanguages();
		for (String language : langauges) {
			System.out.print(language + "\t");
		}
		System.out.println();

		Locale[] locales = Locale.getAvailableLocales();
		for (Locale l : locales) {
			System.out.println(l.getDisplayCountry() + ":"
					+ l.getDisplayLanguage());
		}
	}
}
