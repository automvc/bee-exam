package org.teasoft.exam.sharding;

import org.junit.After;
import org.junit.Before;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.sharding.InitSameDsUtil;
import org.teasoft.exam.bee.osql.sharding.ShardingInitData;
import org.teasoft.exam.bee.osql.special.ddl.DdlForShardingTest;
import org.teasoft.exam.bee.osql.special.ddl.DdlForShardingTest2;
import org.teasoft.exam.comm.ClearDsUtil;

public abstract class BaseShardingMoreTest {
	
	static {
		System.out.println("---------BaseShardingMoreTest----------");
		StartSharding.reMark();
	}
	
	@Before
	public void setUp() {
		ShardingInitData.init(); // 分片
		InitSameDsUtil.initDS();
		
	}

	@After
	public void after() throws Exception {
		ClearDsUtil.clearConfig();
		
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		
		System.out.println("---------BaseShardingMoreTest-----after-----");
	}

}
