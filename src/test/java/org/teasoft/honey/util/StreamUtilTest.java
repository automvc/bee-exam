/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.teasoft.honey.logging.Logger;

import static org.teasoft.honey.util.StreamUtil.*;

/**
 * @author Kingstar
 * @since  1.9.8
 */
public class StreamUtilTest {

	@Test
	public void test() {
		try {
			InputStream in = new FileInputStream("D:\\temp\\user3.txt");
			System.out.println(stream2String(in));
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
		}
	}

}
