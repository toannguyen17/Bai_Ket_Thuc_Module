package com.red.contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
	private static PhoneBook instance;
	private List<Contacts> lists;
	private PhoneBook(){
		lists = new ArrayList<Contacts>();
	}

	public static PhoneBook getInstance(){
		if (instance == null){
			instance = new PhoneBook();
		}
		return instance;
	}

	public Contacts searchPhone(String phone){
		for (Contacts contacts: lists){
			if (contacts.getPhone().equals(phone))
				return contacts;
		}
		return null;
	}

	public List<Contacts> search(String query){
		List<Contacts> searchs = new ArrayList<Contacts>();
		for (Contacts contacts: lists){
			int checkPhone   = contacts.getPhone().compareTo(query);
			int checkGroup   = contacts.getGroup().compareTo(query);
			int checkName    = contacts.getName().compareTo(query);
			int checkAddress = contacts.getAddress().compareTo(query);
			int checkEmail   = contacts.getEmail().compareTo(query);

			if (checkPhone > -10 && checkPhone < 10){
				searchs.add(contacts);
			}else if(checkGroup > -10 && checkGroup < 10){
				searchs.add(contacts);
			}else if(checkName > -10 && checkName < 10){
				searchs.add(contacts);
			}else if(checkAddress > -10 && checkAddress < 10){
				searchs.add(contacts);
			}else if(checkEmail > -10 && checkEmail < 10){
				searchs.add(contacts);
			}
		}

		return searchs;
	}

	public void addContacts(Contacts contacts){
		lists.add(contacts);
	}

	public void addAllContacts(List<Contacts> lists) {
		this.lists.addAll(lists);
	}

	public void removeContacts(Contacts contacts){
		lists.remove(contacts);
	}

	public void removeContacts(String phone){

	}

	public void show(){
		for (Contacts contacts: lists){
			System.out.println(contacts);
		}
	}

	public void show(List<Contacts> lists){
		for (Contacts contacts: lists){
			System.out.println(contacts);
		}
	}

	public int size(){
		return lists.size();
	}

	public List<Contacts> getLists(){
		return lists;
	}
}
