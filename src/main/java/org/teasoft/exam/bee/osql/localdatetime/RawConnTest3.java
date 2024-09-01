/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.teasoft.honey.osql.core.SessionFactory;

/**
 * @author Kingstar
 * @since  1.11
 */
public class RawConnTest3 {
	
	public static void main(String[] args) throws SQLException{
		Connection conn=SessionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs =null;
//		String sql="select orders.id from orders;"; //oracle ORA-00911: 无效字符   不能带分号
		String sql="select *  from LOCALDATETIME_TABLE WHERE localtimestamp <= TO_DATE('2024-07-05', 'YYYY-MM-DD')";
		pst = conn.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) {
			//oracle,sqlite不能用带表名的名称来获取数据
//			Object s=rs.getString("localtimestamp"); //mysql ok.  oracle:列名无效
//				System.out.println(s);	
			
			for (int i = 1; i <= 7; i++) {
				Object obj=rs.getObject(i);
				if(obj!=null)System.out.println("i:"+i+ obj.getClass().getName());
				
			}
			
		}
	}

}
