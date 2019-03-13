package com.collaboration.collaborationbackend.dao;

import java.util.List;

import com.collaboration.collaborationbackend.model.Blog;

public interface BlogDao {
	boolean addBlog(Blog blog);

	boolean updateBlog(Blog blog);

	boolean deleteBlog(Blog blog);

	List<Blog> selectAllBlog();

	Blog getOneBlog(int blog_id);
	
	boolean incrementLikes(Blog blog);
	
	boolean incrementDisLikes(Blog blog);
	
	boolean approveBlog(Blog blog);
	
	boolean rejectBlog(Blog blog);
}
