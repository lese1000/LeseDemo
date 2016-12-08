package tech.lese.demo.other.neoman.utils;

import java.io.Serializable;
import java.util.HashMap;

public class NeoReqParams extends HashMap<String, Object> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public NeoReqParams(){
		Long timeStamp = NeomanUtils.getUTCTimeStamp();
		this.put("icID", NeomanUtils.getCustomerID());
		this.put("TimeStamp", timeStamp);
		this.put("MD5", NeomanUtils.getMd5(timeStamp));
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
	
	
}
