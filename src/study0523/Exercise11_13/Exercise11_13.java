package study0523.Exercise11_13;


import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
/**
 * [11-13] 다음 코드는 문제11-12를 발전시킨 것으로
 *  각 Player들의 점수를 계산하고, 
 *  점 수가 제일 높은 사람을 출력하는 코드이다. 
 *  TreeMap의 정렬기준을 점수가 제일 높은 사람 부터 
 *  내림차순이 되도록 아래의 코드를 완성하시오. 
 *  단, 동점자 처리는 하지 않는다.
 * @author govlmo91
 *
 */
public class Exercise11_13 {
	public static void main(String[] args) throws Exception {
		SutdaDeck deck = new SutdaDeck();
		
		deck.shuffle();

		Player[] pArr = {
				new Player("타짜", deck.pick(), deck.pick()),
				new Player("고수", deck.pick(), deck.pick()),
				new Player("물주", deck.pick(), deck.pick()),
				new Player("중수", deck.pick(), deck.pick()),
				new Player("하수", deck.pick(), deck.pick()),
		};
		
		TreeMap<Player, Integer> rank = new TreeMap<>(new Comparator<Player>(){

			@Override
			public int compare(Player o1, Player o2) {
				
				return o2.point - o1.point;
			}
			
		});
		
		for(int i = 0; i < pArr.length; i++) {
			Player p =pArr[i];
			rank.put(p, deck.getPoint(p));
			System.out.println(p+" "+deck.getPoint(p));
		}
		
		System.out.println();
		System.out.println("1위는 "+rank.firstKey()+"입니다.");
	}

}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	int pos = 0;			//다음에 가져올 카드 위치.
	HashMap<String, Integer> jokbo = new HashMap<>();	//족보를 저장할 HashMap.
	
	SutdaDeck(){
		for(int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1;
			boolean isKwang = i < 10 && (num==1 || num==3 || num==8);
			
			cards[i] = new SutdaCard(num, isKwang);
			System.out.println(cards[i]);
		}
		
		registerJokbo();
	}

	void registerJokbo() {
		jokbo.put("KK", 4000);
		jokbo.put("1010",3100); 
		jokbo.put("99", 3090); 
		jokbo.put("88", 3080); 
		jokbo.put("77", 3070); 
		jokbo.put("66", 3060); 
		jokbo.put("55", 3050); 
		jokbo.put("44", 3040); 
		jokbo.put("33", 3030); 
		jokbo.put("22", 3020); 
		jokbo.put("11", 3010);
		jokbo.put("12", 2060); 
		jokbo.put("21", 2060); 
		jokbo.put("14", 2050); 
		jokbo.put("41", 2050); 
		jokbo.put("19", 2040); 
		jokbo.put("91", 2040); 
		jokbo.put("110", 2030); 
		jokbo.put("101", 2030); 
		jokbo.put("104", 2020); 
		jokbo.put("410", 2020); 
		jokbo.put("46", 2010);
		jokbo.put("64", 2010);
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
			result = jokbo.get("KK");
		}else {
			String numKey = c1.num +""+c2.num;
			result = jokbo.get(numKey);
			
			if(result == null) {
				result = (c1.num + c2.num) % 10 + 1000;
			}
		}
		
		p.point = result;
		
		return result;
	}
	
	SutdaCard pick() throws Exception{
		SutdaCard c = null;
		
		if(0 <= pos && pos < CARD_NUM) {
			c = cards[pos];
			cards[pos++] = null;
		}else {
			throw new Exception("남아있는 카드가 없습니다.");
		}
		
		return c;
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
