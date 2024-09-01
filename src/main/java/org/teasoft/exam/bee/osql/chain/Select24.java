package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * 
 * @author Kingstar
 * @since  2.4.0
 */
public class Select24 {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
//		Insert insert =new InsertImpl();
//		insert.insert("test");
//		insert.column("id").column("name");
		
		
//		System.out.println(insert.toSQL());
		
//		PreparedSql select SQL: select * from orders
		
//		Select select=new SelectImpl();
		Select select=CSF.getSelect();
//		select.select().from("orders"); 
		select.from("orders"); //默认加select *
		select.where().op("userid", "1001"); //默认加where
		
		PreparedSql pre=BF.getPreparedSql();
		pre.select(select.toSQL());
		
		pre.select(select.toSQL()); //再次查询,测试是否用缓存
		
		select.start(1);
		pre.select(select.toSQL());
		
	}

}
