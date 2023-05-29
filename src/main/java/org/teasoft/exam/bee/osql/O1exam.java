/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.exam.bee.osql.entity.StudentHobby;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class O1exam {
	public static void main(String[] args) {
		Suid suid=BeeFactory.getHoneyFactory().getSuid();
		
		Student student=new Student();
		student.setId(1);
		List<Student> list1 =suid.select(student); //查询实体student
		for (int i = 0; i < list1.size(); i++) {//处理list1
			Logger.info(list1.get(i).toString());
		}
		
		StudentHobby hobby=new StudentHobby();
		hobby.setStuId("1001");
		List<StudentHobby> list2 =suid.select(hobby);//查询实体StudentHobby
		for (int i = 0; i < list2.size(); i++) { //处理list2
			Logger.info(list2.get(i).toString());
		}
	}

}
