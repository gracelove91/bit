package study0608.DataInputStreamEx1;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("bin/sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.read());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			
			dis.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}