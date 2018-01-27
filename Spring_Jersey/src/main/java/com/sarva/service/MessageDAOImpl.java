package com.sarva.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarva.dto.MessagesDTO;
import com.sarva.entity.Messages;

@Service
@Transactional
public class MessageDAOImpl implements MessageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Messages> getAllMessages() {
		Session session = getSession();
		session.beginTransaction();
		Query query = session.createQuery("from Messages");
		List<Messages> mess = (List<Messages>) query.list();
		session.getTransaction().commit();
		return mess;
	}

	@Override
	public MessagesDTO getProfile() {
		// TODO Auto-generated method stub
		return null;
	}

}
