package day06;
//public(접근에 아무런 제한이 없다.) -> protected(같은 패키지, 다른 패키지의 자손까지 접근가능) -> default(같은 패키지 내에서만.) -> private(같은 클래스 안에서만)
public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine fe = new FireEngine();
		
		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance");
		}
		
		if(fe instanceof Car) {
			System.out.println("This is a Car instance");
		}
		
		if(fe instanceof Object) {
			System.out.println("This is a Object instance");
		}
	}
	
}
