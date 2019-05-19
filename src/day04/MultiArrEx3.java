package day04;

public class MultiArrEx3 {
	public static void main(String[] args) {
		int[][] m1 = {
				{1,2,3},
				{4,5,6}
		};
		
		int[][] m2 = {
				{1,2},
				{3,4},
				{5,6}
		};
		
		final int ROW     = m1.length;			//m1행길이.
		final int COL     = m2[0].length;		//m2열길이.
		final int m2_ROW  = m2.length;			//m2행길이.
		
		int[][] m3 = new int[ROW][COL];			//m1의 행길이와 m2의 열길이를 각각 행과열로 가지고있는배열생성.
		System.out.println(ROW);
		System.out.println(COL);
	}
}
