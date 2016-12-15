package tech.lese.demo.other.neoman.utils;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import tech.lese.demo.common.utils.MD5;

public class NeomanUtils {
	/**
	 * 获取客户ID
	 * @return
	 */
	public static long getCustomerID(){
		return 514;
	}
	/**
	 * 获取客户密钥
	 * @return
	 */
	private static String getUserKey(){
		return "U0sia2bl44crfwT";
	}
	
	private static String getPdaKey(){
		return "!pok@Ako234nqmor!adF345";
	}
	
	/**
	 * 获取时间戳
	 * @return
	 */
	public static Long getUTCTimeStamp(){
		// 1、取得本地时间：  
        Calendar cal = Calendar.getInstance() ;  
        // 2、取得时间偏移量：  
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);  
        // 3、取得夏令时差：  
        int dstOffset = cal.get(Calendar.DST_OFFSET);  
        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：  
        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset)); 
        return cal.getTimeInMillis();
	}
	
	/**
	 * 根据条件生成md5值
	 * @return
	 */
	public static String getMd5(Long timeStamp){
		return MD5.md5Hex(getCustomerID()+""+timeStamp+getUserKey());
	}
	public static String getMd5(String timeStamp){
		return MD5.md5Hex(getCustomerID()+""+timeStamp+getUserKey());
	}
	public static String getMd5UsePda(Long timeStamp){
		return MD5.md5Hex(getCustomerID()+""+timeStamp+getPdaKey());
	}
	public static String getMd5UsePda(String timeStamp){
		return MD5.md5Hex(getCustomerID()+""+timeStamp+getPdaKey());
	}
	
	public static String toLocalString(String str){
		try {
			return new String(str.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String toNeoString(String str){
		try {
			return new String(str.getBytes("UTF-8"),"iso8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
