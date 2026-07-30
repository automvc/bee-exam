/*
 * Copyright 2022-2026 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.quickstart.genbean;

import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;

/**
 * Table -> Entity
 * generate java bean via DB table.
 * 
 * @author Kingstar
 * @since  3.0.0
 */
public class GenBeanExam {

	public static void main(String[] args) {
		GenConfig genConfig=new GenConfig();
		genConfig.setGenToString(true);
		genConfig.setOverride(true); //要是已存在,会覆盖
		
		GenBean genBean=new GenBean(genConfig);
//		genBean.genSomeBeanFile("city");
		
		genBean.genSomeBeanFile("province_history"); //会进行 命名转换
	}

}
