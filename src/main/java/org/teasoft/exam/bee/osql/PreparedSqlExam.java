package org.teasoft.exam.bee.osql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.dialect.DbFeatureRegistry;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyContext;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.dialect.sqlserver.SqlServerPagingStruct;

public class PreparedSqlExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {

		try {
			PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();

			String sql = CustomSql.getCustomSql("osql.example.entity.selectOrders");
			Logger.info("getCustomSql:  " + sql); //只能在一行的.
			
//			List<String[]> list6 = 
					preparedSql.select(sql,new Object[] { "bee" },1,3);
					preparedSql.select(sql,new Object[] { "bee" },1,3);//test: don't use cache
					preparedSql.select(sql,new Object[] { "bee" },1,3);//test: don't use cache
			
//			osql.example.entity.selectOrders=select * from orders where userid=?
//			List<String[]> list5 = preparedSql.select(sql,new Object[] { "bee"},1,3);

//			List<Orders> list1 = preparedSql.selectSomeField(sql, new Orders(), new Object[] { "bee" });
			List<Orders> list1 = preparedSql.selectSomeField(sql, new Orders(), new Object[] { "bee" },2,3);
			for (int i = 0; i < list1.size(); i++) {
				Logger.info(list1.get(i).toString());
			}
			
			String jsonString1= preparedSql.selectJson(sql, new Object[] { "bee" },1,3);//array  selectJson
			Logger.info(jsonString1);

			String sql2 = CustomSql.getCustomSql("osql.example.entity.selectOrdersViaMap");
			Logger.info("getCustomSql:  " + sql2);

			Map<String, Object> map = new HashMap<>();
			map.put("userid", "bee");
//			List<Orders> list2 = preparedSql.select(sql2, new Orders(), map);//map
//			List<Orders> list2 = preparedSql.select(sql2, new Orders(), map,1,3);//map
			preparedSql.selectSomeField(sql2, new Orders(), map,1,3);//use cache
			List<Orders> list2 = preparedSql.selectSomeField(sql2, new Orders(), map,1,3);//map  selectSomeField
			for (int i = 0; i < list2.size(); i++) {
				Logger.info(list2.get(i).toString());
			}
			
			String jsonString= preparedSql.selectJson(sql2, map,1,3);//map  selectJson
			Logger.info(jsonString);
			
			String sql3 = CustomSql.getCustomSql("osql.example.entity.selectOrdersLikeNameViaMap");
			Logger.info("getCustomSql:  " + sql3);

			Map<String, Object> map2 = new HashMap<>();
			map2.put("name", "Bee");
//			List<Orders> list3 = preparedSql.select(sql3, new Orders(), map2);//map
			List<Orders> list3 = preparedSql.select(sql3, new Orders(), map2,1,3);//map
			for (int i = 0; i < list3.size(); i++) {
				Logger.info(list3.get(i).toString());
			}
			
			String sql3_2 = CustomSql.getCustomSql("osql.example.entity.selectOrdersLikeNameViaMap2"); //%name
			preparedSql.select(sql3_2, new Orders(), map2,1,3);//map
			
			String sql3_3 = CustomSql.getCustomSql("osql.example.entity.selectOrdersLikeNameViaMap3");//%name%
			preparedSql.select(sql3_3, new Orders(), map2,1,3);//map
			
			String sql4 = CustomSql.getCustomSql("osql.example.entity.selectAllOrders");
			Logger.info("getCustomSql:  " + sql4); //只能在一行的.

//			List<Orders> list4 = preparedSql.select(sql4, new Orders(), new Object[] {});
			List<Orders> list4 = preparedSql.select(sql4, Orders.class, new Object[] {},1,3);
//			List<Orders> list4 = preparedSql.select(sql4, new Orders(), new HashMap());
			for (int i = 0; i < list4.size(); i++) {
				Logger.info(list4.get(i).toString());
			}
			
//			preparedSql.select(sql4, new Orders(), new HashMap()); //test: get from cache
			preparedSql.select(sql4, Orders.class, new Object[] {});
			List<String[]> list7 = preparedSql.select(sql4,new Object[] {},1,3);
			
			//自定义sql多表查询
			String sql8 = CustomSql.getCustomSql("osql.example.userOrders");
			List<String[]> list8 = preparedSql.select(sql8, new Object[] { "123456" });
			String str[];
			for (int i = 0; i < list8.size(); i++) {
				str = list8.get(i);
				for (int j = 0; j < str.length; j++) {
					Logger.info(str[j]);
				}
			}
			
			String sql9="INSERT INTO orders(id,name,userid) VALUES (#{id},#{name},#{userid})";
			final String USERID="userid";
			final String NAME="name";
			final String ID="id";
			Map<String,Object> insertMap1=new HashMap<>();
			insertMap1.put(USERID, "1001");
			insertMap1.put(NAME, "bee");
			insertMap1.put(ID, 121L);
			
			Map<String,Object> insertMap2=new HashMap<>();
			insertMap2.put(USERID, "1001");
			insertMap2.put(NAME, "bee");
			insertMap2.put(ID, 122L);
			
			Map<String,Object> insertMap3=new HashMap<>();
			insertMap3.put(USERID, "1001");
			insertMap3.put(NAME, "bee");
			insertMap3.put(ID, 123L);
			
			List<Map<String, Object>> parameterMapList=new ArrayList<>();
			parameterMapList.add(insertMap1);
			parameterMapList.add(insertMap2);
			parameterMapList.add(insertMap3);
			
//			preparedSql.modify("delete from orders where id=123 or id=122 or 123");
			preparedSql.modify("delete from orders where id=121 or id=122 or id=123");
			preparedSql.insertBatch(sql9, parameterMapList,2);
			preparedSql.modify("delete from orders where id=121 or id=122 or id=123");
			preparedSql.insertBatch(sql9, parameterMapList);
			
//			HoneyContext.test();
			
			
			if(HoneyUtil.isSqlServer()) {
				//sql server 自动分页; 自定义sql方式.
				
				
				//sql server>=2012,用新语法: order by id offset 1 row fetch next 3 rows only
				//当定义的sql语句有order by 时,要告知系统.
				//面向对象方式分页,则由Bee框架自动处理.
				
				String sql2012="select * from orders order by id";
				SqlServerPagingStruct struct=new SqlServerPagingStruct();
				struct.setHasOrderBy(true);
				HoneyContext.setSqlServerPagingStruct(sql2012, struct);
				preparedSql.select(sql2012, Orders.class, new Object[] {},2,3);

				
				//sql server>=2012 ,use old type,用回旧语法  默认分页排序,用row_number() over (order by id)
				HoneyConfig.getHoneyConfig().getDbName();
				DbFeatureRegistry.register(DatabaseConst.SQLSERVER, null); 
				HoneyConfig.getHoneyConfig().setDatabaseMajorVersion(0); 
				List<Orders> list4_2 = preparedSql.select(sql4, Orders.class, new Object[] {},1,3);
				List<Orders> list4_3 = preparedSql.select(sql4, Orders.class, new Object[] {},2,3);
				
//				不是用id分页排序时,要告知系统. //面向对象方式分页,则由Bee框架自动处理.
				
				//使用旧语法
				String sql2008="select * from orders order by id"; //旧语法,sql 语句有order by也可以不用调整
//				SqlServerPagingStruct struct2=new SqlServerPagingStruct();
//				struct2.setHasOrderBy(true);
//				HoneyContext.setSqlServerPagingStruct(sql2008, struct2);
				preparedSql.select(sql2008, Orders.class, new Object[] {},2,3);
				
				String sql2008_2="select * from orders order by name desc";
				SqlServerPagingStruct struct3=new SqlServerPagingStruct();
				struct3.setJustChangeOrderColumn(true);
				struct3.setOrderColumn("name");
				struct3.setOrderType(OrderType.DESC);
				HoneyContext.setSqlServerPagingStruct(sql2008_2, struct3);
				preparedSql.select(sql2008_2, Orders.class, new Object[] {},2,3);
				
			}
		} catch (BeeException e) {
			Logger.error("In PreparedSqlExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In PreparedSqlExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
