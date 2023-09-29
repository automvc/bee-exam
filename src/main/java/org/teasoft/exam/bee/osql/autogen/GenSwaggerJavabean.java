/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.autogen;

import org.teasoft.honey.osql.autogen.GenBean;
import org.teasoft.honey.osql.autogen.GenConfig;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class GenSwaggerJavabean {
	
	public static void main(String[] args) {
		GenConfig config = new GenConfig();
		
		config.setGenSerializable(false);
		config.setOverride(true);
		
		config.setGenSwagger(true);
//		config.setGenComment(true);
//		config.setCommentPlace(2);
		
//		config.setLombokGetter(true);
//		config.setLombokSetter(true);
		
		GenBean genBean = new GenBean(config);
		
//		genBean.genSomeBeanFile("numblue");
		genBean.genSomeBeanFile("numseq");
		genBean.genSomeBeanFile("numrecord");
	}

}
