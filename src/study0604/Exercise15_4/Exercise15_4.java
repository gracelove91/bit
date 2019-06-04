package study0604.Exercise15_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise15_4 {
/**
 * 커맨드라인으로 부터 여러 파일의 이름을 입력받고, 
 * 이 파일들을 순서대로 합쳐 서 
 * 새로운 파일을 만들어 내는 프로그램(FileMergeTest.java)을
 *  작성하시오. 
 *  단, 합칠 파일의 개수에는 제한을 두지 않는다.
 * @throws IOException 
 * 
 */
	
	public static void main(String[] args) throws IOException {
		File[] files = new File[args.length];	//files[0]은 새로 만들 파일이다.
		files[0] = new File(args[0]);
		
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = new FileWriter(files[0]);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 1; i < args.length; i++) {
			files[i] = new File(args[i].trim());
			fr = new FileReader(files[i]);
			br = new BufferedReader(fr);
			
			
			
			String line = "";
			while( (line = br.readLine()) != null) {
				System.out.println(line);
				bw.append(line);
			}
			
//			FileWriter fw = new FileWriter(files[0]);
//			BufferedWriter bw = new BufferedWriter(fw);
//			String line = "";
//			while((line = br.readLine()) != null) {
//				System.out.println(line);
//				bw.write(line);
//			}
		}
		
		bw.close();
		
		
		//sb에 저장된 문자들을 새로운 파일로.
	
		
		
		
//		String line = "";
//		File f = new File("1.txt");
//		fr = new FileReader(f);
//		br = new BufferedReader(fr);
//		while((line = br.readLine()) != null) {
//			System.out.println(line);
//		}
		
	}
}
