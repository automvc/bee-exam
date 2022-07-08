/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.commomid;

import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.dialect.Noid2;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.distribution.UUID;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class NotLongId {
	
	static SuidRich suidRich=BF.getSuidRich();
	
	public static void main(String[] args) {
		
		
		Noid noid=new Noid();//@GenUUID
		noid.setName("Bee");
		noid.setNum(100);
		
		suidRich.insert(noid);
		
		//在String类型字段,使用long型id
		Noid0 noid0=new Noid0(); //@GenId
//		noid0.setUuid("1111");
		noid0.setName("Bee");
		noid0.setNum(200);
		
		suidRich.insert(noid0);
		
		//1)当主键的类型为String时,而主键的值是long值的字符串,可以使用返回值是long的insertAndReturnId
		//2)当主键的类型为Integer时,也可以使用返回值是long的insertAndReturnId
		//3)当主键的类型为String时,只能由程序生成主键的非Long或Integer型字符串,并由程序负责保存,然后使用insert(T)方法插入.
		long returnId=suidRich.insertAndReturnId(noid0);
		System.out.println(returnId);
		
		noid0.setUuid(returnId+"");
		noid0.setNum(300);
		suidRich.update(noid0); //默认时,主键为where的过滤条件.
//		update Noid set name='Bee' , num=300 where uuid='727972478713858' ;
		
		
		//字符型的id不能用返回值的long的方法返回,不能使用如:5038ec2b8d534c9fb66294475e0bd252
//		long returnId2=suidRich.insertAndReturnId(noid);
//		System.out.println(returnId2);
		//3)当主键的类型为String时,只能由程序生成主键的非Long或Integer型字符串,并由程序负责保存,然后使用insert(T)方法插入.
		//手动设置字符串主键
		noid.setName("Bee");
		noid.setNum(200);
		String myUuid=UUID.getId();
		noid.setUuid(myUuid); //手动设置字符串主键
		suidRich.insert(noid);
		
		noid.setNum(400); //改为400
		suidRich.update(noid);//默认时,主键为where的过滤条件.
		
//		int updateBy(T entity,String whereFields);
		suidRich.updateBy(noid, "uuid,name"); //updateBy, 通过"uuid,name"字段修改,"uuid,name"会作为where的过滤条件
		
//		int update(T entity,String updateFields);
		suidRich.update(noid, "num"); //只更新num字段, 则其它字段作为where过滤条件
		
		
		//测试自定义主键情形
		List<Noid> list4 = suidRich.select(new Noid(),3);
		Printer.printList(list4);
		
		suidRich.select(new Noid(),2,3);
		suidRich.select(new Noid(),"uuid",0,3);
		String json=suidRich.selectJson(new Noid(),"uuid",0,3);
		Logger.info(json);
		
		Condition condition5=BF.getCondition();
		condition5.size(5);
		List<Noid> list5 = suidRich.select(new Noid(),condition5);
		Printer.printList(list5);
		
		//测试主键字段要命名转换
		suidRich.select(new Noid2(),2,3);
		suidRich.select(new Noid2(),"uuId",0,3);
		
		Condition condition6=BF.getCondition();
		condition6.size(5);
		List<Noid0> list6 = suidRich.select(new Noid0(),condition6);
	}

}
