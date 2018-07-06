package com.internal.codeGen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodeGenTest {

	public static Date dateGen() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = format.parse("06/25/2018");
		System.err.println(date);
		return null;
	}

	public static void main(String[] args) throws ParseException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String Password = passwordEncoder.encode("$2a$10$3ZROVZ0fRP0THRHvwPX8ReD4KcWr6BqyBe.zyeCihNhzkWfu3ibG.");
		System.err.println(Password);
		dateGen();
		String str = "null";
		System.err.println(str.length());
		System.err.println(str.equalsIgnoreCase("true"));
	}

}
