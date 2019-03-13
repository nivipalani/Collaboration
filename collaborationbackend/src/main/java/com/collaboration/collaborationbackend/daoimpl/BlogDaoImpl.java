package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.BlogDao;
import com.collaboration.collaborationbackend.model.Blog;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Blog> selectAllBlog() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Blog getOneBlog(int blog_id) {
		// TODO Auto-generated method stub
		try {
			return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where blogId=" + blog_id)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean incrementLikes(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean incrementDisLikes(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}
