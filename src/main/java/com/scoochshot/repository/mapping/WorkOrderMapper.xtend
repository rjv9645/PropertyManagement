package com.scoochshot.repository.mapping

import org.apache.ibatis.annotations.Mapper
import com.scoochshot.repository.pojo.WorkOrder
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Update

@Mapper
public interface WorkOrderMapper {
	
	@Insert("INSERT INTO APP.WORKORDERS 
			 VALUES (#{user_workOrder}, #{location_workOrder},
					 #{description}, #{status}, CURRENT DATE, CURRENT DATE)")
	def void insertWorkOrder(WorkOrder workOrder);
	
	@Update("UPDATE APP.WORKORDERS 
			 SET STATUS=#{status}
			 WHERE ID=#{id}")
	def int updateWorkOrderStatusById(int id, String status);
}