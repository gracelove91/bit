package study0603.StreamEx5;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "Stream",
				"OptionalDouble", "IntStream", "count", "sum"
				,""
		};
		
//		Stream.of(strArr).forEach(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length()==0);
//		System.out.println(noEmptyStr);
		Optional<String> sWord = Stream.of(strArr)
									.filter(s -> s.charAt(0) == 's' || s.charAt(0) == 'S')
									.findFirst();
		System.out.println("noEmptyStr : " + noEmptyStr);
		System.out.println("sWord : " + sWord.get());	//Stream 
		
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
//		intStream4.forEach(System.out::println);
		
		int count = intStream1.reduce(0, (a,b) -> {return a+1;});
		System.out.println("count : "+count);
		int sum = intStream2.reduce(0, (a,b) -> a+b);
		System.out.println("sum : " +sum);
		
		OptionalInt max =intStream3.reduce(Integer::max);
		OptionalInt min = intStream4.reduce(Integer::min);
		
		System.out.println("max : "+max.getAsInt());
		System.out.println("min : "+min.getAsInt());
		
	}
}
