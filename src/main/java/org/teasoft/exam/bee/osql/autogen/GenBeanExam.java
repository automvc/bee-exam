/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.7.2
 */
public class GenBeanExam {
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		 try{
			String dbName=HoneyConfig.getHoneyConfig().getDbName();
//			driverName,url,username,password config in bee.properties.

			GenConfig config = new GenConfig();
			config.setDbName(dbName);
			config.setGenToString(true);//生成toString方法
			config.setGenSerializable(true);
			
//			更改成本地的具体路径  change to your real path
			config.setBaseDir("D:\\xxx\\yyy\\bee-exam\\src\\main\\java\\");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity");
			config.setPackagePath("org.teasoft.exam.bee.osql.entity2");

			GenBean genBean = new GenBean(config);

			
//			config.setGenComment(true);
			config.setGenFieldFile(true);
			config.setCommentPlace(1);
			
			//设置相对Entity的文件夹; 空表示与Entity同一个文件夹
//			config.setFieldFileRelativeFolder("field"); 
			
			config.setOverride(true); //是否覆盖原来的文件
			
			genBean.genSomeBeanFile("download");
			
			
//			
		  } catch (BeeException e) {
			 e.printStackTrace();
		  }
	}
}
