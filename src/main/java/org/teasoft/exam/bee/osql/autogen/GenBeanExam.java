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
//			config.setBaseDir("D:\\xxx\\yyy\\bee-exam\\src\\main\\java\\");
			config.setBaseDir("D:\\JavaWeb\\workspaceGit19\\bee-exam\\src\\main\\java\\");
			config.setPackagePath("org.teasoft.exam.bee.osql.entity2");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity.dynamic");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity.sqlite");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity.postgreSQL");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity.h2");

			GenBean genBean = new GenBean(config);
//			genBean.genSomeBeanFile("leaf_alloc,Orders");
//			genBean.genSomeBeanFile("Orders,user");
//			genBean.genSomeBeanFile("POSTGRESQL_TYPE");
//			genBean.genSomeBeanFile("H2_TYPE");
			
			genBean.genSomeBeanFile("resource,permit,users,role_assign");
//			genBean.genSomeBeanFile("tableinfo");
//			genBean.genSomeBeanFile("leftsz_info");
//			genBean.genSomeBeanFile("t_test");
			
//			genBean.genSomeBeanFile("sqlserver_type");
//			genBean.genSomeBeanFile("H2_type");
//			genBean.genSomeBeanFile("POSTGRESQL_TYPE");
//			
		  } catch (BeeException e) {
			 e.printStackTrace();
		  }
	}
}
