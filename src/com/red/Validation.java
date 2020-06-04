package com.red;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	private static Validation instance;

	private static final Pattern patternEmail = Pattern.compile("^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");

	private static final Pattern patternPhone = Pattern.compile("^0[0-9]{8,11}$");

	private static final Pattern patternValid = Pattern.compile(",");

	private Validation(){}

	public static Validation getInstance(){
		if(instance == null){
			instance = new Validation();
		}
		return instance;
	}

	public boolean validEmail(String email){
		Matcher matcher = patternEmail.matcher(email);
		return matcher.find();
	}

	public boolean validPhone(String phone){
		Matcher matcher = patternPhone.matcher(phone);
		return matcher.find();
	}

	public boolean validCheck(String text){
		Matcher matcher = patternValid.matcher(text);
		return !matcher.find();
	}
}
