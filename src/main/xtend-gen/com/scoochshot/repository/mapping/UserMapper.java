package com.scoochshot.repository.mapping;

import com.scoochshot.repository.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
@SuppressWarnings("all")
public interface UserMapper {
	
  @Select("Select * From APP.Users Where Id=#{userId}")
  public abstract User getUser(@Param("userId") final int userId);
}
