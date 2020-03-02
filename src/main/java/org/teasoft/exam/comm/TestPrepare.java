/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.comm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.teasoft.bee.logging.Log;
import org.teasoft.bee.logging.Path;
import org.teasoft.honey.logging.FileLogger;
import org.teasoft.honey.logging.LoggerFactory;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class TestPrepare {
	
	static String version="v1.7.2";
	
	public static void init(){
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH.mm.ss.SS");
		String datetime=df.format(System.currentTimeMillis());
		
//		D:\{project-home}\src\main\resources\log
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\log"+"\\bee-exam("+version+"){datatime}.txt".replace("{datatime}", datetime);
		System.out.println(path);
		//set the path and file name of log file
		Path.setFullPath(path);
	
		Log log=new FileLogger();
		LoggerFactory.getLoggerFactory().setLog(log);
	}

}
