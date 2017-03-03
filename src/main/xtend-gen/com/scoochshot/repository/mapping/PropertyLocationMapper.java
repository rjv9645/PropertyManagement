package com.scoochshot.repository.mapping;

import com.scoochshot.repository.pojo.PropertyLocation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
@SuppressWarnings("all")
public interface PropertyLocationMapper {
  @Select("Select * From APP.LOCATIONS")
  public abstract List<PropertyLocation> getPropertiesWithinRadius(final float longitude, final float latitude, final double distance);
}
