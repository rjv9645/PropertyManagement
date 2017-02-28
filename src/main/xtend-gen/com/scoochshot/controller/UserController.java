package com.scoochshot.controller;

import com.scoochshot.repository.mapping.UserMapper;
import com.scoochshot.repository.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/")
@SuppressWarnings("all")
public class UserController {
  @Autowired
  private UserMapper userDb;
  
  @RequestMapping("details/{userId}")
  public String getUser(@PathVariable("userId") final int userId) {
    String _xblockexpression = null;
    {
      User foundUser = this.userDb.getUser(userId);
      String _firstName = null;
      if (foundUser!=null) {
        _firstName=foundUser.getFirstName();
      }
      _xblockexpression = ("Found user with name: " + _firstName);
    }
    return _xblockexpression;
  }
}
