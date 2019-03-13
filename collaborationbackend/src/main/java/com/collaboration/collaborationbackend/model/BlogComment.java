package com.collaboration.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class BlogComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int blogComment_Id;
	
	@ManyToOne
	Blog blog;
	
	@Column(nullable=false)
	String blog_Comment;

	@Column(nullable=false)
	Date blogComment_Date;
	
	@ManyToOne
	UserDetail userdetail;

	public int getBlogComment_Id() {
		return blogComment_Id;
	}

	public void setBlogComment_Id(int blogComment_Id) {
		this.blogComment_Id = blogComment_Id;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getBlog_Comment() {
		return blog_Comment;
	}

	public void setBlog_Comment(String blog_Comment) {
		this.blog_Comment = blog_Comment;
	}

	public Date getBlogComment_Date() {
		return blogComment_Date;
	}

	public void setBlogComment_Date(Date blogComment_Date) {
		this.blogComment_Date = blogComment_Date;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}
	
	
	
	
}
