package day04;

public class TvMain {
	public static void main(String[] args) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		System.out.println("클래스변수 height 변경 전 : ");
		System.out.println("t1.height : "+t1.height);
		System.out.println("t2.height : "+t2.height);
		

		t1.height = 5;
		System.out.println("클래스변수 height 변경  : ");
		System.out.println("t1.height : "+t1.height);
		System.out.println("t2.height : "+t2.height);
	}
}
