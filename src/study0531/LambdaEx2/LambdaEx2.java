package study0531.LambdaEx2;
@FunctionalInterface
interface MyFunction{
	void myMethod(); //public abstract void myMethod();
}
public class LambdaEx2 {
	public static void main(String[] args) {
		MyFunction f = () -> {};
		Object obj = (MyFunction)( () -> {} );
		String str = ( (Object)(MyFunction)( () -> {} ) ).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(( () -> {} );   //람다식은 Object타입으로 형변환 안됨. 
		
	}
}
