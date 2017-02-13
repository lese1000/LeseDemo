package tech.lese.demo.common.utils;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import Decoder.BASE64Decoder;

/**
 * 文件上传辅助类_lese_m
 * 
 */
public class UploadHelper {
	

	// 文件大小常量, 单位kb
	private static final int MAX_SIZE = 500 * 1024;
	// 输出文件地址
	private String url = "";
	// 上传文件名
	private String fileName = "";
	// 状态
	private String state = "";
	// 文件类型
	private String type = "";
	// 原始文件名
	private String originalName = "";
	// 文件大小
	private String size = "";

	private HttpServletRequest request = null;
	private String title = "";

	// 默认保存的一级路径
	private String rootDir = "upload";
	//当前项目名称
	private String curProjectName="";
	//是否使用spring的multipartResolver,默认为否。
	
	// 文件允许格式
	private String[] allowFiles = { ".rar", ".doc", ".docx", ".zip", ".pdf",
			".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	// 文件大小限制，单位Byte
	private long maxSize = 0;

	private HashMap<String, String> errorInfo = new HashMap<String, String>();
	private Map<String, String> params = null;
	// 上传的文件数据
	private InputStream inputStream = null;

	public static final String ENCODEING = System.getProperties().getProperty(
			"file.encoding");
	
	

	/**
	 * 构造函数 接受 ：MultipartHttpServletRequest 或者 HttpServletRequest 的对象，并根据对象类型自动采用相应的保存方式
	 * 1）MultipartHttpServletRequest :采用该方式，需要在spring-mvc.xml配置文件中配置：multipartResolver。
	 * 2）HttpServletRequest：不需要在spring-mvc.xml配置.采用apache的jar包方式保存上传文件。
	 * 注:配置了multipartResolver，则apache的jar包方式保存上传文件将获取不到文件。
	 * @param request
	 */
	public UploadHelper(HttpServletRequest request) {
		this.request = request;
		this.curProjectName=request.getContextPath();
		//初始化信息
		this.initInfo();
		//解析参数
		this.parseParams();

	}
	
	/**
	 * 该构造函数针对 spring的 MultipartHttpServletRequest
	 * 采用该方式，需要在spring-mvc.xml配置文件中配置：multipartResolver。
	 * 该方式会与Apache的jar包上传冲突。
	 * @param file
	 */
	public UploadHelper(MultipartFile files){
		//初始化信息
		this.initInfo();
	}
	
	//1)
	private void initInfo(){
		this.params = new HashMap<String, String>();
		this.setMaxSize(UploadHelper.MAX_SIZE);
		this.errorInfo.put("SUCCESS", "SUCCESS"); // 默认成功
		// 未包含文件上传域
		this.errorInfo.put("NOFILE",
				"未包含文件上传域");
		// 不允许的文件格式
		this.errorInfo.put("TYPE",
				"不允许的文件格式");
		// 文件大小超出限制
		this.errorInfo.put("SIZE",
				"文件大小超出限制");
		// 请求类型错误
		this.errorInfo.put("ENTYPE", "请求类型错误");
		// 上传请求异常
		this.errorInfo.put("REQUEST", "上传请求异常");
		// 未找到上传文件
		this.errorInfo.put("FILE", "未找到上传文件");
		// IO异常
		this.errorInfo.put("IO", "IO异常");
		// 目录创建失败
		this.errorInfo.put("DIR", "目录创建失败");
		// 未知错误
		this.errorInfo.put("UNKNOWN", "未知错误");
	}
	
	//2)
	private void parseParams() {

		DiskFileItemFactory dff = new DiskFileItemFactory();
		try {
			ServletFileUpload sfu = new ServletFileUpload(dff);
			sfu.setSizeMax(this.maxSize);
			sfu.setHeaderEncoding(UploadHelper.ENCODEING);

			FileItemIterator fii = sfu.getItemIterator(this.request);

			while (fii.hasNext()) {
				
				FileItemStream item = fii.next();
				// 普通参数存储
				if (item.isFormField()) {

					this.params.put(item.getFieldName(),
							this.getParameterValue(item.openStream()));

				} else {

					// 只保留一个
					if (this.inputStream == null) {
						this.inputStream = item.openStream();
						this.originalName = item.getName();
						return;
					}

				}

			}

		} catch (Exception e) {
			this.state = this.errorInfo.get("UNKNOWN");
		}

	}

	/**
	 * 调用该方法执行上传操作
	 * @throws Exception
	 */
	public void upload() throws Exception {
		//判断是否为spring的MultipartHttpServletRequest
		if(this.request instanceof MultipartHttpServletRequest){
			MultiValueMap<String, MultipartFile> fileMap = ((MultipartHttpServletRequest) this.request).getMultiFileMap();
			if(null!=fileMap&&!fileMap.isEmpty()){
				for(List<MultipartFile> fileList: fileMap.values()){
					for(MultipartFile file:fileList){
						if (null != file && !file.isEmpty()) {
							this.saveMultipartFile(file);				//执行上传
							this.state = this.errorInfo.get("SUCCESS");
						}else{
							this.state = this.errorInfo.get("FILE");
						}
					}
				}
			}else{
				this.state = this.errorInfo.get("NOFILE");
				return;
			}
			
		}else{
			boolean isMultipart = ServletFileUpload
					.isMultipartContent(this.request);
			if (!isMultipart) {
				this.state = this.errorInfo.get("NOFILE");
				return;
			}

			if (this.inputStream == null) {
				this.state = this.errorInfo.get("FILE");
				return;
			}

			// 存储title====尚未使用
			this.title = this.getParameter("pictitle");

			try {
				String savePath = this.generateFolder(this.rootDir);

				if (!this.checkFileType(this.originalName)) {
					this.state = this.errorInfo.get("TYPE");
					return;
				}

				this.fileName = this.getNewFileName(this.originalName);
				this.type = this.getFileExt(this.fileName);
				this.url = savePath + "/" + this.fileName;

				FileOutputStream fos = new FileOutputStream(
						this.getPhysicalPath(this.url));
				BufferedInputStream bis = new BufferedInputStream(this.inputStream);
				byte[] buff = new byte[128];
				int count = -1;

				while ((count = bis.read(buff)) != -1) {

					fos.write(buff, 0, count);

				}

				bis.close();
				fos.close();

				this.state = this.errorInfo.get("SUCCESS");
			} catch (Exception e) {
				e.printStackTrace();
				this.state = this.errorInfo.get("IO");
			}
		}
		

	}

	/**
	 * 接受并保存以base64格式上传的文件
	 * 
	 * @param fieldName
	 */
	public void uploadBase64(String fieldName) {
		String savePath = this.generateFolder(this.rootDir);
		String base64Data = this.request.getParameter(fieldName);
		this.fileName = this.getNewFileName("test.png");
		this.url = savePath + "/" + this.fileName;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(this.getPhysicalPath(this.url));
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
			this.state = this.errorInfo.get("SUCCESS");
		} catch (Exception e) {
			this.state = this.errorInfo.get("IO");
		}
	}

	public String getParameter(String name) {

		return this.params.get(name);

	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	private String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	


	/**
	 * 依据原始文件名生成新文件名
	 * 
	 * @return
	 */
	private String getNewFileName(String originalFileName) {
		Random random = new Random();
		return this.fileName = "" + random.nextInt(10000)
				+ System.currentTimeMillis() + this.getFileExt(originalFileName);
	}

	/**
	 * 根据传入的path创建本地目录， 并按照日期创建子目录
	 * 
	 * @param path
	 * @return
	 */
	private String generateFolder(String path) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		path += "/" + formater.format(new Date());
		File dir = new File(this.getPhysicalPath(path));
		if (!dir.exists()) {
			try {
				dir.mkdirs();
			} catch (Exception e) {
				this.state = this.errorInfo.get("DIR");
				return "";
			}
		}
		return path;
	}

	/**
	 * 拼接保存文件的物理路径:base.upload.path+生成的文件名
	 * 
	 * @param path
	 * @return
	 */
	private String getPhysicalPath(String path) {
		
		return getAutoSavePath()+"/"+path;//自动选择保存路径
	}
	
	/**
	 * 1）指定保存的路径。不限盘
	 * @return
	 */
	private String getPreSetSavePath(){
		return AppConfigurator.getProperty("base.upload.path");
	}
	/**
	 * 2）当未指定保存的路径时，获取保存文件的'资源项目'名称，固定格式为:当前项目名_res
	 * @return
	 */
	private String getCurProjectResName(){
		return this.getCurProjectName()+"_res";
	}
	/**
	 * 自动选择保存文件路径，
	 * 1)当配置保存路径时,使用配置的路径。
	 * 2）否则使用默认设置，即在webapp目录下生成‘项目名_res’格式文件夹保存
	 * @return
	 */
	public String getAutoSavePath(){
		if(null==getPreSetSavePath()||"".equals(getPreSetSavePath())){
			return getCurProjectParentPath()+"/"+getCurProjectResName();
		}else{
			return getPreSetSavePath();
		}
	}
	/**
	 * 获取当前项目的父目录。即webapp的绝对路径
	 * @return
	 */
	private String getCurProjectParentPath(){
		String path = this.request.getServletContext().getRealPath("");//F:\devtools\apache-tomcat-7.0.55\webapps\wuliu
		return new File(path).getParent();
	}
	

	/**
	 * 从输入流中获取字符串数据
	 * 
	 * @param in
	 *            给定的输入流， 结果字符串将从该流中读取
	 * @return 从流中读取到的字符串
	 */
	private String getParameterValue(InputStream in) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String result = "";
		String tmpString = null;

		try {

			while ((tmpString = reader.readLine()) != null) {
				result += tmpString;
			}

		} catch (Exception e) {
			// do nothing
		}

		return result;

	}
	
	private byte[] getFileOutputStream(InputStream in) {

		try {
			return IOUtils.toByteArray(in);
		} catch (IOException e) {
			return null;
		}

	}
	
	//======以下两个方法用于MultipartFile 保存文件=============================
	
	/**
	 * @param file 			//文件对象
	 * @param filePath		//上传路径
	 * @param fileName		//文件名
	 * @return  文件名
	 */
	private  void saveMultipartFile(MultipartFile file){
		try {
			String tmpSavePath = this.generateFolder(this.rootDir);
			this.originalName=file.getOriginalFilename();
			this.fileName = this.getNewFileName(file.getOriginalFilename());
			this.type = this.getFileExt(file.getOriginalFilename());
			this.url = tmpSavePath + "/" + this.fileName;
			
			copyFile(file.getInputStream(), this.getPhysicalPath(this.url));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * 写文件到当前目录的upload目录中
	 * 
	 * @param in
	 * @param fileName
	 * @throws IOException
	 */
	private  void copyFile(InputStream in, String fileName)
			throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		FileUtils.copyInputStreamToFile(in, file);
	}
	
	//======以上两个方法用于MultipartFile 保存文件=============================

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public void setAllowFiles(String[] allowFiles) {
		this.allowFiles = allowFiles;
	}

	public void setMaxSize(long size) {
		this.maxSize = size * 1024;
	}

	public String getSize() {
		return this.size;
	}

	public String getUrl() {
		return this.url;
	}

	public String getFileName() {
		return this.fileName;
	}

	public String getState() {
		return this.state;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String getOriginalName() {
		return this.originalName;
	}

	public String getCurProjectName() {
		return curProjectName;
	}

	public void setCurProjectName(String curProjectName) {
		this.curProjectName = curProjectName;
	}

	
	
}