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
		
		
		String s1="%";
		String s2="%_";
		String s3="_%";
		String s4="_";
		
		String s5="";
		String s6="%a";
		String s7="\\%";
		String s8="%bee";
		
		String s9="\u0025"; //%
		String s10="\u005f"; //_
		
		
		String s11="\u0025\u0025"; //%%
		String s12="\\u0025\\u0025";
		
		
		System.out.println(justLikeChar(s1));
		System.out.println(justLikeChar(s2));
		System.out.println(justLikeChar(s3));
		System.out.println(justLikeChar(s4));
		System.out.println(justLikeChar(s5));
		System.out.println(justLikeChar(s6));
		System.out.println(justLikeChar(s7));
		System.out.println(justLikeChar(s8));
		
		System.out.println(justLikeChar(s9));
		System.out.println(justLikeChar(s10));
		System.out.println(justLikeChar(s11));
		System.out.println(justLikeChar(s12));
		
		
		System.out.println(escapeLike(s1));
		System.out.println(escapeLike(s2));
		System.out.println(escapeLike(s3));
		System.out.println(escapeLike(s4));
		System.out.println(escapeLike(s5));
		System.out.println(escapeLike(s6));
		System.out.println(escapeLike(s7));
		System.out.println(escapeLike(s8));
		
		System.out.println(escapeLike(s9));
		System.out.println(escapeLike(s10));
		System.out.println(escapeLike(s11));
		System.out.println(escapeLike(s12));
		
		System.out.println(getUnicode("若没有配置bee.dosql.multiDS.type,则根据具体情况确定数据源"));
		System.out.println(getUnicode("则根据具体情况确定数据源"));
		System.out.println(getUnicode("%"));
		System.out.println(getUnicode("_"));
		
		
	}

}
