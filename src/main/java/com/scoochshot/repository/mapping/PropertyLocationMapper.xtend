package com.scoochshot.repository.mapping

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import com.scoochshot.repository.pojo.PropertyLocation
import java.util.List
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Insert

@Mapper
interface PropertyLocationMapper {
	
	/**
	 * Credit: query found here: http://spinczyk.net/blog/2009/10/04/radius-search-with-google-maps-and-mysql/
	 * 
	 * Based on the longitude and latitude of a starting position, finds all properties in the database that
	 * are within 'distance' from that point. The units of 'distance' are determined by 'earthRadius'.
	 * 
	 * Pass in the earth's radius in miles, to return distance based on miles. etc...
	 * 
	 * @returns 
	 * 	- A List of PropertyLocations (or empty List) within the given distance.
	 *    Units measured by the earth's radius. 
	 */
	@Select("SELECT ADDRESS, CITY, STATE, ZIP,
				ACOS( SIN( RADIANS(LATITUDE) ) * SIN( RADIANS(#{latitude}) ) + COS( RADIANS(LATITUDE) ) * 
				COS( RADIANS(#{latitude})) * COS(RADIANS(LONGITUDE) - RADIANS(#{longitude})) ) * #{earthRadius} AS DISTANCE
			FROM APP.LOCATIONS
			WHERE 
				ACOS( SIN( RADIANS(LATITUDE) ) * SIN( RADIANS(#{latitude}) ) + COS( RADIANS(LATITUDE) ) * 
				COS( RADIANS(#{latitude})) * COS(RADIANS(LONGITUDE) - RADIANS(#{longitude})) ) * #{earthRadius} < #{distance}
			ORDER BY DISTANCE ASC")
	def List<PropertyLocation> getPropertiesWithinRadius(@Param("longitude")   float longitude, 
														 @Param("latitude")    float latitude, 
														 @Param("distance")    double distance, 
														 @Param("earthRadius") int earthRadius);
	
	@Insert("INSERT INTO APP.LOCATIONS (ADDRESS, ADDREXT, LONGITUDE, LATITUDE, CITY, STATE, ZIP)
			 VALUES (#{address},#{addrExt},#{longitude}, #{latitude}, #{city}, #{state}, #{zip})")
	def void insertPropertyLocation(PropertyLocation location);
	
	@Select("SELECT * FROM APP.LOCATIONS WHERE ID=#{id}")
	def PropertyLocation getPropertyById(@Param("id") int id);
}