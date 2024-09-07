package org.teasoft.exam.bee.osql.moretable.modify.sharding;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.moretable.modify.Book2;
import org.teasoft.exam.bee.osql.moretable.modify.BookDetail;
import org.teasoft.exam.bee.osql.moretable.modify.BookReal;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
//1:1:1 子表里又有子表
public class MoreInsert40_5 {
	
		
		public static void main(String[] args) throws Exception{
			
			ShardingInitData.init(); // 分片
			InitSameDsUtil.initDS();
			
			test();
		}
		
		public static void test() throws Exception{
		
		//		SuidRich suidRich=BF.getSuidRich();
		
		//单表插入，解析到List类型时，要提示。
			
		boolean b=	HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
		System.out.println(b);
		
		Book2 entity=new Book2();
//		entity.setId(2L);  //没有设置值,使用框架自动生成的值. 并会设置到外键中.  需要用:@FK("bookId")
		entity.setIsbn("isbn123456");
		entity.setName("Java开发");
		
		BookDetail bookDetail=new BookDetail();
//		bookDetail.setBookId(returnId);
		bookDetail.setCodeId("2001");
		bookDetail.setRemark("第一本");
//		suidRich.insert(bookDetail);
		
		BookDetail bookDetail2=new BookDetail();
		bookDetail2.setCodeId("2002");
		bookDetail2.setRemark("第2本");
		
		BookReal bookReal=new BookReal();
		bookReal.setRemark("测试OneHasOne");
		bookDetail.setBookReal(bookReal);
		
//		entity.setBookDetail(bookDetail);
		
	
//		MoreTableInsert aaa=new MoreTableInsert();
		
		MoreTable moreTable=BF.getMoreTable();
		int num=moreTable.insert(entity);	
		Logger.info("MoreTable insert(1:1:1 子表里又有子表), num(main table):"+num); //只是主表受影响的行数	
		
//		List<BookDetail> list2=book.getBookDetailList();
//		if(list2!=null && list2.size()>0) {
//			for (int i = 0; i < list2.size(); i++) {
//				list2.get(i).setBookId(returnId);  //要改为反射 找到外表和外键。   防止循环依赖的问题；
////				要判断，主表的关联字段是否是主键；不是的话，直接获取关联字段的值设置；
////				要多设置一个属性，当从表的关联字段有值时，是否覆盖。
//			}
//			
//			suidRich.insert(list2);  
////			子实体还是调用MoreTable接口的方法,因为可能子表还有子表;
////			是否要控制,只有三个表可关联?
//			
//			//是否需要事务？？     
//		}
		
		

////通过反射，可以获取到list2对象对应的泛型类型。可以使用以下代码来获取泛型类型：
//
//ParameterizedType genericType = (ParameterizedType) entity.getClass().getMethod("getBookDetailList").getGenericReturnType();
//Class<?> genericClass = (Class<?>) genericType.getActualTypeArguments()[0];
//System.err.println(genericClass.getName());
//
////这段代码假设book对象的类型为Book，getBookDetailList()方法返回值的类型为List<BookDetail>。通过调用getGenericReturnType()方法获取方法返回值的泛型类型，
////然后通过getActualTypeArguments()方法获取泛型类型的实际类型参数。在这个例子中，genericClass变量将保存BookDetail类的Class对象。
//		
////		suidRich.insert(bookDetail);
	}

}
