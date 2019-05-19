package day06;

public class CastingTest1 {
	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = new FireEngine();
		
		fe.water();
		car = fe;				//부모타입의 참조변수로 형변환 하는 것은 자동형변환. --> Car car = new FireEngine();
//		car.water();			//Car에는 water가 없기 때문에 호출불가능. Car타입으로는 Car의 멤버만 다룰 수 있다.
		fe2 = (FireEngine)car;	//자식타입의 참조변수로 형변환하는 것은 강제형변환 해줘야 한다.
		fe2.water();			//FireEngine에는 water()	가 있기때문에 호출가능. 
	}		
}
class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("Drive !");
	}
	
	void stop() {
		System.out.println("Stop !!");
	}
}
class FireEngine extends Car{
	void water() {
		System.out.println("Water ! !");
	}
	void drive() {
		System.out.println("FE Drive ! !");
	}
}
