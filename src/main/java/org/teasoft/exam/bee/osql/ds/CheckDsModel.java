/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.11
 */
public class CheckDsModel {
	
	
   private static boolean enableMultiDs; //是否多数据源标识
   private static int multiDsType;   //多数据源模式
   private static boolean differentDbType; //是否同时使用多种不同类型DB,如同时使用mysql,oracle
	
	public static void main(String[] args) {
		Logger.info("不是多数据源模式");
		enableMultiDs=false;
		check();
		
		/////////////////////////////////////////////////////////		
		Logger.info("多数据源模式1,不同时使用多种DB");
		enableMultiDs=true;
		multiDsType=1;
		differentDbType=false;
		check();
		
		Logger.info("多数据源模式1,同时使用多种DB");
		differentDbType=true;
		check();
		
		/////////////////////////////////////////////////////////		
		Logger.info("多数据源模式2,不同时使用多种DB");
		enableMultiDs=true;
		multiDsType=2;
		differentDbType=false;
		check();
		
		Logger.info("多数据源模式2,同时使用多种DB");
		differentDbType=true;
		check();
		
		/////////////////////////////////////////////////////////
		Logger.info("多数据源模式0(通用模式),不同时使用多种DB");
		enableMultiDs=true;
		multiDsType=0;
		differentDbType=false;
		check();
		
		Logger.info("多数据源模式0(通用模式),同时使用多种DB");
		differentDbType=true;
		check();
	}
	
//	[INFO] 不是多数据源模式
//	[INFO]     不 需要特殊处理!
//	[INFO] 多数据源模式1,不同时使用多种DB
//	[INFO]     不 需要特殊处理!
//	[INFO] 多数据源模式1,同时使用多种DB
//	[INFO]    需要特殊处理!
//	[INFO] 多数据源模式2,不同时使用多种DB
//	[INFO]    需要特殊处理!
//	[INFO] 多数据源模式2,同时使用多种DB
//	[INFO]    需要特殊处理!
//	[INFO] 多数据源模式0(通用模式),不同时使用多种DB
//	[INFO]    需要特殊处理!
//	[INFO] 多数据源模式0(通用模式),同时使用多种DB
//	[INFO]    需要特殊处理!

	
//	public static void check() {
//		if (enableMultiDs && ( !(multiDsType ==1 && !differentDbType ))) {
//			Logger.info("   需要特殊处理!");
//		}else {
//			Logger.info("    不 需要特殊处理!");
//		}
//	}
	
	
	public static void check() {
		if (isMultiDs()) {
//			int multiDsType = HoneyConfig.getHoneyConfig().multiDS_type;
//			boolean differentDbType = HoneyConfig.getHoneyConfig().multiDS_differentDbType;
			
			if (!(multiDsType == 1 && !differentDbType)) // 不是(模式1的同种DB) //sameDbType=!differentDbType
				Logger.info("   需要特殊处理!");
			else
				Logger.info("    不 需要特殊处理!");
		} else {
			Logger.info("    不 需要特殊处理!");
		}
	}
	
	private static boolean isMultiDs() {
		return enableMultiDs;
	}
	

}
