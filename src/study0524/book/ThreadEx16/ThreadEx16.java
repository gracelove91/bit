package study0524.book.ThreadEx16;

public class ThreadEx16 {
	
	public static void main(String[] args) {

		RunImpleEx16 r1 = new RunImpleEx16();
		RunImpleEx16 r2 = new RunImpleEx16();
		RunImpleEx16 r3 = new RunImpleEx16();
		Thread th1 = new Thread(r1, "*");
		Thread th2 = new Thread(r2, "**");
		Thread th3 = new Thread(r3, "***");
		
		Thread tmp = new Thread();
		tmp.start();
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(1000);
			r1.suspend();
			Thread.sleep(1000);
			r2.suspend();
			Thread.sleep(1000);
			r1.resume();
			Thread.sleep(1000);
			r1.stop();
			r2.stop();
			Thread.sleep(1000);
			r3.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getState()); 
	}
	
}

class RunImpleEx16 implements Runnable{
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	@Override
	public void run() {
		while(!stopped) {
			if(!suspended) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " -- stopped");
	}
	
	public void suspend() { suspended = true; }
	public void resume()  { suspended = false; }
	public void stop()    { stopped = true;}
}
