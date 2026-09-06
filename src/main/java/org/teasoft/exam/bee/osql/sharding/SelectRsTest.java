package org.teasoft.exam.bee.osql.sharding;

import org.teasoft.bee.osql.BeeSql;
import org.teasoft.bee.osql.SelectRsWrap;
import org.teasoft.honey.osql.core.SqlLib;

public class SelectRsTest {

	public static void main(String[] args) {

		test();
	}

	public static void test() {

		String sql = "select id,userid,orderid,name,total,createtime,remark,sequence,abc,updatetime from orders0 order by id";
		BeeSql beeSql = new SqlLib();
		
//		SelectRsWrap wrap0 = beeSql.selectRs(sql);
//		wrap0.close(); //需要自己关闭资源
		
		try (SelectRsWrap wrap = beeSql.selectRs(sql);) { //这样写会自己关闭资源
			//处理Rs
//			int a=1/0;
		}finally {
			System.out.println(" finished!");
		}
	}

}
