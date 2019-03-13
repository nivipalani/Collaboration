package com.collaboration.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int forumcomment_Id;
	
	@ManyToOne
	Forum forum;
	
	@Column(nullable=false)
	String forum_Comment;
	
	@Column(nullable=false)
	Date forumcomment_Date;
	
	@ManyToOne
	UserDetail userdetail;

	public int getForumcomment_Id() {
		return forumcomment_Id;
	}

	public void setForumcomment_Id(int forumcomment_Id) {
		this.forumcomment_Id = forumcomment_Id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public String getForum_Comment() {
		return forum_Comment;
	}

	public void setForum_Comment(String forum_Comment) {
		this.forum_Comment = forum_Comment;
	}

	public Date getForumcomment_Date() {
		return forumcomment_Date;
	}

	public void setForumcomment_Date(Date forumcomment_Date) {
		this.forumcomment_Date = forumcomment_Date;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}
	
	
	
	

}
