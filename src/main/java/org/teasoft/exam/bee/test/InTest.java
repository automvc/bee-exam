/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.exam.bee.osql.entity.field.Orders_F;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 关于condition.op(fieldName, Op.in, Value)的示例
 * How to use condition.op(fieldName, Op.in, Value)
 * @author Kingstar
 * @since  1.11
 */
public class InTest {
	
//	/**
//	 * 添加一个表达式条件.Add a expression condition.
//	 * <br>仅Op.notIn,Op.in支持String,Number,List,Set;其它类型一般只使用String,Number两种类型.
//	 * <br>Op.notIn,Op.in使用String类型时,逗号作为分隔符.
//	 * <br>此方法不能用于SQL的update set.
//	 * @param field 字段名.field name
//	 * @param op 操作符.operator.
//	 * @param value 字段对应的值.value of the field.
//	 * @return Condition
//	 */
//	public Condition op(String field, Op op, Object value);
	
	
	
    public static void main(String[] args) {
    	Suid suid=BF.getSuid();
    	Orders orders = new Orders();

//		orders.setName("Bee(ORM Framework)"); //等于的条件,会默认转换
//		orders.setAbc("test1");

    	
    	//case 1: empty string
		Condition condition = new ConditionImpl();
		condition
//		.op("userid", Op.in, "Bee,client02,client03")
		.op("userid", Op.in, "")   //会转换,这样安全.  否则可能会有暴露所有数据的危险.  where userid in ('') ;
//		.op("createtime", Op.ge, "2020-03-01")
//        .op("createtime", Op.le, "2020-03-03")
		;

		List<Orders> list1 = suid.select(orders, condition);
		Printer.printList(list1);
		
		//case 2: "1006,1008"
		if (HoneyUtil.isMysql()) {
			Condition condition2 = BF.getCondition();
			condition2.op(Orders_F.id, Op.in, "1006,1008"); // mysql可以这样用.
			List<Orders> list2 = suid.select(orders, condition2);
			Printer.printList(list2);
		}
		
		//case3: List<Number>
		Condition condition3 =BF.getCondition();
		List<Integer> ids=new ArrayList<>();
		ids.add(1006);
		ids.add(1008);
		condition3.op(Orders_F.id, Op.in, ids);
		List<Orders> list3 = suid.select(orders, condition3);
		Printer.printList(list3);
		
		//case4: Set<Number>
		Condition condition4 =BF.getCondition();
        Set<Long> idsSet=new HashSet<>();
        idsSet.add(1007L);
        idsSet.add(1008L);
        idsSet.add(1008L); //test: add again
        idsSet.add(1009L);
		condition4.op(Orders_F.id, Op.in, idsSet);
		List<Orders> list4 = suid.select(orders, condition4);
		Printer.printList(list4);
		
		//case5: Number Array
		Condition condition5=BF.getCondition();
		Integer idArray[] = {1,2,3};
		condition5.op(Orders_F.id, Op.in, idArray);
		List<Orders> list5 = suid.select(orders, condition5);
		Printer.printList(list5);
		
		//case6: one element
		Condition condition6=BF.getCondition();
		condition6.op(Orders_F.id, Op.in, 1007L); 
		List<Orders> list6 = suid.select(orders, condition6);
		Printer.printList(list6);
		
		//case7: null element
		Condition condition7=BF.getCondition();
		condition7.op(Orders_F.id, Op.in, null); 
		List<Orders> list7 = suid.select(orders, condition7);
		Printer.printList(list7);
		
		//case8: List<String>
		Condition condition8 =BF.getCondition();
		List<String> ids8=new ArrayList<>();
		ids8.add("Bee");
		ids8.add("Honey");
		condition8.op(Orders_F.name, Op.in, ids8);
		List<Orders> list8 = suid.select(orders, condition8);
		Printer.printList(list8);
	}

}
