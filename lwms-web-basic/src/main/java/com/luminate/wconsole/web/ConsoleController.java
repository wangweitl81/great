package com.luminate.wconsole.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/console")
public class ConsoleController {
    /**
     * Simple controller for "/" that returns a Thymeleaf view.
     */
    @RequestMapping(value = "/{context}/{concretePage}", method = RequestMethod.GET)
    public String showConcreteConsolePage(@PathVariable String context, @PathVariable String concretePage, Model model) {
    	return "console/"+context + "/" + concretePage;
    }
    
    /**
     * Simple controller for "/" that returns a Thymeleaf view.
     */
    @RequestMapping(value = "/{concretePage}", method = RequestMethod.GET)
    public String showConsoleIndex(@PathVariable String concretePage, Model model) {
    	return "console/" + concretePage;
    }    
}
