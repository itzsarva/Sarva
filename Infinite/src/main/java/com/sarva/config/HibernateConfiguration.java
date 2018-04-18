package com.sarva.config;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.sarva.*")
@EnableConfigurationProperties
@EntityScan("com.sarva.entity")
public class HibernateConfiguration {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	// getting the Session Factory
	public SessionFactory getSession() {
		return this.entityManagerFactory.unwrap(SessionFactory.class);
	}

	//setting up transactions manager
	@Bean
	public PlatformTransactionManager getTransaction() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSession());
		return transactionManager;
	}

}
