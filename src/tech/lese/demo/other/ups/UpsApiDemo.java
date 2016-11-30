package tech.lese.demo.other.ups;

import java.io.FileInputStream;

import tech.lese.demo.httpclient.utils.HttpUtils;

public class UpsApiDemo {

	public static void main(String[] args) {
		testMethod2();
	}
	
	public static void testMethod1(){
		String uri ="https://wwwcie.ups.com/ups.app/xml/ShipConfirm";
//		String uri ="https://onlinetools.ups.com/ups.app/xml/ShipConfirm";
		try {
			FileInputStream accessRequestIs = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\AccessRequest.xml");
			FileInputStream confirmRequestIs = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\ShipmentConfirmRequest.xml");
			byte[] b1 = new byte[accessRequestIs.available()];
			byte[] b2 = new byte[confirmRequestIs.available()];
			accessRequestIs.read(b1);
			confirmRequestIs.read(b2);
			String accessRequesStr = new String(b1);
			String confirmRequesStr = new String(b2);
			String confirmStr = accessRequesStr+confirmRequesStr;
//			System.out.println(confirmStr);
			String result = HttpUtils.doPostByString(uri, confirmStr);
			System.out.println(result);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testMethod2(){
		String uri ="https://wwwcie.ups.com/ups.app/xml/ShipConfirm";
		try {
			FileInputStream fis = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\Y16W78_LBS.xml");
			byte[] b1 = new byte[fis.available()];
			fis.read(b1);
			fis.close();
			String paramStr = new String(b1);
//			System.out.println(paramStr);
			String result = HttpUtils.doPostByString(uri, paramStr);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
