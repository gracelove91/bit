package study0604.Exercise15_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Exercise15_1 {
	public static void main(String[] args) throws IOException {
		int maxLine = Integer.parseInt(args[0]);
		String fileName = args[1];
		String currentPath = "/Users/govlmo91/workspace/bit/src/study0604/Exercise15_1/";

		File f = new File(currentPath + fileName);
		if (f.isDirectory() || !f.exists()) {
			System.out.println(fileName + "은/는 디렉토리거나, 존재하지않는 파일입니다.");
			System.out.println(f.getCanonicalPath());
			System.exit(0);
		}

		FileReader fr =new FileReader(f);
		
		BufferedReader br = new BufferedReader(fr);

		String line = "";
		for (int i = 1; i <= maxLine; i++) {
			line = br.readLine();
			if (line == null)
				break;
			

			System.out.println(i + " : " + line);
		}
		
		br.close();

	}
}
