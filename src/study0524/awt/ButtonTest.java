package study0524.awt;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest {
	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		
		Button b = new Button("확 인");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Button tmp = (Button) e.getSource();
				System.out.println(tmp.getLabel());
				
			}
			
		});
		b.setSize(100, 50);
		
		f.add(b);
		f.setVisible(true);
	}
}
