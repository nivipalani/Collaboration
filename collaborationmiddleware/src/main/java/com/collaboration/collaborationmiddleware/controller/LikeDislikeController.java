package com.collaboration.collaborationmiddleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.collaborationbackend.dao.BlogDao;
import com.collaboration.collaborationbackend.dao.LikeDislikeDao;
import com.collaboration.collaborationbackend.model.LikeDislike;

@RestController
@RequestMapping("likedislike")
public class LikeDislikeController {
	
	@Autowired
	BlogDao blogdao; 
	@Autowired 
	LikeDislikeDao likedislikedao;
	
	@GetMapping("{blogid}")
	ResponseEntity<LikeDislike> getBloglikes(@PathVariable("blogid") int blogid)
	{
		LikeDislike blog=likedislikedao.selectLikeDislike(blogid);
		if(blog!=null)
		{
			return new ResponseEntity<LikeDislike>(blog,HttpStatus.ACCEPTED);
		}
		else
		{
			LikeDislike blog1=new LikeDislike();
			blog1.setBlog(blogdao.getOneBlog(blogid));
			return new ResponseEntity<LikeDislike>(blog1,HttpStatus.FOUND);
			
		}
	}
	
	@PostMapping
	ResponseEntity<Void> InsertOrUpdateBlogLike(@RequestBody LikeDislike likedislike)
	{
		if(likedislikedao.updateLikesDislikes(likedislike))
		{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	

}
