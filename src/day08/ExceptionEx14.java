package day08;

public class ExceptionEx14 {
	public static void main(String[] args){
		try {
			method1();			
		} catch (Exception e) {
			System.out.println("main메서드에서 예외가 처리되었습니다. ");
		}
	}
	
	static void method1(){
		throw new RuntimeException();
	}
}
