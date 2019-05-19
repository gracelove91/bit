package homeWork;

import java.util.Arrays;

public class Homework {
	public static void main(String[] args) {
		//중복된 수 제거하고 출력하기.
		//예상결과 ) 1 2 3 4
		
		int[] arr = { 3, 1, 4, 2, 2, 3, 1, 4, 4, 4 };
		int[] counter = new int[4+1];				//arr의 요소 중 4가 가장 큰 값이니까, 크기 4+1인 int형 배열 생성.  
		
		for(int i = 0; i < arr.length; i++) {
			counter[arr[i]]++;						//arr의 요소와 동일한 값의 인덱스를 1 증가시켜준다.
		}
		
		for(int i = 0; i < counter.length; i++) {
			if(counter[i] > 0) {					//0보다 크다면 해당인덱스와 arr 각 요소의 동일한 값이 1개이상 있다는 뜻이니까 i를 출력해준다.
				System.out.print(i+"\t");							
			}
		}
	}
}
