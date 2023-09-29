/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.access.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.teasoft.honey.osql.core.SessionFactory;

/**
 * @author ctc
 * @since  1.0
 */
public class AccessDbTest_2 {
	
	public static void main(String[] args){
		try {
			

		
//		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://d:/school.accdb");
			
		Connection conn= SessionFactory.getOriginalConnForIntra("jdbc:ucanaccess://d:/school.accdb", "","", "net.ucanaccess.jdbc.UcanaccessDriver");

		Statement stmt=conn.createStatement() ;
		ResultSet rs=stmt.executeQuery("select * from stu");
		
		Statement stmt2=conn.createStatement() ;
		ResultSet rs2=stmt2.executeQuery("select * from stu");
//		rs2.close();
		rs2.next();rs2.next();rs2.next();rs2.next();
		rs.next();
		
//		while (rs.next()) {
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(4));
//		}
		System.out.println("finished1----");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e:"+e.getMessage());
		}
		System.out.println("finished");
	}

}
