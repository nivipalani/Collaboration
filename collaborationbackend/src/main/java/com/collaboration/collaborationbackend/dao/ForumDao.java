package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.Forum;

public interface ForumDao {
	
	boolean addForum(Forum forum);

	boolean updateForum(Forum forum);

	boolean deleteForum(Forum forum);

	List<Forum> selectAllForum();

	Forum getOneForum(int forum_id);

}
