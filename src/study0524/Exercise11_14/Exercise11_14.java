package study0524.Exercise11_14;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author govlmo91
 *[11-14] 다음은 성적처리 프로그램의 일부이다. 
 *Scanner클래스를 이용해서 화면으로부터 데이터를 입력하고 보여주는 기능을 완성하시오.
 */
public class Exercise11_14 {
	static ArrayList recored = new ArrayList();	//성적데이터를 저장할 공간.
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
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
		 * (1) 아래의 로직에 맞게 코드를 작성하시오.
				1. 화면으로부터 메뉴를 입력받는다. 메뉴의 값은 1~3사이의 값이어야 한다. 

				2. 1~3사이의 값을 입력받지 않으면, 메뉴의 선택이 잘못되었음을 알려주고
					다시 입력받는다.(유효한 값을 입력받을 때까지 반복해서 입력받는다.)
		 */
		
		return menu;
	}//end of static int displayMenu()
	ㅋ
	//데이터를 입력받는 메서드.
	static void inputRecord() {
		System.out.println("1.학생성적 입력하기.");
		System.out.println("이름, 반, 번호, 국어성적, 영어성적, 수학성적 의 순으로 공백없이 입력하세요. ");
		System.out.println("입력을 마치려면 q를 입력하세요. 메인화면으로 돌아갑니다.");
	
	
		while(true) {
			System.out.print(">>");
			
			/*
			 *  1. Scanner를 이용해서 화면으로 부터 데이터를 입력받는다.(','를 구분자로)
			 *  2. 입력받은 값이 q 또는 Q이면 메서드를 종료하고,
					그렇지 않으면 입력받은 값으로 Student인스턴스를 생성하고 record에 추가한다. 
				3. 입력받은 데이터에서 예외가 발생하면, "입력오류입니다."를 보여주고 다시 입력받는다.
 				4. q 또는 Q가 입력될 때까지 2~3의 작업을 반복한다.
			 */
			
			
			
		}//end of while.
	}// end of inputRecord
	
	//데이터목록을 보여주는 메서드.
	static void displayRecord() {
		
	}
	
	

}
