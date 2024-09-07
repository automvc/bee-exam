package org.teasoft.exam.bee.osql.moretable.modify.sharding;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.exam.bee.osql.moretable.modify.Book2;
import org.teasoft.exam.bee.osql.moretable.modify.BookDetail;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreModify {
	
	public static void main(String[] args) throws Exception{
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		test();
	}
	
	public static void test() throws Exception{
		
		
		Book2 entity=new Book2();
		entity.setIsbn("isbn123456");
		entity.setName("Java开发");
//		entity.setId(879395556294657L);  //插入时, 返回的id,可以自动填入外键; 但delete和modify时,则不行.
		
		BookDetail bookDetail=new BookDetail();
		bookDetail.setCodeId("2001");
		bookDetail.setRemark("第一本");
//		bookDetail.setBookId(879396697145345L);   
		bookDetail.setBookId(880470782902273L); //外键设置有,但主键对应的字段没有设置有;则只删该条;
		//TODO 但标准SQL, 是删除了某条语句,则删除对应关联的;  这样的话,删除前,要先进行查询.
		
//	          update,delete:主表,设置所有的外键对应字段时,从表会自动关联更新;
		//主表没有设置所有的外键对应字段时,若从表设置了所有的外键值，从表也会自动关联更新;否则不更新
		
		
//		BookDetail bookDetail2=new BookDetail();
//		bookDetail2.setCodeId("2002");
//		bookDetail2.setRemark("第2本");
		
		entity.setBookDetail(bookDetail);
		
	
		MoreTable moreTable=BF.getMoreTable();
		moreTable.delete(entity);	

	}

}
