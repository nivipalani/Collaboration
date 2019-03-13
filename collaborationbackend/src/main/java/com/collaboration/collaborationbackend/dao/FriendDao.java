package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.Friend;

public interface FriendDao {
	boolean createFriend(Friend friend);

	boolean updateFriend(Friend friend);

	boolean deleteFriend(Friend friend);

	List<Friend> selectAllFriend();

	Friend selectOneFriend(int friend_id);

}
