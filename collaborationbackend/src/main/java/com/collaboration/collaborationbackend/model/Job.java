package com.collaboration.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int job_Id;
	
	@Column(nullable=false)
	String job_Profile;
	
	@Column(nullable=false)
	String job_description;
	
	@Column(nullable=false)
	String qualification;
	
	@Column(nullable=false)
	String status;
	
	@Column(nullable=false)
	Date published_Date;

	public int getJob_Id() {
		return job_Id;
	}

	public void setJob_Id(int job_Id) {
		this.job_Id = job_Id;
	}

	public String getJob_Profile() {
		return job_Profile;
	}

	public void setJob_Profile(String job_Profile) {
		this.job_Profile = job_Profile;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPublished_Date() {
		return published_Date;
	}

	public void setPublished_Date(Date published_Date) {
		this.published_Date = published_Date;
	}
	
	

}
