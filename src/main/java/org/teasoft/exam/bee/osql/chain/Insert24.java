package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.chain.Insert;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * 
 * @author Kingstar
 * @since  2.4.0
 */
public class Insert24 {
	private static PreparedSql preparedSql = BF.getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {

//		Insert insert = new InsertImpl();
		Insert insert =CSF.getInsert();
//		insert.setUsePlaceholder(false); //在添加值之前,就要决定
//		insert.insert("t_test");
		insert.insert("orders");
		insert.columnAndValue("id",111L).columnAndValue("name","myname").columnAndValue("total",1111111);
		System.out.println(insert.toSQL());// insert into test(id,name) values (?,?)
		
		System.out.println(insert.toSQL());
		System.out.println(insert.toSQL());
		
		preparedSql.modify(insert.toSQL());
		preparedSql.modify(insert.toSQL());
		
		
//		System.out.println(insert.toSQL(false)); // insert into test(id,name) values (?,?);

//		System.out.println(insert.toSQL(true));
	}

}
