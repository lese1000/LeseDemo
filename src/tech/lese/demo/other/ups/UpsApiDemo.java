package tech.lese.demo.other.ups;

import java.io.FileInputStream;



import java.util.Map;

import tech.lese.demo.httpclient.utils.HttpUtils;
import tech.lese.demo.xml.utils.XmlUtils;

public class UpsApiDemo {
	private static final String accessRequestStr="<?xml version=\"1.0\"?>"
							+"<AccessRequest xml:lang=\"en-US\">"
							+" <AccessLicenseNumber>ED0CDC6BD05D9E86</AccessLicenseNumber>"
							+"  <UserId>hanscorpusaapi</UserId>"
							+"  <Password>shipUPS123!</Password>"
							+" </AccessRequest>";

	public static void main(String[] args) {
		testMethod2();
//		testShipmentAcceptRequest();
	}
	
	public static void testMethod1(){
//		String uri ="https://wwwcie.ups.com/ups.app/xml/ShipConfirm";
		String uri ="https://onlinetools.ups.com/ups.app/xml/ShipConfirm";
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
//		String uri ="https://wwwcie.ups.com/ups.app/xml/ShipConfirm";
		String uri ="https://onlinetools.ups.com/ups.app/xml/ShipConfirm";
		try {
			FileInputStream shipConfirmFis = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\Y16W78_LBS.xml");
			byte[] b1 = new byte[shipConfirmFis.available()];
			shipConfirmFis.read(b1);
			shipConfirmFis.close();
			String paramStr = new String(b1);
			String result = HttpUtils.doPostByString(uri, paramStr);
			Map<String, Object> confirmResponseMap = XmlUtils.xml2Map(result);
			Map responeMap =(Map) confirmResponseMap.get("Response");
			Object respoStatus = responeMap.get("ResponseStatusCode");
			System.out.println(respoStatus);
			if(respoStatus.equals("1")){
				String shipmentDigest = (String) confirmResponseMap.get("ShipmentDigest");
				testShipmentAcceptRequest(shipmentDigest);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testShipmentAcceptRequest(String shipmentDigest){
		String uri = "https://onlinetools.ups.com/ups.app/xml/ShipAccept";				

		try {
			FileInputStream shipmentAcceptFis = new FileInputStream("F:\\devdocs\\DataHub\\UPSAPI\\ShipmentAcceptRequest.xml");
			byte[] b2 = new byte[shipmentAcceptFis.available()];
			shipmentAcceptFis.read(b2);
			shipmentAcceptFis.close();
			String shipmentAcceptStr = new String(b2);
			Map<String, Object> shipmentAcceptRequestMap = XmlUtils.xml2Map(shipmentAcceptStr);
			shipmentAcceptRequestMap.put("ShipmentDigest", shipmentDigest);
			String shipmentAcceptRequestStr = XmlUtils.map2XmlWithoutAttr(shipmentAcceptRequestMap, "ShipmentAcceptRequest");
//			System.out.println(shipmentAcceptRequestStr);
			String ShipmentAcceptResponseStr = HttpUtils.doPostByString(uri, accessRequestStr+shipmentAcceptRequestStr);
			System.out.println(ShipmentAcceptResponseStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
