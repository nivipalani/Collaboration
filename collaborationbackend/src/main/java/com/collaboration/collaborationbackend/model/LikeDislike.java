package com.collaboration.collaborationbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LikeDislike {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int dummyid;
	
	@ManyToOne
	Blog blog;
	
	@Column
	int likecount;
	
	@Column 
	int dislikecount;

	public int getDummyid() {
		return dummyid;
	}

	public void setDummyid(int dummyid) {
		this.dummyid = dummyid;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public int getDislikecount() {
		return dislikecount;
	}

	public void setDislikecount(int dislikecount) {
		this.dislikecount = dislikecount;
	}
		
}
