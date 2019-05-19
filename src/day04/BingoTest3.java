package day04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BingoTest3 {

	int bingoCnt(int[][] bingo) {
		//빙고판을 매개변수로 받아서 빙고의 갯수를 반환하는 메서드.
		//1줄씩 checkLineBingo(int[] line) 로 보내 빙고인지 확인한다 반환값이 true면 빙고이므로 cnt++.
		
		int[] rowLine = new int[bingo.length];						//행의 한 줄을 저장하는 배열.(ㅡ)
		int[] colLine = new int[bingo.length];						//열의 한 줄을 저장하는 배열.(|)
		int[] acrossLine = new int[bingo.length];					//왼쪽에서 시작하는 대각선 한 줄을 저장하는 배열.(\)
		int[] anotherAcrossLine = new int[bingo.length];				//오른쪽에서 시작하는 대각선 한 줄을 저장하는 배열.(/)
		
		int bingoCnt = 0;											//빙고의 갯수 카운트하는 변수.
		
		for(int i = 0; i < bingo.length; i++) {					//for문 시작.
			for(int j = 0; j < bingo[i].length; j++) {				
				rowLine[j] = bingo[i][j];						//[0.1][0.2][0.3][0.4] ... 행(5x5)이므로 이중for문 내에 위치한다 
				colLine[j] = bingo[j][i];						//[1.0][2.0][3.0][4.0] ... 열(5x5)이므로 이중for문 내에 위치한다 
			}// end of inner for
			
			acrossLine[i] = bingo[i][i];						//[0.0][1.1][2.2][3.3][4.4]	   대각선한줄(5x1)이므로 단일for문 내에 위치한다. 
			anotherAcrossLine[i] = bingo[i][bingo.length-i-1];	//[0.4][1.3][2.2][3.1][4.0]    대각선한줄(5x1)이므로 단일for문 내에 위치한다.
			
			//checkLineBingo로 한줄씩 보내서 빙고인지 확인한다. true면 빙고므로 cnt++
			if(checkLineBingo(colLine)) bingoCnt++;				
			if(checkLineBingo(rowLine)) bingoCnt++;
		}//end of outter for
		if(checkLineBingo(acrossLine)) bingoCnt++;
		if(checkLineBingo(anotherAcrossLine)) bingoCnt++;
		
		return bingoCnt;
	}
	
	boolean checkLineBingo(int[] line) {	//한 줄이 모두 1인지 검사해서 참이면 true, 아니면 false반
		for(int i = 0; i < line.length; i++) {
			if(line[i] != 1) {
				return false;				// 1이 발견안되면 빙고는 불가능하니까 더 검사할 필요 없이 false	리턴.
			}
		}
		return true;
	}
	
	@Test
	void test0() {
		int[][] bingo = {
				{ 1,0,1,0,1 },
				{ 0,1,1,1,1 },
				{ 0,0,1,1,1 },
				{ 1,1,1,1,0 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 4);
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
	@Test
	void test8() {
		int[][] bingo = {
				{ 0,0,0,0,0 },
				{ 0,0,0,1,0 },
				{ 0,0,0,0,0 },
				{ 0,0,0,0,0 },
				{ 0,0,0,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 0);
	}
	@Test
	void test9() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 1,0,0,1,0 },
				{ 1,0,1,0,0 },
				{ 1,1,0,0,0 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 3);
	}
	@Test
	void test10() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 0,1,0,1,0 },
				{ 0,0,1,0,0 },
				{ 0,1,0,1,0 },
				{ 1,0,0,0,1 }
		};
		assertTrue(bingoCnt(bingo) == 2);
	}
	@Test
	void test11() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 1,0,0,1,0 },
				{ 1,0,1,0,0 },
				{ 1,1,0,0,0 },
				{ 1,1,1,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 3);
	}
	@Test
	void test12() {
		int[][] bingo = {
				{ 1,0,0,0,1 },
				{ 1,0,0,1,0 },
				{ 1,0,1,0,0 },
				{ 1,1,0,0,0 },
				{ 1,0,0,0,0 }
		};
		assertTrue(bingoCnt(bingo) == 2);
	}
	@Test
	void test13() {
		int[][] bingo = {
				{ 1,0,0,1,1 },
				{ 1,0,0,1,0 },
				{ 1,0,1,1,0 },
				{ 1,1,0,1,0 },
				{ 1,0,0,1,0 }
		};
		assertTrue(bingoCnt(bingo) == 3);
	}
	@Test
	void test14() {
		int[][] bingo = {
				{ 1,1,0,1,1 },
				{ 1,1,1,1,1 },
				{ 1,1,1,1,0 },
				{ 1,1,0,1,0 },
				{ 1,1,0,1,0 }
		};
		assertTrue(bingoCnt(bingo) == 5);
	}
	@Test
	void test15() {
		int[][] bingo = {
				{ 1,0,0,1,0,1,1 },
				{ 1,0,0,1,0,1,1 },
				{ 1,0,0,1,1,1,1 },
				{ 1,0,0,1,0,1,1 },
				{ 1,0,1,1,0,1,1 },
				{ 1,1,0,1,0,1,1 },
				{ 1,0,0,1,0,1,1 }
		};
		assertTrue(bingoCnt(bingo) == 5);
	}
	

}
