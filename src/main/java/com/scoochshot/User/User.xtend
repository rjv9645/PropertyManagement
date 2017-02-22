package com.scoochshot.User

import com.scoochshot.annotations.SimpleStringValidation

class User {
	
	@SimpleStringValidation(pattern="\\\\d{10}")
	var String phoneNumber
	
	@SimpleStringValidation(pattern=".*loves.*")
	var String phrase
}