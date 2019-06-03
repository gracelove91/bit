package study0603.StreamEx2;

import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt") };
	
		Stream<File> fileStream = Stream.of(fileArr);
	
	
		//map으로 stream<File>을 stream<String>으로 변환.
		Stream<String> fileNameStream = fileStream.map( (file) -> file.getName());
//		Stream<String> fileNameStream2 = fileStream.map(File::getName);
		
		fileNameStream.forEach( (name) -> System.out.println(name) );
//		fileNameStream2.forEach(System.out::println);
		System.out.println();
		
		//forEach로 소비되었으니 다시생성해줘야한다.
		fileStream = Stream.of(fileArr);
		
		fileStream.map(File::getName)
				.filter(s -> s.indexOf('.') != -1)   //확장자가 있는것만 뽑아온다.
				.map(s -> s.substring(s.indexOf('.') + 1))	//파일 풀네임 중 확장자만 뽑아온다.
				.map(s -> s.toUpperCase())
				.distinct()
				.forEach((name) -> System.out.print(name + ", "));
		System.out.println();
		
	}


}
