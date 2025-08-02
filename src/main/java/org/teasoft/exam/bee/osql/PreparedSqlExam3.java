package org.teasoft.exam.bee.osql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;

public class PreparedSqlExam3 {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {

		try {
			PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();

			
			String sql4 = CustomSql.getCustomSql("osql.example.entity.selectAllOrders");
			Logger.info("getCustomSql:  " + sql4); //只能在一行的.

			List<String[]> list4 = preparedSql.select(sql4,  new Object[] {});
			                     preparedSql.select(sql4,  new Object[] {},1,3);
			                     
			                     Map<String, Object> map2 = new HashMap<>();
			                 	  preparedSql.select(sql4, map2);//map
			                 	  preparedSql.select(sql4, map2,1,3);//map
//			                 	  preparedSql.select(sql4, new Orders(), map2);//map
//			                 	  preparedSql.select(sql4, new Orders(), map2,1,3);//map
			
//			List<Orders> list4 = preparedSql.select(sql4, new Orders(), new HashMap());
			                     
//			for (int i = 0; i < list4.size(); i++) {
//				Logger.info(list4.get(i).toString());
//			}
			

				
		} catch (BeeException e) {
			Logger.error("In PreparedSqlExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In PreparedSqlExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
