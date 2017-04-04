package com.scoochshot.repository.mapping;

import com.scoochshot.repository.pojo.PropertyLocation;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
@SuppressWarnings("all")
public interface PropertyLocationMapper {
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
  @Select("SELECT ID, ADDRESS, CITY, STATE, ZIP,\r\n\t\t\t\tACOS( SIN( RADIANS(LATITUDE) ) * SIN( RADIANS(#{latitude}) ) + COS( RADIANS(LATITUDE) ) * \r\n\t\t\t\tCOS( RADIANS(#{latitude})) * COS(RADIANS(LONGITUDE) - RADIANS(#{longitude})) ) * #{earthRadius} AS DISTANCE\r\n\t\t\tFROM APP.LOCATIONS\r\n\t\t\tWHERE \r\n\t\t\t\tACOS( SIN( RADIANS(LATITUDE) ) * SIN( RADIANS(#{latitude}) ) + COS( RADIANS(LATITUDE) ) * \r\n\t\t\t\tCOS( RADIANS(#{latitude})) * COS(RADIANS(LONGITUDE) - RADIANS(#{longitude})) ) * #{earthRadius} < #{distance}\r\n\t\t\tORDER BY DISTANCE ASC")
  public abstract List<PropertyLocation> getPropertiesWithinRadius(@Param("longitude") final float longitude, @Param("latitude") final float latitude, @Param("distance") final double distance, @Param("earthRadius") final int earthRadius);
  
  @Insert("INSERT INTO APP.LOCATIONS (ADDRESS, ADDREXT, LONGITUDE, LATITUDE, CITY, STATE, ZIP)\r\n\t\t\t VALUES (#{address},#{addrExt},#{longitude}, #{latitude}, #{city}, #{state}, #{zip})")
  public abstract void insertPropertyLocation(final PropertyLocation location);
  
  @Select("SELECT * FROM APP.LOCATIONS WHERE ID=#{id}")
  public abstract PropertyLocation getPropertyById(@Param("id") final int id);
}
