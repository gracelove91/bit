package day04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BingoTest2 {

	int bingoCnt(int[][] bingo) {
		//가로부터 세보자
		int bingoCnt = 0;
		for(int i = 0; i < bingo.length; i++) {
			int cnt = 0;		//매행마다 0으로 초기화 
			for(int j = 0; j < bingo[i].length; j++) {
				if(bingo[i][j] == 1) {
					cnt++;
				}
			}
//			i==j	arr[i][j] == 1
//			i+j==4  arr]i][j] == 1

			if(cnt == 5) bingoCnt++;
		}
		return bingoCnt;
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
