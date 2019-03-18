package com.collaboration.collaborationmiddleware.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.collaborationbackend.dao.ForumDao;
import com.collaboration.collaborationbackend.model.Forum;

@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	ForumDao forumdao;

	@PostMapping
	ResponseEntity<Void> createForum(@RequestBody Forum forum) {
		forum.setComment_Date(new Date());
		if (forumdao.addForum(forum))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/update")
	ResponseEntity<Void> updateForum(@RequestBody Forum forum) {
		forum.setComment_Date(new Date());
		if (forumdao.updateForum(forum))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/{forumid}")
	ResponseEntity<Forum> deleteBlog(@PathVariable("forumid") int forum_id) {
		if (forumdao.deleteForum(forumdao.getOneForum(forum_id)))
			return new ResponseEntity<Forum>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Forum>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
