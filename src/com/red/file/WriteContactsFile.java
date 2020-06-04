package com.red.file;

import com.red.contacts.Contacts;
import com.red.contacts.PhoneBook;

import java.io.*;
import java.util.List;

public class WriteContactsFile {
	private static String title = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Email";

	private File file;

	public WriteContactsFile(String url){
		file = new File(url);
	}

	public void save(){
		List<Contacts> lists = PhoneBook.getInstance().getLists();
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

			bufferedWriter.write(title);
			bufferedWriter.newLine();

			for (Contacts contacts: lists){
				bufferedWriter.write(contacts.getData());
				bufferedWriter.newLine();
			}

			bufferedWriter.flush();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
}
