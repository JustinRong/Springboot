package com.example.girl.controller;

import com.example.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

  @Autowired
  private GirlProperties girlProperties;

  //@RequestMapping(value = "/say",method = RequestMethod.GET)
  @GetMapping(value = "/say")
  public String say(@RequestParam(value = "id", required = false,defaultValue = "0") Integer myid){
    return "id: " + myid;
  }
}
