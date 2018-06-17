package com.concretepage.controller;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.concretepage.entity.Article;
import com.concretepage.entity.UserInfo;

@Controller
@RequestMapping("/save")
@Transactional
public class SaveController {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public SessionFactory getSessionFactory() {
		if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	@GetMapping
	public String saveAll() {
		Article art = new Article(1, "Java Concurrency", "Java");
		Article art1 = new Article(2, "Hibernate HQL ", "Hibernate");
		Article art2 = new Article(3, "Spring MVC with Hibernate", "Spring");
		UserInfo info = new UserInfo("mukesh", "$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W",
				"ROLE_ADMIN", "Mukesh Sharma", "India", (short) 1);
		UserInfo info1 = new UserInfo("tarun", "$2a$10$QifQnP.XqXDW0Lc4hSqEg.GhTqZHoN2Y52/hoWr4I5ePxK7D2Pi8q",
				"ROLE_USER", "Tarun Singh", "India", (short) 1);
		getSession().save(art);
		getSession().save(art1);
		getSession().save(art2);
		getSession().save(info);
		getSession().save(info1);
		return "success";
	}

}
