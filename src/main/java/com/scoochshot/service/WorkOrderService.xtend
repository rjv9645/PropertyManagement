package com.scoochshot.service

import com.google.gson.Gson
import com.scoochshot.repository.pojo.WorkOrder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.beans.factory.annotation.Autowired
import com.scoochshot.repository.mapping.WorkOrderMapper
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.MediaType

@RestController
@RequestMapping("/api/v1/maintenance/")
class WorkOrderService {
	val Gson jsonMorph = new Gson();
	
	
	val String NEW = "new"
	val String ACKNOWLEDGED = "acknowledged";
	val String IN_PROGRESS = "in-progress";
	val String ABANDONED = "abandoned";
	val String COMPLETE = "complete";
	
	val String[] WORK_ORDER_STATUSES = #[NEW, ACKNOWLEDGED, IN_PROGRESS, ABANDONED, COMPLETE];
	
	@Autowired
	var WorkOrderMapper workOrderDb;
	
	@RequestMapping(path="insert", method=RequestMethod.POST)
	def void insertWorkOrder(@RequestBody WorkOrder workOrder){
		println("Attempting to insert WorkOrder: " + workOrder)
		
		workOrder.status = NEW;
		workOrderDb.insertWorkOrder(workOrder);
	}
	
	@RequestMapping(path="update/status/{id}", method=RequestMethod.POST, consumes=MediaType.TEXT_PLAIN_VALUE)
	def int updateWorkOrderStatusById(@PathVariable("id") int id, String status)
	{
		if(!WORK_ORDER_STATUSES.contains(status))
		{
			println("Illegal status: " + status + ". Will not update workOrder with id: "+ id);
			return -1;
		}
		
		return workOrderDb.updateWorkOrderStatusById(id, status);	
	}	
}