package com.scoochshot.repository.mapping

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import com.scoochshot.repository.pojo.User
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Update

@Mapper
interface UserMapper { 
	
	@Select("Select * From APP.Users Where Id=#{userId}")
	def User getUser(@Param("userId") int userId)
	
	@Update("Update APP.Users Set FIRSTNAME=#{firstName}, PHONE=#{phone} Where ID=#{id}")
	def int updateUser(User user)
}