package study0602.StreamEx1;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
					new Student("이자바", 3, 300),
					new Student("김자", 1, 200),
					new Student("안자", 2, 100),
					new Student("박자바", 2, 150),
					new Student("소자바", 1, 200),
					new Student("나자바", 3, 290),
					new Student("메롱메", 3, 180)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan)//반별정렬.
				.thenComparing(Comparator.naturalOrder()))
				.forEach(System.out::println);
								
	}
}

class Student implements Comparable<Student>{
	String name;
	int ban, totalScore;
	public Student(String name, int ban, int totalScore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	@Override
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	String getName() {return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore; }
	
	@Override
	public int compareTo(Student o) {
		return o.totalScore - this.totalScore;
	}
	
	
}
