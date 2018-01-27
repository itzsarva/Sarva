package com.sarva.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Messages {

	@Id
	@GeneratedValue()
	private int id;
	private String message;
	@ManyToOne
	@JsonBackReference
	private Profile profie;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "messages")
	@JsonManagedReference("likes")
	// @JsonBackReference("likes")
	private List<Likes> likes = new ArrayList<Likes>();
	// @JsonBackReference("shares")
	@JsonManagedReference("shares")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "messages")
	private List<Shares> shares = new ArrayList<Shares>();

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

	public Profile getProfie() {
		return profie;
	}

	public void setProfie(Profile profie) {
		this.profie = profie;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public List<Shares> getShares() {
		return shares;
	}

	public void setShares(List<Shares> shares) {
		this.shares = shares;
	}

}
