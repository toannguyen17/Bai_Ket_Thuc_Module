package com.red.file;

import com.red.contacts.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadContactsFile {
	private boolean isGetData = false;

	private List<Contacts> lists;

	private File file;

	public ReadContactsFile(String url){
		lists = new ArrayList<Contacts>();
		file  = new File(url);
	}

	public boolean exists(){
		return file.exists();
	}

	private void getData() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

			String line   = null;
			int countLine = 0;

			while ((line = bufferedReader.readLine()) != null) {
				if (countLine > 0) {
					Contacts contacts = new Contacts(line);
					lists.add(contacts);
				}
				countLine++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		isGetData = true;
	}

	public List<Contacts> getContacts(){
		if (exists() && lists.size() == 0 && isGetData == false){
			getData();
		}
		return lists;
	}

	public int size() {
		if (exists() && lists.size() == 0 && isGetData == false){
			getData();
		}

		return lists.size();
	}

	public void show(){
		for(Contacts contacts: lists){
			System.out.println(contacts);
		}
	}
}
