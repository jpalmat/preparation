package streams;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
	}

}
