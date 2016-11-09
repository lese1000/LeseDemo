package tech.lese.demo.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemo {
	public static void stringToJson(){
		
		try {
			Map map = new ObjectMapper().readValue("{\"a\":1, \"b\":2}", HashMap.class);
//			Map map2 = new ObjectMapper().readValue("{a:1, b:2}", HashMap.class);
			//开启支持字段名称不带引号的转换模式,默认是关闭的
//			Map map = new ObjectMapper().configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue("{a:1, b:2}", HashMap.class);  
			System.out.println("a::"+map.get("a"));
//			System.out.println("a2::"+map2.get("a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		stringToJson();
	}

}
