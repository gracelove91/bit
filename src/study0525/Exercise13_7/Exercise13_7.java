package study0525.Exercise13_7;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exercise13_7 extends Frame implements MouseListener{
	final int LINE_NUM = 9; //오목판 줄 수.
	final int LINE_WIDTH = 30; //오목판 줄 간격.
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1); //오목판의 크기.
	final int STONE_SIZE = (int)(LINE_WIDTH * 0.8);     //돌의 크기.
	
	final int X0;
	final int Y0;
	
	final int FRAME_WIDTH;	//프레임의 폭.
	final int FRAME_HEIGHT; //프레임의 높이.
	
	Image img = null;
	Graphics gImg = null;
	 
	public Exercise13_7(String title) {
		super(title);
		
		//이벤트 핸들러 등록.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);;
			}
		});
		
		setVisible(true);		//프레임을 화면에 보이게한다.
		Insets insets = getInsets(); //화면에 보이기 전에는 insets의 값을 얻을 수 없다.
		
		//오목판이 그려질 위치(LEFT, TOP)의 좌표 XO, YO를 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.right + LINE_WIDTH;
		
		//프레임의 크기를 계산한다.
		FRAME_WIDTH = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
		FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;
		
		//프레임을 화면의 (100, 100)의 위치에 계산된 크기로 보이게한다.
		setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
		
		setResizable(false);
		drawBoard(gImg);
	}
	
	public void drawBoard(Graphics g) {
		for(int i = 0; i < LINE_NUM; i++) {
			g.drawLine(X0,Y0+i*LINE_WIDTH,X0+BOARD_SIZE, Y0+i*LINE_WIDTH);
			g.drawLine(X0+i*LINE_WIDTH,Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE);
		}
	}
	
	public void paint(Graphics g) {
		if(img == null) return;
		
		g.drawImage(img, 0, 0, this);		//가상화면에 그려진 그림을 프레임에 복사.
	}
	@Override
	public void mousePressed(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		System.out.println("x : "+x+", y : "+y);
		System.out.println(x*y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new Exercise13_7("OmokTest");
	}
	

}
