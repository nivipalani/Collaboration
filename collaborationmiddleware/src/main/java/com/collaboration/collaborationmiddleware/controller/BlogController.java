package com.collaboration.collaborationmiddleware.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.collaboration.collaborationbackend.dao.BlogDao;
import com.collaboration.collaborationbackend.dao.LikeDislikeDao;
import com.collaboration.collaborationbackend.dao.UserDetailDao;
import com.collaboration.collaborationbackend.model.Blog;
import com.collaboration.collaborationbackend.model.LikeDislike;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	BlogDao blogDao;
	@Autowired
	UserDetailDao userdao;
	@Autowired
	LikeDislikeDao likedislikedao;

	@PostMapping
	ResponseEntity<Void> createBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUserdetail(userdao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			blog.setCreateDate(new Date());
			if (blogDao.addBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/updateBlog")
	ResponseEntity<Void> updateBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUserdetail(userdao.selectOneUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			blog.setCreateDate(new Date());
			if (blogDao.updateBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/{blogid}")
	ResponseEntity<Blog> deleteBlog(@PathVariable("blogid") int blog_id) {
		if (blogDao.deleteBlog(blogDao.getOneBlog(blog_id)))
			return new ResponseEntity<Blog>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Blog>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<Blog>> viewAllBlog() {
		List<Blog> blog = blogDao.selectAllBlog();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}

	@GetMapping("/approved")
	ResponseEntity<List<Blog>> viewApprovedBlog() {
		List<Blog> blog = blogDao.selectApprovedBlog();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/{userid}")
	ResponseEntity<List<Blog>> viewUserBlog(@PathVariable("userid") int user_id) {
		List<Blog> blog = blogDao.selectUserBlog(user_id);
		if (blog == null)
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{blogid}")
	ResponseEntity<Blog> viewOneBlog(@PathVariable("blogid") int blog_id) {
		Blog blog = blogDao.getOneBlog(blog_id);
		if (blog == null)
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Blog>(blog, HttpStatus.ACCEPTED);
	}

	@PostMapping("/likedislike")
	ResponseEntity<Void> InsertOrUpdateBlogLike(@RequestBody LikeDislike likedislike) {
		if (likedislikedao.updateLikesDislikes(likedislike)) {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/likedislike/{blogid}")
	ResponseEntity<LikeDislike> getBloglikes(@PathVariable("blogid") int blog_id) {
		LikeDislike lblog = likedislikedao.selectLikeDislike(blog_id);
		if (lblog != null) {
			return new ResponseEntity<LikeDislike>(lblog, HttpStatus.ACCEPTED);
		} else {
			LikeDislike lblog1 = new LikeDislike();
			lblog1.setBlog(blogDao.getOneBlog(blog_id));
			return new ResponseEntity<LikeDislike>(lblog1, HttpStatus.NOT_ACCEPTABLE);

		}
	}

}
