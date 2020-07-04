/*
 * Copyright 2016-2019 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.Condition;
import org.teasoft.bee.osql.Op;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.exam.bee.osql.entity.LeafAlloc;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.ConditionImpl;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.6
 */
public class UpdateSetExam {
	
	public static void main(String[] args) {
		test();
	}
	public static void test() {
       try{
		SuidRich suidRich = BeeFactory.getHoneyFactory().getSuidRich();
		LeafAlloc entity=null;
		
//		UPDATE leaf_alloc SET max_id = max_id + step WHERE biz_tag = #{tag} 
		
		entity=new LeafAlloc();
		entity.setBizTag("bee");
		
		Condition conditionSetAdd=new ConditionImpl();
		conditionSetAdd.setAdd("maxId", "step");
		int setAddNum=suidRich.updateBy(entity, "bizTag",conditionSetAdd);
		Logger.info("test setAdd , update num: "+setAddNum);
		
		
		
//		"update leaf_alloc set max_id= ?," +
//      " update_time=now(), version=version+1" +
//      " where id=? and max_id=? and version=? and biz_tag=?";
		
//		select id,biz_tag,max_id,step,description,update_time,version from leaf_alloc where biz_tag=?   [values]: test
//		update leaf_alloc set max_id=max_id+step,version=version+? where id=? and biz_tag=? and max_id=? and version=?   [values]: 1,456537470402562,test,4811,39
		
		entity=new LeafAlloc();
		entity.setBizTag("test");
		entity=suidRich.selectOne(entity);
		
		entity.setUpdateTime(null);//设置为null可以不处理
		entity.setDescription(null);
		entity.setStep(null);
		
		Condition condition=new ConditionImpl();
		condition.setAdd("maxId", "step");
		condition.setAdd("version", 1);  //当version为null时,不能加1(mysql)
		
		int setMultiplyNum=suidRich.update(entity, "version,maxId",condition);  //ok
//		int setMultiplyNum=suidRich.update(entity, "version,maxId,description",condition);  //test bug.  [values]: 顺序出错
//		int setMultiplyNum=suidRich.updateBy(entity, "id,maxId,version,bizTag",condition);  //没指定到where的条件,又会放到set中,不合要求.  需要注意.
		Logger.info("test setMultiply , update num: "+setMultiplyNum);
		

		
/*		Orders orders=null;
		
		Condition conditionSetAdd1=new ConditionImpl();
		conditionSetAdd1.setAdd("total", "total");
		orders=new Orders();
		orders.setId(100001L);
		int setAddNum1=suidRich.updateBy(orders, "id",conditionSetAdd1);
		Logger.info("test setAdd , update num: "+setAddNum1);
		
		
		Condition conditionSetMultiply1=new ConditionImpl();
		conditionSetMultiply1.setMultiply("total", "total");
		orders=new Orders();
		orders.setId(100002L);
		int setMultiplyNum1=suidRich.updateBy(orders, "id",conditionSetMultiply1);
		Logger.info("test setMultiply , update num: "+setMultiplyNum1);*/
		
		
		} catch (BeeException e) {
			Logger.error("In ConditionExam (BeeException):"+e.getMessage());
			e.printStackTrace();
		}catch (Exception e) {
			Logger.error("In ConditionExam (Exception):"+e.getMessage());
			e.printStackTrace();
		}
	}
}
