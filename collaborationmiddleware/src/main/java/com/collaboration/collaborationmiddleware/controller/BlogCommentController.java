package com.collaboration.collaborationmiddleware.controller;

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

import com.collaboration.collaborationbackend.dao.BlogCommentDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.BlogComment;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentController {

	@Autowired
	BlogCommentDao blogcommentdao;

	@PostMapping
	ResponseEntity<Void> addComment(@RequestBody BlogComment blogcomment) {
		if (blogcommentdao.createBlogComment(blogcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateComment(@RequestBody BlogComment blogcomment) {
		if (blogcommentdao.updateBlogComment(blogcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping("/{blogcommentid}")
	ResponseEntity<BlogComment> deleteBlogComment(@PathVariable("blogcommentid") int blogcomment_id) {
		if (blogcommentdao.deleteBlogComment(blogcommentdao.selectOneBlogComment(blogcomment_id)))
			return new ResponseEntity<BlogComment>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/{blogid")
	ResponseEntity<List<BlogComment>> viewAllBlogComment(@PathVariable("blogid") int blog_id) {
		List<BlogComment> blogcomment = blogcommentdao.selectAllBlogComment(blog_id);
		if (blogcomment.isEmpty())
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.ACCEPTED);
	}
}
