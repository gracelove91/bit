package study0604.TcpIpClient;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {
	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			System.out.println("서버에 연결 중입니다. 서버 IP : "+serverIp);
			
			//소켓을 생성하여 연결요청.
			Socket socket = new Socket(serverIp, 7777);
			
			//소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			dis.close();
			socket.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
