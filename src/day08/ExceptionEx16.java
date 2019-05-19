package day08;

import java.io.File;

public class ExceptionEx16 {
	public static void main(String[] args){
//		System.out.println(args.length);
//		System.out.println("args is null?"+args == null);
//		System.out.println();
//		System.out.println(args[0]);
//		
//		int[] score = new int[5];
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() +"파일이 성공적으로 생성되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+ " 다시 입력해주십시오.");
		}
		
	}

	static File createFile(String fileName) throws Exception {
//		if(fileName == null || fileName.equals("")) {
//			throw new Exception("파일 이름이 유효하지않습니다. ");
//			throw new Exception();
//		}
		
		File f = new File(fileName);
		f.createNewFile();
		return f;
	
	}
}
