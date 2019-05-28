package study0528.ch7;

public class InnerEx1 {
	class InstanceInner{				//인스턴스 클래스.
		int iv = 100;
//		static int cv = 100;			//static변수를 선언할 수 없다. 왜?
		final static int CONST = 100;	//상수이므로 허용한다.
	}
	
	static class StaticInner{			//스태틱 클래스.
		int iv = 200;
		static int cv = 200;			//스태틱 클래스에서만 스태틱변수를 정의할 수 있다.
	}
	
	void myMethod() {
		class LocalInner {				//지역클래스.
			int iv = 300;
//			static int cv = 300;			//이 역시 스태틱 변수를 선언할 수 없다.
			final static int CONST = 300;	//이는 상수이므로 허용한다.
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}
}
