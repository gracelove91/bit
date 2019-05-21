package study0521;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
	}
}

class Descending implements Comparator<Comparable>{
	
	@Override
	public int compare(Comparable o1, Comparable o2) {
		return o2.compareTo(o1);
	}

}
