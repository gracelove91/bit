package study0528.awt;

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
import java.awt.event.WindowListener;
import java.util.Calendar;

public class Exercise13_6 extends Frame{
	Panel pDate = new Panel();			
	Panel pUp = new Panel();
	
	Button btnPrevMon = new Button("<");
	Button btnNextMon = new Button(">");
	Label lblYearMon = new Label();
	
	Button[] btnArr = new Button[42];
	
	Calendar curMon = Calendar.getInstance();
	
	Exercise13_6(String title){
		super(title);
		
		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);
		
		pDate.setLayout(new GridLayout(6, 7));
		for(int i = 0; i < btnArr.length; i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}
		
		//액션리스너 달기.
		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
			

		add(pUp, "North");
		add(pDate, "Center");
		setBounds(200, 200, 500, 300); // width 500, height 300 크기로 200.200 위치.
		setDays(curMon);
		setVisible(true);
	}
	//Calendar date받아서 pUp패널의 라벨 변경. & 버튼에 날짜 입력.
	void setDays(Calendar date) { // setDay(curMon)
		int year = date.get(Calendar.YEAR);			//현재시각은 19년 5월 28일 이므로 year는 2019
		int month = date.get(Calendar.MONTH);		//MONTH는 0부터시작. 따라서 지금은 5월이니 MONTH는 4.
		
		lblYearMon.setText(year+"년 "+(month+1)+"월");
		
		Calendar sDay = Calendar.getInstance();	//시작일.
		
		sDay.set(Calendar.MONTH, 1);
		
	}
	
	public static void main(String[] args) {
		Exercise13_6 mainWin = new Exercise13_6("SSS");
	}
	
	//이벤트 처리위한 내부클래스.
	class BtnEventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Button clickedBtn = (Button)e.getSource();
			if(clickedBtn.getLabel().equals(">")) {
				curMon.add(Calendar.MONTH, 1);
			}else if(clickedBtn.getLabel().equals("<")) {
				curMon.add(Calendar.MONTH, -1);
			}
			setDays(curMon);
		}
	}
}
