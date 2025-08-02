/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.comm.ClearDsUtil;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 支持同时使用多种类型数据库的数据源.
 * 同时使用Mysql,Oracle两种DB, 操作同一方法测试
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExam0 {
	
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	static {
		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
			HoneyConfig.getHoneyConfig().multiDS_enable = true;
			HoneyConfig.getHoneyConfig().multiDS_type = 0;
			HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;
			HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds1";  //mysql
			
			
//			HoneyConfig.getHoneyConfig().multiDS_matchEntityClassPath = "ds2:org.teasoft.exam.bee.osql.entity.dynamic.Orders,org.teasoft.exam.bee.osql.moretable.entity.TestUser,org.teasoft.exam.bee.osql.moretable.entity.Orders;ds3:com.xxx.dd.User";
//			HoneyConfig.getHoneyConfig().multiDS_matchTable = "ds2:test_user";
			HoneyContext.setConfigRefresh(true); 
			
            System.out.println(">>>>>>>>>>>>>>>>>>>test1");
			test1();
			
			HoneyConfig.getHoneyConfig().multiDS_defalutDS = "ds2"; //oracle
			HoneyContext.setConfigRefresh(true); 
			test1();
			
            //clear
//			HoneyConfig.getHoneyConfig().multiDS_enable = false;
//			HoneyConfig.getHoneyConfig().multiDS_type = 0;
//			HoneyConfig.getHoneyConfig().multiDS_differentDbType = false;
//            BeeFactory.getInstance().setDataSource(null);
//            BeeFactory.getInstance().setDataSourceMap(null);
//            HoneyContext.setConfigRefresh(true);
			 ClearDsUtil.clearConfig();
		}

	public static void test1() {

		LeafAlloc leafAlloc = new LeafAlloc();
		leafAlloc.setBizTag("bee");
		LeafAlloc result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString());
		
		
		Condition condition = new ConditionImpl();
		condition.setAdd("maxId", "step");
		int num = suidRich.update(leafAlloc, condition, "maxId");
		Logger.info("---------------------------------update num is :" + num);

		//"SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
		result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString());

		result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString());
		Logger.info("-------------1--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,0,10);
		Logger.info("-------------2--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,10);
		Logger.info("-------------3--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		suidRich.select(leafAlloc,10);
		Logger.info("-------------4--dbName: "+HoneyConfig.getHoneyConfig().getDbName());
		
		//上个操作test1(),放入缓存,看下下个操作(不同DB类型),是否会从缓存中获取
		leafAlloc = new LeafAlloc();
		leafAlloc.setBizTag("bee");
		result = suidRich.selectOne(leafAlloc);
		if (result != null) Logger.info(result.toString()); 
		
		
		Logger.info("");
		Logger.info("+++++++++++++++++++++++====================================================+++++++++++++++++++++++");
		
	}
	
	
	
	


}
