/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.special.type;

import java.util.List;

import org.teasoft.bee.osql.DatabaseConst;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.type.SetParaTypeConverterRegistry;
import org.teasoft.honey.osql.type.SqlDotDateTypeHandler;
import org.teasoft.honey.osql.type.TypeHandlerRegistry;
import org.teasoft.honey.osql.type.UtilDotDateTypeConvert;
import org.teasoft.honey.osql.type.UtilDotDateTypeHandler;
import org.teasoft.honey.osql.util.DateUtil;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DateTypeTest {
	
	private static SuidRich suidRich=BF.getSuidRich();
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
//		Ddl.createTable(new DateType(),true);
		
//		DateType dateType=new DateType();
//		dateType.setId(12L);
//		dateType.setDate1(new Date());
//		dateType.setDate2(new java.sql.Date(new Date().getTime()));
//		dateType.setCreatetime(new Timestamp(new Date().getTime()));
//		
//		int insertNum=suidRich.insert(dateType);
//		Logger.info(insertNum);
//		
//		List list=suidRich.select(new DateType());
//		Printer.printList(list);
		
//		DateType dateType2=new DateType();
//		dateType2.setId(12L);
//		dateType2.setDate1(new Date());
		
//		suidRich.update(dateType2);
		
//		String sql="select id,date1,date2,createtime,remark from date_type";
//		String sql="SELECT ID,DATE1,DATE2 as DATE2,CREATETIME,REMARK FROM DATE_TYPE";
//		String sql="SELECT ID,DATE1,DATE2 as DATE2,CREATETIME,ID AS REMARK FROM DATE_TYPE";
//		String sql="select id,date1,date2 as date2,createtime,id as remark from date_type";
//		String sql="select id,date1,date2 as date2,createtime,remark,id as userId from date_type";
//		String sql="select id,DATE1,date2 as date2,createtime,remark,id as USER_ID from date_type";

		
//		String sql="select id,DATE1,date2 as date2,createtime,remark as userid,id as userId from date_type";
//		
//		PreparedSql pre=BF.getPreparedSql();
//		List list3=pre.select(sql);
//		Printer.print(list3);
//		
//		pre=BF.getPreparedSql();
//		List list4=pre.select(sql,new DateType());
//		Printer.printList(list4);
		
//		Ddl.createTable(new DateType2(), true);
		
		suidRich.delete(new DateType2());
		DateType2 dateType2=new DateType2();
		dateType2.setDate3(new java.util.Date());
		dateType2.setRemark("test dateType2");
		dateType2.setDate1(new java.util.Date());
		dateType2.setDate2(new java.sql.Date(System.currentTimeMillis()));
		suidRich.insert(dateType2);
		
//		SetParaTypeConverterRegistry.register(java.util.Date.class, new UtilDotDateTypeConvert<java.util.Date>());
		SetParaTypeConverterRegistry.register(java.util.Date.class, new UtilDotDateTypeConvert<java.util.Date>(), DatabaseConst.MYSQL);
		SetParaTypeConverterRegistry.register(java.util.Date.class, new UtilDotDateTypeConvert<java.util.Date>(), DatabaseConst.H2);
		//优先使用结果转换处理;  没有声明优先使用,则是默认转换不了,才使用
//		TypeHandlerRegistry.register(java.util.Date.class, new UtilDotDateTypeHandler<java.util.Date>(),true); 
//		TypeHandlerRegistry.register(java.sql.Date.class, new SqlDotDateTypeHandler<java.util.Date>(),true);  //SQLite
		List list4=suidRich.select(new DateType2());
		Printer.printList(list4);
		
//		List list5=suidRich.select(dateType2);
//		Printer.printList(list5);
		
	}

}
