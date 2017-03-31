package com.scoochshot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings("all")
public class HomeController {
  @RequestMapping("/")
  public String helloWorld(final Model model) {
    String _xblockexpression = null;
    {
      model.addAttribute("name", "Vrooman");
      _xblockexpression = "index";
    }
    return _xblockexpression;
  }
}
