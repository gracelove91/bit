package study0520.myvector;

import java.util.Vector;

public class MyVectorTest {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		
		MyVector v = new MyVector(2);
//		System.out.println(v1.get(100));
		v.add(new String("1"));
		v.add(new String("2"));
		v.add(new String("3"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(new String("4"));
		v.add(null);
		System.out.println(v.size());
		System.out.println(v.get(0));
		System.out.println(v.get(1));
		System.out.println(v.get(2));
//		System.out.println(v.get(5));
		System.out.println(v);
		
		System.out.println(v.remove("4"));
		System.out.println(v.remove("1"));
		System.out.println(v.remove("2"));
		System.out.println(v.remove("3"));
		
		System.out.println(v);
		
		
		System.out.println(v.size());
	}
}
