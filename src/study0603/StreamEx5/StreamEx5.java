package study0603.StreamEx5;

import java.util.stream.Stream;

public class StreamEx5 {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "Stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};
		
//		Stream.of(strArr).forEach(System.out::println);

		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length()==0);
		System.out.println(noEmptyStr);
	}
}
