package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.collaboration.collaborationbackend.dao.ForumCommentDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.ForumComment;

public class ForumCommentDaoImpl implements ForumCommentDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean createForumComment(ForumComment forumcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(forumcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateForumComment(ForumComment forumcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(forumcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteForumComment(ForumComment forumcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(forumcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<ForumComment> selectAllForumComment() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public ForumComment selectOneForumComment(int forumcomment_id) {
		// TODO Auto-generated method stub
		try {
			return (ForumComment) sessionFactory.getCurrentSession()
					.createQuery("from ForumComment where forumcomment_Id=" + forumcomment_id).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
