package study0603.BufferedOutputStreamEx1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			//BufferedOutputStream	의 버퍼크기를 5로한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			//파일 123.txt	에 1부터 9까지출력한다.
			for(int i = 1; i <= 100; i++) {
				System.out.println((char)i);
				bos.write(i);
			}
			
			bos.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
