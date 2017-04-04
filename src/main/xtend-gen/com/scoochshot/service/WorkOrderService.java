package com.scoochshot.service;

import com.google.gson.Gson;
import com.scoochshot.repository.mapping.WorkOrderMapper;
import com.scoochshot.repository.pojo.WorkOrder;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/maintenance/")
@SuppressWarnings("all")
public class WorkOrderService {
  private final Gson jsonMorph = new Gson();
  
  private final String NEW = "new";
  
  private final String ACKNOWLEDGED = "acknowledged";
  
  private final String IN_PROGRESS = "in-progress";
  
  private final String ABANDONED = "abandoned";
  
  private final String COMPLETE = "complete";
  
  private final String[] WORK_ORDER_STATUSES = { this.NEW, this.ACKNOWLEDGED, this.IN_PROGRESS, this.ABANDONED, this.COMPLETE };
  
  @Autowired
  private WorkOrderMapper workOrderDb;
  
  @RequestMapping(path = "insert", method = RequestMethod.POST)
  public void insertWorkOrder(@RequestBody final WorkOrder workOrder) {
    InputOutput.<String>println(("Attempting to insert WorkOrder: " + workOrder));
    workOrder.setStatus(this.NEW);
    this.workOrderDb.insertWorkOrder(workOrder);
  }
  
  @RequestMapping(path = "update/status/{id}", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
  public int updateWorkOrderStatusById(@PathVariable("id") final int id, final String status) {
    boolean _contains = ((List<String>)Conversions.doWrapArray(this.WORK_ORDER_STATUSES)).contains(status);
    boolean _not = (!_contains);
    if (_not) {
      InputOutput.<String>println(((("Illegal status: " + status) + ". Will not update workOrder with id: ") + Integer.valueOf(id)));
      return (-1);
    }
    return this.workOrderDb.updateWorkOrderStatusById(id, status);
  }
}
