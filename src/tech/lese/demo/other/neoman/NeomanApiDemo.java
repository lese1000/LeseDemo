package tech.lese.demo.other.neoman;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.lese.demo.httpclient.utils.HttpUtils;
import tech.lese.demo.json.utils.JacksonUtils;
import tech.lese.demo.other.neoman.params.NeoReqParams;
import tech.lese.demo.other.neoman.params.PreInputListParamMap;
import tech.lese.demo.other.neoman.params.PreInputSetParam;
import tech.lese.demo.other.neoman.params.PreInputSetParam.GoodsEntity;
import tech.lese.demo.other.neoman.params.PreInputSetParam.RecItemEnity;
import tech.lese.demo.other.neoman.params.QueryPriceParamMap;
import tech.lese.demo.other.neoman.utils.NeomanUtils;

public class NeomanApiDemo {
	private static final String DoUri="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
	public static void main(String[] args) throws UnsupportedEncodingException{
//		System.out.println(getClientAuth());
//		System.out.println(getTimeStamp());
//		System.out.println(clientCreate());
//		getClientInfo();//ok
//		getEmsKindList();//ok
//		getFeeList();//需其他参数筛选
//		getRecList();//需其他参数筛选
//		testFeeAdd();//测试充值//ok
//		testPreInputSet();
//		testPreInputData();
//		testPreInputList();
		testQueryPrice();
	}
	
	public static String getClientAuth(){
//		String uri="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
//		String params="{\"RequestName\":\"ClientAuth\",\"icID\":\"80,\"TEST_PASS\":6677XX99}";
		Map<String,Object> clientAuthParamsMap=new HashMap<>();
		clientAuthParamsMap.put("RequestName", "ClientAuth");
		clientAuthParamsMap.put("icID", "514");
		/*clientAuthParamsMap.put("cWebAccount", "Just4Test");
		clientAuthParamsMap.put("cWeChat", "");*/
		clientAuthParamsMap.put("TestPass", "nurL9901");
		String params = JacksonUtils.toJson(clientAuthParamsMap);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoUri, params);
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
		String result = HttpUtils.doPostByString(DoUri, params);
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
	
	public static void getEmsKindList() throws UnsupportedEncodingException{
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
		System.out.println(new String(result.getBytes("iso8859-1"),"UTF-8"));
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
	public static void testPreInputSet() throws UnsupportedEncodingException{
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.usePreInputSet();
		PreInputSetParam.RecItemEnity recItemEntity1 = new PreInputSetParam.RecItemEnity();
		recItemEntity1.setiID("0");
		recItemEntity1.setnItemType("1");
		recItemEntity1.setnLanguage("2");
		recItemEntity1.setcEmsKind(NeomanUtils.toNeoString("印度专线"));
		recItemEntity1.setcDes(NeomanUtils.toNeoString("印度"));
		recItemEntity1.setfWeight("2.123");
		recItemEntity1.setcNo("EM12345678990TCN");//内单好与转运单号同一个
		recItemEntity1.setcNum("EM12345678990TCN");
//		单个物品，不加goodsList,无x，无[]，测试ok
		/*recItemEntity1.setcGoods(NeomanUtils.toNeoString("测试的物品xxxx"));
		recItemEntity1.setiQuantity("99999");
		recItemEntity1.setfPrice("1111.11");*/
		//多个物品
		List<GoodsEntity> goodsList =new ArrayList<>();
		GoodsEntity goods1=new GoodsEntity();
		goods1.setCxGoods(NeomanUtils.toNeoString("测试的物品电视机1"));
		goods1.setIxQuantity("6");
		goods1.setFxPrice("66.66");
		GoodsEntity goods2=new GoodsEntity();
		goods2.setCxGoods(NeomanUtils.toNeoString("洗衣机2"));
		goods2.setIxQuantity("2");
		goods2.setFxPrice("22.22");
		goodsList.add(goods1);
		goodsList.add(goods2);
		recItemEntity1.setGoodsList(goodsList);
		
		List<RecItemEnity> recList= new ArrayList<>();
		recList.add(recItemEntity1);
		neoParams.put("RecList", recList);
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(new String(result.getBytes("iso8859-1"),"UTF-8"));
	}
	public static void testPreInputDel(){
		List<Integer> idsList =new ArrayList<Integer>();
		idsList.add(1);
		idsList.add(2);
		idsList.add(3);
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.usePreInputDel();
		neoParams.put("iIDs", idsList);
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}
	/**
	 * 有详细物品信息，goodlist
	 */
	public static void testFeeAdd(){
		NeoReqParams  neoParams=new NeoReqParams(true);
		neoParams.useFeeAdd();
		neoParams.put("fFee", "0.01");
		neoParams.put("cRefNo", "T"+NeomanUtils.getUTCTimeStamp());
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(result);
	}
	
	/**
	 * 与PreInputData相对比，没有goodList节点，即没有详细物品信息。
	 */
	public static void testPreInputData(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.usePreInputData();
		neoParams.put("cNum", "EM1234567899TCN");
		String params = JacksonUtils.toJson(neoParams);
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(NeomanUtils.toLocalString(result));
	}

	public static void testPreInputList(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.usePreInputList();
		PreInputListParamMap preInputListParamMap= new PreInputListParamMap();
		preInputListParamMap.setiPage(1);
		preInputListParamMap.setiPagePer(100);
		preInputListParamMap.setDqBDate("2013-10-03");
		preInputListParamMap.setDqEDate("2017-10-03");
		preInputListParamMap.setCqDes("印度");
		preInputListParamMap.setCqEmsKind("印度专线");
		preInputListParamMap.setCqStateMask("11");
		neoParams.putAll(preInputListParamMap);
		String params =NeomanUtils.toNeoString( JacksonUtils.toJson(neoParams));
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(NeomanUtils.toLocalString(result));
	}
	
	public static void testQueryPrice(){
		NeoReqParams  neoParams=new NeoReqParams();
		neoParams.useQueryPrice();
		QueryPriceParamMap queryPriceParamMap = new QueryPriceParamMap();
		queryPriceParamMap.setCqDes("印度");
		queryPriceParamMap.setNqItemType(1);
		queryPriceParamMap.setFqLong(1);//b
		queryPriceParamMap.setFqWidth(1);//b
		queryPriceParamMap.setFqWeight(1);//b
		neoParams.putAll(queryPriceParamMap);
		String params = NeomanUtils.toNeoString(JacksonUtils.toJson(neoParams));
		System.out.println(params);
		String result = HttpUtils.doPostByString(DoAppUri, params);
		System.out.println(NeomanUtils.toLocalString(result));
	}
}
