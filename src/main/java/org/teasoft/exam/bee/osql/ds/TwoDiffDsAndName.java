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
import org.teasoft.honey.osql.name.UnderScoreAndCamelName;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 同时使用不同数据源和不同命名转换实例.
 * <br>比如:mysql使用:　　DB<-->Java,eg: order_no<-->orderNo.
 * <br>oracle使用：DB<-->Java,eg: ORDER_NO<-->orderNo.
 * <br>可参考该实例
 * <br>但是建议只使用一种命名规则。 Javabean根据DB使用Bee自动生成
 * 
 * @author Kingstar
 * @since  1.11
 */
public class TwoDiffDsAndName {
	
	static {
		InitDsUtil.initDS();
	}
	
	public static void main(String[] args) {
		
		HoneyConfig.getHoneyConfig().multiDS_enable = true; //使用多数据源  多个数据源时必须设置
		HoneyConfig.getHoneyConfig().multiDS_differentDbType=true;  //同时要使用多种数据库,一定要设置
		HoneyContext.setConfigRefresh(true); 
		
		//当操作mysql时
		SuidRich mysqlSuidRich=getMysqlSuidRich();
//		mysqlSuidRich.select(new Orders());
		mysqlSuidRich.select(new Orders(),2);
		
		//当操作sqlite时
		SuidRich sqliteSuidRich=getSqliteSuidRich();
//		sqliteSuidRich.select(new Orders());
		sqliteSuidRich.select(new Orders(),2);
		
		//mysql
		mysqlSuidRich.select(new Orders(),2);
	}
	
	
	public static SuidRich getMysqlSuidRich() {
		SuidRich mysqlSuidRich=BF.getSuidRich();
//		数据源可以使用Java方式配置,也可以使用xml方式配置
//		mysqlSuidRich.setDataSourceName("mysqlDsName");
		mysqlSuidRich.setDataSourceName("ds1");  //此实例是在InitDsUtil.initDS();用java设置方式
		mysqlSuidRich.setNameTranslateOneTime(new UnderScoreAndCamelName()); //DB<-->Java,eg: order_no<-->orderNo.
		return mysqlSuidRich;
	}
	
	public static SuidRich getSqliteSuidRich() {
		SuidRich sqliteSuidRich=BF.getSuidRich();
//		数据源可以使用Java方式配置,也可以使用xml方式配置
//		sqliteSuidRich.setDataSourceName("sqliteDsName");
		sqliteSuidRich.setDataSourceName("ds2");  //此实例是在InitDsUtil.initDS();用java设置方式
		//TODO 像Oracle使用的规则,与其它不一样,可以这样使用.
//		sqliteSuidRich.setNameTranslate(new UpperCaseUnderScoreAndCamelName()); //DB<-->Java,eg: ORDER_NO<-->orderNo.
		return sqliteSuidRich;
	}
	

}
