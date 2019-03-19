package com.collaboration.collaborationmiddleware.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.collaborationbackend.dao.ForumCommentDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.ForumComment;

@RestController
@RequestMapping("/forumcomment")
public class ForumCommentController {

	@Autowired
	ForumCommentDao forumcommentdao;

	@PostMapping
	ResponseEntity<Void> createForumComment(@RequestBody ForumComment forumcomment) {
		forumcomment.setForumcomment_Date(new Date());
		if (forumcommentdao.createForumComment(forumcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	ResponseEntity<Void> updateForumComment(@RequestBody ForumComment forumcomment) {
		forumcomment.setForumcomment_Date(new Date());
		if (forumcommentdao.createForumComment(forumcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

	}

	@DeleteMapping("/{forumcommentid}")
	ResponseEntity<ForumComment> deleteForumComment(@PathVariable("forumcommentid") int forumcomment_id) {
		if (forumcommentdao.deleteForumComment(forumcommentdao.selectOneForumComment(forumcomment_id)))
			return new ResponseEntity<ForumComment>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<ForumComment>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	ResponseEntity<List<ForumComment>> viewAllForumComment()
	{
		List<ForumComment> forumcomment=forumcommentdao.selectAllForumComment(); 
		if(forumcomment.isEmpty())
			return new ResponseEntity<List<ForumComment>>(forumcomment,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<ForumComment>>(forumcomment,HttpStatus.ACCEPTED); 
	}

}
