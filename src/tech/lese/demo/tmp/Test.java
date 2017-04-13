package tech.lese.demo.tmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import tech.lese.demo.common.utils.MD5;

import com.sun.org.apache.xml.internal.security.utils.Base64;


public class Test {
	
	public static void main(String[] args){
		
		query();
	}
	
	public void create(){
		BufferedReader reader= new BufferedReader(new InputStreamReader(Test.class.getClassLoader().getResourceAsStream("params.json")));
		String contentJson = "";
		try {
			String tmpStr =null;
			while((tmpStr=reader.readLine())!=null){
				contentJson=contentJson+tmpStr;
			}
		} catch (Exception e) {
		}
		System.err.println(contentJson);
		String params =contentJson;
		String uri="http://wlapi.winlinklogistics.com/wuliu/delivery";
		doPostByString(uri, params);
	}
	
	public static void query(){
		String uri="http://wlapi.winlinklogistics.com/wuliu/response";
		String param="{\"orderSN\":[\"CNB3239401\"]}"; 
		System.out.println("param::"+param);		 
		
		doPostByString(uri, param);
	}
	
	
	public static String doPostByString(String uri,String params){
		String AppID = "539937";         
		String AppKey =  "uKCF5gmtzDo8FeeKBRNS";   
		String result=null;
		try {
			HttpPost httppost = new HttpPost(uri);
			httppost.addHeader("Content Type", "application/json;charset=utf-8");
			String binaryData = MD5.md5Hex(AppID+AppKey);
			System.out.println();
			String authVal  = Base64.encode((AppID+":"+binaryData).getBytes());
			httppost.addHeader("User-Auth",authVal);
			StringEntity entity = new StringEntity(params);
			httppost.setEntity(entity); 
			CloseableHttpClient httpclient = HttpClients.createDefault(); 
			CloseableHttpResponse response=httpclient.execute(httppost);
			HttpEntity resentity = response.getEntity();
			if(null!=resentity){
				result=EntityUtils.toString(resentity);
				response.close(); 
			}
			System.out.println(result);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
