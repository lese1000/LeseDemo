package tech.lese.demo.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import tech.lese.demo.common.utils.MD5;


public class HttpGetDemo {
	
	public static void callGet(){
//		String	uri="http://localhost/huango/api/v1/jifen/consume?phone=18959289898&openid=1111&consumeVal=100&uType=1&orderNum=order11111122333";
		
		String  uri="http://ispeed.ebit.cn/face/integral/orderByIntegral.jhtml?buyNum=2&ticketType=2&openid=onDC9jseVXywmQL-N1H_R1nMx5XE&sign=";
		String buyNum="2";
		String ticketType="2";
		String openid="onDC9jseVXywmQL-N1H_R1nMx5XE";
		String sign =MD5.md5Hex(buyNum+openid+ticketType+"jfwx");
		uri=uri+sign;
		System.out.println(uri);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		try {
			CloseableHttpResponse respone = httpclient.execute(httpGet);
			HttpEntity entity = respone.getEntity();
			String rtnResult = EntityUtils.toString(entity);
			System.out.println(" >>rtnResult::"+rtnResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		callGet();
	}

}
