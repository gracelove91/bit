package day03;

import java.util.Arrays;

public class ArrayEx8 {
	public static void main(String[] args) {
		int[] ball = new int[45];
		int[] lotto = new int[6];
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i+1;
		}
		
		for(int i = 0; i < ball.length; i++) {
			int index = (int)(Math.random() * ball.length);
			
			int tmp = ball[index];
			ball[index] = ball[i];
			ball[i] = tmp;
			
		}
		System.out.print("정렬 전 : ");
		lotto = Arrays.copyOf(ball, 6);
		
		System.out.println(Arrays.toString(lotto));
		
		for(int i = 0; i < lotto.length; i++) {
			System.out.println();
			for(int j = i+1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					System.out.printf("lotto[%d] : %d , lotto[%d] : %d%n",i,lotto[i], j, lotto[j]);
					int tmp = lotto[j];
					lotto[j] = lotto[i];
					lotto[i] = tmp;
				}
			}
		}
		

		System.out.println("정렬 후 : "+Arrays.toString(lotto));
		
		
		
	}
}
