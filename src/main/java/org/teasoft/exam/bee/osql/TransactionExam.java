package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.bee.osql.transaction.TransactionIsolationLevel;
import org.teasoft.exam.bee.osql.entity.Orders;
//import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;

/**
 * @author Kingstar
 * @since  1.0
 */
public class TransactionExam {

	public static void main(String[] args) {
		test();
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
	}

}
