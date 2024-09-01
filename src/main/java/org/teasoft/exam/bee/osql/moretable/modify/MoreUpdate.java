package org.teasoft.exam.bee.osql.moretable.modify;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreUpdate {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		
		Book2 entity=new Book2();
		entity.setIsbn("isbn123456");
		entity.setName("Java开发");
		entity.setId(868503003332609L);  //插入时, 返回的id,可以自动填入外键; 但delete和modify时,则不行.
		
		BookDetail bookDetail=new BookDetail();
		bookDetail.setId(880477460234241L); //业务上,是否可以设置?
		bookDetail.setCodeId("2001");
		bookDetail.setRemark("第一本");
		bookDetail.setBookId(868878901051398L); //没用, 外键会使用关联主表的对应键的值
	
		
//	          update,delete:主表,设置所有的外键对应字段时,从表会自动关联更新;
		//主表没有设置所有的外键对应字段时,若从表设置了所有的外键值，从表也会自动关联更新;否则不更新
		
		
//		BookDetail bookDetail2=new BookDetail();
//		bookDetail2.setCodeId("2002");
//		bookDetail2.setRemark("第2本");
		
		entity.setBookDetail(bookDetail);
		
	
		MoreTable moreTable=BF.getMoreTable();
		moreTable.update(entity);	

	}

}
