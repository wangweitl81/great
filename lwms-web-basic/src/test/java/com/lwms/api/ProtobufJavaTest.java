package com.lwms.api;

import org.junit.Test;

import com.googlecode.protobuf.format.JsonFormat;
import com.lwms.api.APListProtos.AP;

public class ProtobufJavaTest {

	@Test
	public void testSimpleConversion() {
	//	Message someProto = SomeProto.getDefaultInstance();
		AP.Builder ap = AP.newBuilder();
		AP.APStatus status = AP.APStatus.valueOf(AP.APStatus.green_VALUE);
    	ap.setId(1);
    	ap.setIp("172.32.2.3");
    	ap.setName("Cupertino-A001");
    	ap.setRegion("California");
    	ap.setUptime("10h20m");
    	ap.setStatus(status);
		
		String jsonFormat = JsonFormat.printToString(ap.build());
		System.out.println(jsonFormat);
	}
	
}
