package ca.unx.template.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

	/**
	 * Handles requests for the application home page.
	 */
	@Controller
	public class BootController {
		 /**
	     * Simple page for bootstrap
	     */
	    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET) 
	    public String bootstrap() {
	        return "bootstrap";
	    }
}
