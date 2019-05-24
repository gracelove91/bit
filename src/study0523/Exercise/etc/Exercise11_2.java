package study0523.Exercise.etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_2 {
/**
 * [11-2] 다음 코드의 실행결과를 적으시오.
 * */
	//list.add(3) .......... .        --> 3,6,2,2,2,7
	//HashSet set = new HashSet(list) --> 3, 6, 2 ,7   --> 찍어보니 정렬되서 나옴..
	//TreeSet tset = new TreeSet(set) --> 2, 3, 6, 7
	//Stack stack = new Stack();
	//stack.addAll(tset);
	//stack.pop                       --> 7,6,3,2 순서대로 출력.
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		
//		System.out.println(list);
		
		HashSet set = new HashSet(list);
//		System.out.println(set);
		TreeSet tset = new TreeSet(set);
//		System.out.println(tset);
		Stack stack = new Stack();
		stack.addAll(tset);
		
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
		
	}
}
