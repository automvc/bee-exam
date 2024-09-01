/*
 * Copyright 2019-2024 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.localdatetime;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.TO_DATE;
import org.teasoft.bee.osql.api.Condition;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  2.4.0
 */
public class LocalDateTimeExam3 {

	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception {
		
		LocaldatetimeTable bean = new LocaldatetimeTable();
		bean.setId(10);
//		bean.setLocaldatetime(LocalDateTime.now());
		bean.setTimestamp(new Timestamp(System.currentTimeMillis()));

		SuidRich suidRich = BF.getSuidRich();
//		int a=suidRich.insert(bean);
//		Logger.info("insert num:"+a);

		LocaldatetimeTable selectBean = new LocaldatetimeTable();
		Condition condition = BF.getCondition();
		condition.op("localdatetime", Op.ge, new TO_DATE("2024-07-08", "YYYY-MM-DD"));

		List<LocaldatetimeTable> list = suidRich.select(selectBean, condition);
		Printer.printList(list);

		String dateString = "2024-07-08T23:55:35.534";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		Date parsedDate = dateFormat.parse(dateString);
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
//	        System.out.println("Timestamp in Java format: " + timestamp);

		condition = BF.getCondition();
		condition.op("localdatetime", Op.ge, timestamp);
		condition.op("localdatetime", Op.le, timestamp); //改为另一个timestamp的值即可
		list = suidRich.select(selectBean, condition);
		Printer.printList(list);
	}

}
