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

/**
 * @author ctc
 * @since  1.0
 */
public class AccessDbTest0 {
	
	public static void main(String[] args){
		try {
			

//		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver") ;
//		String url="jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=d:/school.accdb";
//		Connection conn = DriverManager.getConnection(url,"","");
		
		
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://<mdb or accdb file path>",user, password); 
//		for example: 
		Connection conn=DriverManager.getConnection("jdbc:ucanaccess://d:/school.accdb");
//		
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
		System.out.println("finished1");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e:"+e.getMessage());
		}
		System.out.println("finished");
	}

}
