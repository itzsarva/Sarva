package com.sarva.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MessagesDTO {

	private int id;
	private String message;
	@JsonIgnore
	private ProfileDTO profie;
	//@JsonDeserialize(using = JsonDeserialization2.class)
	private List<LikesDTO> likes = new ArrayList<LikesDTO>();
	//@JsonDeserialize(using = JsonDeserialization3.class)
	private List<SharesDTO> shares = new ArrayList<SharesDTO>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ProfileDTO getProfie() {
		return profie;
	}

	public void setProfie(ProfileDTO profie) {
		this.profie = profie;
	}

	public List<LikesDTO> getLikes() {
		return likes;
	}

	public void setLikes(List<LikesDTO> likes) {
		this.likes = likes;
	}

	public List<SharesDTO> getShares() {
		return shares;
	}

	public void setShares(List<SharesDTO> shares) {
		this.shares = shares;
	}

}
