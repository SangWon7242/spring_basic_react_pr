package com.psw.sbb.basic.boundedContext.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HomeController {
  @GetMapping("/home")
  @ResponseBody
  public String showHome() {
    return "어서와";
  }
}
