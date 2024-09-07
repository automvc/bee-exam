package org.teasoft.exam.bee.osql.moretable.modify.sharding;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.moretable.modify.Book2;
import org.teasoft.exam.bee.osql.moretable.modify.BookDetail;
import org.teasoft.exam.bee.osql.moretable.modify.BookReal;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;
//1:1:1 子表里又有子表
public class MoreInsert40_6 {
	
		
		public static void main(String[] args) throws Exception{
			
			ShardingInitData.init(); // 分片
			InitSameDsUtil.initDS();
			
			test();
		}
		
		public static void test() throws Exception{
		
		
		//单表插入，解析到List类型时，要提示。
			
//		boolean b=	HoneyConfig.getHoneyConfig().genid_forAllTableLongId;
//		System.out.println(b);
		
		Book2 entity=new Book2();
//		Book entity=new Book();
		entity.setId(1L); //使用用户填写的值,并会设置到外键中.
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
		
//		entity.setBookDetail(bookDetail);  //List类型的子表,没有时,不需要插入.
		
	
//		MoreTableInsert aaa=new MoreTableInsert();
		
		MoreTable moreTable=BF.getMoreTable();
		int num=moreTable.insert(entity);	
		Logger.info("MoreTable insert(1:1:1 子表里又有子表), num(main table):"+num); //只是主表受影响的行数	
		
		
//		List<Book> list=moreTable.select(entity);	
		
		
//		List<Book> list=BF.getSuid().select(entity);	
//		Printer.printList(list);
		
//		int updateNum=moreTable.update(entity);	
//		Logger.info(updateNum);
		
//		int delNum=moreTable.delete(entity);	
//		Logger.info(delNum);
	}

}
