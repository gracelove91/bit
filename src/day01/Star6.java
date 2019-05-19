package day01;

public class Star6 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 6; j++) {
				System.out.print("[" + i + "," + j + "]");
			}
			System.out.println();
		}
	}
}
