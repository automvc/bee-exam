/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.exam.bee.test;

import java.util.TreeSet;

/**
 * @author Kingstar
 * @since  1.11
 */
public class SetTest {
	private static String LINE_SEPARATOR = System.getProperty("line.separator"); // 换行符
	
	public static void main(String[] args) {
		String importStr="";
		TreeSet<String> importSet=new TreeSet<>();
		importSet.add("import java.math.BigInteger;");
		importSet.add("import java.math.BigInteger22;");
		importSet.add("import java.math.BigInteger22;");
		importSet.add("import java.math.BigInteger22;");
		importSet.add("import java.util.Map;");
		
		for (String s: importSet) {
			importStr += s+LINE_SEPARATOR ;
		}
		
		System.out.println(importStr);
	}

}
