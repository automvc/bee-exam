package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.bee.osql.transaction.TransactionIsolationLevel;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * @author Kingstar
 * @since  1.0
 */
public class TransactionExam {

	private static SuidRich suidRich=BeeFactory.getHoneyFactory().getSuidRich();
	
	public static void main(String[] args) {
		test();
		testRollback(false);
	}
	public static void test() {
		Transaction transaction=SessionFactory.getTransaction();
		
		try {
			
			transaction.begin();
//			transaction.setTransactionIsolation(TransactionIsolationLevel.TRANSACTION_READ_UNCOMMITTED); //oracle donot support
//			transaction.setTransactionIsolation(TransactionIsolationLevel.TRANSACTION_READ_COMMITTED); //SQLite donot support
			transaction.setTransactionIsolation(TransactionIsolationLevel.TRANSACTION_SERIALIZABLE);
			
			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			
			TestUser user=new TestUser();
			user.setUsername("testuser");
			user.setPassword("bee-user");
			
			suid.insert(user);//insert 1

			Orders orders = new Orders();
			orders.setUserid("bee");
			orders.setName("Bee(ORM Framework)");
			orders.setTotal(new BigDecimal("91.99"));
			orders.setRemark("test transaction"); 
			orders.setSequence("");//empty String test

			suid.insert(orders); //insert 2
			
			transaction.commit();

			List<Orders> list = suid.select(orders); //可任意组合条件查询
			for (int i = 0; i < list.size(); i++) {
				Logger.info(list.get(i).toString());
			}
			
			
			transaction.begin();
			
			if( !(HoneyUtil.isSQLite() || HoneyUtil.isSqlServer()) ) {
				Orders orders11 = new Orders();
				orders11.setUserid("bee");
				Condition condition_add_forUpdate = new ConditionImpl();
				condition_add_forUpdate
				.op("id", Op.eq,100003)
				.forUpdate();     // 用for update锁住某行记录
				List<Orders> list11 = suid.select(orders11, condition_add_forUpdate);
				for (int i = 0; i < list11.size(); i++) {
					Logger.info(list11.get(i).toString());
				}
			}
			
			Logger.info("---------------locking the record!");
			Logger.info("doing...");  //可添加更改操作等.
			
//			Caused by: org.postgresql.util.PSQLException: 不能在事务交易过程中改变事物交易隔绝等级。
//			transaction.setTransactionIsolation(TransactionIsolationLevel.TRANSACTION_READ_COMMITTED);
			transaction.commit();
			Logger.info("---------------release the record!");

		} catch (BeeException e) {
			Logger.error("In TransactionExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In TransactionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
		
		Orders exampleField=new Orders();
		exampleField.setUserid("bee");
//      select some fields
		List<Orders> selectSomeField=suidRich.select(exampleField, "name,total");
	}
	
	
	public static void testRollback(boolean isThrowException) {
		LeafAlloc result = null;
		Transaction transaction = SessionFactory.getTransaction();
		try {
			
//			TypeHandlerRegistry.register(Timestamp.class, new TimestampTypeHandler<Timestamp>());
			
			transaction.begin();

//			"UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag}"
			LeafAlloc leafAlloc = new LeafAlloc();
			leafAlloc.setBizTag("bee");
			Condition condition = new ConditionImpl();
			condition.setAdd("maxId", "step");
			if(!HoneyUtil.isSqlServer()) {
				String d=null;
				condition.set("updateTime", d);  //updateTime是Timestamp类型,即使设置为null,Sql Server也不允许
	//		    suidRich.update(leafAlloc, "maxId", condition);
				suidRich.update(leafAlloc, condition); //v1.8
			}
//			if (!HoneyUtil.isOracle()) {
			if (HoneyUtil.isMysql()) {
				condition.set("updateTime", DateUtil.currentDate()); //直接设置字符串可以.
				suidRich.update(leafAlloc, condition);
//				update leaf_alloc set max_id=max_id+step,update_time=null,update_time='2022-03-09 11:54:51' where biz_tag='bee'
//				Caused by: java.sql.SQLSyntaxErrorException: ORA-00957: 重复的列名
//				at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
			}
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

//		    "SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
			result = suidRich.selectOne(leafAlloc);
			if(result!=null) Logger.info(result.toString());
			
			List list=suidRich.select(leafAlloc,0,10); //从0开始算. offset是偏移量
			Printer.printList(list);
			
			LeafAlloc leafAlloc2 = new LeafAlloc();
			leafAlloc2.setBizTag("bee");
			leafAlloc2.setUpdateTime(DateUtil.currentTimestamp());
			int a=suidRich.updateBy(leafAlloc2,"BizTag");
//			System.err.println(a);
			Logger.info(a);
			List list2=suidRich.select(new LeafAlloc(),0,10); //从0开始算. offset是偏移量
			Printer.printList(list2);
			
			if(isThrowException) {
				int error=1/0;
			}

			transaction.commit();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
			Logger.error(" Transaction rollback !");
			transaction.rollback();
		}
	}

}
