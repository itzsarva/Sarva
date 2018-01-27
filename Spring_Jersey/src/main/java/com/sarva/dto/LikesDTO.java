package com.sarva.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LikesDTO {

	private int id;
	private int numberOfLikes;
	@JsonIgnore
	private MessagesDTO messages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public MessagesDTO getMessages() {
		return messages;
	}

	public void setMessages(MessagesDTO messages) {
		this.messages = messages;
	}

}
