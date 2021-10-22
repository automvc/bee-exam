/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.thread;

import org.teasoft.bee.osql.Suid;
import org.teasoft.exam.bee.osql.entity.TestUser;
import org.teasoft.honey.osql.core.BeeFactory;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class Test2 {
	
	public static void main(String[] args) {
		
		DiffEntityThreadTest2 array[]=new DiffEntityThreadTest2[8];
		for (int i = 0; i < array.length; i++) {
			array[i]=new DiffEntityThreadTest2();
			array[i].start();
		}
		
		try {
//			Thread.sleep(5000);
			Thread.sleep(5000);  //测试超时删除      缓存未达到满的比例,超时也不会删
		} catch (Exception e) {

		}
		
		//测试有更新,   删除缓存,是否正确    可以正确删除
		Suid suid = BeeFactory.getHoneyFactory().getSuid();
//		TestUser testUser=new TestUser();
//		testUser.setId(100862L);
//		suid.insert(testUser);
		
//		       2021-10-20 17:34:15 [INFO] [Bee] [Bee] ==========get from Cache.
//				------------------->>>>>>>>>>>map.size():  1
//				------------------+++++++++->>>>>>>>>>> keymap :  {select id,email,last_name,name,password,username,createtime from test_user (@separator#) [returnType]: List<T>=9}
//				------------------+++++++++->>>>>>>>>>> map_tableIndexSet :  {test_user=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]}
//				2021-10-20 17:34:15 [INFO] [Bee]  | <--  select rows: 113
//				------------------+++++++++->>>>>>>>>>> map_tableNameList :  {select id,email,last_name,name,password,username,createtime from test_user (@separator#) [returnType]: List<T>=[test_user, test_user, test_user, test_user, test_user, test_user, test_user, test_user, test_user, test_user]}
//				------------------+++++++++->>>>>>>>>>> sql :  select id,email,last_name,name,password,username,createtime from test_user
//				------------------+++++++++->>>>>>>>>>> key :  select id,email,last_name,name,password,username,createtime from test_user (@separator#) [returnType]: List<T>
//				------------------+++++++++->>>>>>>>>>> index :  9
//				2021-10-20 17:34:15 [INFO] [Bee] [Bee] ==========get from Cache.
//				2021-10-20 17:34:15 [INFO] [Bee]  | <--  select rows: 113
//				2021-10-20 17:34:19 [INFO] [Bee] insert SQL: insert into test_user(id) values (?)   [values]: 100862
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 0
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 1
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 2
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 3
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 4
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 5
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 6
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 7
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 8
//				>>>>>>>>>>>>>>>>>>>>>>>---------------Thread ID:1,   index: 9
//		2021-10-20 17:34:19 [INFO] [Bee]  | <--  Affected rows: 1
//		2021-10-20 17:34:19 [INFO] [Bee] select SQL: select id,email,last_name,name,password,username,createtime from test_user
//		------------------->>>>>>>>>>>map.size():  0
//		------------------+++++++++->>>>>>>>>>> keymap :  {}
//		------------------+++++++++->>>>>>>>>>> map_tableIndexSet :  {}
//		------------------+++++++++->>>>>>>>>>> map_tableNameList :  {}
//		------------------+++++++++->>>>>>>>>>> sql :  select id,email,last_name,name,password,username,createtime from test_user
//		------------------+++++++++->>>>>>>>>>> key :  select id,email,last_name,name,password,username,createtime from test_user (@separator#) [returnType]: List<T>
//		------------------+++++++++->>>>>>>>>>> index :  null
//		{select id,email,last_name,name,password,username,createtime from test_user (@separator#) [returnType]: List<T>=[test_user]}
//		[test_user]
		
		TestUser testUser=new TestUser();
		testUser.setId(100862L);
		suid.select(testUser);
		suid.select(new TestUser());
		suid.select(new TestUser());
		
//		TestUser testUser2=new TestUser();
//		testUser2.setId(100863L);
//		suid.insert(testUser2);
//		suid.select(new TestUser());
		
	}

}
