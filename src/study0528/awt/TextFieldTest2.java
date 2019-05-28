package study0528.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldTest2 extends Frame {
	Label lid;
	Label lpwd;
	TextField tfId;
	TextField tfPwd;
	Button ok;
	
	TextFieldTest2(String title){
		super(title);	//Frame(String title)
		
		lid = new Label("ID : ", Label.RIGHT); //Label의 오른쪽정렬.
		lpwd = new Label("Password : ",Label.RIGHT);
		
		//약 10개의 글자를 입력할 수 있는 TextField 생성.
		tfId = new TextField(10);
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*'); 		//입력한 값 대신 '*'
		
		ok = new Button("OK");
		// ok버튼과 TextField에 이벤트처리를 위한 Listener를 추가해준다.
		tfId.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		ok.addActionListener(new EventHandler());
		
		setLayout(new FlowLayout()); //LayoutManager를 FlowLayout으로.
		add(lid);			//생성한 Component들을 Frame에 포함시킨다.
		add(tfId);
		add(lpwd);
		add(tfPwd);
		add(ok);
		setSize(450, 65);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TextFieldTest2 f = new TextFieldTest2("Login");
	}
	
	//인스턴스 클래스.
	class EventHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = tfId.getText();
			String pwd = tfPwd.getText();
			if(!id.equals("eunmo")) {
				System.out.println("입력하신 id가 유효하지 않습니다. 다시 입력하세요. ");
				
				//id를 다시 입력할 수 있도록 focus를 tfId로 옮긴다.
				tfId.requestFocus();
				tfId.selectAll(); 
			}else if(!pwd.equals("asdf")) {
				System.out.println("입력하신 비밀번호가 유효하지 않습니다.");
				
				tfPwd.requestFocus();
				tfPwd.selectAll();
			}else {
				System.out.println(id+"님, 로그인성공.");
			}
		}
	}
}

