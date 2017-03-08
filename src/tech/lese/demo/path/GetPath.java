package tech.lese.demo.path;

import java.net.URL;

public class GetPath {

	public static void main(String[] args) {
//		getPathStyle1();
		getPathStyle2();

	}
	
	public static void getPathStyle1(){
		URL classPath = Thread.currentThread().getContextClassLoader().getResource("");
		//在java普通项目中的路径为：file:/H:/LeseRepo/LeseDemo/bin/
		//在web项目中为：file:/E:/workspace2017/FHMYSQL3/WebRoot/WEB-INF/classes/
		System.out.println(classPath);
		//与上述相比，无'file:'前缀。即：/H:/LeseRepo/LeseDemo/bin/
		System.out.println(classPath.getPath());
	}
	
	/**
	 * 获取的结果是同方式1相同。即在普通项目和web项目下获取的路径都是相同的
	 */
	public static void getPathStyle2(){
		URL classPath = GetPath.class.getClassLoader().getResource("");
		System.out.println(classPath);//   file:/H:/LeseRepo/LeseDemo/bin/
		System.out.println(classPath.getPath());//  /H:/LeseRepo/LeseDemo/bin/
	}

}
