package com.internal.codeGen;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CodeGenTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String Password = passwordEncoder.encode("password");
		System.err.println(Password);
	}

}
