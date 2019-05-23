package study0522.FruitBoxEx4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Fruit {
	String name;
	int weight;

	Fruit(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String toString() {
		return "[" + name + " : " + weight + "]";
	}
}

class Apple extends Fruit {
	Apple(String name, int weight) {
		super(name, weight);
	}
}

class Grape extends Fruit {
	Grape(String name, int weight) {
		super(name, weight);
	}
}

class AppleComp implements Comparator<Apple> {
	@Override
	public int compare(Apple o1, Apple o2) {
		// TODO Auto-generated method stub

		return o1.weight - o2.weight;
	}
}

class GrapeComp implements Comparator<Grape> {
	@Override
	public int compare(Grape o1, Grape o2) {
		// TODO Auto-generated method stub
		return o1.weight - o2.weight;
	}
}

class FruitComp implements Comparator<Fruit> {
	@Override
	public int compare(Fruit o1, Fruit o2) {
		return o1.weight - o2.weight;
	}
}

public class FruitBoxEx4 {
	public static void main(String[] args) {
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();

		appleBox.add(new Apple("GreenApple" , 300));
		appleBox.add(new Apple("GreenApple" , 100));
		appleBox.add(new Apple("GreenApple" , 200));
		
		grapeBox.add(new Grape("YellowGrape" , 400));
		grapeBox.add(new Grape("YellowGrape" , 500));
		grapeBox.add(new Grape("YellowGrape" , 300));
	
	
		Collections.sort(appleBox.getList(), new AppleComp());
		Collections.sort(grapeBox.getList(), new GrapeComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp());
	
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
		
		
	}
}

class FruitBox<T extends Fruit> extends Box<T> {
}

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();

	void add(T item) {
		list.add(item);
	}

	T get(int index) {
		return list.get(index);
	}
	
	ArrayList<T> getList() {
		return list;
	}
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
}
