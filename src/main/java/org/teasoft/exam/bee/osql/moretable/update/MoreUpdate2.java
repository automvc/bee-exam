package org.teasoft.exam.bee.osql.moretable.update;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.api.MoreTable;
import org.teasoft.honey.osql.shortcut.BF;

public class MoreUpdate2 {
	
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		
		Book2 entity=new Book2();
		entity.setIsbn("isbn123456");
		entity.setName("Java开发");
		entity.setId(880477456039937L);  //插入时, 返回的id,可以自动填入外键; 但delete和modify时,则不行.
		
		BookDetail bookDetail=new BookDetail();
		bookDetail.setId(880477460234241L); //业务上,是否可以设置?
		bookDetail.setCodeId("2001");
		bookDetail.setRemark("第一本");
//		bookDetail.setBookId(879396697145345L);   
		bookDetail.setBookId(880477456039937L); //外键设置有,但主键对应的字段没有设置有;则只删该条;
	
		
		BookDetail bookDetail2=new BookDetail();
		bookDetail2.setCodeId("2002");
		bookDetail2.setRemark("第2本");
		bookDetail2.setId(868467049758722L);
		
//		entity.setBookDetail(bookDetail);
		List<BookDetail> list=new ArrayList<>();
		list.add(bookDetail);
		list.add(bookDetail2);
		entity.setBookDetail(list);
		
	
		MoreTable moreTable=BF.getMoreTable();  //TODO 关联字段,在从表更新时,应该作为过滤条件.
		moreTable.update(entity);	

	}

}
