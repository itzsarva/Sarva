package com.sarva.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sarva.entity.Messages;
import com.sarva.service.MessageDAO;

@Component
public class MessageResource {

	@Autowired
	private MessageDAO messageDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getMessages() {
		return messageDao.getAllMessages();
	}
}
