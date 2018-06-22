package com.internal.dao;

import com.internal.entity.UserInfo;

public interface IUserInfoDAO {

	public UserInfo getActiveUser(String userName);

}