package com.collaboration.collaborationmiddleware.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.collaborationbackend.dao.UserDetailDao;
import com.collaboration.collaborationbackend.model.UserDetail;

@RestController
public class LoginController {

	@Autowired
	UserDetailDao userdetaildao;

	@PostMapping("/login")
	ResponseEntity<Void> loginpage(@RequestBody UserDetail userdetail,HttpSession httpSession) {
		UserDetail existinguser=userdetaildao.selectOneUserByEmail(userdetail.getEmailId());
		if(existinguser.getPassword().equals(userdetail.getPassword()))
		{
			httpSession.setAttribute("userid",existinguser.getUser_Id());
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			
		}
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

}


















































































