package com.scoochshot.repository.pojo;

import com.google.gson.Gson;
import java.sql.Date;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class WorkOrder {
  private final Gson jsonMorph = new Gson();
  
  private int id;
  
  private int user_workOrder;
  
  private int location_workOrder;
  
  private String description;
  
  private String status;
  
  private Date createDate;
  
  private Date updateDate;
  
  @Override
  public String toString() {
    return this.jsonMorph.toJson(this);
  }
  
  @Pure
  public Gson getJsonMorph() {
    return this.jsonMorph;
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public int getUser_workOrder() {
    return this.user_workOrder;
  }
  
  public void setUser_workOrder(final int user_workOrder) {
    this.user_workOrder = user_workOrder;
  }
  
  @Pure
  public int getLocation_workOrder() {
    return this.location_workOrder;
  }
  
  public void setLocation_workOrder(final int location_workOrder) {
    this.location_workOrder = location_workOrder;
  }
  
  @Pure
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  @Pure
  public String getStatus() {
    return this.status;
  }
  
  public void setStatus(final String status) {
    this.status = status;
  }
  
  @Pure
  public Date getCreateDate() {
    return this.createDate;
  }
  
  public void setCreateDate(final Date createDate) {
    this.createDate = createDate;
  }
  
  @Pure
  public Date getUpdateDate() {
    return this.updateDate;
  }
  
  public void setUpdateDate(final Date updateDate) {
    this.updateDate = updateDate;
  }
}
