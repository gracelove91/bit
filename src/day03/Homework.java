package day03;

import java.util.Arrays;

public class Homework {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 4, 2, 2, 3, 1, 4, 4, 4 };
		int[] count = new int[maxE(arr) + 1];			
		//arr요소의 중복갯수를 저장할 count[] 선언. 크기는 arr의 요소 중 가장 큰 값에 +1을 해야한다. 
		//( 배열의 인덱스는 0부터 시작하기 때문에. )
		//ex) max가 4일 때, count의 인덱스는 0, 1, 2, 3이기 때문에 4의 중복값을 저장할 인덱스가 없다.
		
		
		for(int i = 0; i < arr.length; i++) {
			count[arr[i]]++;			// arr요소의 값을 그 값과 동일한 count인덱스 값에 ++해준다. ex) arr[0] = 3  =>  count[3] = count[3]++
		}
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] > 0) {		//count[i]가 0보다 크다면 arr요소 중 i값과 동일한 값이 한 개 이상 있다는 말이기 때문에 i를 출력해준다.
				System.out.print(i);
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(count));
	}
	
	public static int maxE(int[] arr) {				//매개변수로 넘어온 배열 중 가장 큰 요소를 반환해준다.
		int maxE = arr[0];							//maxE arr[0]값으로 초기화.
		for(int i = 0; i < arr.length; i++) {		//arr요소를 검사하여 maxE보다 크면 maxE에 대입. 길이만큼 반복.
			if(maxE < arr[i]) {
				maxE = arr[i];
			}
		}
		return maxE;								//요소 중 가장 큰 값 반환.
	}
}
