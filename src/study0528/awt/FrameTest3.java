package study0528.awt;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//이벤트 처리방법.

//1 Frame의 닫기버튼 을 누르면 WindowEvent가 발생한다.(WindowEvent 인스턴스 생성.)
//2 Frame에 WindowListener로 등록되어있는 EventHandler windowClosing 메소드를 호출.
//  windowClosing() 메소드 내에서는 이벤트 발생시 생성된 WindowEvent인스턴스의 참조를 사용할 수 있어서 WindowEvent인스턴스의 메서드들을 사용할 수 있다.
public class FrameTest3 {
	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		
		//EventHandler클래스의 객체를 생성해서 Frame의 WindowListener로 등록한다.
		f.addWindowListener(new EventHandler());
		f.setVisible(true);
	}
}

class EventHandler implements WindowListener{

	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);	//이벤트가 발생한 소스는 Frame.
		e.getWindow().dispose(); 			//메모리에서 제거.
		System.exit(0);
				
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
