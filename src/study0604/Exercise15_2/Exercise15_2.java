package study0604.Exercise15_2;

import java.io.BufferedReader;
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

		
	}
}
