/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.prod.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.teasoft.bee.osql.SuidType;
import org.teasoft.bee.osql.annotation.AnnotationHandler;

/**
 * 在插入记录时,自动填充CreateBy标识的字段.
 * @author Kingstar
 * @since  1.11
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CreateBy {
	boolean override() default false;
	SuidType suidType();
//	@SuppressWarnings("rawtypes")
//	Class handler() default AnnotationHandler.class; 
	Class<? extends AnnotationHandler> handler(); 
}
