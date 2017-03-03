package com.scoochshot.service

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.scoochshot.repository.mapping.PropertyLocationMapper
import java.util.List
import com.fasterxml.jackson.databind.ObjectMapper
import com.scoochshot.repository.pojo.PropertyLocation

@RestController
@RequestMapping("/api/v1/locations/")
class PropertyLocationService {
	
	@Autowired
	var PropertyLocationMapper propertyDb;
	
	@RequestMapping(path="radius/{longitude}/{latitude}/{distance}", method=RequestMethod.GET,
				   produces=#[MediaType.APPLICATION_JSON_VALUE])
	def getPropertiesWithinRadius(@PathVariable("longitude") float longitude, 
								  @PathVariable("latitude")  float latitude, 
								  @PathVariable("distance")  double distance)
	{
		var List<PropertyLocation> locations = propertyDb.getPropertiesWithinRadius(longitude, latitude, distance)
		
		var ObjectMapper toJson = new ObjectMapper()
		 
		toJson.writeValueAsString(locations)
	}
}