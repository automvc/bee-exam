package org.teasoft.exam.bee.mongodb.json;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.exam.bee.mongodb.json.entity.Inventory;
import org.teasoft.exam.bee.mongodb.json.entity.Size;
import org.teasoft.honey.osql.shortcut.BF;
import org.teasoft.honey.util.Printer;

public class InventoryTestJson3 {
	
	public static void main(String[] args) throws Exception{
		test();
	}

	public static void test() throws Exception{
		Inventory test=new Inventory();
		test.setItem("fruit");
		test.setQty(10);
		test.setStatus("exist");
		
		Size size=new Size();
		size.setUom("cm");
		size.setH(10D);
		size.setW(new BigDecimal("11.2"));
		test.setSize(size);
		
		SuidRich suidRich=BF.getSuidRich();
		
		int num=suidRich.insert(test);
		System.out.println(num);
		
		
//		String json=suidRich.selectJson(new Inventory(),IncludeType.EXCLUDE_BOTH,null); //fixed bug
		
		List<Inventory> list0=suidRich.select(new Inventory(),IncludeType.EXCLUDE_BOTH);
		Printer.printList(list0);
	}

}
