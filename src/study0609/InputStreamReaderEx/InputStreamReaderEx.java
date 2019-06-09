package study0609.InputStreamReaderEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
	public static void main(String[] args) {
		String line = "";
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("사용 중인 os의 인코딩 : "+ isr.getEncoding());
			
			do {
				System.out.print("문장을 입력하세요. 마치시려면 q를 입력하세요.");
				line = br.readLine();
				
				System.out.println("입력하신 문장 : "+line);
			}while(!line.equalsIgnoreCase("q"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
