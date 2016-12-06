package tech.lese.demo.other.ups;

import java.util.List;
import java.util.Map;

public class UpsRequestXmlUtils {
	
	public static String getAccessRequest(){
		/*String accessLicenseNumber= AppConfigurator.getProperty("AccessLicenseNumber");
		String userId=AppConfigurator.getProperty("UserId");
		String password=AppConfigurator.getProperty("Password");
		String accessRequestStr="<?xml version=\"1.0\"?>"
				+"<AccessRequest xml:lang=\"en-US\">"
				+" <AccessLicenseNumber>"+accessLicenseNumber+"</AccessLicenseNumber>"
				+"  <UserId>hanscorpusaapi"+userId+"</UserId>"
				+"  <Password>"+password+"</Password>"
				+" </AccessRequest>";*/
		
		String accessRequestStr="<?xml version=\"1.0\"?>"
				+"<AccessRequest xml:lang=\"en-US\">"
				+" <AccessLicenseNumber>ED0CDC6BD05D9E86</AccessLicenseNumber>"
				+"  <UserId>hanscorpusaapi</UserId>"
				+"  <Password>shipUPS123!</Password>"
				+" </AccessRequest>";
		return accessRequestStr;
	}
	
	public static String paymentInformationAccountNumber(){
		return "Y16W78";
	}
	
	/**
	 * 第一次握手请求
	 * @param shipper
	 * @param shipTo
	 * @param notification
	 * @param packages
	 * @return
	 */
	public static String buildShipmentConfirmRequest(Map<String,Object> shipper,Map<String,Object> shipTo,Map<String,Object> notification,List<Map<String,Object>> packages){
		String shipmentConfirmRequestStr="<?xml version=\"1.0\"?>"
		+"<ShipmentConfirmRequest xml:lang=\"en-US\">"
		+" <Request>"
		+"    <TransactionReference>"
		+"      <CustomerContext>Customer Comment</CustomerContext>"
		+"      <XpciVersion/>"
		+"    </TransactionReference>"
		+"    <RequestAction>ShipConfirm</RequestAction>"
		+"    <RequestOption>validate</RequestOption>"
		+"  </Request>"
		+"<LabelSpecification>"
		+"    <LabelPrintMethod>"
		+"      <Code>GIF</Code>"
		+"      <Description>gif file</Description>"
		+"    </LabelPrintMethod>"
		+"    <HTTPUserAgent>Mozilla/4.5</HTTPUserAgent>"
		+"    <LabelImageFormat>"
		+"      <Code>GIF</Code>"
		+"      <Description>gif</Description>"
		+"    </LabelImageFormat>"
		+"</LabelSpecification>"
		+"<Shipment>"
		+"<Shipper>"
		+"      <Name>"+shipper.get("Name")+"</Name>"
		+"      <AttentionName>"+shipper.get("AttentionName")+"</AttentionName>"
		+"      <ShipperNumber>"+shipper.get("ShipperNumber")+"</ShipperNumber>"
		+"      <PhoneNumber>"+shipper.get("PhoneNumber")+"</PhoneNumber>"
		+"      <Address>"
		+"     <AddressLine1>"+shipper.get("AddressLine1")+"</AddressLine1>"
		+"     <AddressLine2>"+shipper.get("AddressLine2")+"</AddressLine2>"
		+"     <AddressLine3>"+shipper.get("AddressLine3")+"</AddressLine3>"
		+"     <City>"+shipper.get("City")+"</City>"
		+"     <StateProvinceCode>"+shipper.get("StateProvinceCode")+"</StateProvinceCode>"
		+"     <PostalCode>"+shipper.get("PostalCode")+"</PostalCode>"
		+"     <CountryCode>"+shipper.get("CountryCode")+"</CountryCode>"
		+"     </Address>"
		+"</Shipper>"
		+"<ShipTo>"
		+"     <CompanyName>"+shipTo.get("CompanyName")+"</CompanyName>"
		+"      <AttentionName>"+shipTo.get("AttentionName")+"</AttentionName>"
		+"      <PhoneNumber>"+shipTo.get("PhoneNumber")+"</PhoneNumber>"
		+"      <EMailAddress>"+shipTo.get("EMailAddress")+"</EMailAddress>"
		+"      <Address>"
		+"        <AddressLine1>"+shipTo.get("AddressLine1")+"</AddressLine1>"
		+"        <AddressLine2>"+shipTo.get("AddressLine2")+"</AddressLine2>"
		+"        <AddressLine3>"+shipTo.get("AddressLine3")+"</AddressLine3>"
		+"        <City>"+shipTo.get("City")+"</City>"
		+"        <StateProvinceCode>"+shipTo.get("StateProvinceCode")+"</StateProvinceCode>"
		+"        <PostalCode>"+shipTo.get("PostalCode")+"</PostalCode>"
		+"        <CountryCode>"+shipTo.get("CountryCode")+"</CountryCode>"
		+"      </Address>"
		+"</ShipTo>"
		+"<PaymentInformation>"
		+"      <Prepaid>"
		+"        <BillShipper>"
		+"          <AccountNumber>"+paymentInformationAccountNumber()+"</AccountNumber>"
		+"        </BillShipper>"
		+"      </Prepaid>"
		+"</PaymentInformation>"
		+"   <!--  <ReferenceNumber>"
		+"       <Code>DP</Code>"
		+"       <Value>123456</Value> "
		+"   </ReferenceNumber>"
		+"    <ReferenceNumber>"
		+"       <Code>PO</Code>"
		+"       <Value>928511251239</Value> "
		+"   </ReferenceNumber> -->"
		+"<Service>"
		+"      <Code>93</Code>"
		+"</Service>"
		+"<ShipmentServiceOptions>"
		+"<Notification>"
		+"      <NotificationCode>6</NotificationCode>"
		+"           <EMailMessage>"
		+"           	<EMailAddress>"+notification.get("6")+"</EMailAddress>"
		+"           </EMailMessage>"
		+"      <NotificationCode>7</NotificationCode>"
		+"           <EMailMessage>"
		+"           	<EMailAddress>"+notification.get("71")+"</EMailAddress>"
		+"           	<EMailAddress>"+notification.get("72")+"</EMailAddress>"
		+"           </EMailMessage>"
		+"      <NotificationCode>8</NotificationCode>"
		+"           <EMailMessage>"
		+"          	<EMailAddress>"+notification.get("81")+"</EMailAddress>"
		+"           	<EMailAddress>"+notification.get("82")+"</EMailAddress>"
		+"           </EMailMessage>"
		+"</Notification>"
		+"</ShipmentServiceOptions>";
		String packageStr="";
		for(Map<String,Object> item:packages){
			packageStr="<Package>"
					+"	  <PackagingType>"
					+"	    <Code>"+item.get("PackagingTypeCode")+"</Code>"
					+"	  </PackagingType>"
					+"	  <Description>"+item.get("Description")+"</Description>"
					+"	  <PackageWeight>"
					+"	    <UnitOfMeasurement>"
					+"	           <Code>"+item.get("UnitOfMeasurementCode")+"</Code>"
					+"	    </UnitOfMeasurement>"
					+"	    <Weight>"+item.get("Weight")+"</Weight>"
					+"	  </PackageWeight>"
					+"</Package>";
		}
		
		String endStr="</Shipment>"+"</ShipmentConfirmRequest> ";
		
		
		return getAccessRequest()+shipmentConfirmRequestStr+packageStr+endStr;
	}
	
	/**
	 * 第二次握手请求
	 * @param shipmentDigest
	 * @return
	 */
	public static String buildShipmentAcceptRequest(String shipmentDigest){
		String shipmentAcceptRequestStr="<?xml version=\"1.0\" ?>"		
		+"<ShipmentAcceptRequest>"
		+"<Request>"
		+"<TransactionReference>"
		+"<CustomerContext>guidlikesubstance</CustomerContext>"
		+"<XpciVersion>1.0001</XpciVersion>"		
		+"</TransactionReference>"		
		+"<RequestAction>ShipAccept</RequestAction>"		
		+"</Request>"		
		+"<ShipmentDigest>"+shipmentDigest+"</ShipmentDigest>"		
		+"</ShipmentAcceptRequest>";
		return getAccessRequest()+shipmentAcceptRequestStr;
	}
	
	public static String buildVoidShipmentRequest(String shipmentNumber){
		String voidShipmentRequestStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"						
		+"<VoidShipmentRequest>"						
		+"<Request>"						
		+"<TransactionReference>"						
		+"<CustomerContext>Customer Transaction ID</CustomerContext>"						
		+"<XpciVersion>1.0001</XpciVersion>	"					
		+"</TransactionReference>"						
		+"<RequestAction>Void</RequestAction>"						
		+"</Request>"						
		+"<ShipmentIdentificationNumber>"						
		+shipmentNumber						
		+"</ShipmentIdentificationNumber>"					
		+"</VoidShipmentRequest>";						
		return getAccessRequest()+voidShipmentRequestStr;
	}		

	

}
