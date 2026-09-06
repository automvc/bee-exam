package org.teasoft.exam.moretable3;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.MoreTableExam;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam2;
import org.teasoft.exam.bee.osql.sharding.moretable.MoreTableExam3;
//import org.teasoft.exam.bee.osql.tran.Gen;
import org.teasoft.exam.moretable26.moretable3.MoreTableExam4_condition;
import org.teasoft.exam.moretable26.moretable3.MoreTableSelect;
import org.teasoft.exam.moretable26.moretable3.MoreTableSelect_filter;
import org.teasoft.exam.moretable26.moretable3.MoreTableSelect_filter2;
import org.teasoft.exam.moretable26.moretable3.SimpleSelect;
//import org.teasoft.exam.moretable26.moretable3.entity.Orders2026;
import org.teasoft.exam.moretable26.moretable3.selectlist.MoreTableSelect_list_filter;
import org.teasoft.exam.moretable26.moretable3.selectlist.MoreTableSelect_list_filter2;
import org.teasoft.exam.moretable26.moretable3.selectlist.MoreTableSelect_list_filter3;
import org.teasoft.exam.moretable26.moretable3.selectlist.layer3.MoreTableSelect_list;
import org.teasoft.exam.moretable26.moretable3.selectlist.layer3.MoreTableSelect_list_filter1_layer3;
import org.teasoft.exam.moretable26.moretable3.selectlist.layer3.MoreTableSelect_list_filter2_layer3;
import org.teasoft.exam.moretable3.moretable3select.MoreTableSelect_list_filter3_0;

public class Moretable3Test {
	
	static {
		System.out.println("---------Moretable3Test start----------");
		StartMoreTable3.reMark();
	}
	
	@Test
	public void test() {
		boolean result = false;
		try {
			System.out.println("---Bee Moretable3Test with junit start:------");
			
//			Gen.test();
			MoreTableExam.test();
			MoreTableExam2.test();
			MoreTableExam3.test();
			MoreTableExam4_condition.test();
			MoreTableSelect.test();
			MoreTableSelect_filter.test();
			MoreTableSelect_filter2.test();
			SimpleSelect.test();
			MoreTableSelect.test();
			MoreTableSelect_filter2.test();
			MoreTableSelect_list.test();
			MoreTableSelect_list_filter.test();
			MoreTableSelect_list_filter2.test();
			MoreTableSelect_list_filter3.test();
			MoreTableSelect_list.test();
			MoreTableSelect_list_filter1_layer3.test();
			MoreTableSelect_list_filter2_layer3.test();
			MoreTableSelect_list_filter3_0.test();
			
			MoreTableSelect_list_filter3.test();
			result = true;
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			System.out.println("---Bee Moretable3Test with junit end.------");
			MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
			
			Assert.assertEquals(result, true);
		}
	}
}
