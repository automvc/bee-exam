/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.teasoft.bee.logging.Path;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class TestPrepare {
	
//	private static String version="v1.7";
//	private static String version="v1.7.2";
//	private static String version="v1.7.3";
//	private static String version="v1.8";
//	private static String version="v1.8.15";
//	private static String version="v1.8.99";
//	private static String version="v1.9";
//	private static String version="v1.9.8";
//	private static String version="v1.11";
//	private static String version="v1.17";
	
//	private static String version="v2.0";
//	private static String version="v2.1"; //2023
	private static String version="v2.1.8"; //2023.8
	
	public static void init(){
		init("");
	}
	
	public static void init(String identify){
		
		if(identify!=null && !"".equals(identify)){
//			identify="-"+identify+"-";
		}
		
//		if ("fileLogger".equalsIgnoreCase(HoneyConfig.getHoneyConfig().loggerType)) {

			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SS");
			String datetime=df.format(System.currentTimeMillis());

			//		D:\{project-home}\src\main\resources\log
//			String path=System.getProperty("user.dir") + "\\src\\main\\resources\\log" + "\\bee-exam(" + version + ")" + identify
//					+ "{datatime}.txt".replace("{datatime}", datetime);
			
			String path=System.getProperty("user.dir") + ("\\src\\main\\resources\\log" + "\\bee-exam(" + version + ")" 
					+ "{datatime}-"+ identify+".txt").replace("{datatime}", datetime);
			System.out.println("the fileLogger path: "+path);
			//set the path and file name of log file
			Path.setFullPath(path);

			//		Log log=new FileLogger();
			//		LoggerFactory.getLoggerFactory().setLog(log);
		}
//	}

}
