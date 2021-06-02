package com.matteo.springpetclinic.controllers;

import com.matteo.springpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners")
public class OwnerController {

  private final OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @RequestMapping(
      value = {"", "/", "/owners/index", "/owners/index.html"},
      method = RequestMethod.GET)
  public String listOwners(Model model) {
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }
}
