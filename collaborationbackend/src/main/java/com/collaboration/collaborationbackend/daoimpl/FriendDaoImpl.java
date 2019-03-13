package com.collaboration.collaborationbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.FriendDao;
import com.collaboration.collaborationbackend.model.Friend;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean createFriend(Friend friend) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteFriend(Friend friend) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Friend> selectAllFriend() {
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().createQuery("from Friend").list();
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Friend selectOneFriend(int friend_id) {
		// TODO Auto-generated method stub
		try
		{
		return (Friend)sessionFactory.getCurrentSession().createQuery("from Friend where friend_id="+friend_id).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
