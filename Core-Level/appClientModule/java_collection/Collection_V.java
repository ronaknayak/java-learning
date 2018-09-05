package java_collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Properties(c):
 * 
 * In our program if any thing which changes frequently (Like, userName,
 * password, mail-id, mobile number etc.) never recommended to HARD CODE in Java
 * program.
 * 
 * Because if there is any change, to reflect that change ReCompilation, ReBuild
 * and ReDeployment of application are required. Even sometimes server restart
 * also requires which creates a big business impact to the client.
 * 
 * We can overcome this issue by properties file. Such type of variable things
 * we have to configure in the properties file. From that properties file we
 * have to read into Java program & we can use those properties.
 * 
 * The main advantage of this approach is if there is a change in properties
 * file, to reflect that change just ReDeployment is enough which won't create
 * any business impact to the client.
 * 
 * We can use Java Properties object to hold properties which are coming from
 * properties file.
 * 
 * 
 * Constructors:
 * 
 * Properties p = new Properties();
 * 
 * In case of normal Map (Like, HashMap, Hashtable etc.) key & value can be any
 * type. But, In the case of Properties key & value should be String type only.
 * 
 * Note:
 * 
 * We can give any extension to the properties file such as .txt, .xml, .company
 * etc. By convention, .properties would be good for readability purpose.
 */

public class Collection_V {
	public static void main(String[] args) throws IOException {

		Properties properties = new Properties();
		FileInputStream inputStream = new FileInputStream("db.properties");

		/**
		 * void load(InputStream i)
		 * 
		 * To load the properties from the properties file into Java Properties
		 * object.
		 */
		properties.load(inputStream);

		/**
		 * String getProperty(String key)
		 * 
		 * Returns the value associated with specified property.
		 */
		System.out.println(properties.getProperty("username"));

		/**
		 * String setProperty(String key, String value)
		 * 
		 * To set new property in a Properties file.
		 * 
		 * If a key is already there then replace old value with new value &
		 * returns old value.
		 * 
		 * void store(OutputStream o)
		 * 
		 * To update properties from the Properties object into properties file.
		 */
		properties.setProperty("url", "LocalHost:5432");
		FileOutputStream outputStream = new FileOutputStream("db.properties");
		properties.store(outputStream, "updated by user ronak.nayak");

		/**
		 * Enumeration propertyNames()
		 */
		Enumeration enumeration = properties.propertyNames();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			System.out.println("Property name: " + key);
		}
	}
}
