package study0608.FileReaderEx1;

import java.io.FileInputStream;
import java.io.FileReader;

public class FileReaderEx1 {
	public static void main(String[] args) {
		String fileName = "test.txt";
		try(FileInputStream fis = new FileInputStream(fileName);
				FileReader fr = new FileReader(fileName)
				){
			int data = 0;
			//FileInputStream을 이용해 파일내용을 읽어서 출력한다.
			while ( (data = fis.read()) != -1 ) {
				System.out.print((char)data);
			}
			System.out.println();
			System.out.println("--------------------");
			
			
			//FileReader를 이용해 파일내용을 읽엏서 출력한다.
			while( (data = fr.read()) != -1) {
				System.out.print((char)data);
			}
			System.out.println();
			
			
		}catch(Exception e) {
			
		}
	}
}
