package day09;

public class CloneEx1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Point origin = new Point(3, 5);
		Point copy = (Point)origin.clone();			
		System.out.println(origin);
		System.out.println(copy);
		
		/////
		System.out.println();
		copy.x = 5;
		System.out.println(origin);
		System.out.println(copy);
	}
}
class Point implements Cloneable{
	int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	String str;
	
	@Override
	public String toString() {
		return "x="+x+", y="+y;
	}
	
	
//	public Object clone() {
//		Object obj = null;
//		try {
//			obj = super.clone();
//		}catch(CloneNotSupportedException e) {
//			
//		}
//		return obj;
//	}
	@Override
	public Point clone() {
		Point obj = null;
		
		try {
			obj = (Point)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
}