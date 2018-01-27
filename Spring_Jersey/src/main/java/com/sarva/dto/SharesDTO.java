package com.sarva.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SharesDTO {

	private int id;
	private int numberOfShares;
	@JsonIgnore
	private MessagesDTO messages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public MessagesDTO getMessages() {
		return messages;
	}

	public void setMessages(MessagesDTO messages) {
		this.messages = messages;
	}

}
