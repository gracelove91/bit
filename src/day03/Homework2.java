package day03;

import java.util.Arrays;

public class Homework2 {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 2, 2, 3, 1, 4, 4, 4 };
		int count = 0;
		//for문으로 arr[i] 와 arr[i+1] 과 비교. arr[i] > arr[i+1] 이라면 int tmp에 arr[i] 저장, arr[i]에 arr[i+1] 저장. arr[i+1]에 tmp저장.
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					System.out.println(Arrays.toString(arr));
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
