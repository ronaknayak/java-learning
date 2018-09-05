package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author ronak.nayak
 * 
 * 
 * > How to process stream objects ?
 * 
 * Stream is an interface present in java.util.stream. Once we got the stream, 
 * by using that we can process objects of that collection.
 * 
 * We can process the objects in the following 2 phases:
 * 
 * 
 * 1) Configuration:
 * 
 * We can configure either by using filter mechanism or by using map mechanism.
 * 
 * a) Filtering:
 * 
 * If we want to filter elements from the collection based on some boolean 
 * condition then we should go for filtering.
 * 
 * We can configure a filter by using filter()method of Stream interface.
 * 
 * public Stream filter(Predicate<T> t)
 * 
 * Here, (Predicate<T > t) can be a boolean valued function/lambda expression
 * 
 * 
 * b) Mapping:
 * 
 * If we want to create a separate new object, for every object present in the 
 * collection based on our requirement then we should go for map() method of 
 * Stream interface.
 * 
 * public Stream map (Function f);
 * 
 * Here, (Function f) can be function/lambda expression
 * 
 * 
 * 
 * 2) Processing:
 * 
 * Once we performed configuration we can process objects by using several methods.
 * 
 */
public class Section_N {
	public static void main(String[] args) {
		
		List<String> lines = Arrays.asList("sunday", "monday", "tuesday", "friday", "saturday");

		/**
		 * collect():
		 * 
		 * This method collects the elements from the stream and adding to the specified
		 * to the collection indicated (specified) by argument.
		 */
		List<String> collectResult = lines.stream()
				.filter(Section_M.equality())
				.map(Section_M.changeCase())
				.collect(Collectors.toList());
		System.out.println("collect() Result:\t" + collectResult);
		
		/**
		 * count():
		 * 
		 * This method returns number of elements present in the stream. public long
		 * count()
		 */
		long countResult = lines.stream()
				.filter(day -> !"monday".equals(day) && !"tuesday".equals(day))
				.count();
		System.out.println("count() Result:\t" + countResult);
		
		/**
		 * sorted():
		 * 
		 * If we sort the elements present inside stream then we should go for sorted()
		 * method. The sorting can either default natural sorting order or customized
		 * sorting order specified by comparator.
		 * 
		 * sorted()- default natural sorting order sorted(Comparator c)-customized
		 * sorting order.
		 */
		List<String> sortedResult = lines.stream()
				.sorted( (day1, day2) -> -(day1.compareTo(day2)))
				.collect(Collectors.toList());
		System.out.println("sorted() Result:\t" + sortedResult);
		
		/**
		 * min():
		 * min(Comparator c) Returns minimum value according to specified comparator.
		 */
		String minResult = lines.stream()
				.min((day1, day2) -> -(day1.compareTo(day2))).get();
		System.out.println("min() Result:\t" + minResult);
		
		/**
		 * max():
		 * max(Comparator c) Returns maximum value according to specified comparator.
		 */
		String maxResult = lines.stream()
				.max((day1, day2) -> -(day1.compareTo(day2))).get();
		System.out.println("max() Result:\t" + maxResult);
		
		/**
		 * forEach():
		 * This method will not return anything.
		 * 
		 * This method will take lambda expression as argument and apply that lambda 
		 * expression for each element present in the stream.
		 */
		lines.stream().forEach(day -> System.out.println(day));
		
		/**
		 * toArray(): 
		 * We can use toArray() method to copy elements present in the stream into 
		 * specified array.
		 */
		String[] days = lines.stream().toArray(String[]::new);
		System.out.println("toArray() Result:");
		for (String day : days) {
			System.out.println(day);
		}
		
		/**
		 * Stream.of():
		 * We can also apply a stream for group of values and for arrays.
		 * 
		 * This method convert array into stream and thus we can apply all methods
		 * of the Stream interface on that.
		 */
		Double[] digits = { 10.0, 10.1, 10.2, 10.3 };
		Stream<Double> stream = Stream.of(digits);
		stream.forEach(digit -> System.out.print(digit + " "));
	}
}
