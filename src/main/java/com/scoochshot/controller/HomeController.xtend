package com.scoochshot.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController

class HomeController {	
	@RequestMapping("/")
	def helloWorld() {
		"Hello, the PropertyManagement application is alive!"
	}
}