package org.teasoft.exam.bee.osql.tran;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.bee.osql.transaction.Transaction;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.SessionFactory;
import org.teasoft.honey.osql.shortcut.BF;
/**
 * 
 * 2.2之前,调用批量插入在每个批都会提交commit,但在2.2改为只调用一次且在事务中,在批量插入的方法内容不再提交,而由事务控制.  
 * 
 * 2.2之前,批量插入使用每一个批次提交一次事务;
 * 这样,当违反主键约束等就忽略的大批量插入效率是很高的;
 * 但当事务中有批量插入时,不了解内部执行规则可能会对业务的正确性造成影响.
 * 所在Bee在2.2时,默认是所有批次的插入操作只提交一次,如插入100条,每批20条,2.2之前是提交了五次commit,在2.2时改为一次commit;
 * 若想在大批量插入时忽略违反约束的失败操作,使用回2.2之前的模式,可以使用配置:bee.osql.eachBatchCommit=true
 * 
 * 在2.2之前,可以将insertBatchSize设置得足够大,将所有记录在一个批次完成,即不会造成多个批次;这样,在事务中,就不会因事务分多批造成事务不准确;
 * 但因2.2之前在批处理时,会调用conn.commit();提交了事务,所以用业务逻辑调用rollback()是无效的.
 * 2.2时,使用事务时,在批处理内部不会再调用conn.commit().
 * 
 *
 */
//捕获异常+批处理
public class TranTest1 {

	public static void main(String[] args) {
		
		
//		new GenBean().genSomeBeanFile("org");
		HoneyConfig.getHoneyConfig().notCatchModifyDuplicateException=false;

		Transaction transaction = SessionFactory.getTransaction();
		SuidRich suidRich = BF.getSuidRich();
		
		try {

			transaction.begin();
			
			Org org1=new Org();
			org1.setOrgName("aaa");
			
			
			Org org2=new Org();
			org2.setOrgName("bbb");
			
			
			Org org3=new Org();
			org3.setOrgName("aa0"); //重；检测前面两条是否能插入
			
			List<Org> list=new ArrayList<>();
			list.add(org1);
			list.add(org2);
			list.add(org3);
			
			int a=suidRich.insert(list, 2);  //V2.2之前, 分多批执行时，前面的批在内部会先提交
//			int a=suidRich.insert(list, 100); // V2.2之前,确保放在一批,可以避免这个问题，
			System.out.println("------------------: "+a);
			if(a!=list.size()) {
				System.out.println("业务触发事务回滚");
				transaction.rollback();
			}else {
			   transaction.commit();
			}
			//批量插入时，一批就会有一个commint;
			
			
//			int a1=suidRich.insert(org1);
//			System.out.println("a1:"+a1);
//			
//			int a2=suidRich.insert(org2);
//			System.out.println("a2:"+a2);
//			
//			int a3=suidRich.insert(org3); //异常的在中间，后面正常的一条，是能插入的
//			System.out.println("a3:"+a3);
//			
////			int a2=suidRich.insert(org2); //bbb   在捕获异常的情况下，上一句有异常， modify里，清了conn上下文，这句拿不了事务的conn
////			System.out.println("a2:"+a2);
//			
//			if((a1+a2+a3)!=list.size()) {
//			System.out.println("业务触发事务回滚");
//			transaction.rollback();
//		    }else {
//		    transaction.commit();
//		    }
			
			
		} catch (BeeException e) {
			Logger.error("In TransactionExam (BeeException):" + e.getMessage());
			transaction.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In TransactionExam (Exception):" + e.getMessage());
			transaction.rollback();
			e.printStackTrace();
		}

	}

}
