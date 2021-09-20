/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.MoreTable;
import org.teasoft.bee.osql.Op;
import org.teasoft.exam.bee.osql.entity.Clazz;
import org.teasoft.exam.bee.osql.entity.Clazz0;
import org.teasoft.exam.bee.osql.entity.Clazz00;
import org.teasoft.exam.bee.osql.entity.Clazz011;
import org.teasoft.exam.bee.osql.entity.Clazz02;
import org.teasoft.exam.bee.osql.entity.Clazz1;
import org.teasoft.exam.bee.osql.entity.Clazz3;
import org.teasoft.exam.bee.osql.entity.Clazz4;
import org.teasoft.exam.bee.osql.entity.Student;
import org.teasoft.exam.bee.osql.entity.Student011;
import org.teasoft.exam.bee.osql.entity.Student1;
import org.teasoft.exam.bee.osql.entity.StudentHobby;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class ListEntityTest {
	
	public static void main(String[] args) {
		
		MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
		
		
//		case 1    Clazz has: List<Student>,     Student里是非List子表
		Clazz c=new Clazz();
//		c.setClassname("class-one");
//		private List<Student> student;  //通过这行代码, 如何能从对象中,获取泛型T是student
		Student student=new Student();
		student.setAge(20);
		c.getStudentList().add(student);   //Student里非List子表
		List<Clazz> list=moreTable.select(c);
		Printer.printList(list);
		list=moreTable.select(c,0,2);  //主表分页,也是会受从表的影响.
		Printer.printList(list);
		
		
		//如何合并数据?????                                                          后面三个不同
//		2001	class-one	1楼	黄老师		1	1001	Peter	20	1	4001		2001	3000	1001	画画	
//		2001	class-one	1楼	黄老师		1	1001	Peter	20	1	4001		2001	3001	1001	书法	
		//case 2: Clazz1 has: Student student,   Student里是:List
		Clazz1 c1=new Clazz1();
		Student1 student1=new Student1();
		student1.setAge(20);
		c1.setStudent(student1);
		student1.getStudentHobbyList().add(new StudentHobby());  //设置关联

		List<Clazz1> list1=moreTable.select(c1);
		Printer.printList(list1);
		
//		//case 3
//		//one Has one 都是List
		Clazz011 c011=new Clazz011();
		c011.setClassname("class-one");
		
		Student011 student011=new Student011();
		student011.setAge(20);
		c011.getStudentList().add(student011);
		
		List<Clazz011> list011=moreTable.select(c011);
		Printer.printList(list011);
//		
//		case 4
		//Clazz02 有两个List     子表还有注解,提示没有打印????
		Clazz02 c02=new Clazz02();
		Student student02=new Student();
//		student011.setAge(20);
		c02.getStudentList().add(student02);
		c02.getStudentHobbyList().add(new StudentHobby());  //设置关联
		List<Clazz02> list02=moreTable.select(c02);
		Printer.printList(list02);
		
		
		
		//case 5
		//Clazz03 有1个List, 1个非List
		Clazz3 c3=new Clazz3();
		Student student3=new Student();
		c3.getStudentList().add(student3);
		c3.setStudentHobby(new StudentHobby());
		List<Clazz3> list3=moreTable.select(c3);
		Printer.printList(list3);
		
		
		
		//case 6     
		//与case5对比,调了两个子表的顺序.
		//bug 中间的表(子表1),一条是null, 导致后面的表在该条记录有数据,也转换不出来.  已解决.
		Clazz4 c4=new Clazz4();
		c4.setStudentHobby(new StudentHobby());
		Student student4=new Student();
		c4.getStudentList().add(student4);
		List<Clazz4> list4=moreTable.select(c4);
		Printer.printList(list4);
		
		
		// 1 to 1(List)  subClass="org.teasoft.exam.bee.osql.entity.Student"
		Clazz0 c0=new Clazz0();
//		Student student02=new Student();
//		c0.getStudentList().add(student02);
		List<Clazz0> list0=moreTable.select(c0);
		Printer.printList(list0);
		
		//注意case4 和 case5 , Clazz里的结构不一样,即使查询到的数据一样,但拼出来的,也不一样.不能用同样的缓存.
		
		//加注解属性 subClass=""
		
		//Condition 一起使用的测试
		//分页.
		
		
		
		Condition condition = new ConditionImpl();
		condition
		//.op("myuser.id", Op.gt,6)//模糊查询   取别名
		//.op("user.id", Op.gt,6) //模糊查询  
		.op("Clazz.id", Op.ge, 1001) //模糊查询  
//		.start(0).size(5) //分页
		.start(2).size(6) //分页
		;
		List<Clazz0> list001=moreTable.select(c0,condition);
		Printer.printList(list001);
		
//		1 to 1(List)  subClass="Student"    subClass 配置 不带包含  
		Clazz00 c00=new Clazz00();
//		c00.setId(1);
		condition = new ConditionImpl();
		condition
		.op("Clazz.teachername", Op.like, "%老师") //模糊查询  
		;
		
//		condition=null;
		
//		List<Clazz00> list00=moreTable.select(c00);
//		List<Clazz00> list00=moreTable.select(c00,2,2);
		List<Clazz00> list00=moreTable.select(c00,condition);
		Printer.printList(list00);
		
//		for (int i = 0; i < 5; i++) {
//			int size=2;
//			list00=moreTable.select(c00,i*size,size);
//			Printer.printList(list00);
//		}
//		
//		
		//从表为null.主表无字段值.   改写,准确
//		Clazz00 c00;
		c00=new Clazz00();
		 list00=moreTable.select(c00,1,2);
		Printer.printList(list00);
//		
//		//从表为null.主表有字段值.   改写,准确
//		c00=new Clazz00();
////		c00.setPlace("1楼");
//		c00.setRemark("aa");
//		list00=moreTable.select(c00,0,2);
//		Printer.printList(list00);
//		
		c00=new Clazz00();
		c00.setId(2001);  //确认是一条记录,   准确
//		list00=moreTable.select(c00,0,2);
		list00=moreTable.select(c00,0,2);
		Printer.printList(list00);
		
		//从表有值.  不改写
		 Student student00=new Student();
		 student00.setAge(20);
		c00.getStudentList().add(student00); 
		list00=moreTable.select(c00,0,2);
		Printer.printList(list00);
		
		
//		1 to 1(List)  subClass="Student"    subClass 配置 不带包含  
		//带分页,   数据不准确.
		condition = new ConditionImpl();
		condition
		.op("Clazz.teachername", Op.like, "%老师") //模糊查询  
		.start(2).size(2) //分页
		;
		c00=new Clazz00();
		list00=moreTable.select(c00,condition);
		Printer.printList(list00);
		
		c00=new Clazz00();
		c00.setId(2001);  //确认是一条记录,   准确
		list00=moreTable.select(c00,condition);
		Printer.printList(list00);
		
		//当子表为List, 且子表设置有值或使用有Condition 时,   若需要分页,    
//		可一次性获取完所有需要数据, 再在程序进行根据list.size()分页.
		
	}

}
