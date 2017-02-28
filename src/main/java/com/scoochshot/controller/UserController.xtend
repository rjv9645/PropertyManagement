package com.scoochshot.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.scoochshot.repository.mapping.UserMapper
import com.scoochshot.repository.pojo.User

@RestController
@RequestMapping("/api/v1/user/")
class UserController {
	
	@Autowired
	var UserMapper userDb;
	
	@RequestMapping("details/{userId}")
	def getUser(@PathVariable("userId") int userId) {
		var User foundUser = userDb.getUser(userId)
		
		"Found user with name: " + foundUser?.firstName
	}
	
}