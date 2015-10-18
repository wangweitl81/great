package com.luminate.wconsole.web;

import javax.servlet.http.HttpServletRequest;

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
	public String showConcreteConsolePage(@PathVariable("context") String context,
	    @PathVariable("concretePage") String concretePage, Model model, HttpServletRequest request) {
		String uri = request.getRequestURI();
		int dotPos = uri.lastIndexOf(".");
		return "console/" + context + "/" + concretePage + uri.substring(dotPos);
	}

	/**
	 * Simple controller for "/" that returns a Thymeleaf view.
	 */
	@RequestMapping(value = "/{concretePage}", method = RequestMethod.GET)
	public String showConsoleIndex(@PathVariable("concretePage") String concretePage, Model model) {
		return "console/" + concretePage + ".html";
	}
}
