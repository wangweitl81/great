package com.lw.ms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lw.ms.service.api.APDataAPI;
import com.lwms.api.APListProtos.AP;
import com.lwms.api.APListProtos.APList;

@Service
public class APRpcService implements APDataAPI{

	@Override
	public APList getApList() {
		APList.Builder aplist = APList.newBuilder();
    	
    	AP.APStatus status = AP.APStatus.valueOf(AP.APStatus.green_VALUE);
    	AP.Builder ap = AP.newBuilder();

    	ap.setId(1);
    	ap.setIp("172.32.2.3");
    	ap.setName("Cupertino-A001");
    	ap.setRegion("California");
    	ap.setUptime("10h20m");
    	ap.setStatus(status);
    	
    	aplist.addAp(ap.build());
    	
    	ap.setId(2);
    	ap.setIp("172.32.2.4");
    	ap.setName("Cupertino-A002");
    	ap.setRegion("California");
    	ap.setUptime("10h20m");
    	ap.setStatus(status);
    	
    	aplist.addAp(ap.build());
    	return aplist.build();
	}

}
