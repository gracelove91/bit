package study0604.SerialEx1;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import study0604.UserInfo.UserInfo;

public class SerialEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("JavaMan", "1234",30);
			UserInfo u2 = new UserInfo("JavaWoman", "4321",26);
			
			List<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);
			
			//객체를 직렬화한다.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화 끝!");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
