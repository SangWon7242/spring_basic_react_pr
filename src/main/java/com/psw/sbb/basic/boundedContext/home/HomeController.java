package com.psw.sbb.basic.boundedContext.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
  @GetMapping("/api/home")
  @ResponseBody
  public String showHome() {
    return "어서와";
  }
}
