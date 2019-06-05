package study0604.Exercise15_2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Exercise15_2 {
/**
 * 지정된 이진파일의 내용을 실행결과와 같이 16진수로 보여주는 프로그램
(HexaViewer.java)을 작성하라. 
[Hint] PrintStream과 printf()를 사용하라.
 * @throws IOException 
 */
	
	public static void main(String[] args) throws IOException {
		File f = new File(".");
		System.out.println(f.getCanonicalPath());
		String path = f.getCanonicalPath();
		path += "/bin/study0604/Exercise15_2/Exercise15_2.class";
		
		File f2 = new File(path);
		//
		FileInputStream fis = new FileInputStream(f2);
//		PrintStream ps = new PrintStream(f2);
		
		int data = 0;
		int count = 0;
		while((data = fis.read()) != -1) {
			count++;
			System.out.printf("%02x ", data);
			if(count % 16 == 0) {
				System.out.println();
			}
		}
			
	}
}
