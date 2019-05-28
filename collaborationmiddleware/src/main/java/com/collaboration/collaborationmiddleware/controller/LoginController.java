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
	ResponseEntity<UserDetail> loginpage(@RequestBody UserDetail userdetail, HttpSession httpSession) {
		UserDetail existinguser = userdetaildao.selectOneUserByEmail(userdetail.getEmailId());
		if(existinguser==null)
		{
			return new ResponseEntity<UserDetail>(existinguser,HttpStatus.NOT_ACCEPTABLE);
		}
		else if (existinguser.getPassword().equals(userdetail.getPassword())) {
			existinguser.setIsOnline("true");
			userdetaildao.updateUserDetail(existinguser);
			httpSession.setAttribute("userid", existinguser.getUser_Id());
			httpSession.setAttribute("emailid", existinguser.getEmailId());
			return new ResponseEntity<UserDetail>(existinguser,HttpStatus.ACCEPTED);

		} else
			return new ResponseEntity<UserDetail>(existinguser,HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/logout")
	ResponseEntity<Void> logoutpage(HttpSession httpSession) {
		UserDetail existinguser = userdetaildao.selectOneUserByEmail(httpSession.getAttribute("emailid").toString());
		existinguser.setIsOnline("false");
		if (userdetaildao.updateUserDetail(existinguser)) {
			httpSession.invalidate();
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
