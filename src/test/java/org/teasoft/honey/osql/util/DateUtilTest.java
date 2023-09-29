/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

/**
 * @author Kingstar
 * @since  1.11
 */
public class DateUtilTest {
	
	
//	new Timestamp(Calendar.getInstance().getTimeInMillis()); 

	
//	Timestamp createTime = new Timestamp(new Date().getTime());//Date转Timestamp
	
//	Timestamp t = new Timestamp(System.currentTimeMillis());
//    Date d = new Date(t.getTime());
	
	
//	public static void main(String[] args) {
	@Test
	public void test() {
		System.out.println(DateUtil.currentDate());
		System.out.println(DateUtil.jumpDays(1));
		System.out.println(DateUtil.jumpDaysExact(1));
		System.out.println(DateUtil.isNowEffect(DateUtil.jumpDays(-1)));
		
		Timestamp d1=DateUtil.jumpDays(2);
		System.out.println(d1);
		Timestamp d2=DateUtil.jumpDays(d1,8);
		System.out.println(d2);
		
		DateUtil.currentDate("yyyy-MM-dd HH:mm:ss");
		DateUtil.toSqlDate(new Date());
		DateUtil.toTimestamp(new Date());
		DateUtil.toDateStr(new Date());
		DateUtil.countAge("2010-10-20");
		DateUtil.yyyy_MM_dd("2010-10-20");
		DateUtil.yyyy_MM_dd("2010-02-29");
		DateUtil.yyyy_MM_dd("2010-10-32");
		DateUtil.yyyyMMdd("20101020");
		DateUtil.yyyyMMdd("20100228");
		DateUtil.yyyyMMdd("20101032");
		DateUtil.yyyyMMdd("2010-10-30"); //写多了-
		DateUtil.checkDate("2010-10-20", "yyyy-MM-dd");
		
		
		System.out.println(DateUtil.jumpDaysExact(0));
	}
	
	

}
