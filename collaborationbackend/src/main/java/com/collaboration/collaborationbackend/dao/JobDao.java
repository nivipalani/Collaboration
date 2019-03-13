package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.Job;

public interface JobDao {
	boolean addJob(Job job);

	boolean updateJob(Job job);

	boolean deleteJob(Job job);

	List<Job> selectAllJob();

	Job getOneJob(int job_id);

}
