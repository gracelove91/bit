package day08;

public class NewExceptionTest {
	public static void main(String[] args) {
		args[0] = null;
		System.out.println(args[0]);
	}
	
	static void startInstall() {
		
	}
	
	static void copyFiles() {}
	static void deleteTempFiles() {}
	
	static boolean enoughSpace() {
		return false;
	}
	static boolean enoughMemory() {
		return true;
	}
}

class SpaceException extends Exception{
	SpaceException(String msg){
		super(msg);
	}
}
class MemoryException extends Exception{
	MemoryException(String msg){
		super(msg);
	}
}