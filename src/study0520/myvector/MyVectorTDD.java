package study0520.myvector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyVectorTDD {
	/*
	 * 기본생성자 넣어서 capacity가 16인지 확인. 음수넣으면 익셉션 발생하는 지 확인.
	 * 
	 */
	@Test
	void 생성자테스트() {
		MyVector v = new MyVector();
		assertTrue(v.capacity() == 16);
//		System.out.println(Integer.MAX_VALUE);
//		MyVector v2 = new MyVector(-1);
//		MyVector v3 = new MyVector(2000000000);
//		MyVector v4 = new MyVector(2147483647);
	}

	/**
	 * v.add(i)를 n번 돌려서 size가 n개인지 확인한다.
	 * add 횟수 == size
	 */
	@Test
	void add테스트() {
		MyVector v = new MyVector();
		for(int i = 0; i < 9999; i++) {
			v.add(i);
		}
//		assertTrue(v.size() == 100);
		try {
			v.add(null);			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
//	/**
//	 * size()가 capacity()에 도달하면 capacity는 두배씩 늘어난다.
//	 * 기본생성자로 초기화할 경우 capacity는 16이다.
//	 * add를 17번해주면 capacity는 두 배인 32가 될 것.
//	 * 
//	 */
//	@Test
//	void capacity테스트() {
//		MyVector v = new MyVector();
//		for(int i = 0; i < 17; i++) {
//			v.add(i);
//		}
//		assertTrue(v.capacity() == 32);
//	}
//	
//	/**
//	 * n번째 add한 값이 get(n-1)로 뽑아낸 값과 같은 지 확인 
//	 * null도 집어넣어서뽀ㅃ아보고~ 되도않는 큰 값 인덱스에 넣어서 뽑아보고~~
//	 */
//	@Test
//	void get테스트() {
//		MyVector v = new MyVector();
//		v.add("abc");
//		v.add(null);
//		assertTrue(v.get(1) == null);
////		v.get(-1);
//		System.out.println(v.get(1000));
//	}
//	
//	/**
//	 * for문으로 100번 돌린다(add(0~99)) 요소값 99가 index 99에 위치헀는 지 확인. 
//	 */
//	@Test
//	void indexOf테스트() {
//		MyVector v = new MyVector();
//		for(int i = 0; i < 100; i++) {
//			v.add(i);
//		}
//		assertTrue(v.indexOf(0) == 0);
//	}
//	/**
//	 * 기본생성 해보고 isEmpty호출.
//	 * add해보고 isEmpty 호출.
//	 * remove해보고 isEmpty호출.
//	 */
//	@Test
//	void isEmpty테스트() {
//		MyVector v = new MyVector();
//		assertTrue(v.isEmpty() == true);
//		v.add("123");
//		assertTrue(v.isEmpty() == false);
//		v.remove("123");
//		assertTrue(v.isEmpty() == true);
//	}
//	/**
//	 * remove(index).
//	 * add한 뒤 remove("123") 해본 후 get으로 출력해본다(null기대)
//	 * 사이즈는 0기대 
//	 */
//	@Test
//	void remove테스트() {
//		MyVector v = new MyVector();
//		v.add("123");
//		System.out.println(v.size());
//		System.out.println(v.remove("123"));
//		System.out.println(v.remove("11111111"));
//		assertTrue(v.get(0) == null);
//		assertTrue(v.size() == 0);
//		v.remove(null);
//		
//	}
//	/**
//	 * add호출 수 == size 여야한다.
//	 * for문으로 add 100번 한 뒤 size 100인지 확인.
//	 * remove 한번 한 뒤 size가 99인지 확인.
//	 * 
//	 */
//	@Test
//	void size테스트() {
//		MyVector v = new MyVector();
//		for(int i = 0; i < 100; i++) {
//			v.add(i);
//		}
//		assertTrue(v.size() == 100);
//		
//		v.remove(1);
//		assertTrue(v.size() == 99);
//		v.remove(2);
//		v.remove(3);
//		assertTrue(v.size() == 97);
//	}
//	/**
//	 * for문으로 0~9까지 add(index)시켜준다.
//	 * 10까지 출력잘되는 지 확인.
//	 * remove(8)한 뒤 0~7, 9출력되는 지 확인.
//	 */
//	@Test
//	void toString테스트() {
//		MyVector v = new MyVector();
//		for(int i = 0; i < 10; i++) {
//			v.add(i);
//		}
//		System.out.println(v);
//		v.remove(8);
//		System.out.println(v);	}
}
