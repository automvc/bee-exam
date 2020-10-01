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
	
//	static String version="v1.7.2";
//	static String version="v1.7.3";
//	static String version="v1.8";
	static String version="v1.8.15";
	
	public static void init(){
		init("");
	}
	
	public static void init(String identify){
		
		if(identify!=null && !"".equals(identify)){
			identify="-"+identify+"-";
		}
		
//		if ("fileLogger".equalsIgnoreCase(HoneyConfig.getHoneyConfig().loggerType)) {

			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SS");
			String datetime=df.format(System.currentTimeMillis());

			//		D:\{project-home}\src\main\resources\log
			String path=System.getProperty("user.dir") + "\\src\\main\\resources\\log" + "\\bee-exam(" + version + ")" + identify
					+ "{datatime}.txt".replace("{datatime}", datetime);
			System.out.println("the fileLogger path: "+path);
			//set the path and file name of log file
			Path.setFullPath(path);

			//		Log log=new FileLogger();
			//		LoggerFactory.getLoggerFactory().setLog(log);
		}
//	}

}
