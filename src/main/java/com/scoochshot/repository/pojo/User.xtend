package com.scoochshot.repository.pojo

import org.eclipse.xtend.lib.annotations.Accessors
import com.fasterxml.jackson.databind.ObjectMapper

@Accessors
class User {

	var int id;
	var String firstName;
	var String phone;
	
	override toString(){
		var ObjectMapper toJson = new ObjectMapper()
		
		toJson.writeValueAsString(this)
	}	
}
