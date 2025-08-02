package org.teasoft.exam.bee.osql;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.CallableSql;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.CallableSqlLib;

public class CallExam {

	public static void main(String[] args) throws SQLException {
		test();
	}

	public static void test() {

		try {

			CallableSql callableSQL = new CallableSqlLib();
//		    conn=...
//		    String sql = "{call dbBorrow(?)}";
//		    CallableStatement cstmt = conn.prepareCall(sql);
//		    cstmt.setLong(1, id);
			
			String callSql = "updateOrders(?)";

//		    CallableStatement
			CallableStatement cstmt = callableSQL.getCallableStatement(callSql);
//		    cstmt.setString(1, "100003");
			cstmt.setLong(1, 100003L);
			int num2 = callableSQL.modify(cstmt);
			Logger.info(num2);
			
//			cstmt.setLong(1, 100003L);
//			int num3 = callableSQL.modify(cstmt);
//			Logger.info(num3);
			
			int num = callableSQL.modify(callSql, new Object[] { 100004L });
			Logger.info(num);
			
			int num5 = callableSQL.modify(callSql, new Object[] { 10000588888L });
			Logger.info(num5);

			String selectCallString = "selectOrders(?)";
			List<Orders> list = callableSQL.select(selectCallString, new Orders(), new Object[] { "change via CallableSql" });
			Printer.printList(list);

			List<String[]> list2 = callableSQL.select(selectCallString, new Object[] { "change via CallableSql" });
			Printer.print(list2);

			String json = callableSQL.selectJson(selectCallString, new Object[] { "change via CallableSql" });
			Logger.info(json);
			
			String json2 = callableSQL.selectJson(selectCallString, new Object[] { "change via CallableSql--no" });
			Logger.info(json2);

		} catch (BeeException e) {
			Logger.error("In CallExam (BeeException):" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In CallExam (Exception):" + e.getMessage());
			e.printStackTrace();
		}
	}

}
