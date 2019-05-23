package study0522.ThreadEx67;

import javax.swing.JOptionPane;

public class ThreadEx7 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadEx7_1());
//		Thread t2 = new Thread( () ->    {
//			public void run() {
//				
//			}
//		});
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 10; i ++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(i+"메메");
				}
			}
		};
		t1.start();
		t2.start();
		
		String input = JOptionPane.showInputDialog("아무값이나입력하세요");		
		System.out.println("입력하신 값은 "+input+"입니다.");
	}
	
}
class ThreadEx7_1 implements Runnable{
	@Override
	public void run() {

		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
