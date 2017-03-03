package com.scoochshot.service

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.scoochshot.repository.mapping.UserMapper
import com.scoochshot.repository.pojo.User
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.http.MediaType
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api/v1/user/")
@Secured("ROLE_ADMIN")
class UserService {
	
	@Autowired
	var UserMapper userDb;
	
	@RequestMapping(path = "details/{userId}", method = RequestMethod.GET,
					produces=#[MediaType.APPLICATION_JSON_VALUE])
	def getUser(@PathVariable("userId") int userId) {
		var User foundUser = userDb.getUser(userId)
		
		foundUser?.toString() ?: "{}"	
	}
	
	
	@RequestMapping(path="update", method=RequestMethod.POST,
					consumes=#[MediaType.APPLICATION_JSON_VALUE],
					produces=#[MediaType.APPLICATION_JSON_VALUE])
	def updateUser(@RequestBody User user) {
		var affectedRows = userDb.updateUser(user)
		
		if(affectedRows == 0)
			return new ResponseEntity("{\"message\":\"No user found with id: "+user.id+"\"}", HttpStatus.INTERNAL_SERVER_ERROR)
		else
			return new ResponseEntity("{\"message\":\"Update success for user with id: "+user.id+"\"}", HttpStatus.OK)
	}
}