package com.matteo.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners")
public class OwnerController {

  @RequestMapping(
      value = {"", "/", "/owners/index", "/owners/index.html"},
      method = RequestMethod.GET)
  public String listOwners() {
    return "owners/index";
  }
}
