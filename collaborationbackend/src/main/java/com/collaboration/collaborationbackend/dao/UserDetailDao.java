package com.collaboration.collaborationbackend.dao;

import com.collaboration.collaborationbackend.model.UserDetail;

public interface UserDetailDao {
	boolean registerUser(UserDetail user);
	boolean updateUserDetail(UserDetail user);
	UserDetail selectOneUser(int userId);
	UserDetail selectOneUserByEmail(String emailid);
	boolean makeOffline(UserDetail user);
	boolean makeOnline(UserDetail user);
	boolean approveUser (UserDetail user);
	boolean rejectUser(UserDetail user);

}
