package org.teasoft.exam.bee.mongodb.json;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.mongodb.json.entity.Inventory;
import org.teasoft.exam.bee.mongodb.json.entity.Size;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

public class InventoryTestString {
	
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
		int num=suidRich.insert(test);
//		
		System.out.println(num);
		
		List<String[]> list2=suidRich.selectString(new Inventory());
//		List<String[]> list2=suidRich.selectString(new Inventory(),"item,qty,size");
		
//		List<String[]> list2=suidRich.selectString(new Inventory(),BF.getCondition());
		System.out.println(list2.size());
		Printer.print(list2);
	}

}
