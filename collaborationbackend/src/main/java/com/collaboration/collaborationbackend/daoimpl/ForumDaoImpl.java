package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.ForumDao;
import com.collaboration.collaborationbackend.model.Forum;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Forum> selectAllForum() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Forum").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Forum getOneForum(int forum_id) {
		// TODO Auto-generated method stub
		try {
			return (Forum) sessionFactory.getCurrentSession().createQuery("from Forum where forum_Id=" + forum_id)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
