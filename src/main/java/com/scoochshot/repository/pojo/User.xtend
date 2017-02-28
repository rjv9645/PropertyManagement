package com.scoochshot.repository.pojo

class User {

	var String firstName;
	var String phone;
	
	def getFirstName(){
		firstName
	}
	
	def setFirstName(String value){
		firstName = value
	}
	
	def getPhone(){
		phone
	}
	
	def setPhoneString(String value){
		phone = value
	}	
}
