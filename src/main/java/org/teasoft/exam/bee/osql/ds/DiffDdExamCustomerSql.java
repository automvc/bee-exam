/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.Timestamp;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.type.TimestampTypeHandler;
import org.teasoft.honey.osql.type.TypeHandlerRegistry;

/**
 * 支持同时使用多种类型数据库的数据源.
 * 同时使用Mysql,Oracle两种DB, 操作同一方法测试
 * <br>support different type database muli-Ds at same time.
 * @author Kingstar
 * @since  1.9
 */
public class DiffDdExamCustomerSql {
//	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	private static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
	static {
		InitDsUtil.initDS();
	}
	
//	private static Suid suid = BeeFactory.getHoneyFactory().getSuid();
	
	public static SuidRich getSuidRich() {
		return suidRich;
	}
	
	public static void setSuidRich(SuidRich suidRich) {
		DiffDdExamCustomerSql.suidRich=suidRich;
	}
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
		HoneyContext.setConfigRefresh(true); 
		
		suidRich.setDataSourceName("ds1");
//		test1();
		LeafAlloc leafAlloc = new LeafAlloc();
		suidRich.select(leafAlloc,10);
		
		
		suidRich.setDataSourceName("ds2");
		test1();
		suidRich.select(leafAlloc,10);
		
		
		PreparedSql preparedSqlOracle = BeeFactory.getHoneyFactory().getPreparedSql();
		preparedSqlOracle.setDataSourceName("ds2");
		
		PreparedSql preparedSqlMysql = BeeFactory.getHoneyFactory().getPreparedSql();
		preparedSqlMysql.setDataSourceName("ds1");
		
		String sql="select id,biz_tag,max_id,step,description,update_time,version from leaf_alloc";
		
		Object preValues[]=null;
		preparedSqlOracle.select(sql, LeafAlloc.class, preValues, 0, 2); //分页语句部分由Bee负责
		
		
		preparedSqlMysql.select(sql, LeafAlloc.class, preValues, 0, 2);
		
		
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
