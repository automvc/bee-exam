package org.teasoft.exam.bee.osql.tran;

import java.util.ArrayList;
import java.util.List;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.honey.logging.Logger;
import org.teasoft.honey.osql.core.HoneyConfig;
import org.teasoft.honey.osql.shortcut.BF;

//捕获异常+批处理+无事务
public class TranTestNo1 {

	public static void main(String[] args) {
		
		
//		new GenBean().genSomeBeanFile("org");
		HoneyConfig.getHoneyConfig().notCatchModifyDuplicateException=false;

//		Transaction transaction = SessionFactory.getTransaction();
		SuidRich suidRich = BF.getSuidRich();
		
		try {

//			transaction.begin();
			
			Org org1=new Org();
			org1.setOrgName("aaa");
			
			
			Org org2=new Org();
			org2.setOrgName("bbb");
			
			
			Org org3=new Org();
			org3.setOrgName("aa0"); //重；检测前面两条是否能插入
			
			List<Org> list=new ArrayList<>();
			list.add(org1);
			list.add(org3);
			//[INFO] [Bee]  | <-- index[0~1] Affected rows: 0  , this batch have exception !
			list.add(org2);
			
//			list.add(org1);
//			list.add(org2);
//			list.add(org3);
			
			int a=suidRich.insert(list, 2);  //V2.2之前, 分多批执行时，前面的批在内部会先提交
//			int a=suidRich.insert(list, 100); // V2.2之前,确保放在一批,可以避免这个问题，
			System.out.println("------------------: "+a);
			if(a!=list.size()) {
				System.out.println("只有部分插入成功");
//				transaction.rollback();
			}else {
//			   transaction.commit();
			}
			//批量插入时，一批就会有一个commint;
			
			
		} catch (BeeException e) {
			Logger.error("In TransactionExam (BeeException):" + e.getMessage());
//			transaction.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			Logger.error("In TransactionExam (Exception):" + e.getMessage());
//			transaction.rollback();
			e.printStackTrace();
		}

	}

}
