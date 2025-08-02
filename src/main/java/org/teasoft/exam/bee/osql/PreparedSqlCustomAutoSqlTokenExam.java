package org.teasoft.exam.bee.osql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;

public class PreparedSqlCustomAutoSqlTokenExam {
	
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {

		try {

			String sqlIn = CustomSql.getCustomSql("example.autosql.in");
			Logger.info("getCustomSql:  " + sqlIn);

			Map<String, Object> map = new HashMap<>();
			
			List<String> list=new ArrayList<>();
			list.add("bee");
			list.add("orders3");
			list.add("orders4");
			map.put("userid", list);
			
//			List<Integer> list=new ArrayList<>();
//			list.add(1);
//			list.add(2);
//			list.add(3);
//			map.put("userid", list);
			
//			List list=new ArrayList();
//			list.add(1);
//			list.add(2);
//			list.add(3);
//			map.put("userid", list);
			
			selectNoPage(sqlIn, map);
			select(sqlIn, map);
			select(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.one"), map); //the only if is notNull
			select(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.two"), map);//the first if is notNull,the second is null
			
			Map<String, Object> map2 = new HashMap<>();
//			selectNoPage(sqlIn, map2);
			//test delete the where and empty string.(select * from orders )
			selectNoPage(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.one"), map2); //the only if is notNull
			
			map2.put("name", "bee");
			//select * from orders where   and name=#{name}
//			selectNoPage(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.two"), map2);
			selectNoPage(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.twoRight"), map2);
			
			map2.put("name", "");
			selectNoPage(CustomSql.getCustomSql("example.autosql.isNotBlank"), map2);
			//可自动去掉where
			selectNoPage(CustomSql.getCustomSql("example.autosql.like.isNotBlank"), map2);
			
			try {
				selectNoPage(CustomSql.getCustomSql("example.autosql.like.isNotNull"), map2);
//				example.autosql.like.isNotNull=select * from orders where <if isNotNull>name like #{%name}</if>
				//name的值非null,会保留<if isNotNull></if>之前的内容,但name的值为空字符,会有注入风险,所以报错(从V1.17开始).
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Map<String, Object> map3 = new HashMap<>();
			Set set=new HashSet();
			set.add("bee");
			set.add("orders3");
			set.add("orders4");
			map3.put("userid", set);
			select(sqlIn, map3);
			select(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.one"), map3); //the only if is notNull
			select(CustomSql.getCustomSql("example.autosql.inAndIsNotNull.two"), map3);//the first if is notNull,the second is null
			
			//sql server 2012转化有问题
			Set set2=new HashSet();
			set2.add(1);
			set2.add(2);
			set2.add(3);
			map3.put("userid", set2);
			select(sqlIn, map3);
			
			Map<String, Object> map4 = new HashMap<>();
			selectNoPage(CustomSql.getCustomSql("example.autosql.toIsNULL1"), map4);
			selectNoPage(CustomSql.getCustomSql("example.autosql.toIsNULL2"), map4);
			
			map4.put("userid", "bee");
			map4.put("id", 10L);
			selectNoPage(CustomSql.getCustomSql("example.autosql.toIsNULL1"), map4);
			selectNoPage(CustomSql.getCustomSql("example.autosql.toIsNULL2"), map4);
			
			// no new token
			selectNoPage(CustomSql.getCustomSql("example.autosql.none"), map4);
			
//			escape
//			selectNoPage(CustomSql.getCustomSql("example.autosql.escape"), map4);
			
			
		} catch (BeeException e) {
			Logger.error("In PreparedSqlExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In PreparedSqlExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void select(String sql,Map<String,Object> map) {
		List<Orders> list3 = preparedSql.select(sql, new Orders(), map,1,3);//map
		for (int i = 0; i < list3.size(); i++) {
			Logger.info(list3.get(i).toString());
		}
	}
	
	private static void selectNoPage(String sql,Map<String,Object> map) {
		List<Orders> list3 = preparedSql.select(sql, new Orders(), map);//map
//		for (int i = 0; i < list3.size(); i++) {
//			Logger.info(list3.get(i).toString());
//		}
	}

}
