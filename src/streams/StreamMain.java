package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

	public static void main(String[] args) {
		//create list
		List<String> list = Arrays.asList("test", "pizza", "ham");
		System.out.println(list);

		//pass string to List customizing the data
		String test = "this is a string";
		List<String> listString = Arrays.stream(test.split("")).filter(y -> !y.equals(" ")).map(x -> x.toUpperCase()).collect(Collectors.toList());
		System.out.println(listString);
		
		
		
	}

}
