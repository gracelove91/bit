package study0603.StreamEx6;


import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collector.*;

public class StreamEx6 {
	public static void main(String[] args) {
		Student[] stuArr = {
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)
		};
		
		//학생 이름만 뽑아서 list에 저장.
		List<String> names = Stream.of(stuArr).map(Student::getName).collect(Collectors.toList());
		System.out.println(names);
		
		//스트림을 배열로 변환.
		Stream<Student> stuStrm = Stream.of(stuArr);
		Student[] stuArr2 = stuStrm.toArray(Student[]::new);
		
		//스트림을 Map<String,Student>로 변환. 학생이름이 키.
//		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(Student::getName, Function.identity()));
//		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(Student::getName, p -> p));
		Map<String, Student> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s -> s.getName(), p->p));
		
		for(String name : stuMap.keySet()) {
			System.out.println(name + " - "+stuMap.get(name));
		}
		
		long count = Stream.of(stuArr).collect(Collectors.counting());
		long totalScore = Stream.of(stuArr).collect(collector)
		
	}
	
}

class Student implements Comparable<Student>{
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	public String getName() {
		return name;
	}

	public int getBan() {
		return ban;
	}

	public int getTotalScore() {
		return totalScore;
	}

	@Override
	public int compareTo(Student o) {
		return o.totalScore - this.totalScore;
	}
}
