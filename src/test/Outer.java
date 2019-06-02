package test;

public class Outer {
	int k = 3;

	public static void main(String[] args) {

	}

	class Inner {
		
		void method1() {
			k = 4;
		}
	}
}
