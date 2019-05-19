package day06;

public class CastingTest2 {
	public static void main(String[] args) {
		Car car = new Car();
		Car tmp = new FireEngine();
		Car car2 = null;
		FireEngine fe = null;
		Car tmp2 = fe;				// tmp2 = null
//		tmp2.drive();				//	nullpointException
		
		car.drive();
//		fe = (FireEngine)car;			//자손타입의 참조변수로는 조상의 인스턴스를 할당할 수 없다. 그래서 ERROR !
										//조상의 인스턴스를 자손의 참조변수로 컨트롤할 수 없다! 으디서 버르장머리없
		fe = (FireEngine)tmp;
		fe.drive();
		
	}
}
