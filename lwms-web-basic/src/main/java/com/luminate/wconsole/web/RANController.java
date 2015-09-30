package com.luminate.wconsole.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ran")
public class RANController {
    private static final Logger logger = LoggerFactory
            .getLogger(RANController.class);
    
    /**
     * Simple controller for "/" that returns a Thymeleaf view.
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String showRadioAccessNetwork(Model model) {
    	return "RAN";
    }
}
