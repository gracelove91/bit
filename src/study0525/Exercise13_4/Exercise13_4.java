package study0525.Exercise13_4;

import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise13_4{
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setBounds(200, 200, 300, 70);
		f.setVisible(true);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 kk시 mm분 ss초");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					f.setTitle(sdf.format(new Date()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.setDaemon(true);
		t1.start();
	}
}
