package day01;

public class StarTest {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
//				System.out.print("[" + i + "," + j + "]");

//				if(i+j <=4 ) {
//					System.out.print("["+i+","+j+"]");		
//				}else {
//					System.out.print("_____");
//				}
//				
//				if( j - i >= 0) {
//					System.out.print("["+i+","+j+"]");		
//				} else {
//					System.out.print("_____");
//				}
//				
				//////
//				if(i+j <= 4 && j-i >= 0) {
//					System.out.print("["+i+","+j+"]");		
//				} else {
//					System.out.print("_____");
//				}
//
//				if (i - j >= 0) {
//					System.out.print("[" + i + "," + j + "]");
//				} else {
//					System.out.print("_____");
//				}
//				if (j + i >= 4) {
//					System.out.print("[" + i + "," + j + "]");
//				} else {
//					System.out.print("_____");
//				}

//				////
				if ((i - j >= 0 && j + i >= 4) || (i + j <= 4 && j - i >= 0)) {
					System.out.print("[" + i + "," + j + "]");
				} else {
					System.out.print("_____");
				}
//				

			}

			System.out.println();
		}
	}
}
