package homeWork;

import java.util.Arrays;

public class Homework2 {
	public static void main(String[] args) {
		//배열 오름차순 정렬.   
		int[] arr = { 3, 1, 4, 2, 2, 3, 1, 4, 4, 4 };
		int[] counter = new int[4+1];	//arr요소 중 가장 큰 값이 4기때문에 4+1 크기의 배열 생성(index는 0부터시작)
		
		for(int i = 0; i < arr.length; i++) {
			counter[arr[i]]++;			//arr요소의 값과 counter의 index값이 동일하면 ++해준다.
		}
		
		System.out.println(Arrays.toString(counter));	
		
		for(int i = 0; i < counter.length; i++) {
			for(int j = 0; j < counter[i]; j++) {
				System.out.print(i);				//counter[i]에 있는 수 만큼 출력
			}
		}
	}
}
