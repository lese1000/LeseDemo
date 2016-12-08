package tech.lese.demo.other.neoman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.lese.demo.httpclient.utils.HttpUtils;
import tech.lese.demo.json.utils.JacksonUtils;
import tech.lese.demo.other.neoman.utils.NeoReqParams;
import tech.lese.demo.other.neoman.utils.NeomanUtils;

public class NeomanApiDemo {
	private static final String uri="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
	public static void main(String[] args){
//		System.out.println(getClientAuth());
//		System.out.println(getTimeStamp());
//		System.out.println(clientCreate());
//		getClientInfo();//ok
//		getEmsKindList();//ok
//		getFeeList();//需其他参数筛选
		getRecList();//需其他参数筛选
	}
	
	public static String getClientAuth(){
//		String uri="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
//		String params="{\"RequestName\":\"ClientAuth\",\"icID\":\"80,\"TEST_PASS\":6677XX99}";
		Map<String,Object> clientAuthParamsMap=new HashMap<>();
		clientAuthParamsMap.put("RequestName", "ClientAuth");
		clientAuthParamsMap.put("icID", "514");
		/*clientAuthParamsMap.put("cWebAccount", "Just4Test");
		clientAuthParamsMap.put("cWeChat", "");*/
		clientAuthParamsMap.put("TestPass", "6677XX99");
		String params = JacksonUtils.toJson(clientAuthParamsMap);
		System.out.println(params);
		String result = HttpUtils.doPostByString(uri, params);
		return result;
	}
	public static String getTimeStamp(){
		String uri="http://218.244.150.40/cgi-bin/EmsData.dll?DoApi";
		String params="{\"RequestName\":\"TimeStamp\"}";
		String result = HttpUtils.doPostByString(uri, params);
		Map<String, Object> resultMap = JacksonUtils.toMap(result);
		return resultMap.get("ReturnValue").toString();
	}
	
	public static String clientCreate(){
		Map<String,Object> map=new HashMap<>();
		map.put("RequestName", "ClientCreate");
		map.put("cUnitName", "SHANGHAI BZJC TRADE COMPANY LTD.");
		map.put("cAccount", "Shbzj888");
		map.put("cWebAc", "Shbzj888");
		map.put("cPassword", "3333");
		map.put("cWeChat", "887766554433");
		String params = JacksonUtils.toJson(map);
		System.out.println(params);
		String result = HttpUtils.doPostByString(uri, params);
		return result;
		
	}
	
	private static final String DoAppUri="http://218.244.150.40/cgi-bin/EmsData.dll?DoApp";
	public static void getClientInfo(){
		Long timeStamp=NeomanUtils.getUTCTimeStamp();
		
//		String timeStamp=getTimeStamp();//ok
//		System.out.println(timeStamp);
		Map<String,Object> map=new HashMap<>();
		map.put("RequestName", "ClientInfo");
		map.put("icID", "514");
		map.put("TimeStamp", timeStamp);
		map.put("MD5", NeomanUtils.getMd5(timeStamp));
		String params = JacksonUtils.toJson(map);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}
	
	public static void getEmsKindList(){
		Long timeStamp=NeomanUtils.getUTCTimeStamp();
		/*Map<String,Object> map=new HashMap<>();
		map.put("RequestName", "EmsKindList");
		map.put("icID", NeomanUtils.getCustomerID());
		map.put("TimeStamp", timeStamp);
		map.put("MD5", NeomanUtils.getMd5(timeStamp));*/
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.useEmsKindList();
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
		Map<String, Object> resultMap = JacksonUtils.toMap(result);
		List<Map<String,Object>> list = (List<Map<String,Object>>) resultMap.get("List");
		for(Map<String,Object> item:list){
			System.out.println("oName::"+item.get("oName"));
			System.out.println("cName::"+item.get("cName"));
		}
	}
	
	public static void getFeeList(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.useFeeList();
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}
	public static void getRecList(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.useRecList();
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}
	public static void testPreInputSet(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.useRecList();
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}

}
