package com.sarva.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sarva.dto.MessagesDTO;
import com.sarva.entity.Messages;

@Component
public interface MessageDAO {

	public List<Messages> getAllMessages();

	public MessagesDTO getProfile();
}
