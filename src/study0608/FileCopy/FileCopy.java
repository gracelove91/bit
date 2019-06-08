package study0608.FileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
// java study0608/FileCopy/FileCopy ../src/study0608/FileCopy/FileCopy.java FileCopy.txt
public class FileCopy {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream(args[0]);		//파일을 읽어서 프로그램에 저장할거야.
			FileOutputStream fos = new FileOutputStream(args[1]);	//프로그램에 저장된 내용을 args[1]에 저장할거야.
			
			int data = 0;
			while ( (data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
