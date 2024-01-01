package org.teasoft.exam.bee.superclass.supertestmore;

import java.util.List;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreTest {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		HoneyConfig.getHoneyConfig().openEntityCanExtend=true;
		MoreTable more=BF.getMoreTable();
		List<EntityClass> list=more.select(new EntityClass());
		
		for (int i = 0; i < list.size(); i++) {
			EntityClass t=list.get(i);
			System.out.println(t.getId()+"  " +t.getName()+"  " + t.getRemark()+"  " + t.getSchool().getSchoolName());
		}
		
		
		EntityClass req=new EntityClass();
		req.setName("name2-test1");
//		req.getSchool().setSchoolName("test");
		School school=new School();
		school.setSchoolName("test");
		req.setSchool(school);
		list=more.select(req);
		
		for (int i = 0; i < list.size(); i++) {
			EntityClass t=list.get(i);
			System.out.println(t.getId()+"  " +t.getName()+"  " + t.getRemark()+"  " + t.getSchool().getSchoolName());
		}
		
		HoneyConfig.getHoneyConfig().openEntityCanExtend=false;
	}

}
