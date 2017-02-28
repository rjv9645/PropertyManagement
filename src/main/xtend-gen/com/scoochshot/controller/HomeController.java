package com.scoochshot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
public class HomeController {
  @RequestMapping("/")
  public String helloWorld() {
    return "Hello, the PropertyManagement application is alive!";
  }
}
