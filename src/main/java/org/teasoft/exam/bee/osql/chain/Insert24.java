package org.teasoft.exam.bee.osql.chain;

import org.teasoft.bee.osql.chain.Insert;
import org.teasoft.honey.osql.chain.InsertImpl;
import org.teasoft.honey.osql.shortcut.CSF;

/**
 * 
 * @author Kingstar
 * @since  2.4.0
 */
public class Insert24 {

	public static void main(String[] args) {

//		Insert insert = new InsertImpl();
		Insert insert =CSF.getInsert();
		insert.insert("test");
		insert.column("id").column("name");
		System.out.println(insert.toSQL());// insert into test(id,name) values (?,?)
		System.out.println(insert.toSQL(false)); // insert into test(id,name) values (?,?);

		System.out.println(insert.toSQL(true));
	}

}
