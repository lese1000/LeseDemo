package tech.lese.demo.httpclient.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	
	public static String doPostByForm(String uri,List<NameValuePair> params){
		String result=null;
		try {
			HttpPost httppost = new HttpPost(uri);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);  
			httppost.setEntity(entity); 
//			httppost.addHeader("app_id", "appid");
			
			CloseableHttpClient httpclient = HttpClients.createDefault(); 
			CloseableHttpResponse response=httpclient.execute(httppost);
			HttpEntity resentity = response.getEntity();
			if(null!=resentity){
				result=EntityUtils.toString(resentity);
				response.close(); 
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static String doPostByString(String uri,String params){
		String result=null;
		try {
			HttpPost httppost = new HttpPost(uri);
			StringEntity entity = new StringEntity(params);
			httppost.setEntity(entity); 
			CloseableHttpClient httpclient = HttpClients.createDefault(); 
			CloseableHttpResponse response=httpclient.execute(httppost);
			HttpEntity resentity = response.getEntity();
			if(null!=resentity){
				result=EntityUtils.toString(resentity);
				response.close(); 
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
