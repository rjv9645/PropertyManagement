package com.scoochshot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoochshot.repository.mapping.PropertyLocationMapper;
import com.scoochshot.repository.pojo.PropertyLocation;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations/")
@SuppressWarnings("all")
public class PropertyLocationService {
  @Autowired
  private PropertyLocationMapper propertyDb;
  
  @RequestMapping(path = "radius/{longitude}/{latitude}/{distance}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
  public String getPropertiesWithinRadius(@PathVariable("longitude") final float longitude, @PathVariable("latitude") final float latitude, @PathVariable("distance") final double distance) {
    try {
      String _xblockexpression = null;
      {
        List<PropertyLocation> locations = this.propertyDb.getPropertiesWithinRadius(longitude, latitude, distance);
        ObjectMapper toJson = new ObjectMapper();
        _xblockexpression = toJson.writeValueAsString(locations);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
