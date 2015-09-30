package com.lw.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lw.ms.config.WebAppEnv;
import com.lw.ms.service.impl.APRestService;
import com.lw.ms.service.impl.APRpcService;
import com.lwms.api.APListProtos.APList;

@Service
public class APService {
	@Autowired
	private APRestService jsonService;
	@Autowired
	private APRpcService rpcService;
	
	public APList getApList(int dataType) {
		if(dataType == WebAppEnv.DATA_REST) {
			return jsonService.getApList();
		} else {
			return rpcService.getApList();
		}
	}
	
}
