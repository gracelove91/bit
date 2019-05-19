package day09;
//StringBuffer는 equals가 오버라이딩되지않아서,
//toString을 통해 String으로 변경 후 비교해야한다.
public class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb==sb2 ? "+(sb==sb2));
		System.out.println("sb.equals(sb2) ? "+sb.equals(sb2));
		
		String s = sb.toString();
		String s2 = sb2.toString();
		
		System.out.println(s==s2);
		System.out.println(s.equals(s2));
	}
}
