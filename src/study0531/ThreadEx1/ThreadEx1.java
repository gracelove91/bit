package study0531.ThreadEx1;

public class ThreadEx1 {
	String str;
	int num;
	
	public static void main(String[] args) {

		ThreadEx1_1 t1 = new ThreadEx1_1();
		ThreadEx1_2 t2 = new ThreadEx1_2();
		
		t1.start();
		t2.start();
	}
	
	class InnerClass extends Thread{
		@Override
		public void run() {
			str = "asd";
			
		}
	}
}

class ThreadEx1_1 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.print("|");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadEx1_2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.print("-");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
