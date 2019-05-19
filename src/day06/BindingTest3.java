package day06;

public class BindingTest3 {
	public static void main(String[] args) {
		Parent3 p = new Child3();
		Child3 c = new Child3();
		
//		System.out.println(p.x);
//		System.out.println(c.x);
		
		p.method();					//실제 인스턴스의 메소드를 호출한다.(오버라이딩된 메소드)
		c.method();
	}
}

class Parent3{
	int x = 100;
	
	void method() {
		System.out.println("This is Parent3 Method");
	}
}
class Child3 extends Parent3{
	int x = 200;
	
	void method() {
		System.out.println("x="+x);
		System.out.println("super.x="+super.x);
		System.out.println("this.x="+this.x);
	}
}
