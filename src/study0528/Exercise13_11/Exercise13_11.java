package study0528.Exercise13_11;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

class BouncingBall extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 7;

	int x;
	int y;
	boolean isPlaying = true;
	ArrayList<Ball> balls = new ArrayList<>();

	BouncingBall(String title) {
		super(title);

		x = FRAME_WIDTH / 2 - BALL_SIZE / 2;
		y = FRAME_HEIGHT / 2 - BALL_SIZE / 2;

		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);

		Insets insets = getInsets();

		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;

		registerEventHandler();
	}

	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		addKeyListener(new KeyAdapter() {
			//회색공이어야한다아아아아
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (!isPlaying)
					return;

				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_UP) {
					y-=2;
					if (y + BALL_SIZE <= TOP) {
						y = BOTTOM;
					}
				} else if (key == KeyEvent.VK_DOWN) {
					y+=2;
					if (y >= BOTTOM) {
						y = TOP;
					}
				} else if (key == KeyEvent.VK_LEFT) {
					x-=2;
					if (x + BALL_SIZE <= LEFT) {
						x = RIGHT;
					}
				} else if (key == KeyEvent.VK_RIGHT) {
					x+=2;
					if (x >= RIGHT) {
						x = LEFT;
					}
					System.out.println("RIGHT");
				}
			}
		});
	}

	void start() {
		new BallGenerator().start();

		while (true) {
			int size = balls.size();

			for (int i = 0; i < size; i++) {
				Ball b = balls.get(i);

				b.x += b.xStep;
				b.y += b.yStep;

				// x의 값이 왼쪽 테두리보다 작거나 같으면
				// x의 값을 LEFT로 바꾸고, x축 이동방향을 반대로.
				if (b.x <= LEFT) {
					b.x = LEFT;
					b.xStep *= -1;
				}

				// x의 값이 오른쪽 테두리보다 작거나 같으면
				// x의 값을 오른쪽 테두리로 바꾸고, x축 이동방향을 반대로한다.
				if (b.x >= RIGHT - b.size) {
					b.x = RIGHT - b.size;
					b.xStep *= -1;
				}

				// y의 값이 윗 쪽 테두리보다 작거나 같으면
				// y의 값을 윗쪽 테두리로 바꾸고 y축 방향 반대로.
				if (b.y <= TOP) {
					b.y = TOP;
					b.yStep *= -1;
				}

				// x의 값이 오른쪽 테두리보다 작거나 같으면
				// x의 값을 오른쪽 테두리로 바꾸고, x축 이동방향을 반대로한다.
				if (b.y >= BOTTOM - b.size) {
					b.y = BOTTOM - b.size;
					b.yStep *= -1;
				}
			} // for

			repaint();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	boolean collisingCheck(Ball b) {

		/**
		 * 
		 * 구현해야할부분.
		 */
		int distance = 0;
		/**
		 * 회색공의 중심과 빨간 공의 중심간의 거리(distance)가
		 * 회색공의 반지름(BALL_SIZE / 2)과 빨간공의 반지름 (b.size/2)보다 같거나 작으면
		 * true를 반환하고 그렇지 않으면 false를 반환한다.
		 * 
		 * 회색공의 위치가 (x,y)일 때,
		 * 중심좌표는 (x + BALL_SIZE/2,  y + BALL_SIZE/2)이다.
		 * 두 점 (x1, y1) 과 (x2, y2) 간의 거리는 아래 공식으로 구할 수 있다.
		 * Math.sqrt( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2)
		 */
		distance = BALL
		
		

	}

	public void paint(Graphics g) {
		g.drawString("Number of balls : " + balls.size(), 20, 50);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);

		g.setColor(Color.red);

		int size = balls.size();

		for (int i = 0; i < size; i++) {
			Ball b = balls.get(i);
			g.fillOval(b.x, b.y, b.size, b.size);
		}
	}

	class BallGenerator extends Thread {
		@Override
		public void run() {

			while (true) {
//				int x = (int)(Math.random() * FRAME_WIDTH);
				int x = (int) (Math.random() * (RIGHT - LEFT - Ball.MAX_SIZE)) + LEFT;
				int y = (int) (Math.random() * (BOTTOM - TOP - Ball.MAX_SIZE)) + TOP;

				Ball ball = new Ball(x, y);

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

	class Ball {
		int x = 100;
		int y = 100;
		int size = 30;

		static final int MAX_SIZE = 30;
		static final int MIN_SIZE = 10;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this(x,y, (int)(Math.random() * (MAX_SIZE-MIN_SIZE)) + MIN_SIZE);
		}

		Ball(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
}

public class Exercise13_11 {
	public static void main(String[] args) {
		new BouncingBall("DSAFdkjdfzgdfsjk").start();
	}
}
