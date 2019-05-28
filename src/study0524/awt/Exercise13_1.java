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
	static int bingoCnt = 0;
	public static void main(String[] args) {
		Frame f = new Frame("GridLayoutTest");
		Button[][] bArr = new Button[5][5];			//버튼객체를 모아둔 배열선언.
		f.setSize(300, 300);
		f.setLayout(new GridLayout(5,5));
//		System.out.println(f.getLayout());
		Set<Integer> s = new LinkedHashSet<>();			//랜덤한 수를 저장하는 링크드해쉬셋(순서유지를 위해 링크드해쉬셋)
		//1에서 100까지의 랜덤한 수를 Set에 저장한다.
		for(int i = 0; s.size() < 25; i++) {					// 5*5 = 25
			int ranNum = (int)(Math.random() * 100) + 1;
			s.add(ranNum);
		}
		
		Iterator iter = s.iterator();
		
		//Set에 저장되어있는 숫자를 Button[i]의 라벨로 새롭게 저장한다.
		for(int i = 0; i < bArr.length; i++) {
			for(int j =0; j < bArr[i].length; j++) {
				bArr[i][j] = new Button(iter.next() + "");
				f.add(bArr[i][j]);
			}
		
		}

		f.setVisible(true);
		
		Button[] rowLine = new Button[bArr.length];						//행의 한 줄을 저장하는 배열.(ㅡ)
		Button[] colLine = new Button[bArr.length];						//열의 한 줄을 저장하는 배열.(|)
		Button[] acrossLine = new Button[bArr.length];					//왼쪽에서 시작하는 대각선 한 줄을 저장하는 배열.(\)
		Button[] anotherAcrossLine = new Button[bArr.length];				//오른쪽에서 시작하는 대각선 한 줄을 저장하는 배열.(/)
		

		
		for(int i = 0; i < bArr.length; i++) {
			for(int j = 0; j < bArr[i].length; j++) {
				bArr[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Button b = (Button) e.getSource();		//이벤트가 일어난 소스를 가져온다...
						b.setBackground(Color.LIGHT_GRAY);

						System.out.println(b.getLabel());
						System.out.println(b.getBackground());
						System.out.println("빙고개수 : " + bingoCnt);
					}
				});
				rowLine[j] = bArr[i][j];						//[0.1][0.2][0.3][0.4] ... 행(5x5)이므로 이중for문 내에 위치한다 
				colLine[j] = bArr[j][i];						//[1.0][2.0][3.0][4.0] ... 열(5x5)이므로 이중for문 내에 위치한다 
			
				if(new Exercise13_1().checkLineBingo(rowLine)) { bingoCnt++; }
				if(new Exercise13_1().checkLineBingo(colLine)) { bingoCnt++; }
				
			}
			acrossLine[i] = bArr[i][i];						//[0.0][1.1][2.2][3.3][4.4]	   대각선한줄(5x1)이므로 단일for문 내에 위치한다. 
			anotherAcrossLine[i] = bArr[i][bArr.length-i-1];	//[0.4][1.3][2.2][3.1][4.0]    대각선한줄(5x1)이므로 단일for문 내에 위치한다.
			if(new Exercise13_1().checkLineBingo(acrossLine)) { bingoCnt++; }
			if(new Exercise13_1().checkLineBingo(anotherAcrossLine)) { bingoCnt++; }
			
		}
		
		
		
		
	}
	//bingo체크. 한열씩 보내서 겟백그라운드로 컬러가 모두 라이트그레이라면 빙고+1
	boolean checkLineBingo(Button[] line) {	//한 줄이 모두 1인지 검사해서 참이면 true, 아니면 false반
		
		for(int i = 0; i < line.length; i++) {
			if(!(line[i].getBackground().equals(Color.LIGHT_GRAY) )) {
				return false;				// 더 검사할 필요 없이 false	리턴.
			}
		}
		return true;
	}
}


