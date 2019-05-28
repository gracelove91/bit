package study0528.awt;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsEx3 extends Frame implements MouseMotionListener{
	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		new GraphicsEx3("GraphicsEx3");
	}
	
	GraphicsEx3(String title){
		super(title);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("마우스를 움직여보삼!",10, 50);
		g.drawString("*", x, y);
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
	////////////////MouseMotionListener.
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}
	
}
