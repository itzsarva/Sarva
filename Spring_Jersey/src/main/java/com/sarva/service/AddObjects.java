package com.sarva.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sarva.entity.Likes;
import com.sarva.entity.Messages;
import com.sarva.entity.Profile;
import com.sarva.entity.Shares;

@Service
@Transactional
public class AddObjects {

	@Autowired
	private SessionFactory sessionFactory;

	public void addObjects() {
		// save profiles
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Profile prof = new Profile();
		prof.setName("Sarva");
		prof.setAddress("somewhere there");
		Messages mes = new Messages();
		mes.setProfie(prof);
		mes.setMessage("here is your message");
		Likes lik = new Likes();
		lik.setMessages(mes);
		lik.setNumberOfLikes(10);
		Shares sha = new Shares();
		sha.setMessages(mes);
		sha.setNumberOfShares(10);
		prof.getMess().add(mes);
		prof.setdOB("28/08/1993");
		session.save(prof);
		session.save(mes);
		session.save(sha);
		session.save(lik);
		session.getTransaction().commit();
	}
}
