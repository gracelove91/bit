package study0608.FileViewer;

import java.io.FileInputStream;
import java.io.IOException;
//java study0608/FileViewer/FileViewer study0608/FileViewer/FileViewer.class
//java study0608/FileViewer/FileViewer ../src/study0608/FileViewer/FileViewer.java
public class FileViewer {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(args[0]);
		int data = 0;
		
		while( (data = fis.read()) != -1) {
			System.out.printf("%02x ",data);
			
//			char c = (char)data;
//			System.out.print(c );
		}
	}
}
