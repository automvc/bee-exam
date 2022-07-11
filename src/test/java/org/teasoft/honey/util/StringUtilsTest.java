/*
 * Copyright 2016-2022 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

import static org.teasoft.honey.util.StringUtils.*;

/**
 * @author Kingstar
 * @since  1.11
 */
public class StringUtilsTest {

	@Test
	public void test() {
		
		String s=null;
		Logger.info(StringUtils.isEmpty(s)+"");
		s="";
		Logger.info(StringUtils.isEmpty(s)+"");
		
		String strings[]=null;
		Logger.info(StringUtils.isEmpty(strings)+"");
		Logger.info(StringUtils.isNotEmpty(strings)+"");
		strings=new String[0];
//		String strings2[]={};
		Logger.info(StringUtils.isEmpty(strings)+"");
		Logger.info(StringUtils.isNotEmpty(strings)+"");
		
		String str = "aa";
		boolean f1 = StringUtils.isContainLetter(str);
		System.out.println(f1);
		
		str = "a2";
		f1 = StringUtils.isContainLetter(str);
		System.out.println(f1);
		
		str = "2a";
		f1 = StringUtils.isContainLetter(str);
		System.out.println(f1);

		str = "%";
		f1 = StringUtils.isContainLetter(str);
		System.out.println(f1);

		str = "34";
		f1 = StringUtils.isContainLetter(str);
		System.out.println(f1);
		
		
		System.out.println(isInteger(""));
		System.out.println(isNumber(""));
		System.out.println(isInteger(" 0"));
		System.out.println(isNumber(" 0"));
		
		System.out.println(isInteger("-"));
		System.out.println(isNumber("-"));
		
		System.out.println(isInteger("+"));
		System.out.println(isNumber("+"));
		
		System.out.println(isInteger("+0"));
		System.out.println(isNumber("+0"));
		
		System.out.println(isInteger("-0"));
		System.out.println(isNumber("-0"));
		
		
		System.out.println(isInteger("a123456789"));
		System.out.println(isNumber("a123456789"));
		
		Integer a[]= {1,2,3};
		toCommasString(a);
		
		String strArray[]= {"1","2","3"};
		toCommasString(strArray);
		
		
	}

}
