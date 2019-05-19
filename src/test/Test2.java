//package test;
//
//public class Test2 {
//	public static void main(String[] args) {
//		
//		SecFor f1 = new SecFor();
//		FirstFor f2 = new FirstFor();
//
//		f1.setPriority(Thread.MAX_PRIORITY);
//		f2.setPriority(Thread.MAX_PRIORITY);
//		
//		f2.start();
//		f1.start();
//		
//		
//	}
//}
//
//
//class FirstFor extends Thread{
//	
//	@Override
//	public void run() {
//		long start = System.currentTimeMillis();
//		for(long i = 0, y = new Integer(1), sum = 0; i < 10000000000L; i++) {
//			sum +=y;
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("FirstFor : " + (end-start));
//	}
//}
//
//class SecFor extends Thread{
//	
//	@Override
//	public void run() {
//		long start = System.currentTimeMillis();
//		for(long i = 0, sum = 0; i < 10000000000L; i++) {
//			Integer y = new Integer(1);
//			sum += y;
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("SecFor : " + (end-start));
//	}
//}

package test;

public class Test2 {
	public static void main(String[] args) {
		
		FirstFor f2 = new FirstFor();
		SecFor f1 = new SecFor();

		f1.setPriority(Thread.MAX_PRIORITY);
		f2.setPriority(Thread.MAX_PRIORITY);
		
		f2.start();
		f1.start();
	}
}


class FirstFor extends Thread{
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		for(long i = 0, y = MethodClass.method(), sum = 0; i < 10000000L; i++) {
			sum += y;
		}
		long end = System.currentTimeMillis();
		System.out.println("FirstFor : " + (end-start));
	}
}

class SecFor extends Thread{
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		for(long i = 0, sum = 0; i < 10000000L; i++) {
			int y = MethodClass.method();
			sum += y;
		}
		long end = System.currentTimeMillis();
		System.out.println("SecFor : " + (end-start));
	}
}

class MethodClass{
	static int method() {
		int num = 0;
		for(long i =0; i < 10; i++) {
			num+=i;
		}
		return num;
	}
}