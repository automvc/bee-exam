/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.bee.osql.BeeException;
import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;
import org.teasoft.honey.osql.core.HoneyConfig;

/**
 * @author Kingstar
 * @since  1.17
 */
public class GenBeanSimple2 {
	public static void main(String[] args) {
		 try{
			
			
			//it is easy way.   最简单的用法,所有的都用默认配置.
			new GenBean().genSomeBeanFile("orders");
//			new GenBean().genSomeBeanFile("places");
			 
//			 new GenBean().genAllBeanFile();
			
		  } catch (BeeException e) {
			 e.printStackTrace();
		  }
	}
}
