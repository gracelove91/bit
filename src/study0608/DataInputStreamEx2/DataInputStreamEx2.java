package study0608.DataInputStreamEx2;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamEx2 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis  = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		} catch (Exception e) {
			System.out.println("총점 : "+sum);
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
