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
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity");
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
			
//			genBean.genSomeBeanFile("resource,permit,users,role_assign");
//			genBean.genSomeBeanFile("tabinfo");
//			genBean.genSomeBeanFile("ienglish");
//			genBean.genSomeBeanFile("tableinfo");
//			genBean.genSomeBeanFile("columninfo");
//			genBean.genSomeBeanFile("user_table");
//			genBean.genSomeBeanFile("Download");
//			genBean.genSomeBeanFile("pro_template");
//			genBean.genSomeBeanFile("sdrecord,userbook");
//			genBean.genSomeBeanFile("notifylog");
//			genBean.genSomeBeanFile("sdrecord");
//			genBean.genSomeBeanFile("orders");
//			genBean.genSomeBeanFile("role,resource");
//			genBean.genSomeBeanFile("noid");
//			genBean.genSomeBeanFile("clazz,student");
//			genBean.genSomeBeanFile("student_hobby");
//			genBean.genSomeBeanFile("tableinfo");
//			genBean.genSomeBeanFile("dinner");
//			genBean.genSomeBeanFile("Resource");
//			genBean.genSomeBeanFile("leftsz_info");
//			genBean.genSomeBeanFile("t_test");
//			genBean.genSomeBeanFile("t_user");
//			genBean.genSomeBeanFile("t_leyy_sign");
//			genBean.genSomeBeanFile("t_transfer_record");
//			genBean.genSomeBeanFile("Columns,Tables");
			
//			genBean.genSomeBeanFile("users");
//			genBean.genSomeBeanFile("orders");
//			genBean.genSomeBeanFile("type_test");
//			genBean.genSomeBeanFile("template_group");
//			genBean.genSomeBeanFile("pro_template");
//			genBean.genSomeBeanFile("tableinfo");
//			genBean.genSomeBeanFile("userbook");
//			genBean.genSomeBeanFile("shopping_cart"); //No keyspace has been specified. USE a keyspace, or explicitly specify keyspace.tablename
//			genBean.genSomeBeanFile("store.shopping_cart");
//			genBean.genSomeBeanFile("store.cassandra_table");
			
//			genBean.genSomeBeanFile("student2");
//			genBean.genSomeBeanFile("column_test");
//			genBean.genSomeBeanFile("date_test");
//			genBean.genSomeBeanFile("Json_Value");
//			genBean.genSomeBeanFile("leaf_alloc");
//			genBean.genSomeBeanFile("sqlserver_type");
			
//			genBean.genSomeBeanFile("dept");
//			genBean.genSomeBeanFile("test_primary_key");
					
//			genBean.genSomeBeanFile("sqlserver_type");
//			genBean.genSomeBeanFile("H2_type");
//			genBean.genSomeBeanFile("POSTGRESQL_TYPE");
			
			
//			genBean.genSomeBeanFile("dict_i18n");
//			genBean.genSomeBeanFile("counter");
			
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
