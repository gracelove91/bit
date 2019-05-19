package day01;

public class Star8 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				if(i == j || i+j == 4 || j % 4 == 0 || i == 2) {
//					System.out.print("["+i+","+j+"]");					
//				}else {
//					System.out.print("     ");
//				}
				
				if(i+j < 5 ) {
					System.out.print("["+i+","+j+"]");			
				}
				
//				if(i<=j) {
//					System.out.print("["+i+","+j+"]");	
//				}
				
//				if(i+j < 5 && i<=j) {
//					System.out.print("["+i+","+j+"]");	
//				}
			}
			
			System.out.println();
		}
	}
}