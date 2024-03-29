package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.BlogDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.LikeDislike;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			LikeDislike likedislike=new LikeDislike();
			likedislike.setBlog(blog);
			likedislike.setDislikecount(0);
			likedislike.setLikecount(0);
			sessionFactory.getCurrentSession().save(blog);
			sessionFactory.getCurrentSession().save(likedislike);
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

	public List<Blog> selectApprovedBlog() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status='" + true + "'").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Blog> selectUserBlog(int userId) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where userdetail.user_Id=" + userId)
					.list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		try {
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	

}
