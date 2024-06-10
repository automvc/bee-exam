package org.teasoft.exam.bee.osql.moretable.insert;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 多表更新,不设置从表的主键时,使用关联字段的值来过滤要更新的记录
 * @author Kingstar
 * @since  2.4.0
 */
public class MoreUpdate2 {
	
	public static void main(String[] args) throws Exception{
		
		
		Book2 entity=new Book2();
		entity.setIsbn("isbn123456");
		entity.setName("Java开发");
//		entity.setId(868503003332609L);  //插入时, 返回的id,可以自动填入外键; 但delete和modify时,则不行.
		
		BookDetail bookDetail=new BookDetail();
//		bookDetail.setId(880477460234241L); //不设置从表的主键时,使用关联字段的值来过滤要更新的记录  V2.2bug.  V2.4.0已更新
		bookDetail.setCodeId("2001");
		bookDetail.setRemark("第一本");
//		bookDetail.setBookId(868878901051398L); 
	
		
//	          update,delete:主表,设置所有的外键对应字段时,从表会自动关联更新;
		//主表没有设置所有的外键对应字段时,若从表设置了所有的外键值，从表也会自动关联更新;否则不更新
		
		
//		BookDetail bookDetail2=new BookDetail();
//		bookDetail2.setCodeId("2002");
//		bookDetail2.setRemark("第2本");
		
		entity.setBookDetail(bookDetail);
		
	
		MoreTable moreTable=BF.getMoreTable();
		int updateNum=moreTable.update(entity);	
		Logger.info("MoreTable update,updateNum:"+updateNum);
		
		int delNum=moreTable.delete(entity);
		Logger.info("MoreTable delete,delNum:"+delNum);
		
		//主表没设置id??  至少要设置关联属性,否则没法更新.
	}

}
