package com.collaboration.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int forum_Id;

	@Column(nullable = false)
	String forum_Name;

	@Column(nullable = false)
	String forum_Content;

	@ManyToOne
	UserDetail userdetail;

	@Column(nullable = false)
	Date comment_Date;

	@Column(nullable = false)
	String forum_status;

	public int getForum_Id() {
		return forum_Id;
	}

	public void setForum_Id(int forum_Id) {
		this.forum_Id = forum_Id;
	}

	public String getForum_Name() {
		return forum_Name;
	}

	public void setForum_Name(String forum_Name) {
		this.forum_Name = forum_Name;
	}

	public String getForum_Content() {
		return forum_Content;
	}

	public void setForum_Content(String forum_Content) {
		this.forum_Content = forum_Content;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}

	public Date getComment_Date() {
		return comment_Date;
	}

	public void setComment_Date(Date comment_Date) {
		this.comment_Date = comment_Date;
	}

	public String getForum_status() {
		return forum_status;
	}

	public void setForum_status(String forum_status) {
		this.forum_status = forum_status;
	}

}
