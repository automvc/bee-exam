/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam;

import org.junit.Test;
import org.teasoft.honey.file.FileHandle;

/**
 * @author Kingstar
 * @since  1.11
 */
public class GenFileTest {
	
	@Test
	public void test() {
		FileHandle f=new FileHandle();
		f.genFile("D:\\\\temp\\", "test.txt", "just test");
		f.genFile("D:\\\\temp\\", "com.test","Test.java", "just test");
		System.err.println("gen file finished!");
	}

}
