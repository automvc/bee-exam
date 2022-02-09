/*
 * Copyright 2016-2021 the original author.All rights reserved.
 * Kingstar(honeysoft@126.com)
 * The license,see the LICENSE file.
 */

package org.teasoft.honey.util;

/**
 * @author Kingstar
 * @since  1.11
 */
public class TokenUtilTest {
	/*public static void main(String[] args) {
	//		String text="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName}}</bee.version>";  //two
	//		String text="<bee.version>${{BeeVersion##</bee.version><beeaa.sversion>${{projectName##</bee.version>";  //none
	//		String text="<bee.version>${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName##</bee.version>";  //right one
	//		String text="<bee.version>${{BeeVersion##</bee.version><beeaa.sversion>${{projectName}}</bee.version>"; //wrong one : BeeVersion##</bee.version><beeaa.sversion>${{projectName
		String text="<bee.version>\\${{BeeVersion}}</bee.version><beeaa.sversion>${{projectName##</bee.version>";  //escape
		//测试SqlValueWrap process是否会   找不到结束标记,死循环.
		SqlValueWrap warp =TokenUtil.process(text, "${{", "}}", "?");
		Logger.info(warp.getSql());
	//		Logger.info(warp.getTableNames());
		Logger.info(warp.getValueBuffer());
	}*/
}
