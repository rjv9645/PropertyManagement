package com.scoochshot.repository.pojo

import org.eclipse.xtend.lib.annotations.Accessors
import java.sql.Date
import com.google.gson.Gson

@Accessors
class WorkOrder {
	
	val Gson jsonMorph = new Gson()
	
	var int id;
	var int user_workOrder;
	var int location_workOrder;
	
	var String description;
	var String status;
	
	var Date createDate;
	var Date updateDate;
	
	override String toString()
	{
		jsonMorph.toJson(this)
	}	
}