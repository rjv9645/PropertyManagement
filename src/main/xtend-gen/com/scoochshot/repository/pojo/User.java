package com.scoochshot.repository.pojo;

@SuppressWarnings("all")
public class User {
  private String firstName;
  
  private String phone;
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public String setFirstName(final String value) {
    return this.firstName = value;
  }
  
  public String getPhone() {
    return this.phone;
  }
  
  public String setPhoneString(final String value) {
    return this.phone = value;
  }
}
