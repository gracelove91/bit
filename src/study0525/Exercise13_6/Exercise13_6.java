package study0525.Exercise13_6;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;


public class Exercise13_6 extends Frame{
	Panel pUp = new Panel();
	Panel pDate = new Panel();
	
	Button btnPrevMon = new Button("<");
	Button btnNextMon = new Button(">");
	Label lblYearMon = new Label();
	
	Button[] btnArr = new Button[42];
	Calendar curMon = Calendar.getInstance();
	
	Exercise13_6(String title){
		super(title);
		
		pUp.setBackground(Color.yellow);	//패널의 색깔은 노란색.
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);				//패널에 btnPrevMon(버튼)추가.
		pUp.add(lblYearMon);				//패널에 lblYearMon(레이블.)추가.
		pUp.add(btnNextMon);				//패널에 btnNextMon(버튼)추가.

		pDate.setLayout(new GridLayout(6,7));
		for(int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}
		
		btnPrevMon.addActionListener(new BtnEventHandler());	//btnPrevMon에 리스너 달아줌.
		btnNextMon.addActionListener(new BtnEventHandler());
		
		//윈도우창 닫기버튼 누르면 꺼지는 리스너.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});
		
		add(pUp, "North");						//frame에pUP패널 달아준다.
		add(pDate, "Center");
		setBounds(200, 200, 500, 300);	//Moves and resizes this component.
		setDays(curMon);				//사용자정의클래스의 메서드에 Calendar인스턴스 전달.
		setVisible(true);
		
	} // Exercise13_6
	//Calendar 인스턴스 받아서 lable을 변경시켜준다아아아아아아아아아아아아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
	void setDays(Calendar date) {
	
	}
	
	//내부클래스??
	class BtnEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			
		}
	}
	
	public static void main(String[] args) {
		Exercise13_6 mainWin = new Exercise13_6("Scheduler");
	}
	
}
