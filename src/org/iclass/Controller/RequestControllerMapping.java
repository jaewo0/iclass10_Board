package org.iclass.Controller;

import java.util.HashMap;
import java.util.Map;

import org.iclass.Controller.community.ListController;
import org.iclass.Controller.community.WriteController;
import org.iclass.Controller.community.WriteViewController;

public class RequestControllerMapping {
	private static final Map<RequestKeyValue, Controller> mapping = new HashMap<>();
	
	public static void init() {
		//설계된 url,method 에 따라 처리할 controller 구현체를 Key,Value 로 HashMap에 저장합니다.
		mapping.put(new RequestKeyValue("/community/list","GET"), new ListController());
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController());
		mapping.put(new RequestKeyValue("/community/write","Post"), new WriteController());
	}

	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
