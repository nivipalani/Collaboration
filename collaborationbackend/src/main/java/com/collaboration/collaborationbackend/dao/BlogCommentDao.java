package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.BlogComment;


public interface BlogCommentDao {
	
	boolean createBlogComment(BlogComment blogcomment);

	boolean updateBlogComment(BlogComment blogcomment);

	boolean deleteBlogComment(BlogComment blogcomment);

	List<BlogComment> selectAllBlogComment();

	BlogComment selectOneBlogComment(int blogcomment_id);


}
