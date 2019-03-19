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

import com.collaboration.collaborationbackend.dao.FriendDao;
import com.collaboration.collaborationbackend.model.Friend;

@RestController
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	FriendDao frienddao;

	@PostMapping
	ResponseEntity<Void> createFriend(@RequestBody Friend friend) {
		if (frienddao.createFriend(friend))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateFriend(@RequestBody Friend friend) {
		if (frienddao.updateFriend(friend))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping("/{friendid}")
	ResponseEntity<Friend> deleteFriend(@PathVariable("friendid") int friend_id) {
		if (frienddao.deleteFriend(frienddao.selectOneFriend(friend_id)))
			return new ResponseEntity<Friend>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Friend>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<Friend>> viewAllFriend() {
		List<Friend> friend = frienddao.selectAllFriend();
		if (friend.isEmpty())
			return new ResponseEntity<List<Friend>>(friend, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Friend>>(friend, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{friendid}")
	ResponseEntity<Friend> viewOneFriend(@PathVariable("friendid") int friend_id) {
		Friend friend = frienddao.selectOneFriend(friend_id);
		if (friend == null)
			return new ResponseEntity<Friend>(friend, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Friend>(friend, HttpStatus.ACCEPTED);
	}

}
