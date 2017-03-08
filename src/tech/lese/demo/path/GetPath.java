package tech.lese.demo.path;

import java.io.File;
import java.net.URL;

public class GetPath {

	public static void main(String[] args) {
//		getClassPathStyle1();
//		getClassPathStyle2();
//		getClassPathSub();
		getClassBehind();
	}
	
	/**
	 * 获取类加载的路径
	 */
	public static void getClassPathStyle1(){
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
	public static void getClassPathStyle2(){
		URL classPath = GetPath.class.getClassLoader().getResource("");
		System.out.println(classPath);//   file:/H:/LeseRepo/LeseDemo/bin/
		System.out.println(classPath.getPath());//  /H:/LeseRepo/LeseDemo/bin/
	}
	
	//===================根据类加载的路径获取之前路径=========================
	
	public static void getClassPathSub(){
		URL classPath = GetPath.class.getClassLoader().getResource("");
		//1)可直接"../../"这样拼接路径
		String prePath = classPath.getPath()+"../../"+"test/somefiles.txt";
		new File(prePath);//。。。。
		//2)或者用File的getParent()方式获取上一级目录
		System.out.println(new File(classPath.getPath()).getParent());
	}
	
	//===================根据类加载的路径获取之后路径=========================
	
	public static void getClassBehind(){
		URL classPath = GetPath.class.getClassLoader().getResource("spring/config");//不以‘/’开头，在当前目录查找指定的文件路径，不存在则返回null
		System.out.println(classPath.getPath());//因为不存在，报空指针异常。
	}

}
