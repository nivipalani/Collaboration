package com.collaboration.collaborationbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friend {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int friend_Id;

	@ManyToOne
	UserDetail userdetail;

	@Column(nullable = false)
	String friend_Status;

	public int getFriend_Id() {
		return friend_Id;
	}

	public void setFriend_Id(int friend_Id) {
		this.friend_Id = friend_Id;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}

	public String getFriend_Status() {
		return friend_Status;
	}

	public void setFriend_Status(String friend_Status) {
		this.friend_Status = friend_Status;
	}

}
