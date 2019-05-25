package study0522.ThreadEx1;

public class ThreadEx1 {
	public static void main(String[] args) throws InterruptedException {
		ThreadEx1_2 t1 = new ThreadEx1_2();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);

		Thread t3 = new Thread1_3();
		
		t1.start();
		Thread.sleep(500);
		t2.start();
		Thread.sleep(500);
		t3.start();
		Thread.sleep(500);
		
		
		System.out.println();
		System.out.println("Main 스택 시작.");
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(StackTraceElement s : stackTraceElements) {
			System.out.println(s.toString());
		}
		System.out.println();
		System.out.println("Main 스택 끝.");
		System.out.println();
		
		System.out.println("=====메인메소드(메인쓰레드) 끝!=====");
		System.out.println();
		
	
	}
}

class ThreadEx1_1 extends Thread{
	@Override
	public void run() {
		System.out.println();
		System.out.println("ThreadEx1_1 스택 시작.");
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(StackTraceElement s : stackTraceElements) {
			System.out.println(s.toString());
		}
		System.out.println();
		System.out.println("ThreadEx1_1 스택 끝.");
		System.out.println();
		for(int i = 1; i <= 5; i++) {
			System.out.println("ThreadEx1_1 run()호출 : "+i+"번째." );
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public synchronized void start() {
		System.out.println("ThreadEx1_1 start()호출.");
		super.start();
	}
}
class ThreadEx1_2 extends Thread{
	@Override
	public void run() {
		System.out.println();
		System.out.println("ThreadEx1_2 스택 시작.");
		System.out.println();
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(StackTraceElement s : stackTraceElements) {
			System.out.println(s.toString());
		}
		System.out.println();
		System.out.println("ThreadEx1_2 스택 끝.");
		System.out.println();
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("ThreadEx1_2 run()호출 : "+i+"번째." );
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public synchronized void start() {
		System.out.println("ThreadEx1_2 start()호출.");
		super.start();
	}
}
class Thread1_3 extends Thread{
	@Override
	public void run() {
		System.out.println();
		System.out.println("ThreadEx1_3 스택 시작.");
		System.out.println();
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		
		for(StackTraceElement s : stackTraceElements) {
			System.out.println(s.toString());
		}
		System.out.println("ThreadEx1_3 스택 끝 .");
		System.out.println();
		
		for(int i = 1; i <= 5; i++) {
			System.out.println("ThreadEx1_3 run()호출 : "+i+"번째." );
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public synchronized void start() {
		System.out.println("ThreadEx1_3 start()호출.");
		super.start();
	}
}
