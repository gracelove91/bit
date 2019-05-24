package study0523.Exercise11_12;

/**
 * 
 * [11-12] 다음은 섯다게임에서 카드의 순위를 결정하는 등급목록(족보)이다. HashMap에 등급과 점수를 저장하는
 * registerJokbo()와 게임참가자의 점수를 계산해서 반환하는 getPoint()를 완성하시오.
 * 
 * [참고] 섯다게임은 두 장의 카드의 숫자를 더한 값을 10으로 나눈 나머지가 높은 쪽이 이기는 게임이다. 그 외에 도 특정 숫자로 구성된
 * 카드로 이루어진 등급(족보)이 있어서 높은 등급의 카드가 이긴다.
 *
 */
public class Exercise11_12 {

}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	void registerJokbo() {
		
	}
	
	int getPoint(Player p) {
		if(p == null) return 0;
		
		SutdaCard c1 = p.c1;
		SutdaCard c2 = p.c2;
		
		Integer result = 0;
		
		/* (2) 아래의 로직에 맞게 코드를 작성하시오.
		1. 카드 두 장이 모두 광이면, jokbo에서 키를 "KK"로 해서 점수를 조회한다. 
		2. 두 카드의 숫자(num)로 jokbo에서 등급을 조회한다.
		3. 해당하는 등급이 없으면, 아래의 공식으로 점수를 계산한다.
		(c1.num + c2.num) % 10 + 1000
		4. Player의 점수(point)에 계산한 값을 저장한다
		*/ 
		
		if(c1.isKwang == true && c2.isKwang == true) {
			//jokbo
		}
	}
	
	SutdaCard pick() throws Exception{
		
	}
	
	void shuffle() {
		for(int x = 0; x < CARD_NUM * 2; x++) {
			int i = (int) (Math.random() * CARD_NUM);
			int j = (int) (Math.random() * CARD_NUM);
			
			SutdaCard tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	
	}
}

class Player {
	String name;
	SutdaCard c1;
	SutdaCard c2;

	int point;

	public Player(String name, SutdaCard c1, SutdaCard c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}

	@Override
	public String toString() {
		return "["+name+"]"+c1.toString() + "," + c2.toString();
	}

}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	public SutdaCard(int num, boolean isKwang) {
		super();
		this.num = num;
		this.isKwang = isKwang;
	}

	@Override
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}