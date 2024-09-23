/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.bee.osql.chain.UnionSelect;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.chain.UnionSelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.3
 */
public class UnionSelectExam {
	
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	
	public static void main(String[] args) {
		
		String DbName=HoneyConfig.getHoneyConfig().getDbName();
		if (DatabaseConst.PostgreSQL.equalsIgnoreCase(DbName)) {
			Logger.warn("PostgreSQL do not support (select * from table1) union all (select * from table2)! can not use *");
		    return ;
		}else {
			test();
		}
		
		
	}
	
	public static void test() {
	  try{	
	   Select joinSelect =new SelectImpl();
		joinSelect.select("*")  //分页时,oracle不允许这样写
		.from("orders,test_user")
		.where("orders.name=test_user.name")
		.start(0)
		.size(10)
		;
		
		Logger.info(joinSelect.toSQL());
		if(joinSelect.toSQL().equals(joinSelect.toSQL())) {
			Logger.info("Getting this sql twice is same!");
		}
		
		try {
          List<String[]> list1= preparedSql.select(joinSelect.toSQL()); //oracle   ORA-00918: 未明确定义列
          Printer.print(list1);
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
		
		UnionSelect unionSelect =new UnionSelectImpl();
		Select select1 =new SelectImpl();
		Select select2 =new SelectImpl();
		select1.select()
		.from("orders")
		.where()
		.op("userid", Op.eq, "client01")
		;
		select2.select()
		.from("orders")
		.where()
		.op("userid", Op.eq, "bee")
		;
		unionSelect.union(select1, select2);
		if(!HoneyUtil.isSQLite() && !HoneyUtil.isMongoDB()) {
	        List<String[]> list2= preparedSql.select(unionSelect.toSQL());
	        Printer.print(list2);
			unionSelect.unionAll(select1, select2);
	        List<String[]> list3= preparedSql.select(unionSelect.toSQL());
	        Printer.print(list3);
	        
	        String subSelects[]= {"select * from orders1","select * from orders2","select * from orders3"};
	        
	        String subSelectsSql1=unionSelect.unionAll(subSelects).toSQL();
//	        Logger.info(subSelectsSql1);
	        preparedSql.select(subSelectsSql1);
	        String subSelectsSql2=unionSelect.unionAll(subSelects).toSQL(); //重新调用toSQL(),不会受前面调用 的影响
//	        Logger.info(subSelectsSql2);
	        preparedSql.select(subSelectsSql1);
	        
		}

	  } catch (BeeException e) {
		Logger.error(e.getMessage());
		e.printStackTrace();
	  }
	}
}
