package javaPrep.streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class StreamMain {

	public static void main(String[] args) {
		//create list
//		List<String> list = Arrays.asList("test", "pizza", "ham");
//		System.out.println(list);
//
//		//pass string to List customizing the data
//		String test = "this is a string";
//		Function<String, Boolean> functTest = (x) -> x.equals(" ");//function get one parameter and return one
//		List<String> listString = Arrays.stream(test.split("")).filter(y -> !functTest.apply(y))
//				.map(x -> x.toUpperCase()).collect(Collectors.toList());
//		System.out.println(listString);
//
//		//build a stream
//		Stream<String> streamBuild = Stream.<String>builder().add("a").add("b").build();
//		streamBuild.forEach(x -> System.out.println(x));
//
//		//supplier, no parameter and return the element
//		Supplier<Stream> supplier = ()-> listString.stream();;
//		System.out.println(supplier.get().collect(Collectors.toList()));
//
//		//generate stream
//		Supplier<String> supplier1 = ()-> {
//			System.out.println("inside supplier");
//			return "a";
//		};
//		Stream<String> streamGenerate = Stream.generate(supplier1);
//		streamGenerate.limit(5).forEach(x -> System.out.println(x));
//
//		//iterate
//		Stream<Integer> streamIterate = Stream.iterate(10, n->n).limit(2);
//		streamIterate.forEach(x -> System.out.println(x));
//
//		IntStream intStream = IntStream.range(1, 6);
//		//intStream.forEach(x -> System.out.println(x));
//		System.out.println(intStream.boxed().collect(Collectors.toList()));
//
//		//reduce
//		IntStream intStream1 = IntStream.range(1, 6);
//		System.out.println(intStream1.reduce((a,b)-> a+b));
//
//		//sum using BiFunction
//		IntStream intStream2 = IntStream.range(1, 6);
//		BiFunction<Integer, Integer, Integer> biFunctionTest = (a,b)-> {
//
//			return a+b;
//		};
//		System.out.println(intStream2.reduce((a, b)->biFunctionTest.apply(a, b)));
//
//		//reduce
//		List<Integer> list2 = Arrays.asList(5, 6, 7);
//		int res = list2.parallelStream().reduce(1, (s1, s2) -> {
//			System.out.println("BiFunction "+s1 + " * " + s2);
//			return s1 * s2;});
//		System.out.println(res);
//
//		//pass list to map https://www.baeldung.com/java-8-streams
//
		String string = "this is a is test a is";
		List<String> listString1 = Arrays.stream(string.split(" ")).collect(Collectors.toList());

//		//{a=2, test=1, this=1, is=3}
		Map<String, Integer> collect = listString1.parallelStream().
		collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));



//		//{false=[is, a, is, a, is], true=[this, test]}
//		Map<Boolean, List<String>> groups = listString1.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));
//		//{1=[a, a], 2=[is, is, is], 4=[this, test]}
//		Map<Integer, List<String>> groups1 = listString1.stream().collect(Collectors.groupingBy(s -> s.length()));
//
////		System.out.println(collect);
////		System.out.println(groups);
////		System.out.println(groups1);
////
//		//remove duplicates
//		List<Integer> listWithDuplicates = Arrays.asList(1, 1, 2, 2, 3, 3);
//		List<Integer> listWithoutDuplicates = listWithDuplicates.stream()
//				.distinct()
//				.collect(Collectors.toList());
//		System.out.println(listWithoutDuplicates);
//
//		//primitive array to List
//		int[] intTest = {1, 2, 3};
//		List<Integer> listIntToInteger = Arrays.stream(intTest).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//
//		System.out.println(listIntToInteger.stream().reduce(Integer::min).orElse(-1));

		Persona person = new Persona("Jimmy", 3);
		Persona person1 = new Persona("Maryam", 4);

//		List<Persona> list = Arrays.asList(new Persona[]{new Persona("Jimmy", 3), new Persona("Maryam", 4)});
//
//		list.sort((p1, p2) -> p2.getAge().compareTo(p1.getAge()));
//
//		System.out.println(list);
//
//		Comparator<Persona> c = Comparator.comparing(Persona::getAge);

		List<Persona> list = Arrays.asList(new Persona[]{new Persona("Jimmyyyyyyyy", 3), new Persona("Maryam", 5)});

		List a = list.stream().sorted((Persona p1, Persona p2) -> p1.getNamePersona().length() - p2.getNamePersona().length()).collect(Collectors.toList());
		List b = list.stream().sorted(Comparator.comparing(Persona::getAge)).collect(Collectors.toList());

		System.out.println(a);
		System.out.println(b);

		//max age
		Persona maxAge = list.stream().max(Comparator.comparing(Persona::getAge)).orElseThrow();
		int max = list.stream().map(x -> x.getAge()).mapToInt(v -> v).max().orElse(-1);

		double aver = list.stream().map(x -> x.getAge()).mapToInt(v -> v).average().orElse(-1);
		OptionalDouble asv = list.stream().map(x -> x.getAge()).mapToInt(v -> v).average();
		System.out.println("a "+asv.getAsDouble());

		System.out.println(max);



		String a1 = "as ad ac";
	}
}

class Persona extends Thread{
	private String namePersona;
	private Integer age;

	public Persona(String namePersona, Integer age) {
		this.namePersona = namePersona;
		this.age = age;
	}

	public String getNamePersona() {
		return namePersona;
	}

	public void setNamePersona(String namePersona) {
		this.namePersona = namePersona;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Persona{" +
				"name='" + namePersona + '\'' +
				", age=" + age +
				'}';
	}
}