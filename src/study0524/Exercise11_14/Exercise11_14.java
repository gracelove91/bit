package study0524.Exercise11_14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author govlmo91 [11-14] 다음은 성적처리 프로그램의 일부이다. Scanner클래스를 이용해서 화면으로부터 데이터를
 *         입력하고 보여주는 기능을 완성하시오.
 */
public class Exercise11_14 {
	static ArrayList<Student> record = new ArrayList<>(); // 성적데이터를 저장할 공간.
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			switch (displayMenu()) {
			case 1:
				inputRecord();
				break;
			case 2:
				displayRecord();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다. ");
				System.exit(0);
			}
		}
	}

	static int displayMenu() {
		System.out.println("*****************************************");
		System.out.println("**			성적관리프로그램 		   **");
		System.out.println("*****************************************");
		System.out.println();
		System.out.println("1.학생성적 입력. ");
		System.out.println();
		System.out.println("2.학생성적 보기. ");
		System.out.println();
		System.out.println("3.프로그램 종료. ");
		System.out.println();
		System.out.print("원하는 메뉴를 선택하세요. ( 1-3 ) : ");

		int menu = 0;
		/**
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1~3사이의 값이어야 한다.
		 * 
		 * 2. 1~3사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고 다시 입력받는다.(유효한 값을 입력받을 때까지 반복해서
		 * 입력받는다.)
		 */

		while (true) {
			menu = s.nextInt();
			if (menu < 0 || menu > 3) {
				System.out.println("잘못된 값입니다. 1-3 의 값을 입력해주세요.");
				continue;
			} else {
				break;
			}
		}

		return menu;
	}// end of static int displayMenu()

	// 데이터를 입력받는 메서드.
	static void inputRecord() {
		System.out.println("1.학생성적 입력하기.");
		System.out.println("이름, 반, 번호, 국어성적, 영어성적, 수학성적 의 순으로 공백없이 입력하세요. ");
		while (true) {
			System.out.print(">>");
			s = new Scanner(System.in);	//자꾸 빈값 들어가서 새로 만들었음.
			String record = s.nextLine();
			if (record.trim().equalsIgnoreCase("q")) {
				break;
			}

			String[] studentInfo = record.trim().split(",");
//			System.out.println(studentInfo.length);
			
			if (studentInfo.length != 6) {
				System.out.println("입력오류입니다. 다시 입력해주세요.");
				continue;
			}

			try {
				String name = studentInfo[0].trim();
				int ban = Integer.parseInt(studentInfo[1].trim());
				int no = Integer.parseInt(studentInfo[2].trim());
				int kor = Integer.parseInt(studentInfo[3].trim());
				int eng = Integer.parseInt(studentInfo[4].trim());
				int math = Integer.parseInt(studentInfo[5].trim());

				Student s = new Student(name, ban, no, kor, eng, math);
				Exercise11_14.record.add(s);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("입력오류입니다. 다시 입력해주세요. ");
				continue;
			}

			// public Student(String name, int ban, int no, int kor, int eng, int math) {

			/*
			 * 1. Scanner를 이용해서 화면으로 부터 데이터를 입력받는다.(','를 구분자로) 2. 입력받은 값이 q 또는 Q이면 메서드를
			 * 종료하고, 그렇지 않으면 입력받은 값으로 Student인스턴스를 생성하고 record에 추가한다. 3. 입력받은 데이터에서 예외가
			 * 발생하면, "입력오류입니다."를 보여주고 다시 입력받는다. 4. q 또는 Q가 입력될 때까지 2~3의 작업을 반복한다.
			 */

		} // end of while.
	}// end of inputRecord

	// 데이터목록을 보여주는 메서드.
	static void displayRecord() {
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		int total = 0;

		int length = record.size();

		if (length > 0) {
			System.out.println();
			System.out.println("이름 반 번호 국어 영어 수학 총점 평균 전교등수 반등수");
			System.out.println("=====================================================");

			for (int i = 0; i < length; i++) {
				Student student = record.get(i);
				System.out.println(student);
				korTotal += student.kor;
				mathTotal += student.math;
				engTotal += student.eng;
				
				total += student.total;
			}
			
			System.out.println("======================================================");
			System.out.println("총점 : "+korTotal+" "+engTotal+ " "+mathTotal+ " "+ total);
			System.out.println();
		}else {
			System.out.println("======================================================");
			System.out.println("데이터가 없습니다.");
			System.out.println("======================================================");
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
	int classRank;

	public Student(String name, int ban, int no, int kor, int eng, int math) {
		super();
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

	@Override
	public int compareTo(Student o) {
		return o.total - this.total;
	}

	@Override
	public String toString() {
		return name + " " + ban + " " + no + " " + kor + " " + eng + " "
				+ math + " " + total + " " + schoolRank + " " + classRank;
	}

}
