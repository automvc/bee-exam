/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.chain;

import java.util.List;

import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.OrderType;
import org.teasoft.bee.osql.PreparedSql;
import org.teasoft.bee.osql.chain.Select;
import org.teasoft.bee.osql.exception.BeeErrorFieldException;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.chain.Aggregate;
import org.teasoft.honey.osql.chain.SelectImpl;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class ChainSelectExam {
	private static PreparedSql preparedSql = BeeFactory.getHoneyFactory().getPreparedSql();
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		Select t = new SelectImpl();
		String sql = "";
//      t.select("*")
        t
//        .select("id")
        .distinct("id")
        .select(Aggregate.max("total"))
//        .select("max(price)")
//        .distinct("name")
		.from("orders")
//		.from("abc") //如何检测已经使用了from,不能再用了??
		.where()
//		.op("userid", Op.eq, "client01")
//		.and()  //default will add
//		.op("name", Op.like, "Bee%")  要考虑注入攻击
//		.op("name", Op.like, "test2_")
		.op("name", Op.notLike, "Bee%") //自己拼字符,占位形式不能自动
//		.op("category", Op.in, "food,fruit")
		.between("total", 10, 100)
//		.notBetween("total", 90, 100)
		.isNotNull("createtime")
        
        .groupBy("name")
        .orderBy("id", OrderType.ASC)
        .orderBy("name")
        ;
        
        
//      sql= t.from("abc") //重新用t写,就可以从原来的开始.
        sql= t.toSQL();
        List<String[]> list1= preparedSql.select(sql);
        Printer.print(list1);
		
		Select goodOrders = new SelectImpl();
//		goodOrders.distinct("id")
		goodOrders
		.select("id,name,total")
//		.max("total")
		.from("orders")
		.where()
		.op("name", Op.eq, "client")
		.or()
		.op("name", Op.eq, "bee")
		;
		
		goodOrders.groupBy("name")
		.having("total>avg(total)")
//		.count("testtest")   顺序没能控制好
		;
        List<String[]> list2= preparedSql.select(goodOrders.toSQL());
        Printer.print(list2);
		
		Select whereJoin = new SelectImpl();
//		book.distinct("name")
		whereJoin
		.select("orders.id,total,orders.name,test_user.name")  //查多表时，怎么知道这是要查哪个表的字段？？  字段带表名，返回的结果如何赋值给Javabean?  要指明字段是哪个表的.可用别名。
//		.max("total")  
		.from("orders,test_user")
		.where("orders.name=test_user.name")
//		.where()
		.lParentheses()
		.between("total", 0, 100)
		.rParentheses()
//		.lParentheses()
		.op("orders.name", Op.eq, "Bee")
//		.rParentheses()
		;
		
        List<String[]> list3= preparedSql.select(whereJoin.toSQL());
        Printer.print(list3);
		
//		Op opType=Op.notIn;
//		if (opType == Op.notIn) Logger.info("===== true");
		
		Select c=new SelectImpl();
		c.select("team_id")
		.from("teams")
		.where()
		.op("price", 99)
		.groupBy("team_id")
		.groupBy("name")
		.having("count(*)=sum(case when status='aaa' then 1 else 0 end)");
		Logger.info(c.toSQL());
		
		Select join =new SelectImpl();
		join.select("*")
		.from("orders o")
		.join("test_user t")
		.on("o.name=t.name");
		
        List<String[]> list5= preparedSql.select(join.toSQL());
        Printer.print(list5);
        
        
		String classno = "201";
		int page = 1, rows = 10;
    	Select selectSql = new SelectImpl();
		selectSql.select("id,examno,classno,name,teacherno,createtime,updatetime")
		.from("scores")
		.where()
//		.op("classno", Op.eq, classno)
		.op("classno", Op.in, classno) 
		.start((page - 1) * rows)
		.size(rows)
		//			.select("count(*)")              
		//TODO  要是.toSQL后,才开始生成sql,那该类,就有可能重用. 只改select部分即可.
		;
        List<String[]> list6= preparedSql.select(selectSql.toSQL());
        Printer.print(list6);

		Select selectSql2 = new SelectImpl();
		selectSql2.select("count(*)")
		.from("scores")
		.where()
//		.op("classno", Op.eq, classno) //  可以扩展 Op.or实现
		.op("classno", Op.in, classno) 
		;
		
        List<String[]> list7= preparedSql.select(selectSql2.toSQL());
        Printer.print(list7);
        
        
        Select selectSql3 = new SelectImpl();
        selectSql3
        .select()
        .from("orders")
		.where()
		.lParentheses()   //(
		.op("id", Op.ge, 100005)
		.or()
		.op("id", Op.in, 100004)
		.rParentheses()  //)
		.isNotNull("name")
		.isNull("createtime")
		.notIn("id",100001)
		.in("id", 100002,100003)
		.between("id", 100002, 100004)
		.notBetween("id", 100005, 100006)
		.notIn("name", "testBee")
		.and()  //test and
		.op("name", "Bee")
		.orderBy("id")
		;
        List<String[]> list8= preparedSql.select(selectSql3.toSQL());
        Printer.print(list8);
        
        
		Select leftJoin =new SelectImpl();
		leftJoin.select("*")
		.from("orders o")
		.leftJoin("test_user t")
		.on("o.name=t.name");
		
        List<String[]> list9= preparedSql.select(leftJoin.toSQL());
        Printer.print(list9);
        
        
		Select rightJoin =new SelectImpl();
		rightJoin.select("*")
		.from("orders o")
		.rightJoin("test_user t")
		.on("o.name=t.name");
		
        List<String[]> list10= preparedSql.select(rightJoin.toSQL());
        Printer.print(list10);
        
		Select innerJoin =new SelectImpl();
		innerJoin.select("*")
		.from("orders o")
		.innerJoin("test_user t")
		.on("o.name=t.name");
		
        List<String[]> list11= preparedSql.select(innerJoin.toSQL());
        Printer.print(list11);
        
        
        Select wherePart=new SelectImpl();
        wherePart
//		.where()
		.lParentheses()
		.between("total", 0, 100)
		.rParentheses()
		.op("orders.name", Op.eq, "Bee")
		;
        
        Logger.info(wherePart.toSQL());
        
        
        
        Select subSelect=new SelectImpl();
        subSelect.select("id").from("orders");
        
        Select select1=new SelectImpl();
        select1
        .select()
        .from("orders")
        .where()
        .exists(subSelect)
        ;
        List<String[]> list12= preparedSql.select(select1.toSQL());
        Printer.print(list12);
        
        
        Select select2=new SelectImpl();
        select2
        .select()
        .from("orders")
        .where()
        .notExists(subSelect)
        ;
        List<String[]> list13= preparedSql.select(select2.toSQL());
        Printer.print(list13);
        
        
        Select select3=new SelectImpl();
        select3
        .select()
        .from("orders")
        .where()
        .in("id",subSelect)
        ;
        List<String[]> list14= preparedSql.select(select3.toSQL());
        Printer.print(list14);
        
        Select select4=new SelectImpl();
        select4
        .select()
        .from("orders")
        .where()
        .notIn("id",subSelect)
        ;
        List<String[]> list15= preparedSql.select(select4.toSQL());
        Printer.print(list15);
        
		Select aggregate = new SelectImpl();
		aggregate
		.select(Aggregate.count("total"))
        .select(Aggregate.max("total"))
        .select(Aggregate.min("total"))
        .select(Aggregate.avg("total"))
        .select(Aggregate.sum("total"))
		.from("orders")
		;
        List<String[]> list16= preparedSql.select(aggregate.toSQL());
        Printer.print(list16);
        
        //test exception
        try {
    		Select c2=new SelectImpl();
    		c2.select("team_id")
    		.from("teams")
    		.where()
    		.op("-- price", 99) // --
    		.groupBy("team_id")
    		.groupBy("name")
    		.having("count(*)=sum(case when status='aaa' then 1 else 0 end)");
    		
    		Logger.info(c2.toSQL());
		} catch (BeeErrorFieldException e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
        
        try {
    		Select c3=new SelectImpl();
    		c3.select("team_id")
    		.from("teams")
    		.where()
    		.op("price", 99)
    		.groupBy("team_id")
    		.groupBy("name")
    		.having(" --count(*)=sum(case when status='aaa' then 1 else 0 end)");  // --
    		
    		Logger.info(c3.toSQL());
		} catch (Exception e) {
			Logger.info(e.getMessage());
			e.printStackTrace();
		}
        
        Logger.info("ChainSelectExam finished....");
        
	}

}
