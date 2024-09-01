package org.teasoft.exam.bee.mongodb.raw;

import org.teasoft.bee.mongodb.MongodbRawSql;
import org.teasoft.honey.osql.core.MongodbRawSqlLib;

public class RawSqlErrorTest {
	static int LEN = 1 + 35; // 加长了要改

	public static void main(String[] args) {
		test();
	}

	public static void test() {

		MongodbRawSql  mongodbSql=new MongodbRawSqlLib();

//		mongodbSql.modify(CommandString.insertMany);
//		mongodbSql.modify(CommandString.insertMany21);
//		String result01 = mongodbSql.selectJson(CommandString.find0);
//		String result02 = mongodbSql.selectJson(CommandString.find27);
//		int r03 = mongodbSql.modify(CommandString.updateMany);
//		int r04 = mongodbSql.modify(CommandString.updateOne22);
		
		int r05 = mongodbSql.modify(CommandString.updateOne23); // set部分为空

	}
}
