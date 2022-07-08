/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.app.bee;

import org.teasoft.exam.app.bee.entity.*;
import org.teasoft.bee.osql.*;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.honey.osql.autogen.Ddl;
import org.teasoft.honey.osql.core.*;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.osql.util.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingstar
 * @since  1.17
 */
public class BeeTest {
	
	private SuidRich suidRich=BF.getSuidRich(); 
	
	public void testCreateTable() {
		Ddl.createTable(new Orders(), false);
		Ddl.createTable(new TestUser(), false);
		Ddl.createTable(new LeafAlloc(), true);
	}
	
	public void testInsertAndReturn() {
		Tb_outaccount a=new Tb_outaccount();
		a.setAddress("aaa");
		
		a.setMoney(0.520);
		long r=suidRich.insertAndReturnId(a);
		System.out.println("----insertAndReturnId:  "+r);
		
//		a.setid(30);
//		r=suidRich.insertAndReturnId(a);
//		System.out.println("----insertAndReturnId,bean有设置id:  "+r);
		
		LeafAlloc leaf=new LeafAlloc();
		leaf.setDescription("bee");
		leaf.setBizTag("bee");
		leaf.setUpdateTime(DateUtil.currentTimestamp());
		r=suidRich.insertAndReturnId(leaf);
		System.out.println("----insertAndReturnId,leaf,有Timestamp:  "+r);
		
		List<LeafAlloc> list2=suidRich.select(new LeafAlloc(),0,10); //从0开始算. offset是偏移量
		if(list2.size()>0) {
			System.err.println("-------------Timestamp:------"+list2.get(0).getUpdateTime().toString());
		}
	}
	
	public void testFun() {
		String max=suidRich.selectWithFun(new Tb_outaccount(), FunctionType.MAX, "_id");
		String min=suidRich.selectWithFun(new Tb_outaccount(), FunctionType.MIN, "_id");
		String sum=suidRich.selectWithFun(new Tb_outaccount(), FunctionType.SUM, "_id");
		String avg=suidRich.selectWithFun(new Tb_outaccount(), FunctionType.AVG, "_id");
		String count=suidRich.selectWithFun(new Tb_outaccount(), FunctionType.COUNT, "_id");
		
		
		System.out.println("max:"+max+",min:"+min+",sum:"+sum+",avg:"+avg+",count:"+count+".");
		
		suidRich.deleteById(Tb_outaccount.class, "1,2");
	}

	public void testMoretable() {
		String sql = "select tb_inaccount._id,tb_inaccount.handler,tb_inaccount.mark,tb_inaccount.money,tb_inaccount.time,tb_inaccount.type,tb_outaccount._id as 'tb_outaccount._id',tb_outaccount.address,tb_outaccount.mark as 'tb_outaccount.mark',tb_outaccount.money as 'tb_outaccount.money',tb_outaccount.time as 'tb_outaccount.time',tb_outaccount.type as 'tb_outaccount.type' from (select * from tb_inaccount where tb_inaccount.mark='abc' or '1'='1' limit 20 offset 0) tb_inaccount,tb_outaccount where tb_inaccount._id=tb_outaccount._id and tb_inaccount.mark='abc' or '1'='1'";
		PreparedSql p = BF.getPreparedSql();
		p.moreTableSelect(sql, new Tb_inaccount());
	}
	
	public void testBatchInsert() {
		
		Tb_outaccount a=new Tb_outaccount();
		Tb_outaccount b=new Tb_outaccount();
		Tb_outaccount c=new Tb_outaccount();
		
		a.setAddress("aaa");
		b.setAddress("bbb");
		c.setAddress("ccc");
		
		a.setMoney(0.618);
		b.setMoney(0.619);
		c.setMoney(0.620);
		
		List<Tb_outaccount> list=new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		
		suidRich.insert(list);
		
		suidRich.insert(list,2); //一次只插入2条,分两批.
		
	}
	
	public int testDelete10000() {
		return suidRich.delete(new Tb_inaccount());
	}
	
	public int testBatchInsert10000() {
		
		Tb_inaccount a=null;
		String addr="aaa";
		List<Tb_inaccount> list=new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			a=new Tb_inaccount();
			a.setid(i);
			a.setMark(addr+i);
			a.setMoney(0.618);
			list.add(a);
		}
		
//		return suidRich.insert(list);
		return suidRich.insert(list,2500);
		
//		suidRich.insert(list,2); //一次只插入2条,分两批.
	}
	
	public int testBatchInsert10000Div2() {
		
		Tb_inaccount a=null;
		String addr="aaa";
		List<Tb_inaccount> list=new ArrayList<>();
		for (int i = 1; i <= 10000; i++) {
			a=new Tb_inaccount();
			a.setid(i);
			a.setMark(addr+i);
			a.setMoney(0.618);
			list.add(a);
		}
		
//		return suidRich.insert(list);
		
		return suidRich.insert(list,5000); 
	}
	
	
//	public List<Tb_inaccount> testQuery10000() {
//		return suidRich.select(new Tb_inaccount(), 0, 10000);
//	}
		
	public void testQuery10000() {
//		return suidRich.select(new Tb_inaccount(), 0, 10000);
		for (int i = 0; i < 10; i++) { //分10批查
			suidRich.select(new Tb_inaccount(), i*10000, 1000);
		}
	}
	
	

	public void testTran() {
		Transaction transaction=SessionFactory.getTransaction();
		
		try {
			
			transaction.begin();
			Suid suid = BeeFactory.getHoneyFactory().getSuid();
			
			TestUser user=new TestUser();
			user.setUsername("testuser");
			user.setPassword("bee-user");
			
			suid.insert(user);//insert 1

			Orders orders = new Orders();
			orders.setUserid("bee");
			orders.setName("Bee(ORM Framework)");
			orders.setTotal(new BigDecimal("91.99"));
			orders.setRemark("test transaction"); 
			orders.setSequence("");//empty String test

			suid.insert(orders); //insert 2
			
			transaction.commit();

			List<Orders> list = suid.select(orders); //可任意组合条件查询
			for (int i = 0; i < list.size(); i++) {
				Logger.info(list.get(i).toString());
			}

		} catch (BeeException e) {
			Logger.error("In TransactionExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In TransactionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
		
		Orders exampleField=new Orders();
		exampleField.setUserid("bee");
//      select some fields
		List<Orders> selectSomeField=suidRich.select(exampleField, "name,total");
	}
	
	
	public void testRollback(boolean isThrowException) {
		LeafAlloc result = null;
		Transaction transaction = SessionFactory.getTransaction();
		try {
			
//			TypeHandlerRegistry.register(Timestamp.class, new TimestampTypeHandler<Timestamp>());
			
			transaction.begin();

//			"UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag}"
			LeafAlloc leafAlloc = new LeafAlloc();
			leafAlloc.setBizTag("bee");
			Condition condition = new ConditionImpl();
			condition.setAdd("maxId", "step");
			if(!HoneyUtil.isSqlServer()) {
				String d=null;
				condition.set("updateTime", d);  //updateTime是Timestamp类型,即使设置为null,Sql Server也不允许
	//		    suidRich.update(leafAlloc, "maxId", condition);
				suidRich.update(leafAlloc, condition); //v1.8
			}
//			if (!HoneyUtil.isOracle()) {
			if (HoneyUtil.isMysql()) {
				condition.set("updateTime", DateUtil.currentDate()); //直接设置字符串可以.
				suidRich.update(leafAlloc, condition);
//				update leaf_alloc set max_id=max_id+step,update_time=null,update_time='2022-03-09 11:54:51' where biz_tag='bee'
//				Caused by: java.sql.SQLSyntaxErrorException: ORA-00957: 重复的列名
//				at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
			}
			
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

//		    "SELECT biz_tag, max_id, step FROM leaf_alloc WHERE biz_tag = #{tag}"
			result = suidRich.selectOne(leafAlloc);
			if(result!=null) Logger.info(result.toString());
			
			List list=suidRich.select(leafAlloc,0,10); //从0开始算. offset是偏移量
			
			LeafAlloc leafAlloc2 = new LeafAlloc();
			leafAlloc2.setBizTag("bee");
			leafAlloc2.setUpdateTime(DateUtil.currentTimestamp());
			int a=suidRich.updateBy(leafAlloc2,"BizTag");
//			System.err.println(a);
			Logger.info(a);
			List list2=suidRich.select(new LeafAlloc(),0,10); //从0开始算. offset是偏移量
			
			if(isThrowException) {
				int error=1/0;
			}

			transaction.commit();
		} catch (Exception e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
			Logger.error(" Transaction rollback !");
			transaction.rollback();
		}
	}

}
