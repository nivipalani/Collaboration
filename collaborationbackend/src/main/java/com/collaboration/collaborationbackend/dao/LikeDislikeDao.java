package com.collaboration.collaborationbackend.dao;

import com.collaboration.collaborationbackend.model.LikeDislike;

public interface LikeDislikeDao {
	
	
	boolean updateLikesDislikes(LikeDislike likedislike);
	
	LikeDislike selectLikeDislike(int blogid);

}
