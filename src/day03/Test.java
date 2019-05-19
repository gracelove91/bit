package day03;

public class Test {
	public static void main(String[] args) {
		for(int i = 1; i <=10; i++) {
			System.out.printf("%2d\t%2d\t%2d\t%2d\t%2d\t%2d\t%2d%n", i, 10-i, i*2, i*2-1, i*i, (i+2)/3, (i+2)%3 + 1);
		}
		
	}
}
