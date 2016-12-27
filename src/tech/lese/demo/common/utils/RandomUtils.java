package tech.lese.demo.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomUtils {
	private static final String RAND_EN_CHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String RAND_NUM_AND_EN_CHAR="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public enum CodeLength {
		FOUR, SIX, EIGHT
	}

	public static void main(String[] args) {
		//1)
		//System.out.println(getRandomNumCode(CodeLength.FOUR));
		//2)中文测试
		 /*char[] words = new char[4];  
		 for (int i = 0; i<words.length; i++) {  
		     words[i] = getRandomZnChar();  
		 }  
		 System.out.println(words); */ 
		 //3)英文随机
		 System.out.println(getRandomNumAndEnChar(CodeLength.FOUR));
	}

	/**
	 * 随机生成数字验证码
	 * 
	 * @param length
	 *            为长度
	 * @return
	 */
	public static String getRandomNumCode(CodeLength length) {
		Random ran = new Random();
		int result = 0;
		switch (length) {
		case SIX:
			result = ran.nextInt(900000)+100000;
			break;
		case EIGHT:
			result = ran.nextInt(90000000)+10000000;
			break;
		default:
			result = ran.nextInt(9000)+1000;
		}
		return result + "";
	}
	
	/**
	 * 随机生成4位数验证码 
	 * @return
	 */
	public static int getFourRandomNum(){
		 Random r = new Random();
		 return r.nextInt(9000)+1000;
	}
	/**
	 * 随机生成6位数验证码 
	 * @return
	 */
	public static int getSixRandomNum(){
		Random r = new Random();
		return r.nextInt(90000000)+10000000;
	}
	/**
	 * 随机生成8位数验证码 
	 * @return
	 */
	public static int getEightRandomNum(){
		Random r = new Random();
		return r.nextInt(900000)+100000;
	}
//==========================================================================
	/**
	 * 随机生成英文验证码
	 * 
	 * @param length为长度
	 * @return
	 */
	public static String getRandomEnChar(CodeLength length) {
		Random ran = new Random();
		String result = "";
		switch (length) {
		case SIX:
			for(int i=0;i<6;i++){
				result =result+ getEnString(ran.nextInt(RAND_EN_CHAR.length()));
			}
			break;
		case EIGHT:
			for(int i=0;i<8;i++){
				result =result+ getEnString(ran.nextInt(RAND_EN_CHAR.length()));
			}
			break;
		case FOUR:
			for(int i=0;i<4;i++){
				result =result+ getEnString(ran.nextInt(RAND_EN_CHAR.length()));
			}
			break;
		}
		return result ;
	}
	public static String getRandomNumAndEnChar(CodeLength length) {
		Random ran = new Random();
		String result = "";
		switch (length) {
		case SIX:
			for(int i=0;i<6;i++){
				result =result+ getNumAndEnString(ran.nextInt(RAND_NUM_AND_EN_CHAR.length()));
			}
			break;
		case EIGHT:
			for(int i=0;i<8;i++){
				result =result+getNumAndEnString(ran.nextInt(RAND_NUM_AND_EN_CHAR.length()));
			}
			break;
		default:
			for(int i=0;i<4;i++){
				result =result+ getNumAndEnString(ran.nextInt(RAND_NUM_AND_EN_CHAR.length()));
			}
		}
		return result ;
	}
	 /*
     * 获取随机的字符
     */
    private static String getEnString(int num){
        return String.valueOf(RAND_EN_CHAR.charAt(num));
    }
    private static String getNumAndEnString(int num){
    	return String.valueOf(RAND_NUM_AND_EN_CHAR.charAt(num));
    }
	//=======================================================================
    /** 
     * 生成随机汉字 ,每次调用获取一个汉字
     * @return 
     */  
    public static char getRandomZnChar() {  
        String str = "";  
        int hightPos;  
        int lowPos;  
  
        Random random = new Random();  
  
        hightPos = (176 + Math.abs(random.nextInt(39)));  
        lowPos = (161 + Math.abs(random.nextInt(93)));  
  
        byte[] b = new byte[2];  
        b[0] = (Integer.valueOf(hightPos)).byteValue();  
        b[1] = (Integer.valueOf(lowPos)).byteValue();  
  
        try {  
            str = new String(b, "GB2312");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
  
        return str.charAt(0);  
    } 

}
