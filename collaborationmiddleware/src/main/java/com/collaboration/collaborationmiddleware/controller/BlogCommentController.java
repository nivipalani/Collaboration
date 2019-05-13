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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.collaborationbackend.dao.BlogCommentDao;
import com.collaboration.collaborationbackend.dao.BlogDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.BlogComment;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentController {

	@Autowired
	BlogCommentDao blogcommentdao;
	
	@Autowired
	BlogDao blogdao;

	@PostMapping
	ResponseEntity<Void> addComment(@RequestBody BlogComment blogcomment) {
		blogcomment.setBlogComment_Date(new Date());
		if (blogcommentdao.createBlogComment(blogcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping("/updateBlogComment/{blogcommentid}/{comment}")
	ResponseEntity<Void> updateComment(@PathVariable("blogcommentid") int blogcomment_id,@PathVariable("comment")String blog_Comment) {
		BlogComment blogcomment=blogcommentdao.selectOneBlogComment(blogcomment_id);
		blogcomment.setBlogComment_Date(new Date());
		blogcomment.setBlog_Comment(blog_Comment);
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

	@GetMapping("/{blogid}")
	ResponseEntity<List<BlogComment>> viewAllBlogComment(@PathVariable("blogid") int blog_id) {
		List<BlogComment> blogcomment = blogcommentdao.selectAllBlogComment(blog_id);
		if (blogcomment.isEmpty())
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.ACCEPTED);
	}
}
