package day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class bingoTest {
	//int bingocnt(int[][] bingo)	//반환은 빙고의 갯수.
	
	//(전략 !!!! )
	//행을 검사하여 1이 있으면 rowCount++
	//rowCount	갯수와 행의 길이가 같으면 빙고이므로 bingoCnt++
	//다음행 검사를 위해 rowCount 를 0으로 초기화시켜준다 
	//행의 길이만큼 반복한다.
	
	//마찬가지로 열을 검사하여 1이 있으면 colCount++
	//rowCount 갯수와 열의 길이가 같으면 빙고이므로 bingoCnt++
	//다음열 검사를 위해 colCount를 0으로 초기화시켜준다.
	//열의 길이만큼 반복한다.
	
	//마찬가지로 대각선을 검사한다
	//왼쪽에서 시작하는 대각선부터 검사. 1이 있으면 oterCount++
	//bingo.length와 otherCount가 같으면 빙고라는 소리므로 bingoCnt++
	//otherCount 0으로 초기화후 오른쪽에서 시작하는 대각선 검사. 1이있으면 othercount++
	//bingo.length와 otherCount가 같으면 빙고라는 소리므로 bingoCnt++
	
	int bingoCnt(int[][] bingo) {
		int bingoCnt = 0; 		//빙고개수
		int colCount = 0;		//열 1이 있는 갯수 
		int rowCount = 0;		//행 1이 있는 갯수
		int otherCount = 0; 	//대각선 1이 있는 갯수 

		//행과 열 빙고갯수 세는 for
		for(int i = 0; i < bingo.length; i++) {
			for(int j = 0; j < bingo[i].length; j++) {
				if(bingo[j][i] == 1) {			//[0.0] , [1.0] , [2.0] ... [1.1] .... [ 0.4 ], [1.4] , [2.4], [3.4], [4.4]	 행에 1이 있나 연속된 행 검
					rowCount++;
				}
				if(bingo[i][j] == 1) {			//[0.0] , [0.1] , [0.2] ...			열에 1이 있나 연속된 열 검사.
					colCount++;
				}
			}
			
			if(rowCount == bingo.length) {		// rowCount와 행의 길이가 같다면 빙고이므로 bingoCnt++
				bingoCnt++;							
			}
			if(colCount == bingo.length) {		//	colCount와 열의 길이가 같다면 빙고이므로 bingmoCnt++
				bingoCnt++;
			}
			rowCount = 0;						//다음 row의 검사를 위해 0으로 초기화 
			colCount = 0;						//다음 col의 검사를 위해 0으로 초기화 
		}
		
		/*대각선 빙고 갯수를 세기 위한 for문 */
		for (int i = 0; i < bingo.length; i++) {
			if(bingo[i][i] == 1) {
				otherCount++;
			}else {
				break;
			}
		}
		
		if(otherCount == bingo.length) {
			bingoCnt++;
		}
		 
		otherCount = 0;

		for(int i = 0; i <bingo.length; i++) {
			for(int j = 0; j < bingo.length; j++) {
				if(i + j == 4) {
					if(bingo[i][j] == 1) {
						otherCount++;
					}else {
						break;
					}
				}else {
					continue;
				}
			}
		}
		
		if(otherCount == bingo.length) {
			bingoCnt++;
		}
		return bingoCnt;
	}
	
	@Test
	void test() {
		int[][] bingo = {
				{ 0,0,0,1,0 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 0,0,0,1,0 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 4);
	}
	@Test
	void test2() {
		int[][] bingo = {
				{ 0,0,1,1,0 },
				{ 0,0,1,1,0 },
				{ 0,0,1,1,0 },
				{ 0,0,1,1,0 },
				{ 1,0,1,1,0 }
		};
		assertTrue(bingoCnt(bingo) == 2);
		
	}
	@Test
	void test3() {
		int[][] bingo = {
				{ 0,0,0,0,0 },
				{ 0,0,0,0,0 },
				{ 1,1,1,1,1 },
				{ 0,0,0,1,0 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 2);
		
	}
	@Test
	void test4() {
		int[][] bingo = {
				{ 0,0,0,1,0 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 5);
		
	}
	@Test
	void test5() {
		int[][] bingo = {
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 12);
	}
	@Test
	void test6() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 0,1,0,1,1 },
				{ 0,0,1,1,1 },
				{ 1,1,0,1,0 },
				{ 0,1,0,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 1);
	}
	@Test
	void test7() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 0,1,0,1,1 },
				{ 0,0,1,1,1 },
				{ 1,1,0,1,0 },
				{ 1,1,0,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 2);
	}

}