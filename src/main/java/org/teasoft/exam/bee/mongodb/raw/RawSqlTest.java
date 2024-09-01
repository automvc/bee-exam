package org.teasoft.exam.bee.mongodb.raw;

import java.util.List;

import org.teasoft.bee.mongodb.MongodbRawSql;
import org.teasoft.exam.bee.mongodb.entity.Movies;
import org.teasoft.honey.osql.core.Logger;
import org.teasoft.honey.osql.core.MongodbRawSqlLib;
import org.teasoft.honey.util.Printer;

public class RawSqlTest {
	static int LEN=1+35; //加长了要改
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		
		
//		doSuid(CommandString.find0);
//		doSuid(CommandString.insertOne); //{"n": 1, "ok": 1.0}
//		doSuid(CommandString.insertMany); //{"n": 2, "ok": 1.0}
		
		
		
//		doSuid(CommandString.deleteOne); //{"n": 0, "ok": 1.0}
//		doSuid(CommandString.deleteOne_2);  //
//		doSuid(CommandString.deleteOne_3);  //{"n": 1, "ok": 1.0}
//		doSuid(CommandString.deleteOne_4);  //{"n": 1, "ok": 1.0}  多个符合也是删一个
//		doSuid(CommandString.deleteMany);   //{"n": 4, "ok": 1.0}
//		doSuid(CommandString.delete_Old);    //{"n": 2, "ok": 1.0}
		
//		doSuid(CommandString.deleteAll);  //{"n": 7, "ok": 1.0}
		
//		doSuid(CommandString.deleteAll21);  //{"n": 10, "ok": 1.0}
		
		
//		doSuid(CommandString.insertMany21); //{"n": 10, "ok": 1.0}
//		doSuid(CommandString.updateOne21);  //{"n": 1, "nModified": 1, "ok": 1.0}
//		doSuid(CommandString.updateMany21);  //{"n": 3, "nModified": 3, "ok": 1.0}
		//更新操作时，获取受影响的行，应取nModified。
		
//		String newStr=StringParser.removeComment(CommandString.updateOne22);
//		System.err.println(newStr);
		
		
		
//		update.n
//		The number of documents selected for update. 
//		update.nModified
//		The number of documents updated. If the update operation results in no change to the document,
//		such as setting the value of the field to its current value, 
//		nModified can be less than n.
		
//		doSuid(CommandString.replaceOne21);
		
//	插入时：	{"n": 1, "upserted": [{"index": 0, "_id": {"$oid": "63dcbd1d28f119217ddee8c5"}}], "nModified": 0, "ok": 1.0}
		//upserted不为null,取null; 否则取
//		还是用这个：取nModified，为null,才取n
//		doSuid(CommandString.save21); //更新时：{"n": 1, "nModified": 1, "ok": 1.0}
		
		

		MongodbRawSql  mongodbSql=new MongodbRawSqlLib();
		
		String findStr[] = new String[LEN];
		
		findStr[0] = CommandString.find0;
		findStr[1] = CommandString.find1;
		findStr[2] = CommandString.find2;
		findStr[3] = CommandString.find3;
		findStr[4] = CommandString.find4;
		findStr[5] = CommandString.find5;
		findStr[6] = CommandString.find6;
		findStr[7] = CommandString.find7;
		findStr[8] = CommandString.find8;
		findStr[9] = CommandString.find9;
		findStr[10] = CommandString.find10;
		findStr[11] = CommandString.find11;
		findStr[12] = CommandString.find12;
		findStr[13] = CommandString.find13;
		findStr[14] = CommandString.find14;
		findStr[15] = CommandString.find15;
		findStr[16] = CommandString.find16;
		findStr[17] = CommandString.find17;
		findStr[18] = CommandString.find18;
		findStr[19] = CommandString.find19;
		findStr[20] = CommandString.find20;
		findStr[21] = CommandString.find21;
		findStr[22] = CommandString.find22;
		findStr[23] = CommandString.find23;
		findStr[24] = CommandString.find24;
		findStr[25] = CommandString.find25;
		findStr[26] = CommandString.find26;
		findStr[27] = CommandString.find27;
		findStr[28] = CommandString.find28;
		findStr[29] = CommandString.find29;
		findStr[30] = CommandString.find30;
		findStr[31] = CommandString.find31;
		findStr[32] = CommandString.find32;
		findStr[33] = CommandString.find33;
		findStr[34] = CommandString.find34;
		findStr[35] = CommandString.find35;
		
		for (int i = 0; i < findStr.length; i++) {
			try {
//			String result=mongodbSql.selectJson(findStr[i]);
//			System.out.println(result);
			
//			List<Map<String, Object>> list=mongodbSql.selectMapList(findStr[i]);
//			Printer.printList(list);
			
			List<Movies> list2=mongodbSql.select(findStr[i],Movies.class);
			Printer.printList(list2);
			
			} catch (Exception e) {
				Logger.warn("i: "+i );
				Logger.warn(e.getMessage());
			}
		}
		
		
		String modifyStr[] = new String[1+27];
		modifyStr[0] = CommandString.insertMany21;
		modifyStr[1] = CommandString.insertOne;
		modifyStr[2] = CommandString.insertMany;
		
		modifyStr[3] = CommandString.updateOne;
		modifyStr[4] = CommandString.updateMany;
		modifyStr[5] = CommandString.updateOne21;
		modifyStr[6] = CommandString.updateMany21;
		modifyStr[7] = CommandString.replaceOne;
		modifyStr[8] = CommandString.replaceOne21;
		modifyStr[9] = CommandString.save21;
		modifyStr[10] = CommandString.updateOne22;
		modifyStr[11] = CommandString.updateMany;
		modifyStr[12] = CommandString.replaceOne;
		
		modifyStr[13] = CommandString.deleteOne_2;
		modifyStr[14] = CommandString.deleteOne_3;
		modifyStr[15] = CommandString.deleteOne_4;
		modifyStr[16] = CommandString.remove;
		modifyStr[17] = CommandString.deleteAll_Old;
		modifyStr[18] = CommandString.deleteAll21;
		modifyStr[19] = CommandString.deleteMany;
		modifyStr[20] = CommandString.deleteOne;
		modifyStr[21] = CommandString.deleteAll;
		
		modifyStr[22] = CommandString.insertMany21; //insert again
		modifyStr[23] = CommandString.updateOne12;
		modifyStr[24] = CommandString.updateMany11;
		modifyStr[25] = CommandString.updateMany12;
		modifyStr[26] = CommandString.updateMany13;
		modifyStr[27] = CommandString.updateOne11;
		
		
		for (int i = 0; i < modifyStr.length; i++) {
			try {
				int r=mongodbSql.modify(modifyStr[i]);
//				System.out.println(r);	
				Logger.warn(r);
			} catch (Exception e) {
				Logger.warn("i: "+i );
				Logger.warn(e.getMessage());
			}
		
		}
	
	
	
	
	mongodbSql.modify(CommandString.insertMany);
	mongodbSql.modify(CommandString.insertMany21);
	
	String result0=mongodbSql.selectJson(CommandString.find0);
	Logger.info(result0);
	String result1=mongodbSql.selectJson(CommandString.find27);
	Logger.info(result1);
	int r0=mongodbSql.modify(CommandString.updateMany);
	Logger.info(r0);
	int r1=mongodbSql.modify(CommandString.updateOne22);
	Logger.info(r1);
	try {
	  int r2=mongodbSql.modify(CommandString.updateOne23); //set部分为空
	  Logger.info(r2);
	} catch (Exception e) {
		Logger.warn(e.getMessage());
	}
	
  }
}
