package streams;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		//create list
		List<String> list = Arrays.asList("test", "pizza", "ham");
		System.out.println(list);

		//pass string to List customizing the data
		String test = "this is a string";
		List<String> listString = Arrays.stream(test.split("")).filter(y -> !y.equals(" "))
				.map(x -> x.toUpperCase()).collect(Collectors.toList());
		System.out.println(listString);
		
		//build a stream
		Stream<String> streamBuild = Stream.<String>builder().add("a").add("b").build();
		streamBuild.forEach(x -> System.out.println(x));

		//supplier, no parameter and return the element
		Supplier<Stream> supplier = ()-> listString.stream();;
		System.out.println(supplier.get().collect(Collectors.toList()));

		//generate stream
		Supplier<String> supplier1 = ()-> "a";
		Stream<String> streamGenerate = Stream.generate(supplier1);
		streamGenerate.limit(5).forEach(x -> System.out.println(x));


	}

}
