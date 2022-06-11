/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 同时使用不同数据源实例
 * @author Kingstar
 * @since  1.11
 */
public class TwoDiffDsWithSet {
	
	static {
		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		
		HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
		HoneyContext.setConfigRefresh(true); 
		
		//当操作mysql时
		SuidRich mysqlSuidRich=getMysqlSuidRich();
		mysqlSuidRich.select(new Orders(),2);
		
		//当操作sqlite时
		SuidRich sqliteSuidRich=getSqliteSuidRich();
		sqliteSuidRich.select(new Orders(),2);
		
		//mysql
		mysqlSuidRich.select(new Orders(),2);
	}
	
	
	public static SuidRich getMysqlSuidRich() {
		SuidRich mysqlSuidRich=BF.getSuidRich();
//		数据源可以使用Java方式配置,也可以使用xml方式配置
//		mysqlSuidRich.setDataSourceName("mysqlDsName");
		mysqlSuidRich.setDataSourceName("ds1");  //此实例是在InitDsUtil.initDS();用java设置方式
		return mysqlSuidRich;
	}
	
	public static SuidRich getSqliteSuidRich() {
		SuidRich sqliteSuidRich=BF.getSuidRich();
//		数据源可以使用Java方式配置,也可以使用xml方式配置
//		sqliteSuidRich.setDataSourceName("sqliteDsName");
		sqliteSuidRich.setDataSourceName("ds2");  //此实例是在InitDsUtil.initDS();用java设置方式
		return sqliteSuidRich;
	}
	
	
//	2022-06-12 07:00:14 [ main:0 ] - [ INFO ] com.alibaba.druid.pool.DruidDataSource.init(DruidDataSource.java:721) {dataSource-1} inited
//	2022-06-12 07:00:14 [ main:2 ] - [ ERROR ] com.alibaba.druid.pool.DruidDataSource.validationQueryCheck(DruidDataSource.java:861) testWhileIdle is true, validationQuery not set
//	2022-06-12 07:00:14 [ main:2 ] - [ INFO ] com.alibaba.druid.pool.DruidDataSource.init(DruidDataSource.java:721) {dataSource-2} inited
//	2022-06-12 07:00:14 [ main:3 ] - [ INFO ] com.alibaba.druid.pool.DruidDataSource.init(DruidDataSource.java:721) {dataSource-3} inited
//	[Bee] LoggerFactory Use the Logger is : org.teasoft.honey.logging.SystemLogger
//	[INFO] [Bee] Parse DataSourceMap: dataSource name to database name , result: {ds1=MySQL, ds2=SQLite, ds3=MySQL}
//	[INFO] [Bee] ========= get the dbName from the Connection is :MySQL
//	[INFO] [Bee] ========= get the dbName in real time is :MySQL
//	[INFO] [Bee] select SQL(entity,size): SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT ?,?   [values]: 0(Integer),2(Integer)
//	[INFO] [Bee] select SQL(entity,size):  ( ExecutableSql )
//	SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT 0,2
//	[INFO] [Bee]  | <--  select rows: 2
//	[INFO] [Bee] ========= get the dbName in real time is :SQLite
//	[INFO] [Bee] select SQL(entity,size): SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT ?   [values]: 2(Integer)
//	[INFO] [Bee] select SQL(entity,size):  ( ExecutableSql )
//	SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT 2
//	[INFO] [Bee]  | <--  select rows: 2
//	[INFO] [Bee] ========= get the dbName in real time is :MySQL
//	[INFO] [Bee] select SQL(entity,size): SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT ?,?   [values]: 0(Integer),2(Integer)
//	[INFO] [Bee] select SQL(entity,size):  ( ExecutableSql )
//	SELECT id,userid,name,total,createtime,remark,sequence,abc,updatetime FROM orders LIMIT 0,2
//	[INFO] [Bee] ==========get from Cache.
//	[INFO] [Bee]  | <--  select rows: 2

	

}
