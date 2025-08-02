/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation.moretable;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.BeeFactory;


/**
 * Moretable suid, no sharding.
 * @author Kingstar
 * @since  1.7
 */
public class MoreTableExam24Suid {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			
			Clazz1 clazz1=new Clazz1();
//			clazz1.setId(10033);
			clazz1.setClassname("class one");
			clazz1.setPlace("BeiJing");
			Student1 student01=new Student1();
//			student01.setClassno(1L);
			student01.setAge(20);
			student01.setName("Zhang san");
			
//			Student1 student02=new Student1();
//			student02.setName("Li si");
			
			StudentHobby s1=new StudentHobby();
			s1.setHobby("ball");
			StudentHobby s2=new StudentHobby();
			s2.setHobby("computer");
			List<StudentHobby> studentHobbyList=new ArrayList<>();
			studentHobbyList.add(s1);
			studentHobbyList.add(s2);
			
			student01.setStudentHobbyList(studentHobbyList);
			clazz1.setStudent(student01);
			
			moreTable.insert(clazz1);
			
			//PostgreSQL    ERROR: operator does not exist: bigint = character varying
			List<Clazz1> list=moreTable.select(new Clazz1());  //不设置表关系,是否可以??
			Printer.printList(list);  //先自动创建一个从表对象,之后再置为null  ??
			
			Clazz1 c1=new Clazz1();
			Student1 student1=new Student1();
			student1.setAge(20);
			c1.setStudent(student1);
			student1.getStudentHobbyList().add(new StudentHobby());  //设置关联

			List<Clazz1> list1=moreTable.select(c1);
			Printer.printList(list1);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
