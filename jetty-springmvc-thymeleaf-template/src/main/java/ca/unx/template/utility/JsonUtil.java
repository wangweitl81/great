package ca.unx.template.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	public static String convertObjToString(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static String getAPList() {
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "green");
		map.put("ap", "AP000001");
		map.put("ip", "192.168.0.101");
		map.put("region", "LOCATION");
		map.put("uptime", "4d14m23s");
		mapList.add(map);
		
		map = new HashMap<String, String>();
		map.put("status", "yellow");
		map.put("ap", "AP000002");
		map.put("ip", "192.168.0.101");
		map.put("region", "LOCATION");
		map.put("uptime", "4d14m23s");
		mapList.add(map);
		
		map = new HashMap<String, String>();
		map.put("status", "red");
		map.put("ap", "AP000003");
		map.put("ip", "192.168.0.101");
		map.put("region", "LOCATION");
		map.put("uptime", "4d14m23s");
		mapList.add(map);
		
		map = new HashMap<String, String>();
		map.put("status", "grey");
		map.put("ap", "AP000004");
		map.put("ip", "192.168.0.101");
		map.put("region", "LOCATION");
		map.put("uptime", "4d14m23s");
		mapList.add(map);
		
		return convertObjToString(mapList);
	}
	
	private static String getAlarmList() {
		List<Map<String, String>> alarmList = new ArrayList<Map<String, String>>();
		Map<String, String> map = null;
		
		String[] alarmTxtList = getAlarmStrList();
		
		for (int i = 0; i < 10; i++) {
			int index = (int)(Math.random()*5);
			
			map = new HashMap<String, String>();
			map.put("alarm", alarmTxtList[index]);
			map.put("ip", "192.168.0.1");
			map.put("severity", "CRITICAL");
			map.put("ipv6", "000.00.000.000");
			map.put("occurence", "6/28/2015 09:00 AM");
			alarmList.add(map);		
		}
		
		return convertObjToString(alarmList);
	}
	
	public static String[] getAlarmStrList() {
		return new String[]{
				"Sed posuere consectetur est at lobortis.",
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
				"Cum sociis natoque penatibus et magnis dis parturient.",
				"Curabitur blandit tempus porttitor.",
				"Fusce dapibus, tellus ac cursus commodo, tortor mauris."
		};
	}
	
	public static void main(String[] args) {
		System.out.println(getAlarmList());
	}
	
}
