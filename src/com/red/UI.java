package com.red;

import com.red.contacts.Contacts;
import com.red.contacts.PhoneBook;
import com.red.file.ReadContactsFile;
import com.red.file.WriteContactsFile;

import java.util.List;
import java.util.Scanner;

public class UI {
	Scanner scanner;
	private static UI  instance;
	private PhoneBook  phoneBook;
	private Validation validation;

	private UI(){
		scanner    = new Scanner(System.in);
		phoneBook  = PhoneBook.getInstance();
		validation = Validation.getInstance();
	}

	public static UI getInstance() {
		if (instance == null)
			instance = new UI();

		return instance;
	}

	public void showMenu(){
		System.out.println("\n------ CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ------");
		System.out.println("Chọn chức năng (theo số) để tiếp tục:");
		System.out.println("1: Xem danh sách.");
		System.out.println("2: Thêm mới.");
		System.out.println("3: Cập nhật.");
		System.out.println("4: Xóa.");
		System.out.println("5: Tìm kiếm.");
		System.out.println("6: Đọc từ app.file.");
		System.out.println("7: Ghi vào app.file.");
		System.out.println("8: Thoát.");
		System.out.print("Chọn chức năng: ");

		onSelect(scanner.nextLine());
	}

	private void onSelect(String select){
		switch (select){
			case "1":
				showPhoneBook();
				break;
			case "2":
				insertContacts();
				break;
			case "3":
				updateContacts();
				break;
			case "4":
				removeContacts();
				break;
			case "5":
				searchContacts();
				break;
			case "6":
				readFile();
				break;
			case "7":
				writeFile();
				break;
			case "8":
				System.exit(0);
				break;
		}
	}

	private void showPhoneBook(){
		System.out.println("\n------ Danh bạ hiện tại ------");
		if (phoneBook.size() == 0)
			System.out.println("Danh bạ trống.");
		else
			phoneBook.show();
	}

	private void insertContacts(){
		System.out.println("\n------ Thêm mới ------");

		String phone   = null;
		String group   = null;
		String name    = null;
		String sex     = null;
		String address = null;
		String email   = null;

		boolean valid = false;
		while (valid == false){
			System.out.print("Số điện thoại: ");
			phone = scanner.nextLine();
			phone = phone.trim();

			if(phone.length() > 1 && validation.validPhone(phone) && validation.validCheck(phone)){
				valid = true;
			}else{
				System.out.println("\nSố điện thoại không hợp lệ !");
			}
		}

		valid = false;
		while (valid == false){
			System.out.print("Nhóm: ");
			group = scanner.nextLine();
			group = group.trim();

			if(group.length() > 1 && validation.validCheck(group)){
				valid = true;
			}else{
				System.out.println("\nNhóm không hợp lệ !");
			}
		}

		valid = false;
		while (valid == false){
			System.out.print("Nhập tên: ");
			name = scanner.nextLine();
			name = name.trim();

			if(name.length() > 1 && validation.validCheck(name)){
				valid = true;
			}else{
				System.out.println("\nTên không hợp lệ !");
			}
		}


		valid = false;
		while (valid == false){
			System.out.print("Giớt tính: ");
			sex = scanner.nextLine();
			sex = sex.trim();

			if(sex.length() > 1 && validation.validCheck(sex)){
				valid = true;
			}else{
				System.out.println("\nGiớt tính không hợp lệ !");
			}
		}


		valid = false;
		while (valid == false){
			System.out.print("Địa chỉ: ");
			address = scanner.nextLine();
			address = address.trim();

			if(address.length() > 1 && validation.validCheck(address)){
				valid = true;
			}else{
				System.out.println("\nĐịa chỉ không hợp lệ !");
			}
		}

		valid = false;
		while (valid == false){
			System.out.print("Email: ");
			email = scanner.nextLine();
			email = email.trim();

			if(email.length() > 1 && validation.validEmail(email) && validation.validCheck(email)){
				valid = true;
			}else{
				System.out.println("\nEmail không hợp lệ !");
			}
		}

		Contacts contacts = new Contacts(phone, group, name, sex, address, email);
		phoneBook.addContacts(contacts);

		System.out.println("\nThêm mới thành công: " + contacts);
	}

	private void updateContacts(){
		System.out.println("\n------ Cập nhật ------");

		System.out.print("Nhập số điện thoại muốn cập nhật: ");
		String phone = scanner.nextLine();

		Contacts contacts = phoneBook.searchPhone(phone);

		if (contacts == null){
			System.out.println("\n! Số điện thoại không tồn tại trong danh bạ.");
		}else{
			String group   = null;
			String name    = null;
			String sex     = null;
			String address = null;
			String email   = null;

			boolean valid = false;
			while (valid == false){
				System.out.print("Số điện thoại mới: ");
				phone = scanner.nextLine();
				phone = phone.trim();

				if(phone.length() > 1 && validation.validPhone(phone) && validation.validCheck(phone)){
					valid = true;
				}else{
					System.out.println("\nSố điện thoại không hợp lệ !");
				}
			}

			valid = false;
			while (valid == false){
				System.out.print("Nhóm mới: ");
				group = scanner.nextLine();
				group = group.trim();

				if(group.length() > 1 && validation.validCheck(group)){
					valid = true;
				}else{
					System.out.println("\nNhóm không hợp lệ !");
				}
			}

			valid = false;
			while (valid == false){
				System.out.print("Nhập tên mới: ");
				name = scanner.nextLine();
				name = name.trim();

				if(name.length() > 1 && validation.validCheck(name)){
					valid = true;
				}else{
					System.out.println("\nTên không hợp lệ !");
				}
			}


			valid = false;
			while (valid == false){
				System.out.print("Giớt tính mới: ");
				sex = scanner.nextLine();
				sex = sex.trim();

				if(sex.length() > 1 && validation.validCheck(sex)){
					valid = true;
				}else{
					System.out.println("\nGiớt tính không hợp lệ !");
				}
			}


			valid = false;
			while (valid == false){
				System.out.print("Địa chỉ mới: ");
				address = scanner.nextLine();
				address = address.trim();

				if(address.length() > 1 && validation.validCheck(address)){
					valid = true;
				}else{
					System.out.println("\nĐịa chỉ không hợp lệ !");
				}
			}

			valid = false;
			while (valid == false){
				System.out.print("Email mới: ");
				email = scanner.nextLine();
				email = email.trim();

				if(email.length() > 1 && validation.validEmail(email) && validation.validCheck(email)){
					valid = true;
				}else{
					System.out.println("\nEmail không hợp lệ !");
				}
			}

			System.out.println("\nThông tin cũ: " + contacts);
			contacts.update(phone, group, name, sex, address, email);
			System.out.println("Thông tin mới: " + contacts);
		}

		System.out.println("\n------ Chọn ------");
		System.out.println("1: Cập nhật số khác");
		System.out.println("0: Về menu.");
		System.out.print("Nhập: ");
		String select = scanner.nextLine();
		switch (select){
			case "1":
				updateContacts();
				break;
		}
	}

	private void removeContacts(){
		System.out.println("\n------ Xóa số điện thoại ------");

		System.out.print("Nhập số điện thoại muốn xóa: ");
		String phone = scanner.nextLine();

		Contacts contacts = phoneBook.searchPhone(phone);

		if (contacts == null){
			System.out.println("\n! Số điện thoại không tồn tại trong danh bạ.");
		}else{
			phoneBook.removeContacts(contacts);
			System.out.println("\n Xóa thành công số điện thoại: " + phone);
		}

		System.out.println("\n------ Chọn ------");
		System.out.println("1: Xóa số điện thoại khác");
		System.out.println("0: Về menu.");
		System.out.print("Nhập: ");
		String select = scanner.nextLine();
		switch (select){
			case "1":
				removeContacts();
				break;
		}
	}

	private void searchContacts(){
		System.out.println("\n------ Tìm kiếm ------");

		System.out.print("Nhập thông tin muốn tìm kiếm: ");
		String search = scanner.nextLine();

		List<Contacts> contacts = phoneBook.search(search);

		System.out.println("Kết quả tìm kiếm cho: " + search);

		if (contacts.size() == 0){
			System.out.println("** Không tìm thấy **");
		}else{
			phoneBook.show(contacts);
		}

		System.out.println("\n------ Chọn ------");
		System.out.println("1: Tìm kiếm mới.");
		System.out.println("0: Về menu.");
		System.out.print("Nhập: ");
		String select = scanner.nextLine();
		switch (select){
			case "1":
				searchContacts();
				break;
		}
	}

	private void readFile(){
		System.out.println("\n------ Đọc từ app.file ------");

		System.out.print("Nhập app.file muốn đọc: ");
		String file = scanner.nextLine();

		ReadContactsFile readContactsFile = new ReadContactsFile(file);

		int size = 0;
		if (readContactsFile.exists()){
			size = readContactsFile.size();
			if (size == 0){
				System.out.println("\nKhông tìm thấy liên hệ trong tập tin.");
			}else{
				System.out.println("\nTìm thấy " + size + " liên hệ mới.");

				while (true){
					System.out.println("\n------ Chọn ------");
					System.out.println("1: Thêm vào danh bạ.");
					System.out.println("2: Xem.");
					System.out.println("3: Đọc từ app.file.");
					System.out.println("0: Menu.");
					System.out.print("Nhập: ");
					String select = scanner.nextLine();
					switch (select){
						case "1":
							List<Contacts> lists = readContactsFile.getContacts();
							phoneBook.addAllContacts(lists);
							return;

						case "2":
							System.out.println("\n------ Liên hệ mới ------");
							readContactsFile.show();
							break;

						case "3":
							readFile();
							return;

						default:
							return;
					}
				}
			}
		}else{
			System.out.println("\nFile không tồn tại.");
		}

		if (size == 0){
			System.out.println("\n------ Chọn ------");
			System.out.println("1: Đọc từ app.file.");
			System.out.println("0: Menu.");
			System.out.print("Nhập: ");
			String select = scanner.nextLine();
			switch (select){
				case "1":
					readFile();
					break;
			}
		}
	}

	private void writeFile(){
		System.out.println("\n------ Ghi vào app.file ------");

		System.out.print("Nhập app.file muốn ghi: ");
		String file = scanner.nextLine();

		WriteContactsFile writeContactsFile = new WriteContactsFile(file);

		if (phoneBook.size() == 0){
			System.out.println("\nDanh bạ trống, không thể lưu app.file, ");
		}else{
			writeContactsFile.save();
			System.out.println("\nLưu thành công.");
		}
	}
}
