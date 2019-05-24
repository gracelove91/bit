package study0524.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Exercise13_1 {
/*
 * [13-1] 아래의 실행결과처럼 가로 세로 크기가 5인 빙고판을 만드시오 
 * 그리고 버튼을 누르면 버튼의 배경색이 밝은 회색(Color.LIGHT_GRAY) 으로 바뀌고 
 * 누른 버튼의 글자가콘솔에 출력되게 하시오.
 */
	public static void main(String[] args) {
		Frame f = new Frame("GridLayoutTest");
		Button[] bArr = new Button[5*5];
		f.setSize(300, 300);
		f.setLayout(new GridLayout(5,5));
		
		Set<Integer> s = new LinkedHashSet<>();
		//1에서 100까지의 랜덤한 수를 Set에 저장한다.
		for(int i = 0; s.size() < 25; i++) {
			int ranNum = (int)(Math.random() * 100) + 1;
			s.add(ranNum);
		}
		
		Iterator iter = s.iterator();
		
		//Set에 저장되어있는 숫자를 Button[i]의 라벨로 새롭게 저장한다.
		for(int i = 0; i < s.size(); i++) {
			bArr[i] = new Button(iter.next() + "");
			f.add(bArr[i]);
		}

		f.setVisible(true);

		for(Button b : bArr) {
			b.addActionListener(new ButtonListener());			
		}
		
	}
}
class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		b.setBackground(Color.LIGHT_GRAY);
		System.out.println(b.getLabel());
		
	}
	
}