package com.internal.dao;

import com.internal.entity.AppUserDetails;

public interface IUserInfoDAO {

	public AppUserDetails getActiveUser(String userName);

}