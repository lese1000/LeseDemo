package tech.lese.demo.other.neoman.params;

import java.util.HashMap;

public class QueryPriceParamMap extends HashMap<String, Object> {
	/*private Object cqFrom;//：快递类别设置中的“站点标示”,0-15字符，一般不提供。
	private Object cqDes;//：目的地，1-63字符，必须提供。可以为目的地编码。
	private Object cqEmsKind;//：快递类别，0-15字符，如提供，则为特定快递类别价格查询，否则提供“nqFilter”筛选的快递类别。
	private Object nqItemType;//：快递类型，数字：0：文件；1：包裹；2：防水袋。
	private Object fqWeight;//：重量，公斤，三位小数。通常理解为称重(如果有长、宽、高数据)
	private Object fqLong;//：长，厘米，一位小数。
	private Object fqWidth;//：宽，厘米，一位小数。
	private Object fqHeight;//：高，厘米，一位小数。
	private Object nqFilter;//：快递类别筛选模式，默认0，全部。1：“客户可见”的快递类别；2：“公布标准价”的快递类别
	*/
	/**
	 * 构造函数中的参数为必填
	 * @param cqDes
	 */
	/*public QueryPriceParamMap(Object cqDes){
		this.setCqDes(cqDes);
	}*/
	public void setCqFrom(Object cqFrom) {
		this.put("cqFrom", cqFrom);
	}
	public void setCqDes(Object cqDes) {
		this.put("cqDes", cqDes);
	}
	public void setCqEmsKind(Object cqEmsKind) {
		this.put("cqEmsKind",cqEmsKind );
	}
	public void setNqItemType(Object nqItemType) {
		this.put("nqItemType", nqItemType);
	}
	public void setFqWeight(Object fqWeight) {
		this.put("fqWeight", fqWeight);
	}
	public void setFqLong(Object fqLong) {
		this.put("fqLong", fqLong);
	}
	public void setFqWidth(Object fqWidth) {
		this.put("fqWidth",fqWidth );
	}
	public void setFqHeight(Object fqHeight) {
		this.put("fqHeight", fqHeight);
	}
	public void setNqFilter(Object nqFilter) {
		this.put("nqFilter", nqFilter);
	}
	
	
}
