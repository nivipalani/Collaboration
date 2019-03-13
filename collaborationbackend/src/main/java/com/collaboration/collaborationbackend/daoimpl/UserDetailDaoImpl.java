package com.collaboration.collaborationbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.collaborationbackend.dao.UserDetailDao;
import com.collaboration.collaborationbackend.model.UserDetail;


@Repository("userDetailDao")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(UserDetail user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(user);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateUserDetail(UserDetail user) {
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public UserDetail selectOneUser(int userId) {
		// TODO Auto-generated method stub
		try
		{
		return (UserDetail)sessionFactory.getCurrentSession().createQuery("from UserDetail where user_id="+userId).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean makeOffline(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean makeOnline(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean approveUser(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean rejectUser(UserDetail user) {
		// TODO Auto-generated method stub
		return false;
	}

}
