package com.scoochshot.repository.pojo;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class PropertyLocation {
  private int id;
  
  private float longitude;
  
  private float latitude;
  
  private String address;
  
  private String addrExt;
  
  private String city;
  
  private String state;
  
  private String zip;
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public float getLongitude() {
    return this.longitude;
  }
  
  public void setLongitude(final float longitude) {
    this.longitude = longitude;
  }
  
  @Pure
  public float getLatitude() {
    return this.latitude;
  }
  
  public void setLatitude(final float latitude) {
    this.latitude = latitude;
  }
  
  @Pure
  public String getAddress() {
    return this.address;
  }
  
  public void setAddress(final String address) {
    this.address = address;
  }
  
  @Pure
  public String getAddrExt() {
    return this.addrExt;
  }
  
  public void setAddrExt(final String addrExt) {
    this.addrExt = addrExt;
  }
  
  @Pure
  public String getCity() {
    return this.city;
  }
  
  public void setCity(final String city) {
    this.city = city;
  }
  
  @Pure
  public String getState() {
    return this.state;
  }
  
  public void setState(final String state) {
    this.state = state;
  }
  
  @Pure
  public String getZip() {
    return this.zip;
  }
  
  public void setZip(final String zip) {
    this.zip = zip;
  }
}
