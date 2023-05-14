package org.teasoft.exam.bee.mongodb.json;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.json.entity.Inventory;
import org.teasoft.exam.bee.mongodb.json.entity.Size;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

public class InventoryTestInsert {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Inventory test=new Inventory();
		test.setItem("fruit");
		test.setQty(10);
		test.setStatus("exist");
		
		Size size=new Size();
		size.setUom("cm(\"OK\")");  //若是嵌入式文档，插入属性入库时就转换。
		size.setH(10D);
		size.setW(new BigDecimal("11.2"));
		test.setSize(size);
		
		SuidRich suidRich=BF.getSuidRich();
		int num=suidRich.insert(test);
		System.out.println(num);
		
//		List<Inventory> list2=suidRich.select(new Inventory(),50);
//		System.out.println(list2.size());
//		Printer.printList(list2);
	}

}
