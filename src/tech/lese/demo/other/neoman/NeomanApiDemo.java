package tech.lese.demo.other.neoman;

import tech.lese.demo.httpclient.utils.HttpUtils;

public class NeomanApiDemo {
//	private static final String URI="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
	public static void main(String[] args){
//		System.out.println(getClientAuth());
		System.out.println(getTimeStamp());
	}
	
	public static String getClientAuth(){
		 String uri="http://218.244.150.40/cgi-bin/EmsData.dll?Do";
		String params="{\"RequestName\":\"ClientAuth\",\"icID\":80}";
		String result = HttpUtils.doPostByString(uri, params);
		return result;
	}
	public static String getTimeStamp(){
		String uri="http://218.244.150.40/cgi-bin/EmsData.dll?DoApi";
		String params="{\"RequestName\":\"TimeStamp\"}";
		String result = HttpUtils.doPostByString(uri, params);
		return result;
	}
	

}
