package study0606.LambdaEx3;
@FunctionalInterface
interface MyFunction{
	void myMethod();
}
public class LambdaEx3 {
	int val = 10; // LambdaEx3.this.val
	
	class Inner{
		int val = 20; // this.val
		
		void method(int i) { //void method(final int i)
			int val = 30; //final int val = 30;
			i = 20;	
			
			MyFunction f = () -> {
				
			};
		}
	}
}
