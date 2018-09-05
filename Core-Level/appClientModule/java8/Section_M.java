package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * STREAMS:
 * ****************************************************************************
 * 
 * > What is the differences between Java.util.streams and Java.io streams ?
 * 
 * java.util streams meant for processing objects from the collection. i.e. it 
 * represents a stream of objects from the collection. 
 * 
 * But Java.io streams meant for processing binary and character data with respect 
 * to file. i.e it represents stream of binary data or character data from the 
 * file. Hence, Java.io streams and Java.util streams both are different.
 * 
 * 
 * > What is the difference between collection and stream ?
 * 
 * If we want to represent a group of individual objects as a single entity then 
 * We should go for collection.
 * 
 * If we want to process a group of objects from the collection then we should 
 * go for streams. i.e. To perform bulk operations on objects in collection.
 * 
 * 
 * We can create a stream object to the collection by using stream() method 
 * of Collection interface. stream() method is a default method added to the 
 * Collection in 1.8 version.
 * 
 * SYNTAX: default Stream stream()
 * 
 * 
 */
public class Section_M {
	public static void main(String[] args) {
		
		beforeJava8();
		
		afterJava8();
	}
	
	private static void afterJava8() {
		List<String> lines = Arrays.asList("sunday", "monday", "tuesday");

		List<String> result = lines.stream()
				.filter(equality())
				.map(changeCase())
				.collect(Collectors.toList());
		
		System.out.println("afterJava8()\t" + result);
	}
	
	private static void beforeJava8() {
		List<String> lines = Arrays.asList("sunday", "monday", "tuesday");
		List<String> result = getFilterOutput(lines, "sunday");
		System.out.println("beforeJava8()\t" + result);
	}

	private static List<String> getFilterOutput(List<String> lines, String filter) {
		List<String> result = new ArrayList<>();
		for (String line : lines) {
			if (!"sunday".equals(line)) {
				result.add(line);
			}
		}
		return result;
	}
	
	public static Predicate<String> equality() {
		return str -> !"sunday".equals(str);
	}
	
	public static Function<String, String> changeCase() {
		return str -> str.toUpperCase();
	}
}

