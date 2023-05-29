/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.mvc;

import java.util.List;

import org.junit.Test;
import org.teasoft.bee.mvc.Result;
import org.teasoft.bee.osql.api.SuidRich;
import org.teasoft.beex.json.JsonUtil;
import org.teasoft.exam.MySqlOneConfig;
import org.teasoft.exam.bee.osql.entity.Orders;
import org.teasoft.honey.osql.shortcut.BF;

/**
 * 模拟SpringMVC返回Rest Json结果
 * @author Kingstar
 * @since  2.1
 */
public class MvcResultTest {
	
	@Test
	public void test() {
		MySqlOneConfig.reset(); //预防测试无序,跳到其它类
		SuidRich suidRich=BF.getSuidRich();
		Orders orders=new Orders();
		int count=suidRich.count(orders); //下次再查总条数,可以用上缓存
		List<Orders> list=suidRich.select(orders);
	    
		Result result=new Result();
		result.setRows(list);
		result.setTotal(count);
		result.setCode("1001");
		result.setMsg("SUCCESS");
		
		String json=JsonUtil.toJson(result);
        System.out.println(json);
        
        
        result=new Result("Some error msg");
        
        result=new Result();
        result.setErrorMsg("Some error msg2");
        
	}

}
