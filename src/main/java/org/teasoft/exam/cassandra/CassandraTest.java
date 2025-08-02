/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.cassandra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.teasoft.bee.osql.api.PreparedSql;
import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.NameTranslateHandle;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class CassandraTest {

	public static void main(String[] args) {
		

		PreparedSql pre = BF.getPreparedSql();
//		String sql = "SELECT * FROM store.shopping_cart";
//		String sql = "select * from store.shopping_cart where 1!=1";
		String sql = "select * from store.cassandra_table limit 1";
//		String sql = "select * from store.shopping_cart where userid='4567'";
		List<String[]> list=pre.select(sql);
		Printer.print(list);
		
		NameTranslateHandle.setSchemaName("store");
//		NameTranslateHandle.setSchemaNameLocal("store2");
		Suid suid=BF.getSuid();
		List<ShoppingCart> list2=suid.select(new ShoppingCart());
		Printer.printList(list2);
		
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setUserid("4567");
		List<ShoppingCart> list3=suid.select(shoppingCart);
		Printer.printList(list3);
		
		CassandraTable t=new CassandraTable();
//		t.setF0Id(11111L);
		
		List<Integer> f22List=new ArrayList<>();
		f22List.add(11);
		f22List.add(22);
		t.setF22List(f22List);
		
		Set f23Set=new HashSet();
		f23Set.add("aa");
		f23Set.add("bb");
		t.setF23Set(f23Set);
		
		Map<String,Long> f24Map=new HashMap<>();
		f24Map.put("a", 123L);
		f24Map.put("b", 126L);
	    t.setF24Map(f24Map);
		
		int isertNum=suid.insert(t); //同一个id,多次插入,是在同一行更新.
		System.out.println("isertNum:"+isertNum);  //返回0, 行数不对
		
		t.setId(1L);
		t.setF20Varchar("test-update2");
		int updateNume=suid.update(t);
		System.out.println("updateNume:"+updateNume);//返回0, 行数不对
		
//		String insertSql="insert into store.cassandra_table(id,f19_uuid) values (3,uuid())";
//		String insertSql="insert into store.cassandra_table(id,f19_uuid) values (5,uuid('edab4b7b-4978-4249-a0da-ef6bd05accca'))";

		String insertSql="insert into store.cassandra_table(id,f19_uuid) values (8,uuid())";
		int a=pre.modify(insertSql);
		Logger.info(a);
		
		List<CassandraTable> list4=suid.select(new CassandraTable()); 
		Printer.printList(list4);
		
	}

}
