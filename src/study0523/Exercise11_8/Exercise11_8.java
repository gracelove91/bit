package study0523.Exercise11_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Exercise11_8 {
	public static void calculateSchoolRank(List<Student> list) {
		Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

		int prevRank = -1; // 이전 전교등수.
		int prevTotal = -1; // 이전 총점.
		int length = list.size();

		/*
(2) 아래의 로직에 맞게 코드를 작성하시오.
1. 반복문을 이용해서 list에 저장된 Student객체를 하나씩 읽는다. 
1.1 총점(total)이 이전총점(prevTotal)과 같으면 이전 등수(prevRank)를 등수(schoolRank)로 한다. 
	//총점이 이전 사람의 총점과 같으면 등수가 똑같겠지? 그래서 이전 학생의 등수를 지금 학생의 등수로 설정.
	 * s.rank = prevRank
1.2 총점이 서로 다르면, 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
	//총점이 서로 다르면 다른 사람. 그러니까 현재 총점을 이전 사람의 총점에 설정. (prevTotal = s.total)
이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해야 한다. 
(실행결과참고)
1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
		 */

		for(int i = 0; i < length; i++) {
			Student s = list.get(i);	//스튜던트 객체 하나 얻는다.
	
			if(s.total == prevTotal) {	//현재 학생의 총점과 이전 학생의 총점이 같으면?
				prevRank = s.schoolRank;
				s.schoolRank = i;
			}else if(s.total != prevTotal) {
				prevTotal = s.total;
				s.schoolRank = i+1;
			}
			
			prevTotal = s.total;
			prevRank = s.schoolRank;
			
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 2, 1, 70, 90, 70));
		list.add(new Student("안자바", 2, 2, 60, 100, 80));
		list.add(new Student("홍길동", 1, 3, 100, 100, 100));
		list.add(new Student("남궁성", 1, 1, 90, 70, 80));
		list.add(new Student("김자바", 1, 2, 80, 80, 90));

		calculateSchoolRank(list);
		Iterator<Student> it = list.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;

	int total;
	int schoolRank;

	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

		total = kor + eng + math;
		
	}

	int getTotal() {
		return total;
	}

	float getAverage() {
		return (int) ((getTotal() / 3f) * 10 + 0.5) / 10f;
	}

	public String toString() {
		return name +
				"," + ban + 
				"," + no + 
				"," + kor + 
				"," + eng + 
				"," + math + 
				"," + getTotal() + 
				"," + getAverage() +
				"," + schoolRank;
	}

	@Override
	public int compareTo(Student o) {
		return o.total - this.total;
	}

} // class Student
