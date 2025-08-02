/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access;

import java.util.List;

import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * Access 使用ORM
 */
public class AccessDbTest2 {
	
	public static void main(String[] args){
//		try {
//		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://d:/school.accdb");
////		
//		Statement stmt=conn.createStatement() ;
//		ResultSet rs=stmt.executeQuery("select * from stu");
//		while (rs.next()) {
//			System.out.println(rs.getString(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getString(4));
//		}
//		System.out.println("finished1");
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("e:"+e.getMessage());
//		}
		
		
//		access由于access并不是作为一项服务运行，所以url的方法对他不适用。
//		https://www.cnblogs.com/shandian333/p/16527057.html
//
//		https://zhuanlan.zhihu.com/p/441219492
//		Access2013开始，将不再支持ODBCDirect(DAO odbc连接SqlServer常用）错误3847
//
//		实际上，是可以使用 纯JDBC驱动访问access的
//		使用驱动：ucanaccess
//		https://mvnrepository.com/artifact/net.sf.ucanaccess/ucanaccess
		
		SuidRich suidRich=BF.getSuidRich();
		suidRich.createTable(Stu.class,false);
		
		List<Stu> list=BF.getSuid().select(new Stu());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getName()+"   ,  ");
			System.out.print(list.get(i).getAge()+"   ,  ");
			System.out.println(list.get(i).getRemark());
		}
		
		
		System.out.println("finished");
	}

}
