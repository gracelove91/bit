package day04;

public class Homework {
	//세개의정수를 받아서 중간크기의 값을 반환하는 메서드 작성하고, 테스트. 메서드 이름 : mid 매개변수 : int x, int y, int z
	//반환타입 int
	public static void main(String[] args) {
		Homework work = new Homework();				//homework	인스턴스 생성.
		
		int x = work.shuffle();					//1~10까지의 정수를 반환하는 메소드.
		int y = work.shuffle();
		int z = work.shuffle();
		
		System.out.println(x +" "+y+" "+z);
		int result = work.mid(x, y, z);			//중간값 리턴해주는 메소드.
		System.out.println("중간값 : "+result);	//출
	}
	public int mid(int x, int y, int z) {		
		int[] tmp = new int[3];		//매개변수로 넘어온 값을 저장하는 배열 생성.
		tmp[0] = x;					//초기화 
		tmp[1] = y;
		tmp[2] = z;
		for(int i = 0; i < tmp.length-1; i++) {			//버블정렬로 오름차순 정렬.
			for(int j = 0; j < tmp.length-1-i; j++) {
				if(tmp[j] > tmp[j+1]) {
					int tmp2 = tmp[j];
					tmp[j] = tmp[j+1];
					tmp[j+1] = tmp2;
				}
			}
		}
		return tmp[1];							//가운데 있는 값 리턴.
	}

	public int mid2(int x, int y ,int z) {
		
		//셋다 같으면 아무거나 리턴가능하니까 걍 y리턴.
		//x == y , y != z     =>    return y.
		//x == z , y != z     =>    return z
		//x랑 y랑 먼저 비교. x가 y보다 크고	z보다 작으면 x리턴.
		//y랑 z랑 비교, y가 x보다 크고, z보다 작으면 y리턴.
		//
		if(x == y && y == z) {
			return y;
		}
		
		return 0;
		
	
		
	}
	public int shuffle() {							//1에서 10까지 정수 랜덤하게 추출 뒤 리턴해주는 메소드.
		int result = (int)(Math.random() * 10)+1;
		return result;
	}
}
