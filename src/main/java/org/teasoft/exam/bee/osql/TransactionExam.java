package org.teasoft.exam.bee.osql;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.User;
import org.teasoft.honey.osql.core.BeeFactory;
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
			
			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			
			User user=new User();
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

		} catch (BeeException e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

}
