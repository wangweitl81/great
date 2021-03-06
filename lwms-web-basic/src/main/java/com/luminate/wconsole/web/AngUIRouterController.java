package com.luminate.wconsole.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/angular")
public class AngUIRouterController {
  /**
   * Simple controller for "/" that returns a Thymeleaf view.
   */
  @RequestMapping(value = "/{context}/{concretePage}", method = RequestMethod.GET)
  public String showRadioAccessNetwork(@PathVariable String context,
      @PathVariable String concretePage, Model model) {
    return "sample/" + context + "/" + concretePage + ".html";
  }

  /**
   * Simple controller for "/" that returns a Thymeleaf view.
   */
  @RequestMapping(value = "/{concretePage}", method = RequestMethod.GET)
  public String showRadioAccessNetwork(@PathVariable String concretePage, Model model) {
    return "sample/" + concretePage + ".html";
  }
}
