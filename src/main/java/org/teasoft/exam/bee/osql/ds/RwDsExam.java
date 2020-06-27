/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.ds;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.SessionFactory;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author Kingstar
 * @since  1.7.3
 */
public class RwDsExam {
	
	static SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();

	static {
		initDS();
	}

	public static void initDS() {
		try {

			DruidDataSource dataSource1;
			dataSource1 = new DruidDataSource();
			dataSource1.setUrl("jdbc:mysql://localhost:3306/pro?characterEncoding=UTF-8");
			dataSource1.setUsername("root");
			dataSource1.setPassword("");
			dataSource1.init();

			DruidDataSource dataSource2;
			dataSource2 = new DruidDataSource();
			dataSource2.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
			dataSource2.setUsername("root");
			dataSource2.setPassword("");
			dataSource2.init();
			
			DruidDataSource dataSource3;
			dataSource3 = new DruidDataSource();
			dataSource3.setUrl("jdbc:mysql://localhost:3306/bee?characterEncoding=UTF-8");
			dataSource3.setUsername("root");
			dataSource3.setPassword("");
			dataSource3.init();

			Map<String, DataSource> dataSourceMap = new HashMap<>();
			dataSourceMap.put("ds1", dataSource1);
			dataSourceMap.put("ds2", dataSource2); //ds2
			dataSourceMap.put("ds3", dataSource3); //ds3
			BeeFactory.getInstance().setDataSourceMap(dataSourceMap);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void test1() {
		

		LeafAlloc leafAlloc = new LeafAlloc();
		leafAlloc.setBizTag("leaf-segment-test");
		Condition condition = new ConditionImpl();
		condition.setAdd("maxId", 200); //TODO
		int num=suidRich.update(leafAlloc, "maxId", condition);
		System.out.println("---------------------------------update num is :"+num);

		//	@Select("SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}")
		LeafAlloc result = suidRich.selectOne(leafAlloc);
		System.out.println(result);
		
		
		result = suidRich.selectOne(leafAlloc);
		System.out.println(result);
	}
	
	public static void test2(){
	   	LeafAlloc result =null;
			Transaction transaction = SessionFactory.getTransaction();
			try {
				transaction.begin();
				
//			    @Update("UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag}")
				LeafAlloc leafAlloc=new LeafAlloc();
				leafAlloc.setBizTag("leaf-segment-test");
		    	Condition condition=new ConditionImpl();
		    	condition.setAdd("maxId", 200);  //TODO
		    	suidRich.update(leafAlloc, "maxId", condition);
		    	
//		    	@Select("SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}")
		    	result = suidRich.selectOne(leafAlloc);
		    	System.out.println(result);

				transaction.commit();
			} catch (Exception e) {
				transaction.rollback();
			}
	}
	
	public static void test() {
		test1();
		test2();
	}

	public static void main(String[] args) {
		test1();
	}

}
