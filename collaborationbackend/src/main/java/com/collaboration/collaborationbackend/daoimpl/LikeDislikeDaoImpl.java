package com.collaboration.collaborationbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.LikeDislikeDao;
import com.collaboration.collaborationbackend.model.LikeDislike;

@Repository("likeDislikeDao")
@Transactional
public class LikeDislikeDaoImpl implements LikeDislikeDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean updateLikesDislikes(LikeDislike likedislike) {
		try {
			sessionFactory.getCurrentSession().update(likedislike);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	}

	public LikeDislike selectLikeDislike(int blogid) {
		// TODO Auto-generated method stub
		try {

			return (LikeDislike) sessionFactory.getCurrentSession()
					.createQuery("from LikeDislike where blog_blogId=" + blogid).uniqueResult();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
