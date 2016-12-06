package tech.lese.demo.other.ups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.lese.demo.httpclient.utils.HttpUtils;
import tech.lese.demo.xml.utils.XmlUtils;

public class UpsApiDemo2 {

	public static void main(String[] args){
	
		testVoidShipmentRequest();
	}
	//ok
	public static void testCreateShipmentNumber(){
		Map<String, Object> shipper = new HashMap<String, Object>();
		shipper.put("Name", "HANS AMERICA GROUP INC");
		shipper.put("AttentionName", "santa santa");
		shipper.put("ShipperNumber", "Y16W78");
		shipper.put("PhoneNumber", "7148899981");
		shipper.put("AddressLine1", "6960 ARAGON CIRCLE");
		shipper.put("AddressLine3", "");
		shipper.put("AddressLine3", "");
		shipper.put("City", "BUENA PARK");
		shipper.put("StateProvinceCode", "CA");
		shipper.put("PostalCode", "90620");
		shipper.put("CountryCode", "US");
		
		Map<String, Object> shipTo= new HashMap<String, Object>();
		shipTo.put("CompanyName", "ABC COMPANY");
		shipTo.put("AttentionName", "May");
		shipTo.put("PhoneNumber", "97225377171");
		shipTo.put("EMailAddress", "may@gmail.com");
		shipTo.put("AddressLine1", "Address Line");
		shipTo.put("AddressLine2", "Address Line");
		shipTo.put("AddressLine3", "Address Line");
		shipTo.put("City", "New York");
		shipTo.put("StateProvinceCode", "NY");
		shipTo.put("PostalCode", "10018");
		shipTo.put("CountryCode", "US");
		Map<String, Object> notification= new HashMap<String, Object>();
		notification.put("6", "jack@abc99.com");
		notification.put("71", "may@abc99.com");
		notification.put("72", "Jack@abc99.com");
		notification.put("81", "may@abc99.com");
		notification.put("82", "Jack@abc99.com");
		List<Map<String, Object>> packages = new ArrayList<Map<String,Object>>();
		Map<String,Object> packageMap=new HashMap<>();
		packageMap.put("PackagingTypeCode", "02");
		packageMap.put("Description", "SHOES SAMPLE");
		packageMap.put("UnitOfMeasurementCode", "LBS");
		packageMap.put("Weight", "5.0");
		packages.add(packageMap);
		
		String shipmentConfirmRequestStr = UpsRequestXmlUtils.buildShipmentConfirmRequest(shipper, shipTo, notification, packages);
		System.out.println(shipmentConfirmRequestStr);
		String shipConfirmUri ="https://onlinetools.ups.com/ups.app/xml/ShipConfirm";
		String result = HttpUtils.doPostByString(shipConfirmUri, shipmentConfirmRequestStr);
		Map<String, Object> confirmResponseMap = XmlUtils.xml2Map(result);
		Map responeMap =(Map) confirmResponseMap.get("Response");
		Object respoStatus = responeMap.get("ResponseStatusCode");
		System.out.println(respoStatus);
		if(respoStatus.equals("1")){
			String shipAcceptUri = "https://onlinetools.ups.com/ups.app/xml/ShipAccept";
			String shipmentDigest = (String) confirmResponseMap.get("ShipmentDigest");
			String shipmentAcceptStr = UpsRequestXmlUtils.buildShipmentAcceptRequest(shipmentDigest);
			String ShipmentAcceptResponseStr = HttpUtils.doPostByString(shipAcceptUri, shipmentAcceptStr);
			System.out.println(ShipmentAcceptResponseStr);
		}
	}
	//ok
	public static void testVoidShipmentRequest(){
		String voidUri= "https://onlinetools.ups.com/ups.app/xml/Void";
		String shipmentNumber="1ZY16W78YW98970567";
		String voidShipmentRequestStr = UpsRequestXmlUtils.buildVoidShipmentRequest(shipmentNumber);
		String result = HttpUtils.doPostByString(voidUri, voidShipmentRequestStr);
		System.out.println(result);
	}
}
