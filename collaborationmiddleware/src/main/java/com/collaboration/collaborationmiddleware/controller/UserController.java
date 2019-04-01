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

import com.collaboration.collaborationbackend.dao.UserDetailDao;
import com.collaboration.collaborationbackend.model.UserDetail;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDetailDao userdetaildao;

	@PostMapping
	ResponseEntity<Void> registerUser(@RequestBody UserDetail userdetail) {
		if (userdetaildao.registerUser(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateUser(@RequestBody UserDetail userdetail) {
		if (userdetaildao.updateUserDetail(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/{userid}")
	ResponseEntity<UserDetail> viewOneUser(@PathVariable("userid") int user_id) {
		UserDetail userdetail = userdetaildao.selectOneUser(user_id);
		if (userdetail == null)
			return new ResponseEntity<UserDetail>(userdetail, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<UserDetail>(userdetail, HttpStatus.ACCEPTED);
	}

	@PostMapping("/online/{userid}")
	ResponseEntity<Void> makeOnLine(@PathVariable("userid") int user_id) {
		UserDetail userdetail = userdetaildao.selectOneUser(user_id);
		if (userdetaildao.makeOnline(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/offline/{userid}")
	ResponseEntity<Void> makeOffLine(@PathVariable("userid") int user_id) {
		UserDetail userdetail = userdetaildao.selectOneUser(user_id);
		if (userdetaildao.makeOffline(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/reject/{userid}")
	ResponseEntity<Void> rejectUser(@PathVariable("userid") int user_id) {
		UserDetail userdetail = userdetaildao.selectOneUser(user_id);
		if (userdetaildao.rejectUser(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/approve/{userid}")
	ResponseEntity<Void> approveUser(@PathVariable("userid") int user_id) {
		UserDetail userdetail = userdetaildao.selectOneUser(user_id);
		if (userdetaildao.approveUser(userdetail))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
}
