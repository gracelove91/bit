package study0604.Exercise15_3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Exercise15_3 {
	static int totalFiles = 0;
	static int totalDirs = 0;
	static int totalSize = 0;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java Exercise15_3 DIRECTORY");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하지않은디렉토리입니다.");
			System.exit(0);
		}
		
		countFiles(dir);
		
		System.out.println();
		System.out.println("총 "+totalFiles +"개의 파일.");
		System.out.println("총 "+totalDirs +"개의 디렉토리.");
		System.out.println("크기 " +totalSize+ " bytes");
	}
	
	public static void countFiles(File dir) {
		//dir의 파일목록을 얻어온다.
		File[] files = dir.listFiles();
		//얻어온 파일목록의 파일 중에서 디렉토미녀? totalDirs의 값 증가.
//		for(File f : files) {
//		for(int i = files.length - 1; i >= 0; i--) {
		for(int i = 0; i < files.length; i++) {
			File f = files[i];
			if(f.isDirectory()) {
				totalDirs++;
				countFiles(f);
				System.out.println(f.getName()+"은 디렉토리입니다.");
			}
			
			//파일이면? totalFiles++, 크기는 totalSize에 저장.
			else if(f.isFile()) {
				totalFiles++;
				totalSize += f.length();
				System.out.println(f.getName()+"은 파일입니다.");
			}
		}
	}
}
