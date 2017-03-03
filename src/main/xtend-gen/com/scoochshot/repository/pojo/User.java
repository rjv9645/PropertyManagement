package com.scoochshot.repository.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class User {
  private int id;
  
  private String firstName;
  
  private String phone;
  
  @Override
  public String toString() {
    try {
      String _xblockexpression = null;
      {
        ObjectMapper toJson = new ObjectMapper();
        _xblockexpression = toJson.writeValueAsString(this);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }
  
  @Pure
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(final String phone) {
    this.phone = phone;
  }
}
