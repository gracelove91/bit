package study0522;

import java.util.ArrayList;
import java.util.List;

public class FruitBoxEx1 {
	public static void main(String[] args) {
		Box<Fruit> fruitBox = new Box<>();
		Box<Apple> appleBox = new Box<>();
		Box<Toy>   toyBox   = new Box<>();
//		Box<Fruit> grapeBox = new Box<Grape>();			//다이아몬드 연산자 안에 있는 타입은 같아야한다.(다형성 불가)
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());						// void add (Fruit item)
		
		appleBox.add(new Apple());
		
		
		System.out.println(fruitBox.toString());
		System.out.println(appleBox.toString());
		
	}
	

}

class Fruit { public String toString() { return "Fruit";} }
class Apple extends Fruit { public String toString() { return "Apple";} }
class Grape extends Fruit { public String toString() { return "Grape";} }
class Toy { public String toString() { return "Toy";} }

class Box<T>{
	List<T> list = new ArrayList<>();
	
	void add(T t) {
		list.add(t);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	List<T> getList() {
		return list;
	}
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}