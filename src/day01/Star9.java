package day01;

public class Star9 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(i % 4 == 0 || j == 2 || i+j == 4 || i==j) {
					System.out.print("["+i+","+j+"]");					
				}else {
					System.out.print("     ");
				}
			}
			
			System.out.println();
		}
	}
}
