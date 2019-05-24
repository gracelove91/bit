package study0523.Exercise11_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Exercise11_1 {
	/**
	 * 
	 * 
[11-1] 다음은 정수집합 1,2,3,4와 3,4,5,6의 
교집합, 차집합, 합집합을 구하는 코드이다. 
코드를 완성하여 실행결과와 같은 결과를 출력하시오. 
[Hint] ArrayList클래스의 addAll(), removeAll(), retainAll()을 사용하라.
	 */
	@SuppressWarnings({ "rawtypes","unchecked" })
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList();
		ArrayList cha = new ArrayList();
		ArrayList hap = new ArrayList();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		

		//합집합을 구한다.
		hap.addAll(list1);
		hap.addAll(list2);
		Set<Integer> set = new HashSet<>(hap);
		hap = new ArrayList<>(set);
		//교집합을구한다.]
		kyo = new ArrayList<>(hap);
		kyo.retainAll(list2);
		kyo.retainAll(list1);
		//차집합을 구한다.
		cha = new ArrayList<>(hap);
		cha.removeAll(list2);
		
		
		
		System.out.println("list1 = "+list1);
		System.out.println("list2 = "+list2);
		System.out.println("kyo = "+kyo);
		System.out.println("cha = "+cha);
		System.out.println("hap = "+hap);
	}
}
