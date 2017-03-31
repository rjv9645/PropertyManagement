package com.scoochshot.service

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.beans.factory.annotation.Autowired
import com.scoochshot.repository.mapping.PropertyLocationMapper
import java.util.List
import com.scoochshot.repository.pojo.PropertyLocation
import com.google.gson.Gson
import java.util.HashMap
import org.springframework.web.bind.annotation.CrossOrigin

@RestController
@RequestMapping("/api/v1/locations/")
class PropertyLocationService {
	
	//Contains the earth's radius in various units of measure.
	val HashMap<String,Integer> unitsToEarthRadius = 
		newHashMap("km" -> 6380,
				   "m"  -> 3965)
	val Gson jsonMorph = new Gson();
	
	@Autowired
	var PropertyLocationMapper propertyDb;
	
	@CrossOrigin(origins="http://localhost:3000")
	@RequestMapping(path="radius/{longitude}/{latitude}/{distance}/{units}", method=RequestMethod.GET,
				   produces=#[MediaType.APPLICATION_JSON_VALUE])
	def getPropertiesWithinRadius(@PathVariable("longitude") float longitude, 
								  @PathVariable("latitude")  float latitude, 
								  @PathVariable("distance")  double distance,
								  @PathVariable("units") String units)
	{
		var int earthRadius;
		if(unitsToEarthRadius.containsKey(units))
			earthRadius = unitsToEarthRadius.get(units)
		else
			earthRadius = unitsToEarthRadius.get("m")
		
		var List<PropertyLocation> locations = 
			propertyDb.getPropertiesWithinRadius(longitude, latitude, distance, earthRadius)
		 
		jsonMorph.toJson(locations)
	}
}