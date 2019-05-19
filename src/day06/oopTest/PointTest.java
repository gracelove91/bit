package day06.oopTest;

import java.lang.reflect.Constructor;

public class PointTest {
	public static void main(String[] args) throws Exception {
		Point p = new Point(3,5);
//		System.out.println(p);
		
		
		Class cop = p.getClass();	//1.
		Class cop2 = Point.class; //2. point.class는 point설계도 객체를 가리키는 리터럴.
		Class cop3 = Class.forName("day06.oopTest.Point"); //3. 
//		System.out.println(cop3.getName());
		//3번은 스트링형의 매개변수를 사용하기 때문에 유연하게 동적으로 Class 사용가능.
		
		String name = cop.getName();
//		System.out.println(name);
		
		Point p2 = (Point) cop.newInstance();
//		System.out.println(p2.x);
		
		
		////생성자 매개변수는 어떻게?
		
//		Point p3 = (Point) cop.getConstructor(cop);
		Constructor[] con = cop.getConstructors();
		for(Constructor c : con) {
			System.out.println(c.newInstance(new Integer(3), new Integer(2)).toString());
		}
//		Constructor p3 = cop.newInstance().
//		System.out.println(p3);
//		System.out.println(cop.newInstance().getClass().getName());

	}
}
