package day09;
// 얕은 복사는 객체의 단순히 iv의 값만을 복사.
// 때문에 iv가 참조변수 타입이라면 복제본의 iv또한 같은 주소를 갖게된다. 때문에 원본 참조변수타입의 iv를 변경하면 복제본에도 영향을 끼치게된다.

// 깊은복사는 원본이 참조하고 있는 객체까지 복제하는 것. 때문에 원본이 참조하고 있는 객체를 변경해도 복제본은 영향이 없다.
public class ShallowDeepCopy {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		
		System.out.println("c1="+c1);	//원본 
		System.out.println("c2="+c2);	//얕은복사. 원본인 c1의 참조타입의 변수를 건드리면 c2또한 영향갈 것.
		System.out.println("c3="+c3);	//깊은복사. 원본인 c1을 건드려도 영향끼치지않을 것.
		
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("--------------------");
		System.out.println("c1="+c1);	
		System.out.println("c2="+c2);	
		System.out.println("c3="+c3);			
	}
}
class Point2{
	int x,y;
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "("+x+", "+y+")";
	}
}

class Circle implements Cloneable{
	Point p;
	double r;
	
	Circle(Point p, double r){
		this.p = p;
		this.r = r;
	}
	
	public Circle shallowCopy() {		//얕은 복사.
		Circle obj = null;
		try {
			obj = (Circle) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	public Circle deepCopy() {	//깊은 복사.
//		Circle obj = null;
		Object obj = null;
		try {
//			obj = (Circle)super.clone();
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Circle c = obj;
//		c.p = new Point(c.p.x , this.y);
		Circle c = (Circle)obj;
		c.p = new Point(this.p.x, this.p.y);
		return c;
		
	}
	@Override
	public String toString() {
		return "[p="+p+", r="+r+"]";
	}
}