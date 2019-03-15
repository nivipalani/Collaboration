package com.collaboration.collaborationmiddleware.controller;

import java.util.List;

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
import com.collaboration.collaborationbackend.model.Blog;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	BlogDao blogDao;

	@PostMapping
	ResponseEntity<Void> createBlog(@RequestBody Blog blog) {
		if (blogDao.addBlog(blog))
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

	}

	@GetMapping
	ResponseEntity<List<Blog>> viewBlog() {
		List<Blog> b = blogDao.selectApprovedBlog();
		if (b.isEmpty())
			return new ResponseEntity<List<Blog>>(b,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(b,HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/{blogid}")
	ResponseEntity <Blog> viewOneBlog(@PathVariable("blogid")int id) {
		Blog b = blogDao.getOneBlog(id);
		if (b==null)
			return new ResponseEntity<Blog>(b,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Blog>(b,HttpStatus.ACCEPTED);
	}
}
