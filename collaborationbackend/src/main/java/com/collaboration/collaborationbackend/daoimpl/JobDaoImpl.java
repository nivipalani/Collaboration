package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.JobDao;
import com.collaboration.collaborationbackend.model.Job;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteJob(Job job) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Job> selectAllJob() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Job").list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Job getOneJob(int job_id) {
		// TODO Auto-generated method stub
		try {
			return (Job) sessionFactory.getCurrentSession().createQuery("from Job where job_id=" + job_id)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
