package org.teasoft.exam.bee.mongodb.json;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.json.entity.Inventory;
import org.teasoft.exam.bee.mongodb.json.entity.Size;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

/**
 * test Mongodb collection sub document
 */
public class InventoryTestSub {
	
	public static void main(String[] args) {
		Inventory test=new Inventory();
		test.setItem("fruit");
		test.setQty(10);
		test.setStatus("exist");
		
		Size size=new Size();
		size.setH(10D);
		size.setW(new BigDecimal("11.2"));
		test.setSize(size);
		
		SuidRich suidRich=BF.getSuidRich();
//		int num=suidRich.insert(test);
//		System.out.println(num);
		
		Condition c=BF.getCondition();
		c.op("size.uom", Op.eq, "cm");
		//以下的api地址,是说可以,但用navicat也不行.  查下,是否是驱动版本太旧了.
//		https://www.mongodb.com/docs/manual/tutorial/query-embedded-documents/
		
		List<Inventory> list2=suidRich.select(new Inventory(),c);
		System.out.println(list2.size());
		Printer.printList(list2);
	}

}
