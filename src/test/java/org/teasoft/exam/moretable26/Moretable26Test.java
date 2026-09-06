package org.teasoft.exam.moretable26;

import org.junit.Assert;
import org.junit.Test;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.moretable3.StartMoreTable3;
import org.teasoft.exam.moretable3.moretable3select.MoreTableSelect_list_filter3_0;
//import org.teasoft.exam.moretable3.moretable3select.test_cache_return_type.MainTest;
import org.teasoft.exam.moretable3.moretable3select2._11.MoreTableSelect_list_filter2_11;
import org.teasoft.exam.moretable3.moretable3select2._11_more2joinCondition.MoreTableSelect_list_filter2_11_more2joinCondition;
//import org.teasoft.exam.moretable3.moretable3select2._11_selectcolumn.MoreTableSelect_list_filter2_11;
import org.teasoft.exam.moretable3.moretable3select2_many2one.MoreTableSelect_list_filter2_many2one;
import org.teasoft.exam.moretable3.moretable3select4.MoreTableSelect_list_filter4_1nn1;
import org.teasoft.exam.moretable3.moretable3select5.MoreTableSelect_list_filter5_1nn11;
import org.teasoft.exam.moretable3.moretable3select5._11111.MoreTableSelect_list_filter5_11111;
import org.teasoft.exam.moretable3.moretable3select5._11111_insert.MoreTableSelect_list_filter5_11111_insert;
import org.teasoft.exam.moretable3.moretable3select5._11111_selectcolumn.MoreTableSelect_list_filter5_11111_selectcolumn;
import org.teasoft.exam.moretable3.moretable3select5._11111_update.MoreTableSelect_list_filter5_11111_update;
import org.teasoft.exam.moretable3.moretable3select5._11n11.MoreTableSelect_list_filter5_11n11;
import org.teasoft.exam.moretable3.moretable3select5._11n11_subvalue.MoreTableSelect_list_filter5_11n11_subvalue;
import org.teasoft.exam.moretable3.moretable3select5._1_11_111.MoreTableSelect_list_filter5_1_11_111;
import org.teasoft.exam.moretable3.moretable3select5._1_11n_1_n_1.MoreTableSelect_list_filter5_1_11n_1_n_1;
//import org.teasoft.exam.moretable3.moretable3select5._1_11_1_1_1_insert.MoreTableSelect_list_filter5_11111_insert;
import org.teasoft.exam.moretable3.moretable3select5._1_1n1_1_n_1.MoreTableSelect_list_filter5_1_1n1_1_n_1;
import org.teasoft.exam.moretable3.moretable3select5._1_1n_1_n_1.MoreTableSelect_list_filter5_1_1n_1n1;
import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1.MoreTableSelect_list_filter5_1_n11_1_n_1;
//import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1.MoreTableSelect_list_filter5_1_n11_1_n_1_ZL;
import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1_subvalueEmptyList.MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueEmptyList;
import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1_subvalueList.MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList;
//import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1_subvalueList_insert.MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList;
//import org.teasoft.exam.moretable3.moretable3select5._1_n11_1_n_1_subvalueList_rewritePaging.MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList;
import org.teasoft.exam.moretable3.moretable3select5._1_n1_1_n_1.MoreTableSelect_list_filter5_1_n1_1_n_1;
//import org.teasoft.exam.moretable3.moretable3select5._11n11_subvalue_selectCount.MoreTableSelect_list_filter5_11n11_subvalue;
//import org.teasoft.exam.moretable3.moretable3select5._11n11_subvalue_selectFun.MoreTableSelect_list_filter5_11n11_subvalue;
//import org.teasoft.exam.moretable3.moretable3select5._11n11_subvalue_selectJson.MoreTableSelect_list_filter5_11n11_subvalue;
//import org.teasoft.exam.moretable3.moretable3select5._11n11_subvalue_selectString.MoreTableSelect_list_filter5_11n11_subvalue;
import org.teasoft.exam.moretable3.moretable3select5._1n.MoreTableSelect_list_filter5_1n;
import org.teasoft.exam.moretable3.moretable3select5._1n1_paging3.MoreTableSelect_list_filter5_1n1_paging3;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1.MoreTableSelect_list_filter5_1n1n1;
//import org.teasoft.exam.moretable3.moretable3select5._1n1n1_column.MoreTableSelect_list_filter5_1n1n1;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_column_condition.MoreTableSelect_list_filter5_1n1n1_column_condition;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_column_condition2.MoreTableSelect_list_filter5_1n1n1_column_condition2;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_column_condition3.MoreTableSelect_list_filter5_1n1n1_column_condition3;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_count.MoreTableSelect_list_filter5_1n1n1_count;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_count_sum.MoreTableSelect_list_filter5_1n1n1_count_sum;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_count_sum2.MoreTableSelect_list_filter5_1n1n1_count_sum2;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_count_sum3.MoreTableSelect_list_filter5_1n1n1_count_sum3;
import org.teasoft.exam.moretable3.moretable3select5._1n1n1_selectcolumn.MoreTableSelect_list_filter5_1n1n1_selectcolumn;
import org.teasoft.exam.moretable3.moretable3select5._1n_page.MoreTableSelect_list_filter5_1n_page;
import org.teasoft.exam.moretable3.moretable3select5._1n_paging2.MoreTableSelect_list_filter5_1n_paging2;
//import org.teasoft.exam.moretable3.moretable3select5._1nn11.MoreTableSelect_list_filter5_1nn11;
import org.teasoft.exam.moretable3.moretable3select5._1nnn1.MoreTableSelect_list_filter5_1nnn1;
import org.teasoft.exam.moretable3.moretable3select5._1nnnn.MoreTableSelect_list_filter5_1nnnn;
import org.teasoft.exam.moretable3.moretable3select5.whereJoin.MoreTableSelect_list_filter5_wherejoin;
//import org.teasoft.exam.moretable3.simple.Gen;
//import org.teasoft.exam.moretable3.simple.MoveDataFromW2R;
import org.teasoft.exam.moretable3.simple.SimpleSelect;

public class Moretable26Test {
	
	static {
		System.out.println("---------Moretable26Test start----------");
		StartMoreTable26.reMark();
	}

	@Test
	public void test() {
		boolean result=false;
		try {
			System.out.println("---Bee Moretable26Test with junit start:------");
			
//			MoreTableExam.test();
			
			MoreTableSelect_list_filter3_0.test();
//			MainTest.test();
			MoreTableSelect_list_filter2_11.test();
			MoreTableSelect_list_filter2_11_more2joinCondition.test();
			MoreTableSelect_list_filter2_11.test();
			MoreTableSelect_list_filter2_many2one.test();
			MoreTableSelect_list_filter4_1nn1.test();
			MoreTableSelect_list_filter5_1nn11.test();
			MoreTableSelect_list_filter5_wherejoin.test();
			MoreTableSelect_list_filter5_11111.test();
			MoreTableSelect_list_filter5_11111_insert.test();
			MoreTableSelect_list_filter5_11111_selectcolumn.test();
			MoreTableSelect_list_filter5_11111_update.test();
			MoreTableSelect_list_filter5_11n11.test();
			MoreTableSelect_list_filter5_11n11_subvalue.test();
			MoreTableSelect_list_filter5_11n11_subvalue.test();
			MoreTableSelect_list_filter5_11n11_subvalue.test();
			MoreTableSelect_list_filter5_11n11_subvalue.test();
			MoreTableSelect_list_filter5_11n11_subvalue.test();
			MoreTableSelect_list_filter5_1n.test();
			MoreTableSelect_list_filter5_1n1n1.test();
			MoreTableSelect_list_filter5_1n1n1.test();
			MoreTableSelect_list_filter5_1n1n1_column_condition.test();
			MoreTableSelect_list_filter5_1n1n1_column_condition2.test();
			MoreTableSelect_list_filter5_1n1n1_column_condition3.test();
			MoreTableSelect_list_filter5_1n1n1_count.test();
			MoreTableSelect_list_filter5_1n1n1_count_sum.test(); // fixed bug 3.0.0.8
			MoreTableSelect_list_filter5_1n1n1_count_sum2.test();
			MoreTableSelect_list_filter5_1n1n1_count_sum3.test();
			MoreTableSelect_list_filter5_1n1n1_selectcolumn.test();
			MoreTableSelect_list_filter5_1n1_paging3.test();
			MoreTableSelect_list_filter5_1nn11.test();
			MoreTableSelect_list_filter5_1nnn1.test();
			MoreTableSelect_list_filter5_1nnnn.test();
			MoreTableSelect_list_filter5_1n_page.test();
			MoreTableSelect_list_filter5_1n_paging2.test();
			MoreTableSelect_list_filter5_1_11n_1_n_1.test();
			MoreTableSelect_list_filter5_1_11_111.test();
			MoreTableSelect_list_filter5_11111_insert.test();
			MoreTableSelect_list_filter5_1_1n1_1_n_1.test();
			MoreTableSelect_list_filter5_1_1n_1n1.test();
			MoreTableSelect_list_filter5_1_n11_1_n_1.test();
//			MoreTableSelect_list_filter5_1_n11_1_n_1_ZL.test();
			MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueEmptyList.test();
			MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList.test();
			MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList.test();
			MoreTableSelect_list_filter5_1_n11_1_n_1_subvalueList.test();
			MoreTableSelect_list_filter5_1_n1_1_n_1.test();
//			Gen.test();
//			MoveDataFromW2R.test();
			SimpleSelect.test();
//			TestUser.test();
			result=true;
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
			
		} finally {
			System.out.println("---Bee Moretable26Test with junit end.------");
			MySqlOneConfig.reset(); // 预防测试无序,跳到其它类
			
			Assert.assertEquals(result, true);
		}
	}

}
