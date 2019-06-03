package study0603.LambdaEx4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LambdaEx4 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(i);
		}
		
		list.forEach(i -> System.out.print(i));
		System.out.println();
		
		list.removeIf(i -> i % 2 == 0 || i%3==0);
		System.out.println(list);
		System.out.println();
		
		list.replaceAll( i -> i*10);
		System.out.println(list);
		System.out.println();
		
		Map<String, String> map = new HashMap<>();
		map.put("1","1");
		map.put("2","2");
		map.put("3","3");
		map.put("4","4");
		
		map.forEach((key, value) -> System.out.println("key : "+ key + ", value : "+value ));
		System.out.println();
		
		
	
	}
	
}
