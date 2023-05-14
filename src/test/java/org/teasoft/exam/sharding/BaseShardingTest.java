package org.teasoft.exam.sharding;

import org.junit.After;
import org.junit.Before;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.bee.osql.special.ddl.DdlForShardingTest;
import org.teasoft.exam.bee.osql.special.ddl.DdlForShardingTest2;
import org.teasoft.exam.comm.ClearDsUtil;

public abstract class BaseShardingTest {
	
	static {
		System.out.println("---------Sharding Test----------");
		StartSharding.reMark();
	}
	
	@Before
	public void setUp() {
//		ClearDsUtil.clearConfig();
		InitSameDsUtil.initDS(); //有clearConfig
		ShardingInitData.init();
		
		DdlForShardingTest2.test();
		DdlForShardingTest.test();
	}

	@After
	public void after() throws Exception {
		ClearDsUtil.clearConfig();
		
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
	}

}
