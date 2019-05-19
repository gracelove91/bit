package day08;

public class FinallyTest {
	public static void main(String[] args) {
		try {
			startInstall();
			copyFiles();
//			deleteTempFiles();	//중복 finally에서 처리하자.
		} catch (Exception e) {
			e.printStackTrace();
//			deleteTempFiles();	//중복. finally에서 처리하자.
		} finally {
			deleteTempFiles();
		}
	}
	
	static void startInstall() {
		
	}
	static void copyFiles() {}
	static void deleteTempFiles() {}
}
