package study0608.DataOutputStreamEx1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class DataOutputStreamEx1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("sample.txt");
			dos = new DataOutputStream(fos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);

			dos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		//////////////

		FileInputStream fis = null;
		ByteArrayOutputStream output = null;
		int data = 0;
		byte[] result = null;
		byte[] temp = new byte[5];
		try {

			fis = new FileInputStream("sample.txt");
			output = new ByteArrayOutputStream();

			while (fis.available() > 0) {
				data = fis.read(temp, 0, temp.length);
				System.out.println(data);
				
				output.write(temp, 0, data);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = output.toByteArray();
		
		System.out.println(Arrays.toString(result));

	}

}
