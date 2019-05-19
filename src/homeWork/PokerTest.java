package homeWork;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
class Card {
	String kind;
	int num;

	Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	Card() {
		this("SPADE", 1);
	}
}
class PokerTest {
	// 5장의 카드 객체가 담긴 cArr을 받아서
	// 랭킹을 문자열로 반환
	// 아래의 메서드를 완성하시오.
	String checkRank(Card[] cArr) {
		int pairCnt = 0;					//pair카드 수 카운팅하는 변수.
		
		boolean isThreeCard = false;
		boolean isFourCard = false;
		boolean isStraight = false;
		boolean isFlush = false;
		
		//카드숫자 카운팅&카드무늬 저장.
		//1. 숫자카운팅하는 배열의 길이는 카드최대숫자인 13+1.. 인덱스는 0부터시작하기때문. 카드의 숫자와 동일한 인덱스의 값++
		//2. kind[] 배열에 각 카드의 무늬 저장.
		int[] cardNumCnt = new int[13+1];			//카드 카운팅하는 배열.
		String[] kinds = new String[5];				//카드의 각 무늬를 저장할 kinds 배열 선언
		for(int i = 0; i < cArr.length; i++) {
			Card card = cArr[i];
			cardNumCnt[card.num]++;					//카드의 숫자와 동일한 인덱스의 값 ++.
			kinds[i] = card.kind;					//카드의 무늬를 kinds[i]에 차례대로 넣어준다.
		}
		
		//Flush 판별.(카드무늬)
		//for문을 kinds,length만큼 돌고, 5개 무늬가 같으면 isFlush = true;
		//0번째 카드무늬 고정. 0+1 카드, 0+2카드.... 0+4 카드까지 비교.
		for(int i = 0; i < kinds.length - 1; i++) {
			if(!kinds[i].equals(kinds[i+1])) {		//연속해서 같은 무늬가 아니면? 플러쉬가 애초에 될 수 없으니 false후 break로 빠져나감.
				isFlush = false;
				break;								
			}else {									//연속해서 같은 무늬라면 플러쉬일 수 있으니 true주고 다음카드의 무늬 확인.
				isFlush = true;
			}
		}
		
		//쓰리카드, 포카드 판별. pair카드 카운팅.
		//for문을 cardNumCnt 길이만큼 돌고, 같은 숫자가 2개면 pairCnt ++. 같은 숫자가 세개면 isThreeCard=true. 네개면 isFourCard=true
		for(int i = 0; i < cardNumCnt.length; i++) {
			if(cardNumCnt[i] == 4) {
				isFourCard = true;					//같은 숫자가 4개면 isFourCard = true
			}else if(cardNumCnt[i] == 3) {
				isThreeCard = true;					//같은 숫자가 3개면 isThreeCard = true.
			}else if(cardNumCnt[i] == 2) {
				pairCnt++;							//같은 숫자가 2개면 pairCnt++
			}
			//스트레이트 확인.
			//cardNumCnt[i]	의 값이 1과 같고  cardNumCnt[i+1] ~ cardNumCnt[i+4] 까지 모두 1이면 isStraight = true.
			if(cardNumCnt[i] == 1) {					//cardNumCnt[i] == 1 ? 
				for(int j = i+1; j < 4; j++) {		    //--> cardNumCnt[i+1] == 1 && cardNumCnt[i+2] == 1 && cardNumCnt[i+3] == 1 && cardNumCnt[i+4] == 1
					if(cardNumCnt[j] == 1) {		
						isStraight = true;
					}else {								//배열 cardNumCnt에 저장되어있는 값이  0또는 2개 이상있으면 straight 성립 불가능하므로 더이상 검사하지않고 빠져나감.
						isStraight = false;
						break;
					}
				}
			}
		}
		//결과값 리턴. 높은 랭크부터 확인해서 리턴한다.
		if(isFlush && isStraight) {return "STRAIGHT FLUSH";}
		if(isFlush) {return "FLUSH";}
		if(isStraight) { return "STRAIGHT";}
		if(isThreeCard && pairCnt==1) { return "FULL HOUSE"; }
		if(isFourCard) { return "FOUR CARD";}
		if(isThreeCard) { return "THREE CARD";}
		if(pairCnt > 0) { return pairCnt+" PAIR"; }
		
		return "NO RANK";
	}
 
 @Test
//  같은 숫자가 2개 있으면 페어(pair)라고 한다.
//  페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
 void pairTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 3),
    new Card("CLUB", 4),
    new Card("SPADE", 5)   
   };
  System.out.println(checkRank(cArr));
   assertTrue(checkRank(cArr).equals("1 PAIR")); 
  }

 @Test
 // 같은 숫자가 2개 있으면 페어(pair)라고 한다.
 // 페어가 1개면 "1 PAIR"를 2개면 "2 PAIR"를 반환
 void pairTest2() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 3),
    new Card("CLUB", 4),
    new Card("SPADE", 4)   
   };
   assertTrue(checkRank(cArr).equals("2 PAIR")); 
  }

 @Test
 // 같은 숫자가 3개 있으면 쓰리카드("THREE CARD")라고 한다.
 void threeCardTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 1),
    new Card("CLUB", 4),
    new Card("SPADE", 5)   
   };
   assertTrue(checkRank(cArr).equals("THREE CARD")); 
  }

 @Test
 // 같은 숫자가 4개 있으면 포카드("FOUR CARD")라고 한다.
 void fourCardTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 1),
    new Card("CLUB", 1),
    new Card("SPADE", 4)   
   };
   assertTrue(checkRank(cArr).equals("FOUR CARD")); 
  }

 @Test
 // 쓰리카드와 원 페이가 같이 있으면 풀 하우스("FULL HOUSE")라고 한다.
 void fullHouseTest() {
  Card[] cArr = {
    new Card("SPADE", 1),
    new Card("DIAMOND", 1),
    new Card("HEART", 1),
    new Card("CLUB", 4),
    new Card("SPADE", 4)   
   };
   assertTrue(checkRank(cArr).equals("FULL HOUSE")); 
  }
 
 @Test
 // 카드의 숫자가 모두 연속인 경우 "STRAIGHT"를 반환
 // 1,2,3,4,5 또는 4,5,6,7,8 인 경우
 void straightTest() { 
  Card[] cArr = {
   new Card("SPADE", 1),
   new Card("DIAMOND", 2),
   new Card("HEART", 3),
   new Card("CLUB", 4),
   new Card("SPADE", 5)   
  };
  assertTrue(checkRank(cArr).equals("STRAIGHT")); 
 }

 @Test
 // 카드의 무늬가 모두 같은 경우 "FLUSH"를 반환
 void flushTest() { 
  Card[] cArr = {
   new Card("SPADE", 1),
   new Card("SPADE", 2),
   new Card("SPADE", 8),
   new Card("SPADE", 4),
   new Card("SPADE", 5)   
  };
  assertTrue(checkRank(cArr).equals("FLUSH")); 
 }
 
 @Test
 // 스트레이트 이면서 카드의 무늬가 모두 같은 경우 "STRAIGHT FLUSH"를 반환
 void straightFlushTest() { 
  Card[] cArr = {
   new Card("SPADE", 1),
   new Card("SPADE", 2),
   new Card("SPADE", 3),
   new Card("SPADE", 4),
   new Card("SPADE", 5)   
  };
  assertTrue(checkRank(cArr).equals("STRAIGHT FLUSH")); 
 }

 @Test
 // 어느 랭크(족보)에도 해당하지 않으면 NO RANK를 반환
 void noRankTest() { 
  Card[] cArr = {
   new Card("SPADE", 1),
   new Card("CLUB", 7),
   new Card("SPADE", 3),
   new Card("SPADE", 4),
   new Card("SPADE", 5)   
  };
  assertTrue(checkRank(cArr).equals("NO RANK")); 
 }

 
}

