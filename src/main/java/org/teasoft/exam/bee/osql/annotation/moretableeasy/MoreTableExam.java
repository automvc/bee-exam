/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.annotation.moretableeasy;

import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;


/**
 * @author Kingstar
 * @since  1.7
 */
public class MoreTableExam {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		try {
			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
			Clazz1 clazz1=new Clazz1();
//			clazz1.setStudent(new Student1()); //若有任务需要拦截器处理,则需要声明.因为由框架生成,实体可能有默认值,与用户想要的不一定一致.
			List<Clazz1> list=moreTable.select(clazz1);  //不设置表关系,是否可以?? 可以
			Printer.printList(list);  //先自动创建一个从表对象,之后再置为null  ??
			
//			Clazz1 c1=new Clazz1();
//			Student1 student1=new Student1();
//			student1.setAge(20);
//			c1.setStudent(student1);
//			student1.getStudentHobbyList().add(new StudentHobby());  //设置关联
//
//			List<Clazz1> list1=moreTable.select(c1);
//			Printer.printList(list1);

		} catch (BeeException e) {
			e.printStackTrace();
			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
		}catch (Exception e) {
			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
