package com.scoochshot.repository.mapping;

import com.scoochshot.repository.pojo.WorkOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
@SuppressWarnings("all")
public interface WorkOrderMapper {
  @Insert("INSERT INTO APP.WORKORDERS \r\n\t\t\t VALUES (#{user_workOrder}, #{location_workOrder},\r\n\t\t\t\t\t #{description}, #{status}, CURRENT DATE, CURRENT DATE)")
  public abstract void insertWorkOrder(final WorkOrder workOrder);
  
  @Update("UPDATE APP.WORKORDERS \r\n\t\t\t SET STATUS=#{status}\r\n\t\t\t WHERE ID=#{id}")
  public abstract int updateWorkOrderStatusById(final int id, final String status);
}
