package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.ForumComment;

public interface ForumCommentDao {
	boolean createForumComment(ForumComment forumcomment);

	boolean updateForumComment(ForumComment forumcomment);

	boolean deleteForumComment(ForumComment forumcomment);

	List<ForumComment> selectAllForumComment();

	ForumComment selectOneForumComment(int forumcomment_id);


}
