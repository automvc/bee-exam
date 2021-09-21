/*
 * Copyright 2016-2020 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.osql.util;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.teasoft.honey.osql.core.Logger;

/**
 * @author Kingstar
 * @since  1.9
 */
public class StringUtilTest {
	
	@Test
	public void test() {
		
		System.out.println("================StringUtilTest==========start====");
		
		Map<String, String> map = new HashMap<>(); 
		String newProjectName = "kvienglish";
		String beeVersion = "1.9-SNAPSHOT";
		map.put("projectName", newProjectName);
		map.put("BeeVersion", beeVersion);
		
		String text="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		text=StringUtil.replaceWithMap(text, map, "${{","}}");
		
		String text1="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		text1=StringUtil.replaceWithMap(text1, map, "${{","##");  //找不到结束标记,死循环.  已解决
		
		String text2="<bee.version>${{BeeVersion##</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		text2=StringUtil.replaceWithMap(text2, map, "${{", "##");  //找不到结束标记,死循环. 已解决
		
		String text3="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName##</bee.version>";
		text3=StringUtil.replaceWithMap(text3, map, "${{", "##");  //找不到结束标记,死循环.  已解决
		
		
		String text4="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName?up1}}</bee.version>";
		text4=StringUtil.replaceWithMap(text4, map, "${{","}}");
		Logger.info(text4);
		
		String text5="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>\\${{projectName}}</bee.version>";
		text5=StringUtil.replaceWithMap(text5, map, "${{","}}");
		Logger.info(text5);
		
		String text6="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		String text6_1=StringUtil.replaceWithMap(text6, null, "${{","}}");
		
		String text7="";
		String text7_1=StringUtil.replaceWithMap(text7, map, "${{","}}");
		
		String text8="no token";
		String text8_1=StringUtil.replaceWithMap(text8, map, "${{","}}");
		
		String result="<bee.version>1.9-SNAPSHOT</bee.version><beeaa.sversion>kvienglish</bee.version>";
		String result1="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		String result2="<bee.version>1.9-SNAPSHOT</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		String result3="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>kvienglish</bee.version>";
		String result4="<bee.version>1.9-SNAPSHOT</bee.version><beeaa.sversion>Kvienglish</bee.version>";
		String result5="<bee.version>1.9-SNAPSHOT</bee.version><beeaa.sversion>${{projectName}}</bee.version>";
		
		assertEquals(result,text);
		assertEquals(result1,text1);
		assertEquals(result2,text2);
		assertEquals(result3,text3);
		assertEquals(result4,text4);
		assertEquals(result5,text5);
		assertEquals(text6,text6_1);
		assertEquals(text7,text7_1);
		assertEquals(text8,text8_1);
		
		assertEquals("${\\}", StringUtil.replaceWithMap("${\\}",map,"${","}") );
		
		System.out.println("================StringUtilTest==========end====");
	}
}
