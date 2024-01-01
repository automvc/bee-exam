package org.teasoft.exam.bee.superclass.supertest;

import java.lang.reflect.Field;
import java.util.List;

import org.teasoft.bee.osql.api.Suid;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.HoneyUtil;
import org.teasoft.honey.osql.shortcut.BF;


public class UseSuperEntityTest {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		HoneyConfig.getHoneyConfig().openEntityCanExtend=true;
		System.out.println("----------------------------------");
		Suid suid=BF.getSuid();
		suid.select(new EntityClass());
		
//		String name=HoneyUtil.getField(EntityClass.class,"name").getName();
//		String remark=HoneyUtil.getField(BaseClass.class,"remark").getName();
//		String remark1=HoneyUtil.getField(BaseSuper.class,"remark1").getName();
////		String remark2=HoneyUtil.getField(BaseSuper.class,"remark2").getName();
//		System.out.println(name);
//		System.out.println(remark);
//		System.out.println(remark1);
		
		System.out.println("------------------------------");
		Field[] fs=HoneyUtil.getFields(EntityClass.class);
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
		
		EntityClass entityClass=new EntityClass();
		entityClass.setName("testSuper");
		entityClass.setRemark("entityClassRemark4");
		
		suid.select(entityClass);
//		entityClass.setId(1L);
		suid.insert(entityClass);
		List<EntityClass> list=suid.select(entityClass);
		for (int i = 0; i < list.size(); i++) {
			EntityClass t=list.get(i);
			System.out.println(t.getId()+" "+t.getName()+" "+t.getRemark()+" ");
//			System.out.println(t.getId()+" "+t.getName()+" "+t.getRemark()+" "+t.getRemark1());
			
		}
		
		HoneyConfig.getHoneyConfig().openEntityCanExtend=false;
	}

}
