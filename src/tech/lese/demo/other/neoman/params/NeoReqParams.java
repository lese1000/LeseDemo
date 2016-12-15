package tech.lese.demo.other.neoman.params;

import java.io.Serializable;
import java.util.HashMap;

import tech.lese.demo.other.neoman.utils.NeomanUtils;

public class NeoReqParams extends HashMap<String, Object> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public NeoReqParams(){
		Long timeStamp = NeomanUtils.getUTCTimeStamp();
		this.put("icID", NeomanUtils.getCustomerID());
		this.put("TimeStamp", timeStamp);
		this.put("MD5", NeomanUtils.getMd5(timeStamp));
	}
	public NeoReqParams(boolean usePda){
		this();
		if(usePda){
			Long timeStamp = NeomanUtils.getUTCTimeStamp();
			this.put("icID", NeomanUtils.getCustomerID());
			this.put("TimeStamp", timeStamp);
			this.put("MD5", NeomanUtils.getMd5UsePda(timeStamp));
		}
		
	}
	
	public void useClientInfo(){
		this.put("RequestName", "ClientInfo");
	}
	public void usePreInputSet(){
		this.put("RequestName", "PreInputSet");
	}
	public void usePreInputDel(){
		this.put("RequestName", "PreInputDel");
	}
	public void usePreInputData(){
		this.put("RequestName", "PreInputData");
	}
	public void usePreInputList(){
		this.put("RequestName", "PreInputList");
	}
	public void useRecList(){
		this.put("RequestName", "RecList");
	}
	public void useEmsKindList(){
		this.put("RequestName", "EmsKindList");
	}
	public void useFeeList(){
		this.put("RequestName", "FeeList");
	}
	public void usePreInputTotal(){
		this.put("RequestName", "PreInputTotal");
	}
	public void useQueryPrice(){
		this.put("RequestName", "QueryPrice");
	}
	public void usePreInputDatab(){
		this.put("RequestName", "PreInputDatab");
	}
	public void useTimeStamp(){
		this.put("RequestName", "TimeStamp");
	}
	public void useRecTransData(){
		this.put("RequestName", "RecTransData");
	}
	public void useRecTransBagList(){
		this.put("RequestName", "RecTransBagList");
	}
	/**
	 * 其签名使用pda密钥(系统用户级别),而不是客户密钥
	 */
	public void useFeeAdd(){
		this.put("RequestName", "FeeAdd");
	}
	
	
}
