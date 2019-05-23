package test_test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GenericWildCardTest {
	public static void main(String[] args) {
		Set<?> c = new HashSet<>();
//		c.add(new String("123"));
		numElementsInCommon(c, c);
	}
	
	static int numElementsInCommon(Collection<?> s1, Set<?> s2) {
		s1.add("123");
		return 1;
	}
}
