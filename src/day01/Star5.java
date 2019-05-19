package day01;

public class Star5 {
	public static void main(String[] args) {
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("[" + i + "," + j + "]");		
			}
			System.out.println();
		}
	}
}
