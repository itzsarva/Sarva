package com.internal.serviceImpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internal.dao.IUserInfoDAO;
import com.internal.entity.UserInfo;

@Service
@Transactional
public class MyAppUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
		System.err.println(activeUserInfo.getRole());
		GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
		System.err.println(activeUserInfo.getRole());
		System.err.println(authority.getAuthority());
		System.err.println(activeUserInfo.getUserName() + " " + activeUserInfo.getPassword());
		Arrays.asList(authority).forEach(System.out::println);
		UserDetails userDetails = (UserDetails) new User(activeUserInfo.getUserName(), activeUserInfo.getPassword(),
				Arrays.asList(authority));
		return userDetails;
	}
}
