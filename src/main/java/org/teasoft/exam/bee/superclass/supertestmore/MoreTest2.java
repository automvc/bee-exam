package org.teasoft.exam.bee.superclass.supertestmore;

import java.util.List;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreTest2 {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		HoneyConfig.getHoneyConfig().openEntityCanExtend=true;
		
		
		MoreTable more=BF.getMoreTable();
		List<EntityClass2> list=more.select(new EntityClass2());
		
		for (int i = 0; i < list.size(); i++) {
			EntityClass2 t=list.get(i);
			System.out.println(t.getId()+"  " +t.getName()+"  " + t.getRemark()+"  " );
		}
		
		
		EntityClass2 req=new EntityClass2();
		req.setName("name2-test1");
		list=more.select(req);
		
		for (int i = 0; i < list.size(); i++) {
			EntityClass2 t=list.get(i);
			System.out.println(t.getId()+"  " +t.getName()+"  " + t.getRemark()+"  " +t.getList().get(0).getSubject());
//			1  name2-test1  remark1-test1  java
		}
		
		HoneyConfig.getHoneyConfig().openEntityCanExtend=false;
	}

}
