package test_test;

public class ThreadTest {
	public static void main(String[] args) {
		ThreadEx1_2 t1 = new ThreadEx1_2();
		
		
	}
}

class ThreadEx1_1 extends Thread{
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}

class ThreadEx1_2 implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}
