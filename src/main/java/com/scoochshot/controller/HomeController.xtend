package com.scoochshot.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model
import org.springframework.stereotype.Controller

@Controller
class HomeController {
		
	@RequestMapping("/")
	def helloWorld(Model model) {
		model.addAttribute("name","Vrooman")
		"index"
	}
}