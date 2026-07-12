//package org.teasoft.exam.moretable3.moretable3select.test_cache_return_type;
//
//import org.teasoft.bee.osql.BeeException;
//import org.teasoft.bee.osql.api.MoreTable;
////import org.teasoft.exam.bee.osql.moretable3.selectlist.layer3.Province;
////import org.teasoft.exam.bee.osql.moretable3.select.layer3.Province;
//import org.teasoft.honey.logging.Logger;
//import org.teasoft.honey.osql.core.BeeFactory;
//
//public class MainTest {
//	
//	public static void main(String[] args) {
//		test();
//	}
//
//	public static void test() {
//		try {
//			MoreTable moreTable = BeeFactory.getHoneyFactory().getMoreTable();
//			
//			org.teasoft.exam.moretable3.moretable3.select.layer3.Province province = new org.teasoft.exam.moretable3.moretable3.select.layer3.Province();
//			moreTable.select(province, 0, 10); //select 查询前10条记录
//			
//			
//			org.teasoft.exam.moretable3.moretable3.selectlist.layer3.Province province2 = new org.teasoft.exam.moretable3.moretable3.selectlist.layer3.Province();
//			moreTable.select(province2, 0, 10); //select 查询前10条记录
//			
//		} catch (BeeException e) {
//			e.printStackTrace();
//			Logger.error("In MoreTableExam (BeeException):"+e.getMessage());
//		}catch (Exception e) {
//			Logger.error("In MoreTableExam (Exception):"+e.getMessage());
//			e.printStackTrace();
//		}
//	}
//}
