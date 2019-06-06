package study0606.LambdaEx1;
@FunctionalInterface
interface MyFunction{
	void myMethod1();
}
public class LambdaEx1 {
	public static void main(String[] args) {
		MyFunction f = () -> System.out.println("메메");
		f.myMethod1();
		
		excute(f);
		
		Object o = (MyFunction)(() -> {});
		String s = ((Object)((MyFunction)(() -> {}))).toString();
	}
	
	static void excute(MyFunction f) {
		f.myMethod1();
	}
}
