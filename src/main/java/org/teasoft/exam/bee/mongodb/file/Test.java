/*
 * Copyright 2016-2023 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.mongodb.file;

import java.lang.annotation.Annotation;

import org.teasoft.bee.osql.annotation.GridFsMetadata;

/**
 * @author Kingstar
 * @since  2.1.8
 */
public class Test {
	
	public static void main(String[] args) {
		HistoryFile3 t=new HistoryFile3();
		
		Annotation a=t.getClass().getAnnotation(GridFsMetadata.class);
		
		Annotation a2=t.getMetadata().getClass().getAnnotation(GridFsMetadata.class);
		
		System.out.println(a2);
		System.out.println(a);
		
	}

}
