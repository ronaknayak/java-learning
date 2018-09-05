package java_localization;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * 2) ResourceBundle:
 * 
 * The ResourceBundle class is used to internationalize the messages. This class
 * programs handle multiple localeS at once be easily modified later to support
 * even more localeS.
 * 
 * ResourceBundle is an abstract class. So, we can't create object directly.
 * 
 * The hard-coded message is not considered good in terms of programming,
 * because it differs from one country to another. So we use the ResourceBundle
 * class to GLOBALIZE the massages.
 * 
 * The ResourceBundle class loads these informations from the properties file
 * that contains the messages.
 * 
 * Conventionally, the name of the properties file should be
 * filename_languagecode_countrycode for example, MyMessage_en_US.properties.
 * 
 * 
 * Now, ResourceBundle class methods:
 * 
 * > public static ResourceBundle getBundle(String baseName)
 * 
 * Returns the instance of the ResourceBundle class for the default locale.
 * 
 * > public static ResourceBundle getBundle(String baseName, Locale locale)
 * 
 * Returns the instance of the ResourceBundle class for the specified locale.
 * 
 * > public String getString(String key)
 * 
 * Returns the value for the corresponding key from this resource bundle.
 * 
 * > public Set<String> keySet()
 * 
 * Returns all the keys associated in specific message bundle.
 * 
 * 
 * Note(ENTHUWARE):
 * 
 * > Observe that when a resource bundle is not found for a given locale (e.g.
 * Locale("jp", "JP")), the default locale (e.g. Locale("fr", "CA")) is used to
 * load the resource bundle.  Every effort is made to load a resource bundle if
 * one is not found and there are several fall back options.
 * 
 * In absence of appmessages_fr_CA.properties, it will look for
 * appmessages_fr.properties. As a last resort, it will try to load a resource
 * bundle with no locale information i.e. appmessages.properties in this case.
 * An exception is thrown when even this resource bundle is not found.
 * 
 * > fileName.properties is the base file for the resource bundle. Therefore, it
 * will be loaded first. If the language and region specific file is also
 * present (e.g. _en_UK), it will also be loaded and the values in this file
 * will be superimposed on the values of the base file.
 * 
 * Remember that if there were another properties file named
 * fileName_en.properties also present, then that file would have been loaded
 * before fileName_en_UK.properties.
 */

public class Local_D {
	public static void main(String[] args) throws IOException {

		/**
		 * In order to provide strings in different languages, create a property
		 * file for each language, and suffix them with underscore (_) and then
		 * the language code.
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("MessageBundle",
				Locale.US);
		System.out.println("Message in " + Locale.getDefault() + " : "
				+ bundle.getString("greeting"));
		
		Object value = bundle.getObject("greeting");
		System.out.println(value);
		
		Set<String> keys = bundle.keySet();
		for (String key : keys) {
			System.out.println("Retrieving key - " + key);
		}

		// changing the default locale to INDONASIAN
		Locale.setDefault(new Locale("in", "ID"));

		bundle = ResourceBundle.getBundle("MessageBundle");
		System.out.println("Message in " + Locale.getDefault() + " : "
				+ bundle.getString("greeting"));
	}
}
