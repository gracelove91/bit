package study0603.Exercise14;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface MyFunction1{
	int max(int a, int b);
}
@FunctionalInterface
interface MyFunction2{
	void printVar(String name, int i);
}
@FunctionalInterface
interface MyFunction3{
	int square(int x);
}
@FunctionalInterface
interface MyFunction4{
	int roll();
}
@FunctionalInterface
interface MyFunction5{
	int sumArr(int[] arr);
}
@FunctionalInterface
interface MyFunction6{
	int[] emptyArr();
}
public class Exercise14_etc {

//	[14-1] 메서드를 람다식으로 변환하여 아래의 표를 완성하시오.
	int max(int a, int b) {
		return a > b ? a:b;
	}
//	MyFunction1 f = (a, b) -> {return a>b?a:b;};
	BinaryOperator<Integer> bf = (a,b) -> a>b?a:b;
	/////////////
	
	void printVar(String name, int i) {
		System.out.println(name + " = "+i);
	}
//	MyFunction2 f2 = (name , i) -> System.out.println(name + " = "+i);
	BiConsumer<String, Integer> bf2 = (name, i) -> System.out.println(name + " = " +i);
	///////////////
	
	int square(int x){
		return x * x;
	}
//	MyFunction3 f3 = (x) -> x*x;
	UnaryOperator<Integer> uf3 = (x) -> x*x;
	
	/////////////
	
	int roll() {
		return (int)(Math.random() * 6);
	}
//	MyFunction4 f4 = () -> (int)(Math.random() * 6);
	Supplier<Integer> s = () -> (int)(Math.random() * 6);
	
	/////////////
	
	int sumArr(int[] arr) {
		int sum = 0;
		for(int i : arr) {
			sum += i;
		}
		return sum;
	}
//	MyFunction5 f5 = (arr) -> {
//		int sum = 0;
//		for(int i : arr) {
//			sum +=i;
//		}
//		return sum;
//	};
//	Function<Integer, int[]> f = int[]::new;
	Function<int[], Integer> f = (arr) -> {
		int sum = 0;
		for(int num : arr) {
			sum+=num;
		}
		return sum;
	};
	
	///////
	
	int[] emptyArr() {
		return new int[] {};
	}
//	MyFunction6 f6 = () -> {return new int[] {};};
//	MyFunction6 f6 = int[]::new;
//	Supplier<int[]> s2 = int[]::new;
	Function<Integer, int[]> ff = int[]::new;
	
	
}
