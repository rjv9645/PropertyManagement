package com.scoochshot.repository.mapping

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import com.scoochshot.repository.pojo.User
import org.apache.ibatis.annotations.Param

@Mapper
interface UserMapper { 
	
	@Select("Select * From APP.Users Where Id=#{userId}")
	def User getUser(@Param("userId") int userId);
}