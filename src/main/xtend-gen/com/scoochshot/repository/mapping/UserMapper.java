package com.scoochshot.repository.mapping;

import com.scoochshot.repository.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
@SuppressWarnings("all")
public interface UserMapper {
  @Select("Select * From APP.Users Where Id=#{userId}")
  public abstract User getUser(@Param("userId") final int userId);
  
  @Update("Update APP.Users Set FIRSTNAME=#{firstName}, PHONE=#{phone} Where ID=#{id}")
  public abstract int updateUser(final User user);
}
