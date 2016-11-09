package tech.lese.demo.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpGetDemo {
	
	public static void callGet(){
		String	uri="http://localhost/huango/api/v1/jifen/consume?phone=18959289898&openid=1111&consumeVal=100&uType=1&orderNum=order11111122333";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		try {
			CloseableHttpResponse respone = httpclient.execute(httpGet);
			HttpEntity entity = respone.getEntity();
			String rtnResult = EntityUtils.toString(entity);
			System.out.println("callSendTmpMsg >>rtnResult::"+rtnResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		callGet();
	}

}
