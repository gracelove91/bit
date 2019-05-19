package day09;

public class StringEx7 {
	public static void main(String[] args) {
		String fullName = "Hello.java";
		
		// fullName에서 '.'을 찾는다.
		int index = fullName.indexOf('.');
		System.out.println(index);
		
		String fileName = fullName.substring(0, index);
		String extendName = fullName.substring(index+1);
		
		System.out.println(fileName);
		System.out.println(extendName);
	}
}
