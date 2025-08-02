package org.teasoft.exam.mongodb;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.bee.mongodb.*;
import org.teasoft.honey.logging.Logger;

public class MongoTest extends BaseMongoTest {
	
	@Test
	public void test(){
		
		System.out.println("---Bee MongoTest with junit start:------");
		
		boolean result=false;
		try {
			Test4_insert.test();
			Test4_insertList.test();
			Test4_insertOrders3.test();
			Delete.test();
			SelectAll.test();
			SelectAll2.test();
			SelectAll3.test();
			SelectDate.test();
			SelectDate2.test();
			SelectGroupBy.test();
			SelectGroupBy2.test();
			SelectGroupBy2_twoField.test();
			SelectGroupBy2_twoField2.test();
			SelectGroupBy3.test();
			SelectGroupBy3_Response.test();
			SelectOrderBy.test();
			SelectWithFun.test();
			SelectWithFun2.test();
			Select_CollectionNotExist.test();
			ShardingPaging2_deleteCache.test();
			ShardingPaging2_deleteCache_insert.test();
			ShardingPaging2_deleteCache_update.test();
			Test0.test();
			Test2.test();
			Test2_Between.test();
			Test2_Between0.test();
			Test2_Between2.test();
			Test2_Between3.test();
			Test2_Condition.test();
			Test2_Condition_isNull.test();
			Test2_TestObject.test();
			Test3_ById.test();
			Test3_ById2.test();
			Test3_selectField.test();
			Test3_selectJson.test();
			Test3_selectString.test();
			Test3_selectString2.test();
			Test4_count.test();
			Test_date.test();
			Update.test();
			Update2.test();
			Update3.test();
			Update4.test();
			Update5_Add.test();
			Update5_Add_Multi.test();
			Update5_setNull.test();

			Update_NewOld.test();
			Update_upper.test();
			Update_upper2.test();
			
			Update_All.test();
			
			GenBeanTest.test();
			
			result=true;
			} catch (Exception e) {
				e.printStackTrace();
				Logger.error(e.getMessage(), e);
				result=false;
			}finally {
				Assert.assertEquals(result,true);
			}
			
			System.out.println("---Bee MongoTest with junit end.------");
		}

}
