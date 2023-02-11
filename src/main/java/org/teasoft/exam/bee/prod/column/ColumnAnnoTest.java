/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod.column;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.Suid;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.11
 */
public class ColumnAnnoTest {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		//已放到预加载
//		ColumnHandler columnHandler=new DefaultColumnHandler();
//		NameTranslateHandle.setColumnHandler(columnHandler);
		
		//case 1 : Suid
		Suid suid=BF.getSuid();
		ColumnTest columnTest=new ColumnTest();
		columnTest.setId("aaaaaa");
//		columnTest.setId2("aaaaaa");
//		columnTest.setID("aaaaaa");
		columnTest.setRemark("test");
		List<ColumnTest> list=suid.select(columnTest);
		Printer.printList(list);
		
		//case 2 : PreparedSql
//		String sql="select uuid,name,num,remark,ch from column_test";
		String sql="select uuid,name,num,remark,ch from column_test where uuid=#{uuid}";
		
		PreparedSql pre=BF.getPreparedSql();
//		Map<String,String> parameterMap=new HashMap<>(); //参数不对
		Map<String,Object> parameterMap=new HashMap<>();
		list=pre.select(sql, columnTest, parameterMap);  //columnTest实体的会对Column注解的进行转换.
//		public <T> List<T> select(String sqlStr,T entity,Map<String,Object> parameterMap);
		Printer.printList(list);
		
		//case 3 : UpdateById
		SuidRich suidRich=BF.getSuidRich();
		
//		suidRich.selectById(columnTest, "aaaaaa");
		
		suidRich.update(columnTest);
		
		//case 4 : SuidRich  Condition
		Condition condition=BF.getCondition();
		condition.op("num", Op.gt, 0);
		suidRich.select(columnTest,condition);
		
		condition.set("remark", "test-column-anno");
//		condition.set("uuid", "bbbbb"); //use the real column name.   ok
//		condition.set("id", "bbbbb"); //是否需要转换???  为了统一使用Javabean属性,转换
		suidRich.update(columnTest,condition);
		
		
		Condition condition2=BF.getCondition();
		condition2.setAdd("num2", 2);
		ColumnTest2 columnTest2=new ColumnTest2();
		columnTest2.setId("aaaaaa-no-id");
		suidRich.update(columnTest2,condition2);
//		update column_test set num=num+2 where uuid='aaaabb-no-id' //mysql bug.当 num字段的值为null时,实际是没有更新的.
//		[INFO] [Bee]  | <--  Affected rows: 1
		
		Condition condition20=BF.getCondition();
		condition20.setMultiply("num2", 2);
		ColumnTest2 columnTest20=new ColumnTest2();
		columnTest20.setId("aaaaaa-no-id");
		suidRich.update(columnTest20,condition20);
		
		//case 5.1 : moretable
		//case 5.2 : moretable 子表1有
		//case 5.3 : moretable 主表同时有子表1和子表2
		//case 5.4 : moretable OneHasOne 子表1有子表2
		//5.3,5.4生成的sql表顺序正确性??
		MoreTable mt=BF.getMoreTable();
		mt.select(new Clazz());
		
		
		//case 6 : Ddl
//		Ddl.createTable(new ColumnTest3(), false); //ok
//		[ERROR] Table 'column_test3' already exists   //run again
	}

}
