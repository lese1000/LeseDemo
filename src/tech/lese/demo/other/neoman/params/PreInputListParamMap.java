package tech.lese.demo.other.neoman.params;

public class PreInputListParamMap extends BaseQueryParamsMap{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6972735657460665343L;
	/*private Object cqStateMask;//：查询记录筛选：记录状态掩码，共2种状态，用2位0或1表示，1表示筛选，0表示过滤。如未处理（10）,所有(11),已处理(01)            
//    0：未处理
//    1：已处理
	private Object cqDes;//：查询记录筛选：目的地，包含查找
	private Object cqEmsKind;//：查询记录筛选：快递类别
	private Object cqNum;//：查询记录筛选：内单号，包含查找。可以提供用“,”分割的多个运单号，总长度小于12000字节，如"12345,66222,EE772222CN,UP334444HH"，进行多单号精确查询
	private Object cqMark;//：查询记录筛选：标签，包含查找
	private Object cqReserve;//：查询记录筛选：留用串，包含查找
*/	public void setCqStateMask(Object cqStateMask) {
		this.put("cqStateMask",cqStateMask );
	}
	public void setCqDes(Object cqDes) {
		this.put("cqDes", cqDes);
	}
	public void setCqEmsKind(Object cqEmsKind) {
		this.put("cqEmsKind",cqEmsKind );
	}
	public void setCqNum(Object cqNum) {
		this.put("cqNum", cqNum);
	}
	public void setCqMark(Object cqMark) {
		this.put("cqMark", cqMark);
	}
	public void setCqReserve(Object cqReserve) {
		this.put("cqReserve",cqReserve );
	}
	
	

}
