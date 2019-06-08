package study0608.DataInputStreamEx3;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx3 {
	public static void main(String[] args) {
		int sum = 0;
		int score = 0;
		
		try (FileInputStream fis = new FileInputStream("score.dat");
				DataInputStream dis = new DataInputStream(fis) ) {
			while(true) {
				score = dis.readInt();
				System.out.println(score);
				sum += score;
			}
		} catch(EOFException e) {
			System.out.println("총합 : "+sum);
		} catch(IOException e2) {
			e2.printStackTrace();
		}
	}
}
