/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.coverage;

import org.junit.Test;
import org.teasoft.bee.sharding.DsTabStruct;
import org.teasoft.bee.sharding.ShardingSimpleStruct;
import org.teasoft.bee.sharding.algorithm.CalculateRegistry;
import org.teasoft.honey.osql.core.BeeInitPreLoadService;
import org.teasoft.honey.osql.interccept.EmptyInterceptor;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * @author Kingstar
 * @since  1.17
 */
public class Other {
	
	@Test
	public void test() {
		BeeInitPreLoadService.init();
		
		new BF();
		
		EmptyInterceptor emptyInterceptor=new EmptyInterceptor();
		emptyInterceptor.beforeReturn();
		emptyInterceptor.afterCompleteSql("just test");
		emptyInterceptor.getOneTimeDataSource();
		emptyInterceptor.getOneTimeTabName();
		emptyInterceptor.getOneTimeTabSuffix();
		
		ShardingSimpleStruct s=new ShardingSimpleStruct();
		s.setDsAlgorithm(0);
		s.setDsName("ds1");
		s.setDsRule("id%2");
		s.setDsShardingValue("1");
		s.setTabShardingValue("1");
		s.setTabAlgorithm(0);
		s.setTabName("orders");
		s.setTabRule("id%2");
		
		s.getDsAlgorithm();
		s.getDsName();
		s.getDsRule();
		s.getDsShardingValue();
		s.getTabShardingValue();
		s.getTabAlgorithm();
		s.getTabName();
		s.getTabRule();
		
		DsTabStruct dsTab=new DsTabStruct();
		dsTab.setDsName("ds1");
		dsTab.setTabName("orders");
		dsTab.setTabSuffix("_1");
		dsTab.setTabSuffix("1");
		dsTab.getDsName();
		dsTab.getDsName();
		dsTab.getTabSuffix();
		
		CalculateRegistry.register(5, new TestCalculate());
		CalculateRegistry.getCalculate(5);
		
		new DictI18nDefaultHandlerTest();
		
	}

}
