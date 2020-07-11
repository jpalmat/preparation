package streams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class StreamMain {

	public static void main(String[] args) {
		//create list
		List<String> list = Arrays.asList("test", "pizza", "ham");
		System.out.println(list);

		//pass string to List customizing the data
		String test = "this is a string";
		Function<String, Boolean> functTest = (x) -> x.equals(" ");//function get one parameter and return one
		List<String> listString = Arrays.stream(test.split("")).filter(y -> !functTest.apply(y))
				.map(x -> x.toUpperCase()).collect(Collectors.toList());
		System.out.println(listString);
		
		//build a stream
		Stream<String> streamBuild = Stream.<String>builder().add("a").add("b").build();
		streamBuild.forEach(x -> System.out.println(x));

		//supplier, no parameter and return the element
		Supplier<Stream> supplier = ()-> listString.stream();;
		System.out.println(supplier.get().collect(Collectors.toList()));

		//generate stream
		Supplier<String> supplier1 = ()-> {
			System.out.println("inside supplier");
			return "a";
		};
		Stream<String> streamGenerate = Stream.generate(supplier1);
		streamGenerate.limit(5).forEach(x -> System.out.println(x));

		//iterate
		Stream<Integer> streamIterate = Stream.iterate(10, n->n).limit(2);
		streamIterate.forEach(x -> System.out.println(x));

		IntStream intStream = IntStream.range(1, 6);
		//intStream.forEach(x -> System.out.println(x));
		System.out.println(intStream.boxed().collect(Collectors.toList()));

		//reduce
		IntStream intStream1 = IntStream.range(1, 6);
		System.out.println(intStream1.reduce((a,b)-> a+b));

		IntStream intStream2 = IntStream.range(1, 6);
		BiFunction<Integer, Integer, Integer> biFunctionTest = (a,b)-> {

			return a+b;
		};
		System.out.println(intStream2.reduce((a, b)->biFunctionTest.apply(a, b)));

		List<Integer> list2 = Arrays.asList(5, 6, 7);
		int res = list2.parallelStream().reduce(1, (s1, s2) -> {
			System.out.println("BiFunction "+s1 + " * " + s2);
			return s1 * s2;});
		System.out.println(res);

		//pass list to map https://www.baeldung.com/java-8-streams
		String string = "this is a is test a is";
		List<String> listString1 = Arrays.stream(string.split(" ")).collect(Collectors.toList());
		//{a=2, test=1, this=1, is=3}
		Map<String, Integer> collect = listString1.parallelStream().collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
		//{false=[is, a, is, a, is], true=[this, test]}
		Map<Boolean, List<String>> groups = listString1.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));
		//{1=[a, a], 2=[is, is, is], 4=[this, test]}
		Map<Integer, List<String>> groups1 = listString1.stream().collect(Collectors.groupingBy(s -> s.length()));

		System.out.println(collect);
		System.out.println(groups);
		System.out.println(groups1);

		//remove duplicates
		List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
		List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println(listWithoutDuplicates);

		//primitive array to List
		int[] intTest = {1, 2, 3};
		List<Integer> listIntToInteger = Arrays.stream(intTest).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}
}