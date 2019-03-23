package com.collaboration.collaborationbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	int vacancy;
	
	@Column(nullable=false)
	int salary;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MMM-dd")
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

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	
	

}
