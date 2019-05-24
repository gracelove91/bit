package study0523.Exercise11_10;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise11_10 {
	/**
	 * 
	 * [11-10] 다음 예제의 빙고판은 1~30사이의 숫자들로 만든 것인데, 
	 * 숫자들의 위치가 잘 섞이지 않는다는 문제가 있다. 
	 * 이러한 문제가 발생하는 이유와 이 문제를 개선하기 위한 방법을 설명하고, 
	 * 이를 개선한 새로운 코드를 작성하시오.
	 */
	
	
	//  ====> HashSet은 저장된 순서를 보장하지않고, 자체적인 저장방식에 따라 순서가 결정되기때문.
	//			저장순서를 유지하고싶으면 LinkedHashSet을 쓰자.
	//			math.random으로 토해낸 값이 순서대로 저장될 것이다. 그러므로 매번 숫자가 달라진다.
	public static void main(String[] args) {
		Set set = new LinkedHashSet();
		int[][] board = new int[5][5];
		for(int i = 0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 30) + 1 + "");
//			System.out.println(set + "==="+i);
		}
//		List list = new ArrayList(set);
		Iterator it = set.iterator();
		
		for(int i = 0; i < board.length; i++) {
			for(int j =0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt( (String)it.next() );
				System.out.print( (board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}
