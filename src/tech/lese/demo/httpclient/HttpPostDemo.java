package tech.lese.demo.httpclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpPostDemo   {
	
	public static void callPost(){
		//NameValuePair--interface
		//BasicNameValuePair--class --implements NameValuePair
		String	uri="http://localhost/huango/api/v1/jifen/query";
		CloseableHttpClient httpclient = HttpClients.createDefault(); 
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
//		List<BasicNameValuePair> formparams2 = new ArrayList<BasicNameValuePair>();  
		
		formparams.add(new BasicNameValuePair("phone", "18959289898"));
		
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);  
			HttpPost httppost = new HttpPost(uri); 
			httppost.setEntity(entity); 
			httppost.addHeader("app_id", "appid");
			CloseableHttpResponse response=httpclient.execute(httppost);
			HttpEntity resentity = response.getEntity();
			if(null!=resentity){
				String result=EntityUtils.toString(resentity);
				Map map2 = new ObjectMapper().readValue(result, HashMap.class);
				System.out.println(result);
				System.out.println("code::"+map2.get("code"));
				response.close(); 
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		callPost();
	}

}
