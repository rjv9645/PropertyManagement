package com.scoochshot.repository.mapping

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import com.scoochshot.repository.pojo.PropertyLocation
import java.util.List

@Mapper
interface PropertyLocationMapper {
	
	//TODO: Change this db call to perform radius searches. Use in location service.
	@Select("Select * From APP.LOCATIONS")
	def List<PropertyLocation> getPropertiesWithinRadius(float longitude, float latitude, double distance);
}