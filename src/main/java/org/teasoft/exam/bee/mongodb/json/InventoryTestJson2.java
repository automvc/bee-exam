package org.teasoft.exam.bee.mongodb.json;

import java.math.BigDecimal;
import java.util.List;

import org.teasoft.bee.osql.IncludeType;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.beex.json.JsonUtil;
import org.teasoft.exam.bee.mongodb.json.entity.Inventory;
import org.teasoft.exam.bee.mongodb.json.entity.Size;
import org.teasoft.exam.comm.Printer;
import org.teasoft.honey.osql.shortcut.BF;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryTestJson2 {
	
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
		
//		String json=suidRich.selectJson(new Inventory());
//		String json=suidRich.selectJson(new Inventory(),"item,qty,size");
//		String json=suidRich.selectJson(new Inventory(),"size");
//		String json=suidRich.selectJson(new Inventory(),"id,size");
//		String json=suidRich.selectJson(new Inventory(),"item,qty");
		
		String json=suidRich.selectJson(new Inventory(),IncludeType.EXCLUDE_BOTH,null); //fixed bug
		
//		String json=suidRich.selectJson(new Inventory(),BF.getCondition());
		System.out.println(json);
		
		
//		  JSONObject object= JSONObject.parseObject(json);
//		  System.err.println(object.getJSONObject("json").get("size"));
		
		//------------------------ali--
//		JSONArray array = JSON.parseArray(json);
//		JSONObject obj=(JSONObject)array.get(0);
		
//		List<Inventory> list0 = JSONObject.parseArray(json, Inventory.class);// 把字符串转换成List<>
//		Printer.printList(list0);
		
//		List<Inventory> list0 =JsonUtil.toEntityList(json, Inventory.class);
//		Printer.printList(list0);
		
//		Object objSize=obj.get("size");
//		System.err.println(objSize.toString());
//		
//		Size obj_TranAli = JSONObject.parseObject(objSize.toString(), Size.class);
//		System.out.println(obj_TranAli);
//		System.err.println(obj_TranAli.getUom());
//		System.err.println(obj_TranAli.getH());
//		System.err.println("-------ali-- end");
		//------------------------ali--
		
//		Size sizeTest=JsonUtil.toEntity(objSize.toString(), Size.class);
//		System.err.println(sizeTest.getUom());
//		System.err.println(sizeTest.getH());
		
		
		//若存储的json,在查出后,又加转义符,会报:can not cast to : com.test.entity.Size
////		所以存的是Json 字符串就不能再转义
////		Size size=new Size();
////		size.setUom("cm(\"OK\")");  //若是嵌入式文档，插入属性入库时就转换; 查出时不用再转换.
//		Inventory tranInventory=obj.toJavaObject(Inventory.class);    
//		System.out.println(tranInventory.toString());
		
//		ObjectMapper mapper2 = new ObjectMapper();
//		Inventory user[] = mapper2.readValue(json, Inventory[].class);
//		System.out.println(user[0].getItem());
	}

}
