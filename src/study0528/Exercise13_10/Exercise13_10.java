package study0528.Exercise13_10;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	
	int x;
	int y;
	
	final int SPEED = 3;
	int xStep = SPEED;
	int yStep = SPEED;
	
	BouncingBall(String title){
		super(title);
		
		x = FRAME_WIDTH/2 - BALL_SIZE/2;
		y = FRAME_WIDTH/2 - BALL_SIZE/2;
		
		setVisible(true);
		setBounds(300, 200, FRAME_WIDTH, FRAME_HEIGHT);
		
		Insets insets = getInsets();
		TOP = insets.top;
		LEFT = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT = FRAME_WIDTH - insets.right;
		
		registerEventHandler();
		setResizable(false);
	}
	
	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				int key = ke.getKeyCode();
				
				
				if(key == KeyEvent.VK_UP) {
					System.out.println("UP");
					y -= yStep;
					if(y + BALL_SIZE <= TOP) {
						y = BOTTOM;
					}
				}else if(key == KeyEvent.VK_DOWN) {
					System.out.println("DOWN");
					y += yStep;
					if(y >= BOTTOM) {
						y = TOP;
					}
				}else if(key == KeyEvent.VK_LEFT) {
					x -= xStep;
					if(x + BALL_SIZE <= LEFT) {
						x = RIGHT;
					}
					System.out.println("LEFT");
				}else if(key == KeyEvent.VK_RIGHT) {
					x += xStep;
					if(x >= RIGHT) {
						x = LEFT;
					}
					System.out.println("RIGHT");
				}
			}
		});
	}
	
	void start() {
		while(true) {
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}

public class Exercise13_10 {
	public static void main(String[] args) {
		new BouncingBall("ADSX").start();
	}

}
