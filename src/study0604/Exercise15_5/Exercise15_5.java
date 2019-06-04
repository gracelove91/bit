package study0604.Exercise15_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/*
 * 다음은 FilterWriter를 상속받아서 직접 구현한 
 * HtmlTagFilterWriter를 사용해서 
 * 주어진 파일에 있는 태그를 모두 제거하는 프로그램이다. 
 * HtmlTagFilterWriter의 write()가 태그를 제거하도록 
 * 코드를 완성하시오.
 */
public class Exercise15_5 {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("USAGE : java Exercise15_5 RESULT_FILE");
			System.exit(0);
		}
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile));
			
			int ch = 0;
			
			while ( (ch = input.read() ) != -1) {
				output.write(ch);
			}
			
			input.close();
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class HtmlTagFilterWriter extends FilterWriter{
	StringWriter tmp = new StringWriter();
	boolean inTag = false;
	
	HtmlTagFilterWriter(Writer out) {
		super(out);
	}
	
	@Override
	public void write(int c) throws IOException {
		
		if(c == '<') {
			inTag = true;
		}else if(c == '>') {
			inTag = false;
			tmp = new StringWriter();
		}
		
		if(inTag) {
			tmp.write(c);
		}else if(!inTag) {
			out.write(c);
		}
	}
	
	public void close() throws IOException{
		out.write(tmp.toString());//StringWriterdㅢ 내요을 출력하고
		super.close();      //조상의 close()를 호출해서 기반 스트림으ㅓㄹ 닫는다ㅓ,.
	}
	
}
