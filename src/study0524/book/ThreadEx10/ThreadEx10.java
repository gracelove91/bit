package study0524.book.ThreadEx10;

public class ThreadEx10 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		StackTraceElement[] stes =  Thread.currentThread().getStackTrace();
		for(StackTraceElement e : stes) {
			System.out.println(e);
		}
		System.out.println("----------------------");
		Thread t = new Thread(new ThreadEx10());
//		t.setDaemon(true);
		t.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(i);

			if (i == 5) {
				autoSave = true;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	@Override
	public void run() {
		StackTraceElement[] stes =  Thread.currentThread().getStackTrace();
		for(StackTraceElement e : stes) {
			System.out.println(e);
		}
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//autoSave의 값이 true면 autoSave()호출.
			if(autoSave) {
				autoSave();
			}
		}
	}
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}

class ThreadExx extends Thread{
	
}
