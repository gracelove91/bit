package day04;

public class Homework2 {
	//int bingocnt(int[][] bingo)	//반환은 빙고의 갯수.
	//j유닛 테스트 
	public static void main(String[] args) {
		int[][] bingo = {
				{ 0,0,0,0,0 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 0,0,0,0,0 },
				{ 1,1,1,1,1 }
		};
	}
	
	int bingoCnt(int[][] bingo) {
		int bingoCnt = 0; //빙고개수
		int iCount = 0;		//1이 있는 갯수. 나중
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				//i행 j열에 0있으면 빙고는 물건너 간거니까 break;
				
			}
		}
		
		return 0;
	}
}
