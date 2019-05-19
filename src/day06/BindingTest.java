package day06;

public class BindingTest {
	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.x);
		p.method();
		
		if(p instanceof Child) {
			Child c = (Child)p;
			System.out.println(c.x);
			c.method();
		}
	}
}

class Parent{
	int x = 100;
	void method() {
		System.out.println("This is parent method");
	}
}

class Child extends Parent{
	int x = 200;
	void method() {
		System.out.println("This is child method");
	}
}