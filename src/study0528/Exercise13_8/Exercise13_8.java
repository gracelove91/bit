package study0528.Exercise13_8;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class BouncingBall extends Frame{
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;
	
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 1;
	
	int x = 100;
	int y = 100;
	
	int xStep = SPEED;
	int yStep = SPEED;
	
	BouncingBall(String title){
		super(title);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		Insets insets = getInsets();	//프레임의 테두리 두께를 얻어온다.
	
		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
	}
	
	void start() {
		while(true) {
			x += xStep;
			y += yStep;
			System.out.println(x + ", " + y);
			if(x <= LEFT) {
				x = LEFT;
				xStep *= -1;
			}
			
			if(x >= RIGHT - BALL_SIZE) {
				x = RIGHT - BALL_SIZE;
				xStep *= -1;
			}
			
			if(y <= TOP) {
				y = TOP;
				yStep *= -1;
			}
			
			if(y >= BOTTOM - BALL_SIZE) {
				y = BOTTOM - BALL_SIZE;
				yStep *= -1;
			}
			
			repaint();
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// start()
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}

public class Exercise13_8{
	public static void main(String[] args) {
		new BouncingBall("ASD").start();
	}
}
