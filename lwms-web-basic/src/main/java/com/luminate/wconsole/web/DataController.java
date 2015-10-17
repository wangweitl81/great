package com.luminate.wconsole.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.googlecode.protobuf.format.JsonFormat;
import com.luminate.wconsole.config.WebAppEnv;
import com.luminate.wconsole.service.APService;
import com.lwms.api.APListProtos.APList;

@Controller
@RequestMapping("/data")
public class DataController {

	@Autowired
	private APService apService;

	private static final Logger logger = LoggerFactory.getLogger(DataController.class);

	/**
	 * Simple controller for "/" that returns a Thymeleaf view.
	 */
	@RequestMapping(value = "/ap.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getAPList(Model model) {
	APList aplist = apService.getApList(WebAppEnv.getDataType());

	final String jsonString = JsonFormat.printToString(aplist);
	logger.debug("returned ap.jons:" + jsonString);
	return jsonString;
	}

	@RequestMapping(value = "/alarm.json", method = RequestMethod.GET)
	@ResponseBody
	public Object getAlarmList(Model model) {
	String jsonString = "[{\"ipv6\":\"000.00.000.000\",\"occurence\""
		+ ":\"6/28/2015 09:00 AM\",\"alarm\":\"Curabitur blandit tempus porttitor.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Curabitur blandit tempus porttitor.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Cum sociis natoque penatibus et magnis dis parturient.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Fusce dapibus, tellus ac cursus commodo, tortor mauris.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Cum sociis natoque penatibus et magnis dis parturient.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Sed posuere consectetur est at lobortis.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Sed posuere consectetur est at lobortis.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Sed posuere consectetur est at lobortis.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Curabitur blandit tempus porttitor.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"},"
		+ "{\"ipv6\":\"000.00.000.000\",\"occurence\":\"6/28/2015 09:00 AM\",\"alarm\":\"Cum sociis natoque penatibus et magnis dis parturient.\",\"severity\":\"CRITICAL\",\"ip\":\"192.168.0.1\"}]";
	return jsonString;
	}

}