package com.internal.daoImpl;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.internal.dao.IUserInfoDAO;
import com.internal.entity.UserInfo;

@Repository
public class UserInfoDAOImpl implements IUserInfoDAO {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	// getting the Session Factory
	public Session getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class).getCurrentSession();
	}

	public UserInfo getActiveUser(String userName) {
		System.err.println("Coming inside DAO");
		int enabled = 1;
		@SuppressWarnings("unchecked")
		Query<UserInfo> userQuery = getSession()
				.createQuery("from UserInfo where userName = :userName and enabled = :enabled");
		userQuery.setParameter("userName", userName);
		userQuery.setParameter("enabled", enabled);
		return userQuery.getSingleResult();
	}

}