package day09;
//래퍼클래스는 객체이기 때문에 비교연산자(>, < 등)을 쓸 수 없다.
//따라서 compareTo를 이용해 비교하자.
public class WrapperEx1 {
	
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Integer i2 = new Integer(100);

		System.out.println("i == i2 ? "+(i == i2));
		System.out.println("i.equals(i2) ? "+(i.equals(i2)));
		System.out.println("i.compareTo(i2) ? "+(i.compareTo(i2)));
		System.out.println("i.toString() = "+i.toString());
		
		System.out.println("MAX_VALUE="+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE="+Integer.MIN_VALUE);
		System.out.println("SIZE="+Integer.SIZE+" bits");
		System.out.println("BYTES="+Integer.BYTES+ "bytes");
		System.out.println("TYPE="+Integer.TYPE);
	}
}
