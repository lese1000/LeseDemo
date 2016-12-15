package tech.lese.demo.other.neoman.params;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PreInputSetParam {

	


	public static class RecItemEnity {
		private Object  iID;//：预录记录ID,大于零，表明为记录数据修改，否则，为新记录添加。必须提供，且必须是记录对象的第一个参数（将用于辅助定界）！
		private Object  nItemType;//：快件类型，默认为1。取值为：0(文件),1(包裹),2(防水袋)
		private Object  nLanguage;//：地域语言，默认为0。取值为：0(中国大陆),1(华语),2(其它地域)
		private Object  cEmsKind;//：快递类别,1-15字符，必须。
		private Object  cEmsKindc;//：快递类别(客户要求),1-15字符。
		private Object  cEmsKindw;//：快递类别(客户希望),1-15字符。
		private Object  cAddrFrom;//：出发地,0-63字符。
		private Object  cDes;//：目的地,1-63字符，必须。
		private Object  fWeight;//：重量，公斤，3位小数。
		private Object  iLong;//：长，厘米。
		private Object  iWidth;//：宽，厘米。
		private Object  iHeight;//：高，厘米。
		private Object  iItem;//：件数，默认1。
		private Object  nPayWay;//：付款方式，默认为0。取值为：0(月结),1(现付),2(到付)
		private Object  fAmount;//：快递费，2位小数。
		
		private Object  cReceiver;//：收件人,0-63字符。
		private Object  cRUnit;//：收件单位,0-254字符。
		private Object  cRAddr;//：收件地址,0-254字符。
		private Object  cRCity;//：收件城市,0-126字符。
		private Object  cRPostcode;//：收件邮编,0-15字符。
		private Object  cRProvince;//：收件省州,0-63字符。
		private Object  cRCountry;//：收件国家,0-126字符。
		private Object  cRPhone;//：收件电话,0-63字符。
		private Object  cREMail;//：收件电邮,0-63字符。
		private Object  cRSms;//：收件短信,0-22字符。
		private Object  cRIDCard;//：收件证照号,0-30字符。
		
		
		private Object  cNum;//：内单号,7-30字符。(通常为系统配置自动生成)
		private Object  cNo;//：转单号,7-30字符。
		private Object  cRNo;//：参考号,0-30字符。
		private Object  cCNo;//：报关号,0-30字符。
		
		
		private Object  cSender;//：发件人,0-30字符。
		private Object  cSUnit;//：发件单位,0-127字符。
		private Object  cSAddr;//：发件地址,0-127字符。
		private Object  cSCity;//：发件城市,0-63字符。
		private Object  cSPostcode;//：发件邮编,0-15字符。
		private Object  cSProvince;//：发件省州,0-30字符。
		private Object  cSCountry;//：发件国家,0-63字符。
		private Object  cSPhone;//：发件电话,0-63字符。
		private Object  cSEMail;//：发件电邮,0-63字符。
		private Object  cSSms;//：发件短信,0-22字符。
		private Object  cSIDCard;//：发件证照号,0-30字符。
		private Object  cDepart;//：所属部门,0-30字符。
		
		private Object  cMark;//：标签,0-15字符。
		private Object  cMemo;//：备注,0-254字符。
		private Object  cReserve;//：留用串,0-30字符。
		private Object  iReserve;//：留用数，默认0
		private Object  cBy1;//：备用1,0-63字符。
		private Object  cBy2;//：备用2,0-63字符。
		private Object  cBy3;//：备用3,0-63字符。
		private Object  cBy4;//：备用4,0-63字符。
		private Object  cBy5;//：备用5,0-254字符。
		private Object GoodsList;//物品列表
		
		
		
		/**
		 * 单个物品时取值，与多个物品相区别。
		 */
		private Object  cGoods;//：物品描述,0-254字符。
		private Object  iQuantity;//：物品数量，默认0
		private Object  fPrice;//：物品单价，2位小数。
		private Object  cMoney;//：货币代码，0-3字符。==
		private Object  fGoods;//：物品货值，代收货款收件人支付的货值，2位小数。==
		private Object  fGoodsc;//：物品返回客户货值，代收货款向客户返还的货值，2位小数。==
		private Object  fDValue;//：物品声明价，2位小数。==
		private Object  fIValue;//：物品投保价，2位小数。==
		private Object  cPayDir;//：结算指示，0-3字符。==
		private Object  cOrigin;//：原产地国家代码，0-3字符。==
		private Object  cGoodsA;//：物品别名，通常为英文描述,0-254字符。
		private Object  cGCodeA;//：物品甲码，通常为HS编码,0-63字符。
		private Object  cGCodeB;//：物品乙码，通常为统一编码,0-63字符。
		private Object  cGCodeC;//：物品丙码，通常为客户编码,0-63字符。
		private Object  cGUnit;//：物品单位，0-15字符。
		private Object  fGCustom;//：关税额，2位小数。
		private Object  fGCRate;//：税率，4位小数。
		private Object  fgWeight;//：物品净重，3位小数。
		
		public Object getiID() {
			return iID;
		}
		public void setiID(Object iID) {
			this.iID = iID;
		}
		public Object getnItemType() {
			return nItemType;
		}
		public void setnItemType(Object nItemType) {
			this.nItemType = nItemType;
		}
		public Object getnLanguage() {
			return nLanguage;
		}
		public void setnLanguage(Object nLanguage) {
			this.nLanguage = nLanguage;
		}
		public Object getcEmsKind() {
			return cEmsKind;
		}
		public void setcEmsKind(Object cEmsKind) {
			this.cEmsKind = cEmsKind;
		}
		public Object getcEmsKindc() {
			return cEmsKindc;
		}
		public void setcEmsKindc(Object cEmsKindc) {
			this.cEmsKindc = cEmsKindc;
		}
		public Object getcEmsKindw() {
			return cEmsKindw;
		}
		public void setcEmsKindw(Object cEmsKindw) {
			this.cEmsKindw = cEmsKindw;
		}
		public Object getcAddrFrom() {
			return cAddrFrom;
		}
		public void setcAddrFrom(Object cAddrFrom) {
			this.cAddrFrom = cAddrFrom;
		}
		public Object getcDes() {
			return cDes;
		}
		public void setcDes(Object cDes) {
			this.cDes = cDes;
		}
		public Object getfWeight() {
			return fWeight;
		}
		public void setfWeight(Object fWeight) {
			this.fWeight = fWeight;
		}
		public Object getiLong() {
			return iLong;
		}
		public void setiLong(Object iLong) {
			this.iLong = iLong;
		}
		public Object getiWidth() {
			return iWidth;
		}
		public void setiWidth(Object iWidth) {
			this.iWidth = iWidth;
		}
		public Object getiHeight() {
			return iHeight;
		}
		public void setiHeight(Object iHeight) {
			this.iHeight = iHeight;
		}
		public Object getiItem() {
			return iItem;
		}
		public void setiItem(Object iItem) {
			this.iItem = iItem;
		}
		public Object getnPayWay() {
			return nPayWay;
		}
		public void setnPayWay(Object nPayWay) {
			this.nPayWay = nPayWay;
		}
		public Object getfAmount() {
			return fAmount;
		}
		public void setfAmount(Object fAmount) {
			this.fAmount = fAmount;
		}
		public Object getcReceiver() {
			return cReceiver;
		}
		public void setcReceiver(Object cReceiver) {
			this.cReceiver = cReceiver;
		}
		public Object getcRUnit() {
			return cRUnit;
		}
		public void setcRUnit(Object cRUnit) {
			this.cRUnit = cRUnit;
		}
		public Object getcRAddr() {
			return cRAddr;
		}
		public void setcRAddr(Object cRAddr) {
			this.cRAddr = cRAddr;
		}
		public Object getcRCity() {
			return cRCity;
		}
		public void setcRCity(Object cRCity) {
			this.cRCity = cRCity;
		}
		public Object getcRPostcode() {
			return cRPostcode;
		}
		public void setcRPostcode(Object cRPostcode) {
			this.cRPostcode = cRPostcode;
		}
		public Object getcRProvince() {
			return cRProvince;
		}
		public void setcRProvince(Object cRProvince) {
			this.cRProvince = cRProvince;
		}
		public Object getcRCountry() {
			return cRCountry;
		}
		public void setcRCountry(Object cRCountry) {
			this.cRCountry = cRCountry;
		}
		public Object getcRPhone() {
			return cRPhone;
		}
		public void setcRPhone(Object cRPhone) {
			this.cRPhone = cRPhone;
		}
		public Object getcREMail() {
			return cREMail;
		}
		public void setcREMail(Object cREMail) {
			this.cREMail = cREMail;
		}
		public Object getcRSms() {
			return cRSms;
		}
		public void setcRSms(Object cRSms) {
			this.cRSms = cRSms;
		}
		public Object getcRIDCard() {
			return cRIDCard;
		}
		public void setcRIDCard(Object cRIDCard) {
			this.cRIDCard = cRIDCard;
		}
		public Object getcNum() {
			return cNum;
		}
		public void setcNum(Object cNum) {
			this.cNum = cNum;
		}
		public Object getcNo() {
			return cNo;
		}
		public void setcNo(Object cNo) {
			this.cNo = cNo;
		}
		public Object getcRNo() {
			return cRNo;
		}
		public void setcRNo(Object cRNo) {
			this.cRNo = cRNo;
		}
		public Object getcCNo() {
			return cCNo;
		}
		public void setcCNo(Object cCNo) {
			this.cCNo = cCNo;
		}
		public Object getcSender() {
			return cSender;
		}
		public void setcSender(Object cSender) {
			this.cSender = cSender;
		}
		public Object getcSUnit() {
			return cSUnit;
		}
		public void setcSUnit(Object cSUnit) {
			this.cSUnit = cSUnit;
		}
		public Object getcSAddr() {
			return cSAddr;
		}
		public void setcSAddr(Object cSAddr) {
			this.cSAddr = cSAddr;
		}
		public Object getcSCity() {
			return cSCity;
		}
		public void setcSCity(Object cSCity) {
			this.cSCity = cSCity;
		}
		public Object getcSPostcode() {
			return cSPostcode;
		}
		public void setcSPostcode(Object cSPostcode) {
			this.cSPostcode = cSPostcode;
		}
		public Object getcSProvince() {
			return cSProvince;
		}
		public void setcSProvince(Object cSProvince) {
			this.cSProvince = cSProvince;
		}
		public Object getcSCountry() {
			return cSCountry;
		}
		public void setcSCountry(Object cSCountry) {
			this.cSCountry = cSCountry;
		}
		public Object getcSPhone() {
			return cSPhone;
		}
		public void setcSPhone(Object cSPhone) {
			this.cSPhone = cSPhone;
		}
		public Object getcSEMail() {
			return cSEMail;
		}
		public void setcSEMail(Object cSEMail) {
			this.cSEMail = cSEMail;
		}
		public Object getcSSms() {
			return cSSms;
		}
		public void setcSSms(Object cSSms) {
			this.cSSms = cSSms;
		}
		public Object getcSIDCard() {
			return cSIDCard;
		}
		public void setcSIDCard(Object cSIDCard) {
			this.cSIDCard = cSIDCard;
		}
		public Object getcDepart() {
			return cDepart;
		}
		public void setcDepart(Object cDepart) {
			this.cDepart = cDepart;
		}
		public Object getcMark() {
			return cMark;
		}
		public void setcMark(Object cMark) {
			this.cMark = cMark;
		}
		public Object getcMemo() {
			return cMemo;
		}
		public void setcMemo(Object cMemo) {
			this.cMemo = cMemo;
		}
		public Object getcReserve() {
			return cReserve;
		}
		public void setcReserve(Object cReserve) {
			this.cReserve = cReserve;
		}
		public Object getiReserve() {
			return iReserve;
		}
		public void setiReserve(Object iReserve) {
			this.iReserve = iReserve;
		}
		public Object getcBy1() {
			return cBy1;
		}
		public void setcBy1(Object cBy1) {
			this.cBy1 = cBy1;
		}
		public Object getcBy2() {
			return cBy2;
		}
		public void setcBy2(Object cBy2) {
			this.cBy2 = cBy2;
		}
		public Object getcBy3() {
			return cBy3;
		}
		public void setcBy3(Object cBy3) {
			this.cBy3 = cBy3;
		}
		public Object getcBy4() {
			return cBy4;
		}
		public void setcBy4(Object cBy4) {
			this.cBy4 = cBy4;
		}
		public Object getcBy5() {
			return cBy5;
		}
		public void setcBy5(Object cBy5) {
			this.cBy5 = cBy5;
		}
		@JsonProperty(value="GoodsList")
		public Object getGoodsList() {
			return GoodsList;
		}
		public void setGoodsList(List<GoodsEntity> goodsList) {
			this.GoodsList = goodsList;
		}
		public Object getcGoods() {
			return cGoods;
		}
		public void setcGoods(Object cGoods) {
			this.cGoods = cGoods;
		}
		public Object getiQuantity() {
			return iQuantity;
		}
		public void setiQuantity(Object iQuantity) {
			this.iQuantity = iQuantity;
		}
		public Object getfPrice() {
			return fPrice;
		}
		public void setfPrice(Object fPrice) {
			this.fPrice = fPrice;
		}
		public Object getcMoney() {
			return cMoney;
		}
		public void setcMoney(Object cMoney) {
			this.cMoney = cMoney;
		}
		public Object getfGoods() {
			return fGoods;
		}
		public void setfGoods(Object fGoods) {
			this.fGoods = fGoods;
		}
		public Object getfGoodsc() {
			return fGoodsc;
		}
		public void setfGoodsc(Object fGoodsc) {
			this.fGoodsc = fGoodsc;
		}
		public Object getfDValue() {
			return fDValue;
		}
		public void setfDValue(Object fDValue) {
			this.fDValue = fDValue;
		}
		public Object getfIValue() {
			return fIValue;
		}
		public void setfIValue(Object fIValue) {
			this.fIValue = fIValue;
		}
		public Object getcPayDir() {
			return cPayDir;
		}
		public void setcPayDir(Object cPayDir) {
			this.cPayDir = cPayDir;
		}
		public Object getcOrigin() {
			return cOrigin;
		}
		public void setcOrigin(Object cOrigin) {
			this.cOrigin = cOrigin;
		}
		public Object getcGoodsA() {
			return cGoodsA;
		}
		public void setcGoodsA(Object cGoodsA) {
			this.cGoodsA = cGoodsA;
		}
		public Object getcGCodeA() {
			return cGCodeA;
		}
		public void setcGCodeA(Object cGCodeA) {
			this.cGCodeA = cGCodeA;
		}
		public Object getcGCodeB() {
			return cGCodeB;
		}
		public void setcGCodeB(Object cGCodeB) {
			this.cGCodeB = cGCodeB;
		}
		public Object getcGCodeC() {
			return cGCodeC;
		}
		public void setcGCodeC(Object cGCodeC) {
			this.cGCodeC = cGCodeC;
		}
		public Object getcGUnit() {
			return cGUnit;
		}
		public void setcGUnit(Object cGUnit) {
			this.cGUnit = cGUnit;
		}
		public Object getfGCustom() {
			return fGCustom;
		}
		public void setfGCustom(Object fGCustom) {
			this.fGCustom = fGCustom;
		}
		public Object getfGCRate() {
			return fGCRate;
		}
		public void setfGCRate(Object fGCRate) {
			this.fGCRate = fGCRate;
		}
		public Object getFgWeight() {
			return fgWeight;
		}
		public void setFgWeight(Object fgWeight) {
			this.fgWeight = fgWeight;
		}
		
		
		
	}	
	
	
	/**
	 * 多个物品时，每个物品的key值
	 * @author LENOVO
	 *
	 */
	public static class GoodsEntity {
		/**
		 * 
		 */
		private Object  cxGoods;//：物品描述,0-63字符。必须。
		private Object  ixQuantity;//：物品数量。必须。
		private Object  fxPrice;//：物品单价，2位小数。
		private Object  cxGoodsA;//：物品别名，通常为英文描述,0-63字符。
		private Object  cxGCodeA;//：物品甲码，通常为HS编码,0-63字符。
		private Object  cxGCodeB;//：物品乙码，通常为统一编码,0-63字符。
		private Object  cxGCodeC;//：物品丙码，通常为客户编码,0-63字符。
		private Object  cxGUnit;//：物品单位，0-15字符。
		private Object  fxGCustom;//：关税额，2位小数。
		private Object  fxGCRate;//：税率，4位小数。
		private Object  fxgWeight;//：物品净重，3位小数。
		public Object getCxGoods() {
			return cxGoods;
		}
		public void setCxGoods(Object cxGoods) {
			this.cxGoods = cxGoods;
		}
		public Object getIxQuantity() {
			return ixQuantity;
		}
		public void setIxQuantity(Object ixQuantity) {
			this.ixQuantity = ixQuantity;
		}
		public Object getFxPrice() {
			return fxPrice;
		}
		public void setFxPrice(Object fxPrice) {
			this.fxPrice = fxPrice;
		}
		public Object getCxGoodsA() {
			return cxGoodsA;
		}
		public void setCxGoodsA(Object cxGoodsA) {
			this.cxGoodsA = cxGoodsA;
		}
		public Object getCxGCodeA() {
			return cxGCodeA;
		}
		public void setCxGCodeA(Object cxGCodeA) {
			this.cxGCodeA = cxGCodeA;
		}
		public Object getCxGCodeB() {
			return cxGCodeB;
		}
		public void setCxGCodeB(Object cxGCodeB) {
			this.cxGCodeB = cxGCodeB;
		}
		public Object getCxGCodeC() {
			return cxGCodeC;
		}
		public void setCxGCodeC(Object cxGCodeC) {
			this.cxGCodeC = cxGCodeC;
		}
		public Object getCxGUnit() {
			return cxGUnit;
		}
		public void setCxGUnit(Object cxGUnit) {
			this.cxGUnit = cxGUnit;
		}
		public Object getFxGCustom() {
			return fxGCustom;
		}
		public void setFxGCustom(Object fxGCustom) {
			this.fxGCustom = fxGCustom;
		}
		public Object getFxGCRate() {
			return fxGCRate;
		}
		public void setFxGCRate(Object fxGCRate) {
			this.fxGCRate = fxGCRate;
		}
		public Object getFxgWeight() {
			return fxgWeight;
		}
		public void setFxgWeight(Object fxgWeight) {
			this.fxgWeight = fxgWeight;
		}
		
		
	}
	

}
