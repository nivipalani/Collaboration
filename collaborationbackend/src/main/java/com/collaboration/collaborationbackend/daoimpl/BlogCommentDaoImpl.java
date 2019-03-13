package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.BlogCommentDao;
import com.collaboration.collaborationbackend.model.BlogComment;
import com.collaboration.collaborationbackend.model.ForumComment;

@Repository("blogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean createBlogComment(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateBlogComment(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blogcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteBlogComment(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<BlogComment> selectAllBlogComment() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from BlogComment").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public BlogComment selectOneBlogComment(int blogcomment_id) {
		// TODO Auto-generated method stub
		try {
			return (BlogComment) sessionFactory.getCurrentSession()
					.createQuery("from BlogComment where blogComment_Id=" + blogcomment_id).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
