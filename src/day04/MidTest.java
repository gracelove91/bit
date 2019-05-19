package day04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MidTest {

	// 세값을 받아서 중간 크기의 값을 반환하는 메서드.

	public int mid(int x, int y, int z) {
		int[] tmp = new int[3]; // 매개변수로 넘어온 값을 저장하는 배열 생성.
		tmp[0] = x; // 초기화
		tmp[1] = y;
		tmp[2] = z;
		for (int i = 0; i < tmp.length - 1; i++) { // 버블정렬로 오름차순 정렬.
			for (int j = 0; j < tmp.length - 1 - i; j++) {
				if (tmp[j] > tmp[j + 1]) {
					int tmp2 = tmp[j];
					tmp[j] = tmp[j + 1];
					tmp[j + 1] = tmp2;
				}
			}
		}
		return tmp[1]; // 가운데 있는 값 리턴.
	}

	int mid2(int x, int y, int z) {
		// x==y==z         => return y
		// x == y , y != z => return y.
		// y == z , y != x => return y
		// x랑 y랑 먼저 비교. x가 y보다 크고 z보다 작으면 x리턴.
		// y랑 z랑 비교, y가 x보다 크고, z보다 작으면 y리턴.
		
		
		if(x == y && y == z) {
			return y;
		}else if(x == y && y != z) {
			return y;
		}else if(y == z && y != x) {
			return y;
		}
		
		
		int result = x > y && x < z ? x : y > x && y < z ? y : z;
		
		return result;
	}
	
	int mid3(int x, int y, int z) {
		//1. 정렬한 뒤 가운데 값을 중간값으로 뽑는다.
		//2. 최대값을 구한 뒤 나머지 두 값 중 가장 큰 값을 뽑는다.
		if( (x<=y && y<=z ) || (z<=y && y <= x) ) return y;
		if( (y<=x && x <= z) || (z<=x && x <= y)) return x;
		
		return z;
	}

	@Test
	void test() {
		assertTrue(mid3(1, 2, 3) == 2);
	}
	
	@Test
	void test2() {
		assertTrue(mid3(2, 1, 3) == 2);
	}

	@Test
	void test3() {
		assertTrue(mid3(3, 1, 2) == 2);
	}

	@Test
	void test4() {
		assertTrue(mid3(1, 2, 2) == 2);
	}

	@Test
	void test5() {
		assertTrue(mid3(1, 1, 2) == 1);
	}

	@Test
	void test6() {
		assertTrue(mid3(2,2,1)==2);
	}
	
	@Test
	void test7() {
		assertTrue(mid3(3,2,3)==3);
	}
	@Test
	void test8() {
		assertTrue(mid3(3,3,3)==3);
	}
	



}
