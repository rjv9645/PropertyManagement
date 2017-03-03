package com.scoochshot.repository.pojo

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class PropertyLocation {
	 
	var int id;
	var float longitude;
	var float latitude;
	
	var String address;
	var String addrExt;
	
	var String city;
	var String state;
	var String zip;
}