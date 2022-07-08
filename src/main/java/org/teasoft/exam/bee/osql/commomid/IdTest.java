/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.osql.commomid;

import org.teasoft.exam.bee.osql.SuidRichExam;

/**
 * @author Kingstar
 * @since  1.17
 */
public class IdTest {
	
	public static void main(String[] args) {
		IntSerialIdTest.test();
		StringIdTest.test();
		StringIdUUIDTest.test();
		SuidRichExam.test();
	}

}
