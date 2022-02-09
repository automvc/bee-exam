/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import java.sql.Timestamp;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DateUtilTest {
	
	
//	new Timestamp(Calendar.getInstance().getTimeInMillis()); 

	
//	Timestamp createTime = new Timestamp(new Date().getTime());//Date转Timestamp
	
//	Timestamp t = new Timestamp(System.currentTimeMillis());
//    Date d = new Date(t.getTime());
	
	
	public static void main(String[] args) {
		System.out.println(DateUtil.jumpDays(1));
		System.out.println(DateUtil.jumpDaysExact(1));
		System.out.println(DateUtil.isNowEffect(DateUtil.jumpDays(-1)));
		
		Timestamp d1=DateUtil.jumpDays(2);
		System.out.println(d1);
		Timestamp d2=DateUtil.jumpDays(d1,8);
		System.out.println(d2);
		
		
		System.out.println(DateUtil.jumpDaysExact(0));
	}
	
	

}
