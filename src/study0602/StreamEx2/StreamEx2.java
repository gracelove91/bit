package study0602.StreamEx2;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex2.txt") };
		
		Stream<File> fileStream = Stream.of(fileArr);
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		
		fileStream = Arrays.stream(fileArr);
		
		fileStream.map(File::getName)
			.filter( (s) -> s.indexOf('.') != -1)
			.map(s -> s.substring(s.indexOf('.')+1))
			.map(String::toUpperCase)
			.distinct()
			.map( s -> s+", ")
			.forEach(System.out::print);
		
		System.out.println();
	
	}
}
