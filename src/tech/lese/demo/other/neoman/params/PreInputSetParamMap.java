package tech.lese.demo.other.neoman.params;

import java.util.HashMap;
import java.util.List;

public class PreInputSetParamMap extends HashMap<Object, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2262624834073921012L;
	
	public static class RecItemEnity extends HashMap<Object, Object>{
	/*	private Object  iID;//：预录记录ID,大于零，表明为记录数据修改，否则，为新记录添加。必须提供，且必须是记录对象的第一个参数（将用于辅助定界）！
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
*/		
		
		public void setGoodsList(List<GoodsEntity> goodsList) {
			this.put("GoodsList", goodsList);
		}
		public void setiID(Object iID) {
			this.put("iID", iID);
		}
		public void setnItemType(Object nItemType) {
			this.put("nItemType", nItemType);
		}
		public void setnLanguage(Object nLanguage) {
			this.put("nLanguage", nLanguage);
		}
		public void setcEmsKind(Object cEmsKind) {
			this.put("cEmsKind", cEmsKind);
		}
		public void setcEmsKindc(Object cEmsKindc) {
			this.put("cEmsKindc",cEmsKindc);
		}
		public void setcEmsKindw(Object cEmsKindw) {
			this.put("cEmsKindw",cEmsKindw);
		}
		public void setcAddrFrom(Object cAddrFrom) {
			this.put("cAddrFrom", cAddrFrom);
		}
		public void setcDes(Object cDes) {
			this.put("cDes", cDes);
		}
		public void setfWeight(Object fWeight) {
			this.put("fWeight", fWeight);
		}
		public void setiLong(Object iLong) {
			this.put("iLong", iLong);
		}
		public void setiWidth(Object iWidth) {
			this.put("iWidth", iWidth);
		}
		public void setiHeight(Object iHeight) {
			this.put("iHeight", iHeight);
		}
		public void setiItem(Object iItem) {
			this.put("iItem", iItem);
		}
		public void setnPayWay(Object nPayWay) {
			this.put("nPayWay", nPayWay);
		}
		public void setfAmount(Object fAmount) {
			this.put("fAmount", fAmount);
		}
		public void setcReceiver(Object cReceiver) {
			this.put("cReceiver", cReceiver);
		}
		public void setcRUnit(Object cRUnit) {
			this.put("cRUnit", cRUnit);
		}
		public void setcRAddr(Object cRAddr) {
			this.put("cRAddr", cRAddr);
		}
		public void setcRCity(Object cRCity) {
			this.put("cRCity", cRCity);
		}
		public void setcRPostcode(Object cRPostcode) {
			this.put("cRPostcode", cRPostcode);
		}
		public void setcRProvince(Object cRProvince) {
			this.put("cRProvince", cRProvince);
		}
		public void setcRCountry(Object cRCountry) {
			this.put("cRCountry", cRCountry);
		}
		public void setcRPhone(Object cRPhone) {
			this.put("cRCountry", cRPhone);
		}
		public void setcREMail(Object cREMail) {
			this.put("cREMail", cREMail);
		}
		public void setcRSms(Object cRSms) {
			this.put("cRSms", cRSms);
		}
		public void setcRIDCard(Object cRIDCard) {
			this.put("cRIDCard", cRIDCard);
		}
		public void setcNum(Object cNum) {
			this.put("cNum", cNum);
		}
		public void setcNo(Object cNo) {
			this.put("cNo", cNo);
		}
		public void setcRNo(Object cRNo) {
			this.put("cRNo", cRNo);
		}
		public void setcCNo(Object cCNo) {
			this.put("cCNo", cCNo);
		}
		public void setcSender(Object cSender) {
			this.put("cSender", cSender);
		}
		public void setcSUnit(Object cSUnit) {
			this.put("cSUnit", cSUnit);
		}
		public void setcSAddr(Object cSAddr) {
			this.put("cSAddr", cSAddr);
		}
		public void setcSCity(Object cSCity) {
			this.put("cSCity", cSCity);
		}
		public void setcSPostcode(Object cSPostcode) {
			this.put("cSPostcode", cSPostcode);
		}
		public void setcSProvince(Object cSProvince) {
			this.put("cSProvince", cSProvince);
		}
		public void setcSCountry(Object cSCountry) {
			this.put("cSCountry", cSCountry);
		}
		public void setcSPhone(Object cSPhone) {
			this.put("cSPhone", cSPhone);
		}
		public void setcSEMail(Object cSEMail) {
			this.put("cSEMail", cSEMail);
		}
		public void setcSSms(Object cSSms) {
			this.put("cSSms", cSSms);
		}
		public void setcSIDCard(Object cSIDCard) {
			this.put("cSIDCard", cSIDCard);
		}
		public void setcDepart(Object cDepart) {
			this.put("cDepart", cDepart);
		}
		public void setcMark(Object cMark) {
			this.put("cMark", cMark);
		}
		public void setcMemo(Object cMemo) {
			this.put("cMemo", cMemo);
		}
		public void setcReserve(Object cReserve) {
			this.put("cReserve", cReserve);
		}
		public void setiReserve(Object iReserve) {
			this.put("iReserve", iReserve);
		}
		public void setcBy1(Object cBy1) {
			this.put("cBy1", cBy1);
		}
		public void setcBy2(Object cBy2) {
			this.put("cBy2", cBy2);
		}
		public void setcBy3(Object cBy3) {
			this.put("cBy3", cBy3);
		}
		public void setcBy4(Object cBy4) {
			this.put("cBy4", cBy4);
		}
		public void setcBy5(Object cBy5) {
			this.put("cBy5", cBy5);
		}
		
		/**
		 * 单个物品时取值，与多个物品相区别。
		 */
		/*private Object  cGoods;//：物品描述,0-254字符。
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
*/		
		public void setcGoods(Object cGoods) {
			this.put("cGoods", cGoods);
		}
		public void setiQuantity(Object iQuantity) {
			this.put("iQuantity", iQuantity);
		}
		public void setfPrice(Object fPrice) {
			this.put("fPrice", fPrice);
		}
		public void setcMoney(Object cMoney) {
			this.put("cMoney", cMoney);
		}
		public void setfGoods(Object fGoods) {
			this.put("fGoods", fGoods);
		}
		public void setfGoodsc(Object fGoodsc) {
			this.put("fGoodsc", fGoodsc);
		}
		public void setfDValue(Object fDValue) {
			this.put("fDValue", fDValue);
		}
		public void setfIValue(Object fIValue) {
			this.put("fIValue", fIValue);
		}
		public void setcPayDir(Object cPayDir) {
			this.put("cPayDir", cPayDir);
		}
		public void setcOrigin(Object cOrigin) {
			this.put("cOrigin", cOrigin);
		}
		public void setcGoodsA(Object cGoodsA) {
			this.put("cGoodsA", cGoodsA);
		}
		public void setcGCodeA(Object cGCodeA) {
			this.put("cGCodeA", cGCodeA);
		}
		public void setcGCodeB(Object cGCodeB) {
			this.put("cGCodeB", cGCodeB);
		}
		public void setcGCodeC(Object cGCodeC) {
			this.put("cGCodeC", cGCodeC);
		}
		public void setcGUnit(Object cGUnit) {
			this.put("cGUnit", cGUnit);
		}
		public void setfGCustom(Object fGCustom) {
			this.put("fGCustom", fGCustom);
		}
		public void setfGCRate(Object fGCRate) {
			this.put("fGCRate", fGCRate);
		}
		public void setFgWeight(Object fgWeight) {
			this.put("fgWeight", fgWeight);
		}
	}	
	
	
	/**
	 * 多个物品时，每个物品的key值
	 * @author LENOVO
	 *
	 */
	public static class GoodsEntity extends HashMap<Object, Object>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8175588724530512429L;
		/*private Object  cxGoods;//：物品描述,0-63字符。必须。
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
*/		
		public void setCxGoods(Object cxGoods) {
			this.put("cxGoods", cxGoods);
		}
		public void setIxQuantity(Object ixQuantity) {
			this.put("ixQuantity", ixQuantity);
		}
		public void setFxPrice(Object fxPrice) {
			this.put("fxPrice", fxPrice);
		}
		public void setCxGoodsA(Object cxGoodsA) {
			this.put("cxGoodsA", cxGoodsA);
		}
		public void setCxGCodeA(Object cxGCodeA) {
			this.put("cxGCodeA", cxGCodeA);
		}
		public void setCxGCodeB(Object cxGCodeB) {
			this.put("cxGCodeB", cxGCodeB);
		}
		public void setCxGCodeC(Object cxGCodeC) {
			this.put("cxGCodeC", cxGCodeC);
		}
		public void setCxGUnit(Object cxGUnit) {
			this.put("cxGUnit", cxGUnit);
		}
		public void setFxGCustom(Object fxGCustom) {
			this.put("fxGCustom", fxGCustom);
		}
		public void setFxGCRate(Object fxGCRate) {
			this.put("fxGCRate", fxGCRate);
		}
		public void setFxgWeight(Object fxgWeight) {
			this.put("fxgWeight", fxgWeight);
		}
		
	}
	

}
