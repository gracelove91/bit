package study0525.Exercise13_1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise13_1 {
	
	public static void main(String[] args) {
		String[][] str = {
				{"참새", "두루미","황새","비둘기","까오기"},
				{"오리","타조","부엉이","올빼미","뱁새"},
				{"꿩","닭","구관조","잉꼬","매"},
				{"거위","독수리","콘돌","봉황","공작"},
				{"까치","까마귀","앵무새","꾀꼬리","고니"}
			};
		
		Frame f = new Frame("GridLayoutTest");
		Button[][] bArr = new Button[5][5];			//버튼객체를 모아둔 배열선언.
		f.setSize(300, 300);
		f.setLayout(new GridLayout(5,5));
		
		
		//버튼 초기화해주고, frame에 달아준다.
		for(int i = 0; i < bArr.length; i++) {
			for(int j = 0; j < bArr[i].length; j++) {
				bArr[i][j] = new Button(str[i][j]);
				f.add(bArr[i][j]);
			}
		}
		f.setVisible(true);
		//클릭시 배경색 회색으로 바꾸는 for문.
		
		int bingoCnt = 0;
		Exercise13_1 eee = new Exercise13_1();
		for(int i = 0; i < bArr.length; i++) {
			for(int j = 0; j < bArr[i].length; j++) {
				int x = i;
				int y = j;
				bArr[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Button b = (Button)e.getSource();
						b.setBackground(Color.LIGHT_GRAY);
						System.out.println(bArr[x][y]+"를 클릭했읍니다요.");
					}
				});
			}
		}
	}

	// 빙고체크.
	public boolean chkBingo(Button[] bingoArr) {
		boolean isBingo = true;
		for (int i = 0; i < bingoArr.length; i++) {
			if (!(bingoArr[i].getBackground().equals(Color.LIGHT_GRAY))) {
				isBingo = false;
				return isBingo;
			}
		}
		return isBingo;
	}
	//빙고를 채우는 메서드.
	public void fillBIngo(Button[][] bingoArr, String[][] words) {
		for(int i = 0; i < bingoArr.length; i++) {
			for(int j = 0; j < bingoArr[i].length; j++) {
				bingoArr[i][j].setLabel(words[i][j]);
			}
		}
	}
}
