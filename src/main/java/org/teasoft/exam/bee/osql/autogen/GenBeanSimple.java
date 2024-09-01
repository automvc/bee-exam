/*
 * Copyright 2016-2022 the original author.All rights reserved.
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
 * @since  1.17
 */
public class GenBeanSimple {
	public static void main(String[] args) {
		 try{
			String dbName=HoneyConfig.getHoneyConfig().getDbName();
//			driverName,url,username,password config in bee.properties.

			GenConfig config = new GenConfig();
			config.setDbName(dbName); //V1.17 可自动获取
			config.setGenToString(true);//生成toString方法
			config.setGenSerializable(true); //生成序列化  //V1.17默认值改为true
			config.setGenComment(true); //可生成注释
			config.setCommentPlace(1); //注释的位置
			
			
//			更改成本地的具体路径  change to your real path
//			config.setBaseDir("D:\\xxx\\yyy\\bee-exam\\src\\main\\java\\");
//			config.setPackagePath("org.teasoft.exam.bee.osql.entity2");

			GenBean genBean = new GenBean(config);

			//可以使用{实体}_F来引用字段名  
			//V1.17 支持生成ALL_NAMES属性(同时引用所有字段的名称)
			config.setGenFieldFile(true);   //生成字段文件, 这样可以避免硬编码引用字段,速度也比反射快.
			//设置相对Entity目录的文件夹名称; 空表示与Entity同一个文件夹
//			config.setFieldFileRelativeFolder("field"); //默认
			config.setOverride(true); //是否覆盖原来的文件
			
//			genBean.genSomeBeanFile("orders");
//			genBean.genSomeBeanFile("store.shopping_cart"); //cassandra 需要带keyspace (store.)
			
			
			//it is easy way.   最简单的用法,所有的都用默认配置.
//			new GenBean().genSomeBeanFile("orderhistory");
			new GenBean().genSomeBeanFile("tyte_table");
			
		  } catch (BeeException e) {
			 e.printStackTrace();
		  }
	}
}
