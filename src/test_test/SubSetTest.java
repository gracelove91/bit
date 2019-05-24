package test_test;

import java.util.TreeSet;

public class SubSetTest {
	public static void main(String[] args) {
		TreeSet<Point> set = new TreeSet();
		
		set.add(new Point(1, 2));
		set.add(new Point(2, 3));
		set.add(new Point(4, 5));
		set.add(new Point(6, 7));
		System.out.println(set.subSet(new Point(1, 1) , new Point(6,7)));
	}

}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
