package day03;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		/*문제!!*/
		//두배열의 요소와 인덱스가 서로 일치하면 s++
		//요소는 같지만 인덱스가 불일치하면 b++
		int[] arr = {1,1,1};
		int[] input = new int[arr.length];
		
		int s = 0, b = 0;
		
		//입력을 받아서, arr.lengt == input일 때 정답과 동시 종료.
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("숫자를 입력하세요. (1~10)");
			input[i] = scan.nextInt();
		}
		
		
		//arr1[i] 와 arr2[0~arr2.length] 를 비교한다.
		//요소가 같고 i와 j가 일치하면 s ++
		//요소는 일치하지만 i와 j가 다르면 b++
		for(int i = 0; i < arr.length; i++) {		//arr1[i] 와 arr2[0~arr2.length] 를 비교한다.
			for(int j = 0; j < input.length; j++) {
				if(arr[i] == input[j]) {			//동일한 요소 발견했을 때.
					if(i == j) {					//동일한 요소가 발견됐고, i와 j가 같을 때(위치(인덱스)가 같을 때) s++
						s++;
					}else {							//동일한 요소가 발견됐지만, i와 j가 다를 때(위치(인덱스)가 다를 때) b++
						b++;
					}
				}
			}
		}
		
		System.out.println("s = "+s+", b = "+b);
	}
}
