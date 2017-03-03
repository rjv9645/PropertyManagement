package com.scoochshot.service;

import com.scoochshot.repository.mapping.UserMapper;
import com.scoochshot.repository.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@Secured("ROLE_ADMIN")
@SuppressWarnings("all")
public class UserService {
  @Autowired
  private UserMapper userDb;
  
  @RequestMapping(path = "details/{userId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
  public String getUser(@PathVariable("userId") final int userId) {
    String _xblockexpression = null;
    {
      User foundUser = this.userDb.getUser(userId);
      String _elvis = null;
      String _string = null;
      if (foundUser!=null) {
        _string=foundUser.toString();
      }
      if (_string != null) {
        _elvis = _string;
      } else {
        _elvis = "{}";
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  @RequestMapping(path = "update", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<String> updateUser(@RequestBody final User user) {
    int affectedRows = this.userDb.updateUser(user);
    if ((affectedRows == 0)) {
      int _id = user.getId();
      String _plus = ("{\"message\":\"No user found with id: " + Integer.valueOf(_id));
      String _plus_1 = (_plus + "\"}");
      return new ResponseEntity<String>(_plus_1, HttpStatus.INTERNAL_SERVER_ERROR);
    } else {
      int _id_1 = user.getId();
      String _plus_2 = ("{\"message\":\"Update success for user with id: " + Integer.valueOf(_id_1));
      String _plus_3 = (_plus_2 + "\"}");
      return new ResponseEntity<String>(_plus_3, HttpStatus.OK);
    }
  }
}
