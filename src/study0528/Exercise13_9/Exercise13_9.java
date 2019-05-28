package study0528.Exercise13_9;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class BouncingBall extends Frame{
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;
	
	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 1;
	
	ArrayList<Ball> balls = new ArrayList<>();
	
	BouncingBall(String title){
		super(title);
		
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		Insets insets = getInsets();	//프레임의 테두리 두께를 얻어온다.
		
		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	void start() {
		new BallGenerator().start();
		
		while(true) {
			int size = balls.size();
			
			for(int i = 0; i < size; i++) {
				Ball b = balls.get(i);
				
				b.x += b.xStep;
				b.y += b.yStep;
				
				//x의 값이 왼쪽 테두리보다 작거나 같으면
				//x의 값을 LEFT로 바꾸고, x축 이동방향을 반대로.
				if(b.x <= LEFT) {
					b.x = LEFT;
					b.xStep *= -1;
				}
				
				//x의 값이 오른쪽 테두리보다 작거나 같으면
				//x의 값을 오른쪽 테두리로 바꾸고, x축 이동방향을 반대로한다.
				if(b.x >= RIGHT-Ball.SIZE) {
					b.x = RIGHT-Ball.SIZE;
					b.xStep *= -1;
				}
				
				//y의 값이 윗 쪽 테두리보다 작거나 같으면
				//y의 값을 윗쪽 테두리로 바꾸고 y축 방향 반대로.
				if(b.y <= TOP) {
					b.y = TOP;
					b.yStep *= -1;
				}
				
				//x의 값이 오른쪽 테두리보다 작거나 같으면
				//x의 값을 오른쪽 테두리로 바꾸고, x축 이동방향을 반대로한다.
				if(b.y >= BOTTOM-Ball.SIZE) {
					b.y = BOTTOM-Ball.SIZE;
					b.yStep *= -1;
				}
			}
			
			repaint();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// start()
	
	public void paint(Graphics g) {
		g.drawString("Number of balls : " +balls.size(), 20, 50);
		g.setColor(Color.red);
		
		int size = balls.size();
		
		for(int i = 0; i < size; i++) {
			Ball b = balls.get(i);
			g.fillOval(b.x, b.y, Ball.SIZE, Ball.SIZE);
		}
		
	}
	
	class BallGenerator extends Thread{
		@Override
		public void run() {
			/**
			 * 3초마다 Frame의 임의의 위치에 공을 생성해서 balls에 추가한다.
			 */
			
			//Frame의 임의의 위치? Math.Random으로 ball.x는 Math.random() * FRAME_width
			
			while(true) {
				int x = (int)(Math.random() * FRAME_WIDTH);
				int y = (int)(Math.random() * FRAME_HEIGHT);
				
				Ball ball = new Ball(x,y);
				
				balls.add(ball);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
			}
			
			
		}
	}
	
	class Ball{
		int x = 100;
		int y = 100;
		
		static final int SIZE = 30;
		
		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;
		
		Ball(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}

public class Exercise13_9{
	public static void main(String[] args) {
		new BouncingBall("ASD").start();
	}
}
