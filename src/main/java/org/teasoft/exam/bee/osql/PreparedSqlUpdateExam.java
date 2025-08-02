package org.teasoft.exam.bee.osql;

import java.util.HashMap;
import java.util.Map;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.CustomSql;

public class PreparedSqlUpdateExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {

		try {
			PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
//			update orders set remark=#{remark},abc=#{abc} where id=#{id}
			String sql = CustomSql.getCustomSql("osql.example.entity.updateOrders");
			Map<String, Object> map = new HashMap<>();
//			map.put("remark", null);
			map.put("abc", "abc-changed");
			map.put("id", 11);
			int updateNum=preparedSql.modify(sql, map);
			Logger.info(updateNum);
			
			
			String sql2="update orders set remark=#{remark},abc=#{abc} where id=#{id} and remark=#{remark}";
			int updateNum2=preparedSql.modify(sql2, map);
//			update orders set remark=null,abc='abc-changed' where id=11 and remark=null ;  
			//得到的sql: where条件的 remark=null是不对的.
			Logger.info(updateNum2);
			
			String sql3="update orders set remark=#{remark},abc=#{abc} where id=#{id} and remark=#{remark @toIsNULL1}";
			int updateNum3=preparedSql.modify(sql3, map);  //remark=#{remark @toIsNULL1}   在where条件,使用remark=#{remark @toIsNULL1}才是对的.
			
			Logger.info(updateNum3);
			
			
		} catch (BeeException e) {
			Logger.error("In PreparedSqlExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In PreparedSqlExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}

}
