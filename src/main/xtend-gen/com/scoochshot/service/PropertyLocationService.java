package com.scoochshot.service;

import com.google.gson.Gson;
import com.scoochshot.repository.mapping.PropertyLocationMapper;
import com.scoochshot.repository.pojo.PropertyLocation;
import java.util.HashMap;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations/")
@SuppressWarnings("all")
public class PropertyLocationService {
  private final HashMap<String, Integer> unitsToEarthRadius = CollectionLiterals.<String, Integer>newHashMap(Pair.<String, Integer>of("km", Integer.valueOf(6380)), 
    Pair.<String, Integer>of("m", Integer.valueOf(3965)));
  
  private final Gson jsonMorph = new Gson();
  
  @Autowired
  private PropertyLocationMapper propertyDb;
  
  @CrossOrigin(origins = "http://localhost:3000")
  @RequestMapping(path = "radius/{longitude}/{latitude}/{distance}/{units}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
  public String getPropertiesWithinRadius(@PathVariable("longitude") final float longitude, @PathVariable("latitude") final float latitude, @PathVariable("distance") final double distance, @PathVariable("units") final String units) {
    String _xblockexpression = null;
    {
      int earthRadius = 0;
      boolean _containsKey = this.unitsToEarthRadius.containsKey(units);
      if (_containsKey) {
        earthRadius = (this.unitsToEarthRadius.get(units)).intValue();
      } else {
        earthRadius = (this.unitsToEarthRadius.get("m")).intValue();
      }
      List<PropertyLocation> locations = this.propertyDb.getPropertiesWithinRadius(longitude, latitude, distance, earthRadius);
      _xblockexpression = this.jsonMorph.toJson(locations);
    }
    return _xblockexpression;
  }
}
