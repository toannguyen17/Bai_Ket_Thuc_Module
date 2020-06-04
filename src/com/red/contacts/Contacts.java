package com.red.contacts;

public class Contacts {
	private String phone;
	private String group;
	private String name;
	private String sex;
	private String address;
	private String email;

	public Contacts(String csv){
		String[] data = csv.split(",");
		this.phone   = data[0];
		this.group   = data[1];
		this.name    = data[2];
		this.sex     = data[3];
		this.address = data[4];
		this.email   = data[5];
	}

	public Contacts(String phone, String group, String name, String sex, String address, String email){
		this.phone   = phone;
		this.group   = group;
		this.name    = name;
		this.sex     = sex;
		this.address = address;
		this.email   = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void update(String phone, String group, String name, String sex, String address, String email){
		this.phone = phone;
		this.group = group;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.email = email;
	}

	public String getData() {
		return phone + "," + group + "," + name + "," + sex + "," + address + "," + email;
	}

	@Override
	public String toString() {
		return "Số điện thoại: " + phone + ", " +
				"Nhóm: " + group + ", " +
				"Họ và tên: " + name + ", " +
				"Giới tính: " + sex + ", " +
				"Địa chỉ: " + address + ", " +
				"Email: " + email;
	}
}
