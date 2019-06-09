package study0609.BufferedReaderEx1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderEx1 {
	public static void main(String[] args) {
		try {
			File f = new File("./src/study0609/");
			System.out.println(f.exists());
			System.out.println(f.getCanonicalPath());
			FileReader fr = new FileReader("./src/study0609/BufferedReaderEx1/BufferedReaderEx1.java");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			for(int i = 1; (line = br.readLine() ) != null; i++) {
				//";"를 포함한 라인만 출력한다.
				if(line.indexOf(";") != -1) {
					System.out.println(i+":"+line);
				}
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
